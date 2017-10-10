package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by root on 4/3/17.
 */
public class Tester {

    public static void main(String[] args){

        JFrame frame = new JFrame("Yo");
        frame.setPreferredSize(new Dimension(875, 545));

        MatrixPanel panel = new MatrixPanel();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
