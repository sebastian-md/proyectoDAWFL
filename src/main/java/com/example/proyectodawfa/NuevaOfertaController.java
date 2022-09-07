package com.example.proyectodawfa;

import com.example.proyectodawfa.modelo.clases.Holder;
import com.example.proyectodawfa.modelo.clases.Oferta;
import com.example.proyectodawfa.modelo.dao.OfertasDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NuevaOfertaController {

    @FXML
    private TextField idTxtNombreOferta;
    @FXML
    private DatePicker idFechaInicio;
    @FXML
    private DatePicker idFechaFinal;


    @FXML
    void enviarDatosOferta(ActionEvent event) throws IOException { // metodo del boton enviarDatosOferta: crear nueva instancia del objeto Oferta y guardarlo en Holder (cambiandolo con set)
        Oferta oferta = new Oferta (0,idTxtNombreOferta.getText(),idFechaInicio.getValue(),idFechaFinal.getValue());
        Holder holder = Holder.getInstance(); //crear instancia de holder
        holder.setOferta(oferta);

        //Crear una escena en otra ventana:
        FXMLLoader loaderUsuario= new FXMLLoader(getClass().getResource("insertar-oferta-view.fxml"));
        Parent root=loaderUsuario.load();
        Scene escena= new Scene(root); //escena
        Stage escenario= new Stage(); //escenario
        escenario.setTitle("Insertar Oferta");
        escenario.initModality(Modality.APPLICATION_MODAL); //restringir, solo abre 1 ventana, modal
        escenario.setScene(escena);
        escenario.showAndWait();
    }

    @FXML
    void insertarNuevaOferta(ActionEvent event) {
        Oferta o = new Oferta (0,idTxtNombreOferta.getText(),idFechaInicio.getValue(),idFechaFinal.getValue());
        OfertasDAO.insertarOferta(o);
    }

}
