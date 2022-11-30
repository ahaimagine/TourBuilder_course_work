package com.example.cursach.Controllers;


import com.example.cursach.HelloApplication;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;


public class ChoosePageController {


    private Scene scene;
    private FXMLLoader root;



    public void switchToNewVoucher(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("AddNewVoucher.fxml"));
        scene = new Scene(root.load(), 900, 600);
        HelloApplication.getStage().setScene(scene);
    }
    public void switchToSelectData(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("SelectData.fxml"));
        scene = new Scene(root.load(), 900, 600);
        HelloApplication.getStage().setScene(scene);
    }
    public void switchToAddnewClient(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("AddNewClient.fxml"));
        scene = new Scene(root.load(), 900, 600);
        HelloApplication.getStage().setScene(scene);
    }

    public void ExitProgr(ActionEvent event){
        System.exit(0);
    }

    public void switchToSearch(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("SearchFor.fxml"));
        scene = new Scene(root.load(), 900, 600);
        HelloApplication.getStage().setScene(scene);
    }
}

