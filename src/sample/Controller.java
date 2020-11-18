package sample;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    boolean nameBool=false;
    boolean priceBool = true;
    String data[]=new String[100];
    int numAded=0;
    @FXML
    private Button btnClear;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnQuit;

    @FXML
    private Button btnRemove;
    @FXML
    private Label label;

    @FXML
    void btnClearOnAction(ActionEvent event) {
         label.setText("Products list:\n");
        data = new String[100];
        numAded=0;
    }

    @FXML
    void btnADD(ActionEvent event) {
            label.setText(label.getText()+name.getText()+" - "+price.getText()+"\n");
            data[numAded]=name.getText()+" - "+price.getText()+"\n";
            numAded++;
        System.out.println(numAded);
    }
    @FXML
    void nameClear(){

        name.setText("");
    }
    @FXML
    void priceClear(){
        price.setText("");
    }

    @FXML//PRESING ENTER WHILE TYPING NAME
    void nameEntered(){
        if(nameBool!=true) {
            label.setText(label.getText() + name.getText()+" - ");
            nameBool = true;
            priceBool=false;
            data[numAded]=label.getText();
            numAded++;
        }
    }
    @FXML//PRESING ENTER WHILE TYPING PRICE
    void priceEntered(){
        if(priceBool!=true) {
            label.setText(label.getText() + price.getText()+"\n");
            priceBool=true;
            nameBool=false;
            data[numAded]=label.getText();
        }
        }

    @FXML//EXIT
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();

    }
    @FXML//REMOVES LAST ADDED
    void btnRemoveOnAction(ActionEvent event){
        if (numAded>0) {
            String result = "Products list:\n";
            for (int i = 1; i < numAded; i++) {
                result += data[i];
                System.out.println("\t i:" + data[i]);
            }
            numAded--;
            System.out.println(numAded);
            System.out.println(result);
            label.setText(result);
        }

    }

    @FXML
    void initialize() {
        assert  label !=null : "fx:id=\"label\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        label.setText("Products list:\n");
        assert btnRemove != null : "fx:id=\"btnRemove\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'sample.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'sample.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
