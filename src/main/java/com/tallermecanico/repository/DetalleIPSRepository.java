package com.tallermecanico.repository;

import com.tallermecanico.entity.DetalleIPS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleIPSRepository extends JpaRepository<DetalleIPS, Integer> {
    List<DetalleIPS> findByOrdenTrabajoProg_Id(Integer idOrdenTrabajoProg);
    List<DetalleIPS> findByOrdenTrabajoMovil_Id(Integer idOrdenTrabajoMovil);
}
