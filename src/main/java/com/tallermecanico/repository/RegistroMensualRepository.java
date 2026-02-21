package com.tallermecanico.repository;

import com.tallermecanico.entity.RegistroMensual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroMensualRepository extends JpaRepository<RegistroMensual, Integer> {

    List<RegistroMensual> findByTipo(String tipo);

    List<RegistroMensual> findByAnio(Integer anio);

    List<RegistroMensual> findByTipoAndAnio(String tipo, Integer anio);
}
