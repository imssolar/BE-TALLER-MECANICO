package com.tallermecanico.repository;

import com.tallermecanico.entity.CompetenciaEvaluada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaEvaluadaRepository extends JpaRepository<CompetenciaEvaluada, Integer> {
}
