package com.dh.clinicaOdolitoByGabrielito.login;

import com.dh.clinicaOdolitoByGabrielito.login.entity.Rol;
import com.dh.clinicaOdolitoByGabrielito.login.entity.Usuario;
import com.dh.clinicaOdolitoByGabrielito.login.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) {
        Usuario user = (Usuario) usuarioRepository.findByNombreUsuario(nombreUsuario);
        if (user == null) {
            throw new NoSuchElementException("Usuario no encontrado: " + nombreUsuario);
        }
        return new User(user.getNombreUsuario(), user.getPassword(), getAuthorities(user.getRol()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Rol rol) {
        return Collections.singleton(new SimpleGrantedAuthority(rol.getNombre()));
    }
}
