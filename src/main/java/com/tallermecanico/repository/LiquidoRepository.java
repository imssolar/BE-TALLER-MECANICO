package com.tallermecanico.repository;

import com.tallermecanico.entity.Liquido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LiquidoRepository extends JpaRepository<Liquido, Integer> {

    @Query("SELECT l FROM Liquido l WHERE LOWER(l.liquido) = LOWER(:liquido)")
    Optional<Liquido> findByLiquidoIgnoreCase(@Param("liquido") String liquido);

    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN true ELSE false END FROM Liquido l WHERE LOWER(l.liquido) = LOWER(:liquido)")
    boolean existsByLiquidoIgnoreCase(@Param("liquido") String liquido);

    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN true ELSE false END FROM Liquido l WHERE LOWER(l.liquido) = LOWER(:liquido) AND l.id <> :id")
    boolean existsByLiquidoIgnoreCaseAndIdNot(@Param("liquido") String liquido, @Param("id") Integer id);
}
