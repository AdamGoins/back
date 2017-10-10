package ExtraCredit;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adam Goins on 3/10/17.
 * Extra Credit Homework
 * 2017.03.19
 *
 * The RectangleTester class extends JFrame to act as a canvas to test the BetterRectangle class.
 */
public class RectangleTester extends JFrame{

    /**
     * The BetterRectangle object to be drawn to the JFrame
     */
    private BetterRectangle rectangle;

    /**
     * Zero-arg constructor. Calls methods of the JFrame class to construct the frame.
     */
    public RectangleTester(){
        // Calling super() and passing into a string to the constructor of JFrame titles the frame to that string.
        super("Rectangle Tester");

        // Sets the size of the JFrame to 875 x 545 pixels
        this.setSize(new Dimension(875, 545));

        // Makes the frame close when we click the "X" on the TitleBar.
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Setting the color of the frame to black because, well, why conform to the standard?
        this.setBackground(Color.BLACK);

        // Makes the frame visible.
        this.setVisible(true);

        // Creats a new BetterRectangle object at origin 275,325 with width of 325 and height of 125
        rectangle = new BetterRectangle(275, 175, 325, 125);
    }


    /**
     * The paint() method is being overridden from the JFrame class to paint the BetterRectangle.
     * This method will paint the BetterRectangle object we created in the constructor of this class.
     * @param g: Graphics to paint onto the JFrame.
     */
    @Override
    public void paint(Graphics g){
        // Sets the color to a very nice green.
        g.setColor(new Color(125,245,0));

        // Grabbing the attributes of the BetterRectangle object we created in the constructor.
        int x = (int) rectangle.getX();
        int y = (int) rectangle.getY();
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();

        // Drawing the BetterRectangle we created in the constructor
        g.drawRect(x, y, width,height);

        // Drawing some strings at specified locations to show the width, height of the rectangle along with the area and perimeter of it.
        g.drawString("Width: " + width, x, y - 10);
        g.drawString("Height:" + height, x - 75, y + 25);
        g.drawString("Area is: " + rectangle.getArea(), x - 50, y - (height / 4)- 25);
        g.drawString("Perimeter is: " + rectangle.getPerimeter(), x - 50, y - (height / 4));
    }


    /**
     * The main method creates a new instance of this class to test it.
     * @param args: Command line arguments.
     */
    public static void main(String[] args){

        // Creates a new instance of this class to test it.
        new RectangleTester();
    }

}
