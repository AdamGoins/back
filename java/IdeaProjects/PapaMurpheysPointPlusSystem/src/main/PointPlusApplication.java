package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Adam on 7/18/2016.
 */
public class PointPlusApplication extends Application {

    private ClassLoader classLoader = this.getClass().getClassLoader();

    public static void main(String[] args) {
        Application.launch(PointPlusApplication.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane page = FXMLLoader.load(classLoader.getResource("PointPlusUserInterface.fxml"));

            Scene scene = new Scene(page);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.getIcons().add(new Image(classLoader.getResourceAsStream("images/murphysLogo.png")));
            primaryStage.setTitle("Papa Murphy's Point Plus System V 1.1");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(PointPlusApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
