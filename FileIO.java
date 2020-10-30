/**
 * the class FileIO is for controling the process of reading from a file or writing into a file
 * @author (Haoyu Yang)
 * @version 1.0 (31.May.2019)
 */
import java.io.*;
import java.util.*;
public class FileIO
{
    private String fileName;
    /**
     * default constructor
     */
    public FileIO()
    {
    }
    /**
     * non-default constructor
     */
    public FileIO(String newFileName)
    {
        fileName = newFileName;
    }
    /**
     * accessor for "FileIO" object to get the file name
     * @return 
     * String : file name
     */
    public String getFileName()
    {
        return fileName;
    }
    /**
     * read and get the contents from a file and return a String of the contents
     * @return 
     * return a String of the contents
     */
    public String readFile()
    {
        String readLines = "";
        if (fileName.trim().length() > 0)
        {
            try
            {
                FileReader inputFile = new FileReader(fileName);
                try
                {
                    Scanner parser = new Scanner(inputFile);
                    while (parser.hasNextLine())
                        readLines += parser.nextLine() + "\n";
                    parser.close();
                }
                finally
                {
                    inputFile.close();
                }
            }
            catch(FileNotFoundException exception)
            {
                System.out.println("The file " + fileName + " is not found!");
            }
            catch(IOException exception)
            {
                System.out.println("Unexpected I/O exception occurs!");
            }
        }
        else
            System.out.println("Please enter file name!");
        return readLines;
    }
    /**
     * mutator for "FileIO" object to set the file name
     * @param
     * String : the file name
     */
    public void setFileName(String newFileName)
    {
        fileName = newFileName;
    }
    /**
     * write the contents of drivers into a file
     */
    public void writeFile(String contents)
    {
        try
        {
            if (fileName.trim().length() > 0)
            {
                PrintWriter outputFile = new PrintWriter(fileName);
                outputFile.print(contents);
                outputFile.close();
            }
            else
                System.out.println("Please enter the file name!");
        }
        catch(IOException e)
        {
            System.out.println("Unexpected I/O exception occurs!");
        }
    }

}