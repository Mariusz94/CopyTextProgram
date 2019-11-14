package pl.lyszczarzmariusz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pl.lyszczarzmariusz.controller.Controller;
import pl.lyszczarzmariusz.controller.ControllerParent;
import pl.lyszczarzmariusz.controller.ControllerTwo;

import java.io.IOException;

public class Main extends Application {
    public static Stage window = null;


    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //changeScene("scene/viewController.fxml", new Controller());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("scene/viewControllerMain.fxml"));
        StackPane stackPane = null;
        try {
            stackPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(stackPane);

        window.setScene(scene);

        window.setResizable(true);
        window.setFullScreen(false);
        window.setAlwaysOnTop(false);
        window.show();
    }

    public static void changeStayOnTop(boolean value){
        if (window.isAlwaysOnTop() != value) {
            window.setAlwaysOnTop(value);
        }
    }

    public static void closeApplication(){
        window.close();
    }

    /*public void changeScene(String sourceNameFXML){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource(sourceNameFXML));
        StackPane stackPane = null;

        try {
            stackPane = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }

        Scene scene = new Scene(stackPane);

        window.setScene(scene);
    }*/


    public static void main(String[] args) {
        launch(args);
    }

}
