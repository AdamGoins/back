package temp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Goins on 9/12/2016.
 */
public class BootLoaderGUI extends JFrame {
    private JTextArea namesTextArea;
    private JTextArea pointsTextArea;
    private JTextArea numbersTextArea;
    private JPanel mainPanel;
    private JButton executeButton;

    public BootLoaderGUI(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(875, 545));
        setContentPane(mainPanel);
        setVisible(true);
        pack();

        executeButton.addActionListener(ActionEvent ->{

            execute();

        });
    }

    private void execute(){

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> points = new ArrayList<>();

        String[] tempNames = namesTextArea.getText().split("\n");
        String[] tempNumbers = numbersTextArea.getText().split("\n");
        String[] tempPoints = pointsTextArea.getText().split("\n");

        for(int i = 0; i < tempNames.length; i++){

            names.add(tempNames[i]);
            numbers.add(tempNumbers[i]);
            points.add(tempPoints[i]);

        }


        new BootLoader().createDatabase(names, numbers, points);


    }

    public static void main(String[] args){


        new BootLoaderGUI();





    }





}
