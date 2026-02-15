package com.tallermecanico.repository;

import com.tallermecanico.entity.EstadosNeumatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadosNeumaticoRepository extends JpaRepository<EstadosNeumatico, Integer> {

    Optional<EstadosNeumatico> findByEstado(String estado);

    boolean existsByEstado(String estado);

    boolean existsByEstadoAndIdNot(String estado, Integer id);
}
