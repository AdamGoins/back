package main;

/**
 * Created by Adam on 7/18/2016.
 */

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import file_handlers.database.BackupDatabase;
import file_handlers.preferences.AdminHandler;
import gui.about_me.AboutMeWindow;
import gui.admin_login_window.AdminLoginWindow;
import gui.help_windows.HelpWindow;
import gui.new_entry_window.NewAccountPopupWindow;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import file_handlers.database.DatabaseManager;
import javafx.stage.Stage;
import objects.Entry;
import objects.FileVerification;

import javax.swing.*;


public class PointPlusFXMLController implements Initializable {

    public boolean activeWindow = false;

    private final String SEARCHHELPTAG = "[SEARCH]";
    private final String CHANGEPOINTSTAG = "[CHANGEPOINTS]";
    private final String EDITACCOUNTTAG = "[EDIT]";
    private final String CREATEACCOUNTTAG = "[CREATEACCOUNT]";

    private ClassLoader classLoader = this.getClass().getClassLoader();

    private ObservableList<Entry> entries = FXCollections.observableArrayList();
    private ObservableList<Entry> filteredEntries = FXCollections.observableArrayList();

    private ObservableList<String> history = DatabaseManager.history;

    private Entry currentEntry;

    private String style = "[MIDNIGHT]";
    private final String MIDNIGHTTAG = "[MIDNIGHT]";
    private final String STANDARDTAG = "[STANDARD]";
    private boolean editing = false;

    private double xOffset;
    private double yOffset;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new FileVerification().validate();

