package com.MiSilo.MiSilo.infraestructura.seguridad;

import com.MiSilo.MiSilo.dominio.modelos.Usuario;
import com.MiSilo.MiSilo.infraestructura.persistencia.mysql.usuario.UsuarioRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private final UsuarioRepositoryAdapter usuarioRepositoryAdapter;

    public UserDetailsServiceImpl(UsuarioRepositoryAdapter usuarioRepositoryAdapter) {
        this.usuarioRepositoryAdapter = usuarioRepositoryAdapter;
    }


    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositoryAdapter.buscarPorNombreUsuario(nombreUsuario);

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getNombreUsuario())
                .password(usuario.getContrasenia())
                .authorities("USER") // Valor por defecto ya que no usas roles
                .build();
    }
}
