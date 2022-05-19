package com.kodilla.game.controllers;

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
    List<ImageView> listFreeFields;
    private final Random random = new Random();
    @FXML
    private GridPane gamesGrid;
    @FXML
    private ImageView c0r0;
    @FXML
    private ImageView c0r1;
    @FXML
    private ImageView c0r2;
    @FXML
    private ImageView c1r0;
    @FXML
    private ImageView c1r1;
    @FXML
    private ImageView c1r2;
    @FXML
    private ImageView c2r0;
    @FXML
    private ImageView c2r1;
    @FXML
    private ImageView c2r2;

    private final Image circleImage = new Image(String.valueOf(getClass().getResource("/images/circle_32px.png")));
    private final Image crossImage = new Image(String.valueOf(getClass().getResource("/images/cross_32px.png")));

    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
    public GameSceneController() {
    }

    boolean checkImage(ImageView inputImageView, Image image) {
        if (Objects.equals(inputImageView.getImage(), image)) {
            return true;
        } else {
            return false;
        }
    }
    boolean checkWinner(Image image) {

        boolean[] strike = null;
        boolean[] winnerStrike = new boolean[]{true, true, true};
        for (int i=0; i<8; i++) {
            switch(i) {
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
                    strike = new boolean[]{checkImage(c0r2, image), checkImage(c1r1, image), checkImage(c2r0, image)};
                    break;
            }
            if (Arrays.equals(strike, winnerStrike)) {
                return true;
            }
        }
        return false;
    }
    public List<ImageView> getListOfEmptyFields() {
        return gamesGrid.getChildren().stream()
                .filter(node -> node instanceof ImageView)
                .map(node -> (ImageView) node)
                .filter(node -> node.getImage()==null)
                .collect(Collectors.toList());
    }

    @FXML
    private void initialize() {
        gamesGrid.setGridLinesVisible(true);
//        boolean playerTurn = random.nextBoolean();
        boolean playerTurn = true;
        int countMovements = 0;
        boolean win;

        if (playerTurn) {
            gamesGrid.getChildren().forEach(node -> {
                node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        ImageView tmp = (ImageView) event.getPickResult().getIntersectedNode();
                        tmp.setImage(circleImage);
                        tmp.setDisable(true);
                    }
                });
            });
            win = checkWinner(circleImage);
            if (win) {
                a.setContentText("Circle won!");
                Optional<ButtonType> endButton = a.showAndWait();
                if(endButton.get() == ButtonType.OK) {
                    Platform.exit();
                    System.exit(0);
                }
            }
            playerTurn = false;
        } else {
            listFreeFields = getListOfEmptyFields();
            ImageView randomEmptyField = listFreeFields.get(random.nextInt(listFreeFields.size()));
            randomEmptyField.setImage(crossImage);
            randomEmptyField.setDisable(true);
            win = checkWinner(crossImage);
            if (win) {
                a.setContentText("Cross won!");
                Optional<ButtonType> endButton = a.showAndWait();
                if(endButton.get() == ButtonType.OK) {
                    Platform.exit();
                    System.exit(0);
                }
            }
            playerTurn = true;
        }
    }
}
