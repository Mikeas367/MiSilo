package com.MiSilo.MiSilo.infraestructura.mappers;

import com.MiSilo.MiSilo.dominio.modelos.Usuario;
import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.UsuarioEntidad;
import org.apache.catalina.User;

public class UsuarioMapper {
    public static Usuario fromEntidadToDominio(UsuarioEntidad usuarioEnDb) {
        return new Usuario(usuarioEnDb.getNombreUsuario(), usuarioEnDb.getContrasenia());
    }
}
