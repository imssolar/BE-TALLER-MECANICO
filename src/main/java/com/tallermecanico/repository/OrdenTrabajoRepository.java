package com.tallermecanico.repository;

import com.tallermecanico.entity.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Integer> {
    List<OrdenTrabajo> findByBus_IdBus(Integer idBus);
    List<OrdenTrabajo> findByTerminal_IdTerminal(Integer idTerminal);
}
