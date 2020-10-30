/**
 * the class Venue store the information of a venue
 * @author (Haoyu Yang)
 * @version 1.0 (31.May.2019)
 */
public class Venue
{
    private String venueName;
    private int noOfLaps;
    private int averageLapTime;
    private double chanceOfRain;
    /**
     * default constructor
     */
    public Venue()
    {
        venueName = "";
        noOfLaps = 0;
        averageLapTime = 0;
        chanceOfRain = 0;
    }
    /**
     * non-default constructor
     */
    public Venue(String newVenueName, int newNoOfLaps, int newAverageLapTime, double newChanceOfRain)
    {
        venueName = newVenueName;
        noOfLaps = newNoOfLaps;
        averageLapTime = newAverageLapTime;
        chanceOfRain = newChanceOfRain;
    }
    /**
     * accessor for "Venue" object to get the venue's average running time of a lap 
     * @return 
     * int : venue's average running time of a lap 
     */
    public int getAverageLapTime()
    {
        return averageLapTime;
    }
    /**
     * accessor for "Venue" object to get the venue's probability of raining
     * @return 
     * double : venue's probability of raining
     */
    public double getChanceOfRain()
    {
        return chanceOfRain;
    }
    /**
     * accessor for "Venue" object to get the venue's laps quantity
     * @return 
     * int : venue's laps quantity
     */
    public int getNoOfLaps()
    {
        return noOfLaps;
    }
    /**
     * mutator for "Venue" object to set the venue's name
     * @param
     * boolean : venue's name
     */
    public void setVenueName(String newVenueName)
    {
        venueName = newVenueName;
    }
    /**
     * mutator for "Venue" object to set the venue's average running time of a lap 
     * @param
     * boolean : venue's average running time of a lap 
     */
    public void setAverageLapTime(int newAverageLapTime)
    {
        averageLapTime = newAverageLapTime;
    }
    /**
     * mutator for "Venue" object to set the venue's probability of raining
     * @param
     * boolean : venue's probability of raining
     */
    public void setChanceOfRain(double newChanceOfRain)
    {
        chanceOfRain = newChanceOfRain;
    }
    /**
     * mutator for "Venue" object to set the venue's laps quantity
     * @param
     * boolean : venue's laps quantity
     */
    public void setNoOfLaps(int newNoOfLaps)
    {
        noOfLaps = newNoOfLaps;
    }
    /**
     * accessor for "Venue" object to get the venue's name
     * @return 
     * String : venue's name
     */
    public String getVenueName()
    {
        return venueName;
    }
}