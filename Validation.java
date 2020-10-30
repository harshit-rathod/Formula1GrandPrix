/**
 * the class Validation is for validating the input contents
 * @author (Haoyu Yang)
 * @version 1.0 (31.May.2019)
 */
public class Validation
{
    /**
     * default constructor
     */
    public Validation()
    {
    }
    /**
     * a static method for judging whether the input integer value is within the range
     * @param
     * input int
     * int min/max : the range
     * @return 
     * a boolean to indicate whether the input integer value is within the range
     */
    public static boolean numberRange(int value, int min, int max)
    {
        boolean numberIsBlank = stringIsBlank(String.valueOf(value));
        if (numberIsBlank == false)
        {
            if (value >= min && value <= max)
                return true;
            else
            {
                if (min != max)
                    System.out.println("The range should be between " + min + " and " + max + "!");
                else
                    System.out.println("Its range should be " + min + "!");
                return false;
            }
        }
        else
            return false;
    }
    /**
     * a static method for judging whether the input String is blank
     * @param
     * input String
     * @return 
     * a boolean to indicate whether the input String is blank
     */
    public static boolean stringIsBlank(String value)
    {
        String trim = value.trim();
        if (value.equals("") || trim.equals(""))
        {
            System.out.println("It cannot be empty or all spaces!");
            return true;
        }
        else
            return false;
    }
    /**
     * a static method for judging whether the input String is within the range
     * @param
     * input String
     * int min/max : the range
     * @return 
     * a boolean to indicate whether the input String is within the range
     */
    public static boolean stringLengthWithRange(String value, int min, int max)
    {
        boolean stringIsBlank = stringIsBlank(value);
        if (stringIsBlank == false)
        {
            if (value.length() >= min && value.length() <= max)
                return true;
            else
            {
                if (min != max)
                    System.out.println("The character range should be between " + min + " and " + max + "!");
                else
                    System.out.println("Its character range should be " + min + "!");
                return false;
            }
        }
        else
            return false;
    }
}