package pl.lyszczarzmariusz.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class ControllerTwo implements ControllerParent{
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
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button10;

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
    private TextField in6;
    @FXML
    private TextField in7;
    @FXML
    private TextField in8;
    @FXML
    private TextField in9;
    @FXML
    private TextField in10;

    public ControllerTwo() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        System.out.println("Zainicjalizowany ControllerTwo");
    }

    @FXML
    void initialize() {
        button1.setText("Copy");
        button2.setText("Copy");
        button3.setText("Copy");
        button4.setText("Copy");
        button5.setText("Copy");
        button6.setText("Copy");
        button7.setText("Copy");
        button8.setText("Copy");
        button9.setText("Copy");
        button10.setText("Copy");
    }

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

    @FXML
    public void onActionButton6() {
        copyText(in6);
    }

    @FXML
    public void onActionButton7() {
        copyText(in7);
    }

    @FXML
    public void onActionButton8() {
        copyText(in8);
    }

    @FXML
    public void onActionButton9() {
        copyText(in9);
    }

    @FXML
    public void onActionButton10() {
        copyText(in10);
    }

    private void copyText(TextField in) {
        text = in.getText();
        if (text == null) {
            text = "null";
        }
        selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }
}
