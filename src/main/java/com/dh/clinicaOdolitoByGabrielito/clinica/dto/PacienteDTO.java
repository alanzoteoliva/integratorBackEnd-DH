package com.dh.clinicaOdolitoByGabrielito.clinica.dto;

import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String dni;
    private LocalDate fechaAlta;
    private Set<Turno> turnos;
}
