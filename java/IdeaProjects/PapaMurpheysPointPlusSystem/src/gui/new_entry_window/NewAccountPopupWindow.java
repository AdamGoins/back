package gui.new_entry_window;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.PointPlusFXMLController;
import objects.Entry;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Adam on 7/24/2016.
 */
public class NewAccountPopupWindow extends Application {

    private ClassLoader classLoader = this.getClass().getClassLoader();
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource("gui/new_entry_window/NewAccountPopupFXML.fxml"));
    private ObservableList<Entry> entries;
    private ObservableList<String> history;
    private String style;

    private PointPlusFXMLController parent;

    public NewAccountPopupWindow(ObservableList<Entry> entries, String style, ObservableList<String> history, PointPlusFXMLController parent){
        this.entries = entries;
        this.style = style;
        this.history = history;
        this.parent = parent;
    }

    public static void main(String[] args) {
        Application.launch(NewAccountPopupWindow.class, (java.lang.String[]) null);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane page = fxmlLoader.load();

            NewAccountPopupController controller = fxmlLoader.<NewAccountPopupController>getController();
            controller.start(entries, style, history, parent);
            Scene scene = new Scene(page);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setAlwaysOnTop(true);
            //primaryStage.setOpacity(.95f);
            primaryStage.setScene(scene);
            primaryStage.show();
            

        } catch (Exception ex) {
            Logger.getLogger(NewAccountPopupWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
