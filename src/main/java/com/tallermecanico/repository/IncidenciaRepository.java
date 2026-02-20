package com.tallermecanico.repository;

import com.tallermecanico.entity.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {

    @Query("SELECT i FROM Incidencia i WHERE LOWER(i.incidencia) = LOWER(:incidencia)")
    Optional<Incidencia> findByIncidenciaIgnoreCase(@Param("incidencia") String incidencia);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM Incidencia i WHERE LOWER(i.incidencia) = LOWER(:incidencia)")
    boolean existsByIncidenciaIgnoreCase(@Param("incidencia") String incidencia);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM Incidencia i WHERE LOWER(i.incidencia) = LOWER(:incidencia) AND i.id <> :id")
    boolean existsByIncidenciaIgnoreCaseAndIdNot(@Param("incidencia") String incidencia, @Param("id") Integer id);
}
