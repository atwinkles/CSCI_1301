
/*
* Player.java
* Author: Alexander Winkles
* Submission Date: April 26, 2017
*
* Purpose: A Java class that conceptualizes the concept of a player
* for the purpose of playing blackjack.
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
 * A player in a blackJack game
 *
 */
public class Player {
	/**
	 * The players hand
	 */
	private Hand hand;
	
	/**
	 * Instantiates the hand instance variable.
	 */
	public Player() {
	    hand = new Hand();	
	}
	
	/**
	 * @return true if the player has bused
	 */
	public boolean busted() {
        if (BlackJack.getValueOfHand(hand) > 21) return true;
        else return false;
	}
	
	/**
	 * empty the player hand into the cards
	 * @param d deck that receives the cards
	 */
	public void returnCardstoDeck(Deck d) {
	    for (Card c : hand.emptyHand()) {
            d.addToBottom(c);
        } 	
	}
	/**
	 * @return the player's hand
	 */
	public Hand getHand() {
		return hand;
	}
}
