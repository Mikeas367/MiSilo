package com.MiSilo.MiSilo.dominio.modelos;

public class Usuario {
    private String nombreUsuario;
    private String contrasenia;


    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

}
