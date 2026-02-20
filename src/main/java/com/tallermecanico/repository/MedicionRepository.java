package com.tallermecanico.repository;

import com.tallermecanico.entity.Medicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicionRepository extends JpaRepository<Medicion, Integer> {

    @Query("SELECT m FROM Medicion m WHERE LOWER(m.medicion) = LOWER(:medicion)")
    Optional<Medicion> findByMedicionIgnoreCase(@Param("medicion") String medicion);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Medicion m WHERE LOWER(m.medicion) = LOWER(:medicion)")
    boolean existsByMedicionIgnoreCase(@Param("medicion") String medicion);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Medicion m WHERE LOWER(m.medicion) = LOWER(:medicion) AND m.id <> :id")
    boolean existsByMedicionIgnoreCaseAndIdNot(@Param("medicion") String medicion, @Param("id") Integer id);
}
