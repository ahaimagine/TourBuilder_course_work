package com.example.cursach.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.cursach.DataBaseActions.ManagerDB;
import com.example.cursach.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddNewVoucherController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField CityField;

    @FXML
    private TextField CountryField;

    @FXML
    private TextField DateF1;

    @FXML
    private TextField DateF2;

    @FXML
    private TextField HotelField;

    @FXML
    private TextField NameField;

    @FXML
    private Button OK;

    @FXML
    private TextField Price;

    @FXML
    private Text Price2;

    @FXML
    private TextField SurnameField;

    @FXML
    private TextField TypeField;

    @FXML
    private Button Count;

    private Scene scene;
    private FXMLLoader root;



    public void switchBack(ActionEvent event) throws IOException {
        String type = TypeField.getText();
        String Name = NameField.getText();
        String Surname = SurnameField.getText();
        String Country = CountryField.getText();
        String City = CityField.getText();
        String Hotel = HotelField.getText();
        String DateIn = DateF1.getText();
        String DateOut = DateF2.getText();
        Double priceperday = Double.parseDouble(Price.getText());
        ManagerDB.getInstance().InserValues(type,Name,Surname,Country,City,Hotel,DateIn,DateOut,priceperday);
        ManagerDB.getInstance().InsertClients(Name,Surname);
        root = new FXMLLoader(HelloApplication.class.getResource("ChoseePage.fxml"));
        scene = new Scene(root.load(), 900, 600);
        HelloApplication.getStage().setScene(scene);
    }

    public void SwitchBBack(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("ChoseePage.fxml"));
        scene = new Scene(root.load(), 900, 600);
        HelloApplication.getStage().setScene(scene);
    }

    public void CountPrice(ActionEvent event) {
        String DateIn = DateF1.getText();
        String DateOut = DateF2.getText();
        Double priceperday = Double.parseDouble(Price.getText());
        String daysIn = DateIn.substring(8);
        String daysOut = DateOut.substring(8);
        if(DateIn.charAt(8) == '0'){
            daysIn = DateIn.substring(9);
        }
        if(DateOut.charAt(8) == '0'){
            daysOut = DateOut.substring(9);
        }
        System.out.println(daysIn);
        Double totalPrice =  priceperday*(Integer.parseInt(daysOut)-Integer.parseInt(daysIn) );
        Price2.setText( totalPrice.toString());
    }
}