package sample;

import java.util.LinkedList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;

public class Controller {
    boolean nameBool = false;
    boolean priceBool = true;
    LinkedList<String> data = new LinkedList<String>();
    LinkedList<Integer> quantityData = new LinkedList<Integer>();
    LinkedList<Double> priceData = new LinkedList<Double>();
    int sum=0;
    int numAded = 0;
    @FXML
    private  Label sumLabel;
    @FXML
    private Button btnClear;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private TextField quantity;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnQuit;

    @FXML
    private Button btnRemove;
    @FXML
    private Label label;
    void updateSum(){
        sum=0;
        for (int i = 0; i <numAded ; i++) {
            {
                sum += priceData.get(i) * quantityData.get(i);
            }
        }
        sumLabel.setText(
                        "Sum: " +sum+
                                " \n Sum with DDS: "+(sum*120/100)
        );

    }

    //removing and clearing stuff
    @FXML
//REMOVES LAST ADDED
    void btnRemoveOnAction(ActionEvent event) {
        if(numAded>0) {
        data.remove(numAded-1);
        quantityData.remove(numAded-1);
        priceData.remove(numAded-1);
        numAded--;
        label.setText(dataToString());
        updateSum();
    }

    }
    String dataToString(){
        String result="Products list:\n";
        for (String i: data) {
            result+=i;
        }
        return result;

    }
    //TO DO: Rework add and quantity[]
    @FXML
    void btnClearOnAction(ActionEvent event) {
            data=new LinkedList<>();
            priceData=new LinkedList<>();
            quantityData=new LinkedList<>();
            numAded=0;
            name.setText("");
            price.setText("");
            quantity.setText("");
            label.setText("Products list:\n");
            sum=0;
        updateSum();
    }


    @FXML
    void nameClear() {
        if (name.getText().equals("name:"))
            name.setText("");
    }
    @FXML
    void priceClear() {
        if (price.getText().equals("price:"))
            price.setText("");
    }
    @FXML
    void quantityClear() {
        if (quantity.getText().equals("quantity:"))
            quantity.setText("");
    }



    //ADDING STUFF
    @FXML
    void btnADD(ActionEvent event) {
        ADD();
    }

    void ADD() {
        if (name.getText().equals("name:") || name.getText().equals("") || price.getText().equals("price:") || price.getText().equals("")) {
            //do nothing
        } else {
            try {

                label.setText((label.getText() + name.getText() + " - " + price.getText() + "  " + Integer.parseInt(quantity.getText()) + "  bought \n"));
                data.add((name.getText() + " - " + price.getText() + "  " + Integer.parseInt(quantity.getText()) + "  bought \n"));
                priceData.add(Double.parseDouble(price.getText()));
                quantityData.add(Integer.parseInt(quantity.getText()));
            } catch (Exception e) {
                label.setText((label.getText() + name.getText() + " - " + price.getText() + "  " + Integer.parseInt(quantity.getText()) + "  bought \n"));
                data.add((name.getText() + " - " + price.getText() + "  " + Integer.parseInt(quantity.getText()) + "  bought \n"));
                priceData.add(Double.parseDouble(price.getText()));
                quantityData.add(1);
            }
            System.out.println(numAded);
            numAded++;
        }
        updateSum();
    }


    @FXML
//PRESING ENTER WHILE TYPING NAME
    void nameEntered() {
        if (price.getText().equals("") || price.getText().equals("price:")) {
        } else {
            ADD();
        }
    }

    @FXML
//PRESING ENTER WHILE TYPING PRICE
    void priceEntered() {
        if (name.getText().equals("") || name.getText().equals("name:")) {
        } else {
            ADD();
        }

    }

    @FXML
    void quantityEntered() {
        if(!name.getText().equals("")||!name.getText().equals("name:")||!price.getText().equals("")||!price.getText().equals("price:")){
            ADD();
        }
    }


    @FXML
//EXIT
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();

    }
    //Key listeners to change typing cursor on diffrent TEXT fields
    @FXML
    void focusName(KeyEvent event) {
        if(event.getCode() == KeyCode.DOWN) {
            if(name.getText().equals(""))
                name.setText("name:");
            price.requestFocus();
            if(price.getText().equals("price:"))
                price.setText("");
        }
        if(event.getCode() == KeyCode.UP) {
            if(name.getText().equals(""))
                name.setText("name:");
            quantity.requestFocus();
            if(quantity.getText().equals("quantity:"))
                quantity.setText("");
        }
    }
    @FXML
    void focusQuantity(KeyEvent event) {
        if(event.getCode() == KeyCode.DOWN) {
            if(quantity.getText().equals(""))
                quantity.setText("quantity:");
            name.requestFocus();
            if(name.getText().equals("name:"))
                name.setText("");
        }
    }

    @FXML
    void focusPrice(KeyEvent event) {
        if(event.getCode() == KeyCode.UP) {
            if(price.getText().equals(""))
                price.setText("price:");
            name.requestFocus();
            if(name.getText().equals("name:"))
                if(name.getText().equals("name:"))
                    name.setText("");
            System.out.println("test");
        }
    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        label.setText("Products list:\n");
        assert btnRemove != null : "fx:id=\"btnRemove\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'sample.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'sample.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'sample.fxml'.";
        assert sumLabel != null : "fx:id=\"sumLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert quantity != null : "fx:id=\"quantity\" was not injected: check your FXML file 'sample.fxml'.";
    }
}
