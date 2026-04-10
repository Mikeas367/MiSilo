package com.MiSilo.MiSilo.dominio.repositorios;

import com.MiSilo.MiSilo.dominio.modelos.Usuario;
import org.apache.catalina.User;

public interface UsuarioRepositoryPort {
    Usuario buscarPorNombreUsuario(String nombreUsuario);
}
