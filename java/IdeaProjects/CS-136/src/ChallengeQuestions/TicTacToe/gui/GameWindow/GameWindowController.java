package ChallengeQuestions.TicTacToe.gui.GameWindow;
import ChallengeQuestions.TicTacToe.gui.GameController.GameController;
import ChallengeQuestions.TicTacToe.gui.StartingScreen.StartingScreen;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by root on 3/24/17.
 */
public class GameWindowController implements Initializable {

    private final String RELATIVEPATH = "ChallengeQuestions/TicTacToe/gui/";
    private ClassLoader classLoader = this.getClass().getClassLoader();
    private double xOffset;
    private double yOffset;

    private void setBackgrounds(){

        titleIcon.setImage(new Image(classLoader.getResourceAsStream(RELATIVEPATH + "Images/TicTacToeIcon.png")));

        ImageView closeIcon = new ImageView(new Image(classLoader.getResourceAsStream(RELATIVEPATH + "Images/minimize_icon.png")));
        closeIcon.setFitHeight(21);
        closeIcon.setFitWidth(21);
        minimizeButton.setGraphic(closeIcon);

        ImageView minimizeIcon = new ImageView(new Image(classLoader.getResourceAsStream(RELATIVEPATH + "Images/close_icon.png")));
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

        EventHandler<ActionEvent> buttonListener = event -> {

            Button source = ((Button) event.getSource());
            int id = Integer.parseInt(source.getId());
            String player = GameController.getCurrentPlayer();
            ImageView image = new ImageView();
            image.setFitWidth(130);
            image.setFitHeight(116);

            if(player.equals(GameController.playerOne)){
                image.setImage(new Image(classLoader.getResourceAsStream(RELATIVEPATH + "/Images/X-Icon.png")));
                source.setGraphic(image);
            }

            else{
                image.setImage(new Image(classLoader.getResourceAsStream(RELATIVEPATH + "/Images/O-Icon.png")));
                source.setGraphic(image);
            }

            //source.setStyle("-fx-background-color: rgb(205, 205, 205);");
            source.setDisable(true);
            logField.appendText(GameController.getCurrentPlayer() + " selects square " + (Integer.parseInt(source.getId()) + 1) + "\n");

            GameController.makeMove(id, this);

            logField.appendText("Current state of Gameboard:\n");
            logField.appendText("----------------------\n");
            logField.appendText(GameController.getGameboard());
            logField.appendText("----------------------\n");
            changeTurn();

        };

        titleBar.setOnMousePressed(Event -> {
            xOffset = titleBar.getScene().getWindow().getX() - MouseInfo.getPointerInfo().getLocation().getX();
            yOffset = titleBar.getScene().getWindow().getY() - MouseInfo.getPointerInfo().getLocation().getY();
        });

        titleBar.setOnMouseDragged(Event -> {
            titleBar.getScene().getWindow().setX(MouseInfo.getPointerInfo().getLocation().getX() + xOffset);
            titleBar.getScene().getWindow().setY(MouseInfo.getPointerInfo().getLocation().getY() + yOffset);

        });

        chatLine.setOnAction(Event -> {
            chatBox.getChildren().add(new Label(GameController.getCurrentPlayer() + ": " + chatLine.getText()));
            chatLine.setText("");
        });

        buttonOne.setId("0");
        buttonOne.setOnAction(buttonListener);
        buttonTwo.setId("1");
        buttonTwo.setOnAction(buttonListener);
        buttonThree.setId("2");
        buttonThree.setOnAction(buttonListener);
        buttonFour.setId("3");
        buttonFour.setOnAction(buttonListener);
        buttonFive.setId("4");
        buttonFive.setOnAction(buttonListener);
        buttonSix.setId("5");
        buttonSix.setOnAction(buttonListener);
        buttonSeven.setId("6");
        buttonSeven.setOnAction(buttonListener);
        buttonEight.setId("7");
        buttonEight.setOnAction(buttonListener);
        buttonNine.setId("8");
        buttonNine.setOnAction(buttonListener);

    }

    private void promptPlayerNames(){
        try {
            Application app = new StartingScreen(this);
            Stage stage = new Stage();
            app.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disable(){
        root.setDisable(true);
    }

    public void enable(){
        root.setDisable(false);
    }


    private void changeTurn(){
        nameLabel.setText(GameController.getCurrentPlayer() + "'s turn");
    }

    public void setLabel(String text){
        nameLabel.setText(text);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBackgrounds();
        createListeners();
        promptPlayerNames();
    }


    @FXML
    private Button buttonFour;

    @FXML
    private Button buttonSix;

    @FXML
    private Button minimizeButton;

    @FXML
    private Button buttonOne;

    @FXML
    private TextField chatLine;

    @FXML
    private Button buttonTwo;

    @FXML
    private Button buttonSeven;

    @FXML
    private Button buttonThree;

    @FXML
    private Button sendButton;

    @FXML
    private MenuBar menuBar;

    @FXML
    private ToolBar titleBar;

    @FXML
    private Button buttonEight;

    @FXML
    private Button closeButton;

    @FXML
    private TextArea logField;

    @FXML
    private Button buttonNine;

    @FXML
    private Button buttonFive;

    @FXML
    private VBox chatBox;

    @FXML
    private BorderPane root;

    @FXML
    private ImageView titleIcon;

    @FXML
    private Label nameLabel;
}
