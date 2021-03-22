/*
* ParseTheTweet.java
* Author: Alexander Winkles
* Submission Date: January 31, 2017
*
* Purpose: A Java application designed to take a ``tweet'' string
* input with certain hashtags and parse the data between them. The
* parsed strings will be printed nicely in a certain format.
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

// imports Scanner class to read in the tweets
import java.util.Scanner;

public class ParseTheTweet {
    public static void main(String[] args) {

        // declares Scanner object
        Scanner keyboard = new Scanner(System.in);

        // prints a statement asking for the tweet to be read
        System.out.println("Please print the tweet on the following line:");

        // reads in the next string
        String tweet = keyboard.nextLine();
        
        // parses ''tweet'' to a list of strings, delimited by the hashtags
        String[] parsedTweet = tweet.split("(#typ)|(#det)|(#loc)|(#lat)|(#lng)");

        // creates a new string list to be used below
        String[] formatTweet = new String[parsedTweet.length];

        // goes through each element of parsedTweet and uses the replace method
        for (int i = 0; i < parsedTweet.length; i++) 
            formatTweet[i] = parsedTweet[i].replace(',','-').replace(';',' ');

        // prints the newly formated string elements nicely
        System.out.println("Type:\t\t" + formatTweet[1].toUpperCase().trim());
        System.out.println("Detail:\t\t" + formatTweet[2].trim());
        System.out.println("Location:\t" + formatTweet[3].trim());
        System.out.println("Latitude:\t" + formatTweet[4].trim());
        System.out.println("Longitude:\t" + formatTweet[5].trim());
    }
}
