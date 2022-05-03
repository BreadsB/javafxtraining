package com.kodilla.game.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private Button btnStart;

    /* Method changing Scene */

    public void handleStartButton() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/mainScene.fxml"));
        Parent root = fxmlLoader.load();
        Scene settingsScene = new Scene(root);

        Stage window = (Stage) btnStart.getScene().getWindow();
        window.setScene(settingsScene);
    }
}
