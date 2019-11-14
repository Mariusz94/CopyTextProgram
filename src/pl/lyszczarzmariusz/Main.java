package pl.lyszczarzmariusz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    public static Stage window = null;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.getPath("scene/viewControllerMain.fxml"));
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

    public static void setSizeWindow(int x, int y){
        window.setWidth(x);
        window.setHeight(y);
    }

    public static void changeStayOnTop(boolean value){
        if (window.isAlwaysOnTop() != value) {
            window.setAlwaysOnTop(value);
        }
    }

    public static void closeApplication(){
        window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static URL getPath(String url){
        return Main.class.getResource(url);
    }

}
