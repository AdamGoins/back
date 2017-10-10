package objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 8/1/2016.
 */
public class Blackbook {

    private List<String> spaceCharacters = new ArrayList<String>(){{
        add("M");
        add("@");
        add("o");
        add("R");
        add("%");
        add("?");
        add("`");
    }};

    private String newWordCharacter = "X";

    private final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789`~!@#$%^&*()_+-=][}[';|\":/?.>,<| ";
    private final String DUMMYCHARS = "ABCDEFGHIJKLNOPQSTUVWYZabcdefghijklmnpqrstuvwxyz0123456789~!#$^&*()_+-=][}[';|\":/.>,<| ";


    public String encrypt(String text){
        String encryptedText = "";

        text = text.length() + " " + text;
        //text = text.replaceAll(" ", spaceCharacter);

        String[] blocks = text.split(" ");


        // Turns letters into indexes of the CHARS
        for(int i = 1; i < blocks.length; i++){

                String tempBlock = "";

                for(char chars : blocks[i].toCharArray()){
                    tempBlock = tempBlock.concat(getRandomSpaceChar() + Integer.toString(CHARS.indexOf(chars)) + getRandomSpaceChar()).concat(" ");
                }

                blocks[i] = tempBlock;
        }

        // Fills with dummy characters

        for(int i = 1; i < blocks.length; i++){

            String tempBlock = "";


            String[] temp = blocks[i].split(" "); // Grabs each word in sentence

            for(int iii = 0; iii < temp.length; iii++){ // For each word
                int place = Integer.parseInt("" + temp[iii].substring(1, temp[iii].length() - 1));

                for(int iv = 0; iv < place; iv++){
                    temp[iii] = temp[iii].concat(Character.toString(getRandomChar()));
                }

                tempBlock = tempBlock.concat(temp[iii]);



            }
            blocks[i] = tempBlock.concat(newWordCharacter);

        }



        //---------------

        for(String block : blocks){
            //System.out.println(block);
            encryptedText = encryptedText.concat(block);
        }

        return encryptedText;
    }

    private String decrypt(String text){

        String decryptedText = "";

        String[] blocks = text.split(newWordCharacter);

        ArrayList<String> decryptedIndexes = new ArrayList<>();
        for(String block : blocks){ // For Word : Sentence

            boolean legal = false;

            String temp = "";


            for(int i = 0; i < block.length(); i++){

                String character = "" + block.charAt(i);

                if(legal && !spaceCharacters.contains(character)){
                    temp = temp.concat(character);
                }

                if(spaceCharacters.contains(character)){
                    legal = !legal;

                    if(!legal){
                        decryptedIndexes.add(temp);
                        temp = "";
                    }
                }

            }
            decryptedIndexes.add(newWordCharacter);

        }


        for(String string : decryptedIndexes){
            if(string.equals(newWordCharacter)) decryptedText = decryptedText.concat(" ");
            else decryptedText = decryptedText.concat(Character.toString(CHARS.charAt(Integer.parseInt(string))));
        }


        return decryptedText.substring(0, decryptedText.length() - 1);

    }

    private char getRandomSpaceChar(){
        char[] temp = spaceCharacters.get(getRandom(0, spaceCharacters.size())).toCharArray();
       // System.out.println(" Character; " + temp[0]);
        return temp[0];
    }

    private char getRandomChar(){
        return DUMMYCHARS.charAt(getRandom(0, DUMMYCHARS.length()));
    }

    private int getRandom(int min, int max){
        return (int) (Math.random() * max) + min;
    }


}
