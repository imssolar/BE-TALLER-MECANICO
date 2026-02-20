package com.tallermecanico.repository;

import com.tallermecanico.entity.Parametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, Integer> {

    @Query("SELECT p FROM Parametro p WHERE LOWER(p.descripcion) = LOWER(:descripcion)")
    Optional<Parametro> findByDescripcionIgnoreCase(@Param("descripcion") String descripcion);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Parametro p WHERE LOWER(p.descripcion) = LOWER(:descripcion)")
    boolean existsByDescripcionIgnoreCase(@Param("descripcion") String descripcion);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Parametro p WHERE LOWER(p.descripcion) = LOWER(:descripcion) AND p.id <> :id")
    boolean existsByDescripcionIgnoreCaseAndIdNot(@Param("descripcion") String descripcion, @Param("id") Integer id);
}
