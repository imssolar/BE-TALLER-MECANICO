package com.tallermecanico.repository;

import com.tallermecanico.entity.GravedadCarroceria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GravedadCarroceriaRepository extends JpaRepository<GravedadCarroceria, Integer> {

    @Query("SELECT g FROM GravedadCarroceria g WHERE LOWER(g.gravedad) = LOWER(:gravedad)")
    Optional<GravedadCarroceria> findByGravedadIgnoreCase(@Param("gravedad") String gravedad);

    @Query("SELECT CASE WHEN COUNT(g) > 0 THEN true ELSE false END FROM GravedadCarroceria g WHERE LOWER(g.gravedad) = LOWER(:gravedad)")
    boolean existsByGravedadIgnoreCase(@Param("gravedad") String gravedad);

    @Query("SELECT CASE WHEN COUNT(g) > 0 THEN true ELSE false END FROM GravedadCarroceria g WHERE LOWER(g.gravedad) = LOWER(:gravedad) AND g.id <> :id")
    boolean existsByGravedadIgnoreCaseAndIdNot(@Param("gravedad") String gravedad, @Param("id") Integer id);
}
