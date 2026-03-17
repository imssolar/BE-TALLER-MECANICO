package com.tallermecanico.repository;

import com.tallermecanico.entity.TorreControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TorreControlRepository extends JpaRepository<TorreControl, Integer> {

    @Query("SELECT t FROM TorreControl t LEFT JOIN FETCH t.bus LEFT JOIN FETCH t.mecanico LEFT JOIN FETCH t.electrico")
    List<TorreControl> findAllWithRelations();

    @Query("SELECT t FROM TorreControl t LEFT JOIN FETCH t.bus LEFT JOIN FETCH t.mecanico LEFT JOIN FETCH t.electrico WHERE t.id = :id")
    Optional<TorreControl> findByIdWithRelations(Integer id);

    @Query("SELECT t FROM TorreControl t LEFT JOIN FETCH t.bus LEFT JOIN FETCH t.mecanico LEFT JOIN FETCH t.electrico WHERE t.bus.idBus = :idBus")
    List<TorreControl> findByBusWithRelations(Integer idBus);

    @Query("SELECT t FROM TorreControl t LEFT JOIN FETCH t.bus LEFT JOIN FETCH t.mecanico LEFT JOIN FETCH t.electrico WHERE t.cerrado = :cerrado")
    List<TorreControl> findByCerradoWithRelations(Boolean cerrado);
}
