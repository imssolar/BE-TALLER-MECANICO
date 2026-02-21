package com.tallermecanico.repository;

import com.tallermecanico.entity.PlanRevisiones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRevisionesRepository extends JpaRepository<PlanRevisiones, Integer> {

    List<PlanRevisiones> findByBus_IdBus(Integer idBus);
}
