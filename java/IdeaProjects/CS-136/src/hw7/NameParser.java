package hw7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Adam Goins on 3/12/17.
 * Homework 7
 * 2017.03.12
 *
 * The NameParser class reads in a text file containg male names, female names, and data on each line.
 * It then parses the male names and data, the female names and data, and then writes them to their respective text file.
 */
public class NameParser {

    /**
     *  Constants for the paths for the babynames, boynames, and girlnames text files.
     */
    private static final String BABYNAMEPATH = "Junk/babynames.txt";
    private static final String BOYSPATH = "boynames.txt";
    private static final String GIRLSPATH = "Junk/girlnames.txt";


    /**
     * The main method.
     *
     * @param args: Arguments received by the command line.
     */
    public static void main(String[] args){

        // We must catch checked exceptions, therefore we use a try block.
        try {
            // The file for the babynames.txt file.
            File namesFile = new File(BABYNAMEPATH);

            // We're going to use printwriters to write to the output file paths.
            PrintWriter boyWriter = new PrintWriter(BOYSPATH);
            PrintWriter girlWriter = new PrintWriter(GIRLSPATH);

            // We use a scanner to read the contents of the babynames.txt text file.
            Scanner namesIn = new Scanner(namesFile);

            // While there is content to be read.
            while(namesIn.hasNextLine()){

                // Reading the line
                String line = namesIn.nextLine();

                // Splitting the name into a String[] by the double spaces that seperate elements in the line
                String[] contents = line.split("  ");

                // This is what we'll be adding boy name data to
                String boyLine = "";

                // This is what we'll be adding girl name data to
                String girlLine = "";

                // Looping though the String[] that is the line of data
                for(int i = 1; i < contents.length; i++){
                    // Boy name data occurs at index 1 - 3 in the array
                    if(i < 4) boyLine += contents[i] + "  ";

                    // Girl name data occurs at indices 4-6
                    else girlLine += contents[i] + "  ";
                }

                // Writes the boy data in the line to the proper out text file.
                boyWriter.println(boyLine);
                // Write the girl data in the line to the proper out text file.
                girlWriter.println(girlLine);
            }

            // Closing our scanner and filehandlers.
            namesIn.close();
            boyWriter.close();
            girlWriter.close();

        // Catching the exception that made be thrown in the try block.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        }
    }


