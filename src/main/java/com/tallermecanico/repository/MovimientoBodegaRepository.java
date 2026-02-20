package com.tallermecanico.repository;

import com.tallermecanico.entity.MovimientoBodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoBodegaRepository extends JpaRepository<MovimientoBodega, Integer> {
}
