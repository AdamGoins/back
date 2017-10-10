package Junk;

import javax.swing.*;
import java.awt.*;

/**
 *  Adam Goins, Taylor Bruce
 *  Lab 4: CustomCarComponent
 *  2017.02.17
 *
 *  The CustomCarComponent class has one field, which is a Junk.PaintBucket object created upon instantiation of this class.
 *  This Component draws a defined number of cars on its canvas and can be viewed by adding this class to a child
 *  of the JContainer class.
 *
 */

public class CustomCarComponent extends JComponent{


    // Junk.PaintBucket object which contains the Color our "cars" are supposed to be painted in.
    PaintBucket paintBucket;

    public CustomCarComponent(){

        // Instantiates new instance of the Junk.PaintBucket class.
        this.paintBucket = new PaintBucket();

    }

    /**
     * The paintComponent method is being overriden from the JComponent Class
     *
     * @param g: The Graphics object received by this method.
     */
    @Override
    public void paintComponent(Graphics g){

        // Casts the Graphics object "g" as the Graphcis2D object "g2d"
        Graphics2D g2d = (Graphics2D) g;

        // Adds a the Color.GREEN color to the paint bucket
        paintBucket.addPaint(Color.GREEN);


        // Creates a new CustomCar object with given x, y, length, frontWheelSize, rearWheelSize, and paintColor arguments
        CustomCar car = new CustomCar(20, 20, 80, 30,7, paintBucket.getColor());

        // Adds the Color.RED color to the paint bucket
        paintBucket.addPaint(Color.RED);

        // Creates a new CustomCar object, with different paint color than the first car object.
        CustomCar car2 = new CustomCar(50, 200, 50, 40,55, paintBucket.getColor());

        // calls the "draw(Graphics2D g2d)" method of the CustomCar object to draw the car into this component.
        car.draw(g2d);
        car2.draw(g2d);
    }
}
