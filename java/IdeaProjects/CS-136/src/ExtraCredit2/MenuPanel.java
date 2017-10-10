package ExtraCredit2;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Adam on 4/23/2017.
 */
public class MenuPanel extends JPanel implements Runnable {

    private Thread animationThread;

    private boolean isExpanded;
    private boolean isAnimating;

    private Color backgroundColor;


    private JPanel innerPanel;

    private JComboBox<ColorLabel> panelColorBox;
    private JComboBox<ColorLabel> rainColorBox;
    private JComboBox<ColorLabel> rainTipColorBox;

    private JSlider numberOfLabelsSlider;
    private JSlider fallSpeedSlider;

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



    private JLabel menuLabel;
    private JLabel numberOfLabelsLabel;
    private JLabel fallSpeedlabel;





    public MenuPanel(){

        setDefaults();
        createComponents();
        createListeners();
        populateComboBoxes();

    }


    private void setDefaults(){
        setLayout(new BorderLayout());

        backgroundColor = Color.BLACK;
        setBackground(backgroundColor);

        isExpanded = true;
        isAnimating = false;

        animationThread = new Thread(this);

    }

    private void createComponents(){

        createLabels();
        createSliders();
        innerPanel = new JPanel();
        // innerPanel.setLayout(new BorderLayout());

        JLabel backgroundLabel = new JLabel("<html><b>Background</b></html>");
        backgroundLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        backgroundLabel.setHorizontalAlignment(JLabel.LEFT);
        backgroundLabel.setPreferredSize(new Dimension(375, 20));
        innerPanel.add(getHorizontalBox(backgroundLabel));

        menuLabel = new JLabel("Collapse");
        menuLabel.setForeground(Color.GREEN);


        panelColorBox = new JComboBox<>();
        panelColorBox.setPreferredSize(new Dimension(150, 20));
        innerPanel.add(getHorizontalBox("Color:", panelColorBox));
        innerPanel.add(getHorizontalBox("Red:", backgroundRSlider, backgroundRLabel));
        innerPanel.add(getHorizontalBox("Green:", backgroundGSlider, backgroundGLabel));
        innerPanel.add(getHorizontalBox("Blue:", backgroundBSlider, backgroundBLabel));

        JLabel fireColorLabel = new JLabel("<html><b>Labels</b></html>");
        fireColorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        fireColorLabel.setHorizontalAlignment(JLabel.LEFT);
        fireColorLabel.setPreferredSize(new Dimension(375, 20));
        innerPanel.add(getHorizontalBox(fireColorLabel));

        rainColorBox = new JComboBox<>();
        rainColorBox.setPreferredSize(new Dimension(150, 20));
        innerPanel.add(getHorizontalBox("Fire Color:", rainColorBox));
        innerPanel.add(getHorizontalBox("Red:", fireRSlider, fireRLabel));
        innerPanel.add(getHorizontalBox("Green:", fireGSlider, fireGLabel));
        innerPanel.add(getHorizontalBox("Blue:", fireBSlider, fireBLabel));


        JLabel fireTipLabel = new JLabel("<html><b>Fire Tip</b></html>");
        fireTipLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        fireTipLabel.setHorizontalAlignment(JLabel.LEFT);
        fireTipLabel.setPreferredSize(new Dimension(375, 20));
        innerPanel.add(getHorizontalBox(fireTipLabel));

        rainTipColorBox = new JComboBox<>();
        rainTipColorBox.setPreferredSize(new Dimension(150, 20));
        innerPanel.add(getHorizontalBox("Fire tip Color:", rainTipColorBox));
        innerPanel.add(getHorizontalBox("Red:", tipRSlider, tipRLabel));
        innerPanel.add(getHorizontalBox("Green:", tipGSlider, tipGLabel));
        innerPanel.add(getHorizontalBox("Blue:", tipBSlider, tipBLabel));


        JLabel miscLabel = new JLabel("<html><b>Misc</b></html>");
        miscLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        miscLabel.setHorizontalAlignment(JLabel.LEFT);
        miscLabel.setPreferredSize(new Dimension(375, 20));
        innerPanel.add(getHorizontalBox(miscLabel));

        numberOfLabelsSlider = new JSlider(100, 400);
        numberOfLabelsSlider.setPreferredSize(new Dimension(150, 50));
        numberOfLabelsSlider.setPaintTicks(true);
        numberOfLabelsSlider.setMajorTickSpacing(100);
        numberOfLabelsSlider.setMinorTickSpacing(25);
        numberOfLabelsSlider.setSnapToTicks(true);
        numberOfLabelsSlider.setPaintLabels(true);
        numberOfLabelsSlider.setValue(175);
        numberOfLabelsLabel = new JLabel("175");

        innerPanel.add(getHorizontalBox("Number of labels:", numberOfLabelsSlider, numberOfLabelsLabel));

        fallSpeedSlider = new JSlider(50, 150);
        fallSpeedSlider.setPreferredSize(new Dimension(150, 50));
        fallSpeedSlider.setPaintTicks(true);
        fallSpeedSlider.setMajorTickSpacing(25);
        fallSpeedSlider.setMinorTickSpacing(3);
        fallSpeedSlider.setSnapToTicks(true);
        fallSpeedSlider.setPaintLabels(true);
        fallSpeedSlider.setValue(75);
        fallSpeedlabel = new JLabel("75");

        innerPanel.add(getHorizontalBox("Fall Speed:", fallSpeedSlider, fallSpeedlabel));

        add(innerPanel);
    }

