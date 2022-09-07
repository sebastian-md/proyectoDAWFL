package com.example.proyectodawfa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController {

    public Label lblSlogan;

    public void verUsuarios(ActionEvent actionEvent) throws IOException {

        //Crear una escena en otra ventana:
            FXMLLoader loaderUsuario= new FXMLLoader(getClass().getResource("buscarusuario-view.fxml"));
            Parent root=loaderUsuario.load();
            Scene escena= new Scene(root); //escena
            Stage escenario= new Stage(); //escenario
            escenario.setTitle("Usuarios");
            escenario.initModality(Modality.APPLICATION_MODAL); //restringir, solo abre 1 ventana, modal
            escenario.setScene(escena);
            escenario.showAndWait();

    }

    public void insertarUsuario(ActionEvent actionEvent) throws IOException {

        //Crear una escena en otra ventana:
        FXMLLoader loaderUsuario= new FXMLLoader(getClass().getResource("insertarusuario-view.fxml"));
        Parent root=loaderUsuario.load();
        Scene escena= new Scene(root); //escena
        Stage escenario= new Stage(); //escenario
        escenario.setTitle("Insertar Usuarios");
        escenario.initModality(Modality.APPLICATION_MODAL); //restringir, solo abre 1 ventana, modal
        escenario.setScene(escena);
        escenario.showAndWait();

    }

    public void verUsuariosPedidos(ActionEvent actionEvent) throws IOException {
        FXMLLoader loaderUsuariosPedidos = new FXMLLoader(getClass().getResource("usuario-pedido-view.fxml"));
        Parent root = loaderUsuariosPedidos.load();
        Scene escena = new Scene(root);
        Stage escenario = new Stage();
        escenario.setTitle("Usuarios y Pedidos");
        escenario.initModality(Modality.APPLICATION_MODAL);
        escenario.setScene(escena);
        escenario.showAndWait();
    }

    public void verOfertas(ActionEvent actionEvent) throws IOException {
        //Crear una escena en otra ventana:
        FXMLLoader loaderUsuario= new FXMLLoader(getClass().getResource("ofertas-view.fxml"));
        Parent root=loaderUsuario.load();
        Scene escena= new Scene(root); //escena
        Stage escenario= new Stage(); //escenario
        escenario.setTitle("Insertar Usuarios");
        escenario.initModality(Modality.APPLICATION_MODAL); //restringir, solo abre 1 ventana, modal
        escenario.setScene(escena);
        escenario.showAndWait();
    }

    public void cerrarPrincipal(MouseEvent mouseEvent) {
        Stage escenario = (Stage) lblSlogan.getScene().getWindow();
        escenario.close();
    }

    public void nuevaOferta(ActionEvent actionEvent) throws IOException {
        //Crear una escena en otra ventana:
        FXMLLoader loaderUsuario= new FXMLLoader(getClass().getResource("nueva-oferta-view.fxml"));
        Parent root=loaderUsuario.load();
        Scene escena= new Scene(root); //escena
        Stage escenario= new Stage(); //escenario
        escenario.setTitle("Insertar Usuarios");
        escenario.initModality(Modality.APPLICATION_MODAL); //restringir, solo abre 1 ventana, modal
        escenario.setScene(escena);
        escenario.showAndWait();
    }

    public void verOfertasUsuarios(ActionEvent actionEvent) throws IOException {
        //Crear una escena en otra ventana:
        FXMLLoader loaderUsuario= new FXMLLoader(getClass().getResource("ofertas-usuarios-view.fxml"));
        Parent root=loaderUsuario.load();
        Scene escena= new Scene(root); //escena
        Stage escenario= new Stage(); //escenario
        escenario.setTitle("Ver Ofertas de Usuarios");
        escenario.initModality(Modality.APPLICATION_MODAL); //restringir, solo abre 1 ventana, modal
        escenario.setScene(escena);
        escenario.showAndWait();
    }
}
