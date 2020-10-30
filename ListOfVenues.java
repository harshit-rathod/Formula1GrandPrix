/**
 * the class ListOfVenues stores the ArrayList of venues
 * @author (Haoyu Yang)
 * @version 1.0 (31.May.2019)
 */
import java.util.ArrayList;
import java.io.*;
public class ListOfVenues
{
    private ArrayList<Venue> venues; 
    /**
     * default constructor
     */
    public ListOfVenues()
    {
        venues = new ArrayList<>();
    }
    /**
     * non-default constructor
     */
    public ListOfVenues(ArrayList<Venue> newVenues)
    {
        venues = newVenues;
    }
    /**
     * display the information of one venue that be chosen
     */
    public void displayVenuesInfo(int index)
    {
        System.out.println("### Venue Information ###\n   The fabulous venue \"" + getVenue(index).getVenueName() + "\" is chosen!");
        System.out.println("   There are " + getVenue(index).getNoOfLaps() + " laps.");
        System.out.println("   The average lap rime is " + getVenue(index).getAverageLapTime() + " seconds");
        System.out.println("   And the chance of raining : " + (int)(getVenue(index).getChanceOfRain() * 100) + "%");
    }
    /**
     * display the information of all venues
     */
    public void displayVenuesList()
    {
        System.out.println("[The Venue List]");
        for (int i = 0; i < venues.size(); i++)
        {
            int venueNo = i + 1;
            System.out.println("   [" + venueNo + "] <" + venues.get(i).getVenueName() + "> - (" + getVenue(i).getNoOfLaps() + " laps) - \"" + (int)(getVenue(i).getChanceOfRain() * 100) + "%\" rain chance");
        }
    }
    /**
     * accessor for "venues" object to get the quantity of the venues
     * @return 
     * int : the quantity of the ArrayList of the venues
     */
    public int getNumberOfVenues()
    {
        return venues.size();
    }
    /**
     * accessor for "venues" object to get one venue by its index
     * @return 
     * Venue object
     */
    public Venue getVenue(int index)
    {
        return venues.get(index);
    }
    /**
     * accessor for "venues" object to get the ArrayList of the venues
     * @return 
     * ArrayList of the venues
     */
    public ArrayList<Venue> getVenues()
    {
        return venues;
    }
    /**
     * read the venues file at the start of the game
     */
    public void readVenueFile()
    {
        try
        {
            FileIO fileIO = new FileIO("venues.txt");
            String[] splitLines = fileIO.readFile().split("\\n");
            venues.clear();
            for (String eachLine : splitLines)
            {
                String[] venueInfo = eachLine.split(",");
                String getVenueName = venueInfo[0];
                int getNoOfLaps = Integer.parseInt(venueInfo[1]);
                int getAverageLapTime = Integer.parseInt(venueInfo[2]);
                double getChanceOfRain = Double.parseDouble(venueInfo[3]);
                setOneVenue(getVenueName, getNoOfLaps, getAverageLapTime, getChanceOfRain);
            }
        }
        catch(NumberFormatException exception)
        {
            System.out.println("The Number Format Exception occurs!");
        }
    }
    /**
     * remove one venue from the ArrayList
     */
    public void removeVenue(int index)
    {
        venues.remove(index);
    }
    /**
     * mutator for "venues" object to add a new "Venue" object with its attributes into the ArrayList
     * @param
     * the attributes of the "Venue" object
     */
    public void setOneVenue(String newVenueName, int newNoOfLaps, int newAverageLapTime, double newChanceOfRain)
    {
        Venue newVenue = new Venue(newVenueName, newNoOfLaps, newAverageLapTime, newChanceOfRain);
        venues.add(newVenue);
    }
    /**
     * mutator for "venues" object to add a new "Venue" object into the ArrayList
     * @param
     * the "Venue" object
     */
    public void setVenue(Venue newVenue)
    {
        venues.add(newVenue);
    }
    /**
     * mutator for "venues" object to set the whole ArrayList of venues
     * @param
     * ArrayList of venues
     */
    public void setVenues(ArrayList<Venue> newVenues)
    {
        File file = new File("venues.txt");
        if (file.exists())
            readVenueFile();
        else
            venues = newVenues;
    }
}