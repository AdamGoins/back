package ExtraCredit2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adam on 4/23/2017.
 */
public class ColorLabel extends JLabel {

    private String text;
    private Color color;

    public ColorLabel(String text, Color color){
        this.text = text;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String toString(){
        return text;
    }

}
