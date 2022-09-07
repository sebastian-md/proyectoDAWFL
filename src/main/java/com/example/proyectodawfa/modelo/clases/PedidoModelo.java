package com.example.proyectodawfa.modelo.clases;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;

public @Data class PedidoModelo {

    private IntegerProperty idPedido;
    private StringProperty nombrePedido;
    private StringProperty estado;
    private StringProperty usuario;

    public PedidoModelo(int idPedido,String nombrePedido, String estado, Usuario usuario){
        this.idPedido = new SimpleIntegerProperty(idPedido);
        this.nombrePedido = new SimpleStringProperty(nombrePedido);
        this.estado = new SimpleStringProperty(estado);
        this.usuario = new SimpleStringProperty(usuario.getNombre());
    }

    //Getters y Setters hechos con @Data
}
