package com.tallermecanico.repository;

import com.tallermecanico.entity.RequisitoMTT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequisitoMTTRepository extends JpaRepository<RequisitoMTT, Integer> {

    @Query("SELECT r FROM RequisitoMTT r WHERE LOWER(r.requisito) = LOWER(:requisito)")
    Optional<RequisitoMTT> findByRequisitoIgnoreCase(@Param("requisito") String requisito);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM RequisitoMTT r WHERE LOWER(r.requisito) = LOWER(:requisito)")
    boolean existsByRequisitoIgnoreCase(@Param("requisito") String requisito);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM RequisitoMTT r WHERE LOWER(r.requisito) = LOWER(:requisito) AND r.id <> :id")
    boolean existsByRequisitoIgnoreCaseAndIdNot(@Param("requisito") String requisito, @Param("id") Integer id);
}
