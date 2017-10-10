package gui.new_entry_window;

import java.net.URL;
import java.util.ResourceBundle;

import file_handlers.database.DatabaseManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.PointPlusFXMLController;
import objects.Entry;


public class NewAccountPopupController implements Initializable{

    private ClassLoader classLoader = this.getClass().getClassLoader();
    private ObservableList<Entry> entries;
    private ObservableList<String> history;
    private String style;
    private PointPlusFXMLController controller;
    private final String MIDNIGHTTAG = "[MIDNIGHT]";
    private final String STANDARDTAG = "[STANDARD]";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setGraphics();
        createListeners();
        setPreferences();


    }

    private void setPreferences(){

        pointsField.setText("20");




    }

    private void setStyle(){
        switch(style){
            case MIDNIGHTTAG:

                titleImageView.setBlendMode(BlendMode.EXCLUSION);
                mainPanel.setBlendMode(BlendMode.EXCLUSION);
                mainPanel.getStylesheets().clear();
                mainPanel.getStylesheets().add(classLoader.getResource("stylesheets/MidnightStylesheet.css").toExternalForm());
                this.style = MIDNIGHTTAG;
                break;

            case STANDARDTAG:
                titleImageView.setBlendMode(BlendMode.DARKEN);
                mainPanel.setBlendMode(BlendMode.DARKEN);
                mainPanel.getStylesheets().clear();
                mainPanel.getStylesheets().add(classLoader.getResource("stylesheets/StandardStylesheet.css").toExternalForm());
                this.style = STANDARDTAG;

                break;
        }
    }

    private void setGraphics(){

        ImageView closeIcon = new ImageView();
        closeIcon.setImage(new Image(classLoader.getResourceAsStream("images/closeIcon.png")));
        closeIcon.setFitWidth(15);
        closeIcon.setFitHeight(15);
        closeIcon.setBlendMode(BlendMode.EXCLUSION);
        closeButton.setGraphic(closeIcon);

        titleImageView.setImage(new Image(classLoader.getResourceAsStream("images/murphysLogo.png")));

        pointsField.setOnAction(Event -> firstNameField.requestFocus());
        firstNameField.setOnAction(Event -> lastNameField.requestFocus());
        lastNameField.setOnAction(Event -> phoneNumberField.requestFocus());
        phoneNumberField.setOnAction(Event -> commentsField.requestFocus());
        commentsField.setOnAction(Event -> createAccount());
    }

    private void createListeners() {

        closeButton.setOnAction(Event -> {
            closeWindow();
        });

        addAccountButton.setOnAction(Event -> {
            if (isLegal()) createAccount();
        });

        phoneNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) {
                try {
                    int value = Integer.parseInt(newValue);
                } catch (NumberFormatException e) {
                    return;
                }

            } else {
                phoneNumberField.setText(oldValue);
            }
        });

        pointsField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) {

                try {
                    int value = Integer.parseInt(newValue);
                    if (value > 999 || value == 0) {
                        pointsField.setText(oldValue);
                    }
                } catch (NumberFormatException e) {
                    return;
                }

            } else {
                pointsField.setText(oldValue);
            }

        });

    }


    private void createAccount(){

        int points = 0;
        String firstName = "";
        String lastName = "";
        String phoneNumber = "";
        String comments = "";
        try{
            points = Integer.parseInt(pointsField.getText());
            pointsField.requestFocus();
        } catch(NumberFormatException e){
            return;
        }

        try{

            Long.parseLong(phoneNumberField.getText());
            phoneNumber = phoneNumberField.getText();

        } catch(NumberFormatException e){
            phoneNumberField.requestFocus();
            return;
        }

        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
        comments = commentsField.getText();

        Entry entry = new Entry();
        entry.setPoints(points);
        entry.setFirstName(firstName);
        entry.setLastName(lastName);
        entry.setPhoneNumber(phoneNumber);
        entry.setComments(comments);

        entries.add(entry);
        saveAndClose(entry);
    }

    private void saveAndClose(Entry entry){
        controller.mainPanel.setDisable(false);
        controller.activeWindow = false;
        DatabaseManager.addNewEntry(entry);
        controller.pullEntry(entry);

        closeWindow();
    }

    private void closeWindow(){
        controller.mainPanel.setDisable(false);
        controller.activeWindow = false;
        ((Stage) mainPanel.getScene().getWindow()).close();
    }

    private boolean isLegal(){

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();

        return firstName.length() > 0 || lastName.length() > 0 || phoneNumber.length() > 0;
    }

    void start(ObservableList<Entry> entries, String style, ObservableList<String> history, PointPlusFXMLController controller){
        this.entries = entries;
        this.style = style;
        this.history = history;
        this.controller = controller;
        setStyle();
        controller.mainPanel.setDisable(true);
    }






    //-----------------------------------------------------JavaFX instantiation-----------------------------------------



    @FXML
    private Label tipLabel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addAccountButton;

    @FXML
    private Button closeButton;

    @FXML
    private TextField commentsField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField pointsField;

    @FXML
    private ToolBar titleBar;

    @FXML
    private ImageView titleImageView;

    @FXML
    private Label titleLabel;


    @FXML
    void initialize() {
        assert addAccountButton != null : "fx:id=\"addAccountButton\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";
        assert closeButton != null : "fx:id=\"closebutton\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";
        assert commentsField != null : "fx:id=\"commentsField\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";
        assert firstNameField != null : "fx:id=\"firstNameField\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";
        assert lastNameField != null : "fx:id=\"lastNameField\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";
        assert mainPanel != null : "fx:id=\"mainPanel\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";
        assert phoneNumberField != null : "fx:id=\"phoneNumberField\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";
        assert pointsField != null : "fx:id=\"pointsField\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";
        assert titleBar != null : "fx:id=\"titleBar\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";
        assert titleImageView != null : "fx:id=\"titleImageView\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";
        assert titleLabel != null : "fx:id=\"titleLabel\" was not injected: check your FXML file 'NewAccountPopupFXML.fxml'.";


    }


}
