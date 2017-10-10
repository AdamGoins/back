package file_handlers.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.Entry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Adam on 7/21/2016.
 */
public class DatabaseLoader {

    //EntryFormatter formatter = new EntryFormatter();

    public DatabaseLoader(){

    }

    public DatabaseLoader(ObservableList<Entry> list){

        loadDatabase(list);

    }


    public ObservableList loadDatabase(ObservableList<Entry> list){
        File[] folders = new File(DatabaseManager.ACCOUNTSPATH).listFiles();

        for(File file : folders){



            Entry entry = new Entry();

            assignAttributesFromFile(file, entry);

           // formatter.format(entry);

            DatabaseManager.addEntry(entry);
            list.add(entry);
        }

        return list;
    }

    private void assignAttributesFromFile(File file, Entry entry) {
        ArrayList<String> tempHistory = new ArrayList<>();

        for (String line : readFile(file)) {
            switch (getKey(line)) {

                case DatabaseManager.NAMENUMBERTAG:
                    entry.setNameNumber(Integer.parseInt(getValue(line)));
                    break;
                case DatabaseManager.FIRSTNAMETAG:
                    entry.setFirstName(getValue(line));
                    break;
                case DatabaseManager.LASTNAMETAG:
                    entry.setLastName(getValue(line));
                    break;
                case DatabaseManager.PHONENUMBERTAG:
                    entry.setPhoneNumber(getValue(line));
                    break;
                case DatabaseManager.POINTSTAG:
                    entry.setPoints(Integer.parseInt(getValue(line)));
                    break;
                case DatabaseManager.COMMENTSTAG:
                    entry.setComments(getValue(line));
                    break;
                case DatabaseManager.HISTORYTAG:
                    tempHistory.add(getValue(line));
                    break;
                default:
                    System.out.println("No case statement for tag: [" + getKey(line) + "]");
            }
        }
        Collections.sort(tempHistory);
        Collections.reverse(tempHistory);
        entry.setHistory(tempHistory);
    }

    public ArrayList<String> readFile(File file){
        System.out.println("Reading file: [" + file.getName() + "]");

        ArrayList<String>  fileContent = new ArrayList<>();
        try {

            Scanner scanner = new Scanner(file);
            String line;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                fileContent.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }

    public ObservableList<String> loadPrivateHistory(){

        ObservableList<String> history = FXCollections.observableArrayList();

        try {

            Scanner scanner = new Scanner(DatabaseManager.privateHistoryFile);
            String line;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                history.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(history);
        Collections.reverse(history);

        return history;

    }


    private String getKey(String string){
        return string.substring(0, string.indexOf("]") + 1);
    }

    private String getValue(String string){
        return string.substring(string.indexOf("]") + 1);
    }


}
