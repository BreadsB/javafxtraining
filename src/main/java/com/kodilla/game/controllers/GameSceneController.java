package com.kodilla.game.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    Image circleImage = new Image(getClass().getResource("/images/circle_32px.png").toExternalForm());
    Image crossImage = new Image(getClass().getResource("/images/cross_32px.png").toExternalForm());

    boolean playersTurn = true;
    int moveCount;
    static String[] winnersStrike = new String[] {"yes", "yes", "yes"};

    Alert a = new Alert(Alert.AlertType.CONFIRMATION);

    @FXML
    void initialize() {
        gamesGrid.setGridLinesVisible(true);

    }

    public void countMovementLeft() {
        Stream<Node> listImageView = gamesGrid.getChildren().stream()
                .filter(node -> node instanceof ImageView);

        moveCount = (int) listImageView
                .filter(node -> !node.isDisabled())
                .count();

        if (moveCount==0) {

            a.setContentText("Tie!");
            Optional<ButtonType> result = a.showAndWait();
            if (result.get() == ButtonType.OK) {
                Platform.exit();
                System.exit(0);
            }
        }
    }

    public static String checkImage(ImageView object, Image checkingImage) {
        if (object.getImage()==checkingImage) {
            return "yes";
        } else {
            return "no";
        }
    }

    public String checkWinner(boolean playersTurn) {
        if (playersTurn) {
            return checkStrike(circleImage);
        } else {
            return checkStrike(crossImage);
        }
    }

    String checkStrike(Image image) {

        String[] strike = null;
        String first;
        String second;
        String third;

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    first = checkImage(c0r0, image);
                    second = checkImage(c0r1, image);
                    third = checkImage(c0r2, image);
                    strike = new String[]{first, second, third};
                    break;
                case 1:
                    first = checkImage(c1r0, image);
                    second = checkImage(c1r1, image);
                    third = checkImage(c1r2, image);
                    strike = new String[]{first, second, third};
                    break;
                case 2:
                    first = checkImage(c2r0, image);
                    second = checkImage(c2r1, image);
                    third = checkImage(c2r2, image);
                    strike = new String[]{first, second, third};
                    break;
                case 3:
                    first = checkImage(c0r0, image);
                    second = checkImage(c1r0, image);
                    third = checkImage(c2r0, image);
                    strike = new String[]{first, second, third};
                    break;
                case 4:
                    first = checkImage(c0r1, image);
                    second = checkImage(c1r1, image);
                    third = checkImage(c2r1, image);
                    strike = new String[]{first, second, third};
                    break;
                case 5:
                    first = checkImage(c0r2, image);
                    second = checkImage(c1r2, image);
                    third = checkImage(c2r2, image);
                    strike = new String[]{first, second, third};
                    break;
                case 6:
                    first = checkImage(c0r0, image);
                    second = checkImage(c1r1, image);
                    third = checkImage(c2r2, image);
                    strike = new String[]{first, second, third};
                    break;
                case 7:
                    first = checkImage(c2r0, image);
                    second = checkImage(c1r1, image);
                    third = checkImage(c0r2, image);
                    strike = new String[]{first, second, third};
                    break;
            }
            if(Arrays.equals(strike, winnersStrike)) {
                return "win";
            }
        }
        return null;
    }

    public ImageView opponentMove() {
        List<ImageView> listOfEmpty;
        listOfEmpty = gamesGrid.getChildren().stream()
                .filter(node -> node instanceof ImageView)
                .filter(node -> !node.isDisabled())
                .map(node -> (ImageView) node)
                .collect(Collectors.toList());
        Random rand = new Random();
        return listOfEmpty.get(rand.nextInt(listOfEmpty.size()));
    }

    public void addMark(MouseEvent mouseEvent) {
        ImageView clicked = (ImageView) mouseEvent.getSource();

        if (clicked.getImage() == null) {
            if (playersTurn) {
                clicked.setImage(circleImage);
                clicked.setDisable(true);
                if (Objects.equals(checkWinner(playersTurn), "win")) {
                    a.setContentText("Circle Winner!");
                    Optional<ButtonType> result = a.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        Platform.exit();
                        System.exit(0);
                    }
                }
                countMovementLeft();
                playersTurn = false;

                ImageView randomImgView = opponentMove();
                randomImgView.setImage(crossImage);
                randomImgView.setDisable(true);

                if (Objects.equals(checkWinner(playersTurn), "win")) {
                    a.setContentText("Cross Winner!");
                    Optional<ButtonType> result = a.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        Platform.exit();
                        System.exit(0);
                    }
                }
                countMovementLeft();
                playersTurn = true;
            }
        }

        System.out.println("Count: " + moveCount);
    }


}