package com.tallermecanico.repository;

import com.tallermecanico.entity.HojaVidaEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HojaVidaEmpleadoRepository extends JpaRepository<HojaVidaEmpleado, Integer> {
}
