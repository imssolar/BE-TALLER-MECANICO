package com.tallermecanico.repository;

import com.tallermecanico.entity.GravedadPintura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GravedadPinturaRepository extends JpaRepository<GravedadPintura, Integer> {

    @Query("SELECT g FROM GravedadPintura g WHERE LOWER(g.gravedad) = LOWER(:gravedad)")
    Optional<GravedadPintura> findByGravedadIgnoreCase(@Param("gravedad") String gravedad);

    @Query("SELECT CASE WHEN COUNT(g) > 0 THEN true ELSE false END FROM GravedadPintura g WHERE LOWER(g.gravedad) = LOWER(:gravedad)")
    boolean existsByGravedadIgnoreCase(@Param("gravedad") String gravedad);

    @Query("SELECT CASE WHEN COUNT(g) > 0 THEN true ELSE false END FROM GravedadPintura g WHERE LOWER(g.gravedad) = LOWER(:gravedad) AND g.id <> :id")
    boolean existsByGravedadIgnoreCaseAndIdNot(@Param("gravedad") String gravedad, @Param("id") Integer id);
}
