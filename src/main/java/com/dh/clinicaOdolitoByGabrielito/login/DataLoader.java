package com.dh.clinicaOdolitoByGabrielito.login;

import com.dh.clinicaOdolitoByGabrielito.login.entity.Rol;
import com.dh.clinicaOdolitoByGabrielito.login.entity.Usuario;
import com.dh.clinicaOdolitoByGabrielito.login.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DataLoader implements ApplicationRunner {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passUser = passwordEncoder.encode("alan");
        usuarioRepository.save(new Usuario("Alan", "alan@dh.com", "alanzote", passUser, Rol.USER));
        String passAdmin = passwordEncoder.encode("admin");
        usuarioRepository.save(new Usuario("Admin", "admin@dh.com", "admin", passAdmin, Rol.ADMIN));
    }
}
