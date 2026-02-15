package com.tallermecanico.repository;

import com.tallermecanico.entity.MarcasNeumatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarcasNeumaticoRepository extends JpaRepository<MarcasNeumatico, Integer> {

    Optional<MarcasNeumatico> findByMarca(String marca);

    boolean existsByMarca(String marca);

    boolean existsByMarcaAndIdNot(String marca, Integer id);
}
