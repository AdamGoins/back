package hw8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Adam Goins
 * CS-136 HW 8
 * 2017.04.03
 *
 */
public class Find {

    /**
     * The main method receives a word to search for and an arbitrary number of filenames to search for said word in.
     * It then parses that data out according by index in the arguments given to it from the command line and uses it
     * accordingly.
     *
     * @param args: Command line arguments where args[0] is always the word to be searched for and args[n] is the name of the
     *            File to search in.
     */
    public static void main(String[] args) {

        // The first argument received is the word we want to locate.
        String word = args[0].toLowerCase();

        // Loops through the args received at index 1 because that's the starting index where all files start being received.
        for (int i = 1; i < args.length; i++) {
            // Makes a File object out of the file name received as an argument and calls the find() method on it.
            find(word, new File(args[i]));
        }

    }

    /**
     * The find() method receives a word as a string to be located in a file. It makes the word lower case for
     * easy comparison. A Scanner is then created pointing to the File object received and a loop is created to read
     * the contents of the file. Each line is ready individually and made to be lower case, then we use the .contains()
     * method to check if the line contains the word we're trying to locate. If it is found, we display data regarding it.
     *
     * We account for FileNotFound exceptions and the NullPointer associated with a scanner object pointing to null
     * being closed.
     *
     * @param word: The word to be found in a file.
     * @param file: The file we're searching for the word in.
     */
    public static void find(String word, File file){

        // Makes the word lower case for unbias comparison.
        word = word.toLowerCase();

        // Declares a new Scanner object
        Scanner fileIn = null;
        try {
            // Instantiates a new instance of a Scanner object pointing to the File object I'm wanting to access.
            fileIn = new Scanner(file);

            System.out.println("\nReading File: " + file.getName());

            // We start reading at the first line in the file.
            int lineNo = 1;
            while(fileIn.hasNextLine()){
                // Reads the line of the file and converts it to lower case for unbias comparison.
                String line = fileIn.nextLine().toLowerCase();
                // If the word trying to be found is in the file, we display data regarding its location.
                if(line.contains(word)){

                    // Prints output in the desired format.
                    System.out.println("Word Found!");
                    System.out.println("Line Number: " + lineNo);
                    System.out.println("Line: \"" + line + "\" contains word: " + word);

                    int beginIndex = line.indexOf(word);
                    int endIndex = word.length() + beginIndex;

                    System.out.println("Starting at index: " + beginIndex + ", ending at index: " + endIndex);
                    System.out.println(line.substring(0, beginIndex) + "\"" + line.substring(beginIndex, endIndex) + "\"" + line.substring(endIndex));
                    System.out.println();
                }
                // Increments my line number because each iteration of this loop is one line in the file.
                lineNo++;
            }

        } catch (FileNotFoundException e) {
            // Prints the stacktrace of the error.
            e.printStackTrace();
        }
        finally{
            // If my Scanner object doesn't point to null, I want to close it.
            if (fileIn != null) fileIn.close();
        }
    }

}
