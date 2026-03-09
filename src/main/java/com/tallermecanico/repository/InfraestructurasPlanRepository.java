package com.tallermecanico.repository;

import com.tallermecanico.entity.InfraestructurasPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfraestructurasPlanRepository extends JpaRepository<InfraestructurasPlan, Integer> {

    List<InfraestructurasPlan> findByInfraHerraPatron_IdInfra(String idInfra);
}
