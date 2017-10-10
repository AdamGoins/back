package gui.about_me;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.PointPlusFXMLController;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Adam on 8/8/2016.
 */
public class AboutMeController implements Initializable {

    PointPlusFXMLController controller;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        aboutMePanel.toFront();
        setGraphics();
        createListeners();
    }

    private void setGraphics(){
        closeButton.setImage(new Image(this.getClass().getClassLoader().getResourceAsStream("images/closeIcon.png")));
        titleImageView.setImage(new Image(this.getClass().getClassLoader().getResourceAsStream("images/helpIcon.png")));
        profilePictureImageView.setImage(new Image(this.getClass().getClassLoader().getResourceAsStream("images/Profile_Picture.jpg")));
    }

    private void createListeners(){

        closeButton.setOnMouseClicked(Event ->{
            closeWindow();
        });

        aboutMeButton.setOnAction(Event ->{
            aboutMePanel.toFront();
        });

        experienceButton.setOnAction(Event ->{
            experiencePanel.toFront();
        });

        featuresButton.setOnAction(Event ->{
            programFeaturesPanel.toFront();
        });

        contactMeButton.setOnAction(Event -> {
            contactMePanel.toFront();
        });

        miscButton.setOnAction(Event ->{
            miscPanel.toFront();
        });
    }

    private void closeWindow(){
        controller.mainPanel.setDisable(false);
        ((Stage) mainPanel.getScene().getWindow()).close();
    }


    public void start(PointPlusFXMLController controller){
        this.controller = controller;
        controller.mainPanel.setDisable(true);
    }

    @FXML
    private AnchorPane contactMePanel;

    @FXML
    private ImageView titleImageView;

    @FXML
    private BorderPane mainPanel;

    @FXML
    private Button experienceButton;

    @FXML
    private AnchorPane miscPanel;

    @FXML
    private Button aboutMeButton;

    @FXML
    private AnchorPane aboutMePanel;

    @FXML
    private Button miscButton;

    @FXML
    private ImageView closeButton;

    @FXML
    private AnchorPane programFeaturesPanel;

    @FXML
    private AnchorPane experiencePanel;

    @FXML
    private Button featuresButton;

    @FXML
    private Button contactMeButton;

    @FXML
    private ImageView profilePictureImageView;

    @FXML
    void initialize() {

    }

}
