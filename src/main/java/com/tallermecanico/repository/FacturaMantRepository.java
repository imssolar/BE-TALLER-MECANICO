package com.tallermecanico.repository;

import com.tallermecanico.entity.FacturaMant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaMantRepository extends JpaRepository<FacturaMant, Integer> {
    List<FacturaMant> findByProveedor_Id(Integer idProveedor);
    List<FacturaMant> findByTallerExterno_Id(Integer idTallerExterno);
}
