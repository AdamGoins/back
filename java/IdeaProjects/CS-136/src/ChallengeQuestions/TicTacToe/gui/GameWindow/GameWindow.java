package ChallengeQuestions.TicTacToe.gui.GameWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by root on 3/24/17.
 */
public class GameWindow extends Application {


    private ClassLoader classLoader = this.getClass().getClassLoader();

    public static void main(String[] args) {
        Application.launch(GameWindow.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane page = FXMLLoader.load(classLoader.getResource("ChallengeQuestions/TicTacToe/gui/GameWindow/TicTacToeFXML.fxml"));

            Scene scene = new Scene(page);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setTitle("Tic Tac Toe");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
