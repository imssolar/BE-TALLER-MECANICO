package com.tallermecanico.repository;

import com.tallermecanico.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

    @Query("SELECT m FROM Modelo m WHERE LOWER(m.modelo) = LOWER(:modelo)")
    Optional<Modelo> findByModeloIgnoreCase(@Param("modelo") String modelo);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Modelo m WHERE LOWER(m.modelo) = LOWER(:modelo)")
    boolean existsByModeloIgnoreCase(@Param("modelo") String modelo);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Modelo m WHERE LOWER(m.modelo) = LOWER(:modelo) AND m.id <> :id")
    boolean existsByModeloIgnoreCaseAndIdNot(@Param("modelo") String modelo, @Param("id") Integer id);
}
