package com.tallermecanico.repository;

import com.tallermecanico.entity.RepuestosProyectados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestosProyectadosRepository extends JpaRepository<RepuestosProyectados, Integer> {
}
