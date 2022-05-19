package com.kodilla.game;

import javafx.scene.image.Image;

public final class Player {

    private final String playerName;
    private final Image image;
    public Player(final String playerName, final Image image) {
        this.playerName = playerName;
        this.image = image;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Image getImage() {
        return image;
    }
}
