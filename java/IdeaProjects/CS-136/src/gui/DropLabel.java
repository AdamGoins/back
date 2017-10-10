package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by root on 4/3/17.
 */
public class DropLabel extends JLabel implements Runnable
{

    int green;

    public DropLabel(int verticalAlignment){

        this.setVerticalAlignment(verticalAlignment);
        this.setOpaque(false);
        this.green = 55;
        this.setForeground(new Color(0, green, 0));

    }

    @Override
    public void setText(String text){

        text = "<html><font color=rgb(205, 200, 112)>" + text + "</font></html>";
        super.setText(text);

    }

    @Override
    public void run() {

        for(int i = 0; i < 12; i++){
            setText(this.getText() + i);
        }

    }
}
