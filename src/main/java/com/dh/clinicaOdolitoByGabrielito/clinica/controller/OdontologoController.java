package com.dh.clinicaOdolitoByGabrielito.clinica.controller;

import com.dh.clinicaOdolitoByGabrielito.clinica.dto.OdontologoDTO;
import com.dh.clinicaOdolitoByGabrielito.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<List<OdontologoDTO>> listar() {
        try {
            List<OdontologoDTO> odontologos = odontologoService.listarOdontologos();
            return ResponseEntity.ok(odontologos);
        } catch (Exception e){
            // Manejo de la excepción
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarPorId(@PathVariable Long id) {
        try {
            OdontologoDTO odontologoDTO = odontologoService.obtenerOdontologoPorId(id);
                if (odontologoDTO != null) {
                    return ResponseEntity.ok(odontologoDTO);
                } else {
                    return ResponseEntity.notFound().build();
                    }
            } catch (Exception e){
            // Manejo de la excepción
            return null;
        }
    }

    @GetMapping("/buscarPorApellido")
    public ResponseEntity<List<OdontologoDTO>> buscarPorApellido(@RequestParam String apellido) {
        try {
            List<OdontologoDTO> odontologosPorApellido = odontologoService.obtenerOdontologoPorApellido(apellido);
            if (!odontologosPorApellido.isEmpty()) {
                return ResponseEntity.ok(odontologosPorApellido);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<OdontologoDTO> registrar(@RequestBody OdontologoDTO odontologoDTO) {
        try {
            OdontologoDTO nuevoOdontologoDTO = odontologoService.registrarOdontologo(odontologoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoOdontologoDTO);
        } catch (Exception e) {
            // Manejo de la excepción
            return null;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OdontologoDTO> actualizar(@PathVariable Long id, @RequestBody OdontologoDTO odontologoDTO) {
        OdontologoDTO odontologoActualizadoDTO = odontologoService.actualizar(id, odontologoDTO);
        if (odontologoActualizadoDTO != null) {
            return ResponseEntity.ok(odontologoActualizadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        odontologoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
