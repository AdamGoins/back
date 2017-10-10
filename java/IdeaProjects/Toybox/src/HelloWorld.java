import javax.swing.*;
import java.awt.*;

public class HelloWorld {

    public static void main(String[] args){

            JFrame frame = new JFrame("My custom frame");

            frame.setPreferredSize(new Dimension(875, 545));

            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(875, 545));

            panel.setBackground(new Color(45,45,45));

            JLabel label = new JLabel("My name is Adam!");
            label.setForeground(new Color(205, 205, 205));

            panel.add(label);

            frame.setContentPane(panel);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();

    }


}
