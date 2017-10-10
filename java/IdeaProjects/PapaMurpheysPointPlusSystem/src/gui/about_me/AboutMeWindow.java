package gui.about_me;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.PointPlusFXMLController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Adam on 8/8/2016.
 */
public class AboutMeWindow extends Application {


    private ClassLoader classLoader = this.getClass().getClassLoader();
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource("gui/about_me/AboutMeFXML.fxml"));

    private PointPlusFXMLController controller;
    public AboutMeController AboutMeController;

    public AboutMeWindow(PointPlusFXMLController controller){

        this.controller = controller;
    }

    public static void main(String[] args) {
        Application.launch(AboutMeWindow.class, (java.lang.String[]) null);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane page = fxmlLoader.load();

            AboutMeController = fxmlLoader.<AboutMeController>getController();
            AboutMeController.start(this.controller);
            Scene scene = new Scene(page);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setAlwaysOnTop(true);
            //primaryStage.setOpacity(.95f);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(AboutMeWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
