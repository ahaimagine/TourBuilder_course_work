package com.example.cursach.Controllers;

import com.example.cursach.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloController {

    private Scene scene;
    private FXMLLoader root;

    @FXML
    private Button Start;

    public void switchToScene2(ActionEvent event) throws IOException{
       root = new FXMLLoader(HelloApplication.class.getResource("ChoseePage.fxml"));
       scene = new Scene(root.load(), 900, 600);
       HelloApplication.getStage().setScene(scene);

   }

}

