/**
 * the class ListOfDrivers stores the ArrayList of drivers
 * @author (Haoyu Yang)
 * @version 1.0 (31.May.2019)
 */
import java.util.ArrayList;
import java.io.*;
public class ListOfDrivers
{
    private ArrayList<Driver> drivers; 
    /**
     * default constructor
     */
    public ListOfDrivers()
    {
        drivers = new ArrayList<>();
    }
    /**
     * non-default constructor
     */
    public ListOfDrivers(ArrayList<Driver> newDrivers)
    {
        drivers = newDrivers;
    }
    /**
     * display all drivers
     * @param
     * message for option
     */
    public void displayDrivers(String displayMessage)
    {
        for (int i = 0; i < getNumberOfDrivers(); i++)
            displayOneDriver(i, displayMessage, 0);
    }
    /**
     * display one drivers
     * @param
     * the index of the driver
     * String messagePosition : message for option
     * int addedObject : the figure of time or score to be changed
     */
    public void displayOneDriver(int index, String messagePosition, int addedObject)
    {
        if (messagePosition.equals("eachLap"))
            System.out.println("    # \"" + getDriver(index).getCarColor() + "\" car : \"" + getDriver(index).getName() + "\" #");
        else if (messagePosition.equals("leadingDriver"))
            System.out.println("    The leading driver is :\n\n        [" + getDriver(index).getName() + "]\n              *drives the \"" + getDriver(index).getCarColor() + "\" car!\n              *Accumulated time: " + getDriver(index).getAccumulatedTime() + " seconds");
        else if (messagePosition.equals("rank&car&name&skill&score"))
        {
            System.out.print("   #Ranking <" + getDriver(index).getRanking() + "> -\"" + getDriver(index).getCarColor() + "\" car - <" + getDriver(index).getName() + "> - Total Score: {" + getDriver(index).getAccumulatedScore() + "} points#");
            if (addedObject != 0)
                System.out.println(": (+" + addedObject + " seconds!)");
            else
                System.out.println("");
        }
        else if (messagePosition.equals("rank&car&name&time"))
            if (getDriver(index).getEligibleToRace())    
                System.out.println("    #" + getDriver(index).getRanking() + "# \"" + getDriver(index).getCarColor() + "\" car - <" + getDriver(index).getName() + "> - accumulated time(" + getDriver(index).getAccumulatedTime() + "s)");
            else
                System.out.println("    # OUT # \"" + getDriver(index).getCarColor() + "\" car - <" + getDriver(index).getName() + ">");
        else if (messagePosition.equals("rank&car&name&time&score"))
        {
            if (getDriver(index).getEligibleToRace())
            {
                System.out.println("    #Ranking " + getDriver(index).getRanking() + "# -\"" + getDriver(index).getCarColor() + "\" car - <" + getDriver(index).getName() + ">");
                if (addedObject != 0)
                    System.out.println("               (+" + addedObject + " points!)");
                System.out.println("               *Accumulated time in this race: " + getDriver(index).getAccumulatedTime() + " seconds\n               *Total Score: {" + getDriver(index).getAccumulatedScore() + "} points");
            }
            else
                System.out.println("    # OUT # -\"" + getDriver(index).getCarColor() + "\" car - <" + getDriver(index).getName() + ">\n               *Total Score: {" + getDriver(index).getAccumulatedScore() + "} points");
        }
        else if (messagePosition.equals("rank&name&skill&score"))
        {
            System.out.println("    #" + getDriver(index).getRanking() + "# <" + getDriver(index).getName() + ">");
            if (getDriver(index).getRanking() == 1)
                System.out.println("          -----[Champion!!!]-----");
            System.out.println("          *Special Skill: \"" + getDriver(index).getSpecialSkill() + "\"\n          *Total Score: {" + getDriver(index).getAccumulatedScore() + "} points");
        }
    }
    /**
     * exchange the position of two drivers in the ArrayList
     * @param
     * int indexOne/indexTwo : the index of the two drivers
     */
    public void exchangeDriverPosition(int indexOne, int indexTwo)
    {
        Driver temporaryDriver = getDriver(indexOne);
        drivers.set(indexOne, getDriver(indexTwo));
        drivers.set(indexTwo, temporaryDriver);
    }
    /**
     * accessor for "drivers" object to get one driver by its index
     * @return 
     * Driver object
     */
    public Driver getDriver(int index)
    {
        return drivers.get(index);
    }
    /**
     * accessor for "drivers" object to get the ArrayList of the drivers
     * @return 
     * ArrayList of the drivers
     */
    public ArrayList<Driver> getDrivers()
    {
        return drivers;
    }
    /**
     * get some information of all drivers and return a String
     * @return 
     * the String of the informaiton of all drivers without the score
     */
    public String getDriversInfo()
    {
        StringBuffer driversInfo = new StringBuffer();
        for (Driver eachDriver : drivers)
        {
            String eachDriverInfo = eachDriver.getDriverInfo();
            driversInfo.append(eachDriverInfo + "\n");
        }
        driversInfo.deleteCharAt(driversInfo.length() - 1);
        return driversInfo.toString();
    }
    /**
     * get some information of all drivers and return a String
     * @return 
     * the String of the informaiton of all drivers including the score
     */
    public String getDriversInfoWithScore()
    {
        StringBuffer driversInfo = new StringBuffer();
        for (Driver eachDriver : drivers)
        {
            String eachDriverInfo = eachDriver.getDriverInfoWithScore();
            driversInfo.append(eachDriverInfo + "\n");
        }
        driversInfo.deleteCharAt(driversInfo.length() - 1);
        return driversInfo.toString();
    }
    /**
     * accessor for "drivers" object to get the quantity of the drivers
     * @return 
     * int : the quantity of the ArrayList of the drivers
     */
    public int getNumberOfDrivers()
    {
        return drivers.size();
    }
    /**
     * read the driver file before each race
     */
    public void readDriverFileDuringGame()
    {
        try
        {
            FileIO fileIO = new FileIO("drivers.txt");
            String[] splitLines = fileIO.readFile().split("\\n");
            drivers.clear();
            for (String eachLine : splitLines)
            {
                String[] driverInfo = eachLine.split(",");
                int newRanking = Integer.parseInt(driverInfo[1]);
                int newAccumulatedScore = Integer.parseInt(driverInfo[3]);
                setOneDriver(driverInfo[0], newRanking, driverInfo[2], true, newAccumulatedScore, 0, false, "");
            }
        }
        catch(NumberFormatException exception)
        {
            System.out.println("The Number Format Exception occurs!");
        }
    }
    /**
     * read the driver file before the first race
     */
    public void readDriverFileFirstTime()
    {
        try
        {
            FileIO fileIO = new FileIO("drivers.txt");
            String[] splitLines = fileIO.readFile().split("\\n");
            drivers.clear();
            for (String eachLine : splitLines)
            {
                String[] driverInfo = eachLine.split(",");
                int getRanking = Integer.parseInt(driverInfo[1]);
                setOneDriver(driverInfo[0], getRanking, driverInfo[2], true, 0, 0, false, "");
            }
        }
        catch(NumberFormatException exception)
        {
            System.out.println("The Number Format Exception occurs!");
        }
    }
    /**
     * mutator for "drivers" object to add a new "Driver" object into the ArrayList
     * @param
     * the "Driver" object
     */
    public void setDriver(Driver newDriver)
    {
        drivers.add(newDriver);
    }
    /**
     * mutator for "drivers" object to set the whole ArrayList of drivers
     * @param
     * ArrayList of drivers
     */
    public void setDrivers(ArrayList<Driver> newDrivers)
    {
        File file = new File("drivers.txt");
        if (file.exists())
            readDriverFileFirstTime();
        else
            drivers = newDrivers;
    }
    /**
     * mutator for "drivers" object to add a new "Driver" object with its attributes into the ArrayList
     * @param
     * the attributes of the "Driver" object
     */
    public void setOneDriver(String newName, int newRanking, String newSpecialSkill, boolean newEligibleToRace, int newAccumulatedScore, int newAccumulatedTime, boolean newTyreStatusIsForWet, String newCarColor)
    {
        Driver newDriver = new Driver(newName, newRanking, newSpecialSkill, newEligibleToRace, newAccumulatedScore, newAccumulatedTime, newTyreStatusIsForWet, newCarColor);
        drivers.add(newDriver);
    }
    /**
     * write all drivers' informaiton into a file at the end of the game
     */
    public void writeDriverFileAtGameEnd()
    {
        FileIO fileIO = new FileIO("drivers.txt");
        String writeContent = getDriversInfo();
        fileIO.writeFile(writeContent);
    }
    /**
     * write all drivers' informaiton into a file after each race
     */
    public void writeDriverFileDuringGame()
    {
        FileIO fileIO = new FileIO("drivers.txt");
        String writeContent = getDriversInfoWithScore();
        fileIO.writeFile(writeContent);
    }
}