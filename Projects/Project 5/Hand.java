/*
* Hand.java
* Author: Alexander Winkles
* Submission Date: April 26, 2017
*
* Purpose: A Java class that conceptualizes the concept of a hand
* of cards for the purpose of playing blackjack.
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


/**
 * 
 * @author ghyzel
 *
 */
public class Hand {
	
	/**
	 * The cards in the hand
	 */
	private Card [] cards;
	
	/**
	 * Creates an empty hand
	 */
	public Hand() {
		//Initializing an empty array. 
		//Calling cards.length on this array would return 0
		cards = new Card[0];		
	}

	/**
	 * Adds Card c to the hand
	 * 
	 * @param c card to be added
	 */
	public void addCard(Card c) {
	    Card[] newHand = new Card[cards.length + 1];
        for (int i = 0; i < cards.length; i++) {
            newHand[i] = cards[i];
        }
        newHand[cards.length] = c;
        cards = new Card[cards.length+1];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = newHand[i];
        }
	}
	
	/**
	 * @return number of cards in the hand
	 */
	public int size() {
        return cards.length;
	}
	
	/**
	 * Returns an array of all the cards in the hand
	 * 
	 * @return the cards in the hand
	 */
	public Card[] getCards() {
		// Ensure you return reference to the copy of the cards array
		// and not a reference actual cards array!

        Card[] hand = new Card[cards.length];
        for (int i = 0; i < cards.length; i++) {
            hand[i] = cards[i];
        }
        return hand;

	}
	
	/**
	 * Empties the hand, and returns an array containing the discarded cards.
	 * 
	 * @return the discarded cards
	 */
	public Card[] emptyHand() {

        Card[] hand = getCards();
        cards = new Card[0];
        return hand;

	}
	
	/**
	 * Returns a String representation of the hand
	 * 
	 * E.g.
	 * 
	 * "Empty Hand"
	 * "1. ACE OF SPADES\n2. QUEEN OF HEARTS"
	 * 
	 * @return a String representing the hand
	 */
	@Override
	public String toString() {
		// HINT: Use the toString() method of the card class
        if (this.size() == 0) return "Empty hand";
        String s = "";
        for (int i = 0; i < this.size(); i++) {
            s += i + ". " + cards[i].toString() + "\n";
        }
        return s;
	}
}
