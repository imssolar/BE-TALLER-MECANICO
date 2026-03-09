package com.tallermecanico.repository;

import com.tallermecanico.entity.DetalleCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCapRepository extends JpaRepository<DetalleCap, Integer> {

    List<DetalleCap> findByCapacitacion_Id(Integer idCapacitacion);

    List<DetalleCap> findByRun(String run);
}
