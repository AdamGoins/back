package gui.admin_login_window;

import file_handlers.preferences.AdminHandler;
import gui.control_panel.ControlPanelWindow;
import gui.new_entry_window.NewAccountPopupWindow;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.PointPlusFXMLController;

import java.net.URL;
import java.util.ResourceBundle;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import objects.LoginCredentials;

/**
 * Created by Adam on 7/29/2016.
 */
public class AdminLoginWindowController implements Initializable {

    private ClassLoader classLoader = this.getClass().getClassLoader();

    private final String MIDNIGHTTAG = "[MIDNIGHT]";
    private final String STANDARDTAG = "[STANDARD]";
    private String username = "";
    private String password = "";
    private LoginCredentials credentials;

    private String style;
    private PointPlusFXMLController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setPreferences();
        setGraphics();
        createListeners();

    }

    private void setPreferences(){

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

    private void createListeners(){

        closeButton.setOnAction(Event -> {
            closeWindow();
        });

        usernameField.setOnAction(Event ->{
            passwordField.requestFocus();

        });

        passwordField.setOnAction(Event ->{
            username = usernameField.getText();
            password = passwordField.getText();

            credentials = new LoginCredentials(username, password);
            verifyLogin();
        });

    }

    private void verifyLogin(){

        if(AdminHandler.testLogin(credentials)) {
            openControlPanel();
        }

        else {
            loginLabel.setVisible(true);
            passwordField.setText("");
        }

    }

    private void openControlPanel(){


        try {
            Application app = new ControlPanelWindow(style, controller);
            Stage stage = new Stage();
            app.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        directClose();

    }

    private void directClose(){
        ((Stage) mainPanel.getScene().getWindow()).close();
    }

    private void closeWindow(){
        controller.activeWindow = false;
        controller.mainPanel.setDisable(false);
        ((Stage) mainPanel.getScene().getWindow()).close();
    }

    public void start(String style, PointPlusFXMLController controller){

        this.style = style;
        this.controller = controller;

        controller.activeWindow = true;
        controller.mainPanel.setDisable(true);
        setStyle();
        usernameField.requestFocus();

    }


    private void setStyle(){
        mainPanel.setBlendMode(style.equals(MIDNIGHTTAG) ? BlendMode.EXCLUSION : BlendMode.DARKEN);
        titleImageView.setBlendMode(style.equals(MIDNIGHTTAG) ? BlendMode.EXCLUSION : BlendMode.DARKEN);
    }


    //------------------------------------------------------JAVAFX INITIALIZATION---------------------------------------

    @FXML
    private Label loginLabel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button closeButton;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView titleImageView;

    @FXML
    private TextField usernameField;


    @FXML
    void initialize() {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'AdmingLoginWindowFXML.fxml'.";
        assert mainPanel != null : "fx:id=\"mainPanel\" was not injected: check your FXML file 'AdmingLoginWindowFXML.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'AdmingLoginWindowFXML.fxml'.";
        assert titleImageView != null : "fx:id=\"titleImageView\" was not injected: check your FXML file 'AdmingLoginWindowFXML.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'AdmingLoginWindowFXML.fxml'.";


    }
}
