package pl.lyszczarzmariusz.services;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pl.lyszczarzmariusz.controllers.Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../view/sample.fxml"));
        StackPane stackPane = loader.load();

        Controller controller = loader.getController();

        Scene scene = new Scene(stackPane, 243, 168);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setTitle("Copy Text");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
