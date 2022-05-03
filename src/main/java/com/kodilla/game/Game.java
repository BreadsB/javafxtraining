package com.kodilla.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/mainScene.fxml"));
        Parent root = loader.load();
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);

        primaryStage.setTitle("First Scene");
        primaryStage.show();
    }
}