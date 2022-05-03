package com.kodilla.game.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class GameSettingsSceneController {



    @FXML
    private RadioButton radioButtonTriangle;
    @FXML
    private RadioButton radioButtonCircle;
    @FXML
    private RadioButton radioButtonCross;
    @FXML
    private ToggleGroup rbshape;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }


}
