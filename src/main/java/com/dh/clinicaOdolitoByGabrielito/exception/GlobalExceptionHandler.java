package com.dh.clinicaOdolitoByGabrielito.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> emitirIllegalArgumentException(IllegalArgumentException e) {
        e.printStackTrace();
        logger.error("mensaje de error illegalArgumentException -->" + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ClinicaErrorResponse> emitirBadRequestException(BadRequestException e) {
        e.printStackTrace();
        logger.error("mensaje de error BadRequestException -->" + e.getMessage());
        ClinicaErrorResponse errorResponse = new ClinicaErrorResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
