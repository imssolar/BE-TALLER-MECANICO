package com.tallermecanico.repository;

import com.tallermecanico.entity.BateriaPaso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BateriaPasoRepository extends JpaRepository<BateriaPaso, Integer> {
    List<BateriaPaso> findByBus_IdBus(Integer idBus);
}
