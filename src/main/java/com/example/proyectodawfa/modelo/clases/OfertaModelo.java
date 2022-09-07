package com.example.proyectodawfa.modelo.clases;

import javafx.beans.property.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class OfertaModelo {
    private IntegerProperty idOferta;
    private StringProperty nombreOferta;
    private ObjectProperty<LocalDate> fechaInicio;
    private ObjectProperty<LocalDate> fechaFinal;
    private StringProperty nombreUsuario;

    public OfertaModelo(){
    }

    public OfertaModelo(String nombreOferta, LocalDate fechaInicio, LocalDate fechaFinal){
        this.nombreOferta = new SimpleStringProperty(nombreOferta);
        this.fechaInicio = new SimpleObjectProperty<LocalDate>(fechaInicio);
        this.fechaFinal = new SimpleObjectProperty<LocalDate>(fechaFinal);
    }

    public OfertaModelo(int idOferta, String nombreOferta, LocalDate fechaInicio, LocalDate fechaFinal, Usuario usuario){
        this.idOferta = new SimpleIntegerProperty(idOferta);
        this.nombreOferta = new SimpleStringProperty(nombreOferta);
        this.fechaInicio = new SimpleObjectProperty<LocalDate>(fechaInicio);
        this.fechaFinal = new SimpleObjectProperty<LocalDate>(fechaFinal);
        this.nombreUsuario = new SimpleStringProperty(usuario.getNombre());
    }

}
