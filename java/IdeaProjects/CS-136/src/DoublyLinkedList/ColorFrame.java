package DoublyLinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Adam Goins
 * CS-136
 *
 * The DoublyLinkedList.ColorFrame class extends JFrame and uses two panels with 3 buttons to display color based on which button is clicked.
 */
public class ColorFrame extends JFrame {

    /**
     * Creates the fields
     */
    JRadioButton redButton;
    JRadioButton greenButton;
    JRadioButton blueButton;

    JPanel contentPane;
    JPanel colorPanel;

    JLabel colorLabel;


    /**
     * Single arg constructor, calls the appropriate methods to make the frame display and do what I want.
     */
    public ColorFrame(){
        super("Colorized JPanel");
        setPreferences();
        createComponents();
        addListeners();
        setAndDisplay();

    }

    /**
     * Creates the ActionListener that controls what the buttons do when they're clicked. Adds that listener
     * To each button.
     */
    private void addListeners(){
        ActionListener listener = e -> {
            // Gets the source of the ActionEvent
            JRadioButton button = (JRadioButton) e.getSource();

            // Controls the color based on which button was clicked
            switch(button.getActionCommand()){
                case "Red":
                    colorPanel.setBackground(Color.RED);
                    colorLabel.setText("Wubba Lubba Dub Dub!");
                    colorLabel.setForeground(Color.BLUE);
                    break;

                case "Green":
                    colorPanel.setBackground(Color.GREEN);
                    colorLabel.setText("Get up on out of here with my eye-holes!");
                    colorLabel.setForeground(Color.BLACK);
                    break;

                case "Blue":
                    colorPanel.setBackground(Color.BLUE);
                    colorLabel.setText("What are you worried about? Come get fake-doors!");
                    colorLabel.setForeground(Color.RED);
                    break;
            }
        };

        // Adds the listeners
        redButton.addActionListener(listener);
        greenButton.addActionListener(listener);
        blueButton.addActionListener(listener);

    }

    /**
     * This method sets the preferences of the JFrame object that is this class
     */
    private void setPreferences(){
        this.setPreferredSize(new Dimension(875, 545));
        this.setMinimumSize(new Dimension(875, 545));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * This method sets the content pane of the JFrame and makes it visible.
     */
    private void setAndDisplay(){
        this.setContentPane(contentPane);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
    }

    /**
     * This method initializes all components required of this class
     *
     */
    private void createComponents() {
        redButton = new JRadioButton("Red");
        greenButton = new JRadioButton("Green");
        blueButton = new JRadioButton("Blue");

        redButton.setActionCommand("Red");
        greenButton.setActionCommand("Green");
        blueButton.setActionCommand("Blue");

        // Button group so that only one button can be active
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(greenButton);
        buttonGroup.add(blueButton);

        // Rick and Morty references begin here.
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

        // Creates a vertical box to add the radio buttons in.
        Box vbox = Box.createVerticalBox();
        vbox.add(redButton);
        vbox.add(greenButton);
        vbox.add(blueButton);

        contentPane.add(vbox, BorderLayout.EAST);
    }

    /**
     * The main method instantiates a new instance of this class.
     * @param args: Command line arguments
     */
    public static void main(String[] args){

        // Creates a new instance of this class
        new ColorFrame();
    }

}
