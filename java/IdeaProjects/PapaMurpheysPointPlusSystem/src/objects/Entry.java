package objects;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Adam on 7/18/2016.
 */
public class Entry {

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    private int points;
    private int nameNumber;

    private String firstName = "";
    private String lastName = "";
    private String phoneNumber = "";
    private String comments = "";

    private ArrayList<String> history = new ArrayList<>();

    public Entry(){
        addToHistory("Account was created.");
    }

    public Entry(String firstName, String lastName, String phoneNumber, String comments, int points){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.comments = comments;
        this.points = points;
        addToHistory("Account was created.");
    }

    public String timeStamp(){

        Date date = new Date();
        return "[" + dateFormat.format(date) + "]";

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int value){
        int newPoints = points + value;

        if(newPoints >= 0) {

            if(value > 0){
                addToHistory(value + " point(s) were added to the Account. Old Total: " + this.points + ", new Total: " + newPoints);
            }

            else addToHistory(value + " point(s) were removed from the Account. Old Total: " + this.points + ", new Total: " + newPoints);

            setPoints(newPoints);

        }

        else JOptionPane.showMessageDialog(null, "Account cannot have negative points!", "ERROR: Negative Point Value", JOptionPane.ERROR_MESSAGE);

    }

    public String toString(){
        return ("First Name: " + this.firstName + " " + "Last Name: " + this.lastName + " Phone Number: " + this.phoneNumber + " Points: " + this.points);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if(!Objects.equals(firstName, this.firstName)){
            if(this.firstName.length() > 0){
                addToHistory("First Name changed from: [" + this.firstName + "], to: [" + firstName + "]");
            }
            else addToHistory("First Name set to: [" + firstName + "]");

            this.firstName = firstName;
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(!Objects.equals(lastName, this.lastName)){
            if(this.lastName.length() > 0){
                addToHistory("Last Name changed from: [" + this.lastName + "], to: [" + lastName + "]");
            }
            else addToHistory("Last Name set to: [" + lastName + "]");

            this.lastName = lastName;
        }

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if(!Objects.equals(phoneNumber, this.phoneNumber)){
            if(this.phoneNumber.length() > 0){
                addToHistory("Phone Number added. Old Number: [" + this.phoneNumber + "], New Number: [" + phoneNumber + "]");
            }

            else addToHistory("Phone Number Added: [" + phoneNumber + "]");

            this.phoneNumber = phoneNumber;
        }

    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        if(!Objects.equals(comments, this.comments)){
            addToHistory("Comments changed to: [" + comments + "]");
            this.comments = comments;
        }
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }

    public void addToHistory(String entry){

        this.history.add(0, timeStamp() + " " + entry);
    }

    public int getNameNumber() {
        return this.nameNumber;
    }

    public void setNameNumber(int nameNumber) {
        this.nameNumber = nameNumber;
    }
}
