package pl.lyszczarzmariusz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("viewControllerCheckBox.fxml"));
        StackPane stackPane = null;
        try {
            stackPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ControllerCheckBox controllerCheckBox = loader.getController();

        Scene scene = new Scene(stackPane, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setTitle("Copy Text");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
