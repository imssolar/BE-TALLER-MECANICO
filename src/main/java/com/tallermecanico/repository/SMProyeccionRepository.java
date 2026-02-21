package com.tallermecanico.repository;

import com.tallermecanico.entity.SMProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMProyeccionRepository extends JpaRepository<SMProyeccion, Integer> {
}
