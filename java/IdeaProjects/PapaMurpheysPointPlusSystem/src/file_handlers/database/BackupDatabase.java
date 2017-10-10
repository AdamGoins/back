package file_handlers.database;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by Adam on 8/1/2016.
 */
public class BackupDatabase {

    Stage primaryStage;

    private File destination;
    public BackupDatabase(){

    }

    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.destination = getDirectory();
        copyDatabase();
    }

    private void copyDatabase(){
        try {
            DatabaseManager.addToPrivate("Attempting Database Backup to: [" + this.destination + "]...");
            File[] databaseDirectory = new File(DatabaseManager.ACCOUNTSPATH).listFiles();
            for (File file : databaseDirectory) {
                Path source = Paths.get(file.getAbsolutePath());
                Path destination = Paths.get(this.destination.getAbsolutePath() + "/" + file.getName());
                writeToDestination(source, destination);
            }
            DatabaseManager.addToPrivate("[" + databaseDirectory.length + "] Files successfully saved to: [" + this.destination + "]");
        }
        catch(NullPointerException e){
            return;
        }
    }

    private void writeToDestination(Path source, Path destination){

        try {
            Files.copy(source, destination, REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private File getDirectory(){

        DirectoryChooser directoryChooser = new DirectoryChooser();

        return directoryChooser.showDialog(primaryStage);
    }

}
