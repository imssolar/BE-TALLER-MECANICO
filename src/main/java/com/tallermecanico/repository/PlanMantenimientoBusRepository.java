package com.tallermecanico.repository;

import com.tallermecanico.entity.PlanMantenimientoBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanMantenimientoBusRepository extends JpaRepository<PlanMantenimientoBus, Integer> {

    List<PlanMantenimientoBus> findByBus_IdBus(Integer idBus);
}
