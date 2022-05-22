package com.kodilla.game;

import com.kodilla.game.controllers.GameSceneController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("GameScene starting");
        Statistics.fxmlLoader.setLocation(getClass().getResource("/fxml/gameScene.fxml"));


        try {
            Parent root = Statistics.fxmlLoader.load();
            Scene gameScene = new Scene(root);
            gameScene.getStylesheets().add(String.valueOf(getClass().getResource("/css/gameScene.css")));
            StartGame.mainView.setScene(gameScene);
            StartGame.mainView.setTitle("TicTacToe game - " + Player.getPlayerName() + " vs AI");
        } catch (Exception exception) {
            System.out.println("Error at loading FXML! Probably wrong .fxml file or .css file");
        }
    }
}
