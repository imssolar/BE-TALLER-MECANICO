package com.tallermecanico.repository;

import com.tallermecanico.entity.OTTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OTTecnicoRepository extends JpaRepository<OTTecnico, Integer> {
    List<OTTecnico> findByOrdenTrabajo_Id(Integer idOrdenTrabajo);
    List<OTTecnico> findByOrdenTrabajoProg_Id(Integer idOrdenTrabajoProg);
}
