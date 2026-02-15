package com.tallermecanico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tallermecanico.entity.Falla;

@Repository
public interface FallaRepository extends JpaRepository<Falla, String> {

    boolean existsByFalla(String falla);

    boolean existsByFallaAndIdFallaNot(String falla, String idFalla);
}