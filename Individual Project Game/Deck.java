import java.util.*;
/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck
{
    // instance variables - replace the example below with your own
    private ArrayList<Card> deck;
    private ArrayList<String> suits;
    private ArrayList<String> faces;
    
    private Random randomGen;

    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {
       suits = new ArrayList<String>();
       faces = new ArrayList<String>();
       deck = new ArrayList<Card>();
       
       addSuits();
       addFaces();
       addToDeck();
    }

    public void addSuits()
    {
        suits.add("Hearts");
        suits.add("Diamonds");
        suits.add("Clubs");
        suits.add("Spades");
       
    }
    public void addFaces()
    {
        faces.add("Ace");
        faces.add("Two");
        faces.add("Three");
        faces.add("Four");
        faces.add("Five");
        faces.add("Six");
        faces.add("Seven");
        faces.add("Eight");
        faces.add("Nine");
        faces.add("Ten");
        faces.add("Jack");
        faces.add("Queen");
        faces.add("King");
    }
     public void addToDeck()
    {
        for(String suit:suits)
        {
            for(String face:faces)
            {
                Card thisCard = new Card(suit, face);
                deck.add(thisCard);
            }
        }
    }
    public Card dealACard()
    {
        randomGen = new Random();
        int index = randomGen.nextInt(deck.size());
        Card thisCard = deck.get(index);
        
        deck.remove(index);
        return thisCard;
         
    }
}
