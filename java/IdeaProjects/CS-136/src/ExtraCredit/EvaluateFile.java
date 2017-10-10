package ExtraCredit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Adam Goins on 3/10/17.
 * Extra Credit Homework
 * 2017.03.19
 *
 * This class is designed to prompt the user to input a file name and returns the number of lines, words, and characters
 * Contained in that file.
 */
public class EvaluateFile {

    /**
     * Main method. Prompts the user to input a filename and then reads the number of lines, words, and characters
     * In that file.
     *
     * @param args: Command line arguments
     */
    public static void main(String[] args){

        // New scanner object that gets input from the keyboard.
        Scanner scanner = new Scanner(System.in);
        // Keyboard prompt.
        System.out.print("Please enter the absolute path for your file: ");
        // Reads the data inputted by the user and stores it into the string "filename"
        String filename = scanner.nextLine();
        // Creates a new file using that name.
        File file = new File(filename);

        // Checked Exceptions require being caught
        try {
            // Scanner is created to read the contents of the file.
            Scanner fileIn = new Scanner(file);

            // Line count of the file (0 to start)
            int linecount = 0;

            // The contents of the file.
            String composition = "";

            // While there's data to be read...
            while(fileIn.hasNextLine()){

                // Adding the line being read to the contents string. We add a space at the end of the line so that the
                // End of one line doesn't get concated with with beginning of the next with no seperator for us to split on.
                composition += fileIn.nextLine() + " ";

                // Incrementing our linecount
                linecount++;
            }
            // Words are seperated by spaces, therefore we split by the space and that gives us a String[] containing just words.
            // The length of that array is how many words we have.
            for(String s : composition.split(" ")){
                System.out.println(s);
            }
            int wordCount = composition.split(" ").length;

            // Character count (including spaces) is just converting the contents of the text file to a char[] and counting the size of that char[].
            // We subtract (linecount - 1) because at the end of each line we added a space to split on later, so we have to not count those spaces
            // When evaluating the charcount of the file.
            int charCountSpaces = composition.toCharArray().length - (linecount - 1);

            // Character count (without spaces) is just the contents of the file, replacing all spaces with nothing, converting it
            // To a char[] and counting the size of that char[].
            int charCountNoSpaces = composition.replaceAll(" ", "").toCharArray().length;

            // Output.
            System.out.println("Words: " + wordCount);
            System.out.println("Characters (including spaces): " + charCountSpaces);
            System.out.println("Characters (excluding spaces): " + charCountNoSpaces);
            System.out.println("Line count: " + linecount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}