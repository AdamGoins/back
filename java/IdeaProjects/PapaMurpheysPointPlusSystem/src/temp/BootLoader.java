package temp;

import file_handlers.database.DatabaseManager;
import objects.Entry;
import objects.EntryFormatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Adam on 7/24/2016.
 */
public class BootLoader {

    EntryFormatter formatter = new EntryFormatter();

    public void createDatabase(ArrayList<String> namesArray, ArrayList<String> numbersArray, ArrayList<String> pointsArray){


        for(int i = 0; i < namesArray.size(); i++){
            Entry entry = new Entry();
            entry.setFirstName(namesArray.get(i));
            entry.setPhoneNumber(numbersArray.get(i));
            try {
                entry.setPoints((int) Double.parseDouble(pointsArray.get(i)));
            }
            catch(Exception e){
                entry.setPoints(0);
            }
            formatter.format(entry);

            DatabaseManager.addNewEntry(entry);

        }



    }

    public void createDatabase(){

        File namesFile = new File("src/temp/names.txt");
        File numbersFile = new File("src/temp/numbers.txt");
        File pointsFile = new File("src/temp/points.txt");


        ArrayList<String> namesArray = new ArrayList<>();
        ArrayList<String> numbersArray = new ArrayList<>();
        ArrayList<String> pointsArray = new ArrayList<>();

        try {

            Scanner nameScanner = new Scanner(namesFile);
            Scanner numberScanner = new Scanner(numbersFile);
            Scanner pointScanner = new Scanner(pointsFile);

            while(nameScanner.hasNextLine()){

                String line = nameScanner.nextLine();

                if(line.length() > 1){
                    namesArray.add(nameScanner.nextLine());
                }

            }

            while(numberScanner.hasNextLine()){
                numbersArray.add(numberScanner.nextLine());
            }

            while(pointScanner.hasNextLine()){
                pointsArray.add(pointScanner.nextLine());
            }

            for(int i = 0; i < namesArray.size(); i++){
                Entry entry = new Entry();
                entry.setFirstName(namesArray.get(i));
                entry.setPhoneNumber(numbersArray.get(i));
                entry.setPoints((int) Double.parseDouble(pointsArray.get(i)));
                formatter.format(entry);

                DatabaseManager.addNewEntry(entry);

            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        new BootLoader().createDatabase();
    }

}