    private void createLabels(){

        backgroundRLabel = new JLabel("0");
        backgroundGLabel = new JLabel("0");
        backgroundBLabel = new JLabel("0");

        fireRLabel = new JLabel("0");
        fireGLabel = new JLabel("0");
        fireBLabel = new JLabel("0");

        tipRLabel = new JLabel("0");
        tipGLabel = new JLabel("0");
        tipBLabel = new JLabel("0");
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

    private ColorLabel getColorLabel(String colorName, Color color){
        return new ColorLabel(colorName, color);
    }

    private JSeparator getSpacer(int distance){
        return new JSeparator();
    }

    private Box getHorizontalBox(JComponent component){
        Box box = Box.createHorizontalBox();
        box.add(component);
        return box;
    }

    private Box getHorizontalBox(String labelText, JComponent component){

        Box box = Box.createHorizontalBox();
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(100, 20));
        label.setHorizontalAlignment(JLabel.LEFT);
        box.add(label);
        box.add(component);
        return box;
    }

    private Box getHorizontalBox(String labelText, JComponent component, JLabel endLabel){

        Box box = Box.createHorizontalBox();
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(75, 20));
        label.setHorizontalAlignment(JLabel.LEFT);
        endLabel.setHorizontalAlignment(JLabel.CENTER);
        endLabel.setPreferredSize(new Dimension(75, 20));
        box.add(label);
        box.add(component);
        box.add(endLabel);

        return box;
    }





    private void createListeners(){


        numberOfLabelsSlider.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            int value = source.getValue();
            numberOfLabelsLabel.setText(Integer.toString(value));
            AnimatedColorFrame.numberOfLabels = value;
        });

        fallSpeedSlider.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            int value = source.getValue();
            fallSpeedlabel.setText(Integer.toString(value));
            AnimatedColorFrame.fallSpeed = value;
        });

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

    private void populateComboBoxes(){

    }

    private void expand(){
        setVisible(true);
    }

    private void collapse(){
        setVisible(false);
    }

    /**
    public void expand(){
        if(!isAnimating) {
            isAnimating = true;

            int desiredX = getParent().getWidth() - getWidth();

            while(getX() > desiredX){
                setLocation(getX() - 1, getY());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            isAnimating = false;
        }
        isExpanded = true;
    }

    private void collapse(){
        if(!isAnimating) {
            isAnimating = true;

            while (getLocation().getX() < getParent().getWidth() - 30) {

                setLocation(getX() + 1, getY());

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            isAnimating = false;
            isExpanded = false;
        }
    }

     **/
    @Override
    public void run() {
        if(isExpanded) collapse();
        else expand();
    }

}
