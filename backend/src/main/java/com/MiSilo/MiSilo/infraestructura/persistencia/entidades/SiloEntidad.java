package com.MiSilo.MiSilo.infraestructura.persistencia.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "silo")
public class SiloEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double kilosMax;
    private double contenidoEnSilo;
    private LocalDateTime fechaUltimoLLenado;

    public SiloEntidad() {
    }

    public SiloEntidad(double kilosMax, double contenidoEnSilo, LocalDateTime ultimoLLenado) {
        this.kilosMax = kilosMax;
        this.contenidoEnSilo = contenidoEnSilo;
        this.fechaUltimoLLenado = ultimoLLenado;
    }

    public Long getId() {
        return id;
    }

    public double getKilosMax() {
        return kilosMax;
    }

    public double getContenidoEnSilo() {
        return contenidoEnSilo;
    }

    public LocalDateTime getfechaUltimoLLenado() {
        return fechaUltimoLLenado;
    }

    public void setFechaUltimoLLenado(LocalDateTime ultimoLLenado) {
        this.fechaUltimoLLenado = ultimoLLenado;
    }

    public void setContenidoEnSilo(double contenidoEnSilo) {
        this.contenidoEnSilo = contenidoEnSilo;
    }
}
