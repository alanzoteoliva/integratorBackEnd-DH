package com.dh.clinicaOdolitoByGabrielito.clinica.controller;

import com.dh.clinicaOdolitoByGabrielito.clinica.dto.PacienteDTO;
import com.dh.clinicaOdolitoByGabrielito.clinica.dto.TurnoDTO;
import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Turno;
import com.dh.clinicaOdolitoByGabrielito.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{dni}/turnos")
    public ResponseEntity<List<TurnoDTO>> obtenerTurnosPaciente(@PathVariable Long dni) {
        List<TurnoDTO> turnos = pacienteService.obtenerTurnosPaciente(dni);
        return ResponseEntity.ok(turnos);
    }

    @PostMapping("/{nombre?apellido}/turnos")
    public ResponseEntity<TurnoDTO> registrarTurnoPaciente(@PathVariable String nombre,@PathVariable String apellido, @RequestBody TurnoDTO turnoDTO) {
        TurnoDTO nuevoTurno = pacienteService.registrarTurnoPaciente(nombre, apellido, turnoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTurno);
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> agregarPaciente(@RequestBody PacienteDTO pacienteDTO){
        PacienteDTO nuevoPaciente = pacienteService.registrar(pacienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPaciente);
    }

}
