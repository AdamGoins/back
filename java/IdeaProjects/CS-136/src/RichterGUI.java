import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Adam Goins
 * CS-136
 * 2017.04.24
 *
 * The RichterGUI class extends JFrame and simulates a richter scale value reader.
 * A Text field is displayed which allows users to input a richter scale reading and displays an appropriate message
 * With respect to that richter reading.
 *
 * If a value greater than 8 is given, I display custom output because output in that event isn't explicitly given.\
 * If invalid output is given (Through catching a NumberFormatException by trying to convert the richter reading to a double),
 * An error message is displayed through the info label.
 */
public class RichterGUI extends JFrame {

    /**
     * Fields.
     */
    private JButton actionButton;

    private JLabel infoLabel;

    private JTextField inputField;

    /**
     * Zero argument constructor, calls the appropriate init methods and sets the title of the window to "Richter Scale"
     */
    public RichterGUI(){
        super("Richter Scale");

        setDefaults();
        createComponents();
        createListeners();
        display();

    }

    /**
     * Sets the default values of this window.
     */
    private void setDefaults(){
        // When coding in swing I always use 875 x 545, not sure why.
        setPreferredSize(new Dimension(875, 545));
        // I hate dealing with resizable frames. They're a mess.
        setResizable(false);
        // JFrame.EXIT_ON_CLOSE is deprecated, this is more proper.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Centers the window on the screen.
        setLocationRelativeTo(null);
    }

    /**
     * This method will create the components that will populate the JFrame.
     */
    private void createComponents(){

        // The content pane of the JFrame.
        JPanel contentPane = new JPanel();

        // (Button to Richtify the scale [read the input])
        actionButton = new JButton("Beam me up Scotty");
        infoLabel = new JLabel();
        inputField = new JTextField();

        // just settin' some ol' sizes.
        inputField.setPreferredSize(new Dimension(50, 35));
        inputField.setMaximumSize(new Dimension(50, 35));

        // Adds components to the contentPane.
        contentPane.add(getHorizontalBox(new JLabel("Richter Reading:"), inputField));
        contentPane.add(actionButton);
        contentPane.add(infoLabel);

        setContentPane(contentPane);
    }

    /**
     * This method creates the ActionListener that is placed on the button and textfield that reads the richter scale reading
     * And sets the infoLabel to display the appropriate output.
     */
    private void createListeners(){
        // Using a lambda expression rather than creating an anonymous class because we'll be adding this ActionListener
        // On both the button and input field.
        ActionListener displayListener = e -> {

            // Tries converting the richter reading into a double so that we can check the range to display the appropriate output.
            // If an invalid number is given (characters for example) then we get a NumberFormatException. We catch this exception
            // And display the appropriate error message as "Invalid Input Given"
            try{
                double richterValue = Double.parseDouble(inputField.getText());

                if(richterValue <= 4.5) infoLabel.setText("Damage to poorly constructed buildings");
                else if(richterValue <= 6) infoLabel.setText("Many buildings considerably damaged, some collapse.");
                else if(richterValue <= 7) infoLabel.setText("Many buildings destroyed");
                else if(richterValue <= 8) infoLabel.setText("Most structures fall to the power of the earthquake");
                // This is always the correct response to an earthquake above an 8.0 on the Ricther Scale.
                else infoLabel.setText("Get Schwifty with it.");
                inputField.setText("");

            } catch(NumberFormatException e1) {
                infoLabel.setText("Invalid input given");
                inputField.setText("");
            }
        };

        // Adds the listener to the components.
        actionButton.addActionListener(displayListener);
        inputField.addActionListener(displayListener);
    }

    /**
     * This method sets the frame to visible and packs it.
     */
    private void display(){
        setVisible(true);
        pack();
    }

    /**
     * This is a helper method that creates a horizontal box to place components in adjacent juxtaposition to eachother
     * So that they're added on the same axis when added to a container.
     *
     * @param first The component on the left side
     * @param second The component on the right side
     *
     * @return A Horizontal box containing the two components in correct juxtaposition
     */
    private Box getHorizontalBox(JComponent first, JComponent second){
        Box box = Box.createHorizontalBox();
        box.add(first);
        box.add(second);

        return box;
    }

    /**
     * The main method creates a new instance of this class.
     *
     * @param args Commandline arguments.
     */
    public static void main(String[] args){
        new RichterGUI();
    }

}
