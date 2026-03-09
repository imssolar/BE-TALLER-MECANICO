package com.tallermecanico.repository;

import com.tallermecanico.entity.DetalleEH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleEHRepository extends JpaRepository<DetalleEH, Integer> {

    List<DetalleEH> findByRut(String rut);
}
