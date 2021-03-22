/*
* Stat.java
* Author: Alexander Winkles
* Submission Date: April 12, 2017
*
* Purpose: A Java class designed to take in a data set and utilize 
* various methods related to said data, such as finding the data
* average, min, max, and mode. Additionally, an equals method is
* implemented to compare two instances of the Stat class.
* 
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither 
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

public class Stat {

    // private instance variable of Stat to hold data
    private double[] data;

    // bare-minimum constructor with no inputs
    public Stat() {
        double[] data = {0.0};
        this.data = data;
    }

    // constructor with input of double[] d data points
    public Stat(double[] d) {
        int N = d.length;
        double[] data = new double[N];
        for (int i = 0; i < N; i++) {
            data[i] = d[i];
        }
        this.data = data;
    }

    // accessor for data
    public double[] getData() {
        int N = this.data.length;
        double[] data = new double[N];
        for (int i = 0; i < N; i++) {
            data[i] = this.data[i];
        }
        return data;
    }

    // mutator for data
    public void setData(double[] d) {
        int N = d.length;
        double[] data = new double[N];
        for (int i = 0; i < N; i++) {
            data[i] = d[i];
        }
        this.data = data;
    }

    // method that compares two Stat objects and returns a boolean if
    // their data is identical or not
    public boolean equals(Stat s) {
        if (this.data.length != s.getData().length) return false;
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] != s.getData()[i]) return false;
        }
        return true;
    }

    // method that converts the data into a nicely formatted string
    public String toString() {
        String data = "[";
        for (int i = 0; i < this.data.length; i++) {
            if (i == this.data.length - 1) data += this.data[i] + "]";
            else data += this.data[i] + ",";
        }
        return data;
    }

    // method that finds the minimum value in the data and returns it
    public double min() {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) min = data[i];
        }
        return min;
    }

    // method that finds the maximum value in the data and returns it
    public double max() {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) max = data[i];
        }
        return max;
    }

    // method that computes the average of the data and returns it
    public double average() {
        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum / data.length;
    }

    // method that computes the mode (most frequent) value of the
    // data and returns it. Returns NaN if no such value exists
    public double mode() {

        // creates a new array that stores how much each data point occurs
        // in the slot where it occurs
        int[] count = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[i] == data[j]) count[j]++;
            }
        }

        // goes through the above array and finds which index has the
        // max count value
        int maxIndex = 0;
        int maxValue = count[0];
        for (int i = 1; i < count.length; i++) {
            if (count[i] > maxValue) {
                maxIndex = i;
                maxValue = count[i];
            }
        }

        // checks if there are more than one max occurances with different
        // values and if so returns NaN
        for (int i = 0; i < data.length; i++) {
            if (count[i] == maxValue && data[i] != data[maxIndex]) return Double.NaN;
        }

        // if the above if statement is not run, returns the value of the
        // most frequent data point
        return data[maxIndex];
    }
    
}
