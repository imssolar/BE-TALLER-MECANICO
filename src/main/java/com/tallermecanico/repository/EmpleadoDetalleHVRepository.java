package com.tallermecanico.repository;

import com.tallermecanico.entity.EmpleadoDetalleHV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoDetalleHVRepository extends JpaRepository<EmpleadoDetalleHV, Integer> {

    List<EmpleadoDetalleHV> findByRut(String rut);
}
