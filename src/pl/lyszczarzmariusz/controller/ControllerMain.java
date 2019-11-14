package pl.lyszczarzmariusz.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class ControllerMain {
    @FXML
    private StackPane mainStackPane;

    @FXML
    public void initialize() {
        loadViewController();
    }

    public void loadViewController() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("scene/viewController.fxml"));
        StackPane stackPane = null;

        try {
            stackPane = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }

        Controller controller = loader.getController();
        controller.setMainController(this);
        setScreen(stackPane);

        Scene scene = new Scene(stackPane);
    }

    public void setScreen(StackPane stackPane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(stackPane);
    }
}
