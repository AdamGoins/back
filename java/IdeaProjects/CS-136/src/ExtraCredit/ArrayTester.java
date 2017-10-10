package ExtraCredit;

/**
 * Created by Adam Goins on 3/10/17.
 * Extra Credit Homework
 * 2017.03.19
 *
 * The ArrayTester class is designed to create a new int array and mutilate it using the ArrayMethods class to test
 * The functionality of that class.
 */

public class ArrayTester {


    /**
     * The main method. Creates a new int[] and mutilates it using the ArrayMethods class
     * @param args: Command line arguments
     */
    public static void main(String[] args){

        // Creates a new ArrayMethods object and passes in a new int[] into the constructor of that class
        ArrayMethods methods = new ArrayMethods(new int[] {31,25,32,14,5});

        // Displaying the array we will be mutilating
        System.out.println("The array is: " + methods);
        System.out.println();

        // Output of swapping first and last elements
        methods.swapFirstAndLast();
        System.out.println();

        // Output of replacing elements with their largest neighbors
        methods.replaceLarger();
        System.out.println();

        // Output of shifting elements to the right
        methods.shiftRight();
        System.out.println();

        // Output of replacing even elements with 0
        methods.replaceEven();
        System.out.println();
    }
}
