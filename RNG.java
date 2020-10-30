/**
 * the class RNG is a "Random Numeral Generator"
 * @author (Haoyu Yang)
 * @version 1.0 (31.May.2019)
 */
public class RNG
{
    /**
     * default constructor
     */
    public RNG()
    {
    }
    /**
     * create a random number within the range of the input integers and return this random number
     * @param
     * int minimumValue/int maximumValue : the range of the random number
     * @return 
     * int : return a random number within the range
     */
    public static int getRandomNumber(int minimumValue, int maximumValue)
    {
        double random = Math.random();
        int randomNumber = 0;
        if (minimumValue < maximumValue)
        {
            int differenceValue = maximumValue - minimumValue + 1;
            randomNumber = minimumValue + (int)(differenceValue * random);
        }
        else
        {
            System.out.println("The second parametre should be greater than the first parametre!");
            randomNumber = -1;
        }
        return randomNumber;
    }
}