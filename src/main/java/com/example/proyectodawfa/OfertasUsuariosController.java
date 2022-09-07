package com.example.proyectodawfa;

import com.example.proyectodawfa.modelo.clases.Oferta;
import com.example.proyectodawfa.modelo.clases.Usuario;
import com.example.proyectodawfa.modelo.dao.OfertasDAO;
import com.example.proyectodawfa.modelo.dao.UsuariosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class OfertasUsuariosController implements Initializable {

    //combo
    @FXML
    private ComboBox<String> cmbUsuarios;
    private List<Usuario> usuarioList;

    //ListView
    @FXML
    private ListView<String> lstVOfertasUsuario;
    @FXML
    private ListView<String> lstVTodasOfertas;


    private List<Oferta> ofertaList;
    private List<Oferta> ofertaListUsuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Rellenamos la lista de usuarios y el combo
        usuarioList = UsuariosDAO.seleccionarUsuarios();
        cmbUsuarios.getItems().addAll(usuarioList.stream().map(Usuario::getNombre).collect(Collectors.toList()));

        //Rellenamos la listView con todas las ofertas, recuperando antes la lista de Ofertas ofertaList
        ofertaList = OfertasDAO.seleccionarOfertas();
        lstVTodasOfertas.getItems().addAll(ofertaList.stream().map(Oferta::getNombreOferta).collect(Collectors.toList()));
        lstVTodasOfertas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lstVOfertasUsuario.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }


    @FXML
    void verUsuariosOferta(ActionEvent actionEvent) { //al poner algo en el combo


        lstVTodasOfertas.getItems().clear();
        lstVTodasOfertas.getItems().addAll(ofertaList.stream().map(Oferta::getNombreOferta).collect(Collectors.toList()));
        lstVOfertasUsuario.getItems().clear();
        ofertaListUsuario=OfertasDAO.seleccionarOfertasUsuarios2(new Usuario(0,cmbUsuarios.getValue()));
        lstVOfertasUsuario.getItems().addAll(ofertaListUsuario.stream().map(Oferta::getNombreOferta).collect(Collectors.toList()));
        lstVTodasOfertas.getItems().removeAll(lstVOfertasUsuario.getItems());

    }


    @FXML
    void anadirOferta(ActionEvent event) { //click añadir
        lstVOfertasUsuario.getItems().addAll(lstVTodasOfertas.getSelectionModel().getSelectedItems());
        lstVTodasOfertas.getItems().removeAll(lstVTodasOfertas.getSelectionModel().getSelectedItems());
    }

    @FXML
    void quitarOferta(ActionEvent event) { // click en quitar
        lstVTodasOfertas.getItems().addAll(lstVOfertasUsuario.getSelectionModel().getSelectedItems());
        lstVOfertasUsuario.getItems().removeAll(lstVOfertasUsuario.getSelectionModel().getSelectedItems());
    }



}
