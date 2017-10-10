package Junk;

import java.util.Arrays;

/**
 * Adam Goins
 * CS-136 HOMEWORK 4
 * Junk.Question 1: Stalls
 */
public class StallHandler {

    private int[] stalls;
    private int stallSize;
    private int leftMidpoint;
    private int rightMidpoint;
    private int counter;
    private int tmid;


    public StallHandler(int stallSize){

        this.stalls = new int[stallSize];
        this.stallSize = stallSize;
        this.counter = -1;
        this.tmid = stallSize / 2;

        // Fills the array with values being 0
        Arrays.fill(this.stalls, 0);

    }

    public static void main(String[] args){

        // Creates a new instance of Junk.StallHandler with 10 stalls

        StallHandler handler = new StallHandler(10);

        // Adds someone to the stall 10 times to demonstrate output..
        for(int i = 0; i < 10; i++) {
            handler.fillNextAvailableStall();
        }
    }

    public void fillNextAvailableStall() {

        System.out.println("Attempting to add someone to a stall...");
        // The counter is initialized to -1 so that the first time we call the function, we place our person in the middle

        if(counter == -1){

            // Middle index = 1
            stalls[stallSize / 2] = 1;

            // True mid = size / 2
            tmid = stallSize / 2;

            // Left midpoint if the array was split in 2
            leftMidpoint = tmid / 2;

            // Right midpoint if the array was split in 2
            rightMidpoint = tmid + (int) ((double) stallSize * .25);

            // sets the counter to 0, meaning next time this is called we'll operate on the left side of the true midpoint
            counter = 0;

        } else if (counter == 0){ // Deals with the left side of the True Midpoint

            // While leftMidpoint is invalid, increment it by 1
            while(leftMidpoint <0 || stalls[leftMidpoint] == 1){
                leftMidpoint++;
            }

            // Sets value of stall @ that index to 1
            stalls[leftMidpoint] = 1;

            // Moves the midpoint
            leftMidpoint -= stallSize * .25;
            counter = 1;
        }

        else { // Deals with the right side of the true midpoint

            // Same exact logic as the left midpoint conditional branch, just inverted
            while (rightMidpoint >= stallSize || stalls[rightMidpoint] == 1) {
                rightMidpoint--;
            }

            stalls[rightMidpoint] = 1;
            rightMidpoint += 2;
            counter = 0;
        }
     
     
        String outputString = "";

        // Adds the values of our array to a string
        for(int number : stalls){
            outputString += Integer.toString(number);
        }

        // Outputs the string in the desired format
        System.out.println(outputString.replaceAll("0", " _ ").replaceAll("1", " X "));

    }
}
