package com.tallermecanico.repository;

import com.tallermecanico.entity.Bateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BateriaRepository extends JpaRepository<Bateria, Integer> {

    List<Bateria> findByActivo(Boolean activo);

    List<Bateria> findByBus_IdBusOrderByPosicionAsc(Integer idBus);

    List<Bateria> findByEstado_Id(Integer idEstado);

    List<Bateria> findByMarca_Id(Integer idMarca);
}
