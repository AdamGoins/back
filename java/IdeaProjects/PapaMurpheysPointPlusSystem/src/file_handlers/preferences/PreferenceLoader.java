package file_handlers.preferences;

import objects.LoginCredentials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Adam on 7/29/2016.
 */
public class PreferenceLoader {

    public LoginCredentials loadCredentials(){

        LoginCredentials credential = new LoginCredentials();

        try {

            Scanner scanner = new Scanner(AdminHandler.credentialFile);
            String line;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String key = getKey(line);
                String value = getValue(line);

                if(key.equals(AdminHandler.USERNAMETAG)) credential.setUsername(value);
                else if(key.equals(AdminHandler.PASSWORDTAG)) credential.setPassword(value);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return credential;

    }

    public String loadTip(){
        String tip = "";
        try {

            Scanner scanner = new Scanner(AdminHandler.preferencesFile);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String key = getKey(line);
                String value = getValue(line);

                if(key.equals(AdminHandler.TIPTAG)) tip = value;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return tip;
    }

    public String loadScheduleURL(){
        String URL = "";
        try {

            Scanner scanner = new Scanner(AdminHandler.preferencesFile);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String key = getKey(line);
                String value = getValue(line);

                if(key.equals(AdminHandler.SCHEDULEURLTAG)) URL = value;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return URL;
    }

    public String loadDefaultSkin(){
        String skin = "";
        try {

            Scanner scanner = new Scanner(AdminHandler.preferencesFile);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String key = getKey(line);
                String value = getValue(line);

                if(key.equals(AdminHandler.DEFAULTSKINTAG)) skin = value;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return skin;
    }

    public LoginCredentials loadTemporaryLogin(){

        LoginCredentials credentials = new LoginCredentials();

        try {

            Scanner scanner = new Scanner(AdminHandler.temporaryLoginFile);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String key = getKey(line);
                String value = getValue(line);

                if(key.equals(AdminHandler.USERNAMETAG)) credentials.setUsername(value);
                else if(key.equals(AdminHandler.PASSWORDTAG)) credentials.setPassword(value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return credentials;

    }

    public String loadDefaultTemporaryPassword(){

        String defaultPassword = "";

        try {

            Scanner scanner = new Scanner(AdminHandler.preferencesFile);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String key = getKey(line);
                String value = getValue(line);

                if(key.equals(AdminHandler.DEFAULTTEMPORARYPASSWORDTAG)) defaultPassword = value;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return defaultPassword;

    }

    private String getKey(String string){
        return string.substring(0, string.indexOf("]") + 1);
    }

    private String getValue(String string){
        return string.substring(string.indexOf("]") + 1);
    }
}
