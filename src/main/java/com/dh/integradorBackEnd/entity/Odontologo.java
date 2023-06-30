package com.dh.integradorBackEnd.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Odontologo {

    @Id
    @SequenceGenerator(name = "producto_sequence", sequenceName = "producto_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_sequence")
    private Long id;
    private String apellido;
    private String nombre;
    private String matricula;
}
