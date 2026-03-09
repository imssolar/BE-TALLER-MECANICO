package com.tallermecanico.repository;

import com.tallermecanico.entity.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Integer> {

    Optional<Sistema> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    boolean existsByNombreAndIdNot(String nombre, Integer id);
}
