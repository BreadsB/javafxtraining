package com.kodilla.game;

import javafx.scene.image.Image;

public final class Player {

    private static String playerName;
    private static Image image;
    public Player(final String playerName, final Image image) {
        Player.playerName = playerName;
        Player.image = image;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static Image getImage() {
        return image;
    }
}
