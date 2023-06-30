package com.dh.integradorBackEnd.entity;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Usuario {

    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private List<Rol> roles;
}
