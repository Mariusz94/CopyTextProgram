package pl.lyszczarzmariusz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class ControllerRadio {
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
    private RadioButton radioButton1_1;

    public ControllerRadio() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        System.out.println("Zainicjalizowany Controller");
    }

    @FXML
    void initialize(){
        button1.setText("Copy");
        button2.setText("Copy");
        button3.setText("Copy");
        button4.setText("Copy");
        button5.setText("Copy");
    }

    @FXML
    public void onActionButton1(){
        copyText(in1);
    }

    @FXML
    public void onActionButton2(){
        copyText(in2);
    }

    @FXML
    public void onActionButton3(){
        copyText(in3);
    }

    @FXML
    public void onActionButton4(){
        copyText(in4);
    }

    @FXML
    public void onActionButton5(){
        copyText(in5);
    }

    private void copyText(TextField in) {
        text = in.getText();
        if(text == null){
            text = "null";
        }
        selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }
}
