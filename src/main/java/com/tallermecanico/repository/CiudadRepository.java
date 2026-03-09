package com.tallermecanico.repository;

import com.tallermecanico.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

    @Query("SELECT c FROM Ciudad c WHERE LOWER(c.ciudad) = LOWER(:ciudad)")
    Optional<Ciudad> findByCiudadIgnoreCase(@Param("ciudad") String ciudad);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Ciudad c WHERE LOWER(c.ciudad) = LOWER(:ciudad)")
    boolean existsByCiudadIgnoreCase(@Param("ciudad") String ciudad);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Ciudad c WHERE LOWER(c.ciudad) = LOWER(:ciudad) AND c.id <> :id")
    boolean existsByCiudadIgnoreCaseAndIdNot(@Param("ciudad") String ciudad, @Param("id") Integer id);
}
