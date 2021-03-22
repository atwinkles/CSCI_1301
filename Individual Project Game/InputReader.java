import java.util.*;
/**
 * Write a description of class InputReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InputReader
{
    // instance variables - replace the example below with your own
    private Scanner reader;

    /**
     * Constructor for objects of class InputReader
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }
    public String getInput()
    {
        System.out.print("> ");         // print prompt
        String inputLine = reader.nextLine();
        
        return inputLine;
    }
}
