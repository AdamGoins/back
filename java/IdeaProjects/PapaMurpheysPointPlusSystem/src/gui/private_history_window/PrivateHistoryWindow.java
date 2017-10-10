package gui.private_history_window;

import gui.control_panel.ControlPanelController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Adam on 7/31/2016.
 */
public class PrivateHistoryWindow extends Application {



    private ClassLoader classLoader = this.getClass().getClassLoader();
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource("gui/private_history_window/PrivateHistoryFXML.fxml"));
    private String style;
    private ControlPanelController controller;

    public PrivateHistoryWindow(String style, ControlPanelController controller){
        this.style = style;
        this.controller = controller;
    }

    public static void main(String[] args) {
        Application.launch(PrivateHistoryWindow.class, (java.lang.String[]) null);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane page = fxmlLoader.load();

            PrivateHistoryController controller = fxmlLoader.<PrivateHistoryController>getController();
            controller.start(style, this.controller);
            Scene scene = new Scene(page);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setAlwaysOnTop(true);
            //primaryStage.setOpacity(.95f);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(PrivateHistoryWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




}
