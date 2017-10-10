package Junk;

import javax.swing.*;
import java.awt.*;

/**
 * Adam Goins, Taylor Bruce
 * Lab 4: Car Viewer
 * 2017.02.17
 *
 * The CarViewer class will create a new JFrame to serve as the container for a CustCarComponent object
 *
 */
public class CarViewer {

    public static void main(String[] args){

        // Creates a new JFrame with the title "Car Drawer"
        JFrame frame = new JFrame("Car Drawer");

        // Sets the dimension of the JFrame to be 875 pixels wide x 545 pixels high
        frame.setMinimumSize(new Dimension(875,545));

        // Makes our JFrame close when we click the "X" button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creates a new CustomCarComponent object
        CustomCarComponent car = new CustomCarComponent();

        // Adds the car object to the JFrame
        frame.add(car);

        // Makes the frame visible.
        frame.setVisible(true);

    }
}
