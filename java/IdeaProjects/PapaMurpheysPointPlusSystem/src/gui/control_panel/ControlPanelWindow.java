package gui.control_panel;

import gui.help_windows.HelpWindow;
import gui.help_windows.HelpWindowController;
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
 * Created by Adam on 7/31/2016.
 */
public class ControlPanelWindow extends Application {

    private ClassLoader classLoader = this.getClass().getClassLoader();
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource("gui/control_panel/ControlPanelFXML.fxml"));
    private String key;
    private String style;
    private PointPlusFXMLController controller;

    public ControlPanelWindow(String style, PointPlusFXMLController controller){
        this.style = style;
        this.controller = controller;
    }

    public static void main(String[] args) {
        Application.launch(ControlPanelWindow.class, (java.lang.String[]) null);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane page = fxmlLoader.load();

            ControlPanelController controller = fxmlLoader.<ControlPanelController>getController();
            controller.start(style, this.controller);
            Scene scene = new Scene(page);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setAlwaysOnTop(true);
            //primaryStage.setOpacity(.95f);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(ControlPanelWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
