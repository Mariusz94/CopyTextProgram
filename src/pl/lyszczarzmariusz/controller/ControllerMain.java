package pl.lyszczarzmariusz.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import pl.lyszczarzmariusz.Main;

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

        loader.setLocation(Main.getPath("scene/viewController.fxml"));
        StackPane stackPane = null;

        try {
            stackPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Controller controller = loader.getController();
        controller.setMainController(this);
        setScreen(stackPane);
        Main.setSizeWindow(300,235);
    }

    public void setScreen(StackPane stackPane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(stackPane);
    }
}
// TODO Wszystkie templatki tu tworzyć przesyłać okno rodzica i wywoływać w innych klasach