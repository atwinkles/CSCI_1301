/*
* CreditCardPayOff.java
* Author: Alexander Winkles
* Submission Date: January 19, 2017
*
* Purpose: A Java application designed to compute and display the number
* of months required to pay off a credit card.
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

public class CreditCardPayOff {
    
    public static void main(String[] args) {
        
        double principal, monthlyPayment, annualInterestRate, monthsNeededExact, monthsNeededCeiling;

        // Calls Scanner to take keyboard inputs

        Scanner keyboard = new Scanner(System.in);
    
        // Obtains principal, annualInterestRate, and monthlyPayment from user

        System.out.print("\nPrincipal:\t\t\t");
        principal = keyboard.nextDouble();
        System.out.print("Annual Interest Rate (%):\t");
        annualInterestRate = keyboard.nextDouble();
        System.out.print("Monthly Payment:\t\t");
        monthlyPayment = keyboard.nextDouble();

        // Computes monthsNeededExact from the given algorithm then computes monthsNeededCeiling by using Math.ceil on monthsNeededExact

        monthsNeededExact = (Math.log(monthlyPayment) - Math.log(monthlyPayment - (annualInterestRate / 1200.0)*principal)) / (Math.log(annualInterestRate / 1200.0 + 1.0));
        monthsNeededCeiling = Math.ceil(monthsNeededExact);

        // Prints the months needed, total amount paid, total interest paid, and overpayment nicely

        System.out.printf("\nMonths Needed to Pay Off:\t%.0f\n",monthsNeededCeiling);
        System.out.printf("Total Amount Paid:\t\t$%.2f\n", monthsNeededCeiling*monthlyPayment);
        System.out.printf("Total Interst Paid:\t\t$%.2f\n",monthsNeededCeiling*monthlyPayment - principal);
        System.out.printf("Overpayment:\t\t\t$%.2f\n\n",monthsNeededCeiling*monthlyPayment - monthsNeededExact*monthlyPayment);

    }
}
    
