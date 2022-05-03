package com.kodilla.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //  Creating FXMLLoader and loading mainScene.fxml
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/mainScene.fxml"));
        Parent root = loader.load();

        //  Assigning mainScene.fxml as Parent to Scene
        Scene mainScene = new Scene(root);

        //  Assigning mainScene to Stage
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("First Scene");
        primaryStage.show();
    }
}