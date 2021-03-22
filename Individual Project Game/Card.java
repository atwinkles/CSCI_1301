
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card
{
    // instance variables - replace the example below with your own
    private String suit;
    private String face;

    /**
     * Constructor for objects of class Card
     */
    public Card(String suit, String face)
    {
        this.suit = suit;
        this.face = face;
    }
   
    public void printInfo()
    {
        System.out.println(face + " of " + suit);
    }
    
    public int getFaceValue() 
    {
        if (face.equalsIgnoreCase("Two")) return 2;
        else if (face.equalsIgnoreCase("Three")) return 3;
        else if (face.equalsIgnoreCase("Four")) return 4;
        else if (face.equalsIgnoreCase("Five")) return 5;
        else if (face.equalsIgnoreCase("Six")) return 6;
        else if (face.equalsIgnoreCase("Seven")) return 7;
        else if (face.equalsIgnoreCase("Eight")) return 8;
        else if (face.equalsIgnoreCase("Nine")) return 9;
        else if (face.equalsIgnoreCase("Ten")) return 10;
        else if (face.equalsIgnoreCase("Jack")) return 11;
        else if (face.equalsIgnoreCase("Queen")) return 12;
        else if (face.equalsIgnoreCase("King")) return 13;
        else return 14;
    }
}
