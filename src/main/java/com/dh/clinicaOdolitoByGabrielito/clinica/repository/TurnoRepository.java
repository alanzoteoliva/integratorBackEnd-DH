package com.dh.clinicaOdolitoByGabrielito.clinica.repository;

import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Paciente;
import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {

    List<Turno> findByPaciente(Paciente paciente);
}
