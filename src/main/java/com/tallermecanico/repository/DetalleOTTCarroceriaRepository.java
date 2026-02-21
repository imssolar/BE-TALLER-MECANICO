package com.tallermecanico.repository;

import com.tallermecanico.entity.DetalleOTTCarroceria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleOTTCarroceriaRepository extends JpaRepository<DetalleOTTCarroceria, Integer> {
    List<DetalleOTTCarroceria> findByOtCarroceria_Id(Integer idOtCarroceria);
}
