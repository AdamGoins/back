package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Adam on 8/9/2016.
 */
public class DigitalFirePanel extends JPanel implements Runnable {

    int inc = 0;
    ArrayList<RainLabel> labels = new ArrayList<>();

    public DigitalFirePanel() {
        setPreferredSize(new Dimension(875, 545));
        setVisible(true);

        setLayout(null);
        System.out.println("Created");

        setBackground(new Color(0, 0, 0));
        setSize(875, 545);
        startFall();

    }


    private void startFall(){

        if(inc < 300){

                int randomChance = getRandom(1, 100);

              //  if(randomChance % 10 != 1){
                    addNewLabel((int) Component.TOP_ALIGNMENT);
                //   if(randomChance % 5 != 1){
                   //     addNewLabel("bottom");
                //    }
             //   }


                inc++;
            startFall();
        }

    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Yo");
        frame.setPreferredSize(new Dimension(875, 545));

        DigitalFirePanel panel = new DigitalFirePanel();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    @Override
    public void paintComponent(Graphics g){
        for(RainLabel label : labels){
            label.draw(g);
        }
    }

    private void addNewLabel(int position){

            RainLabel label = new RainLabel(new Random().nextInt(875), new Random().nextInt(545));
            labels.add(label);

    }


    private int getRandom(int min, int max){
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    @Override
    public void run() {

        System.out.println("Run");
        startFall();

    }
}
