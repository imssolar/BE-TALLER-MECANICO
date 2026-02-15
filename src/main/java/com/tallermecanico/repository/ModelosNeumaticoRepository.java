package com.tallermecanico.repository;

import com.tallermecanico.entity.ModelosNeumatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelosNeumaticoRepository extends JpaRepository<ModelosNeumatico, Integer> {

    Optional<ModelosNeumatico> findByModelo(String modelo);

    boolean existsByModelo(String modelo);

    boolean existsByModeloAndIdNot(String modelo, Integer id);
}
