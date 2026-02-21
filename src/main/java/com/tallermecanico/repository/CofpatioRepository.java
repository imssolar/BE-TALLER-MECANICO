package com.tallermecanico.repository;

import com.tallermecanico.entity.Cofpatio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CofpatioRepository extends JpaRepository<Cofpatio, Integer> {

    List<Cofpatio> findByBus_IdBus(Integer idBus);
}
