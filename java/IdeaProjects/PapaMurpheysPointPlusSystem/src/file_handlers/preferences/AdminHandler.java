package file_handlers.preferences;

import file_handlers.database.DatabaseManager;
import objects.LoginCredentials;

import java.io.File;

/**
 * Created by Adam on 7/29/2016.
 */
public final class AdminHandler {

    static final String BASEPATH = System.getProperty("user.home");
    static final String ABSOLUTEPATH = BASEPATH + "/PapaMurphysPointPlusSystem/";
    static final String USERNAMETAG = "[USERNAME]";
    static final String PASSWORDTAG = "[PASSWORD]";


    static final String TIPTAG = "[TIP]";
    static final String SCHEDULEURLTAG = "[SCHEDULEURL]";
    static final String DEFAULTSKINTAG = "[DEFAULTSKIN]";
    static final String DEFAULTTEMPORARYPASSWORDTAG = "[DEFAULTTEMPORARYPASSWORD]";

    static final File temporaryLoginFile = new File(ABSOLUTEPATH + "preference_files/temporary_login.txt");
    static final File credentialFile = new File(ABSOLUTEPATH + "preference_files/logins.txt");
    static final File preferencesFile = new File(ABSOLUTEPATH + "preference_files/preferences.txt");

    public static String tip = new PreferenceLoader().loadTip();
    public static String scheduleURL = new PreferenceLoader().loadScheduleURL();
    public static String defaultSkin  = new PreferenceLoader().loadDefaultSkin();

    public static LoginCredentials credentials = new PreferenceLoader().loadCredentials();
    public static LoginCredentials temporaryLogin = new PreferenceLoader().loadTemporaryLogin();
    public static String defaultTemporaryPassword = new PreferenceLoader().loadDefaultTemporaryPassword();



    public static void main(String[] args){

    }

    public static void savePreferences(){

        new PreferenceSaver().savePreferences();

    }

    public static boolean testLogin(LoginCredentials attempt){
        boolean legal = false;

        if(attempt.getUsername().equals(credentials.getUsername()) && attempt.getPassword().equals(credentials.getPassword())){
            legal = true;
            DatabaseManager.addToPrivate("Control Panel Access GRANTED. Username: [" + attempt.getUsername() + "]");
        }

        else if(attempt.getUsername().equals(temporaryLogin.getUsername()) && attempt.getPassword().equals(temporaryLogin.getPassword())){
            legal = true;
            DatabaseManager.addToPrivate("Control Panel Access GRANTED. Username: [" + attempt.getUsername() + "]");
            resetTemporaryLogin();
        }

        else {
            DatabaseManager.addToPrivate("INVALID LOGIN ATTEMPT. Attempted Username: [" + attempt.getUsername() + "] Attempted Password: [" + attempt.getPassword() + "] ACCESS DENIED.");
        }

        return legal;
    }

    public static void resetTemporaryLogin(){
        temporaryLogin.setPassword(defaultTemporaryPassword);
        DatabaseManager.addToPrivate("Secondary Password reset to Default: [" + defaultTemporaryPassword + "]");
        savePreferences();
    }

}
