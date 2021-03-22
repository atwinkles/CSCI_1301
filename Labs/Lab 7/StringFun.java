/*
* StringFun.java
* Author: Alexander Winkles
* Submission Date: Feburary 28, 2017
*
* Purpose: A Java application designed to take a string from the
* user as well as a command. If the command is a valid input, 
* the program will alter the string in some way, until the
* user chooses to quit.
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

public class StringFun {
    public static void main(String[] args) {
    
        // creating a new scanner object
        Scanner keyboard = new Scanner(System.in);

        // a boolean variable that is true until the user wishes to quit
        boolean check = true;
        
        // asks for the intial string
        System.out.println("Enter the string to be manipulated");  
        String input = keyboard.nextLine();

        // while check is true, the user can keep altering the string
        while (check) {

            // asks for the command
            System.out.println("Enter your command (quit, print reverse, replace all, replace single, remove)");
            String command = keyboard.nextLine();

            // if the command is invalid, an error is returned
            if (!command.equalsIgnoreCase("quit") && !command.equalsIgnoreCase("print reverse") && !command.equalsIgnoreCase("replace all") && !command.equalsIgnoreCase("replace single") && !command.equalsIgnoreCase("remove")) {
                System.out.println("Error: That is not a command.");
            }
            else {

                // ends the program
                if (command.equalsIgnoreCase("quit")) {
                    check = false;
                }
                else {

                    // calls the preverse method, defined below
                    if (command.equalsIgnoreCase("print reverse")) {
                        System.out.println(preverse(input));
                    }
        
                    // calls the repall method
                    else if (command.equalsIgnoreCase("replace all")) {
                        System.out.println("Enter the character to replace");
                        String blank = keyboard.nextLine();
                        char oldChar = blank.charAt(0);
            
                        // checks if the char input is valid
                        int count = 0;
                        for (int i = 0; i < input.length(); i++) {
                            if (input.charAt(i) == oldChar) {
                                count += 1;
                            }
                        }
                        if (count > 0) {
                            System.out.println("Enter the new character");
                            blank = keyboard.nextLine();
                            char newChar = blank.charAt(0);
                            input = repall(input, oldChar, newChar);
                            System.out.println("The new string is: " + input);
                        }
                        else {
                            System.out.println("Error: The letter you are trying to replace does not exist");
                        }
                    }

                    // calls the repsing method
                    else if (command.equalsIgnoreCase("replace single")) {
                        System.out.println("Enter the character to replace");
                        String blank = keyboard.nextLine();
                        char oldChar = blank.charAt(0);

                        // checks if the char input is valid
                        int count = 0;
                        for (int i = 0; i < input.length(); i++) {
                            if (input.charAt(i) == oldChar) {
                                count += 1;
                            }
                        }
                        if (count > 0) {
                            System.out.println("Enter the new character");
                            blank = keyboard.nextLine();
                            char newChar = blank.charAt(0);
                            System.out.println("Which " + oldChar + " would you like to replace?");
                            int charPos = keyboard.nextInt();
                            String trash = keyboard.nextLine();
                            if (charPos > count || charPos < 0) {
                                System.out.println("Error: The letter you are trying to replace does not exist");
                            }
                            else {  
                                input = repsing(input, oldChar, newChar, charPos);
                                System.out.println("The new string is: " + input);
                            }
                        }
                        else {
                            System.out.println("Error: The letter you are trying to replace does not exist");
                        }
                    }

                    // calls the remov method
                    else {
                        System.out.println("Enter the character to remove");
                        String blank = keyboard.nextLine();
                        char oldChar = blank.charAt(0);
                        input = remov(input, oldChar);
                        System.out.println("The new string is: " + input);
                    }
                }

            }

        }
    }

    // method to reverse strings
    public static String preverse(String message) {
        int N = message.length();
        String newMessage = "";
        for (int i = N-1; i >= 0; i--) {
            newMessage += message.charAt(i);
        }
        return newMessage;
    }

    // method to replace all instances of a char
    public static String repall(String message, char oldChar, char newChar) {
        int N = message.length();
        String newMessage = "";
        for (int i = 0; i < N; i++) {
            if (message.charAt(i) == oldChar) {
                newMessage += newChar;
            }
            else {
                newMessage += message.charAt(i);
            }
        }
        return newMessage;
    }
    
    // method to replace a single instance of a char
    public static String repsing(String message, char oldChar, char newChar, int charPos) {
        int N = message.length();
        String newMessage = "";
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (message.charAt(i) == oldChar) {
                count++;
                if (charPos == count) {
                    newMessage += newChar;
                }
                else {
                    newMessage += message.charAt(i);    
                }
            }
            else {
                newMessage += message.charAt(i);
            }
        }
        return newMessage;
    }

    // method to remove all instances of a char
    public static String remov(String message, char removChar) {
        int N = message.length();
        String newMessage = "";
        for (int i = 0; i < N; i++) {
            if (message.charAt(i) == removChar) {
                continue;
            }
            else {
                newMessage += message.charAt(i);
            }
        }
        return newMessage;
    } 
}
