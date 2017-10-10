package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by root on 4/3/17.
 */
public class RainLabel extends JComponent {

    String[] message = new String[] {"\u041f", "\u4e01", "\u4e02", "\u00A2", "\u22a5", "\u3046", "1", "B", "2", "\u4E13", "\u4E43", "C", "3", "D", "4", "\u4E0A", "\u4E0B", "\u4E0D", "E", "5", "F", "\u3005", "6", "G", "\u3006", "\u4EC0", "7", "H", "8", "\u4E5E", "I", "9", "K", "L", "\u4E49", "0", "P", "Q", "R", "\u4E59", "T","V", "X", "Y", "Z", "%", "&"};

    private String text;

    int xPos;
    int yPos;

    Color color;
    Color white;

    int iteration;

    public void addCharacter(){
        this.text += getRandomLetter();
    }

    public void draw(Graphics g) {

        addCharacter();

        color.darker();
        white.darker();

        int yOffset = 0;
        g.setColor(color);


        for (int i = 0; i < text.length() - 1; i++) {

            yOffset = (5 * i) + (iteration * 50);
            g.drawString(text.charAt(i) + "", this.xPos, yOffset);

        }

        g.setColor(white);

        g.drawString(text.charAt(text.length()) + "", this.xPos, yOffset + 5);


        iteration++;
    }

    public RainLabel(){
        this.xPos = new Random().nextInt(1920);
        this.yPos = new Random().nextInt(1080);
        this.color = new Color(0, 120, 0);
        this.white = Color.WHITE;
        this.iteration = 0;
    }

    public String getRandomLetter(){
        return message[new Random().nextInt(message.length)];
    }

    public RainLabel(int x, int y){
        this.xPos = x;
        this.yPos = y;
        this.color = new Color(0, 120, 0);
        this.white = Color.WHITE;
        this.iteration = 0;
    }

}
