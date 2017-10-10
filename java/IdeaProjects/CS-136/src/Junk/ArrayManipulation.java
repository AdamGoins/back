package Junk;

import java.util.Arrays;
import java.util.Random;

/**
 * Adam Goins
 * CS-136
 * HOMEWORK 4 Junk.Question 2
 */
public class ArrayManipulation {

    private static Random rand = new Random();
    public static void main(String[] args){

        int[] myArray = new int[10];


        System.out.println("Populating Array with 10 random numbers from 1-20...");

        // Populates array
        for(int i = 0; i < myArray.length; i++){
            myArray[i] = getRandom(1, 20);
        }

        System.out.println("The Array is: " + Arrays.toString(myArray));
        System.out.println("----------------------------------------\n");

        System.out.println("Even indexes are: " + getEvenIndexes(myArray));
        System.out.println("Elements that are even are: " + getEvenElements(myArray));
        System.out.println("Elements Reversed is: " + getReverseArray(myArray));
        System.out.println("First Element is: " + myArray[0] + ", Last element is: " + myArray[myArray.length -1]);
    }

    public static String getReverseArray(int[] myArray){

        String output = "";

        // Loops through the array starting from last index and decrementing through
        for(int i = myArray.length - 1; i >= 0; i--){
            output += myArray[i] + ", ";
        }

        return output;
    }


    public static String getEvenElements(int[] myArray){

        String output = "";

        for(int element : myArray){
            // If the element is even then add it to the output string
            if (element % 2 == 0){
                output += Integer.toString(element) + ", ";
            }
        }
        return output;
    }

    public static String getEvenIndexes(int[] myArray){

        String output = "";

        // Starting at 0 and incrementing the i variable by 2 each time yields only even indices
        for(int i = 0; i < myArray.length; i += 2){
            output += Integer.toString(myArray[i]) + ", ";
        }

        return output;
    }

    public static int getRandom(int min, int max){
        // Returns a random within bounds min, max
        return rand.nextInt((max - min) + 1) + min;

    }

}
