package com.kodilla.game.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.kodilla.game.Game;
import com.kodilla.game.Statistics;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GameSettingsSceneController {

    @FXML
    private RadioButton radioButtonTriangle;
    @FXML
    private RadioButton radioButtonCircle;
    @FXML
    private RadioButton radioButtonCross;
    @FXML
    private Button buttonStartGame;
    @FXML
    TextField playerNameTextField;
    @FXML
    private ImageView imageShape;
    @FXML
    private ToggleGroup toggleGroupShape;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    private final static String crossImagePath = "/images/cross_32px.png";
    private final static String circleImagePath = "/images/circle_32px.png";
    private final static String triangleImagePath = "/images/triangle_32px.png";

    @FXML
    void initialize() {

    }

    public void getPlayerName() {
        String playerNameTemporary = playerNameTextField.getText();
        if (playerNameTemporary == null || playerNameTemporary.isBlank()) {
            System.out.println("no name");
        } else { Statistics.setPlayerName(playerNameTemporary); }
    }
    public void getChoosenShape() {
        Image circleImage = new Image(circleImagePath, 100.0, 100.0, true, true);
        Image triangleImage = new Image(triangleImagePath, 100.0, 100.0, true, true);
        Image crossImage = new Image(crossImagePath, 100.0, 100.0, true, true);

        toggleGroupShape.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (radioButtonCircle.isSelected()) { imageShape.setImage(circleImage); }
            if (radioButtonTriangle.isSelected()) { imageShape.setImage(triangleImage); }
            if (radioButtonCross.isSelected()) { imageShape.setImage(crossImage); }
        });
    }
    public void handleStartGameButton() throws Exception {
        Game game = new Game();
        game.start(new Stage());
    }
}