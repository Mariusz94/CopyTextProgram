package pl.lyszczarzmariusz.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import pl.lyszczarzmariusz.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;


public class ControllerCheckBox{
    private Clipboard clipboard;
    private StringSelection selection;
    private String text;
    private JTextArea jTextArea;
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

    @FXML
    private CheckMenuItem stayOnTopItem;

    public ControllerCheckBox() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        jTextArea = new JTextArea();
        System.out.println("Zainicjalizowany ControllerCheckBox");
    }

    @FXML
    void initialize(){

    }

    @FXML
    public void onActionButton1(){
        copyTextFromInput(in1);
    }

    @FXML
    public void onActionButton2(){
        copyTextFromInput(in2);
    }

    @FXML
    public void onActionButton3(){
        copyTextFromInput(in3);
    }

    @FXML
    public void onActionButton4(){
        copyTextFromInput(in4);
    }

    @FXML
    public void onActionButton5(){
        copyTextFromInput(in5);
    }

    private void copyTextFromInput(TextField in) {
        text = in.getText();
        if(text == null){
            text = "null";
        }
        selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }

    private void copyHandler(TextField in, Checkbox ch1, Checkbox ch2){
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

    @FXML
    public void stayOnTopAction(){
        Main.changeStayOnTop(stayOnTopItem.isSelected());
    }

    @FXML
    public void closeAction() {
        Main.closeApplication();
    }

    @FXML
    public void fiveFieldItem() {
        controllerMain.loadViewController();
    }

    @FXML
    public void tenFieldItem() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.getPath("scene/viewControllerTwo.fxml"));
        StackPane stackPane = null;
        try {
            stackPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControllerTwo controllerTwo = loader.getController();
        controllerTwo.setControllerMain(controllerMain);

        controllerMain.setScreen(stackPane);
        Main.setSizeWindow(300,390);
    }

    @FXML
    public void fiveFieldCheckItem() {
        //do nothing
    }

    public void setControllerMain(ControllerMain controllerMain) {
        this.controllerMain = controllerMain;
    }
}
