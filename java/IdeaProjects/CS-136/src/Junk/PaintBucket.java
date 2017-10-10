package Junk;

import java.awt.*;

/**
 * Adam Goins, Taylor Bruce
 * Lab 4: PaintBucket
 * 2017.02.17 PaintBucket
 *
 *  The PaintBucket class is a class that is designed by problem constraints to contain one mutator, and one accessor.
 *  The class must abide by these constraints and simulate a PaintBucket, which has paint inside holding distinct Red, Green,
 *  And Blue RGB values.
 *
 *  The Mutator must receive a new combination of color (in RGB), add it to the existing amounts, and then average the colors
 *  To result in a new color of Paint being held in the PaintBucket. If the new averaged value for any given color is
 *  Greater than 255, it will be capped at 255.
 *
 *  The Accessor must return a Color object containing the appropriate Red, Green, and Blue values of the paint in the PaintBucket
 *  At ant given time.
 *
 */

public class PaintBucket {


    // Color of the paint in the paint bucket.
    Color color;

    // No arg constructor
    public PaintBucket(){

        // Creates a new color with RGB values 0, 0, 0. Black color to start with.
        this.color = new Color(0,0,0);

    }


    /**
     * The addPaint method is the sole mutator of the Class.
     * It receives the RGB values of a new paint being added to the PaintBucket, adds them to the current
     * Values, and then averages them to obtain the new color of Paint inside the bucket. If any RGB value is greater
     * Than 255, then it is capped at 255.
     *
     * @param color: The color being added to the paint bucket.
     */


    public void addPaint(Color color){

        // Adds the current color value to the added red value
        int currentRed = this.color.getRed();
        int currentGreen = this.color.getGreen();
        int currentBlue = this.color.getBlue();

        int addedRed = color.getRed();
        int addedGreen = color.getGreen();
        int addedBlue = color.getBlue();

        // The new color value is the average of two colors being added.
        int new_red = (currentRed + addedRed) / 2;
        int new_green = (currentGreen + addedGreen) / 2;
        int new_blue = (currentBlue + addedBlue) / 2;

        // If the new color value is greater than the allowed 255, then it is capped at 255.
        if(new_red > 255)
            new_red = 255;

        if(new_green > 255)
            new_green = 255;

        if(new_green > 255)
            new_green = 255;


        // Sets the instance variable paint colors to the new RGB values of the paint
        this.color = new Color(new_red, new_green, new_blue);

    }

    // Returns the color of the paint in the bucket
    public Color getColor(){

        // returns a new Color object of the paint in the bucket.
        return this.color;

    }


}
