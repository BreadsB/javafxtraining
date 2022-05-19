package com.kodilla.game;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Statistics.fxmlLoader.setLocation(getClass().getResource("/fxml/gameScene.fxml"));
            Parent root = Statistics.fxmlLoader.load();
            Scene gameScene = new Scene(root);
            gameScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/gameScene.css")).toExternalForm());
            StartGame.mainView.setScene(gameScene);
    }
}
