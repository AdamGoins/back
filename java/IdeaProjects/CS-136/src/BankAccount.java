import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Adam Goins
 * CS-136
 * 2016.04.24
 *
 *  The BankAccount class extends JFrame and simulates a very simple GUI interface which allows the user to depost/withdraw
 *  Money from their account by using the respective textfields / buttons.
 *
 *  The withdraw and deposit ActionListeners are invoked on both the respective textfields and jbuttons alike so that the user
 *  Can hit enter after typing in their desired amount rather than needing to click the button afterward.
 *
 *  In the event an invalid number is given into the fields, an error is thrown and a label is displayed prompting about that error.
 *  If the user tries to withdraw an amount greater than the balance the same thing happens with the appropriate message.
 */
public class BankAccount extends JFrame {

    /**
     * Fields
     */
    private JButton depositButton;
    private JButton withdrawButton;

    private JTextField depositField;
    private JTextField withdrawField;

    private JLabel balanceLabel;
    private JLabel errorLabel;

    private double balance;

    /**
     * Single argument constructor, calls the appropriate init methods and sets the balance to the balance received.
     *
     * @param balance The starting balance of the bank account
     */
    public BankAccount(double balance){
        super("Bank Account App");

        this.balance = balance;

        setDefaults();
        createComponents();
        createListeners();
        display();

    }

    /**
     * Sets the default values of my JFrame.
     */
    private void setDefaults(){
        // Creates a small window.
        setPreferredSize(new Dimension(250, 175));
        // Don't want it to be resizable.
        setResizable(false);
        // JFrame.EXIT_ON_CLOSE is deprecated, this is more proper.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Centers the window.
        setLocationRelativeTo(null);
    }

    /**
     * This method creates the components that will populate the window.
     */
    private void createComponents(){

        // The contentPane of the JFrame.
        JPanel contentPane = new JPanel();

        // Creates the buttons.
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        // Creates the textfields
        depositField = new JTextField();
        depositField.setPreferredSize(new Dimension(75, 35));
        withdrawField = new JTextField();
        withdrawField.setPreferredSize(new Dimension(75, 35));

        // Creates the JLabels
        balanceLabel = new JLabel(Double.toString(balance));
        errorLabel = new JLabel();

        // Adds the components to the window in the proper order.
        contentPane.add(errorLabel);
        contentPane.add(getHorizontalBox(depositField, depositButton));
        contentPane.add(getHorizontalBox(withdrawField, withdrawButton));
        contentPane.add(getHorizontalBox(new JLabel("Balance:"), balanceLabel));

        setContentPane(contentPane);

    }

    /**
     * this method creates the two action listeners, one of withdrawing and one for depositing, and sets them to the
     * appropriate components (Jbuttons, JTextfields)
     */
    private void createListeners(){

        // Using a lambda expression to create this action listener rather that create two anonymous classes for each place
        // we'll use it.
        ActionListener depositListener = e -> {
            // We try to parse the data in the field as a double. If we get an error, it means an invalid number was given.
            try{
                double amount = Double.parseDouble(depositField.getText());
                deposit(amount);
            } catch(NumberFormatException e1) {
                errorLabel.setText("Invalid Number Received!");
            }
        };

        // Same as above.
        ActionListener withdrawListener = e -> {

            try{
                double amount = Double.parseDouble(withdrawField.getText());
                withdraw(amount);
            } catch(NumberFormatException e1){
                System.out.println("Invalid Number Received!");
            }
        };

        // Adds the action listeners to the appropriate components.
        depositButton.addActionListener(depositListener);
        depositField.addActionListener(depositListener);

        withdrawButton.addActionListener(withdrawListener);
        withdrawField.addActionListener(withdrawListener);
    }

    /**
     * This method makes the frame visible and packs it.
     */
    private void display(){
        setVisible(true);
        pack();
    }

    /**
     * This method receives an amount to deposit in the bank account. That amount is added to the total balance,
     * The balance label is updated with the new balances value and the deposit field and errorlabel's text is set to nothing.
     *
     * @param amount The amount being deposited into the bank account
     */
    private void deposit(double amount){
        balance += amount;
        balanceLabel.setText(Double.toString(balance));
        depositField.setText("");
        errorLabel.setText("");
    }

    /**
     * This method attempts to withdraw an amount of money from the bank account. If the amount exceeds the balance,
     * The error label is set to display just that and a value of 0 is returned. Otherwise, the balance and labels are updated,
     * The field is reset to "" and the amount being withdrawn is returned simulating a withdrawal.
     *
     * @param amount The amount of money being withdrawn
     *
     * @return The amount of money being withdrawn if it's a legal amount, otherwise 0.
     */
    private double withdraw(double amount){
        if(amount > balance) {
            errorLabel.setText("Amount can't be greater than balance!");
            return 0;
        }

        else{
            balance -= amount;
            balanceLabel.setText(Double.toString(balance));
            withdrawField.setText("");
            errorLabel.setText("");

            return amount;
        }

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
     * The main method creates a new instance of this class with an initial value of 1000 for the starting balance.
     *
     * @param args Commandline arguments. There should be done.
     */
    public static void main(String[] args){
        // Creates a new instance of this class, passing in 1000 as an initial bank account value.
        new BankAccount(1000);
    }

}
