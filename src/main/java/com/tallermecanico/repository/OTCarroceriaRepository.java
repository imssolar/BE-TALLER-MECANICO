package com.tallermecanico.repository;

import com.tallermecanico.entity.OTCarroceria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OTCarroceriaRepository extends JpaRepository<OTCarroceria, Integer> {

    List<OTCarroceria> findByBus_IdBus(Integer idBus);

    List<OTCarroceria> findByTerminal_IdTerminal(Integer idTerminal);
}
