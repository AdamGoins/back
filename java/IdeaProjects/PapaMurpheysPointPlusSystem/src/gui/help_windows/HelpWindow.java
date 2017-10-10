package gui.help_windows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.PointPlusFXMLController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Adam on 7/25/2016.
 */
public class HelpWindow extends Application {

    private ClassLoader classLoader = this.getClass().getClassLoader();
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource("gui/help_windows/BlankHelpWindowFXML.fxml"));
    private String key;
    private String style;
    private PointPlusFXMLController controller;

    public HelpWindow(String key, String style, PointPlusFXMLController controller){
        this.key = key;
        this.style = style;
        this.controller = controller;
    }

    public static void main(String[] args) {
        Application.launch(HelpWindow.class, (java.lang.String[]) null);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane page = fxmlLoader.load();

            HelpWindowController controller = fxmlLoader.<HelpWindowController>getController();
            controller.start(key, style, this.controller);
            Scene scene = new Scene(page);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setAlwaysOnTop(true);
            //primaryStage.setOpacity(.95f);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(HelpWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
