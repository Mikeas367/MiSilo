package com.MiSilo.MiSilo.dominio.modelos;

import java.time.LocalDateTime;

public class Silo {
    private long id;
    private double kilosMax;
    private double contenidoEnSilo;
    private LocalDateTime fechaUltimoLLenado;

    public void llenarSilo(double cantidadAIngresar){
        double sum = cantidadAIngresar + contenidoEnSilo;
        if(sum > kilosMax){
            throw new RuntimeException("La cantidad a ingresar supera a la capacidad del silo");
        }
        contenidoEnSilo = contenidoEnSilo + cantidadAIngresar;
    }

    public void sacarContenido(double cantidadARetirar){
        if(cantidadARetirar > contenidoEnSilo){
            throw new RuntimeException("La cantidad a retirar es mayor a la del silo");
        }
        contenidoEnSilo = contenidoEnSilo - cantidadARetirar;
    }



    public Silo() {
    }

    public Silo(long id, double kilosMax, double contenidoEnSilo, LocalDateTime fechaUltimoLLenado) {
        this.id = id;
        this.kilosMax = kilosMax;
        this.contenidoEnSilo = contenidoEnSilo;
        this.fechaUltimoLLenado = fechaUltimoLLenado;
    }

    public void setFechaUltimoLLenado(LocalDateTime fechaUltimoLLenado) {
        this.fechaUltimoLLenado = fechaUltimoLLenado;
    }

    public double getKilosMax() {
        return kilosMax;
    }

    public double getContenidoEnSilo() {
        return contenidoEnSilo;
    }

    public LocalDateTime getFechaUltimoLLenado() {
        return fechaUltimoLLenado;
    }

    public long getId() {
        return id;
    }
}
