package com.tallermecanico.repository;

import com.tallermecanico.entity.RepuestoCarroceria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepuestoCarroceriaRepository extends JpaRepository<RepuestoCarroceria, Integer> {

    @Query("SELECT r FROM RepuestoCarroceria r WHERE LOWER(r.repuesto) = LOWER(:repuesto)")
    Optional<RepuestoCarroceria> findByRepuestoIgnoreCase(@Param("repuesto") String repuesto);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM RepuestoCarroceria r WHERE LOWER(r.repuesto) = LOWER(:repuesto)")
    boolean existsByRepuestoIgnoreCase(@Param("repuesto") String repuesto);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM RepuestoCarroceria r WHERE LOWER(r.repuesto) = LOWER(:repuesto) AND r.id <> :id")
    boolean existsByRepuestoIgnoreCaseAndIdNot(@Param("repuesto") String repuesto, @Param("id") Integer id);
}
