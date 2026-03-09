package com.tallermecanico.repository;

import com.tallermecanico.entity.TorreControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TorreControlRepository extends JpaRepository<TorreControl, Integer> {
    List<TorreControl> findByBus_IdBus(Integer idBus);
    List<TorreControl> findByCerrado(Boolean cerrado);
}
