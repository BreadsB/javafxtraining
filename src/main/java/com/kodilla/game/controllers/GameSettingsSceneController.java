package com.kodilla.game.controllers;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.kodilla.game.Game;
import com.kodilla.game.Player;
import com.kodilla.game.Statistics;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GameSettingsSceneController {

    private final Image circleImage = new Image(String.valueOf(getClass().getResource(circleImagePath)), 100.0, 100.0, true, true);
    private final Image triangleImage = new Image(String.valueOf(getClass().getResource(triangleImagePath)), 100.0, 100.0, true, true);
    private final Image crossImage = new Image(String.valueOf(getClass().getResource(crossImagePath)), 100.0, 100.0, true, true);
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

        toggleGroupShape.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton rb = (RadioButton) toggleGroupShape.getSelectedToggle();

            if (rb!=null) {
                if (rb.getText().equals("Circle")) {
                    imageShape.setImage(circleImage);
                    System.out.println(circleImage);

                } else if (rb.getText().equals("Cross")) {
                    imageShape.setImage(crossImage);
                } else if (rb.getText().equals("Triangle")) {
                    imageShape.setImage(triangleImage);
                } else {
                    System.out.println("error");
                }
            } else {
                System.out.println("Error");
            }
        });
    }
    public void handleStartGameButton() throws Exception {
        String playerNameTemporary = playerNameTextField.getText();
        if (playerNameTemporary==null) {
            System.out.println("playerName null");
        } else if (playerNameTemporary.isBlank()) {
            System.out.println("playerName blank");
        } else if (toggleGroupShape.getSelectedToggle()==null) {
            System.out.println("ToogleGroup not assigned");
        } else {
            Statistics.setPlayerName(playerNameTemporary);

            Player player = new Player(playerNameTemporary, imageShape.getImage());
            System.out.println(player.getPlayerName());
            System.out.println(player.getImage());

            Game game = new Game();
            game.start(new Stage());
        }
    }
}