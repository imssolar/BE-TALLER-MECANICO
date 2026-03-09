package com.tallermecanico.repository;

import com.tallermecanico.entity.Movil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovilRepository extends JpaRepository<Movil, Integer> {

    boolean existsByPatente(String patente);

    boolean existsByPatenteAndIdNot(String patente, Integer id);
}
