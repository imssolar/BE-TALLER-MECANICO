package com.tallermecanico.repository;

import com.tallermecanico.entity.FacturaTC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaTCRepository extends JpaRepository<FacturaTC, Integer> {
    List<FacturaTC> findByProveedor_Id(Integer idProveedor);
    List<FacturaTC> findByTerminal_IdTerminal(Integer idTerminal);
}
