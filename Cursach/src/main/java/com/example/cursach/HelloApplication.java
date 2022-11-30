package com.example.cursach;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        HelloApplication.stage=stage;
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root.load(), 900, 600);
        stage.setTitle("TourBuilder");
        stage.setScene(scene);
        stage.show();
    }


    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}