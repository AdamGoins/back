package objects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Adam on 8/7/2016.
 */
public class FileVerification {

    String basePath = System.getProperty("user.home") + "/PapaMurphysPointPlusSystem/";
    String accountPath = basePath + "accounts/";
    String preferencePath = basePath + "preference_files/";

    public FileVerification(){

    }

    public void validate(){
        checkAbsolutePath();
        checkAccountPath();
        checkPreferencePath();
    }

    private void checkAbsolutePath(){
       verify(new File(basePath));
    }

    private void checkAccountPath(){
        verify(new File(accountPath));
    }

    private void checkPreferencePath(){
        if(!verify(new File(preferencePath))) createDefaultPreferences();

    }

    private void createDefaultPreferences(){
        File loginsFile = new File(preferencePath + "logins.txt");
        File preferencesFile = new File(preferencePath + "preferences.txt");
        File privateHistoryFile = new File(preferencePath + "private_history.txt");
        File temporaryLoginFile = new File(preferencePath + "temporary_login.txt");

        try {
            FileWriter fw = new FileWriter(loginsFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("[USERNAME]Administrator");
            bw.newLine();
            bw.write("[PASSWORD]Elijah13");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(preferencesFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("[DEFAULTSKIN][STANDARD]");
            bw.newLine();
            bw.write("[DEFAULTTEMPORARYPASSWORD]DefaultPassword");
            bw.newLine();
            bw.write("[SCHEDULEURL]http://www.youtube.com/");
            bw.newLine();
            bw.write("[TIP]Remember, You cannot redeem Points in conjunction with other Discounts, Coupons, Specials, or Standalone purchases of our $5 Fave Pizzas.");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fw = new FileWriter(privateHistoryFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileWriter fw = new FileWriter(temporaryLoginFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("[USERNAME]TemporaryUsername");
            bw.newLine();
            bw.write("[PASSWORD]TemporaryPassword");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean verify(File file){
        if(!file.exists()){
            file.mkdir();
            return false;
        }
        else return true;
    }


}
