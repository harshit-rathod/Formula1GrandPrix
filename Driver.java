/**
 * the class Driver store the information of a driver. There are two extra attributes in the field, 
 * tyreStatusIsForWet and carColor. The former is a boolean that indicates the tyre status of the 
 * car the driver are driving by the rule that "true" is for wet-weather type and "false" is for 
 * dry-weather type. The latter is a String that stores the color of the car the driver are driving.
 * @author (Haoyu Yang)
 * @version 1.0 (31.May.2019)
 */
public class Driver
{
    private String name;
    private int ranking;
    private String specialSkill;
    private boolean eligibleToRace;
    private int accumulatedScore;
    private int accumulatedTime;
    private boolean tyreStatusIsForWet;//true means "wet", false means "dry"
    private String carColor;//the color of the car that the driver drives
    /**
     * default constructor
     */
    public Driver()
    {
        name = "";
        ranking = 0;
        specialSkill = "";
        eligibleToRace = true;
        accumulatedScore = 0;
        accumulatedTime = 0;
        tyreStatusIsForWet = false;
        carColor = "";
    }
    /**
     * non-default constructor
     */
    public Driver(String newName, int newRanking, String newSpecialSkill, boolean newEligibleToRace, int newAccumulatedScore, int newAccumulatedTime, boolean newTyreStatusIsForWet, String newCarColor)
    {
        name = newName;
        ranking = newRanking;
        specialSkill = newSpecialSkill;
        eligibleToRace = newEligibleToRace;
        accumulatedScore = newAccumulatedScore;
        accumulatedTime = newAccumulatedTime;
        tyreStatusIsForWet = newTyreStatusIsForWet;
        carColor = newCarColor;
    }
    /**
     * accessor for "Driver" object to get the driver's accumulated score
     * @return 
     * int : driver's accumulated score
     */
    public int getAccumulatedScore()
    {
        return accumulatedScore;
    }
    /**
     * accessor for "Driver" object to get the driver's accumulated time
     * @return 
     * int : driver's accumulated time
     */
    public int getAccumulatedTime()
    {
        return accumulatedTime;
    }
    /**
     * accessor for "Driver" object to get the driver's car color
     * @return 
     * int : driver's car color
     */
    public String getCarColor()
    {
        return carColor;
    }
    /**
     * return the driver's name, ranking, special skill for writing driver information into a file
     * @return 
     * String : the driver's name, ranking, special skill for writing driver information into a file
     */
    public String getDriverInfo()
    {
        String driverInfo = name + "," + ranking + "," + specialSkill;
        return driverInfo;
    }
    /**
     * return the driver's name, ranking, special skill, and accumulated score for writing driver information into a file
     * @return 
     * String : the driver's name, ranking, special skill, and accumulated score for writing driver information into a file
     */
    public String getDriverInfoWithScore()
    {
        String driverInfo = name + "," + ranking + "," + specialSkill + "," + accumulatedScore;
        return driverInfo;
    }
    /**
     * accessor for "Driver" object to get the driver's eligibility to race
     * @return 
     * boolean : driver's eligibility to race
     */
    public boolean getEligibleToRace()
    {
        return eligibleToRace;
    }
    /**
     * accessor for "Driver" object to get the driver's name
     * @return 
     * String : driver's name
     */
    public String getName()
    {
        return name;
    }
    /**
     * accessor for "Driver" object to get the driver's ranking
     * @return 
     * int : driver's ranking
     */
    public int getRanking()
    {
        return ranking;
    }
    /**
     * accessor for "Driver" object to get the driver's special skill
     * @return 
     * String : driver's special skill
     */
    public String getSpecialSkill()
    {
        return specialSkill;
    }
    /**
     * accessor for "Driver" object to get the driver's tyre status
     * @return 
     * boolean : driver's tyre status
     */
    public boolean getTyreStatusIsForWet()
    {
        return tyreStatusIsForWet;
    }
    /**
     * mutator for "Driver" object to set the driver's accumulated score
     * @param
     * int : driver's accumulated score
     */
    public void setAccumulatedScore(int newAccumulatedScore)
    {
        accumulatedScore = newAccumulatedScore;
    }
    /**
     * mutator for "Driver" object to set the driver's accumulated time
     * @param
     * int : driver's accumulated time
     */
    public void setAccumulatedTime(int newAccumulatedTime)
    {
        accumulatedTime = newAccumulatedTime;
    }
    /**
     * mutator for "Driver" object to set the driver's car color
     * @param
     * String : driver's car color
     */
    public void setCarColor(String newCarColor)
    {
        carColor = newCarColor;
    }
    /**
     * mutator for "Driver" object to set the driver's eligibility to race
     * @param
     * boolean : driver's eligibility to race
     */
    public void setEligibleToRace(boolean newEligibleToRace)
    {
        eligibleToRace = newEligibleToRace;
    }
    /**
     * mutator for "Driver" object to set the driver's name
     * @param
     * String : driver's name
     */
    public void setName(String newName)
    {
        name = newName;
    }
    /**
     * mutator for "Driver" object to set the driver's ranking
     * @param
     * int : driver's ranking
     */
    public void setRanking(int newRanking)
    {
        ranking = newRanking;
    }
    /**
     * mutator for "Driver" object to set the driver's special skill
     * @param
     * String : driver's special skill
     */
    public void setSpecialSkill(String newSpecialSkill)
    {
        specialSkill = newSpecialSkill;
    }
    /**
     * mutator for "Driver" object to set the driver's tyre status
     * @param
     * boolean : driver's tyre status
     */
    public void setTyreStatusIsForWet(boolean newTyreStatusIsForWet)
    {
        tyreStatusIsForWet = newTyreStatusIsForWet;
    }
}