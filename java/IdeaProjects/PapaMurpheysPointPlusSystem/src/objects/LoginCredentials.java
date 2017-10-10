package objects;

/**
 * Created by Adam on 7/29/2016.
 */
public class LoginCredentials  {

    private String username;
    private String password;

    public LoginCredentials(){

    }

    public LoginCredentials(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
