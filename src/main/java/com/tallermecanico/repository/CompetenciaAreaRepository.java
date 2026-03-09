package com.tallermecanico.repository;

import com.tallermecanico.entity.CompetenciaArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetenciaAreaRepository extends JpaRepository<CompetenciaArea, Integer> {

    @Query("SELECT ca FROM CompetenciaArea ca WHERE LOWER(ca.area) = LOWER(:area)")
    Optional<CompetenciaArea> findByAreaIgnoreCase(@Param("area") String area);

    @Query("SELECT CASE WHEN COUNT(ca) > 0 THEN true ELSE false END FROM CompetenciaArea ca WHERE LOWER(ca.area) = LOWER(:area)")
    boolean existsByAreaIgnoreCase(@Param("area") String area);

    @Query("SELECT CASE WHEN COUNT(ca) > 0 THEN true ELSE false END FROM CompetenciaArea ca WHERE LOWER(ca.area) = LOWER(:area) AND ca.id <> :id")
    boolean existsByAreaIgnoreCaseAndIdNot(@Param("area") String area, @Param("id") Integer id);
}
