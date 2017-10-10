package ExtraCredit;

import java.util.Arrays;

/**
 * Created by Adam Goins
 * Extra Credit Homework
 * 2017.03.19
 *
 * The ArrayMethods class is created to allow mutilating an array of integers in methods defined by the problem constraints.
 *
 * The array should allow for the first/last elements to be swapped, shifting the positions to the right (pushing last indice to first),
 * Replacing the even values of the array with the integer 0, and replacing each element with the largest of it's neighbors (excluding the first and last)
 */
public class ArrayMethods
{
    /**
     * The integer array we will be mutated
     */
    private int[] values;

    /**
     * One-arg constructor, receives an array of integers that we'll be mutilating
     * @param initialValues: The int array that we'll be mutating
     */
    public ArrayMethods(int[] initialValues) {
        values = initialValues;
    }

    /**
     * This method will swap the first and last elements in the array.
     */
    public void swapFirstAndLast() {
        System.out.println("Swapping first and last elements...");
        System.out.println("Array before mutilation: " + this.toString());

        // Creates a new array to place the elements in.
        int[] newArray = values.clone();

        // The max possible index of a collection is always the length of that collection -1
        int maxIndex = values.length - 1;

        // The first index of the new array will be equal to the last index of the initial one.
        newArray[0] = values[maxIndex];

        // The last index of the new array will be equal to the first index of the initial one.
        newArray[maxIndex] = values[0];

        // Sets our array to the new array, reflecting appropriate changes.
        values = newArray;
        System.out.println("Array after mutilation: " + this.toString());
    }

    /**
     * This method will shift all elements to the right by 1 index. The last element will be placed at index 0.
     */
    public void shiftRight() {
        System.out.println("Shifting the Array to the right...");
        System.out.println("Array before mutilation: " + this.toString());

        // Creates a new array to place elements in.
        int[] newArray = values.clone();

        // Max index is always length - 1
        int maxIndex = values.length - 1;

        // We loop through the new array starting at index 1 and stopping at 1 before the last index.
        // We then assign it values equal to each index of the initial array - 1 (right shift)
        for(int i = 1; i < values.length; i++){
            newArray[i] = values[i - 1];
        }

        // The first index of the shifted array is equal to the last index of it pre-shifted.
        newArray[0] = values[maxIndex];

        // Sets our array to the new array, reflecting appropriate changes.
        values = newArray;
        System.out.println("Array after mutilation: " + this.toString());
    }

    /**
     * This method will loop through the array and check the values at each index, if a value is even it is replaced with 0.
     */
    public void replaceEven(){
        System.out.println("Replacing even values with 0...");
        System.out.println("Array before mutilation: " + this.toString());

        // Loop through the array.
        for(int i = 0; i < values.length; i++){
            // If the number is even, we set it to 0.
            if(values[i] % 2 == 0) values[i] = 0;
        }
        System.out.println("Array after mutilation: " + this.toString());
    }

    /**
     * This method loops through the array and replaces each index with the value of its largest neighbor.
     */
    public void replaceLarger(){
        System.out.println("Replacing largest neighbors...");
        System.out.println("Array before mutilation: " + Arrays.toString(values));

        // New array to write to.
        int[] newArray = values.clone();
        // For each element (not first and last)
        for(int i = 1; i < values.length - 1; i++){
            if(values[i - 1] > values[i + 1]){ // Sets the value of the new array to the left neighbor if it's bigger than the right neighbor.
                newArray[i] = values[i-1];
            } // Otherwise we set the value to the right neighbor.
            else newArray[i] = values[i + 1];
        }

        // Saving changes into our array.
        values = newArray;
        System.out.println("Array after mutilation: " + Arrays.toString(values));
    }

    /**
     * Returns the array
     * @return int[]: The array
     */
    public int[] getValues(){
        return this.values;
    }

    /**
     * This method is being overridden from the Object class, it displays the int[] in the proper format using the Array.toString() method.
     * @return String: The array of int values.
     */
    @Override
    public String toString(){
        return Arrays.toString(this.values);
    }
}