import java.io.*;

/**
 * Created by Adam on 1/29/2017.
 */
public class Recursive {


    public static void main(String[] args){

        System.out.println(recursiveMultiply(2, 3));

        try {

            PrintWriter writer = new PrintWriter(new FileOutputStream(new File("Hey there.txt")));

            writer.write("Sup");
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static int recursiveMultiply(int numberOne, int numberTwo){



        if(numberTwo == 0){
            return numberOne;
        }

        else{

            return numberOne + recursiveMultiply(numberOne, numberTwo - 1);

        }



    }

}
