package com.tallermecanico.repository;

import com.tallermecanico.entity.BateriaMotivoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BateriaMotivoCambioRepository extends JpaRepository<BateriaMotivoCambio, Integer> {

    @Query("SELECT b FROM BateriaMotivoCambio b WHERE LOWER(b.motivoCambio) = LOWER(:motivoCambio)")
    Optional<BateriaMotivoCambio> findByMotivoCambioIgnoreCase(@Param("motivoCambio") String motivoCambio);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM BateriaMotivoCambio b WHERE LOWER(b.motivoCambio) = LOWER(:motivoCambio)")
    boolean existsByMotivoCambioIgnoreCase(@Param("motivoCambio") String motivoCambio);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM BateriaMotivoCambio b WHERE LOWER(b.motivoCambio) = LOWER(:motivoCambio) AND b.id <> :id")
    boolean existsByMotivoCambioIgnoreCaseAndIdNot(@Param("motivoCambio") String motivoCambio, @Param("id") Integer id);
}
