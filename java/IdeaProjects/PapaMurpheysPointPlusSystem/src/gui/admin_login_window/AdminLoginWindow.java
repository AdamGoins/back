package gui.admin_login_window;

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
 * Created by Adam on 7/29/2016.
 */
public class AdminLoginWindow extends Application {


    private ClassLoader classLoader = this.getClass().getClassLoader();
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource("gui/admin_login_window/AdmingLoginWindowFXML.fxml"));
    private String style;
    private PointPlusFXMLController controller;
    public AdminLoginWindowController adminController;

    public AdminLoginWindow(String style, PointPlusFXMLController controller){

        this.style = style;
        this.controller = controller;
    }

    public static void main(String[] args) {
        Application.launch(AdminLoginWindow.class, (java.lang.String[]) null);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane page = fxmlLoader.load();

            adminController = fxmlLoader.<AdminLoginWindowController>getController();
            adminController.start(style, this.controller);
            Scene scene = new Scene(page);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setAlwaysOnTop(true);
            //primaryStage.setOpacity(.95f);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(AdminLoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
