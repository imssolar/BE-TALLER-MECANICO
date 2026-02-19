package com.tallermecanico.repository;

import com.tallermecanico.entity.Glosa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GlosaRepository extends JpaRepository<Glosa, Integer> {

    Optional<Glosa> findByGlosa(String glosa);

    boolean existsByGlosa(String glosa);

    boolean existsByGlosaAndIdNot(String glosa, Integer id);
}
