package DoublyLinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Adam Goins
 * CS-136
 *
 * The DoublyLinkedList.ColorBlendFrame class inherits from JFrame and allows colors to be selected using a Jcheckbox to have blended colors
 * To be displayed in the Jpanel
 */
public class ColorBlendFrame extends JFrame {

    /**
     * Creates fields
     */
    JCheckBox redButton;
    JCheckBox greenButton;
    JCheckBox blueButton;
    JCheckBox[] boxes;

    JPanel contentPane;
    JPanel colorPanel;

    JLabel colorLabel;

    private Color[] colors;

    /**
     * Single arg constructor, calls the appropriate methods to make the frame display and do what I want.
     */
    public ColorBlendFrame(){
        super("Colorized JPanel");
        setPreferences();
        createComponents();
        addListeners();
        setAndDisplay();
    }

    /**
     * Creates the ActionListener for the checkboxes and adds it to them appropriately.
     */
    private void addListeners(){
        ActionListener listener = e -> {

            // I add all RGB values of all active colors and divide each later by how many active colors I have.
            int activeBoxes = 0;
            int red = 0;
            int green = 0;
            int blue = 0;

            // For every Checkbox
            for(JCheckBox box : boxes){

                // If that box is selective (Active) I get the color it represents and handle it appropriagely.
                if(box.isSelected()){
                    Color color = new Color(0, 0, 0);
                    switch(box.getActionCommand()){
                        case "Red":
                            color = Color.RED;
                            break;

                        case "Green":
                            color = Color.GREEN;
                            break;

                        case "Blue":
                            color = Color.BLUE;
                            break;
                    }

                    // Adds the sum of the RGB values of the color to the running total
                    red += color.getRed();
                    green += color.getGreen();
                    blue += color.getBlue();
                    activeBoxes++;
                }
            }

            // Don't want to divide by 0, so if there are active boxes then we do the rgb/total otherwise the color is just black.
            Color color = activeBoxes > 0 ? new Color(red / activeBoxes, green / activeBoxes, blue / activeBoxes) : Color.BLACK;
            colorPanel.setBackground(color);

            // Displays the RGB value of the displayed color
            colorLabel.setText("The blended RGB value is: Red: " + color.getRed() + " Green: " + color.getGreen() + " Blue: " + color.getBlue());

            // Sets the foreground using a mask so that it can be displayed.
            colorLabel.setForeground(new Color(color.getRed() | 0xFF, color.getGreen() | 0xFF, color.getBlue() | 0xFF));
        };


        // Adds the action listeners
        redButton.addActionListener(listener);
        greenButton.addActionListener(listener);
        blueButton.addActionListener(listener);

    }

    /**
     * This method sets the preferences of the JFrame that is this class to the appropriate size/close operation/ etc.
     */
    private void setPreferences(){
        this.setPreferredSize(new Dimension(875, 545));
        this.setMinimumSize(new Dimension(875, 545));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Sets the content pane and visibility of the frame and displays it.
     */
    private void setAndDisplay(){
        this.setContentPane(contentPane);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
    }

    /**
     * This method creates and initializes all components that make up this class.
     */
    private void createComponents() {
        redButton = new JCheckBox("Red");
        greenButton = new JCheckBox("Green");
        blueButton = new JCheckBox("Blue");

        // Creates an array of checkboxes that's all of the checkboxes that I have in the GUI. I use this later to loop
        // Through each to see if it's active or not, and it is we blend the colors.
        boxes = new JCheckBox[3];
        boxes[0] = redButton;
        boxes[1] = greenButton;
        boxes[2] = blueButton;

        redButton.setActionCommand("Red");
        greenButton.setActionCommand("Green");
        blueButton.setActionCommand("Blue");

        colorLabel = new JLabel("Hi I'm Mr. Sneezy!");
        colorLabel.setHorizontalAlignment(JLabel.CENTER);
        colorLabel.setForeground(new Color(50, 255, 50));
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLACK);
        colorPanel.setLayout(new BorderLayout());

        colorPanel.setSize(new Dimension(500, 545));
        colorPanel.setPreferredSize(new Dimension(500, 545));
        colorPanel.setMinimumSize(new Dimension(500, 545));
        colorPanel.add(colorLabel, BorderLayout.CENTER);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(colorPanel, BorderLayout.CENTER);

        // Creates a vbox to add the checkboxes to so they're displayed vertically
        Box vbox = Box.createVerticalBox();
        vbox.add(redButton);
        vbox.add(greenButton);
        vbox.add(blueButton);

        contentPane.add(vbox, BorderLayout.EAST);
    }

    /**
     * This method creates a new instance of this class.
     * @param args: Commandline arguments.
     */
    public static void main(String[] args){
        new ColorBlendFrame();
    }

}
