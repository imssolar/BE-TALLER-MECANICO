package com.tallermecanico.repository;

import com.tallermecanico.entity.ResponsableCierre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsableCierreRepository extends JpaRepository<ResponsableCierre, Integer> {

    @Query("SELECT r FROM ResponsableCierre r WHERE LOWER(r.nombre) = LOWER(:nombre)")
    Optional<ResponsableCierre> findByNombreIgnoreCase(@Param("nombre") String nombre);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM ResponsableCierre r WHERE LOWER(r.nombre) = LOWER(:nombre)")
    boolean existsByNombreIgnoreCase(@Param("nombre") String nombre);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM ResponsableCierre r WHERE LOWER(r.nombre) = LOWER(:nombre) AND r.id <> :id")
    boolean existsByNombreIgnoreCaseAndIdNot(@Param("nombre") String nombre, @Param("id") Integer id);
}
