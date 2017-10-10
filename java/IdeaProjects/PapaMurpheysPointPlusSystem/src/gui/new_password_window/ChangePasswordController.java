package gui.new_password_window;

import file_handlers.database.DatabaseManager;
import file_handlers.preferences.AdminHandler;
import gui.control_panel.ControlPanelController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Adam on 7/31/2016.
 */
public class ChangePasswordController implements Initializable {


    private ClassLoader classLoader = this.getClass().getClassLoader();

    private final String MIDNIGHTTAG = "[MIDNIGHT]";
    private final String STANDARDTAG = "[STANDARD]";

    private String style;
    private ControlPanelController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setPreferences();
        setGraphics();
        createListeners();

    }

    private void setPreferences(){


    }

    private void createListeners(){

        closeButton.setOnAction(Event ->{
            closeWindow();
        });

        confirmPasswordField.setOnAction(Event ->{
            if(oldPasswordField.getText().length() == 0) oldPasswordField.requestFocus();
            else if(newPasswordField.getText().length() == 0) newPasswordField.requestFocus();
            else if(confirmPasswordField.getText().length() > 0) attemptSave();
        });

    }

    private void attemptSave(){

        if(oldPasswordField.getText().equals(AdminHandler.credentials.getPassword())){
            if(newPasswordField.getText().equals(confirmPasswordField.getText())){
                saveAndClose();

            }

            else{
                passwordTipLabel.setVisible(true);
                passwordTipLabel.setText("Passwords must match...");
                newPasswordField.setText("");
                confirmPasswordField.setText("");
                newPasswordField.requestFocus();
            }
        }
        else {

            DatabaseManager.addToPrivate("INVALID ADMIN PASSWORD CHANGE ATTEMPT. Guessed Password: [" + oldPasswordField.getText() + "]");

            passwordTipLabel.setVisible(true);
            passwordTipLabel.setText("Invalid Password");

            oldPasswordField.setText("");
            newPasswordField.setText("");
            confirmPasswordField.setText("");

            oldPasswordField.requestFocus();
        }

    }
    private void saveAndClose(){

        AdminHandler.credentials.setPassword(newPasswordField.getText());
        AdminHandler.savePreferences();

        closeWindow();
    }

    private void closeWindow(){
        controller.enable();
        ((Stage) mainPanel.getScene().getWindow()).close();
    }

    private void setGraphics(){

        ImageView closeIcon = new ImageView();
        closeIcon.setImage(new Image(classLoader.getResourceAsStream("images/closeIcon.png")));
        closeIcon.setFitWidth(15);
        closeIcon.setFitHeight(15);
        closeIcon.setBlendMode(BlendMode.EXCLUSION);
        closeButton.setText("");

        closeButton.setGraphic(closeIcon);

        titleImageView.setImage(new Image(classLoader.getResourceAsStream("images/helpIcon.png")));

    }

    public void start(String style, ControlPanelController controller){
        this.style = style;
        this.controller = controller;

        controller.disable();
        setStyle(style);
    }

    private void setStyle(String style){
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


    //------------------------------------------------------JAVAFX INITIALIZATION---------------------------------------

    @FXML
    private Label passwordTipLabel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button closeButton;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField oldPasswordField;

    @FXML
    private ImageView titleImageView;


    @FXML
    void initialize() {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'ChangePasswordFXML.fxml'.";
        assert confirmPasswordField != null : "fx:id=\"confirmPasswordField\" was not injected: check your FXML file 'ChangePasswordFXML.fxml'.";
        assert mainPanel != null : "fx:id=\"mainPanel\" was not injected: check your FXML file 'ChangePasswordFXML.fxml'.";
        assert newPasswordField != null : "fx:id=\"newPasswordField\" was not injected: check your FXML file 'ChangePasswordFXML.fxml'.";
        assert oldPasswordField != null : "fx:id=\"oldPasswordField\" was not injected: check your FXML file 'ChangePasswordFXML.fxml'.";
        assert titleImageView != null : "fx:id=\"titleImageView\" was not injected: check your FXML file 'ChangePasswordFXML.fxml'.";


    }


}
