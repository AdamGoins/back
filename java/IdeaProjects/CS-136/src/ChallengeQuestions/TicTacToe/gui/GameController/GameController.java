package ChallengeQuestions.TicTacToe.gui.GameController;

import ChallengeQuestions.TicTacToe.gui.GameWindow.GameWindow;
import ChallengeQuestions.TicTacToe.gui.GameWindow.GameWindowController;
import ChallengeQuestions.TicTacToe.gui.StartingScreen.StartingScreen;
import ChallengeQuestions.TicTacToe.gui.StartingScreen.StartingScreenController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Created by root on 3/27/17.
 */
public final class GameController {

    static char[][] gameboard = new char[3][3];

    public static String playerOne = "";
    public static String playerTwo = "";

    private static String currentPlayer = playerOne;

    public static void main(String[] args){
        Platform.setImplicitExit(false);
        fillBoard();
        promptPlayerNames();
        startGame();
    }

    public static void makeMove(int buttonNumber, Object source){

        gameboard[buttonNumber / 3][buttonNumber % 3] = getCurrentPlayer().equals(playerOne) ? 'x' : 'o';
        verifyGameboard();
        changeCurrentPlayer();
    }

    private static void fillBoard() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                gameboard[row][column] = '_';
            }
        }
    }
    private static void verifyGameboard(){
        verifyRows();
        verifyColumns();
        verifyDiagonals();
        verifyStalemate();
    }

    private static boolean verifyStalemate(){

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(gameboard[i][j] == '_') return false;
            }
        }

        stalemate();
        return true;
    }

    private static void stalemate(){
        System.out.println("GAME ENDED");
        JOptionPane.showMessageDialog(null, "It was a draw!", "Stalemate!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static void verifyDiagonals(){
        int colIndex = 0;
        int occurences = 0;
        char startingChar = gameboard[0][0];
        if(!(startingChar == '_')){
            for(int row = 0; row < 3; row++){
                char currentChar = gameboard[row][colIndex];
                if(currentChar == startingChar){
                    occurences++;
                }
                colIndex++;
            }

            if(occurences == 3){
                endGame();
            }
        }

        occurences = 0;
        startingChar = gameboard[0][2];
        colIndex = 2;

        if(!(startingChar == '_')){
            for(int row = 0; row < 3; row++){
                char currentChar = gameboard[row][colIndex];
                if(currentChar == startingChar){
                    occurences++;
                }
                colIndex--;
            }

            if(occurences == 3){
                endGame();
            }
        }


    }

    private static void verifyColumns(){

        for(int row = 0; row < 3; row++) {
            int occurences = 0;
            char colChar = gameboard[0][row];
            System.out.println(colChar);
            if(colChar == '_') continue;
            for (int column = 0; column < 3; column++) {
                char currentCharacter = gameboard[column][row];
                if(colChar == currentCharacter) occurences += 1;

            }
            if(occurences == 3){
                endGame();
            }
        }
    }

    private static void verifyRows(){
        for(int row = 0; row < 3; row++) {
            int occurences = 0;
            char rowChar = gameboard[row][0];
            System.out.println(rowChar);
            if(rowChar == '_') continue;
            for (int column = 0; column < 3; column++) {
                char currentCharacter = gameboard[row][column];
                if(rowChar == currentCharacter) occurences += 1;

            }
            if(occurences == 3) {
                endGame();
            }
        }
    }

    private static void endGame(){
        System.out.println("GAME ENDED");
        JOptionPane.showMessageDialog(null, getCurrentPlayer() + " wins!", getCurrentPlayer() + " is the winner!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static String getGameboard(){
        String board = "";
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column++){
                board+= gameboard[row][column] + "   ";
            }
            board += "\n";
        }

        return board;
    }

    private static void changeCurrentPlayer(){
        currentPlayer = getCurrentPlayer().equals(playerOne) ? playerTwo : playerOne;
    }

    public static String getCurrentPlayer(){
        return currentPlayer;
    }

    public static void promptPlayerNames(){
        setCurrentPlayer(playerOne);
    }

    public static void setCurrentPlayer(String player){
        currentPlayer = player;
    }
    private static void startGame(){
        Application.launch(GameWindow.class, new String[]{});
    }

    public static void reset(){
        Application.launch(GameWindow.class, new String[]{});
    }


}
