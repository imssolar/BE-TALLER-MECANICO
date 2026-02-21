package com.tallermecanico.repository;

import com.tallermecanico.entity.PagoBonos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PagoBonosRepository extends JpaRepository<PagoBonos, Integer> {

    Optional<PagoBonos> findByFecha(LocalDate fecha);

    boolean existsByFecha(LocalDate fecha);

    boolean existsByFechaAndIdNot(LocalDate fecha, Integer id);
}
