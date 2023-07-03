package com.dh.clinicaOdolitoByGabrielito.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends Exception{
    private String code;
    public BadRequestException(String message, String code) {
        super(message);
        this.code = code;
    }

}
