package com.tallermecanico.repository;

import com.tallermecanico.entity.PlanMantenimientoMovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanMantenimientoMovilRepository extends JpaRepository<PlanMantenimientoMovil, Integer> {
}
