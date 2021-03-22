/*
* FindTheSums.java
* Author: Alexander Winkles
* Submission Date: April 26, 2017
*
* Purpose: A Java program designed to take in a 2D array and an
* integer, then find all of the array horizontals and verticles
* that sum to the given value. Returns an array with all the
* values that sum properly, and zeros for all other indeces.
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

public class FindTheSums {

    // method that takes in a 2D array and prints it nicely
    public static String arrayToString(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        String s = "";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n-1) s += a[i][j] + "\n";
                else s += a[i][j] + " ";
            }
        }
        return s;
    }

    // method that takes a 2D array and an integer then returns a
    // 2D array that replaces all points that don't sum to the integer
    // horizontally with 0
    public static int[][] horizontalSums(int[][] a, int sumToFind) {
        int m = a.length;
        int n = a[0].length;
        int sum, count;
        int[][] b = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = 0;
                count = 0;
                loop:
                for (int k = j; k < n; k++) {
                    sum += a[i][k];
                    count++;
                    if (sum == sumToFind) {
                        for (int l = j; l < j + count; l++) {
                            b[i][l] = a[i][l];
                        }
                        break loop;
                    }
                }
            }
        }
        return b;
    } 

    // method that takes a 2D array and an integer then returns a
    // 2D array that replaces all points that don't sum to the integer
    // vertically with 0
    public static int[][] verticalSums(int[][] a, int sumToFind) {
        int m = a.length;
        int n = a[0].length;
        int sum, count;
        int[][] b = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = 0;
                count = 0;
                loop:
                for (int k = i; k < m; k++) {
                    sum += a[k][j];
                    count++;
                    if (sum == sumToFind) {
                        for (int l = i; l < i + count; l++) {
                            b[l][j] = a[l][j];
                        }
                        break loop;
                    }
                }
            }
        }
        return b;
    } 
}
