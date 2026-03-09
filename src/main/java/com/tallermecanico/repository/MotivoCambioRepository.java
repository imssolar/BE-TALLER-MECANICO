package com.tallermecanico.repository;

import com.tallermecanico.entity.MotivoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotivoCambioRepository extends JpaRepository<MotivoCambio, Integer> {

    @Query("SELECT m FROM MotivoCambio m WHERE LOWER(m.motivo) = LOWER(:motivo)")
    Optional<MotivoCambio> findByMotivoIgnoreCase(@Param("motivo") String motivo);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MotivoCambio m WHERE LOWER(m.motivo) = LOWER(:motivo)")
    boolean existsByMotivoIgnoreCase(@Param("motivo") String motivo);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MotivoCambio m WHERE LOWER(m.motivo) = LOWER(:motivo) AND m.id <> :id")
    boolean existsByMotivoIgnoreCaseAndIdNot(@Param("motivo") String motivo, @Param("id") Integer id);
}
