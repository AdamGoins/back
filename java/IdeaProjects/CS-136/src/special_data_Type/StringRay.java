package special_data_Type;

/**
 * Created by root on 6/7/17.
 */
public class StringRay {

    public String booleanTrueChar = "\\\\TRUE";
    public String booleanFalseChar = "\\\\FALSE";

    public String shortChar = "\\\\s";

    public String intChar = "\\\\i";


    public String floatStartChar = "\\\\f";

    public String doubleChar = "\\\\d";

    public String longChar = "\\\\l";


    public String content;

    public StringRay(String content){
        this.content = content;

    }

    public int getInteger() {
        int intCharOccurence = content.indexOf(intChar) + 3;

        if (intCharOccurence == -1) return 0;

        String numberStart = content.substring(intCharOccurence).replaceAll(intChar, "");
        System.out.println(numberStart);

        int spaceOccurence = numberStart.indexOf(" ");


        String formattedNumber = numberStart;
        if (spaceOccurence > -1) formattedNumber = formattedNumber.substring(0, spaceOccurence);

        formattedNumber = formattedNumber.replaceAll(",", "");
        System.out.println(formattedNumber);


        try {
            return Integer.parseInt(formattedNumber);
        } catch (NumberFormatException e) {
            return 0;


        }
    }


    public int[] getIntegers()  {

        String[] intOccurencesFromString = content.split(intChar);
        System.out.println(intOccurencesFromString[1]);
        int[] integers = new int[intOccurencesFromString.length];

        for(int i = 0; i < intOccurencesFromString.length; i++){

            int indexOfSpace = intOccurencesFromString[i].indexOf(" ");

            String unformattedInteger = intOccurencesFromString[i];

            if(indexOfSpace > -1) unformattedInteger = unformattedInteger.substring(0, indexOfSpace);

            String formattedInteger = unformattedInteger.replaceAll(",", "");

            try{
                integers[i] = Integer.parseInt(formattedInteger);
            } catch(NumberFormatException e){
                continue;
            }

        }

        return integers;

    }

    public static void main(String[] args){

        StringRay sentence = new StringRay("My age is: \\\\i23");

        System.out.println(sentence.getInteger());


    }

}
