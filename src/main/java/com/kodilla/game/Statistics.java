package com.kodilla.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Statistics {
    private static String playerName;
    private static int playerGamesWon;
    private static int opponentGamesWon;

    public static final FXMLLoader fxmlLoader = new FXMLLoader();

    public Statistics() {
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        Statistics.playerName = playerName;
    }

    public static int getPlayerGamesWon() {
        return playerGamesWon;
    }

    public static void setPlayerGamesWon(int playerGamesWon) {
        Statistics.playerGamesWon = playerGamesWon;
    }

    public static int getOpponentGamesWon() {
        return opponentGamesWon;
    }

    public static void setOpponentGamesWon(int opponentGamesWon) {
        Statistics.opponentGamesWon = opponentGamesWon;
    }
}