package com.example.cursach.Controllers;

import com.example.cursach.DataBaseActions.ManagerDB;
import com.example.cursach.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.io.IOException;


public class AddNewClient {
    @FXML
    private TextField Name;

    @FXML
    private TextField Surname;

    @FXML
    private Button addClient;

    private Scene scene;
    private FXMLLoader root;



    public void InsertClient(ActionEvent event) throws IOException {
        String name = Name.getText();
        String surname = Surname.getText();
        ManagerDB.getInstance().InsertClients(name,surname);
        root = new FXMLLoader(HelloApplication.class.getResource("ChoseePage.fxml"));
        scene = new Scene(root.load(), 900, 600);
        HelloApplication.getStage().setScene(scene);
    }

    public void SwitchBAck(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("ChoseePage.fxml"));
        scene = new Scene(root.load(), 900, 600);
        HelloApplication.getStage().setScene(scene);
    }
}
