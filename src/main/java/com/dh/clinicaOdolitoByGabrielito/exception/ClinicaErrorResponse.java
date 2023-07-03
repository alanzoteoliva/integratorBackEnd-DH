package com.dh.clinicaOdolitoByGabrielito.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClinicaErrorResponse extends Throwable {

    private String message;
}
