package com.dh.clinicaOdolitoByGabrielito.clinica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@AllArgsConstructor
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apellido;
    private String nombre;
    private String domicilio;
    private Long dni;
    private LocalDate fechaAlta;
    @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnos;
    public void setDNI(Long dni) {
    }

    public Paciente orElseThrow(Object o) {
        return null;
    }
}
