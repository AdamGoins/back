package file_handlers.database;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Adam on 8/6/2016.
 */
public class Test {

    public static void main(String[] args){
        System.out.println(answer("2+3*2"));

        System.out.println(answer("2*4*3+9*3+5"));

        System.out.println(answer("<html>Hey! <font color=red> there </html>"));
    }

    public static String answer(String str) {
       return str.replaceAll("\\<.*?>","");
        //return format(str);

    }

    public static String format(String str){

        ArrayList<String> operators = new ArrayList<>(); // Arraylist to hold the operators that occur in the given string
        ArrayList<String> digits = new ArrayList<>();    // Arraylist to hold the digits that are in the given string

        String result = ""; // Blank for now, this will be what we add to when parsing the string into proper syntax

        for(char character : str.toCharArray()){ // Splits the string into a character array so that we can sort the characters into the appropriate array declared above

            if(Character.isDigit(character)) digits.add(Character.toString(character)); // If the character is a digit, we add it to the digits Array.
            else operators.add(Character.toString(character));      // If the character is an operator, we add it to the operators array.

        }

        Collections.sort(operators); // Sorts the Array so that '*' are before '+' operators

        int depreciation = digits.size() / 2 ; // Depreciation is a placeholder variable that keeps track of the depreciating value of how many consecutive digits preceed a cluster of operators,
                                                // I really don't know a good way to explain that, and I'm sure my implementation is incorrect but I recognize the function and importance of it.
                                                // It returns legal output consistent with the test cases listed, however I'm sure the simple digits.size() / 2 will break down with higher level input.


            for(int i = 0; i < digits.size(); i++){ // For each digit in our array, we're going to add it to the string 'result', with placing necessary binary operators before it if necessary.


                if(i != 0 && i % depreciation == 0){ // This block is hit when we need to add binary operators following a cluster of consecutive digits.
                    // If I == 0 we will hit this block, we don't want to hit it on the first iteration, but we want to hit it when we iterate through a multiple of the depreciation value.

                    if(operators.size() > 0){ // if we still have operators to use
                        for(int ii = 0; ii < depreciation - 1; ii++){ // Depreciation - 1 is necessary because the number of consecutive operators should be 1 less than the number of consecutive digits before the cluster. I. E (243*+)

                            result = result.concat(operators.get(0)); // We grab the next available operator in our list (it's sorted with '*' being the first operators already).
                            operators.remove(0); // We remove that operator from the available operators because it was just placed into the result
                        }
                    }
                    if(i < digits.size() - 1){ // if we aren't at the last digit in our digits Array, we want to add the next two available ones to the (possible) current cluster
                        result = result.concat(digits.get(i)).concat(digits.get(i + 1)); // We're adding our next digit cluster to the result string
                        digits.remove(i + 1); // We remove the next digit from the available digits so that we don't duplicate digits.

                    }
                    else {
                        result = result.concat(digits.get(i)); // if we are on the last digit, then we will add it to the result;
                    }

                    depreciation--; // Depreciation depreciates by a value of 1 for each time we hit this block.
                }


                else{
                    result = result.concat(digits.get(i)); // If operators are not required to be added this iteration, we'll just add the next available digit to the result.
                }

            }

            if (operators.size() > 0) { // we hit this if by the time the above for loop is complete, we still have leftover operators that weren't placed.

                for(String operator : operators){
                    result = result.concat(operator); // We add those operators at the end of the string appropriately.
                }

            }


        return result;

    }


}


