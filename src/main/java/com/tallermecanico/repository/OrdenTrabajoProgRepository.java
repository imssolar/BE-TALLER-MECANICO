package com.tallermecanico.repository;

import com.tallermecanico.entity.OrdenTrabajoProg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenTrabajoProgRepository extends JpaRepository<OrdenTrabajoProg, Integer> {

    List<OrdenTrabajoProg> findByBus_IdBus(Integer idBus);

    List<OrdenTrabajoProg> findByTerminal_IdTerminal(Integer idTerminal);
}
