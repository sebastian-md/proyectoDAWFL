package com.example.proyectodawfa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//proyectoDAWFB
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("control-usuario-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 578, 372);
        stage.setTitle("Aplicacion de venta de PCs");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}