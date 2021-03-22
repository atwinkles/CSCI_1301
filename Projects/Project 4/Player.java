/*
* Player.java
* Author: Alexander Winkles
* Submission Date: April 6, 2017
*
* Purpose: A Java class used to play a game of 
* "Pico, Fermi, Bagel", a guessing game. This is used by
* Bagel.java to store information about a player as well
* as their actions.
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

public class Player {

    // creates new instance of Scanner class
    Scanner keyboard = new Scanner(System.in); 

    // declares private fields
    private String name; // name of player
    private int fastestWin = Integer.MAX_VALUE; // fastest win of player, set to max value initially
    private int gamesCompleted = 1; // number of games player has done
    
    // askForGuess method prints a question then uses Scanner class
    // to obtain a String value for the guess
    public String askForGuess() {
        System.out.print("Enter your guess: ");
        String guess = this.keyboard.nextLine(); 
        return guess;
    }

    // getName method returns the name of the player
    public String getName() {
        return name;
    }

    // getFastestWin returns the fastest win of player
    public int getFastestWin() {
        return fastestWin; 
    }

    // getGamesCompleted returns number of games completed by player
    public int getGamesCompleted() {
        return gamesCompleted;
    }

    // setName method changes the name of the player
    public void setName(String name) {
        this.name = name;
    }

    // updateStats method updates the fastestWin and gamesCompleted fields of player
    public void updateStats(int numberOfMovesTakenToWin) {
        // only updates fastestWin if less guesses that previous value
        if (numberOfMovesTakenToWin < fastestWin) {
            fastestWin = numberOfMovesTakenToWin; 
        }
        gamesCompleted++;
    }
}
