package pl.lyszczarzmariusz.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.StackPane;
import pl.lyszczarzmariusz.Main;


import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;


public class Controller implements ControllerParent {
    private Clipboard clipboard;
    private StringSelection selection;
    private String text;
    private ControllerMain controllerMain;

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;

    @FXML
    private TextField in1;
    @FXML
    private TextField in2;
    @FXML
    private TextField in3;
    @FXML
    private TextField in4;
    @FXML
    private TextField in5;

    @FXML
    private CheckMenuItem stayOnTopItem; //Definicje pól

    public Controller() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        System.out.println("Zainicjalizowany Controller");
    }

    @FXML
    void initialize() {
    } //Metoda wywoływana po konstruktorze klasy

    @FXML
    public void onActionButton1() {
        copyText(in1);
    }

    @FXML
    public void onActionButton2() {
        copyText(in2);
    }

    @FXML
    public void onActionButton3() {
        copyText(in3);
    }

    @FXML
    public void onActionButton4() {
        copyText(in4);
    }

    @FXML
    public void onActionButton5() {
        copyText(in5);
    }

    private void copyText(TextField in) {
        text = in.getText();
        if (text == null) {
            text = "null";
        }
        selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    } // Metody pól do kopiowania

    @FXML
    public void stayOnTopAction() {
        Main.changeStayOnTop(stayOnTopItem.isSelected());
    }

    @FXML
    public void closeAction() {
        Main.closeApplication();
    }

    @FXML
    public void fiveFieldItem() {

    }

    @FXML
    public void tenFieldItem() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("scene/viewControllerTwo.fxml"));
        StackPane stackPane = null;
        try {
            stackPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControllerTwo controllerTwo = loader.getController();
        controllerTwo.setControllerMain(controllerMain);
        controllerMain.setScreen(stackPane);

    }

    @FXML
    public void fiveFieldCheckItem() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("scene/viewControllerCheckBox.fxml"));
        StackPane stackPane = null;
        try {
            stackPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControllerCheckBox controllerCheckBox = loader.getController();
        controllerCheckBox.setControllerMain(controllerMain);
        controllerMain.setScreen(stackPane);
    }


    public void setMainController(ControllerMain controllerMain) {
        this.controllerMain = controllerMain;
    }
}
