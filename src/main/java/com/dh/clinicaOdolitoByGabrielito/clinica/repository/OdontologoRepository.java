package com.dh.clinicaOdolitoByGabrielito.clinica.repository;

import com.dh.clinicaOdolitoByGabrielito.clinica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    Odontologo findByApellido(String apellido);
}
