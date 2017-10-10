package ExtraCredit2;

import javax.swing.*;
import java.awt.*;
/**
 * Created by Adam on 8/9/2016.
 */
public class DigitalFirePanel extends JPanel implements Runnable {

    int inc = 0;
    int timer = 0;
    String x = "";

    public DigitalFirePanel() {
        setPreferredSize(new Dimension(1920, 1080));
        setVisible(true);


        setBackground(new Color(0, 0, 0));
        setSize(1920, 1080);
        startFall();

    }


    private void startFall(){

        System.out.println("Start Fall");

        if(inc < AnimatedColorFrame.numberOfLabels){
            addNewLabel("bottom");


            inc++;
            startFall();
        }

    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setBackground(Color.BLACK);
        frame.setPreferredSize(new Dimension(875, 545));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DigitalFirePanel panel = new DigitalFirePanel();

        panel.startFall();

        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.pack();
    }

    private void addNewLabel(String position){

        Thread thread = new Thread(() -> {

            AnimationLabel label= new AnimationLabel(position);

            add(label);
            label.run();

        });
        thread.start();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(AnimatedColorFrame.backgroundColor);



      /**  String string = " Hello There...";
        if(timer / 25 < string.length()) {
            if (timer % 25 == 0) x += string.charAt(timer / 25);
        }
        g.drawString(x, getWidth() / 2, getHeight() / 2);
       **/
        timer++;
    }


    private int getRandom(int min, int max){
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    @Override
    public void run() {
        startFall();

    }
}
