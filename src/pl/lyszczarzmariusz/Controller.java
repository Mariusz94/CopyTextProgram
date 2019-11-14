package pl.lyszczarzmariusz;

import javafx.fxml.FXML;
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


public class Controller {
    private Clipboard clipboard;
    private StringSelection selection;
    private String text;

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
    public void stayOnTopAction(){
        Main.changeStayOnTop(stayOnTopItem.isSelected());
    }

    @FXML
    public void closeAction() {
        Main.closeApplication();
    }

}
