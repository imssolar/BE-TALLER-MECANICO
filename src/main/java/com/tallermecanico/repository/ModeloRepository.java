package com.tallermecanico.repository;

import com.tallermecanico.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

    Optional<Modelo> findByModelo(String modelo);

    boolean existsByModelo(String modelo);

    boolean existsByModeloAndIdModeloNot(String modelo, Integer idModelo);
}
