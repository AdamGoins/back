package ChallengeQuestions.TicTacToe.gui.StartingScreen;

import ChallengeQuestions.TicTacToe.gui.GameWindow.GameWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by root on 3/28/17.
 */
public class StartingScreen extends Application {

    private ClassLoader classLoader = this.getClass().getClassLoader();
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource("ChallengeQuestions/TicTacToe/gui/StartingScreen/StartingScreen.fxml"));

    private Object parent;

    public StartingScreen(Object parent){
        this.parent = parent;
    }

    public static void main(String[] args) {
        Application.launch(StartingScreen.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {


            BorderPane page = fxmlLoader.load();

            StartingScreenController controller = fxmlLoader.getController();
            controller.setParent(parent);
            Scene scene = new Scene(page);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setAlwaysOnTop(true);
            primaryStage.setTitle("Enter player names...");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(StartingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
