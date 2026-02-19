package com.tallermecanico.repository;

import com.tallermecanico.entity.TrabajosElect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrabajosElectRepository extends JpaRepository<TrabajosElect, Integer> {

    Optional<TrabajosElect> findByTipoTE(String tipoTE);

    boolean existsByTipoTE(String tipoTE);

    boolean existsByTipoTEAndIdNot(String tipoTE, Integer id);
}
