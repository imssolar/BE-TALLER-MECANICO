package com.tallermecanico.repository;

import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.BusKMMensual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusKMMensualRepository extends JpaRepository<BusKMMensual, Integer> {

    boolean existsByBusAndMesAndAno(Bus bus, Integer mes, Integer ano);

    boolean existsByBusAndMesAndAnoAndIdNot(Bus bus, Integer mes, Integer ano, Integer id);
}
