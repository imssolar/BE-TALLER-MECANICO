package com.tallermecanico.repository;

import com.tallermecanico.entity.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Integer> {

    @Query("SELECT h FROM Herramienta h WHERE LOWER(h.herramienta) = LOWER(:herramienta)")
    Optional<Herramienta> findByHerramientaIgnoreCase(@Param("herramienta") String herramienta);

    @Query("SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END FROM Herramienta h WHERE LOWER(h.herramienta) = LOWER(:herramienta)")
    boolean existsByHerramientaIgnoreCase(@Param("herramienta") String herramienta);

    @Query("SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END FROM Herramienta h WHERE LOWER(h.herramienta) = LOWER(:herramienta) AND h.id <> :id")
    boolean existsByHerramientaIgnoreCaseAndIdNot(@Param("herramienta") String herramienta, @Param("id") Integer id);
}
