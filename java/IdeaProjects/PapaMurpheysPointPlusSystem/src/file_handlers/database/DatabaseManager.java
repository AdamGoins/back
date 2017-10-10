package file_handlers.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.Entry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Adam on 7/18/2016.
 */
public final class DatabaseManager {

    static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");


    public static final String HOMEDIR = System.getProperty("user.home");
    public static final String ABSOLUTEPATH = HOMEDIR + "/PapaMurphysPointPlusSystem/";

    public static final File privateHistoryFile = new File(ABSOLUTEPATH + "preference_files/private_history.txt");

    public static final String ACCOUNTSPATH = ABSOLUTEPATH + "accounts/";
    public static final String NAMENUMBERTAG = "[NAMENUMBER]";
    public static final String FIRSTNAMETAG = "[FIRSTNAME]";
    public static final String LASTNAMETAG = "[LASTNAME]";
    public static final String PHONENUMBERTAG = "[PHONENUMBER]";
    public static final String POINTSTAG = "[POINTS]";
    public static final String HISTORYTAG = "[HISTORY]";
    public static final String COMMENTSTAG = "[COMMENTS]";

    public static ObservableList<Entry> database = FXCollections.observableArrayList();
    public static ObservableList<String> history = FXCollections.observableArrayList();
    public static ObservableList<String> privateHistory = new DatabaseLoader().loadPrivateHistory();

    private static HashMap<Integer, Entry> databaseHashMap = new HashMap<>();


    public static void deleteAccount(Entry entry){

        Path filePath = Paths.get(ACCOUNTSPATH + entry.getNameNumber() + ".txt");
        try {
            Files.delete(filePath);
            database.remove(entry);
            databaseHashMap.remove(entry.getNameNumber());
            addToHistory("Account: [" + entry.getFirstName() + " " + entry.getLastName() + "] Phone Number: [" + entry.getPhoneNumber() + "] Points: [" + entry.getPoints() + "]" + " was deleted.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void addNewEntry(Entry entry){

        assignNameNumber(entry);
        addEntry(entry);
        addToHistory("New Account was created: [" + entry.getFirstName() + " " + entry.getLastName() + "] Points: [" + entry.getPoints() + "]");
        save(entry);
    }

    public static void addToHistory(String value){
        history.add(0, value);
        addToPrivate(value);
    }

    public static void addToPrivate(String value){
        privateHistory.add(0, timeStamp() + " " + value);
        new DatabaseSaver().saveHistory(timeStamp() + " " + value);
    }

    public static String timeStamp(){
        Date date = new Date();
        return "[" + dateFormat.format(date) + "]";
    }

    public static void save(Entry entry){
        new DatabaseSaver(entry);
    }

    public static void loadDatabase(){
        new DatabaseLoader(database);
    }

    public static void addEntry(Entry entry){

        databaseHashMap.put(entry.getNameNumber(), entry);

    }

    private static void assignNameNumber(Entry entry){

        int nameNumber = (int) (Math.random() * 50000) + 1;

        while(databaseHashMap.keySet().contains(nameNumber)){
            nameNumber = (int) (Math.random() * 50000) + 1;
        }

        entry.setNameNumber(nameNumber);

    }



}
