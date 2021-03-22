/*
* Engine.java
* Author: Alexander Winkles
* Submission Date: April 6, 2017
*
* Purpose: A Java class used to play a game of 
* "Pico, Fermi, Bagel", a guessing game. This is used by
* Bagel.java to store the game actions used.
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

import java.util.Random;
public class Engine {

    // declares private fields
    private int numDigits; // the number of digits the random number could have
    private int[] secretNumber; // the array of digits of the secret number
    private Random randomNumberGenerator = new Random(); // an instance of the Random class to generate random numbers

    // convertNumToDigitArray method takes a string guess from Player class and converts to
    // an integer array
    public int[] convertNumToDigitArray(String number) {
        int N = number.length();
        int[] digitArray = new int[N];
        for (int i = 0; i < N; i++) {
            digitArray[i] = Integer.parseInt(number.substring(i,i+1));
        }
        return digitArray; 
    }

    // getNumDigits method returns the number of digits of the game
    public int getNumDigits() {
        return numDigits;
    }

    // getSecretNumber method returns the secret number array, primarily used for Validator class
    public int[] getSecretNumber() {
        return secretNumber;
    }

    // generateNewSecret method uses the Random class to generate a secret number array
    // with digits based on numDigits
    public void generateNewSecret() {
        secretNumber = new int[numDigits];
        for (int i = 0; i < numDigits; i++) {
            secretNumber[i] = randomNumberGenerator.nextInt(9) + 1;
        }
    }

    // setNumDigits method changes the number of digits in the game
    public void setNumDigits(int numDigits) {
        this.numDigits = numDigits;
    }

    // setSecretNumber method is a method that sets the secret number of the game
    // used primarily for testing purposes
    public void setSecretNumber(int[] secretNumber) {
        this.secretNumber = secretNumber;
    }

}
