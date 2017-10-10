package gui.control_panel;

import file_handlers.database.DatabaseManager;
import file_handlers.preferences.AdminHandler;
import gui.new_password_window.ChangePasswordWindow;
import gui.private_history_window.PrivateHistoryWindow;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.PointPlusFXMLController;
import objects.LoginCredentials;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Created by Adam on 7/31/2016.
 */
public class ControlPanelController implements Initializable {
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

        skinComboBox.getItems().clear();

        skinComboBox.getItems().add("[STANDARD]");
        skinComboBox.getItems().add("[MIDNIGHT]");

        usernameTextField.setText(AdminHandler.temporaryLogin.getUsername());
        passwordTextField.setText(AdminHandler.temporaryLogin.getPassword());
        defaultPasswordField.setText(AdminHandler.defaultTemporaryPassword);
        skinComboBox.getSelectionModel().select(Objects.equals(AdminHandler.defaultSkin, "[STANDARD]") ? 0 : 1);
        urlField.setText(AdminHandler.scheduleURL);
        tipLabelField.setText(AdminHandler.tip);

    }

    private void createListeners(){
        closeButton.setOnAction(Event ->{
            closeWindow();
        });

        saveChangesButton.setOnAction(Event ->{
            saveAndClose();
        });

        changePasswordButton.setOnAction(Event ->{
            openChangePasswordWindow();
        });

        viewHistoryButton.setOnAction(Event ->{
            openViewHistoryWindow();
        });
    }

    private void openViewHistoryWindow(){
        try {
            Application app = new PrivateHistoryWindow(this.style, this);
            Stage stage = new Stage();
            app.start(stage);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void openChangePasswordWindow(){
        try {
            Application app = new ChangePasswordWindow(this.style, this);
            Stage stage = new Stage();
            app.start(stage);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    private void saveAndClose(){

        AdminHandler.defaultSkin = skinComboBox.getSelectionModel().getSelectedItem();
        AdminHandler.temporaryLogin.setUsername(usernameTextField.getText());
        AdminHandler.temporaryLogin.setPassword(passwordTextField.getText());
        AdminHandler.defaultTemporaryPassword = defaultPasswordField.getText();
        AdminHandler.scheduleURL = urlField.getText();
        AdminHandler.tip = tipLabelField.getText();


        AdminHandler.savePreferences();
        controller.reloadWebpage();
        controller.refreshTip();
        closeWindow();
    }

    private void closeWindow(){
        controller.activeWindow = false;
        controller.mainPanel.setDisable(false);
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

    public void start(String style, PointPlusFXMLController controller){
        this.style = style;
        this.controller = controller;

        controller.mainPanel.setDisable(true);
        controller.activeWindow = true;
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

    public void disable(){
        mainPanel.setDisable(true);
    }

    public void enable(){
        mainPanel.setDisable(false);
    }







    //--------------------------------------------------JAVAFX INITIALIZATION-------------------------------------------

    @FXML
    private Button viewHistoryButton;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button changePasswordButton;

    @FXML
    private Button closeButton;

    @FXML
    private TextField defaultPasswordField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button saveChangesButton;

    @FXML
    private ComboBox<String> skinComboBox;

    @FXML
    private TextArea tipLabelField;

    @FXML
    private ImageView titleImageView;

    @FXML
    private TextField urlField;

    @FXML
    private TextField usernameTextField;


    @FXML
    void initialize() {
        assert changePasswordButton != null : "fx:id=\"changePasswordButton\" was not injected: check your FXML file 'ControlPanelFXML.fxml'.";
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'ControlPanelFXML.fxml'.";
        assert defaultPasswordField != null : "fx:id=\"defaultPasswordField\" was not injected: check your FXML file 'ControlPanelFXML.fxml'.";
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'ControlPanelFXML.fxml'.";
        assert saveChangesButton != null : "fx:id=\"saveChangesButton\" was not injected: check your FXML file 'ControlPanelFXML.fxml'.";
        assert skinComboBox != null : "fx:id=\"skinComboBox\" was not injected: check your FXML file 'ControlPanelFXML.fxml'.";
        assert tipLabelField != null : "fx:id=\"tipLabelField\" was not injected: check your FXML file 'ControlPanelFXML.fxml'.";
        assert titleImageView != null : "fx:id=\"titleImageView\" was not injected: check your FXML file 'ControlPanelFXML.fxml'.";
        assert urlField != null : "fx:id=\"urlField\" was not injected: check your FXML file 'ControlPanelFXML.fxml'.";
        assert usernameTextField != null : "fx:id=\"usernameTextField\" was not injected: check your FXML file 'ControlPanelFXML.fxml'.";


    }


}
