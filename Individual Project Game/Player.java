import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private ArrayList<Card> player1Hand;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        player1Hand = new ArrayList<Card>();
    }
    public void addCardtoDeck(Card aCard)
    {
        player1Hand.add(aCard);
    }
    public void setHand(ArrayList<Card> cards)
    {
        player1Hand = cards;
    }
    public void printPlayerHand()
    {
        for(Card aCard:player1Hand)
        {
            aCard.printInfo();
        }
    }
}
