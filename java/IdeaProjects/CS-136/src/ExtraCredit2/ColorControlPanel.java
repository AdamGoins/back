package ExtraCredit2;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by root on 4/26/17.
 */
public class ColorControlPanel extends JPanel {

    private Color[] colors = new Color[] {
            Color.BLACK,
            Color.BLUE,
            Color.CYAN,
            Color.DARK_GRAY,
            Color.GRAY,
            Color.GREEN,
            Color.LIGHT_GRAY,
            Color.MAGENTA,
            Color.ORANGE,
            Color.PINK,
            Color.RED,
            Color.WHITE,
            Color.YELLOW
    };

    private String[] colorNames = new String[] {
            "Black",
            "Blue",
            "Cyan",
            "Dark Gray",
            "Gray",
            "Green",
            "Light Gray",
            "Magenta",
            "Orange",
            "Pink",
            "Red",
            "White",
            "Yellow"
    };

    private JComboBox<ColorLabel> panelColorBox;
    private JComboBox<ColorLabel> rainColorBox;
    private JComboBox<ColorLabel> rainTipColorBox;

    private JSlider backgroundRSlider;
    private JSlider backgroundGSlider;
    private JSlider backgroundBSlider;

    private JSlider fireRSlider;
    private JSlider fireGSlider;
    private JSlider fireBSlider;

    private JSlider tipRSlider;
    private JSlider tipGSlider;
    private JSlider tipBSlider;

    private JLabel backgroundRLabel;
    private JLabel backgroundGLabel;
    private JLabel backgroundBLabel;

    private JLabel fireRLabel;
    private JLabel fireGLabel;
    private JLabel fireBLabel;

    private JLabel tipRLabel;
    private JLabel tipGLabel;
    private JLabel tipBLabel;

