package com.kodilla.game.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import com.kodilla.game.Game;
import com.kodilla.game.Player;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GameSettingsSceneController {

    private final Image circleImage = new Image(String.valueOf(getClass().getResource(circleImagePath)), 100.0, 100.0, true, true);
    private final Image triangleImage = new Image(String.valueOf(getClass().getResource(triangleImagePath)), 100.0, 100.0, true, true);
    private final Image crossImage = new Image(String.valueOf(getClass().getResource(crossImagePath)), 100.0, 100.0, true, true);
    protected static Image aiImage;
    @FXML
    private TextField playerNameTextField;
    @FXML
    private ImageView imageShape;
    @FXML
    private ToggleGroup toggleGroupShape;
    private final static String crossImagePath = "/images/cross_32px.png";
    private final static String circleImagePath = "/images/circle_32px.png";
    private final static String triangleImagePath = "/images/triangle_32px.png";
    Random random = new Random();

    @FXML
    void initialize() {

        List<Image> imageList = new ArrayList<>(List.of(circleImage, triangleImage, crossImage));

        toggleGroupShape.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {

            RadioButton rb = (RadioButton) toggleGroupShape.getSelectedToggle();

            if (rb!=null) {
                if (rb.getText().equals("Circle")) {
                    imageShape.setImage(circleImage);
                    System.out.println(imageList.size());
                } else if (rb.getText().equals("Cross")) {
                    imageShape.setImage(crossImage);
                    System.out.println(imageList.size());
                } else if (rb.getText().equals("Triangle")) {
                    imageShape.setImage(triangleImage);
                    System.out.println(imageList.size());
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
            new Player(playerNameTemporary, imageShape.getImage());

            try {
                List<Image> imageList = new ArrayList<>(List.of(circleImage, crossImage, triangleImage));
                imageList.remove(imageShape.getImage());
                aiImage = imageList.get(random.nextInt(imageList.size()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            Game game = new Game();
            game.start(new Stage());
        }
    }
}