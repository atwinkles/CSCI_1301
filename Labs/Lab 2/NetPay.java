/*
* NetPay.java
* Author: Alexander Winkles
* Submission Date: January 24, 2017
*
* Purpose: A Java application designed to take an input from users of
* how many hours they work in a week and return their gross pay, 
* net pay, and all the deductions that were taken out of their pay.
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

public class NetPay {

    // declaring constants to be used
    public static final double FEDERAL_TAX_PERCENT = 10.00;
    public static final double STATE_TAX_PERCENT = 4.5;
    public static final double SS_PERCENT = 6.2;
    public static final double MEDICARE_PERCENT = 1.45;
    public static final double PAY_PER_HOUR = 7.25;

    public static void main(String[] args){

        // initilizes Scanner
        Scanner keyboard = new Scanner(System.in);
    
        // asks for user input for how many hours they work
        System.out.print("\nHours per Week:\t\t");
        double hoursPerWeek = keyboard.nextDouble();
        
        // computes gross pay
        double grossPay = hoursPerWeek*PAY_PER_HOUR;

        // computes the various deductions from gross pay
        double fedTax = FEDERAL_TAX_PERCENT/100.00*grossPay;
        double stateTax = STATE_TAX_PERCENT/100.00*grossPay;
        double ss = SS_PERCENT/100.00*grossPay;
        double medicare = MEDICARE_PERCENT/100.00*grossPay;

        // computes the net pay
        double netPay = grossPay - (fedTax + stateTax + ss + medicare);

        // prints results in a nice way
        System.out.println("Gross Pay:\t\t" + grossPay);
        System.out.println("Net Pay:\t\t" + netPay);
        System.out.println("\nDeductions");
        System.out.println("Federal:\t\t"+fedTax);
        System.out.println("State:\t\t\t"+stateTax);
        System.out.println("Social Security:\t"+ss);
        System.out.println("Medicare:\t\t"+medicare+"\n");
    }
} 
