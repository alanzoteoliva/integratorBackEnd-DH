package com.dh.clinicaOdolitoByGabrielito.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

}
