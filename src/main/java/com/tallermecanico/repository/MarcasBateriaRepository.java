package com.tallermecanico.repository;

import com.tallermecanico.entity.MarcasBateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarcasBateriaRepository extends JpaRepository<MarcasBateria, Integer> {

    Optional<MarcasBateria> findByMarca(String marca);

    boolean existsByMarca(String marca);

    boolean existsByMarcaAndIdNot(String marca, Integer id);
}
