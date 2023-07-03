package com.dh.clinicaOdolitoByGabrielito.clinica.service;

import com.dh.clinicaOdolitoByGabrielito.clinica.dto.TurnoDTO;
import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Turno;
import com.dh.clinicaOdolitoByGabrielito.clinica.repository.TurnoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    private TurnoRepository turnoRepository;
    private ObjectMapper mapper;

    public List<TurnoDTO> listarTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        return mapper.convertValue(turnos, new TypeReference<List<TurnoDTO>>() {});
    }

    public TurnoDTO crearTurno(TurnoDTO turnoDto) {
        Turno turno = mapper.convertValue(turnoDto, Turno.class);
        Turno turnoCreado = turnoRepository.save(turno);
        return mapper.convertValue(turnoCreado, TurnoDTO.class);
    }
}
