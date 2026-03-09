package com.tallermecanico.repository;

import com.tallermecanico.entity.RepuestoOT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepuestoOTRepository extends JpaRepository<RepuestoOT, Integer> {
    List<RepuestoOT> findByOrdenTrabajo_Id(Integer idOrdenTrabajo);
    List<RepuestoOT> findByOrdenTrabajoProg_Id(Integer idOrdenTrabajoProg);
    List<RepuestoOT> findByOrdenTrabajoMovil_Id(Integer idOrdenTrabajoMovil);
}
