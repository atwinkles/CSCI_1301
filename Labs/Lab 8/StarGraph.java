/*
* StarGraph.java
* Author: Alexander Winkles
* Submission Date: March 16, 2017
*
* Purpose: A Java application designed to take an integer N, a 
* double xmin, and a double xstep from the user and calculates
* x and y based on the equations x_n = x_(n-1)+xstep and 
* y_n = 20.0*|sin(x_n)|. The results are printed in a simple 
* graph using astericks. 
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

import java.util.Scanner;
public class StarGraph {
    public static void main(String[] args) {

        // instance of the scanner class
        Scanner keyboard = new Scanner(System.in);

        // asks for the number of iterations
        System.out.print("Please enter the number of x values to process: ");
        int N = keyboard.nextInt();

        // checks that the iterations is a positive natural number
        if (N < 1) {
            System.out.println("The number of x values must be an integer greater than 0.");
            System.exit(0);
        }

        // asks for an xmin
        System.out.print("Enter a minimum value for x: ");
        double xmin = keyboard.nextDouble();

        // asks for an xstep
        System.out.print("Enter the amount to increment x: ");
        double xstep = keyboard.nextDouble();

        // checks that xstep is positive
        if (xstep <= 0) {
            System.out.println("The increment must be a decimal number greater than 0.");
            System.exit(0);
        }

        // creates two arrays to store the x and y values
        double[] x = new double[N];
        double[] y = new double[N];

        // prints results nicely
        System.out.println("\nValues");

        // generates new x and y values and prints them
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                x[i] = xmin;
            }
            else {
                x[i] = x[i-1] + xstep;
            }
            y[i] = 20.0*Math.abs(Math.sin(x[i]));
            System.out.printf("x: %.3f, y: %.3f\n", x[i],y[i]);
        }

        // generates the asterick graph
        System.out.println("\nGraph");
        for (int i = 0; i < N; i++) {
            System.out.print(":");
            for (int j = (int)(y[i]); j >= 0; j--) {
                if (j == 0) {
                    System.out.println();
                }
                else {
                    System.out.print("*");
                }
            }
        }

    }
}
