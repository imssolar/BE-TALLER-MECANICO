package com.tallermecanico.repository;

import com.tallermecanico.entity.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer> {

    @Query("SELECT r FROM Ruta r WHERE LOWER(r.ruta) = LOWER(:ruta)")
    Optional<Ruta> findByRutaIgnoreCase(@Param("ruta") String ruta);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Ruta r WHERE LOWER(r.ruta) = LOWER(:ruta)")
    boolean existsByRutaIgnoreCase(@Param("ruta") String ruta);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Ruta r WHERE LOWER(r.ruta) = LOWER(:ruta) AND r.idRuta <> :idRuta")
    boolean existsByRutaIgnoreCaseAndIdRutaNot(@Param("ruta") String ruta, @Param("idRuta") Integer idRuta);
}
