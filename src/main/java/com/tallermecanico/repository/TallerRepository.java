package com.tallermecanico.repository;

import com.tallermecanico.entity.Taller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TallerRepository extends JpaRepository<Taller, Integer> {

    @Query("SELECT t FROM Taller t WHERE LOWER(t.taller) = LOWER(:taller)")
    Optional<Taller> findByTallerIgnoreCase(@Param("taller") String taller);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Taller t WHERE LOWER(t.taller) = LOWER(:taller)")
    boolean existsByTallerIgnoreCase(@Param("taller") String taller);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Taller t WHERE LOWER(t.taller) = LOWER(:taller) AND t.id <> :id")
    boolean existsByTallerIgnoreCaseAndIdNot(@Param("taller") String taller, @Param("id") Integer id);
}
