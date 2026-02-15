package com.tallermecanico.repository;

import com.tallermecanico.entity.Neumatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeumaticoRepository extends JpaRepository<Neumatico, Integer> {

    List<Neumatico> findByActivo(Boolean activo);

    List<Neumatico> findByBus_IdBusOrderByPosicionAsc(Integer idBus);

    List<Neumatico> findByEstado_Id(Integer idEstado);

    List<Neumatico> findByMarca_Id(Integer idMarca);
}
