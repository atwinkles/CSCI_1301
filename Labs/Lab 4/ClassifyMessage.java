/*
* ClassifyMessage.java
* Author: Alexander Winkles
* Submission Date: February 9, 2017
*
* Purpose: A Java application designed to take in a message from 
* the user and parse it into its type of alter, lat and long, and
* the message associated with it. Then it will print the results 
* nicely as well as check whether the issue is in the correct area.
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

public class ClassifyMessage {

    // an enumeration of the possible message types
    public enum MessageCategory {NEED, OFFER, ALERT, INFO, UNKNOWN}

    // constants for the where the latitude and longitude must be within
    public static final double SOUTH = 39.882343; 
    public static final double NORTH = 40.231315;
    public static final double WEST = -105.743511;
    public static final double EAST = -104.907864;

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a formatted message:");
        
        // reads in a message from the user and parses it by whitespace
        String catString = keyboard.next();
        double latitude = keyboard.nextDouble();
        double longitude = keyboard.nextDouble();
        String payload = keyboard.nextLine();
    
        // trims the message if needed
        payload = payload.trim();

        MessageCategory category = null;
        boolean isInRange;

        // checks what the type of message is
        if (catString.equalsIgnoreCase("fire") || catString.equalsIgnoreCase("smoke")) {
            category = MessageCategory.ALERT;
        }
        else if (catString.equalsIgnoreCase("need")) {
            category = MessageCategory.NEED;
        }
        else if (catString.equalsIgnoreCase("offer")) {
            category = MessageCategory.OFFER;
        }
        else if (catString.equalsIgnoreCase("structure") || catString.equalsIgnoreCase("road") || catString.equalsIgnoreCase("photo") || catString.equalsIgnoreCase("evac")) {
            category = MessageCategory.INFO;
        }
        else {
            category = MessageCategory.UNKNOWN;
        }
 
        // checks if the message is in the desired area
        if (latitude >= SOUTH && latitude <= NORTH && longitude >= WEST && longitude <= EAST) {
            isInRange = true;
        }
        else {
            isInRange = false;
        }

        // prints the results nicely
        System.out.println("Category:\t"+category);
        System.out.println("Raw Cat:\t"+catString);
        System.out.println("Message:\t"+payload);
        System.out.println("Latitude:\t"+latitude);
        System.out.println("Longitude:\t"+longitude);
        System.out.println("In Range:\t"+isInRange);

    }
}
