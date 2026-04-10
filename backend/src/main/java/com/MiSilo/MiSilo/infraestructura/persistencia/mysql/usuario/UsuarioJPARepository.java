package com.MiSilo.MiSilo.infraestructura.persistencia.mysql.usuario;

import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJPARepository extends JpaRepository<UsuarioEntidad,Long> {
    Optional<UsuarioEntidad> findByNombreUsuario(String nombreUsuario);
}
