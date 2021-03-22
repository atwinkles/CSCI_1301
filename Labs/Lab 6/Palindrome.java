/*
* Palindrome.java
* Author: Alexander Winkles
* Submission Date: Feburary 23, 2017
*
* Purpose: A Java application designed to take a natural number and
* test whether it is a palindrome of not. If it is, it returns the
* sum of all numbers up to it. If not, it returns a message saying
* so.
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

public class Palindrome {
    public static void main(String[] args) {

        // creates an Scanner object
        Scanner keyboard = new Scanner(System.in);        

        // asks for an integer greater than 0
        System.out.print("Please enter an integer greater than zero: ");
        int original = keyboard.nextInt();

        // if integer given is not positive, gives error message and ends
        if (original <= 0) {
            System.out.println("Sorry, you must enter an integer greater than zero.");
            System.exit(0);
        }

        // creates a copy of original message
        int copy = original;
        int palindrome = 0;

        // creates the flipped number using modulus
        for (int size = (int)(Math.log10(original)); size > -1; size--) {
            palindrome += (copy%10*Math.pow(10,size));
            copy = (copy - copy%10)/10;
        }

        // checks if new value is a palindrome
        if (palindrome != original) {
            System.out.println("The integer " + original + " is not a palindrome.");
        }
        else {
            System.out.println("The integer " + original + " is a palindrome.");

            // sums values up to original
            int sum = 0;
            for (int i = 1; i <= original; i++) {
                sum += i;
            }
            System.out.println("The sum of the numbers from 1 to " + original + " is " + sum);
        } 

        keyboard.close();
    }
}
