package com.tallermecanico.repository;

import com.tallermecanico.entity.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipamientoRepository extends JpaRepository<Equipamiento, Integer> {

    @Query("SELECT e FROM Equipamiento e WHERE LOWER(e.equipamiento) = LOWER(:equipamiento)")
    Optional<Equipamiento> findByEquipamientoIgnoreCase(@Param("equipamiento") String equipamiento);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Equipamiento e WHERE LOWER(e.equipamiento) = LOWER(:equipamiento)")
    boolean existsByEquipamientoIgnoreCase(@Param("equipamiento") String equipamiento);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Equipamiento e WHERE LOWER(e.equipamiento) = LOWER(:equipamiento) AND e.id <> :id")
    boolean existsByEquipamientoIgnoreCaseAndIdNot(@Param("equipamiento") String equipamiento, @Param("id") Integer id);
}
