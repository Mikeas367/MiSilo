package com.MiSilo.MiSilo.dominio.modelos;

public enum TipoDeBolsa {
    ENTERO(35),
    MOLIDO(30),
    PARTIDO(30);

    private final int peso;

    TipoDeBolsa(int peso){
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }
}
