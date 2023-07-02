package com.dh.clinicaOdolitoByGabrielito.clinica.service;

import com.dh.clinicaOdolitoByGabrielito.clinica.dto.OdontologoDTO;
import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Odontologo;
import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Paciente;
import com.dh.clinicaOdolitoByGabrielito.clinica.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    private ObjectMapper mapper;

    public List<OdontologoDTO> listarOdontologos() {
        List<Odontologo> listaEntidades = odontologoRepository.findAll();
        return convertToDtoList(listaEntidades);
    }

    public OdontologoDTO registrarOdontologo(OdontologoDTO odontologoDTO) {

        Odontologo odontologo = convertToEntity(odontologoDTO);

        if (odontologo != null) {
            String inicialApellido = odontologo.getApellido().substring(0, 1);
            String restoApellido = odontologo.getApellido().substring(1);
            odontologo.setApellido(inicialApellido.toUpperCase() + restoApellido.toLowerCase());

            String inicialNombre = odontologo.getNombre().substring(0, 1);
            String restoNombre = odontologo.getNombre().substring(1);
            odontologo.setNombre(inicialNombre.toUpperCase() + restoNombre.toLowerCase());

            if (odontologo.getMatricula() > 0 && odontologo.getMatricula() <= 10000) {
                Odontologo nuevoO = odontologoRepository.save(odontologo);
            }

        }
        return null;
    }

    private List<OdontologoDTO> convertToDtoList(List<Odontologo> odontologos){
        return odontologos.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private OdontologoDTO convertToDto (Odontologo odontologo){
        return mapper.convertValue(odontologo, OdontologoDTO.class);
    }

    private Odontologo convertToEntity (OdontologoDTO odontologoDTO){
        return mapper.convertValue(odontologoDTO, Odontologo.class);
    }

    public OdontologoDTO obtenerOdontologoPorId(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        return mapper.convertValue(odontologo.get(), OdontologoDTO.class);
    }

    public List<OdontologoDTO> obtenerOdontologoPorApellido(String apellido) {
        Odontologo odontologo = odontologoRepository.findByApellido(apellido);
        mapper.convertValue(odontologo.getApellido(), OdontologoDTO.class);
        return null;
    }

    public OdontologoDTO actualizar(Long id, OdontologoDTO odontologoDTO) {
        Odontologo odontologoExistente = odontologoRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No se encontró ningún odontologo con el ID: "+id));
        odontologoExistente.setNombre(odontologoDTO.getNombre());
        odontologoExistente.setApellido(odontologoDTO.getApellido());
        odontologoExistente.setMatricula(Long.valueOf(odontologoDTO.getMatricula()));
        Odontologo odontologoActualizado = odontologoRepository.save(odontologoExistente);
        return convertToDto(odontologoActualizado);
    }

    public void eliminarPorId(Long id) {
        if (!odontologoRepository.existsById(id)) {
            throw new NoSuchElementException("No se encontró ningún odontologo con el ID: "+id);
        }
        odontologoRepository.deleteById(id);
    }
}
