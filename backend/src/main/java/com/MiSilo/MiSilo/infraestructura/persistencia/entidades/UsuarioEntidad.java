package com.MiSilo.MiSilo.infraestructura.persistencia.entidades;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class UsuarioEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreUsuario;
    private String contrasenia;

    public UsuarioEntidad() {
    }

    public long getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
