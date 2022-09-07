package com.example.proyectodawfa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlUsuarioController {

    @FXML
    public TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;

    public void loginAction(ActionEvent actionEvent) throws IOException {

        if ( (txtUsuario.getText().equals("")) && (txtPassword.getText().equals("")) ){

            //crear una escena en la MISMA ventana
            FXMLLoader loaderPrincipal = new FXMLLoader(getClass().getResource("principal-view.fxml"));
            Parent root = loaderPrincipal.load();
            Scene escena = new Scene(root);
            Stage escenario = (Stage) txtUsuario.getScene().getWindow(); //abre escena dentro del mismo escenario
            escenario.setScene(escena);
            escenario.show();

            /* //Crear una escena en OTRA ventana:
            FXMLLoader loaderUsuario= new FXMLLoader(getClass().getResource("buscarusuario-view.fxml"));
            Parent root=loaderUsuario.load();
            Scene escena= new Scene(root); //escena
            Stage escenario= new Stage(); //escenario
            escenario.setTitle("Usuarios");
            escenario.initModality(Modality.APPLICATION_MODAL); //restringir, solo abre 1 ventana, modal
            escenario.setScene(escena);
            escenario.showAndWait(); */

        } else {
            //crear alerta
            Alert vInformativa = new Alert(Alert.AlertType.INFORMATION);
            vInformativa.setTitle("Login incorrecto");
            vInformativa.setHeaderText("Usuario y password incorrectos");
            vInformativa.setContentText("Por favor, pruebe de nuevo");
            vInformativa.show();
            txtUsuario.setText("");
            txtPassword.setText("");
        }
    }
}