package com.dh.clinicaOdolitoByGabrielito.clinica.repository;

import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findByDni(Long dni);

    Paciente findByApellido(String apellido);

    boolean existsByDni(Long dni);

    void deleteByDni(Long dni);
    List<Paciente> findByNombreAndApellido(String nombre, String apellido);
}