    public ColorControlPanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000, 225));
        createSliders();
        createLabels();
        createListeners();
        populateComboBoxes();
        addComponentsToPanel();
    }

    private void addComponentsToPanel(){
        Box mainContainer = Box.createHorizontalBox();
        Box backgroundBox = Box.createVerticalBox();
        Box fireBox = Box.createVerticalBox();
        Box fireTipBox = Box.createVerticalBox();

        JLabel backgroundLabel = new JLabel("<html><b>Background Color</b></html>");
        backgroundLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        backgroundLabel.setHorizontalAlignment(JLabel.LEFT);
        backgroundLabel.setPreferredSize(new Dimension(375, 20));
        backgroundBox.add(backgroundLabel);
        backgroundBox.add(getVerticalSpacer(25));

        panelColorBox = new JComboBox<>();
        panelColorBox.setMaximumSize(new Dimension(215, 20));

        backgroundBox.add(getHorizontalBox(new JLabel("Color:   "), panelColorBox));
        backgroundBox.add(getVerticalSpacer(10));
        backgroundBox.add(getHorizontalBox(getRGBLabels()[0], backgroundRSlider, backgroundRLabel));
        backgroundBox.add(getVerticalSpacer(10));
        backgroundBox.add(getHorizontalBox(getRGBLabels()[1], backgroundGSlider, backgroundGLabel));
        backgroundBox.add(getVerticalSpacer(10));
        backgroundBox.add(getHorizontalBox(getRGBLabels()[2], backgroundBSlider, backgroundBLabel));

        JLabel fireColorLabel = new JLabel("<html><b>Fire Color</b></html>");
        fireColorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        fireColorLabel.setHorizontalAlignment(JLabel.LEFT);
        fireColorLabel.setPreferredSize(new Dimension(375, 20));
        fireBox.add(fireColorLabel);
        fireBox.add(getVerticalSpacer(25));

        rainColorBox = new JComboBox<>();
        rainColorBox.setMaximumSize(new Dimension(215, 20));

        fireBox.add(getHorizontalBox(new JLabel("Color:   "), rainColorBox));
        fireBox.add(getVerticalSpacer(10));
        fireBox.add(getHorizontalBox(getRGBLabels()[0], fireRSlider, fireRLabel));
        fireBox.add(getVerticalSpacer(10));
        fireBox.add(getHorizontalBox(getRGBLabels()[1], fireGSlider, fireGLabel));
        fireBox.add(getVerticalSpacer(10));
        fireBox.add(getHorizontalBox(getRGBLabels()[2], fireBSlider, fireBLabel));


        JLabel fireTipLabel = new JLabel("<html><b>Fire Tip Color</b></html>");
        fireTipLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        fireTipLabel.setHorizontalAlignment(JLabel.LEFT);
        fireTipLabel.setPreferredSize(new Dimension(375, 20));
        fireTipBox.add(fireTipLabel);
        fireTipBox.add(getVerticalSpacer(25));

        rainTipColorBox = new JComboBox<>();
        rainTipColorBox.setMaximumSize(new Dimension(215, 20));
        fireTipBox.add(getHorizontalBox(new JLabel("Color:   "), rainTipColorBox));
        fireTipBox.add(getVerticalSpacer(10));
        fireTipBox.add(getHorizontalBox(getRGBLabels()[0], tipRSlider, tipRLabel));
        fireTipBox.add(getVerticalSpacer(10));
        fireTipBox.add(getHorizontalBox(getRGBLabels()[1], tipGSlider, tipGLabel));
        fireTipBox.add(getVerticalSpacer(10));
        fireTipBox.add(getHorizontalBox(getRGBLabels()[2], tipBSlider, tipBLabel));

        mainContainer.add(backgroundBox);
        mainContainer.add(getHorizontalSpacer(25));
        mainContainer.add(fireBox);
        mainContainer.add(getHorizontalSpacer(25));
        mainContainer.add(fireTipBox);

        add(mainContainer);
    }

    private JLabel[] getRGBLabels(){

        JLabel redLabel = new JLabel("Red:");
        redLabel.setPreferredSize(new Dimension(50, 35));
        JLabel greenLabel = new JLabel("Green:");
        greenLabel.setPreferredSize(new Dimension(50, 35));
        JLabel blueLabel = new JLabel("Blue:");
        blueLabel.setPreferredSize(new Dimension(50, 35));

        return new JLabel[] {redLabel, greenLabel, blueLabel};

    }

    private Component getHorizontalSpacer(int width){
        return Box.createHorizontalStrut(width);

    }
    private Component getVerticalSpacer(int height){
        return Box.createVerticalStrut(height);

    }

    private Box getHorizontalBox(JComponent leftComponent, JComponent rightComponent){
        Box box = Box.createHorizontalBox();
        box.add(leftComponent);
        box.add(rightComponent);
        return box;
    }

    private Box getHorizontalBox(JComponent leftComponent, JComponent middleComponent, JComponent rightComponent){
        middleComponent.setSize(new Dimension(75, 50));

        Box box = Box.createHorizontalBox();
        box.add(leftComponent);
        box.add(middleComponent);
        box.add(rightComponent);
        return box;
    }


    private void createSliders(){

        backgroundRSlider = new JSlider(0, 255);
        backgroundRSlider.setValue(0);
        backgroundRSlider.setSnapToTicks(true);
        backgroundRSlider.setPaintLabels(true);
        backgroundRSlider.setPaintTicks(true);
        backgroundRSlider.setMajorTickSpacing(50);
        backgroundRSlider.setMinorTickSpacing(5);

        backgroundGSlider = new JSlider(0, 255);
        backgroundGSlider.setValue(0);
        backgroundGSlider.setSnapToTicks(true);
        backgroundGSlider.setPaintLabels(true);
        backgroundGSlider.setPaintTicks(true);
        backgroundGSlider.setMajorTickSpacing(50);
        backgroundGSlider.setMinorTickSpacing(5);

        backgroundBSlider = new JSlider(0, 255);
        backgroundBSlider.setValue(0);
        backgroundBSlider.setSnapToTicks(true);
        backgroundBSlider.setPaintLabels(true);
        backgroundBSlider.setPaintTicks(true);
        backgroundBSlider.setMajorTickSpacing(50);
        backgroundBSlider.setMinorTickSpacing(5);


        fireRSlider = new JSlider(0, 255);
        fireRSlider.setValue(0);
        fireRSlider.setSnapToTicks(true);
        fireRSlider.setPaintLabels(true);
        fireRSlider.setPaintTicks(true);
        fireRSlider.setMajorTickSpacing(50);
        fireRSlider.setMinorTickSpacing(5);


        fireGSlider = new JSlider(0, 255);
        fireGSlider.setValue(0);
        fireGSlider.setSnapToTicks(true);
        fireGSlider.setPaintLabels(true);
        fireGSlider.setPaintTicks(true);
        fireGSlider.setMajorTickSpacing(50);
        fireGSlider.setMinorTickSpacing(5);


        fireBSlider = new JSlider(0, 255);
        fireBSlider.setValue(0);
        fireBSlider.setSnapToTicks(true);
        fireBSlider.setPaintLabels(true);
        fireBSlider.setPaintTicks(true);
        fireBSlider.setMajorTickSpacing(50);
        fireBSlider.setMinorTickSpacing(5);



        tipRSlider = new JSlider(0, 255);
        tipRSlider.setValue(0);
        tipRSlider.setSnapToTicks(true);
        tipRSlider.setPaintLabels(true);
        tipRSlider.setPaintTicks(true);
        tipRSlider.setMajorTickSpacing(50);
        tipRSlider.setMinorTickSpacing(5);


        tipGSlider = new JSlider(0, 255);
        tipGSlider.setValue(0);
        tipGSlider.setSnapToTicks(true);
        tipGSlider.setPaintLabels(true);
        tipGSlider.setPaintTicks(true);
        tipGSlider.setMajorTickSpacing(50);
        tipGSlider.setMinorTickSpacing(5);


        tipBSlider = new JSlider(0, 255);
        tipBSlider.setValue(0);
        tipBSlider.setSnapToTicks(true);
        tipBSlider.setPaintLabels(true);
        tipBSlider.setPaintTicks(true);
        tipBSlider.setMajorTickSpacing(50);
        tipBSlider.setMinorTickSpacing(5);


    }

    private void populateComboBoxes(){
        JComboBox[] boxes = new JComboBox[] {panelColorBox, rainColorBox, rainTipColorBox};

        for(int i = 0; i < colorNames.length; i++){
            ColorLabel label = new ColorLabel(colorNames[i], colors[i]);
            for(JComboBox box : boxes){
                System.out.println(i);
                box.addItem(label);
            }
        }
    }
    private void createLabels(){

        backgroundRLabel = new JLabel("0");
        backgroundRLabel.setPreferredSize(new Dimension(40, 35));
        backgroundRLabel.setHorizontalAlignment(JLabel.CENTER);
        backgroundGLabel = new JLabel("0");
        backgroundGLabel.setPreferredSize(new Dimension(40, 35));
        backgroundGLabel.setHorizontalAlignment(JLabel.CENTER);
        backgroundBLabel = new JLabel("0");
        backgroundBLabel.setPreferredSize(new Dimension(40, 35));
        backgroundBLabel.setHorizontalAlignment(JLabel.CENTER);

        fireRLabel = new JLabel("0");
        fireRLabel.setPreferredSize(new Dimension(35, 35));
        fireRLabel.setHorizontalAlignment(JLabel.CENTER);
        fireGLabel = new JLabel("0");
        fireGLabel.setPreferredSize(new Dimension(35, 35));
        fireGLabel.setHorizontalAlignment(JLabel.CENTER);
        fireBLabel = new JLabel("0");
        fireBLabel.setPreferredSize(new Dimension(35, 35));
        fireBLabel.setHorizontalAlignment(JLabel.CENTER);

        tipRLabel = new JLabel("0");
        tipRLabel.setPreferredSize(new Dimension(40, 35));
        tipRLabel.setHorizontalAlignment(JLabel.CENTER);
        tipGLabel = new JLabel("0");
        tipGLabel.setPreferredSize(new Dimension(40, 35));
        tipGLabel.setHorizontalAlignment(JLabel.CENTER);
        tipBLabel = new JLabel("0");
        tipBLabel.setPreferredSize(new Dimension(40, 35));
        tipBLabel.setHorizontalAlignment(JLabel.CENTER);

    }

    private void createListeners(){

        ChangeListener backgroundColorSliderListener = e -> {


            int r = backgroundRSlider.getValue();
            int g = backgroundGSlider.getValue();
            int b = backgroundBSlider.getValue();

            AnimatedColorFrame.setBackgroundColor(r, g, b);

            backgroundRLabel.setText(Integer.toString(r));
            backgroundGLabel.setText(Integer.toString(g));
            backgroundBLabel.setText(Integer.toString(b));

        };

        ChangeListener fireColorSliderListener = e -> {


            int r = fireRSlider.getValue();
            int g = fireGSlider.getValue();
            int b = fireBSlider.getValue();

            AnimatedColorFrame.setFireColor(r, g, b);

            fireRLabel.setText(Integer.toString(r));
            fireGLabel.setText(Integer.toString(g));
            fireBLabel.setText(Integer.toString(b));

        };

        ChangeListener tipColorSliderListener = e -> {


            int r = tipRSlider.getValue();
            int g = tipGSlider.getValue();
            int b = tipBSlider.getValue();

            AnimatedColorFrame.setTipColor(r, g, b);

            tipRLabel.setText(Integer.toString(r));
            tipGLabel.setText(Integer.toString(g));
            tipBLabel.setText(Integer.toString(b));

        };


        backgroundRSlider.addChangeListener(backgroundColorSliderListener);
        backgroundGSlider.addChangeListener(backgroundColorSliderListener);
        backgroundBSlider.addChangeListener(backgroundColorSliderListener);

        fireRSlider.addChangeListener(fireColorSliderListener);
        fireGSlider.addChangeListener(fireColorSliderListener);
        fireBSlider.addChangeListener(fireColorSliderListener);

        tipRSlider.addChangeListener(tipColorSliderListener);
        tipGSlider.addChangeListener(tipColorSliderListener);
        tipBSlider.addChangeListener(tipColorSliderListener);





        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Thread((MenuPanel) e.getSource()).start();
            }

        });

    }


    public static void main(String[] args){
        JFrame frame = new JFrame("Yo");
        ColorControlPanel panel = new ColorControlPanel();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }


}
