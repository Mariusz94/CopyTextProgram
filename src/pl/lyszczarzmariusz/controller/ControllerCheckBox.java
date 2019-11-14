package pl.lyszczarzmariusz.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class ControllerCheckBox {
    private Clipboard clipboard;
    private StringSelection selection;
    private String text;
    private JTextArea jTextArea;

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
    private CheckBox checkbox1_1;

    @FXML
    private CheckBox checkbox1_2;

    @FXML
    private CheckBox checkbox2_1;

    @FXML
    private CheckBox checkbox2_2;

    @FXML
    private CheckBox checkbox3_1;

    @FXML
    private CheckBox checkbox3_2;

    @FXML
    private CheckBox checkbox4_1;

    @FXML
    private CheckBox checkbox4_2;

    @FXML
    private CheckBox checkbox5_1;

    @FXML
    private CheckBox checkbox5_2;

    public ControllerCheckBox() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        jTextArea = new JTextArea();
        System.out.println("Zainicjalizowany ControllerCheckBox");
    }

    @FXML
    void initialize() {
        button1.setText("Copy");
        button2.setText("Copy");
        button3.setText("Copy");
        button4.setText("Copy");
        button5.setText("Copy");
    }

    @FXML
    public void onActionButton1() {
        copyTextFromInput(in1);
    }

    @FXML
    public void onActionButton2() {
        copyTextFromInput(in2);
    }

    @FXML
    public void onActionButton3() {
        copyTextFromInput(in3);
    }

    @FXML
    public void onActionButton4() {
        copyTextFromInput(in4);
    }

    @FXML
    public void onActionButton5() {
        copyTextFromInput(in5);
    }

    private void copyTextFromInput(TextField in) {
        text = in.getText();
        if (text == null) {
            text = "null";
        }
        selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }

    private void copyHandler(TextField in, Checkbox ch1, Checkbox ch2) {
        copyTextFromInput(in);

        if (ch1.getState()) {
            EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (ch2.getState()) {
                        jTextArea.selectAll();
                    }
                    jTextArea.paste();
                }
            };
        }
    }
}
