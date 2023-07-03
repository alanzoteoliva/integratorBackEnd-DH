package com.dh.clinicaOdolitoByGabrielito.clinica.service;


import com.dh.clinicaOdolitoByGabrielito.clinica.dto.PacienteDTO;
import com.dh.clinicaOdolitoByGabrielito.clinica.dto.TurnoDTO;
import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Paciente;
import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Turno;
import com.dh.clinicaOdolitoByGabrielito.clinica.repository.PacienteRepository;
import com.dh.clinicaOdolitoByGabrielito.clinica.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    private ObjectMapper mapper;

    public PacienteDTO registrar(PacienteDTO pacienteDTO) {
        Paciente paciente = convertToEntity(pacienteDTO);
        if (paciente != null) {
            pacienteRepository.save(paciente);
            return convertToDto(paciente);
        }
        return null;
    }

    public List<PacienteDTO> listar() {
        List<Paciente> listaEntidades = pacienteRepository.findAll();
        return convertToDtoList(listaEntidades);
    }

    public PacienteDTO buscarPorDni(Long dni) {
        Paciente paciente = pacienteRepository.findByDni(dni);
        return convertToDto(paciente);
    }

    public List<PacienteDTO> buscarPorApellido(String apellido) {
        Paciente paciente = pacienteRepository.findByApellido(apellido);
        List<Paciente> listaDeApellidos;
        if (paciente != null) {
            listaDeApellidos = pacienteRepository.findAll();
            return convertToDtoList(listaDeApellidos);
        }
        return null;
    }

    public PacienteDTO actualizar(Long dni, PacienteDTO pacienteDTO) {
        Paciente pacienteExistente = convertToEntity(buscarPorDni(dni));
        if (pacienteExistente == null){
            throw new NoSuchElementException("No se encontró ningun paciente con el DNI proporcinado");
        }
        pacienteExistente.setNombre(pacienteDTO.getNombre());
        pacienteExistente.setApellido(pacienteDTO.getApellido());
        pacienteExistente.setDomicilio(pacienteDTO.getDomicilio());
        Paciente pacienteActualizado = pacienteRepository.save(pacienteExistente);
        return convertToDto(pacienteActualizado);
    }

    public void eliminar(Long dni) {
        if (!pacienteRepository.existsByDni(dni)) {
            throw new NoSuchElementException("No se encontró ningún paciente con el DNI: "+dni);
        }
        pacienteRepository.deleteByDni(dni);
    }


    public List<TurnoDTO> obtenerTurnosPaciente(Long dni) {
        Paciente paciente = pacienteRepository.findByDni(dni);
        List<Turno> turnos = turnoRepository.findByPaciente(paciente);
        return turnos.stream().map(this::convertTurnoToDto).collect(Collectors.toList());
    }

    public TurnoDTO registrarTurnoPaciente(String nombre, String apellido, TurnoDTO turnoDTO) {
        List<Paciente> pacientes = pacienteRepository.findByNombreAndApellido(nombre, apellido);
        if (pacientes.isEmpty()) {
            throw new EntityNotFoundException("No se encontró ningún paciente con el nombre '" + nombre + "' y apellido '" + apellido + "'");
        }
        Paciente paciente = pacientes.get(0);
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turno.setPaciente(paciente);
        turnoRepository.save(turno);
        return turnoDTO;
    }

    private List<PacienteDTO> convertToDtoList(List<Paciente> pacientes){
        return pacientes.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    private PacienteDTO convertToDto (Paciente paciente){
        return mapper.convertValue(paciente, PacienteDTO.class);
    }

    private TurnoDTO convertTurnoToDto (Turno turno){
        return mapper.convertValue(turno, TurnoDTO.class);
    }

    private Paciente convertToEntity (PacienteDTO pacienteDTO){
        return mapper.convertValue(pacienteDTO, Paciente.class);
    }

}