        setGraphics();
        setPreferences();
        createListeners();
        setContextMenus();
        createColumns();
        populateTable();

    }

    private void populateTable(){
        DatabaseManager.loadDatabase();
        entries = DatabaseManager.database;
        databaseTable.setItems(entries);
    }

    private void createColumns(){

        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("comments"));

    }

    private void setGraphics(){

        ImageView closeIcon = new ImageView();
        closeIcon.setImage(new Image(classLoader.getResourceAsStream("images/closeIcon.png")));
        closeIcon.setFitWidth(15);
        closeIcon.setFitHeight(15);
        closeIcon.setBlendMode(BlendMode.EXCLUSION);
        closeButton.setText("");

        closeButton.setGraphic(closeIcon);

        ImageView minimizeIcon = new ImageView();
        minimizeIcon.setImage(new Image(classLoader.getResourceAsStream("images/minimizeIcon.png")));
        minimizeIcon.setFitWidth(15);
        minimizeIcon.setFitHeight(15);
        minimizeIcon.setBlendMode(BlendMode.EXCLUSION);
        minimizeButton.setText("");
        minimizeButton.setGraphic(minimizeIcon);

        ImageView searchIcon = new ImageView();
        searchIcon.setImage(new Image(classLoader.getResourceAsStream("images/searchIcon.png")));
        searchIcon.setFitWidth(15);
        searchIcon.setFitHeight(15);
        searchButton.setGraphic(searchIcon);

        titleLabel.setImage(new Image(classLoader.getResourceAsStream("images/murphysLogo.png")));



    }

    private void setPreferences(){

        midnightMenuItem.setSelected(true);
        titleLabel.setBlendMode(BlendMode.EXCLUSION);
        invertColors(AdminHandler.defaultSkin);
        tipLabel.setText(AdminHandler.tip);
        webview.getEngine().load(AdminHandler.scheduleURL);
        disableFields();


    }

    private void enableEditing(){

        editing = true;
        appendField.setEditable(false);
        firstNameField.setEditable(true);
        lastNameField.setEditable(true);
        phoneNumberField.setEditable(true);
        notesField.setEditable(true);

    }

    private void disableFields(){
        appendField.setEditable(false);
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        phoneNumberField.setEditable(false);
        notesField.setEditable(false);
        historyField.setEditable(false);

    }

    private void disableEditing(){

        appendField.setEditable(true);
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        phoneNumberField.setEditable(false);
        notesField.setEditable(false);
        historyField.setEditable(false);


    }

    private void saveAndClose(){
        System.exit(0);
    }

    private void createListeners(){

        closeButton.setOnMouseClicked(Event -> saveAndClose());
        closeButton.setOnMouseEntered(Event -> closeButton.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)))));
        closeButton.setOnMouseExited(Event -> closeButton.setBorder(null));

        minimizeButton.setOnMouseEntered(Event -> minimizeButton.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)))));
        minimizeButton.setOnMouseExited(Event -> minimizeButton.setBorder(null));

        standardMenuItem.setOnAction(Event ->{
            invertColors(STANDARDTAG);

        });

        minimizeButton.setOnAction(Event ->{
            ((Stage) mainPanel.getScene().getWindow()).setIconified(true);
        });

        midnightMenuItem.setOnAction(Event ->{
            invertColors(MIDNIGHTTAG);
        });

        titleBar.setOnMousePressed(Event -> {
            xOffset = titleBar.getScene().getWindow().getX() - MouseInfo.getPointerInfo().getLocation().getX();
            yOffset = titleBar.getScene().getWindow().getY() - MouseInfo.getPointerInfo().getLocation().getY();
        });
        titleBar.setOnMouseDragged(Event -> {
            titleBar.getScene().getWindow().setX(MouseInfo.getPointerInfo().getLocation().getX() + xOffset);
            titleBar.getScene().getWindow().setY(MouseInfo.getPointerInfo().getLocation().getY() + yOffset);

        });

        phoneNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) {
                try{
                    int value = Integer.parseInt(newValue);
                } catch(NumberFormatException e){
                    return;
                }

            } else {
                phoneNumberField.setText(oldValue);
            }
        });

        appendField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*") || newValue.startsWith("-")) {
                try{
                    int value = Integer.parseInt(newValue);
                    if(value > 999 || value == 0){
                        appendField.setText(oldValue);
                    }
                    else if(value < -1000){
                        appendField.setText(oldValue);
                    }
                } catch(NumberFormatException e){

                    return;
                }

            } else {
                appendField.setText(oldValue);
            }
        });

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            int length = searchField.getLength();
            if (length > 0) {
                clearFilter();
                filterList(searchField.getText());
            } else {
                databaseTable.setItems(entries);
            }
        });


        searchField.setOnAction(Event ->{
            if(databaseTable.getItems().size() == 1){
                databaseTable.getSelectionModel().select(0);
                pullEntry(databaseTable.getSelectionModel().getSelectedItem());
            }
        });

        databaseTable.setOnMouseClicked(Event -> {
            if (Event.getClickCount() == 2 && Event.getButton().equals(MouseButton.PRIMARY)) {
                pullEntry(databaseTable.getSelectionModel().getSelectedItem());
            }
            //else if(Event.getButton().equals(MouseButton.SECONDARY)) databaseTable.getContextMenu().show(databaseTable, Side.BOTTOM, 0, 0);


        });

        editEntryButton.setOnAction(Event ->{
            if(currentEntry != null){
                if(editing){
                    saveChanges();
                }
                else{
                    enableEditing();
                    editEntryButton.setText("Save Changes");
                }
            }

        });

        appendField.setOnAction(Event ->{
            if(appendField.getText().length() > 0){
                try{
                    int value = Integer.parseInt(appendField.getText());

                    if(value != 0){

                        updateEntry(value);
                        //pullEntry(currentEntry);
                    }

                }
                catch(NumberFormatException e){
                    appendField.setText("");
                    JOptionPane.showMessageDialog(null, "Enter an Integer!", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        addEntryButton.setOnAction(Event ->{

            openNewEntryWindow();

        });
        clearButton.setOnAction(Event ->{
            history.clear();
            searchHistoryList.setItems(history);
        });

        firstNameField.setOnAction(Event ->{
            saveChanges();
        });

        lastNameField.setOnAction(Event ->{
            saveChanges();
        });

        phoneNumberField.setOnAction(Event ->{
            saveChanges();
        });

        notesField.setOnAction(Event ->{
            saveChanges();
        });

        newEntryMenuItem.setOnAction(Event ->{
            openNewEntryWindow();
        });

        aboutMenuItem.setOnAction(Event ->{
            openAboutMeWindow();
        });

        searchHelpMenuItem.setOnAction(Event -> openHelpWindow(SEARCHHELPTAG, style));
        addPointHelpMenuItem.setOnAction(Event -> openHelpWindow(CHANGEPOINTSTAG, style));
        editEntryHelpMenuItem.setOnAction(Event -> openHelpWindow(EDITACCOUNTTAG, style));
        createNewEntryHelpMenuItem.setOnAction(Event -> openHelpWindow(CREATEACCOUNTTAG, style));

        controlPanelMenuItem.setOnAction(Event -> promptAdminLogin());

        saveMenuItem.setOnAction(Event ->{
            backupDatabase();
        });

    }

    private void openAboutMeWindow(){


        try {

            Application app = new AboutMeWindow(this);
            Stage stage = new Stage();
            app.start(stage);
            activeWindow = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setContextMenus(){

        ContextMenu tableMenu = new ContextMenu();

        MenuItem pullEntryItem = new MenuItem("Pull Account...");
        pullEntryItem.setOnAction(Event -> pullEntry(databaseTable.getSelectionModel().getSelectedItem()));

        MenuItem deleteAccountItem = new MenuItem("Delete Account");
        deleteAccountItem.setOnAction(Event ->{
            Entry entry = databaseTable.getSelectionModel().getSelectedItem();
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete Account: \n" +
                    "[" + entry.getFirstName() + " " + entry.getLastName() + "] Phone Number: [" + entry.getPhoneNumber() + "] " + " Points: [" + entry.getPoints() + "]", "Confirm Choice", JOptionPane.YES_NO_OPTION);

            if(selection == JOptionPane.YES_OPTION) deleteAccount(entry);
            else return;
        });

        tableMenu.getItems().add(pullEntryItem);
        tableMenu.getItems().add(new SeparatorMenuItem());
        tableMenu.getItems().add(deleteAccountItem);

        databaseTable.setContextMenu(tableMenu);

    }

    private void deleteAccount(Entry entry){

        DatabaseManager.deleteAccount(entry);

    }

    private void promptAdminLogin(){

        try {
            AdminLoginWindow app = new AdminLoginWindow(style, this);
            Stage stage = new Stage();
            app.start(stage);
            activeWindow = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void openHelpWindow(String key, String style){
        if(!activeWindow){
            try {
                Application app = new HelpWindow(key, style, this);
                Stage stage = new Stage();
                app.start(stage);
                activeWindow = true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private void openNewEntryWindow(){
        if(!activeWindow){
            try {
                Application app = new NewAccountPopupWindow(entries, style, history, this);
                Stage stage = new Stage();
                app.start(stage);
                activeWindow = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void refreshTip(){
        tipLabel.setText(AdminHandler.tip);
    }

    public void reloadWebpage(){
        webview.getEngine().load(AdminHandler.scheduleURL);
    }

    private void saveChanges(){
        editEntryButton.setText("Edit Account");
        editing = false;
        updateEntry();
        disableEditing();
    }

    private void backupDatabase(){
        new BackupDatabase().start((Stage) mainPanel.getScene().getWindow());
    }

    private void updateEntry(int value){

        DatabaseManager.database.remove(currentEntry);

        if(value > 0){
            currentEntry.addPoints(value);
            DatabaseManager.addToHistory(value + " Point(s) were added to Account: [" + currentEntry.getFirstName() + " " + currentEntry.getLastName() + "]");


        }

        else if(value < 0){
            currentEntry.addPoints(value);
            if(currentEntry.getPoints() + value >= 0){
                DatabaseManager.addToHistory(value + " Point(s) were removed from Account: [" + currentEntry.getFirstName() + " " + currentEntry.getLastName() + "]");
            }

        }



        if(!currentEntry.getFirstName().equals(firstNameField.getText())){
            DatabaseManager.addToHistory("Account: [" + currentEntry.getFirstName() + " " + currentEntry.getLastName() + "] First Name Changed to: [" + firstNameField.getText() + "]");
            currentEntry.setFirstName(firstNameField.getText());
        }

        if(!currentEntry.getLastName().equals(lastNameField.getText())){
            DatabaseManager.addToHistory("Account: [" + currentEntry.getFirstName() + " " + currentEntry.getLastName() + "] Last Name Changed to: [" + lastNameField.getText() + "]");
            currentEntry.setLastName(lastNameField.getText());
        }

        if(!currentEntry.getPhoneNumber().equals(phoneNumberField.getText())){
            DatabaseManager.addToHistory("Account: [" + currentEntry.getFirstName() + " " + currentEntry.getLastName() + "] Phone Number Changed to: [" + phoneNumberField.getText() + "]");
            currentEntry.setPhoneNumber(phoneNumberField.getText());
        }

        if(!currentEntry.getComments().equals(notesField.getText())){
            DatabaseManager.addToHistory("Account: [" + currentEntry.getFirstName() + " " + currentEntry.getLastName() + "] Comments changed to: [" + notesField.getText() + "]");
            currentEntry.setComments(notesField.getText());
        }

        DatabaseManager.database.add(currentEntry);
        DatabaseManager.save(currentEntry);

        entries = DatabaseManager.database;

        databaseTable.setItems(entries);

        pullEntry(currentEntry);

    }

    private void updateEntry(){

        DatabaseManager.database.remove(currentEntry);

        if(!currentEntry.getFirstName().equals(firstNameField.getText())){
            DatabaseManager.addToHistory("Account: [" + currentEntry.getFirstName() + " " + currentEntry.getLastName() + "] First Name Changed to: [" + firstNameField.getText() + "]");
            currentEntry.setFirstName(firstNameField.getText());
        }

        if(!currentEntry.getLastName().equals(lastNameField.getText())){
            DatabaseManager.addToHistory("Account: [" + currentEntry.getFirstName() + " " + currentEntry.getLastName() + "] Last Name Changed to: [" + lastNameField.getText() + "]");
            currentEntry.setLastName(lastNameField.getText());
        }

        if(!currentEntry.getPhoneNumber().equals(phoneNumberField.getText())){
            DatabaseManager.addToHistory("Account: [" + currentEntry.getFirstName() + " " + currentEntry.getLastName() + "] Phone Number Changed to: [" + phoneNumberField.getText() + "]");
            currentEntry.setPhoneNumber(phoneNumberField.getText());
        }

        if(!currentEntry.getComments().equals(notesField.getText())){
            DatabaseManager.addToHistory("Account: [" + currentEntry.getFirstName() + " " + currentEntry.getLastName() + "] Comment added: [" + notesField.getText() + "]");
            currentEntry.setComments(notesField.getText());
        }

        DatabaseManager.database.add(currentEntry);
        DatabaseManager.save(currentEntry);

        entries = DatabaseManager.database;

        databaseTable.setItems(entries);

        pullEntry(currentEntry);

    }

    private void refresh(){

        appendField.setText("");
        pointsLabel.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        phoneNumberField.setText("");
        notesField.setText("");
        historyField.setText("");
        searchField.setText("");

        databaseTable.setItems(entries);
    }

    public void pullEntry(Entry entry){

        if(editing){
            saveChanges();
        }

        refresh();

        this.currentEntry = entry;

        appendField.setEditable(true);

        pointsLabel.setText(Integer.toString(entry.getPoints()));
        firstNameField.setText(entry.getFirstName());
        lastNameField.setText(entry.getLastName());
        phoneNumberField.setText(entry.getPhoneNumber());
        notesField.setText(entry.getComments());

        for (String item : entry.getHistory()) {
            historyField.appendText(item + "\n");
        }

        if(history.size() < 2 || !(history.get(1).equals("Entry Pulled: [" + entry.getFirstName() + " " + entry.getLastName() + "] Phone Number: [" + entry.getPhoneNumber() + "]"))) {

            DatabaseManager.addToHistory("Entry Pulled: [" + entry.getFirstName() + " " + entry.getLastName() + "] Phone Number: [" + entry.getPhoneNumber() + "]");

            searchHistoryList.setItems(history);

        }

    }

    private void clearFilter(){
        filteredEntries.clear();
    }

    private void filterList(String args){
        clearFilter();
        try{
            long phoneNumber = Long.parseLong(args);
            for(Entry entry : entries){
                try{
                    String[] phoneNumbers = entry.getPhoneNumber().split(" ");
                    if(phoneNumbers[0].contains(Long.toString(phoneNumber)) || phoneNumbers[1].contains(Long.toString(phoneNumber))){
                        filteredEntries.add(entry);
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){
                    if (entry.getPhoneNumber().contains(Long.toString(phoneNumber))){
                        filteredEntries.add(entry);
                    }
                }

            }
        } catch(NumberFormatException e){

            for(Entry entry : entries){
                if(entry.getFirstName().toLowerCase().contains(args.toLowerCase()) || entry.getLastName().toLowerCase().contains(args.toLowerCase())){
                    filteredEntries.add(entry);
                }
            }
        }

        databaseTable.setItems(filteredEntries);
        if(databaseTable.getItems().size() == 1){
            databaseTable.getSelectionModel().select(0);
        }
    }

    private void invertColors(String style){

        switch(style){
            case MIDNIGHTTAG:

                if(standardMenuItem.isSelected()){
                    standardMenuItem.setSelected(false);
                }
                midnightMenuItem.setSelected(true);
                titleLabel.setBlendMode(BlendMode.EXCLUSION);
                mainPanel.setBlendMode(BlendMode.EXCLUSION);
                menuBar.setBlendMode(BlendMode.EXCLUSION);
                mainPanel.getStylesheets().clear();
                mainPanel.getStylesheets().add(classLoader.getResource("stylesheets/MidnightStylesheet.css").toExternalForm());
                this.style = MIDNIGHTTAG;
                break;

            case STANDARDTAG:
                if(midnightMenuItem.isSelected()){
                    midnightMenuItem.setSelected(false);

                }
                standardMenuItem.setSelected(true);
                titleLabel.setBlendMode(BlendMode.DARKEN);
                mainPanel.setBlendMode(BlendMode.DARKEN);
                menuBar.setBlendMode(BlendMode.DARKEN);
                mainPanel.getStylesheets().clear();
                mainPanel.getStylesheets().add(classLoader.getResource("stylesheets/StandardStylesheet.css").toExternalForm());
                this.style = STANDARDTAG;

            break;
        }

    }


    //--------------------------------------------------------------------------------------------------------FXML INITIALIZATION----------------------------------------------------------------------------------

        @FXML
        private Label tipLabel;

        @FXML
        private MenuItem controlPanelMenuItem;

        @FXML
        private MenuItem editEntryHelpMenuItem;

        @FXML
        private ListView<String> searchHistoryList;

        @FXML
        public AnchorPane mainPanel;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private MenuItem aboutMenuItem;

        @FXML
        private Button addEntryButton;

        @FXML
        private MenuItem addPointHelpMenuItem;

        @FXML
        private TextField appendField;

        @FXML
        private Button clearButton;

        @FXML
        private Button closeButton;

        @FXML
        private MenuItem createNewEntryHelpMenuItem;

        @FXML
        private TableView<Entry> databaseTable;

        @FXML
        private Button editEntryButton;

        @FXML
        private TableColumn<?, ?> firstNameColumn;

        @FXML
        private TextField firstNameField;

        @FXML
        private TextArea historyField;

        @FXML
        private TableColumn<?, ?> lastNameColumn;

        @FXML
        private TextField lastNameField;

        @FXML
        private TextField searchField;

        @FXML
        private MenuBar menuBar;

        @FXML
        private RadioMenuItem midnightMenuItem;

        @FXML
        private Button minimizeButton;

        @FXML
        private MenuItem newEntryMenuItem;

        @FXML
        private TableColumn<?, ?> notesColumn;

        @FXML
        private TextField notesField;

        @FXML
        private TableColumn<?, ?> phoneNumberColumn;

        @FXML
        private TextField phoneNumberField;


        @FXML
        private TableColumn<?, ?> pointsColumn;

        @FXML
        private Label pointsLabel;

        @FXML
        private MenuItem saveMenuItem;

        @FXML
        private Button searchButton;

        @FXML
        private MenuItem searchHelpMenuItem;

        @FXML
        private RadioMenuItem standardMenuItem;

        @FXML
        private ToolBar titleBar;

        @FXML
        private ImageView titleLabel;

        @FXML
        private WebView webview;


        @FXML
        void initialize() {
            assert aboutMenuItem != null : "fx:id=\"aboutMenuItem\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert addEntryButton != null : "fx:id=\"addEntryButton\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert addPointHelpMenuItem != null : "fx:id=\"addPointHelpMenuItem\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert appendField != null : "fx:id=\"appendField\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert createNewEntryHelpMenuItem != null : "fx:id=\"createNewEntryHelpMenuItem\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert databaseTable != null : "fx:id=\"databaseTable\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert editEntryButton != null : "fx:id=\"editEntryButton\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert firstNameColumn != null : "fx:id=\"firstNameColumn\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert firstNameField != null : "fx:id=\"firstNameField\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert historyField != null : "fx:id=\"historyField\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert lastNameColumn != null : "fx:id=\"lastNameColumn\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert lastNameField != null : "fx:id=\"lastNameField\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert midnightMenuItem != null : "fx:id=\"midnightMenuItem\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert minimizeButton != null : "fx:id=\"minimizeButton\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert newEntryMenuItem != null : "fx:id=\"newEntryMenuItem\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert notesColumn != null : "fx:id=\"notesColumn\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert notesField != null : "fx:id=\"notesField\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert phoneNumberColumn != null : "fx:id=\"phoneNumberColumn\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert phoneNumberField != null : "fx:id=\"phoneNumberField\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert pointsColumn != null : "fx:id=\"pointsColumn\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert pointsLabel != null : "fx:id=\"pointsLabel\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert saveMenuItem != null : "fx:id=\"saveMenuItem\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert searchHelpMenuItem != null : "fx:id=\"searchHelpMenuItem\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert standardMenuItem != null : "fx:id=\"standardMenuItem\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert titleBar != null : "fx:id=\"titleBar\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert titleLabel != null : "fx:id=\"titleLabel\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";
            assert webview != null : "fx:id=\"webview\" was not injected: check your FXML file 'PointPlusUserInterface.fxml'.";


        }

}
