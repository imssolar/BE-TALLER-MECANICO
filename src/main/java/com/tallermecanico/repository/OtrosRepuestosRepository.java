package com.tallermecanico.repository;

import com.tallermecanico.entity.OtrosRepuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtrosRepuestosRepository extends JpaRepository<OtrosRepuestos, Integer> {
    List<OtrosRepuestos> findByOrdenTrabajo_Id(Integer idOrdenTrabajo);
}
