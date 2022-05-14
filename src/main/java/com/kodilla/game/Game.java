package com.kodilla.game;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Hello world");
        Statistics.fxmlLoader.setLocation(getClass().getResource("/fxml/gameScene.fxml"));
        Parent root = Statistics.fxmlLoader.load();
//        Parent root = new GridPane();
        Scene gameScene = new Scene(root);
        gameScene.getStylesheets().add(getClass().getResource("/css/gameScene.css").toExternalForm());
        StartGame.mainView.setScene(gameScene);
    }
}
