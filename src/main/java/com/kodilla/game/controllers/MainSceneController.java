package com.kodilla.game.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController {
    @FXML
    private Button btnStart; // Assigning button id from fxml to java. Must be declared as @FXML!
    private URL location;
    private ResourceBundle resources;

    public MainSceneController() {

    }
    @FXML
    public void initialize() {

    }

    /* Method changing scene to SettingsScene */
    @FXML // <---- HERE MUST BE @FXML, OTHERWISE SCENEBUILDER WONT SEE THIS METHOD!
    // ALSO YOU NEED TO WRITE METHOD IN INPUT WINDOW #handleStartButton
    public void handleStartButton() throws Exception {

        //  Creating new FXMLLoader object and assigning gameSettings.fxml scene
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/gameSettings.fxml"));
        Parent root = fxmlLoader.load();
        Scene settingsScene = new Scene(root);
        settingsScene.getStylesheets().add(getClass().getResource("/css/gameSettings.css").toExternalForm());

        //  Setting scene to a Stage
        Stage window = (Stage) btnStart.getScene().getWindow();
        window.setScene(settingsScene);

        /* btnStart odwołuje się do FXML, getScene pobiera scenę w której znajduje się btnStart,
        getWindow pobiera okno z getScene */
    }
}
