/**
 * the class Championship control the process of the whole game. The executive method is runGame() that is the main method of this class
 * @author (Haoyu Yang)
 * @version 1.0 (31.May.2019)
 */
public class Championship
{
    private ListOfDrivers drivers;
    private ListOfVenues venues;
    /**
     * default constructor
     */
    public Championship()
    {
        drivers = new ListOfDrivers();
        venues = new ListOfVenues();
    }
    /**
     * non-default constructor
     */
    public Championship(ListOfDrivers newDrivers, ListOfVenues newVenues)
    {
        drivers = newDrivers;
        venues = newVenues;
    }
    /**
     * allocate all the drivers ar the start of one race
     */
    public void allDriversAllocatedAtRaceStart()
    {
        String[] carColors = new String[]{"pink", "blue", "red", "purple", "orange"};
        int addedTime = 0;
        sortDrivers("ranking");
        System.out.println("\nDrivers have been allocated by their previous ranking!\n\n[Drivers Position]");
        for (int i = 0; i < drivers.getNumberOfDrivers(); i++)
        {
            int ranking = i + 1;
            if (ranking == 1)
            {
                oneDriverTimeIncrement(i, addedTime, "");
                drivers.getDriver(i).setCarColor(carColors[i]);
                drivers.displayOneDriver(i, "rank&car&name&skill&score", addedTime);
                addedTime++;
            }
            else if (ranking == 2 ||  ranking == 3 ||  ranking == 4)
            {
                addedTime += 2;
                oneDriverTimeIncrement(i, addedTime, "");
                drivers.getDriver(i).setCarColor(carColors[i]);
                drivers.displayOneDriver(i, "rank&car&name&skill&score", addedTime);
            }
            else if (ranking == 5)
            {
                oneDriverTimeIncrement(i, 10, "");
                drivers.getDriver(i).setCarColor(carColors[i]);
                drivers.displayOneDriver(i, "rank&car&name&skill&score", 10);
            }
            else
            {
                oneDriverTimeIncrement(i, 10, "");
                drivers.getDriver(i).setCarColor("No." + (i + 1));
                drivers.displayOneDriver(i, "rank&car&name&skill&score", 10);
            }
        }
    }
    /**
     * calculate scores of all drivers at the end of a race
     */
    public void allDriversCalculateScores()
    {
        for (int i = 0; i < drivers.getNumberOfDrivers(); i++)
        {
            int position = i + 1;
            switch (position)
            {
                case 1 : 
                    oneDriverScoreIncrement(i, 8);
                    drivers.displayOneDriver(i,"rank&car&name&time&score", 8);
                    break;
                case 2 : 
                    oneDriverScoreIncrement(i, 5);
                    drivers.displayOneDriver(i, "rank&car&name&time&score", 5);
                    break;
                case 3 : 
                    oneDriverScoreIncrement(i, 3);
                    drivers.displayOneDriver(i, "rank&car&name&time&score", 3);
                    break;
                case 4 : 
                    oneDriverScoreIncrement(i, 1);
                    drivers.displayOneDriver(i, "rank&car&name&time&score", 1);
                    break;
                default:
                    drivers.displayOneDriver(i, "rank&car&name&time&score", 0);
                    if (!drivers.getDriver(i).getEligibleToRace())
                        System.out.println("    ------has lost the eligibility in this race------");
            }
        }
    }
    /**
     * display the information at the end of the game
     */
    public void displayChampionshipResult()
    {
        displayTitleWithClean("Formula 9131 Grand Prix Championship", 50, 5);
        System.out.println("################## Game Result ##################\n\n### Champion Information ###");
        sortDrivers("score");
        int highestScore = drivers.getDriver(0).getAccumulatedScore();
        int championQuantity = findChampions();
        if (championQuantity == 1)
            System.out.println("There are " + championQuantity + " champion who gets " + highestScore + " points in this season!\nThis driver is:\n");
        else
            System.out.println("There are " + championQuantity + " champions who get " + highestScore + " points in this season!\nThey are:\n");
        for (int i = 0; i < championQuantity; i++)
        {
            String championName = drivers.getDriver(i).getName();
            displayTitle(championName, championName.length() + 9, 3);
        }
        Input.acceptStringInput("\nPlease press the enter key to display all drivers information...");
        displayTitleWithClean("Formula 9131 Grand Prix Championship", 50, 5);
        System.out.println("################### Game Over ###################\n\n### Drivers Information ###\n(ranked by total scores)\n");
        drivers.displayDrivers("rank&name&skill&score");
    }
    /**
     * display some message at title enclosed by a box
     * @param
     * String : the message that should be displayed
     * int : the length of the box and the line quantity of the box
     */
    public void displayTitle(String displayMessage, int length, int line)
    {
        int lengthOfString = displayMessage.length();
        if (lengthOfString < length)
        {
            for (int j = 0; j < line; j++)
            {
                if (j == 0 || j == line - 1)
                {
                    for (int i = 0; i < length; i++)
                    {
                        if (i == length -1)
                            System.out.print("\n");
                        else
                            System.out.print("-");
                    }
                }
                else if (j == line/2)
                {
                    for (int i = 0; i < length; i++)
                    {
                        if (i == 0)
                            System.out.print("|");
                        else if (i == length - 1)
                            System.out.print("|\n");
                        else if (i == (length - lengthOfString)/2)
                        {
                            System.out.print(displayMessage);
                            i += lengthOfString;
                        }
                        else
                            System.out.print(" ");
                    }
                }
                else
                {
                    for (int i = 0; i < length -1; i++)
                        if (i == 0)
                            System.out.print("|");
                        else if (i == length - 2)
                            System.out.print("|\n");
                        else
                            System.out.print(" ");
                }
            }
        }
        else
            System.out.println("The length of the display message should be less than the total length!");
    }
    /**
     * clean the message on the screen and display some message at title enclosed by a box
     * @param
     * String : the message that should be displayed
     * int : the length of the box and the line quantity of the box
     */
    public void displayTitleWithClean(String displayMessage, int length, int line)
    {
        System.out.print('\u000C');
        displayTitle(displayMessage, length, line);
    }
    /**
     * let user enter the quantity of races and return the numebr of it
     * @return 
     * int : return the numebr of the race quantity
     */
    public int enterRaceNum()
    {
        int raceNum = 0;
        do
            raceNum = Input.acceptIntegerInput("Please enter the number of races in the championship between 3 and 5:");
        while (!Validation.numberRange(raceNum, 3, 5));
        return raceNum;
    }
    /**
     * get the drivers who are the champions and return the number of it
     * @return 
     * int : return the number of champion quantity
     */
    public int findChampions()
    {
        int countChampions = 1;
        for (int i = 1; i < drivers.getNumberOfDrivers(); i++)
        {
            if (drivers.getDriver(i).getAccumulatedScore() == drivers.getDriver(0).getAccumulatedScore())
                countChampions++;
        }
        return countChampions;
    }
    /**
     * accessor for ListOfDrivers
     * @return 
     * ListOfDrivers : the ListOfDrivers object
     */
    public ListOfDrivers getDriverList()
    {
        return drivers;
    }
    /**
     * accessor for ListOfVenues
     * @return 
     * ListOfVenues : the ListOfVenues object
     */
    public ListOfVenues getVenueList()
    {
        return venues;
    }
    /**
     * control the process of one driver changing the tyre randomly at the second lap when it rains
     * @param
     * the index of the driver
     */
    public void oneDriverChangeTyre(int driverIndex)
    {
        int randomNum = 0;
        randomNum = RNG.getRandomNumber(1, 2);
        if (randomNum == 1)
        {
            drivers.getDriver(driverIndex).setTyreStatusIsForWet(true);
            oneDriverTimeIncrement(driverIndex, 10, "<Change tyre> The tyres have been changed to wet-weather tyres");
        }
    }
    /**
     * control the events happened for one driver
     * @param
     * int driverIndex : the driver index
     */
    public void oneDriverRandomEventsOccur(int driverIndex)
    {
        int randomNum = RNG.getRandomNumber(1, 100);
        if (randomNum <= 5)//5%
            oneDriverTimeIncrement(driverIndex, 20, "<event> The car has developed a minor mechanical fault!");
        if (randomNum > 5 && randomNum <=8)//3%
            oneDriverTimeIncrement(driverIndex, 120, "<event> The car has developed a major mechanical fault!");
        if (randomNum == 9)//1%
        {
            System.out.println("             - <event> The car has developed a unrecoverable mechanical fault!");
            drivers.getDriver(driverIndex).setEligibleToRace(false);
            drivers.getDriver(driverIndex).setRanking(100);
            drivers.getDriver(driverIndex).setAccumulatedTime(10000);
            System.out.println("             ----------The driver lost the eligibility of this race!----------");
        }
    }
    /**
     * control adding points for one driver
     * @param
     * int driverIndex : the driver index
     * int addedScore : points to add
     */
    public void oneDriverScoreIncrement(int driverIndex, int addedScore)
    {
        int eachDriverScore = drivers.getDriver(driverIndex).getAccumulatedScore();
        int finalScore = eachDriverScore + addedScore;
        drivers.getDriver(driverIndex).setAccumulatedScore(finalScore);
    }
    /**
     * control adding time for one driver
     * @param
     * int driverIndex : the driver index
     * int addedTime : time to add
     * String displayMessage : the message for time increment
     */
    public void oneDriverTimeIncrement(int driverIndex, int addedTime, String displayMessage)
    {
        int eachDriverTime = drivers.getDriver(driverIndex).getAccumulatedTime();
        int finalTime = eachDriverTime + addedTime;
        drivers.getDriver(driverIndex).setAccumulatedTime(finalTime);
        if (!displayMessage.equals(""))
            System.out.println("             - " + displayMessage + ": +" + addedTime + " seconds!");
    }
    /**
     * control minusing time for one driver when triggering their skills
     * @param
     * int driverIndex : the driver index
     * int min/max : the range of the random number
     * String displayMessage : the message for time increment
     */
    public void oneDriverTimeReduction(int driverIndex, int min, int max, String displayMessage)
    {
        int randomTime = RNG.getRandomNumber(min, max);
        int eachDriverTime = drivers.getDriver(driverIndex).getAccumulatedTime();
        int eachDriverFinalTime = eachDriverTime - randomTime;
        drivers.getDriver(driverIndex).setAccumulatedTime(eachDriverFinalTime);
        System.out.println("             - " + displayMessage + ": -" + randomTime + " seconds!");
    }
    /**
     * control triggering drivers' skills process
     * @param
     * int driverIndex : the driver index
     * int lapNoIndex : the current lap index
     */
    public void oneDriverTriggerSkill(int driverIndex, int lapNoIndex)
    {
        String skill = drivers.getDriver(driverIndex).getSpecialSkill();
        if (skill.equals("Braking") || skill.equals("Cornering"))
            oneDriverTimeReduction(driverIndex, 1, 8, "<skill> " + skill);
        else if (skill.equals("Overtaking"))
        {
            int lapNo = lapNoIndex + 1;
            int lapNoRemainder = lapNo % 3;
            if (lapNoRemainder == 0)
                oneDriverTimeReduction(driverIndex, 10, 20, "<skill> " + skill);
        }
        else
            System.out.println("             - <skill> The race driver do not have a special skill!");
    }
    /**
     * control the process of one lap
     * @param
     * int lapNoIndex : the lap's index 
     * int venueNoOfLaps: the index of the chosen venue
     * int venueAverageLapTime: the average lap time
     * int venueChanceOfRainNo: the rain chance rate
     * boolean rainStatus: rain or not
     * String raceInfo: the display message for race at the top of the screen
     * @return 
     * boolean : return a boolean to show the rain status of this race
     */
    public boolean oneLap(int lapNoIndex, int venueNoOfLaps, int venueAverageLapTime, int venueChanceOfRainNo, boolean rainStatus, String raceInfo)
    {
        displayTitleWithClean(raceInfo, 50, 3);
        System.out.println("[lap No]:("+(lapNoIndex+1)+"/" + venueNoOfLaps + ")");
        if (!rainStatus)
            rainStatus = oneRaceRandomRainOccurs(venueChanceOfRainNo);
        if (rainStatus)
            System.out.println("<Weather> Oops! It's raining!");
        else
            System.out.println("<Weather> Nice! There is no rain!");
        System.out.println("<Each Driver's Status in This Lap>");
        for (int i = 0; i < drivers.getNumberOfDrivers(); i++)
        {
            drivers.displayOneDriver(i, "eachLap", 0);
            if (drivers.getDriver(i).getEligibleToRace())
            {
                if (lapNoIndex == 0)
                    drivers.displayOneDriver(i, "startTimePenalty", 0);
                if (rainStatus && lapNoIndex == 1)
                    oneDriverChangeTyre(i);
                if (drivers.getDriver(i).getTyreStatusIsForWet())
                    System.out.println("             (tyres type: Wet-weather)");
                else
                    System.out.println("             (tyres type: Dry-weather)");
                if (rainStatus && (!drivers.getDriver(i).getTyreStatusIsForWet()))
                    oneDriverTimeIncrement(i, 5, "<rain penalty> Using dry-weather tyres in rainny day");
                oneDriverTriggerSkill(i, lapNoIndex);
                oneDriverTimeIncrement(i, venueAverageLapTime, "<lap time> Average running time of a lap");
                oneDriverRandomEventsOccur(i);
            }
            else
                System.out.println("    ------has lost the eligibility in this race------");
        }
        sortDrivers("time");
        sortDriversIfTimeEqualRandomly();
        Input.acceptStringInput("\nPlease press enter key to show the results of this lap...");
        displayTitleWithClean(raceInfo, 50, 3);
        System.out.println("[lap No]:["+(lapNoIndex+1)+"/" + venueNoOfLaps + "]");
        System.out.println("\n####### Lap Information #######\n\n### Leading driver ###");
        drivers.displayOneDriver(0, "leadingDriver", 0);
        System.out.println("\n### Drivers Information ###\n");
        drivers.displayDrivers("rank&car&name&time");
        Input.acceptStringInput("\nPlease press enter key to continue...");
        return rainStatus;
    }
    /**
     * control the process of one race
     * @param
     * int raceNo : the number of the current race
     * int raceQuantity : the quantity of race chosen by user
     */
    public void oneRace(int raceNo, int raceQuantity)
    {
        String raceInfo = "Race (" + raceNo + "/" + raceQuantity + ") of the season";
        displayTitleWithClean(raceInfo, 50, 3);
        int venueIndex = venueChoiceAtRaceStart();
        displayTitleWithClean(raceInfo, 50, 3);
        venues.displayVenuesInfo(venueIndex);
        int venueNoOfLaps = venues.getVenue(venueIndex).getNoOfLaps();
        int venueAverageLapTime = venues.getVenue(venueIndex).getAverageLapTime();
        int venueChanceOfRainNo = (int)(venues.getVenue(venueIndex).getChanceOfRain() * 100);
        for (int i = 0; i < venues.getNumberOfVenues(); i++)
        {
            if (venueIndex == i)
                venues.removeVenue(i);
        }
        if (raceNo == 1)
            drivers.setDrivers(null);
        else
            drivers.readDriverFileDuringGame();
        allDriversAllocatedAtRaceStart();
        boolean rainStatus = false;
        Input.acceptStringInput("\nPlease press enter key to start the race...");
        for (int i = 0; i < venueNoOfLaps; i++) 
            rainStatus = oneLap(i, venueNoOfLaps, venueAverageLapTime, venueChanceOfRainNo, rainStatus, raceInfo);
        displayTitleWithClean(raceInfo, 50, 3);
        Input.acceptStringInput("\nThis race have been completed!!!\n\nPlease press enter key to show the drivers information in this race...");
        displayTitleWithClean(raceInfo, 50, 3);
        System.out.println("\n########## Race information ##########\n");
        allDriversCalculateScores();
        drivers.writeDriverFileDuringGame();
        Input.acceptStringInput("\nPlease press enter key to start the next race...");
    }
    /**
     * rain occurs randomly in one lap
     * @param
     * int : the percentage of the rain chance
     * @return 
     * boolean : rain or not
     */
    public boolean oneRaceRandomRainOccurs(int venueChanceOfRainNo)
    {
        boolean rainStatus = false;
        int randomNo = RNG.getRandomNumber(1, 100);
        if (randomNo <= venueChanceOfRainNo)
            rainStatus = true;
        return rainStatus;
    }
    /**
     * the main method of controlling the process of the game
     */
    public void runGame()
    {
        displayTitleWithClean("Formula 9131 Grand Prix Championship", 50, 5);
        int raceNum = enterRaceNum();
        Input.acceptStringInput("\nYou have chosen " + raceNum + " races for this session!\n\nPlease press enter key to start the first race...");
        venues.setVenues(null);
        for (int i = 1; i <= raceNum; i++)
            oneRace(i, raceNum);
        displayTitleWithClean("Formula 9131 Grand Prix Championship", 50, 5);
        Input.acceptStringInput("\nAll the " + raceNum + " races have been completed!\n\nPlease press enter key to see the result information...");
        for (int i = 0; i < drivers.getNumberOfDrivers(); i++)
            drivers.getDriver(i).setEligibleToRace(true);
        displayChampionshipResult();
        drivers.writeDriverFileAtGameEnd();
        Input.acceptStringInput("\nPlease press enter key to see what to do next...");
        whatToDoNext();
    }
    /**
     * mutator for "drivers" object to set the whole ArrayList of drivers
     * @param
     * ArrayList of drivers
     */
    public void setDriverList(ListOfDrivers newDrivers)
    {
        drivers = newDrivers;
    }
    /**
     * set the ranking of drivers orderly after sorting them
     * @param
     * String message : to indicate where the method is used
     */
    public void setDriversRanking(String message)
    {
        int ranking = 1;
        int championQuantity = findChampions();
        if (message.equals("score"))
        {
            ranking += championQuantity;
            for (int i = 0; i < drivers.getNumberOfDrivers(); i++)
            {
                if (i < championQuantity)
                    drivers.getDriver(i).setRanking(1);
                else
                {
                    drivers.getDriver(i).setRanking(ranking);
                    ranking++;
                }
            } 
        }
        else
        {
            for (int i = 0; i < drivers.getNumberOfDrivers(); i++)
            {
                if (drivers.getDriver(i).getEligibleToRace() == true)
                    drivers.getDriver(i).setRanking(ranking);
                ranking++;
            }
        }
    }
    /**
     * mutator for "venues" object to set the whole ArrayList of venues
     * @param
     * ArrayList of venues
     */
    public void setVenueList(ListOfVenues newVenues)
    {
        venues = newVenues;
    }
    /**
     * set the ranking of drivers orderly after sorting them
     * @param
     * String message : to indicate what comparative attribute is used
     */
    public void sortDrivers(String comparativeAttribute)
    {
        int driverQuantity = drivers.getNumberOfDrivers();
        for (int i = 0; i < driverQuantity; i++)
        {
            int minIndex = i;
            for (int j = i; j < driverQuantity; j++)
            {
                if (comparativeAttribute.equals("ranking"))
                {
                    if (drivers.getDriver(j).getRanking() < drivers.getDriver(minIndex).getRanking())
                        minIndex = j;
                }
                else if (comparativeAttribute.equals("time"))
                {
                    if (drivers.getDriver(j).getAccumulatedTime() < drivers.getDriver(minIndex).getAccumulatedTime())
                        minIndex = j;
                }
                else if (comparativeAttribute.equals("score"))
                {
                    if (drivers.getDriver(j).getAccumulatedScore() > drivers.getDriver(minIndex).getAccumulatedScore())
                        minIndex = j;
                }
            }
            drivers.exchangeDriverPosition(minIndex, i);
        }
        setDriversRanking(comparativeAttribute);
    }
    /**
     * randomly sort and exchange the positions of drivers who share the same accumulated time for each lap
     */
    public void sortDriversIfTimeEqualRandomly()
    {
        for (int i = 0; i < drivers.getNumberOfDrivers(); i++)
        {
            if (drivers.getDriver(i).getEligibleToRace())
            {
                int countRepeatedTime = 0;
                for (int j = i + 1; j < drivers.getNumberOfDrivers(); j++)
                {
                    if (drivers.getDriver(i).getAccumulatedTime() == drivers.getDriver(j).getAccumulatedTime())
                        countRepeatedTime++;
                    else
                        break;
                }
                if (countRepeatedTime > 0)
                {
                    int index = i;
                    i += countRepeatedTime;
                    while (countRepeatedTime > 0)
                    {
                        int randomNo = RNG.getRandomNumber(index, index + countRepeatedTime);
                        if (index != randomNo)
                            drivers.exchangeDriverPosition(index, randomNo);
                        index++;
                        countRepeatedTime--;
                    }
                }
            }
        }
        setDriversRanking("");
    }
    /**
     * let user enter the venue number and return an integer of the number of the chosen venue
     * @return 
     * an integer of the number of the chosen venue
     */
    public int venueChoiceAtRaceStart()
    {
        int choosenNo = 0;
        venues.displayVenuesList();
        do
            choosenNo = Input.acceptIntegerInput("\nPlease enter a number between 1 and " + venues.getNumberOfVenues() + " to choose a venue for this race:");
        while (!Validation.numberRange(choosenNo, 1, venues.getNumberOfVenues()));
        return choosenNo - 1;
    }
    /**
     * represent the choice of what to do next and control the process of the choices
     */
    public void whatToDoNext()
    {
        String enteredWord = "";
        displayTitleWithClean("Formula 9131 Grand Prix Championship", 50, 5);
        do
        {
            enteredWord = Input.acceptStringInput("\n[What do you want to do next?]\nPlease make a choice:\n    - enter \'R\' or \'r\' to restart the game\n    - enter \'E\' or \'e\' to close the game");
            if (Validation.stringLengthWithRange(enteredWord,1,1))
            {
                if (enteredWord.equalsIgnoreCase("r"))
                {
                    runGame();
                    break;
                }
                if (enteredWord.equalsIgnoreCase("e"))
                {
                    displayTitleWithClean("Formula 9131 Grand Prix Championship", 50, 5);
                    System.out.println("\n################## Game Close ##################");
                }
            }
            else
                System.out.println("The input should be just one character mentioned above!!!");
        }
        while (!enteredWord.equalsIgnoreCase("e"));
    }
}