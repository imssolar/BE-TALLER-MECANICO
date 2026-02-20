package com.tallermecanico.repository;

import com.tallermecanico.entity.DetalleEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleEntregaRepository extends JpaRepository<DetalleEntrega, Integer> {
}
