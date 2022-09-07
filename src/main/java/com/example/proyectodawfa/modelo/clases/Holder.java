package com.example.proyectodawfa.modelo.clases;

import lombok.Getter;
import lombok.Setter;

public class Holder {

    @Setter
    @Getter

    private Oferta oferta;

    private static Holder INSTANCE = new Holder();

    public static Holder getInstance(){
        return INSTANCE;
    }

}
