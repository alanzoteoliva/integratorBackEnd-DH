package com.dh.clinicaOdolitoByGabrielito.clinica.controller;

import com.dh.clinicaOdolitoByGabrielito.clinica.dto.TurnoDTO;
import com.dh.clinicaOdolitoByGabrielito.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public List<TurnoDTO> listarTurnos() {
        return turnoService.listarTurnos();
    }

    @PostMapping
    public ResponseEntity<TurnoDTO> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        TurnoDTO nuevoTurno = turnoService.crearTurno(turnoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTurno);
    }

}
