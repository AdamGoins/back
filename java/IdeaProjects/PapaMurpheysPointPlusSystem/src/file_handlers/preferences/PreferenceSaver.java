package file_handlers.preferences;

import file_handlers.database.DatabaseManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Adam on 7/29/2016.
 */
public class PreferenceSaver {

    public void savePreferences(){
        rewrite();
        writeDefaultSkin();
        writeDefaultTemporaryPassword();
        writeTemporaryLogin();
        writeScheduleURL();
        writeTip();

    }

    private void writeDefaultSkin(){
        writeToFile(AdminHandler.preferencesFile, AdminHandler.DEFAULTSKINTAG + AdminHandler.defaultSkin);
        DatabaseManager.addToPrivate("Default Skin saved as: [" + AdminHandler.defaultSkin + "]");
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

    private void writeDefaultTemporaryPassword(){

        writeToFile(AdminHandler.preferencesFile, AdminHandler.DEFAULTTEMPORARYPASSWORDTAG + AdminHandler.defaultTemporaryPassword);
        DatabaseManager.addToPrivate("Default Secondary Password saved as: [" + AdminHandler.defaultTemporaryPassword + "]");

    }

    private void writeTemporaryLogin(){

        writeToFile(AdminHandler.temporaryLoginFile, AdminHandler.USERNAMETAG + AdminHandler.temporaryLogin.getUsername());
        writeToFile(AdminHandler.temporaryLoginFile, AdminHandler.PASSWORDTAG + AdminHandler.temporaryLogin.getPassword());

        DatabaseManager.addToPrivate("Secondary Username saved as: [" + AdminHandler.temporaryLogin.getUsername() + "]");
        DatabaseManager.addToPrivate("Secondary Password saved as: [" + AdminHandler.temporaryLogin.getPassword() + "]");
    }

    private void rewrite(){
        if(AdminHandler.preferencesFile.exists()){
            try {
                FileWriter fw = new FileWriter(AdminHandler.preferencesFile.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(AdminHandler.temporaryLoginFile.exists()){
            try {
                FileWriter fw = new FileWriter(AdminHandler.temporaryLoginFile.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void writeScheduleURL(){
        writeToFile(AdminHandler.preferencesFile, AdminHandler.SCHEDULEURLTAG + AdminHandler.scheduleURL);
        DatabaseManager.addToPrivate("Default Schedule URL saved as: [" + AdminHandler.scheduleURL + "]");
    }

    private void writeTip(){
        writeToFile(AdminHandler.preferencesFile, AdminHandler.TIPTAG + AdminHandler.tip);
        DatabaseManager.addToPrivate("Daily Tip saved as: [" + AdminHandler.tip + "]");
    }

}
