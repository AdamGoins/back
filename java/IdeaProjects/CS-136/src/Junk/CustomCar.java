package Junk;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Adam Goins, Taylor Bruce
 * Lab 4: CustomCar
 * 2017.02.17
 *
 * The CustomCar Class is designed to be the graphics representing a 2-Dimensional car.
 * The x and y coordinates are given, as well as tiresize and body length to draw an appropriate sized car.
 *
 */

public class CustomCar{

  // The x and y coordinates of where to draw the Graphics2D object
  private int x;
  private int y;

  // The Bodylength of the vehicle
  private int length;

  // Front tire size
  private int frontWheelSize;

  // Read tire size
  private int rearWheelSize;

  // The color to draw the vehicle
  private Color color;


  /**
   * The Constructor of the CustomCar object receives the appropriate values of how to draw the car
   * @param x: X-Coordinate of where to start drawing
   * @param y: Y-Coordinate of where to start drawing
   * @param length: Length of the vehicle
   * @param frontWheelSize: Size of the front wheel
   * @param rearWheelSize:  Size of the rear wheel
   * @param color: Color of the vehicle
   */
  public CustomCar(int x, int y, int length, int  frontWheelSize, int rearWheelSize, Color color){
      this.x = x;
      this.y = y;
      this.length = length;
      this.frontWheelSize = frontWheelSize;
      this.rearWheelSize = rearWheelSize;
      this.color = color;

    }

    /**
     * The Draw method receives a Graphics2D object of whichever class is using this car to draw.
     * It receives that Graphics2D object and draws all shapes necessary to construct a car object using the coordinates,
     * Color, and Bodylength attributes given to it upon creation.
     *
     * @param g2d: The Graphcis2D object the accessor will be using to draw the shapes.
     */

  public void draw(Graphics2D g2d){

      // Sets the color we will be drawing with
      g2d.setColor(this.color);

      // Rectangle will act as the body of the car
      Rectangle rectangle = new Rectangle(this.x, this.y + 20, 80 + this.length, 20);

      // Bottom left point of the windshield
      Point2D.Double point1 = new Point2D.Double(this.x + 20, this.y + 20);
      // Top left point of the windshield
      Point2D.Double point2 = new Point2D.Double(this.x + 40, this.y);

      // Top right point of the windshield
      Point2D.Double point3 = new Point2D.Double(this.x + 40 + this.length, this.y);

      // Bottom right point of the windshield
      Point2D.Double point4 = new Point2D.Double(this.x + 60 + this.length, this.y + 20);

      // The left line of the windshield
      Line2D.Double frontWind = new Line2D.Double(point1, point2);

      // The roof of the vehicle
      Line2D.Double topWind = new Line2D.Double(point2, point3);

      // the Right line of the windshield
      Line2D.Double rearWind = new Line2D.Double(point3, point4);


      // Draws the lines of the windshield and roof
      g2d.draw(frontWind);
      g2d.draw(topWind);
      g2d.draw(rearWind);

      // Draws the body and fills it with the color of the Graphics2D object
      g2d.fill(rectangle);

      // The front tire
      Ellipse2D.Double frontTire = new Ellipse2D.Double(this. x + (20 - (this.rearWheelSize / 2)), this.y + (40 - (this.rearWheelSize / 2)), this.rearWheelSize, this.rearWheelSize);

      // The rear tire
      Ellipse2D.Double rearTire  = new Ellipse2D.Double(this. x + (60 + this.length  - (this.frontWheelSize / 2)), this.y + (40  - (this.frontWheelSize / 2)), this.frontWheelSize, this.frontWheelSize);

      // Sets the color to black because wheels are always black
      g2d.setColor(Color.BLACK);

      // Draws and fills the ellipse shape for the tires
      g2d.fill(frontTire);
      g2d.fill(rearTire);

  }

}
