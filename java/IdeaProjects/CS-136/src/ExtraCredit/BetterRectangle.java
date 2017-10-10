package ExtraCredit;

import java.awt.*;
/**
 * Created by Adam Goins
 * Extra Credit Homework
 * 2017.03.19
 *
 * The BetterRectangle class is a Sublcass to the java.awt.Rectangle class.
 * This class is designed to add the getPerimeter() and getArea() functionality to a rectangle to access
 * The perimeter and area of a rectangle.
 */
public class BetterRectangle extends Rectangle {

    /**
     * 4-arg constructor, receives the x and y coordinates to originate this Rectangle object, as well as the
     * Width and Height of the rectangle itself.
     * @param x: The x-coordinate of the origin of this rectangle.
     * @param y: The y-coordinate of the origion of this rectangle.
     * @param width: The width of the rectangle.
     * @param height: The height of the rectangle.
     */
    public BetterRectangle(int x, int y, int width, int height){

        // Calls the setLocation() method of the parent class to set the location of the rectangle to the x and y received
        super.setLocation(x, y);
        // Calls the setSize() method of the parent class to the width and height received.
        super.setSize(new Dimension(width, height));
    }

    /**
     * The getPerimeter() method returns the perimeter of the rectangle by using the P = 2*L*W formula
     * @return double: The perimeter of the rectangle.
     */
    public double getPerimeter(){
        return 2 * (super.getWidth() + super.getHeight());
    }

    /**
     * The getArea() method returns the area of the rectangle by using the A = L * W formula
     * @return double: The area of the rectangle
     */
    public double getArea(){
        return super.getWidth() * super.getHeight();
    }

}
