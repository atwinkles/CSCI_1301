/*
* Bagel.java
* Author: Alexander Winkles
* Submission Date: April 6, 2017
*
* Purpose: A Java application designed to play a game of 
* "Pico, Fermi, Bagel", a guessing game using the Player, 
* Engine, and Validator classes. 
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
public class Bagel {

    // main method of bagel game
    public static void main(String[] args) {

    // creates instances of classes necessary
    Scanner keyboard = new Scanner(System.in);
    Validator check = new Validator(); // checks win conditions
    Player player = new Player(); // player class for stats and asking for guesses
    Engine currentGame = new Engine(); // game engine, processes guesses and passes to validator

    // post game question result, for whether another game is play or not
    // initially 'r' to start game
    char game = 'r';

    // game begins
    System.out.println("Welcome!");
    
    // while the player does not wish to quit, the game runs
    while (game != 'q') {

        // if the player inputs 'r', creates a new game with new player
        if (game == 'r') {

            // creates new instance of player each time game is reset
            player = new Player();

            // asks for digits to be used initially
            System.out.print("Enter the number of digits to use: ");
            currentGame.setNumDigits(keyboard.nextInt());
            keyboard.nextLine();

            // if an inproper input is given, loops until a proper input is provided
            while (currentGame.getNumDigits() < 1) {
                System.out.print("Enter the number of digits to use: ");
                currentGame.setNumDigits(keyboard.nextInt());
                keyboard.nextLine();
            }

            // obtains player name
            System.out.print("Enter the player's name: ");
            player.setName(keyboard.nextLine());
        }

        // boolean for win condition, initially set to false
        boolean win = false;

        // generates new secret word array through Engine instance
        currentGame.generateNewSecret();

        // prints game number
        System.out.println("\nStarting game #" + player.getGamesCompleted());

        // counts number of guesses till win
        int count = 0;

        // until win conditions are met, loops through using Player instance to ask question
        // and Validation instantce to check answer and return boolean result of win condition
        while (!win) {
            String guess = player.askForGuess();
            win = check.validateGuess(currentGame.getSecretNumber(),currentGame.convertNumToDigitArray(guess),currentGame.getNumDigits());
            count++;
        }

        // once the player has won, prints congratulations
        System.out.println("Congratulations! You won in " + count + " moves.");

        // updates player statistics with results
        player.updateStats(count);

        // prints statistics of player and asks if they would like to play again
        System.out.println("\nStatistics for " + player.getName());
        System.out.println("Games completed: " + player.getGamesCompleted());
        System.out.println("Number of digits: " + currentGame.getNumDigits());
        System.out.println("Fastest win: " + player.getFastestWin() + " guesses");
        System.out.println("p - Play again");
        System.out.println("r - Reset game");
        System.out.println("q - Quit");
        System.out.print("\nWhat would you like to do? ");
        game = keyboard.next().charAt(0);
        keyboard.nextLine();

        while (game != 'q' && game != 'r' && game != 'p') {
            System.out.println("Not a valid input.");
            System.out.print("What would you like to do? ");
            game = keyboard.next().charAt(0);
            keyboard.nextLine();
        }

        // added to print game nicely
        if (game == 'r') {
            System.out.println();
        }
        
        }

    // when player chooses 'q', game exits
    System.out.println("Goodbye!");
    
    }
    
}
