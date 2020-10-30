/**
 * the class Input is for contorlling the input process
 * @author (Haoyu Yang)
 * @version 1.0 (31.May.2019)
 */
import java.util.Scanner;
public class Input
{
    /**
     * default constructor
     */
    public Input()
    {
    }
    /**
     * static method for catching the input String of users
     * @param
     * String the message displayed before entering
     * @return 
     * String of the input contents
     */
    public static String acceptStringInput(String displayMessage)
    {
        String input = "";
        try
        {
            System.out.println(displayMessage);
            Scanner console = new Scanner(System.in);
            input = console.nextLine();
            console.close();
        }
        catch(NumberFormatException exception)
        {
            System.out.println("Some number format exception occurs! The type should be String!");
        }
        finally
        {
            return input;
        }
    }
    /**
     * static method for catching the input integer of users
     * @param
     * String the message displayed before entering
     * @return 
     * integer of the input contents
     */
    public static int acceptIntegerInput(String displayMessage)
    {
        int input = 0;
        try
        {
            String copy = "";
            System.out.println(displayMessage);
            Scanner console = new Scanner(System.in);
            copy = console.nextLine(); 
            input = Integer.parseInt(copy);
            console.close();
        }
        catch(NumberFormatException exception)
        {
            System.out.println("Some number format exception occurs! The type should be integer!");
        }
        finally
        {
            return input;
        }
    }
}