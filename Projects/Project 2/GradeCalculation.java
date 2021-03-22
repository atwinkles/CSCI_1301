/*
* GradeCalculation.java
* Author: Alexander Winkles
* Submission Date: Feburary 9, 2017
*
* Purpose: A Java application designed to read in the grade weights
* for a class and user's known scores for grades, then compute
* their current average as well as tell them if they can achieve
* their desired grade.
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

public class GradeCalculation {

    public static void main(String[] args) {

        // rather than declaring a host of variables, an array is used to store
        // weights and known scores
        double[][] weightsAndGrades = new double[2][7];
        double currentGrade = 0;
        double knownWeight = 0;
        char currentLetterGrade, letterGrade;
        double finalOverallScore;

        // prints out the grading scale of the course
        System.out.println("Grading Scale");
        System.out.println("A\t90 - 100");
        System.out.println("B\t80 - 89");
        System.out.println("C\t70 - 79");
        System.out.println("D\t60 - 69");
        System.out.println("F\tbelow 60");
        System.out.print("What letter grade do you want to achieve for the course? ");

        // creates a new scanner object
        Scanner keyboard = new Scanner(System.in);

        // reads in the letter grade desired
        letterGrade = keyboard.findInLine(".").charAt(0);
        
        // checks that the entered grade is valid
        if (letterGrade != 'A' && letterGrade != 'B' && letterGrade != 'C' && letterGrade != 'D' && letterGrade != 'F') {
            System.out.println("InputError");
        }
        else {

            // uses scanner object to read in the grade weights
            System.out.println("Enter Percentage Weights:");
            System.out.print("Exam 1:\t\t");
            weightsAndGrades[0][0] = keyboard.nextDouble();
            System.out.print("Exam 2:\t\t");
            weightsAndGrades[0][1] = keyboard.nextDouble();
            System.out.print("Final Exam:\t");
            weightsAndGrades[0][2]= keyboard.nextDouble();
            System.out.print("Labs:\t\t");
            weightsAndGrades[0][3]= keyboard.nextDouble();
            System.out.print("Projects:\t");
            weightsAndGrades[0][4]= keyboard.nextDouble();
            System.out.print("Attendance:\t");
            weightsAndGrades[0][5]= keyboard.nextDouble();
            System.out.print("Quizzes:\t");
            weightsAndGrades[0][6]= keyboard.nextDouble();

            // if the weights don't add to 100, returns an error message
            if ((weightsAndGrades[0][0] + weightsAndGrades[0][1] + weightsAndGrades[0][2] + weightsAndGrades[0][3] + weightsAndGrades[0][4] + weightsAndGrades[0][5] + weightsAndGrades[0][6]) != 100) {
                System.out.println("\nWeights don't add up to 100, program exiting...");
            }
            else {

                // uses scanner object to ask if grades are known and their values
                System.out.println("Enter your scores out of a 100:");
                System.out.print("Do you know your Exam 1 score? ");
                String hasExamOne = keyboard.next();
                if (hasExamOne.equalsIgnoreCase("yes") || hasExamOne.equalsIgnoreCase("y")){
                    System.out.print("Score received on Exam 1: ");
                    weightsAndGrades[1][0]= keyboard.nextDouble();
                    System.out.print("Do you know your Exam 2 score? ");
                    String hasExamTwo = keyboard.next();
                    if (hasExamTwo.equalsIgnoreCase("yes") || hasExamTwo.equalsIgnoreCase("y")){
                        System.out.print("Score received on Exam 2: ");
                        weightsAndGrades[1][1]= keyboard.nextDouble();
                        System.out.print("Do you know your Final Exam score? ");
                        String hasFinal = keyboard.next();
                        if (hasFinal.equalsIgnoreCase("yes") || hasFinal.equalsIgnoreCase("y")){
                            System.out.print("Score received on Final Exam: ");
                            weightsAndGrades[1][2]= keyboard.nextDouble();
                        }
                        else {
                            weightsAndGrades[0][2]= 0;
                        }
                    }
                    else {
                        weightsAndGrades[0][1]= 0;
                        weightsAndGrades[0][2]= 0;
                    }
                }
                else {
                    weightsAndGrades[0][0]= 0;
                    weightsAndGrades[0][1]= 0;
                    weightsAndGrades[0][2]= 0;
                }
                System.out.print("Do you know your lab average? ");
                String hasLabs = keyboard.next();
                if (hasLabs.equalsIgnoreCase("yes") || hasLabs.equalsIgnoreCase("y")){
                    System.out.print("Average Lab grade: ");
                    weightsAndGrades[1][3]= keyboard.nextDouble();
                }
                else {
                    weightsAndGrades[0][3]= 0;
                }
                System.out.print("Do you know your project average? ");
                String hasProjects = keyboard.next();
                if (hasProjects.equalsIgnoreCase("yes") || hasProjects.equalsIgnoreCase("y")){
                    System.out.print("Average Project grade: ");
                    weightsAndGrades[1][4]= keyboard.nextDouble();
                }
                else {
                    weightsAndGrades[0][4]= 0;
                }
                System.out.print("Do you know your quiz average? ");
                String hasQuizzes = keyboard.next();
                if (hasQuizzes.equalsIgnoreCase("yes") || hasQuizzes.equalsIgnoreCase("y")){
                    System.out.print("Average Quiz grade: ");
                    weightsAndGrades[1][6]= keyboard.nextDouble();
                }
                else {
                    weightsAndGrades[0][6]= 0;
                }
                System.out.print("Do you know your attendance average? ");
                String hasAttendance = keyboard.next();
                if (hasAttendance.equalsIgnoreCase("yes") || hasAttendance.equalsIgnoreCase("y")){
                    System.out.print("Average Attendance Grade: ");
                    weightsAndGrades[1][5]= keyboard.nextDouble();
                }
                else {
                    weightsAndGrades[0][5]= 0;
                }

                // calculates the current numerical grade                
                for (int i = 0; i < 7; i++) {
                    currentGrade += weightsAndGrades[0][i]*weightsAndGrades[1][i];                
                    knownWeight += weightsAndGrades[0][i];
                }
                currentGrade /= knownWeight;

                System.out.printf("Current Grade Score: %.2f\n",currentGrade);

                // finds the letter equivalent of the current grade
                if (currentGrade >= 90) {
                    currentLetterGrade = 'A';
                }
                else if (currentGrade >= 80) {
                    currentLetterGrade = 'B';
                }
                else if (currentGrade >= 70) {
                    currentLetterGrade = 'C';
                }
                else if (currentGrade >= 60) {
                    currentLetterGrade = 'D';
                }
                else {
                    currentLetterGrade = 'F';
                }
                System.out.println("Your current letter grade is a " + currentLetterGrade);

                // finds the minimum value of the desired final grade
                switch (letterGrade) {
                    case 'A': finalOverallScore = 90.0;
                            break;
                    case 'B': finalOverallScore = 80.0;
                            break;
                    case 'C': finalOverallScore = 70.0;
                            break;
                    case 'D': finalOverallScore = 60.0;
                            break;
                    default: finalOverallScore = 0;
                            break;
                }

                if (100 - knownWeight > 0) {
                    if (currentGrade <= finalOverallScore) {

                        // calculates the average necessary to obtain desired final grade
                        double avgToFinalLetterGrade = (100 * finalOverallScore - currentGrade*knownWeight)/(100 - knownWeight);
                        if (avgToFinalLetterGrade <= 100.0) {
                            System.out.printf("You have to score an average greater than or equal to %.2f \nin the remaining grade items to receive an " + letterGrade + " in the course\n", avgToFinalLetterGrade);
                        }
                        else {
                            System.out.println("Sorry, you cannot receive an " + letterGrade + " in the course");
                        }
                    }
                    else {
                        // if user has the desired grade currently, prints motivation
                        System.out.println("You have an " + letterGrade + " in the course so far. Keep up the good work!");
                    }
                }
                else {
                    
                    // checks if the user achieved their final grade or not
                    if (currentLetterGrade < letterGrade) {
                        System.out.println("Congratulations! Your grade is an " + currentLetterGrade + " and is higher than what you desired!");
                    }
                    else if (currentLetterGrade == letterGrade) {
                        System.out.println("Congratulations! You received the " + letterGrade + " that you wanted!");
                    }
                    else {
                        System.out.println("Sorry, you did not receive an " + letterGrade + " in the course");
                    }
                }
                
            }
        }
    }
}
