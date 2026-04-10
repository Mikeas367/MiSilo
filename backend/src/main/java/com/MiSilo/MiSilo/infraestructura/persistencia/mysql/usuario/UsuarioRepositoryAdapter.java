package com.MiSilo.MiSilo.infraestructura.persistencia.mysql.usuario;

import com.MiSilo.MiSilo.dominio.modelos.Usuario;
import com.MiSilo.MiSilo.dominio.repositorios.UsuarioRepositoryPort;
import com.MiSilo.MiSilo.infraestructura.mappers.UsuarioMapper;
import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.UsuarioEntidad;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    @Autowired
    private final UsuarioJPARepository usuarioJPARepository;

    public UsuarioRepositoryAdapter(UsuarioJPARepository usuarioJPARepository) {
        this.usuarioJPARepository = usuarioJPARepository;
    }

    @Override
    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        UsuarioEntidad usuarioEnDb = usuarioJPARepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new RuntimeException("No se encontró el Usuario con el nombre de usuario: " + nombreUsuario));
        return UsuarioMapper.fromEntidadToDominio(usuarioEnDb);
    }
}
