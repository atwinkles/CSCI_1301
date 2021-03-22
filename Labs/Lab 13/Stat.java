/*
* Stat.java
* Author: Alexander Winkles
* Submission Date: April 20, 2017
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
        double[] data = new double[0];
        this.data = data;
    }

    // constructors with various input values
    public Stat(double[] d) {
        if (d == null) {
            double[] data = new double[0];
            this.data = data;
            return;
        }
        int N = d.length;
        double[] data = new double[N];
        for (int i = 0; i < N; i++) {
            data[i] = d[i];
        }
        this.data = data;
    }

    public Stat(int[] i) {
        if (i == null) {
            double[] data = new double[0];
            this.data = data;
            return;
        }
        int N = i.length;
        double[] data = new double[N];
        for (int j = 0; j < N; j++) {
            data[j] = i[j];
        }
        this.data = data;
    }

    public Stat(long[] lo) {
        if (lo == null) {
            double[] data = new double[0];
            this.data = data;
            return;
        }
        int N = lo.length;
        double[] data = new double[N];
        for (int i = 0; i < N; i++) {
            data[i] = lo[i];
        }
        this.data = data;
    }

    public Stat(float[] f) {
        if (f == null) {
            double[] data = new double[0];
            this.data = data;
            return;
        }
        int N = f.length;
        double[] data = new double[N];
        for (int i = 0; i < N; i++) {
            data[i] = f[i];
        }
        this.data = data;
    }

    // mutator for data
    public void setData(double[] d) {
        if (d == null) {
            double[] data = new double[0];
            this.data = data;
            return;
        }
        int N = d.length;
        double[] data = new double[N];
        for (int i = 0; i < N; i++) {
            data[i] = d[i];
        }
        this.data = data;
    }

    public void setData(int[] i) {
        if (i == null) {
            double[] data = new double[0];
            this.data = data;
            return;
        }
        int N = i.length;
        double[] data = new double[N];
        for (int j = 0; j < N; j++) {
            data[j] = i[j];
        }
        this.data = data;
    }

    public void setData(long[] lo) {
        if (lo == null) {
            double[] data = new double[0];
            this.data = data;
            return;
        }
        int N = lo.length;
        double[] data = new double[N];
        for (int i = 0; i < N; i++) {
            data[i] = lo[i];
        }
        this.data = data;
    }

    public void setData(float[] f) {
        if (f == null) {
            double[] data = new double[0];
            this.data = data;
            return;
        }
        int N = f.length;
        double[] data = new double[N];
        for (int i = 0; i < N; i++) {
            data[i] = f[i];
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

    // method that compares two Stat objects and returns a boolean if
    // their data is identical or not
    public boolean equals(Stat s) {
        if (this.data.length != s.getData().length) return false;
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] != s.getData()[i]) return false;
        }
        return true;
    }

    // method that resets the data variable with an empty double array
    public void reset() {
        double[] data = new double[0];
        this.data = data;
    }

    // method appends an array to the already existent array
    public void append(double[] d) {
        if (d == null) {
            return;
        }
        double[] data = new double[this.data.length + d.length];
        for (int i = 0; i < this.data.length; i++) {
            data[i] = this.data[i];
        }
        for (int i = this.data.length; i < data.length; i++) {
            data[i] = d[i - this.data.length];
        }
        this.data = data;
    }

    public void append(int[] i) {
        if (i == null) {
            return;
        }
        double[] data = new double[this.data.length + i.length];
        for (int j = 0; j < this.data.length; j++) {
            data[j] = this.data[j];
        }
        for (int j = this.data.length; j < data.length; j++) {
            data[j] = i[j - this.data.length];
        }
        this.data = data;
    }

    public void append(long[] l) {
        if (l == null) {
            return;
        }
        double[] data = new double[this.data.length + l.length];
        for (int i = 0; i < this.data.length; i++) {
            data[i] = this.data[i];
        }
        for (int i = this.data.length; i < data.length; i++) {
            data[i] = l[i - this.data.length];
        }
        this.data = data;
    }

    public void append(float[] f) {
        if (f == null) {
            return;
        }
        double[] data = new double[this.data.length + f.length];
        for (int i = 0; i < this.data.length; i++) {
            data[i] = this.data[i];
        }
        for (int i = this.data.length; i < data.length; i++) {
            data[i] = f[i - this.data.length];
        }
        this.data = data;
    }

    // method that checks if a data array is empty and returns a boolean
    public boolean isEmpty() {
        if (this.data.length == 0) return true;
        else return false;
    }

    // method that converts the data into a nicely formatted string
    public String toString() {
        String data = "[";
        if (isEmpty()) {
            data += "]";
            return data;
        }
        for (int i = 0; i < this.data.length; i++) {
            if (i == this.data.length - 1) data += this.data[i] + "]";
            else data += this.data[i] + ",";
        }
        return data;
    }

    // method that finds the minimum value in the data and returns it
    public double min() {
        if (isEmpty()) return Double.NaN;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) min = data[i];
        }
        return min;
    }

    // method that finds the maximum value in the data and returns it
    public double max() {
        if (isEmpty()) return Double.NaN;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) max = data[i];
        }
        return max;
    }

    // method that computes the average of the data and returns it
    public double average() {
        if (isEmpty()) return Double.NaN;
        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum / data.length;
    }

    // method that computes the mode (most frequent) value of the
    // data and returns it. Returns NaN if no such value exists
    public double mode() {

        if (isEmpty()) return Double.NaN;

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

    public double variance() {
        if (isEmpty()) return Double.NaN;
        double mean = average();
        double sum = 0;
        for (double d : data) {
            sum += (d-mean)*(d-mean);
        }
        return (sum / this.data.length);
    }
    public double standardDeviation() { 
        if (isEmpty()) return Double.NaN;
        return Math.sqrt(variance());
    }
}
