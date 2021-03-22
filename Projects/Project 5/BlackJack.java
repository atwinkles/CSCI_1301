/*
* BlackJack.java
* Author: Alexander Winkles
* Submission Date: April 26, 2017
*
* Purpose: A Java application that simulates playing blackjack
* using the Card, Hand, Deck, Dealer, and Player classes.
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
 * Class representing a single player blackjack game
 */
public class BlackJack {
	
	private Deck deck;
	private Dealer dealer;
	private Player player;


	/**
	 * Constructs and prepares for a new game of BlackJack.
	 * Creates player, dealer and deck objects then shuffles
	 * the deck and gives both the dealer and player two cards.
	 */
	public BlackJack() {
        deck = new Deck();
        dealer = new Dealer();
        player = new Player();
        deck.shuffle(); 
        player.getHand().addCard(deck.draw());
        player.getHand().addCard(deck.draw());
        dealer.getHand().addCard(deck.draw());
        dealer.getHand().addCard(deck.draw());
	}
	/**
	 * Restarts in a few steps
	 * 1. The Player and dealer return their cards to the deck.
	 * 2. The deck is shuffled.
	 * 3. Both the player and the dealer receive two cards drawn form the top of the deck.
	 */
	public void restart() {
        for (Card card : player.getHand().emptyHand()) {
            deck.addToBottom(card);
        }	
        for (Card card : dealer.getHand().emptyHand()) {
            deck.addToBottom(card);
        }	
        deck.shuffle();
        player.getHand().addCard(deck.draw());
        player.getHand().addCard(deck.draw());
        dealer.getHand().addCard(deck.draw());
        dealer.getHand().addCard(deck.draw());
	}
	/**
	 * Returns the value of a card in a standard game of Blackjack based on the type of the card
	 * ex. An Ace would return 1, a 2 would return 2... 
	 * @param c card whose value is extracted
	 * @return value of the card
	 */
	public static int getValueOfCard(Card c) {

        if (c.getType() == Card.Type.ACE) return 1;
        else if (c.getType() == Card.Type.TWO) return 2;
        else if (c.getType() == Card.Type.THREE) return 3;
        else if (c.getType() == Card.Type.FOUR) return 4;
        else if (c.getType() == Card.Type.FIVE) return 5;
        else if (c.getType() == Card.Type.SIX) return 6;
        else if (c.getType() == Card.Type.SEVEN) return 7;
        else if (c.getType() == Card.Type.EIGHT) return 8;
        else if (c.getType() == Card.Type.NINE) return 9;
        else return 10;
	}
	/**
	 * Returns the maximum value of the hand that does not result in a bust
	 * @param h Hand whose value is returned
	 * @return value of h
	 */
	public static int getValueOfHand(Hand h) {
        int sum = 0;
        int count = 0;
		for (Card c : h.getCards()) {
            if (c.getType() == Card.Type.ACE) count++;
            sum += getValueOfCard(c);
        }
        for (int i = 0; i < count; i++) {
            if (sum + 10 > 21) break;
            sum += 10; 
        }
        return sum;
	}

	/**
	 * @return Deck used to play
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * @return Dealer of the game
	 */
	public Dealer getDealer() {
		return dealer;
	}
	
	/**
	 * @return Player playing the blackjack game
	 */
	public Player getPlayer() {
		return player;
	}

}
