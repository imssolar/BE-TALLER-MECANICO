package com.tallermecanico.repository;

import com.tallermecanico.entity.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {

    @Query("SELECT c FROM Comuna c WHERE LOWER(c.comuna) = LOWER(:comuna)")
    Optional<Comuna> findByComunaIgnoreCase(@Param("comuna") String comuna);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Comuna c WHERE LOWER(c.comuna) = LOWER(:comuna)")
    boolean existsByComunaIgnoreCase(@Param("comuna") String comuna);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Comuna c WHERE LOWER(c.comuna) = LOWER(:comuna) AND c.id <> :id")
    boolean existsByComunaIgnoreCaseAndIdNot(@Param("comuna") String comuna, @Param("id") Integer id);
}
