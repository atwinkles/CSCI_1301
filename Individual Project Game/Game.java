import java.util.*;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    private Deck thisDeck;
    private InputReader reader;
    private Player human;
    private Player computer;
    private ArrayList<Card> player1Hand;
    private ArrayList<Card> player2Hand;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        // initialise instance variables
        reader = new InputReader();
        thisDeck = new Deck();
        human = new Player();
        computer = new Player();
        player1Hand = new ArrayList<Card>();
        player2Hand = new ArrayList<Card>();
        play();
        
        
    }

    public void play()
    {
        printWelcome();
        createDecks();
        human.setHand(player1Hand);
        computer.setHand(player2Hand);
       
        boolean finished = false;
        while(!finished)
        {
            String input = reader.getInput();
            
            if(input.contains("bye"))
            {
                finished = true;
                System.out.println("Thank you for playing!");
            }
            else if(input.equals("draw"))
            {
                Card humanCard = getPlayer1Card();
                System.out.println("Player Hand: ");
                humanCard.printInfo();
                Card computerCard = getPlayer2Card();
                System.out.println("Computer Hand: ");
                computerCard.printInfo();
                if(humanCard.getFaceValue() > computerCard.getFaceValue())
                {
                    System.out.println("You have won this round!");
                    player1Hand.add(humanCard);
                    player1Hand.add(computerCard);
                }
                else if(humanCard.getFaceValue() < computerCard.getFaceValue())
                {
                        System.out.println("The computer won this round.");
                        player2Hand.add(humanCard);
                        player2Hand.add(computerCard);
                }
                else
                {
                    ArrayList<Card> warPile;
                    Card humanWarCard1, humanWarCard2, computerWarCard1, computerWarCard2;      
                    System.out.println("There was a draw. Go into WAR!");
                    humanWarCard1 = getPlayer1Card();
                    System.out.println("Player Card: ");
                    humanWarCard1.printInfo();
                    humanWarCard2 = getPlayer1Card();
                    computerWarCard1 = getPlayer2Card();
                    System.out.println("Computer Card: ");
                    computerWarCard1.printInfo();
                    computerWarCard2 = getPlayer2Card();
                    if(humanWarCard1.getFaceValue() > computerWarCard1.getFaceValue())
                    {
                        System.out.println("You have won the war!");
                        player1Hand.add(humanWarCard1);
                        player1Hand.add(humanWarCard2);
                        player1Hand.add(computerWarCard1);
                        player1Hand.add(computerWarCard2);
                    }
                    else if(humanWarCard1.getFaceValue() < computerWarCard1.getFaceValue())
                    {
                        System.out.println("The computer won the war!");
                        player2Hand.add(humanWarCard1);
                        player2Hand.add(humanWarCard2);
                        player2Hand.add(computerWarCard1);
                        player2Hand.add(computerWarCard2);
                    }
                    else {
                        while (humanWarCard1 == computerWarCard1)
                        {
                            
                        }
                    }
                }
        }
    }
    }
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
    
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Game of War");
        System.out.println("During each round, both players will draw a card face up from their pile.");
        System.out.println("The player with the highest card value will win.");
        System.out.println("If the players tie- then it's WAR!");
        System.out.println("Both players will put a card face down and one face up.");
        System.out.println("The player with the highest card face up will take the whole pile.");
        System.out.println("If the players tie, they will continue to repeat this until one of them wins.");
        System.out.println("The winner will take the whole stack. The game ends when one players has all of the cards.");
        System.out.println("Ready to get started? Draw a card.");
        System.out.println("To draw a card, type draw. Type bye to quit at any time.");
    }
    public Card getPlayer1Card()
    {
        Card humanCard = player1Hand.get(0);
        return humanCard;
        
    }
     public Card getPlayer2Card()
    {
        Card computerCard = player2Hand.get(0);
        return computerCard;
    }
    public void createDecks()
    {
        int count= 0;
        while(count < 26)
        {
            player1Hand.add(thisDeck.dealACard());
            count ++;
        }
        while(count < 52)
        {
            player2Hand.add(thisDeck.dealACard());
            count ++;
        }
    }
}
