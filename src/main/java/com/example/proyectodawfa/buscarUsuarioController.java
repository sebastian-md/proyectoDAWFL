package com.example.proyectodawfa;

import com.example.proyectodawfa.modelo.clases.Usuario;
import com.example.proyectodawfa.modelo.dao.UsuariosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class buscarUsuarioController implements Initializable {


    @FXML
    private TextField txtBuscar;

    @FXML
    private ListView<String> lstNombreUsuarios;
    private List<String> nombresUsuariosList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            //lista Usuario -- lista String -- ListView
        List<Usuario> usuarioList= UsuariosDAO.seleccionarUsuarios(); //lista Usuario
        nombresUsuariosList=usuarioList.stream().map(x->x.getNombre()).collect(Collectors.toList()); //lista String (con nombre de Usuario)
        lstNombreUsuarios.getItems().addAll(nombresUsuariosList); //añadimos los nombres a ListView
    }

    public void filtrar(ActionEvent actionEvent) {
        lstNombreUsuarios.getItems().clear(); //limpiamos ListView
        lstNombreUsuarios.getItems().addAll(nombresUsuariosList.stream().filter(x->x.startsWith(txtBuscar.getText())).collect(Collectors.toList())); //metemos nombres que empiecen con el textfield

    }

    public void cerrar(ActionEvent actionEvent) {
        Stage escenario = (Stage) txtBuscar.getScene().getWindow();
        escenario.close();
    }
}
