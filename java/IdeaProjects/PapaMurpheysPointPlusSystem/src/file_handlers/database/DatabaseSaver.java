package file_handlers.database;

import objects.Entry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Adam on 7/21/2016.
 */
public class DatabaseSaver {

    private File historyFile= new File(DatabaseManager.ABSOLUTEPATH + "preference_files/private_history.txt");

    public DatabaseSaver(){

    }

    public DatabaseSaver(Entry entry){

        saveEntry(entry);

    }

    public void saveHistory(String item){

        writeToFile(historyFile, item);
        System.out.println(item);

    }

    public void saveEntry(Entry entry) {

        String path = DatabaseManager.ACCOUNTSPATH + Integer.toString(entry.getNameNumber()) + ".txt";

        File file = new File(path);
        reWrite(file);

        writeEntry(file, DatabaseManager.NAMENUMBERTAG, entry);
        writeEntry(file, DatabaseManager.FIRSTNAMETAG, entry);
        writeEntry(file, DatabaseManager.LASTNAMETAG, entry);
        writeEntry(file, DatabaseManager.PHONENUMBERTAG, entry);
        writeEntry(file, DatabaseManager.POINTSTAG, entry);
        writeEntry(file, DatabaseManager.COMMENTSTAG, entry);
        writeEntry(file, DatabaseManager.HISTORYTAG, entry);

    }

    private void writeEntry(File file, String tag, Entry entry){

        switch(tag){
            case DatabaseManager.NAMENUMBERTAG:
                writeToFile(file, tag + Integer.toString(entry.getNameNumber()));
                break;

            case DatabaseManager.FIRSTNAMETAG:
                writeToFile(file, tag + entry.getFirstName());
                break;

            case DatabaseManager.LASTNAMETAG:
                writeToFile(file, tag + entry.getLastName());
                break;

            case DatabaseManager.PHONENUMBERTAG:
                writeToFile(file, tag + entry.getPhoneNumber());
                break;

            case DatabaseManager.POINTSTAG:
                writeToFile(file, tag + Integer.toString(entry.getPoints()));
                break;

            case DatabaseManager.COMMENTSTAG:
                writeToFile(file, tag + entry.getComments());
                break;

            case DatabaseManager.HISTORYTAG:
                for(String history : entry.getHistory()){
                    writeToFile(file, tag + history);
                }
                break;

            default:
                System.out.println("No case statement for key: [" + tag + "]");
                break;
        }
    }

    private void reWrite(File file){
        if(file.exists()){
            try {
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    private void writeToFile(File file, String value){
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);


            bw.write(value);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
