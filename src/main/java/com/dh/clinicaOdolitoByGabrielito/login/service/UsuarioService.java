package com.dh.clinicaOdolitoByGabrielito.login.service;

import com.dh.clinicaOdolitoByGabrielito.clinica.dto.OdontologoDTO;
import com.dh.clinicaOdolitoByGabrielito.clinica.dto.TurnoDTO;
import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Odontologo;
import com.dh.clinicaOdolitoByGabrielito.login.entity.Usuario;
import com.dh.clinicaOdolitoByGabrielito.login.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Transactional
@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsername(username);

        UserDetails userDetails = new User(username, user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRol().name())));

        return userDetails;
    }
    public Usuario crearUsuario(Usuario usuario) {
        try {
            // Crear el objeto Usuario a partir de los datos recibidos
            if (usuario != null) {
                return usuarioRepository.save(usuario);
            }
        } catch (Exception e) {
            // Manejo de la excepción
            // ...
        }
        return null;
    }
}
