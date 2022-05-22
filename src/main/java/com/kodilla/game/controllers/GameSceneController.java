package com.kodilla.game.controllers;

import com.kodilla.game.Player;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.*;
import java.util.stream.Collectors;

public class GameSceneController {

    @FXML
    public GridPane gamesGrid;
    @FXML
    private ImageView c0r0;
    @FXML
    public ImageView c1r0;
    @FXML
    public ImageView c2r0;
    @FXML
    public ImageView c0r1;
    @FXML
    public ImageView c1r1;
    @FXML
    public ImageView c2r1;
    @FXML
    public ImageView c0r2;
    @FXML
    public ImageView c1r2;
    @FXML
    public ImageView c2r2;
    Image circleImage = new Image(String.valueOf(getClass().getResource("/images/circle_32px.png")));
    Image playerImage = Player.getImage();
    Image crossImage = new Image(String.valueOf(getClass().getResource("/images/cross_32px.png")));

    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
    Random random = new Random();
    Image aiImage = GameSettingsSceneController.aiImage;
    boolean playersTurn = false;
    int moveCount = 0;
    static boolean[] winnersStrike = new boolean[]{true, true, true};
    boolean endgame = false;
    List<ImageView> emptyListOfViews = null;

    void pcMove() {
        emptyListOfViews = listOfEmptyFields();
        ImageView randomImageView = emptyListOfViews.get(random.nextInt(listOfEmptyFields().size()));
        randomImageView.setImage(aiImage);
        randomImageView.setDisable(true);

        if (checkStrike(aiImage)) {
            endgame = true;
            shutDown("PC wins");
        }
        System.out.println(++moveCount);
    }

    @FXML
    void initialize() {

        gamesGrid.setGridLinesVisible(true);
        List<ImageView> gridElements = gamesGrid.getChildren().stream()
                .filter(node -> node instanceof ImageView)
                .map(node -> (ImageView) node)
                .collect(Collectors.toList());

        System.out.println(gridElements.size());

        if (playersTurn) {
            playerMoveClicked();
        } else {
            pcMove();
            playerMoveClicked();
        }
    }

    void playerMoveClicked() {
        gamesGrid.getChildren().stream()
                .filter(node -> node instanceof ImageView)
                .map(node -> (ImageView) node)
                .forEach(imageView -> imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        imageView.setImage(playerImage);
                        imageView.setDisable(true);
                        if (checkStrike(playerImage)) {
                            endgame = true;
                            shutDown("Player wins");
                        }
                        moveCount++;
                        pcMove();
                    }
                }));
    }

    boolean checkImage(ImageView imageView, Image image) {
        Image imageViewImage = imageView.getImage();
        return Objects.equals(imageViewImage, image);
    }

    boolean checkStrike(Image image) {

        boolean[] strike = null;

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    strike = new boolean[]{checkImage(c0r0, image), checkImage(c0r1, image), checkImage(c0r2, image)};
                    break;
                case 1:
                    strike = new boolean[]{checkImage(c1r0, image), checkImage(c1r1, image), checkImage(c1r2, image)};
                    break;
                case 2:
                    strike = new boolean[]{checkImage(c2r0, image), checkImage(c2r1, image), checkImage(c2r2, image)};
                    break;
                case 3:
                    strike = new boolean[]{checkImage(c0r0, image), checkImage(c1r0, image), checkImage(c2r0, image)};
                    break;
                case 4:
                    strike = new boolean[]{checkImage(c0r1, image), checkImage(c1r1, image), checkImage(c2r1, image)};
                    break;
                case 5:
                    strike = new boolean[]{checkImage(c0r2, image), checkImage(c1r2, image), checkImage(c2r2, image)};
                    break;
                case 6:
                    strike = new boolean[]{checkImage(c0r0, image), checkImage(c1r1, image), checkImage(c2r2, image)};
                    break;
                case 7:
                    strike = new boolean[]{checkImage(c2r0, image), checkImage(c1r1, image), checkImage(c0r2, image)};
                    break;
            }
            if(Arrays.equals(strike, winnersStrike)) {
                return true;
            }
        }
        return false;
    }

    List<ImageView> listOfEmptyFields() {
        return gamesGrid.getChildren().stream()
                .filter(node -> node instanceof ImageView)
                .map(node -> (ImageView) node)
                .filter(node -> !node.isDisabled())
                .collect(Collectors.toList());
    }

    void shutDown(String text) {
        a.setContentText(text);
        Optional<ButtonType> button = a.showAndWait();
        if (button.isPresent()) {
            if (button.get()==ButtonType.OK) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}