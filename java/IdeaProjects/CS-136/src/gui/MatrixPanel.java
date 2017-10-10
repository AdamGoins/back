package gui;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author Adam
 */
public class MatrixPanel extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form MatrixPanel
     */


    int threadCount = 0;

    private JTextArea[] columnsArray = new JTextArea[46];
    private JLabel[] whiteArray = new JLabel[46];

    private JLabel white1;
    private JLabel white2;
    private JLabel white3;
    private JLabel white4;
    private JLabel white5;
    private JLabel white6;
    private JLabel white7;
    private JLabel white8;
    private JLabel white9;
    private JLabel white10;
    private JLabel white11;
    private JLabel white12;
    private JLabel white13;
    private JLabel white14;
    private JLabel white15;
    private JLabel white16;
    private JLabel white17;
    private JLabel white18;
    private JLabel white19;
    private JLabel white20;
    private JLabel white21;
    private JLabel white22;
    private JLabel white23;
    private JLabel white24;
    private JLabel white25;
    private JLabel white26;
    private JLabel white27;
    private JLabel white28;
    private JLabel white29;
    private JLabel white30;
    private JLabel white31;
    private JLabel white32;
    private JLabel white33;
    private JLabel white34;
    private JLabel white35;
    private JLabel white36;
    private JLabel white37;
    private JLabel white38;
    private JLabel white39;
    private JLabel white40;
    private JLabel white41;
    private JLabel white42;
    private JLabel white43;
    private JLabel white44;
    private JLabel white45;
    private JLabel white46;


    String[] message = new String[] {"\u041f", "\u4e01", "\u4e02", "\u00A2", "\u22a5", "\u3046", "1", "B", "2", "\u4E13", "\u4E43", "C", "3", "D", "4", "\u4E0A", "\u4E0B", "\u4E0D", "E", "5", "F", "\u3005", "6", "G", "\u3006", "\u4EC0", "7", "H", "8", "\u4E5E", "I", "9", "K", "L", "\u4E49", "0", "P", "Q", "R", "\u4E59", "T","V", "X", "Y", "Z", "%", "&"};
    private int[] activeThreads = new int[50];

    Timer fallTimer = null;
    Timer startTimer = null;

    public MatrixPanel(){
        initComponents();

        columnsArray[0] = column1;
        columnsArray[1] = column2;
        columnsArray[2] = column3;
        columnsArray[3] = column4;
        columnsArray[4] = column5;
        columnsArray[5] = column6;
        columnsArray[6] = column7;
        columnsArray[7] = column8;
        columnsArray[8] = column9;
        columnsArray[9] = column10;
        columnsArray[10] = column11;
        columnsArray[11] = column12;
        columnsArray[12] = column13;
        columnsArray[13] = column14;
        columnsArray[14] = column15;
        columnsArray[15] = column16;
        columnsArray[16] = column17;
        columnsArray[17] = column18;
        columnsArray[18] = column19;
        columnsArray[19] = column20;
        columnsArray[20] = column21;
        columnsArray[21] = column22;
        columnsArray[22] = column23;
        columnsArray[23] = column24;
        columnsArray[24] = column25;
        columnsArray[25] = column26;
        columnsArray[26] = column27;
        columnsArray[27] = column28;
        columnsArray[28] = column29;
        columnsArray[29] = column30;
        columnsArray[30] = column31;
        columnsArray[31] = column32;
        columnsArray[32] = column33;
        columnsArray[33] = column34;
        columnsArray[34] = column35;
        columnsArray[35] = column36;
        columnsArray[36] = column37;
        columnsArray[37] = column38;
        columnsArray[38] = column39;
        columnsArray[39] = column40;
        columnsArray[40] = column41;
        columnsArray[41] = column42;
        columnsArray[42] = column43;
        columnsArray[43] = column44;
        columnsArray[44] = column45;
        columnsArray[45] = column46;

        whiteArray[0] = white1;
        whiteArray[1] = white2;
        whiteArray[2] = white3;
        whiteArray[3] = white4;
        whiteArray[4] = white5;
        whiteArray[5] = white6;
        whiteArray[6] = white7;
        whiteArray[7] = white8;
        whiteArray[8] = white9;
        whiteArray[9] = white10;
        whiteArray[10] = white11;
        whiteArray[11] = white12;
        whiteArray[12] = white13;
        whiteArray[13] = white14;
        whiteArray[14] = white15;
        whiteArray[15] = white16;
        whiteArray[16] = white17;
        whiteArray[17] = white18;
        whiteArray[18] = white19;
        whiteArray[19] = white20;
        whiteArray[20] = white21;
        whiteArray[21] = white22;
        whiteArray[22] = white23;
        whiteArray[23] = white24;
        whiteArray[24] = white25;
        whiteArray[25] = white26;
        whiteArray[26] = white27;
        whiteArray[27] = white28;
        whiteArray[28] = white29;
        whiteArray[29] = white30;
        whiteArray[30] = white31;
        whiteArray[31] = white32;
        whiteArray[32] = white33;
        whiteArray[33] = white34;
        whiteArray[34] = white35;
        whiteArray[35] = white36;
        whiteArray[36] = white37;
        whiteArray[37] = white38;
        whiteArray[38] = white39;
        whiteArray[39] = white40;
        whiteArray[40] = white41;
        whiteArray[41] = white42;
        whiteArray[42] = white43;
        whiteArray[43] = white44;
        whiteArray[44] = white45;
        whiteArray[45] = white46;

        for(int i = 0; i <columnsArray.length; i++){
            whiteArray[i].setForeground(Color.WHITE);
            columnsArray[i].setEditable(false);
            columnsArray[i].add(whiteArray[i]);
        }



        start();


    }

    private void start(){
        ActionListener append = ActionEvent -> {
            int randomChance = (int) (Math.random() * 100);
            if (randomChance % 10 != 1) {
                int random = (int) (Math.random() * whiteArray.length);
                String[] stuff = new String[columnsArray.length];

                while(Arrays.toString(stuff).contains(Integer.toString(random))){
                    random = (int) (Math.random() * columnsArray.length);
                }
                if(columnsArray[random].getText().equals("") && threadCount < columnsArray.length) {
                    activeThreads[threadCount] = random;
                    fall(columnsArray[random], whiteArray[random]);
                    threadCount++;
                }
                //Thread thread = new Thread(this);
                //thread.run();
            }
        };
        startTimer = new Timer(350, append);
        startTimer.start();
    }

    private void fall(JTextArea column, JLabel white){
        ArrayList<String> characters = new ArrayList<>();
        ArrayList<String> spaces = new ArrayList<>();
        int randomSize = (int) (Math.random() * 6 + 10);
        int randomColor = (int) (Math.random() * 41 + 17);
        column.setForeground(new Color(0, randomColor, 0));
        white.setForeground(Color.WHITE);

        int randomString = (int) (Math.random() * 16 + 30);
        column.setFont(new Font("SimSun", Font.PLAIN, randomSize));
        white.setFont(new Font("SimSun", Font.PLAIN, randomSize));

        ActionListener append = ActionEvent -> {

            String randomChar = message[(int) (Math.random() * message.length)];

            if (characters.size() < randomString) {
                characters.add(randomChar);
                column.setText("");
                for(String character : characters){
                    column.append("\n" + character );

                }
                String oldText = white.getText().replaceAll("<html><br>", "");
                String newText = randomChar;
                white.setText("<html>" + "<br>" + white.getText().replace(oldText, newText));
                int randomChance = (int) (Math.random() * 100);
                if (randomChance % 2 == 1) {
                    int randomChanges = (int) (Math.random() * 7);
                    for(int i = 0; i < randomChanges; i++) {
                        String randomCharacter = message[(int) (Math.random() * message.length)];
                        characters.set((int) (Math.random() * characters.size()), randomCharacter);
                    }
                }

            }

            else if(characters.size() >= randomString){
                spaces.add("\n");
                characters.remove(0);
                characters.add(randomChar);
                String oldText = white.getText().replaceAll("<html><br>", "");
                String newText = randomChar;
                column.setText("");
                for(String character : characters){
                    column.append(character + "\n");
                }
                column.insert("\n", 0);
                for(String s : spaces){
                    column.insert(s, 0);
                }
                white.setText("<html>" + "<br>" + white.getText().replace(oldText, newText));


                int randomChance1 = (int) (Math.random() * 100);
                if (randomChance1 % 2 == 1) {
                    int randomChanges = (int) (Math.random() * characters.size() - 3);
                    for(int i = 0; i < randomChanges; i++) {
                        String randomCharacter = message[(int) (Math.random() * message.length)];
                        characters.set((int) (Math.random() * characters.size()), randomCharacter);

                    }
                }



            }

            if(spaces.size() + characters.size() >= 50){
                int green = column.getForeground().getGreen();
                if(green > 1){
                    column.setForeground(new Color(0, green - 1, 0));
                }
            }

            if(spaces.size() > 71){
                column.setForeground(new Color(0, 225, 0));
                column.setText("");
                white.setText("");
                characters.clear();
                spaces.clear();
            }
        };

        fallTimer = new Timer(100, append);
        fallTimer.start();
    }


    @Override
    public void run() {
       start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        column1 = new JTextArea();
        column2 = new JTextArea();
        column3 = new JTextArea();
        column4 = new JTextArea();
        column5 = new JTextArea();
        column6 = new JTextArea();
        column7 = new JTextArea();
        column8 = new JTextArea();
        column9 = new JTextArea();
        column10 = new JTextArea();
        column11 = new JTextArea();
        column12 = new JTextArea();
        column13 = new JTextArea();
        column14 = new JTextArea();
        column15 = new JTextArea();
        column16 = new JTextArea();
        column17 = new JTextArea();
        column18 = new JTextArea();
        column19 = new JTextArea();
        column20 = new JTextArea();
        column21 = new JTextArea();
        column22 = new JTextArea();
        column23 = new JTextArea();
        column24 = new JTextArea();
        column25 = new JTextArea();
        column26 = new JTextArea();
        column27 = new JTextArea();
        column28 = new JTextArea();
        column29 = new JTextArea();
        column30 = new JTextArea();
        column31 = new JTextArea();
        column32 = new JTextArea();
        column33 = new JTextArea();
        column34 = new JTextArea();
        column35 = new JTextArea();
        column36 = new JTextArea();
        column37 = new JTextArea();
        column38 = new JTextArea();
        column39 = new JTextArea();
        column40 = new JTextArea();
        column41 = new JTextArea();
        column42 = new JTextArea();
        column43 = new JTextArea();
        column44 = new JTextArea();
        column45 = new JTextArea();
        column46 = new JTextArea();

        white1 = new JLabel();
        white2 = new JLabel();
        white3 = new JLabel();
        white4 = new JLabel();
        white5 = new JLabel();
        white6 = new JLabel();
        white7 = new JLabel();
        white8 = new JLabel();
        white9 = new JLabel();
        white10 = new JLabel();
        white11 = new JLabel();
        white12 = new JLabel();
        white13 = new JLabel();
        white14 = new JLabel();
        white15 = new JLabel();
        white16 = new JLabel();
        white17 = new JLabel();
        white18 = new JLabel();
        white19 = new JLabel();
        white20 = new JLabel();
        white21 = new JLabel();
        white22 = new JLabel();
        white23 = new JLabel();
        white24 = new JLabel();
        white25 = new JLabel();
        white26 = new JLabel();
        white27 = new JLabel();
        white28 = new JLabel();
        white29 = new JLabel();
        white30 = new JLabel();
        white31 = new JLabel();
        white32 = new JLabel();
        white33 = new JLabel();
        white34 = new JLabel();
        white35 = new JLabel();
        white36 = new JLabel();
        white37 = new JLabel();
        white38 = new JLabel();
        white39 = new JLabel();
        white40 = new JLabel();
        white41 = new JLabel();
        white42 = new JLabel();
        white43 = new JLabel();
        white44 = new JLabel();
        white45 = new JLabel();
        white46 = new JLabel();

        setBackground(new Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(967, 533));

        column1.setBackground(new Color(0, 0, 0));
        column1.setColumns(20);
        column1.setForeground(new Color(51, 225, 0));
        column1.setRows(5);

        column2.setBackground(new Color(0, 0, 0));
        column2.setColumns(20);
        column2.setForeground(new Color(51, 225, 0));
        column2.setRows(5);

        column3.setBackground(new Color(0, 0, 0));
        column3.setColumns(20);
        column3.setForeground(new Color(51, 225, 0));
        column3.setRows(5);

        column4.setBackground(new Color(0, 0, 0));
        column4.setColumns(20);
        column4.setForeground(new Color(51, 225, 0));
        column4.setRows(5);

        column5.setBackground(new Color(0, 0, 0));
        column5.setColumns(20);
        column5.setForeground(new Color(51, 225, 0));
        column5.setRows(5);

        column6.setBackground(new Color(0, 0, 0));
        column6.setColumns(20);
        column6.setForeground(new Color(51, 225, 0));
        column6.setRows(5);

        column7.setBackground(new Color(0, 0, 0));
        column7.setColumns(20);
        column7.setForeground(new Color(51, 225, 0));
        column7.setRows(5);

        column8.setBackground(new Color(0, 0, 0));
        column8.setColumns(20);
        column8.setForeground(new Color(51, 225, 0));
        column8.setRows(5);

        column9.setBackground(new Color(0, 0, 0));
        column9.setColumns(20);
        column9.setForeground(new Color(51, 225, 0));
        column9.setRows(5);

        column10.setBackground(new Color(0, 0, 0));
        column10.setColumns(20);
        column10.setForeground(new Color(51, 225, 0));
        column10.setRows(5);

        column11.setBackground(new Color(0, 0, 0));
        column11.setColumns(20);
        column11.setForeground(new Color(51, 225, 0));
        column11.setRows(5);

        column12.setBackground(new Color(0, 0, 0));
        column12.setColumns(20);
        column12.setForeground(new Color(51, 225, 0));
        column12.setRows(5);

        column13.setBackground(new Color(0, 0, 0));
        column13.setColumns(20);
        column13.setForeground(new Color(51, 225, 0));
        column13.setRows(5);

        column14.setBackground(new Color(0, 0, 0));
        column14.setColumns(20);
        column14.setForeground(new Color(51, 225, 0));
        column14.setRows(5);

        column15.setBackground(new Color(0, 0, 0));
        column15.setColumns(20);
        column15.setForeground(new Color(51, 225, 0));
        column15.setRows(5);

        column16.setBackground(new Color(0, 0, 0));
        column16.setColumns(20);
        column16.setForeground(new Color(51, 225, 0));
        column16.setRows(5);

        column17.setBackground(new Color(0, 0, 0));
        column17.setColumns(20);
        column17.setForeground(new Color(51, 225, 0));
        column17.setRows(5);

        column18.setBackground(new Color(0, 0, 0));
        column18.setColumns(20);
        column18.setForeground(new Color(51, 225, 0));
        column18.setRows(5);

        column19.setBackground(new Color(0, 0, 0));
        column19.setColumns(20);
        column19.setForeground(new Color(51, 225, 0));
        column19.setRows(5);

        column20.setBackground(new Color(0, 0, 0));
        column20.setColumns(20);
        column20.setForeground(new Color(51, 225, 0));
        column20.setRows(5);

        column21.setBackground(new Color(0, 0, 0));
        column21.setColumns(20);
        column21.setForeground(new Color(51, 225, 0));
        column21.setRows(5);

        column22.setBackground(new Color(0, 0, 0));
        column22.setColumns(20);
        column22.setForeground(new Color(51, 225, 0));
        column22.setRows(5);

        column23.setBackground(new Color(0, 0, 0));
        column23.setColumns(20);
        column23.setForeground(new Color(51, 225, 0));
        column23.setRows(5);

        column24.setBackground(new Color(0, 0, 0));
        column24.setColumns(20);
        column24.setForeground(new Color(51, 225, 0));
        column24.setRows(5);

        column25.setBackground(new Color(0, 0, 0));
        column25.setColumns(20);
        column25.setForeground(new Color(51, 225, 0));
        column25.setRows(5);

        column26.setBackground(new Color(0, 0, 0));
        column26.setColumns(20);
        column26.setForeground(new Color(51, 225, 0));
        column26.setRows(5);

        column27.setBackground(new Color(0, 0, 0));
        column27.setColumns(20);
        column27.setForeground(new Color(51, 225, 0));
        column27.setRows(5);

        column28.setBackground(new Color(0, 0, 0));
        column28.setColumns(20);
        column28.setForeground(new Color(51, 225, 0));
        column28.setRows(5);

        column29.setBackground(new Color(0, 0, 0));
        column29.setColumns(20);
        column29.setForeground(new Color(51, 225, 0));
        column29.setRows(5);

        column30.setBackground(new Color(0, 0, 0));
        column30.setColumns(20);
        column30.setForeground(new Color(51, 225, 0));
        column30.setRows(5);

        column31.setBackground(new Color(0, 0, 0));
        column31.setColumns(20);
        column31.setForeground(new Color(51, 225, 0));
        column31.setRows(5);

        column32.setBackground(new Color(0, 0, 0));
        column32.setColumns(20);
        column32.setForeground(new Color(51, 225, 0));
        column32.setRows(5);

        column33.setBackground(new Color(0, 0, 0));
        column33.setColumns(20);
        column33.setForeground(new Color(51, 225, 0));
        column33.setRows(5);

        column34.setBackground(new Color(0, 0, 0));
        column34.setColumns(20);
        column34.setForeground(new Color(51, 225, 0));
        column34.setRows(5);

        column35.setBackground(new Color(0, 0, 0));
        column35.setColumns(20);
        column35.setForeground(new Color(51, 225, 0));
        column35.setRows(5);

        column36.setBackground(new Color(0, 0, 0));
        column36.setColumns(20);
        column36.setForeground(new Color(51, 225, 0));
        column36.setRows(5);

        column37.setBackground(new Color(0, 0, 0));
        column37.setColumns(20);
        column37.setForeground(new Color(51, 225, 0));
        column37.setRows(5);

        column38.setBackground(new Color(0, 0, 0));
        column38.setColumns(20);
        column38.setForeground(new Color(51, 225, 0));
        column38.setRows(5);

        column39.setBackground(new Color(0, 0, 0));
        column39.setColumns(20);
        column39.setForeground(new Color(51, 225, 0));
        column39.setRows(5);

        column40.setBackground(new Color(0, 0, 0));
        column40.setColumns(20);
        column40.setForeground(new Color(51, 225, 0));
        column40.setRows(5);

        column41.setBackground(new Color(0, 0, 0));
        column41.setColumns(20);
        column41.setForeground(new Color(51, 225, 0));
        column41.setRows(5);

        column42.setBackground(new Color(0, 0, 0));
        column42.setColumns(20);
        column42.setForeground(new Color(51, 225, 0));
        column42.setRows(5);

        column43.setBackground(new Color(0, 0, 0));
        column43.setColumns(20);
        column43.setForeground(new Color(51, 225, 0));
        column43.setRows(5);

        column44.setBackground(new Color(0, 0, 0));
        column44.setColumns(20);
        column44.setForeground(new Color(51, 225, 0));
        column44.setRows(5);

        column45.setBackground(new Color(0, 0, 0));
        column45.setColumns(20);
        column45.setForeground(new Color(51, 225, 0));
        column45.setRows(5);

        column46.setBackground(new Color(0, 0, 0));
        column46.setColumns(20);
        column46.setForeground(new Color(51, 225, 0));
        column46.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(column1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column18, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column17, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column16, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column15, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column28, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column24, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column21, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column19, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column23, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column30, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column29, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column25, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column27, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column36, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column35, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column34, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column33, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column31, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column32, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column26, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column20, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column22, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column41, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column40, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column39, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column38, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column37, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column42, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column43, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column44, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column45, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(column46, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(column1)
                                .addComponent(column2)
                                .addComponent(column3)
                                .addComponent(column4)
                                .addComponent(column5)
                                .addComponent(column6, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                .addComponent(column7, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
                        .addComponent(column8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addComponent(column9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(column18)
                                .addComponent(column17)
                                .addComponent(column16)
                                .addComponent(column15)
                                .addComponent(column14)
                                .addComponent(column13, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                .addComponent(column12))
                        .addComponent(column11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addComponent(column10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(column28)
                                .addComponent(column24)
                                .addComponent(column21)
                                .addComponent(column19)
                                .addComponent(column23)
                                .addComponent(column30, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                .addComponent(column29))
                        .addComponent(column25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addComponent(column27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(column36)
                                .addComponent(column35)
                                .addComponent(column34)
                                .addComponent(column33)
                                .addComponent(column31)
                                .addComponent(column32, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                .addComponent(column26))
                        .addComponent(column20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addComponent(column22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(column41)
                                .addComponent(column40, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                .addComponent(column39))
                        .addComponent(column38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addComponent(column37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(column42)
                                .addComponent(column43, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                .addComponent(column44))
                        .addComponent(column45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addComponent(column46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>


    // Variables declaration - do not modify
    private JTextArea column1;
    private JTextArea column10;
    private JTextArea column11;
    private JTextArea column12;
    private JTextArea column13;
    private JTextArea column14;
    private JTextArea column15;
    private JTextArea column16;
    private JTextArea column17;
    private JTextArea column18;
    private JTextArea column19;
    private JTextArea column2;
    private JTextArea column20;
    private JTextArea column21;
    private JTextArea column22;
    private JTextArea column23;
    private JTextArea column24;
    private JTextArea column25;
    private JTextArea column26;
    private JTextArea column27;
    private JTextArea column28;
    private JTextArea column29;
    private JTextArea column3;
    private JTextArea column30;
    private JTextArea column31;
    private JTextArea column32;
    private JTextArea column33;
    private JTextArea column34;
    private JTextArea column35;
    private JTextArea column36;
    private JTextArea column37;
    private JTextArea column38;
    private JTextArea column39;
    private JTextArea column4;
    private JTextArea column40;
    private JTextArea column41;
    private JTextArea column42;
    private JTextArea column43;
    private JTextArea column44;
    private JTextArea column45;
    private JTextArea column46;
    private JTextArea column5;
    private JTextArea column6;
    private JTextArea column7;
    private JTextArea column8;
    private JTextArea column9;
    // End of variables declaration
}
