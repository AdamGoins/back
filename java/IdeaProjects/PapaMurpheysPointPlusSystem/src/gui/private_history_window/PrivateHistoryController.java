package gui.private_history_window;

import file_handlers.database.DatabaseManager;
import file_handlers.preferences.AdminHandler;
import gui.control_panel.ControlPanelController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Adam on 7/31/2016.
 */
public class PrivateHistoryController implements Initializable {


    private ClassLoader classLoader = this.getClass().getClassLoader();
    private ObservableList<String> filteredList = FXCollections.observableArrayList();

    private final String MIDNIGHTTAG = "[MIDNIGHT]";
    private final String STANDARDTAG = "[STANDARD]";

    private String style;
    private ControlPanelController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setPreferences();
        setGraphics();
        createListeners();

    }

    private void setPreferences(){


    }

    private void createListeners(){

        closeButton.setOnAction(Event ->{
            closeWindow();
        });

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            int length = searchField.getLength();
            if (length > 0) {
                clearFilter();
                filterList(searchField.getText());
            } else {
                historyList.setItems(DatabaseManager.privateHistory);
            }
        });



    }

    private void clearFilter(){
        filteredList.clear();
    }

    private void filterList(String filter){
        clearFilter();
        for(String item : DatabaseManager.privateHistory){
            if(item.toLowerCase().contains(filter.toLowerCase())){
                filteredList.add(item);
            }
        }

        historyList.setItems(filteredList);

    }


    private void closeWindow(){
        controller.enable();
        ((Stage) mainPanel.getScene().getWindow()).close();
    }

    private void setGraphics(){

        ImageView closeIcon = new ImageView();
        closeIcon.setImage(new Image(classLoader.getResourceAsStream("images/closeIcon.png")));
        closeIcon.setFitWidth(15);
        closeIcon.setFitHeight(15);
        closeIcon.setBlendMode(BlendMode.EXCLUSION);
        closeButton.setText("");

        closeButton.setGraphic(closeIcon);

        titleImageView.setImage(new Image(classLoader.getResourceAsStream("images/helpIcon.png")));

        ImageView searchIcon = new ImageView();
        searchIcon.setImage(new Image(classLoader.getResourceAsStream("images/searchIcon.png")));
        searchIcon.setFitWidth(15);
        searchIcon.setFitHeight(15);
        searchButton.setGraphic(searchIcon);

    }

    public void start(String style, ControlPanelController controller){
        this.style = style;
        this.controller = controller;

        controller.disable();
        setStyle(style);
        populateList();
    }

    private void populateList(){

        historyList.setItems(DatabaseManager.privateHistory);

    }

    private void setStyle(String style){
        switch(style){
            case MIDNIGHTTAG:

                titleImageView.setBlendMode(BlendMode.EXCLUSION);
                mainPanel.setBlendMode(BlendMode.EXCLUSION);
                mainPanel.getStylesheets().clear();
                mainPanel.getStylesheets().add(classLoader.getResource("stylesheets/MidnightStylesheet.css").toExternalForm());
                this.style = MIDNIGHTTAG;
                break;

            case STANDARDTAG:

                titleImageView.setBlendMode(BlendMode.DARKEN);
                mainPanel.setBlendMode(BlendMode.DARKEN);
                mainPanel.getStylesheets().clear();
                mainPanel.getStylesheets().add(classLoader.getResource("stylesheets/StandardStylesheet.css").toExternalForm());
                this.style = STANDARDTAG;

                break;
        }
    }

        //-------------------------------------------------------JAVAFX INITIALIZATION----------------------------------

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button closeButton;

    @FXML
    private ListView<String> historyList;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    @FXML
    private ImageView titleImageView;


    @FXML
    void initialize() {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'PrivateHistoryFXML.fxml'.";
        assert historyList != null : "fx:id=\"historyList\" was not injected: check your FXML file 'PrivateHistoryFXML.fxml'.";
        assert mainPanel != null : "fx:id=\"mainPanel\" was not injected: check your FXML file 'PrivateHistoryFXML.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'PrivateHistoryFXML.fxml'.";
        assert searchField != null : "fx:id=\"searchField\" was not injected: check your FXML file 'PrivateHistoryFXML.fxml'.";
        assert titleImageView != null : "fx:id=\"titleImageView\" was not injected: check your FXML file 'PrivateHistoryFXML.fxml'.";


    }

}
