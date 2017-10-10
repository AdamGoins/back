package ExtraCredit2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adam on 8/8/2016.
 */
public class AnimationLabel extends JLabel implements Runnable {

    private String[] characters = new String[] {"\u041f", "\u4e01", "\u4e02", "\u00A2", "\u22a5", "\u3046", "1", "B", "2", "\u4E13", "\u4E43", "C", "3", "D", "4", "\u4E0A", "\u4E0B", "\u4E0D", "E", "5", "F", "\u3005", "6", "G", "\u3006", "\u4EC0", "7", "H", "8", "\u4E5E", "I", "9", "K", "L", "\u4E49", "0", "P", "Q", "R", "\u4E59", "T","V", "X", "Y", "Z", "%", "&"};

    public boolean falling = false;

    private boolean growing = false;

    // 6, 10
    int randomSize = getRandom(6, 10);

    // 41, 140
    Color randomColor;
    //3, 15
    int maxSize = getRandom(AnimatedColorFrame.minFireHeight, AnimatedColorFrame.maxFireHeight);


    int currentSize = 0;

    public AnimationLabel(String position) {

        randomColor = AnimatedColorFrame.fireColor;


        setFont(new Font("SimSun", Font.PLAIN, randomSize));
        setForeground(AnimatedColorFrame.fireColor);
        setVerticalAlignment(position.equals("top") ? TOP : BOTTOM);
        setLocation(getRandom(0, 1400), 500);
        setSize(7, 500);
    }

    private void start(){

        falling = true;

        while(falling){

            try {
                fall();
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void fall(){
        currentSize = getText().replaceAll("\\<.*?>", "").length();
        Color tipColor = AnimatedColorFrame.fireTipColor;
       // setForeground(AnimatedColorFrame.fireColor);

        if(currentSize < maxSize){
            String text = "<html>";
            char[] chars = getText().replaceAll("\\<.*?>", "").toCharArray();

            for(int i = 0; i < chars.length; i++){

                if(i == 0) text = text + "<font color=rgb(" + tipColor.getRed() + "," + tipColor.getGreen() + "," + tipColor.getBlue() + ")>";
                text = text + "<br>" + chars[i];
                if(i == 0) text = text + "</font>";
            }

            text = text  + getRandomChar() + "</html>";
            setText(text);


        }

        else {

            String text = "<html>";
            char[] chars = getText().replaceAll("\\<.*?>", "").toCharArray();

            for(int i = 1; i < chars.length; i++){


                if(i == 1) text = text + "<font color=rgb(" + tipColor.getRed() + "," + tipColor.getGreen() + "," + tipColor.getBlue() + ")>";

                text = text + "<br>" + chars[i];
                if(i == 1) text = text + "</font>";

            }

            text = text + getRandomChar() + "</html>";
            setText(text);


            if(!growing) {
                if(getRandom(0, 1000) > 950) growing = true;
            }

            if(growing){
                disperse();
            }

        }

        if(getText().length() > 2000 || getForeground().getGreen() == 0){
            setText("");
            setForeground(randomColor);
        }
    }

    private void disperse(){

        setFont(new Font("SimSun", Font.PLAIN, randomSize + 1));

        setSize(getWidth() + 1, getHeight());
     //   setLocation(getX(), getVerticalAlignment() == TOP ? getY() + 10 : getY() - 10);
        if (getForeground().getGreen() > 10 || getForeground().getRed() > 10 || getForeground().getBlue() > 10) setForeground(getForeground().darker());
        //if(getForeground().getGreen() > 10) setForeground(new Color(0, getForeground().getGreen() - 10, 0));

        else{
            randomSize = getRandom(6, 10);
            setForeground(AnimatedColorFrame.fireColor);
            maxSize = getRandom(AnimatedColorFrame.minFireHeight, AnimatedColorFrame.maxFireHeight);
            currentSize = 0;
            setText("");
            setLocation(getRandom(0, 1400), 500);
        }



    }


    private Color getRandomColor(){
        Color fireColor = AnimatedColorFrame.fireColor;
        int r = fireColor.getRed();
        int g = fireColor.getGreen();
        int b = fireColor.getBlue();

        return fireColor;

    }

    @ Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    private String getRandomChar(){
        return characters[getRandom(0, characters.length - 1)];
    }



    private int getRandom(int min, int max){
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;

    }


    @Override
    public void run() {
        start();
    }
}
