package gui.help_windows;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.PointPlusFXMLController;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Adam on 7/25/2016.
 */
public class HelpWindowController implements Initializable {

    private PointPlusFXMLController controller;
    private ClassLoader classLoader = this.getClass().getClassLoader();

    private String key;
    private String style;

    private final String MIDNIGHTTAG = "[MIDNIGHT]";
    private final String STANDARDTAG = "[STANDARD]";
    private final String SEARCHHELPTAG = "[SEARCH]";
    private final String CHANGEPOINTSTAG = "[CHANGEPOINTS]";
    private final String EDITACCOUNTTAG = "[EDIT]";
    private final String CREATEACCOUNTTAG = "[CREATEACCOUNT]";

    private Image[] images;
    private String[] details;
    private int limit;
    private int stage = 0;

    private double xOffset;
    private double yOffset;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setGraphics();
        createListeners();


    }

    private void setGraphics(){

        ImageView closeIcon = new ImageView();
        closeIcon.setImage(new Image(classLoader.getResourceAsStream("images/closeIcon.png")));
        closeIcon.setFitWidth(15);
        closeIcon.setFitHeight(15);
        closeIcon.setBlendMode(BlendMode.EXCLUSION);
        closeButton.setGraphic(closeIcon);

        titleImageView.setImage(new Image(classLoader.getResourceAsStream("images/helpIcon.png")));

        ImageView rightIcon = new ImageView();
        rightIcon.setImage(new Image(classLoader.getResourceAsStream("images/navigateRightIcon.png")));
        rightIcon.setFitWidth(30);
        rightIcon.setFitHeight(30);
        rightIcon.setBlendMode(BlendMode.EXCLUSION);
        navigateRightButton.setGraphic(rightIcon);


        ImageView leftIcon = new ImageView();
        leftIcon.setImage(new Image(classLoader.getResourceAsStream("images/navigateLeftIcon.png")));
        leftIcon.setFitWidth(30);
        leftIcon.setFitHeight(30);
        leftIcon.setBlendMode(BlendMode.EXCLUSION);
        leftIcon.setScaleX(-1);
        navigateLeftButton.setGraphic(leftIcon);

    }

    private void createListeners(){

        closeButton.setOnAction(Event ->{
            closeWindow();
        });

        navigateRightButton.setOnAction(Event -> navigateRight());
        navigateLeftButton.setOnAction(Event -> navigateLeft());

        titleBar.setOnMousePressed(Event -> {
            xOffset = titleBar.getScene().getWindow().getX() - MouseInfo.getPointerInfo().getLocation().getX();
            yOffset = titleBar.getScene().getWindow().getY() - MouseInfo.getPointerInfo().getLocation().getY();
        });
        titleBar.setOnMouseDragged(Event -> {
            titleBar.getScene().getWindow().setX(MouseInfo.getPointerInfo().getLocation().getX() + xOffset);
            titleBar.getScene().getWindow().setY(MouseInfo.getPointerInfo().getLocation().getY() + yOffset);

        });
    }

    private void closeWindow(){
        controller.activeWindow = false;
        controller.mainPanel.setDisable(false);
        ((Stage) mainPanel.getScene().getWindow()).close();
    }

    private void navigateRight(){

        if(stage < limit){
            stage++;
            pictureImageView.setImage(images[stage]);
            infoLabel.setText(details[stage]);

            slideLabel.setText((stage + 1) + "/" + (limit + 1));
        }



    }

    private void navigateLeft(){

        if(stage > 0){
            stage--;
            pictureImageView.setImage(images[stage]);
            infoLabel.setText(details[stage]);

            slideLabel.setText((stage + 1) + "/" + (limit + 1));
        }


    }

    private void load(){
        switch(key){
            case SEARCHHELPTAG:
                loadSearchHelp();
                break;

            case CHANGEPOINTSTAG:
                loadPointsHelp();
                break;

            case EDITACCOUNTTAG:
                loadEditHelp();
                break;

            case CREATEACCOUNTTAG:
                loadCreateHelp();
                break;
        }
    }

    private void loadSearchHelp(){

        helpLabel.setText("Search Account Help");

        limit = 2;
        images = new Image[3];
        details = new String[3];

        slideLabel.setText(1 + "/" + (limit + 1));

        images[0] = new Image(classLoader.getResourceAsStream("images/help_pictures/SearchImageOne.png"));
        images[1] = new Image(classLoader.getResourceAsStream("images/help_pictures/SearchImageTwo.png"));
        images[2] = new Image(classLoader.getResourceAsStream("images/help_pictures/SearchImageThree.png"));

        details[0] = "Searching for an Existing Account can be done by using the Search Bar circled in the picture above." +
                "\nNames or Phone Numbers can be entered as input and the Search Bar dynamically reads what you enter and adjusts its search accordingly." +
                "\nFor example, if you begin typing in numbers it will search the database for Accounts that have a matching phone number." +
                "\nIf you input letters, it will search the Database for Accounts that have a First or Last Name that contain the letters you enter. There's no need to specify." +
                "\nAn example can be seen on the next slide.";

        details[1] = "As pictured above, the numbers \"928757\" were entered into the Search Field [Item #1] and it immediately filtered the Database down to Accounts that had matching Phone Numbers." +
                "\nBecause There's only one account in the filtered list, we can either hit the \"Enter\" key, or double click that account in the Database Table [Item #2] to retrieve that Account." +
                "\nIf more than one Account is returned in the filtered results, you will have to manually double click the Account name in the Database Table to retrieve the Account.";

        details[2] = "Once an Account is retrieved, all of it's data will be displayed in the above outlined box. The Attributes are as follows:" +
                "\n1: Point Label: This label displays the running total of the available points for an account. For every 10 points, $1 can be removed from the Customer's total." +
                "\n2: Append Field: This field is where an Employee can add or remove points from an Account." +
                "\n3: First Name Field: Displays the First Name of the Account Holder." +
                "\n4: Last Name Field: Displays the Last Name of the Account Holder." +
                "\n5: Phone Number Field: Displays the Phone Number of the Account Holder." +
                "\n6: Comments Field: Displays any Comments the store may have for the Account." +
                "\n7: History Field: Displays History of all changes made to the Account.";

        pictureImageView.setImage(images[0]);
        infoLabel.setText(details[0]);

    }

    private void loadPointsHelp(){

        helpLabel.setText("Add/Remove Points Help");

        limit = 1;
        images = new Image[2];
        details = new String[2];

        slideLabel.setText(1 + "/" + (limit + 1));

        images[0] = new Image(classLoader.getResourceAsStream("images/help_pictures/AddPointsImageOne.png"));
        images[1] = new Image(classLoader.getResourceAsStream("images/help_pictures/AddPointsImageTwo.png"));

        details[0] = "Once we have an Account pulled, we can add/remove points from the Account by typing the point value into the Append Field circled in the picture above and hitting the \"Enter\" key." +
                "\nTo add points to an Account, you'll input a positive integer ranging from 1-100." +
                "\nFor Example, if we wanted to add 50 points to the Account, we would input \"50\" or \"+50\" into the Append Field and hit \"Enter\"." +
                "\nTo remove points from an Account, we would input a negative integer no greater than the total point value on the Account." +
                "\nFor Example, if we wanted to remove 20 points from the Account, we would input \"-20\" into the Append Field and hit \"Enter\"." +
                "\nAn Account cannot have a negative point value, therefore if you try to remove more points than an Account has you will be prompted to change the amount removed." +
                "\nOnce you have the desired amount of points, you can apply them directly to the Account by hitting the \"Enter\" key.";

        details[1] = "As you can see, the points were successfully added to the account. You can see the changes reflected in the Points Label [Item No.1]" +
                "\nThe history of the change is logged in the Account History Field [Item No.2] and also logged in the Global History List [Item No.3]";


        pictureImageView.setImage(images[0]);
        infoLabel.setText(details[0]);
    }

    private void loadEditHelp(){

        helpLabel.setText("Edit Account Help");

        limit = 2;
        images = new Image[3];
        details = new String[3];

        slideLabel.setText(1 + "/" + (limit + 1));

        images[0] = new Image(classLoader.getResourceAsStream("images/help_pictures/EditEntryImageOne.png"));
        images[1] = new Image(classLoader.getResourceAsStream("images/help_pictures/EditEntryImageTwo.png"));
        images[2] = new Image(classLoader.getResourceAsStream("images/help_pictures/EditEntryImageThree.png"));

        details[0] = "An Account can be edited at any time by selecting the \"Edit Account\" Button pictured above.";
        details[1] = "Once clicked, the Text Fields [Item No.1] containing the Account Information become editable. Any changes made to these Fields will be implemented to the Account." +
                     "\nOnce we have made the desired changes, we can click the \"Save Changes\" Button located where the \"Edit Account\" Button was before.";
        details[2] = "Once the \"Save Changes\" Button is hit, the applied changes will be saved to the Account." +
                "\nIn this case, we changed \"Jimmy Test's\" First Name to \"Jim.\"" +
                "\nThe changes were applied [Item No.1] and the \"Save Entry\" Button reverted back to \"Edit Account.\"" +
                "\nA log of the changes is be created [Item No.2] and added directly to the Account History, as well as added to the Global History [Item No.3].";

        pictureImageView.setImage(images[0]);
        infoLabel.setText(details[0]);


    }

    private void loadCreateHelp(){

        helpLabel.setText("Create New Account Help");

        limit = 3;
        images = new Image[4];
        details = new String[4];

        slideLabel.setText(1 + "/" + (limit + 1));

        images[0] = new Image(classLoader.getResourceAsStream("images/help_pictures/CreateAccountImageOne.png"));
        images[1] = new Image(classLoader.getResourceAsStream("images/help_pictures/CreateAccountImageTwo.png"));
        images[2] = new Image(classLoader.getResourceAsStream("images/help_pictures/CreateAccountImageThree.png"));
        images[3] = new Image(classLoader.getResourceAsStream("images/help_pictures/CreateAccountImageFour.png"));

        details[0] = "Creating a new Account can be done by clicking the \"Create Account\" Button pictured above." +
                "\nThis will open up a second interface in which the attributes for the Account can be set.";
        details[1] = "This window contains several fields where you can set the starting points, name, number, and any comments for the Account." +
                "\nLet's put some values into these fields for our new Account.";
        details[2] = "We've added some values to the Account [Item No.1], we can now click the \"Create Account\" Button [Item No.2] to add our new Account to the System.";
        details[3] = "Once the Account is created, the System will automatically pull the Account and display it's information in the main interface [Item No.1]." +
                "\nA log that the Account was created and pulled is stored in the Global History [Item No.2]." +
                "\nThe new Account is saved and displayed in the Account Database [Item No.3].";

        pictureImageView.setImage(images[0]);
        infoLabel.setText(details[0]);

    }

    private void loadStyle(){
        switch(style){
            case MIDNIGHTTAG:
                mainPanel.setBlendMode(BlendMode.EXCLUSION);
                break;

            case STANDARDTAG:
                mainPanel.setBlendMode(BlendMode.DARKEN);
                titleImageView.setBlendMode(BlendMode.DARKEN);
                break;

            default:
                System.out.println("Cannot load style for tag: " + style);
                break;
        }
    }

    public void start(String key, String style, PointPlusFXMLController controller){
        this.key = key;
        this.style = style;
        this.controller = controller;
        controller.activeWindow = true;
        loadStyle();
        load();
        controller.mainPanel.setDisable(true);

    }

    //--------------------------------------------------JAVA INSTANTIATION----------------------------------------------


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button closeButton;

    @FXML
    private Label helpLabel;

    @FXML
    private Label infoLabel;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private Button navigateLeftButton;

    @FXML
    private Button navigateRightButton;

    @FXML
    private ImageView pictureImageView;

    @FXML
    private Label slideLabel;

    @FXML
    private ToolBar titleBar;

    @FXML
    private ImageView titleImageView;


    @FXML
    void initialize() {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file \"BlankHelpWindowFXML.fxml\".";
        assert helpLabel != null : "fx:id=\"helpLabel\" was not injected: check your FXML file \"BlankHelpWindowFXML.fxml\".";
        assert infoLabel != null : "fx:id=\"infoLabel\" was not injected: check your FXML file \"BlankHelpWindowFXML.fxml\".";
        assert mainPanel != null : "fx:id=\"mainPanel\" was not injected: check your FXML file \"BlankHelpWindowFXML.fxml\".";
        assert navigateLeftButton != null : "fx:id=\"navigateLeftButton\" was not injected: check your FXML file \"BlankHelpWindowFXML.fxml\".";
        assert navigateRightButton != null : "fx:id=\"navigateRightButton\" was not injected: check your FXML file \"BlankHelpWindowFXML.fxml\".";
        assert pictureImageView != null : "fx:id=\"pictureImageView\" was not injected: check your FXML file \"BlankHelpWindowFXML.fxml\".";
        assert slideLabel != null : "fx:id=\"slideLabel\" was not injected: check your FXML file \"BlankHelpWindowFXML.fxml\".";
        assert titleBar != null : "fx:id=\"titleBar\" was not injected: check your FXML file \"BlankHelpWindowFXML.fxml\".";
        assert titleImageView != null : "fx:id=\"titleImageView\" was not injected: check your FXML file \"BlankHelpWindowFXML.fxml\".";


    }


}
