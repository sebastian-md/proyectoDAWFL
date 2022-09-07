package com.example.proyectodawfa;

import com.example.proyectodawfa.modelo.clases.Holder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class InsertarOfertaController implements Initializable {

    @FXML
    private TextArea idTADatosOferta;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Holder holder = Holder.getInstance();
        idTADatosOferta.setText(holder.getOferta().getNombreOferta() + " -- " + holder.getOferta().getFechaInicio() + " -- " + holder.getOferta().getFechaFinal()  );
    }
}
