package com.tallermecanico.repository;

import com.tallermecanico.entity.HerramientasPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HerramientasPlanRepository extends JpaRepository<HerramientasPlan, Integer> {

    List<HerramientasPlan> findByInfraHerraPatron_IdInfra(String idInfra);
}
