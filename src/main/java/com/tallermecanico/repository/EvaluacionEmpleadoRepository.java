package com.tallermecanico.repository;

import com.tallermecanico.entity.EvaluacionEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionEmpleadoRepository extends JpaRepository<EvaluacionEmpleado, Integer> {
}
