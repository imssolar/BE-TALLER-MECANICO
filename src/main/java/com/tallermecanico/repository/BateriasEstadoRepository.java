package com.tallermecanico.repository;

import com.tallermecanico.entity.BateriasEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BateriasEstadoRepository extends JpaRepository<BateriasEstado, Integer> {

    @Query("SELECT b FROM BateriasEstado b WHERE LOWER(b.estado) = LOWER(:estado)")
    Optional<BateriasEstado> findByEstadoIgnoreCase(@Param("estado") String estado);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM BateriasEstado b WHERE LOWER(b.estado) = LOWER(:estado)")
    boolean existsByEstadoIgnoreCase(@Param("estado") String estado);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM BateriasEstado b WHERE LOWER(b.estado) = LOWER(:estado) AND b.id <> :id")
    boolean existsByEstadoIgnoreCaseAndIdNot(@Param("estado") String estado, @Param("id") Integer id);
}
