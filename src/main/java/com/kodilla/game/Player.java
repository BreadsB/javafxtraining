package com.kodilla.game;

import javafx.scene.image.Image;

public class Player {

    private String playerName;
    private Image image;
    public Player(String playerName, Image image) {
        this.playerName = playerName;
        this.image = image;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
