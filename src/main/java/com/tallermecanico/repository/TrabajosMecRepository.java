package com.tallermecanico.repository;

import com.tallermecanico.entity.TrabajosMec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrabajosMecRepository extends JpaRepository<TrabajosMec, Integer> {
    boolean existsByTrabajoMec(String trabajoMec);
    boolean existsByTrabajoMecAndIdNot(String trabajoMec, Integer id);
}
