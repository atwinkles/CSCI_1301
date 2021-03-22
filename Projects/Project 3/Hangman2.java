/*
* Hangman2.java
* Author: Alexander Winkles
* Submission Date: March 16, 2017
*
* Purpose: A Java application designed to play an altered game 
* of hangman with the caveat of having to chose what positions
* the user needs to guess for each letter.
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

public class Hangman2 extends RandomWord {

    // constant for testing purposes
    private static final boolean testingMode = true;

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String trash; // string variable used to remove and escape characters that might cause issues
        char guessOneChar,guessTwoChar,guessThreeChar,guessFourChar;
        int guesses, spaces, guessOne, guessTwo, guessThree, guessFour;
        int games = 20;

        // counts the number of games possible to play
        while (games > 0) {

            // asks user for difficulty
            System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
            String difficulty = keyboard.nextLine();

            // if the user responds improperly, gives error and asks again
            while ((difficulty.charAt(0) != 'e') && (difficulty.charAt(0) != 'i') && (difficulty.charAt(0) != 'h')) {
                System.out.println("Invalid difficulty. Try again...");
                System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
                difficulty = keyboard.nextLine();
            }

            // picks a secret word for the game
            String secretWord = RandomWord.newWord();
         
            // prints the secret word if testingMode == true
            if (testingMode == true) {
                System.out.println("The secret word is: " + secretWord);
            }

            // assigns the number of guesses and spaces based on difficulty
            if (difficulty.charAt(0) == 'e') { 
                guesses = 15;
                spaces = 4;
            }
            else if (difficulty.charAt(0) == 'i') {
                guesses = 12;
                spaces = 3;
            }
            else {
                guesses = 10;
                spaces = 2;
            }

            // creates initial word with hyphens
            String word = "";
            for (int i = 0; i < secretWord.length(); i++) {
                word += "-";
            }

            System.out.println("The word is: " + word);

            // begins the game
            while (guesses > 0) {
                System.out.print("Please enter the letter you want to guess: ");
                String initialGuess = keyboard.nextLine();
                char guess = initialGuess.charAt(0);
                while(!(Character.isLetter(guess))) {
                    System.out.println("Your input is not valid. Try again.");
                    System.out.println("Guesses Remaining: " + guesses); 
                    System.out.print("Please enter the letter you want to guess: ");
                    initialGuess = keyboard.nextLine();
                    guess = initialGuess.charAt(0);
                }

                // if they don't want to solve, they are asked for what spaces to check
                if (!initialGuess.equalsIgnoreCase("solve")) {
                    System.out.println("Please enter the spaces you want to check (separated by spaces):");

                    // easy mode
                    if (spaces == 4) {

                        // takes the next chars seperated by space
                        guessOneChar = keyboard.next().charAt(0);
                        guessTwoChar = keyboard.next().charAt(0);
                        guessThreeChar = keyboard.next().charAt(0);
                        guessFourChar = keyboard.next().charAt(0);
                        trash = keyboard.nextLine(); // removes \n found after ints

                        // converts characters to numbers
                        guessOne = Character.getNumericValue(guessOneChar);
                        guessTwo = Character.getNumericValue(guessTwoChar);
                        guessThree = Character.getNumericValue(guessThreeChar);
                        guessFour = Character.getNumericValue(guessFourChar);

                        // loops until all input values are the appropriate type and range
                        while ((guessOne >= secretWord.length() || guessTwo >= secretWord.length() || guessThree >= secretWord.length() || guessFour >= secretWord.length() || guessOne < 0 || guessTwo < 0 || guessThree < 0 || guessFour < 0) || (!Character.isDigit(guessOneChar) || !Character.isDigit(guessTwoChar) || !Character.isDigit(guessThreeChar) || !Character.isDigit(guessFourChar))) {
                            System.out.println("Your input is not valid. Try again.");
                            System.out.println("Guesses Remaining: " + guesses); 
                            System.out.print("Please enter the letter you want to guess: ");
                            initialGuess = keyboard.nextLine();
                            guess = initialGuess.charAt(0);

                            // loops until the letter guess is a letter
                            while (!Character.isLetter(guess)) {
                                System.out.println("Your input is not valid. Try again.");
                                System.out.println("Guesses Remaining: " + guesses); 
                                System.out.print("Please enter the letter you want to guess: ");
                                initialGuess = keyboard.nextLine();
                                guess = initialGuess.charAt(0);
                            }

                            System.out.println("Please enter the spaces you want to check (separated by spaces):");

                            guessOneChar = keyboard.next().charAt(0);
                            guessTwoChar = keyboard.next().charAt(0);
                            guessThreeChar = keyboard.next().charAt(0);
                            guessFourChar = keyboard.next().charAt(0);
                            trash = keyboard.nextLine(); // removes \n found after ints

                            guessOne = Character.getNumericValue(guessOneChar);
                            guessTwo = Character.getNumericValue(guessTwoChar);
                            guessThree = Character.getNumericValue(guessThreeChar);
                            guessFour = Character.getNumericValue(guessFourChar);

                        }

                        // temporary variable for constructing updated word
                        String newWord = "";

                        // goes through secretWord and checks whether letters and positions match
                        for (int i = 0; i < secretWord.length(); i++) {
                            if ((i == guessOne || i == guessTwo || i == guessThree || i == guessFour) && (Character.toLowerCase(secretWord.charAt(i)) == Character.toLowerCase(guess))) {
                                newWord += secretWord.charAt(i);
                            } 
                            else if (word.charAt(i) != '-') {
                                newWord += word.charAt(i);
                            }
                            else {
                                newWord += "-";
                            }
                        }

                        int count = 0;

                        // counts the number of no matches. if it equals the length of the secret word, takes off a guess
                        for (int i = 0; i < secretWord.length(); i++) {
                            if ((i != guessOne && i != guessTwo && i != guessThree && i != guessFour) || (Character.toLowerCase(secretWord.charAt(i)) != Character.toLowerCase(guess))) {
                                count += 1;
                            } 
                        }
                        if (count == secretWord.length()) {
                            guesses -= 1;
                            System.out.println("Your letter was not found in the spaces you provided.");
                        }
                        else {
                            System.out.println("Your guess is in the word!");
                        }

                        word = newWord;

                        System.out.println("The updated word is: " + word);
                        System.out.println("Guesses Remaining: " + guesses);

                    }

                    // intermediate mode
                    else if (spaces == 3) {

                        // takes characters and turns them into integers
                        guessOneChar = keyboard.next().charAt(0);
                        guessTwoChar = keyboard.next().charAt(0);
                        guessThreeChar = keyboard.next().charAt(0);
                        trash = keyboard.nextLine(); // removes \n found after ints

                        guessOne = Character.getNumericValue(guessOneChar);
                        guessTwo = Character.getNumericValue(guessTwoChar);
                        guessThree = Character.getNumericValue(guessThreeChar);

                        // loops until guess numbers are the appropriate type and range
                        while ((guessOne >= secretWord.length() || guessTwo >= secretWord.length() || guessThree >= secretWord.length() || guessOne < 0 || guessTwo < 0 || guessThree < 0)) {
                            System.out.println("Your input is not valid. Try again.");
                            System.out.println("Guesses Remaining: " + guesses); 
                            System.out.print("Please enter the letter you want to guess: ");
                            initialGuess = keyboard.nextLine();
                            guess = initialGuess.charAt(0);
    
                            // loops until guess letter is appropriate type
                            while (!Character.isLetter(guess)) {
                                System.out.println("Your input is not valid. Try again.");
                                System.out.println("Guesses Remaining: " + guesses); 
                                System.out.print("Please enter the letter you want to guess: ");
                                initialGuess = keyboard.nextLine();
                                guess = initialGuess.charAt(0);
                            }

                            System.out.println("Please enter the spaces you want to check (separated by spaces):");

                            guessOneChar = keyboard.next().charAt(0);
                            guessTwoChar = keyboard.next().charAt(0);
                            guessThreeChar = keyboard.next().charAt(0);
                            trash = keyboard.nextLine(); // removes \n found after ints

                            guessOne = Character.getNumericValue(guessOneChar);
                            guessTwo = Character.getNumericValue(guessTwoChar);
                            guessThree = Character.getNumericValue(guessThreeChar);
                        }

                        // temporary variable for constructing updated word
                        String newWord = "";

                        // goes through secretWord and checks whether letters and positions match
                        for (int i = 0; i < secretWord.length(); i++) {
                            if ((i == guessOne || i == guessTwo || i == guessThree) && (Character.toLowerCase(secretWord.charAt(i)) == Character.toLowerCase(guess))) {
                                newWord += secretWord.charAt(i);
                            } 
                            else if (word.charAt(i) != '-') {
                                newWord += word.charAt(i);
                            }
                            else {
                                newWord += "-";
                            }
                        }

                        int count = 0;

                        // counts the number of no matches. if it equals the length of the secret word, takes off a guess
                        for (int i = 0; i < secretWord.length(); i++) {
                            if ((i != guessOne && i != guessTwo && i != guessThree) || (Character.toLowerCase(secretWord.charAt(i)) != Character.toLowerCase(guess))) {
                                count += 1;
                            } 
                        }
                        if (count == secretWord.length()) {
                            guesses -= 1;
                            System.out.println("Your letter was not found in the spaces you provided.");
                        }
                        else {
                            System.out.println("Your guess is in the word!");
                        }

                        word = newWord;

                        System.out.println("The updated word is: " + word);
                        System.out.println("Guesses Remaining: " + guesses);
                    }

                    // hard mode
                    else {

                        // takes in charaters and turns them into integers
                        guessOneChar = keyboard.next().charAt(0);
                        guessTwoChar = keyboard.next().charAt(0);
                        trash = keyboard.nextLine(); // removes \n found after ints

                        guessOne = Character.getNumericValue(guessOneChar);
                        guessTwo = Character.getNumericValue(guessTwoChar);

                        // loops until number guesses are appropriate type and range
                        while ((guessOne >= secretWord.length() || guessTwo >= secretWord.length() || guessOne < 0 || guessTwo < 0)) {
                            System.out.println("Your input is not valid. Try again.");
                            System.out.println("Guesses Remaining: " + guesses); 
                            System.out.print("Please enter the letter you want to guess: ");
                            initialGuess = keyboard.nextLine();
                            guess = initialGuess.charAt(0);

                            // loops until guess letter is appropriate type
                            while (!Character.isLetter(guess)) {
                                System.out.println("Your input is not valid. Try again.");
                                System.out.println("Guesses Remaining: " + guesses); 
                                System.out.print("Please enter the letter you want to guess: ");
                                initialGuess = keyboard.nextLine();
                                guess = initialGuess.charAt(0);
                            }

                            System.out.println("Please enter the spaces you want to check (separated by spaces):");

                            guessOneChar = keyboard.next().charAt(0);
                            guessTwoChar = keyboard.next().charAt(0);
                            trash = keyboard.nextLine(); // removes \n found after ints

                            guessOne = Character.getNumericValue(guessOneChar);
                            guessTwo = Character.getNumericValue(guessTwoChar);
                        }

                        // temporary variable for constructing updated word
                        String newWord = "";

                        // goes through secretWord and checks whether letters and positions match
                        for (int i = 0; i < secretWord.length(); i++) {
                            if ((i == guessOne || i == guessTwo)  && (Character.toLowerCase(secretWord.charAt(i)) == Character.toLowerCase(guess))) {
                                newWord += secretWord.charAt(i);
                            } 
                            else if (word.charAt(i) != '-') {
                                newWord += word.charAt(i);
                            }
                            else {
                                newWord += "-";
                            }
                        }

                        int count = 0;

                        // counts the number of no matches. if it equals the length of the secret word, takes off a guess
                        for (int i = 0; i < secretWord.length(); i++) {
                            if ((i != guessOne && i != guessTwo) || (Character.toLowerCase(secretWord.charAt(i)) != Character.toLowerCase(guess))) {
                                count += 1;
                            } 
                        }
                        if (count == secretWord.length()) {
                            guesses -= 1;
                            System.out.println("Your letter was not found in the spaces you provided.");
                        }
                        else {
                            System.out.println("Your guess is in the word!");
                        }

                        word = newWord;

                        System.out.println("The updated word is: " + word);
                        System.out.println("Guesses Remaining: " + guesses);
                    }

                    // win conditions
                    if (word.equalsIgnoreCase(secretWord)) {
                        System.out.println("You have guessed the word! Congratulations");
                        break;
                    }

                }
        
                // if user attempts to solve the word
                else {
                    System.out.print("Please solve the answer: ");
                    String fullGuess = keyboard.nextLine();
                    if (fullGuess.equalsIgnoreCase(secretWord)) {
                        System.out.println("You win!");
                        System.out.println("You have guessed the word! Congratulations");
                        break;
                    }
                    else {
                        System.out.println("That is not the secret word.");
                        guesses -= 1;
                        System.out.println("Guesses Remaining: " + guesses);
                    }
                }
                
                    
            }

            // if user runs out of guesses, prints sadness
            if (guesses == 0) {
                System.out.println("You have failed to guess the word... :(");
            }

            // after the game is complete, asks if the user would like to play again
            System.out.println("Would you like to play again? Yes(y) or No(n)");
            String response = keyboard.nextLine();
            if (response.equalsIgnoreCase("y")) {
                continue;
            }
            else {
                System.exit(0);
            }
            games--;

        }
    }
}
