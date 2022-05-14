package com.kodilla.game;

import javafx.fxml.FXMLLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StartGameTestSuite {

    @DisplayName("Testing FXML location")
    @Test
    void testFXMLNotExist() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/mainScene.fxml"));

    }
}
