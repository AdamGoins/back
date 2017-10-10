package ExtraCredit2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adam on 4/23/2017.
 */
public class AnimatedColorFrame extends JFrame {

    private DigitalFirePanel firePanel;

    private JLabel numberOfLabelsLabel;

    public static int fallSpeed = 75;
    public static int numberOfLabels = 175;

    public static int minFireHeight = 3;
    public static int maxFireHeight = 15;

    public static Color backgroundColor = Color.BLACK;
    public static Color fireColor = new Color(0, 115, 0);
    public static Color fireTipColor = new Color(245, 245, 245);


    public AnimatedColorFrame(){
        setDefaults();
        createComponents();
        display();
    }

    private void setDefaults(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void createComponents(){
        DigitalFirePanel panel = new DigitalFirePanel();
        panel.setLayout(new BorderLayout());
        MenuPanel panel2 = new MenuPanel();
        panel2.setPreferredSize(new Dimension(400, 545));
        panel2.setMinimumSize(new Dimension(400, 545));

        panel.add(panel2, BorderLayout.EAST);
        setContentPane(panel);
    }

    private void display(){
        setVisible(true);
        pack();
    }

    public static void main(String[] args){

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIManager.put("nimbusBase", new Color(45, 45, 45));
                    UIManager.put("nimbusBlueGrey", new Color(90, 45, 90));
                    UIManager.put("control", new Color(90, 90, 90));
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        new AnimatedColorFrame();

    }

    public static void setBackgroundColor(int r, int g, int b){
        backgroundColor = new Color(r, g, b);
    }

    public static void setFireColor(int r, int g, int b){
        fireColor = new Color(r, g, b);
    }

    public static void setTipColor(int r, int g, int b){
        fireTipColor = new Color(r, g, b);
    }

}
