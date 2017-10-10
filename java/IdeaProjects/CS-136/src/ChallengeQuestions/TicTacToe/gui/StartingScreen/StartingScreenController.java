package ChallengeQuestions.TicTacToe.gui.StartingScreen;

import ChallengeQuestions.TicTacToe.gui.GameController.GameController;
import ChallengeQuestions.TicTacToe.gui.GameWindow.GameWindowController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by root on 3/28/17.
 */
public class StartingScreenController implements Initializable {

    private final String RELATIVEPATH = "ChallengeQuestions/TicTacToe/gui/";
    private ClassLoader classLoader = this.getClass().getClassLoader();
    private double xOffset;
    private double yOffset;
    private Object parent;


    private void setBackgrounds(){
        titleIcon.setImage(new javafx.scene.image.Image(classLoader.getResourceAsStream(RELATIVEPATH + "Images/TicTacToeIcon.png")));

        javafx.scene.image.ImageView closeIcon = new javafx.scene.image.ImageView(new javafx.scene.image.Image(classLoader.getResourceAsStream(RELATIVEPATH + "Images/minimize_icon.png")));
        closeIcon.setFitHeight(21);
        closeIcon.setFitWidth(21);
        minimizeButton.setGraphic(closeIcon);

        javafx.scene.image.ImageView minimizeIcon = new javafx.scene.image.ImageView(new javafx.scene.image.Image(classLoader.getResourceAsStream(RELATIVEPATH + "Images/close_icon.png")));
        minimizeIcon.setFitHeight(21);
        minimizeIcon.setFitWidth(21);
        closeButton.setGraphic(minimizeIcon);
    }



    private void createListeners(){

        // Sets the Stylesheet for the root container, affecting all children of that container.
        root.getStylesheets().add(classLoader.getResource(RELATIVEPATH + "Stylesheets/StandardStylesheet.css").toExternalForm());

        // Makes minimize button minimize the window.
        minimizeButton.setOnAction(event ->  ((Stage) root.getScene().getWindow()).setIconified(true));

        // Makes the close button close the window.
        closeButton.setOnAction(event -> System.exit(1));

        titleBar.setOnMousePressed(Event -> {
            xOffset = titleBar.getScene().getWindow().getX() - MouseInfo.getPointerInfo().getLocation().getX();
            yOffset = titleBar.getScene().getWindow().getY() - MouseInfo.getPointerInfo().getLocation().getY();
        });
        titleBar.setOnMouseDragged(Event -> {
            titleBar.getScene().getWindow().setX(MouseInfo.getPointerInfo().getLocation().getX() + xOffset);
            titleBar.getScene().getWindow().setY(MouseInfo.getPointerInfo().getLocation().getY() + yOffset);

        });

        startButton.setOnAction(Event ->{
            if(playerOneField.getText().equals("")){
                playerOneField.requestFocus();
            }

            else if(playerTwoField.getText().equals("")){
                playerTwoField.requestFocus();
            }

            else{
                GameController.playerOne = playerOneField.getText();
                GameController.playerTwo = playerTwoField.getText();
                GameController.setCurrentPlayer(GameController.playerOne);
                root.getScene().getWindow().hide();
                ((GameWindowController) parent).setLabel(GameController.playerOne + "'s turn");
                enableParent();
            }
        });
    }

    private void disableParent(){
        ((GameWindowController) parent).disable();
    }

    private void enableParent(){
        ((GameWindowController) parent).enable();
    }

    public void setParent(Object parent){
        this.parent = parent;
        disableParent();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBackgrounds();
        createListeners();
    }


    @FXML
    private Button minimizeButton;

    @FXML
    private Button startButton;

    @FXML
    private Button closeButton;

    @FXML
    private TextField playerTwoField;

    @FXML
    private TextField playerOneField;

    @FXML
    private ImageView titleIcon;

    @FXML
    private ToolBar titleBar;

    @FXML
    private BorderPane root;



}
