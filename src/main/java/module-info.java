module testfx.main {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.kodilla.game to javafx.fxml;
    opens com.kodilla.game.controllers to javafx.fxml;
    exports com.kodilla.game;
}