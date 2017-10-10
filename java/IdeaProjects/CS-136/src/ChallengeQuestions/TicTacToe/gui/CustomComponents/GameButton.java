package ChallengeQuestions.TicTacToe.gui.CustomComponents;

import ChallengeQuestions.TicTacToe.gui.GameController.GameController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by root on 3/27/17.
 */
public class GameButton extends Button {

    private String relativePath;


    public GameButton(){
        relativePath = "ChallengeQuestions/TicTacToe/gui/";
    }

    public void click(String player){
        if(player.equals(GameController.playerOne)){
            this.setGraphic(new ImageView(new Image(relativePath + "Images/X-icon.png")));

        }

    }

}
