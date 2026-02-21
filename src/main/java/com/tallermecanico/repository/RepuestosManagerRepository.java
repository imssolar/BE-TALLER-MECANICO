package com.tallermecanico.repository;

import com.tallermecanico.entity.RepuestosManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepuestosManagerRepository extends JpaRepository<RepuestosManager, Integer> {
    List<RepuestosManager> findByGlosa_Id(Integer idGlosa);
    List<RepuestosManager> findByTerminal_IdTerminal(Integer idTerminal);
}
