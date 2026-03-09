package com.tallermecanico.repository;

import com.tallermecanico.entity.MedicionHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicionHistoricoRepository extends JpaRepository<MedicionHistorico, Integer> {

    List<MedicionHistorico> findByBus_IdBus(Integer idBus);
}
