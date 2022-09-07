package com.example.proyectodawfa;

import com.example.proyectodawfa.modelo.clases.Usuario;
import com.example.proyectodawfa.modelo.dao.UsuariosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class InsertarUsuarioController implements Initializable {

    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtTelefono;

    @FXML
    void insertar(ActionEvent event) {
        Usuario u = new Usuario();
        u.setId_usuario(Integer.parseInt(txtID.getText()));
        u.setNombre(txtNombre.getText());
        u.setApellido(txtApellido.getText());
        u.setTelefono(txtTelefono.getText());
        UsuariosDAO.insertarUsuario(u);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { // esto??

    }


    public void atras(ActionEvent actionEvent) { //cerrar ventana
        Stage escenario = (Stage) txtID.getScene().getWindow();
        escenario.close();
    }
}
