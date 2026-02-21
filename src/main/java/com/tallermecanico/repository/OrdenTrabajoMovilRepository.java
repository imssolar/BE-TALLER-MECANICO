package com.tallermecanico.repository;

import com.tallermecanico.entity.OrdenTrabajoMovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenTrabajoMovilRepository extends JpaRepository<OrdenTrabajoMovil, Integer> {

    List<OrdenTrabajoMovil> findByTerminal_IdTerminal(Integer idTerminal);
}
