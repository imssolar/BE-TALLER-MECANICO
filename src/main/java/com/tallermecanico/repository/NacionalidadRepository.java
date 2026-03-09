package com.tallermecanico.repository;

import com.tallermecanico.entity.Nacionalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NacionalidadRepository extends JpaRepository<Nacionalidad, Integer> {

    @Query("SELECT n FROM Nacionalidad n WHERE LOWER(n.nacionalidad) = LOWER(:nacionalidad)")
    Optional<Nacionalidad> findByNacionalidadIgnoreCase(@Param("nacionalidad") String nacionalidad);

    @Query("SELECT CASE WHEN COUNT(n) > 0 THEN true ELSE false END FROM Nacionalidad n WHERE LOWER(n.nacionalidad) = LOWER(:nacionalidad)")
    boolean existsByNacionalidadIgnoreCase(@Param("nacionalidad") String nacionalidad);

    @Query("SELECT CASE WHEN COUNT(n) > 0 THEN true ELSE false END FROM Nacionalidad n WHERE LOWER(n.nacionalidad) = LOWER(:nacionalidad) AND n.id <> :id")
    boolean existsByNacionalidadIgnoreCaseAndIdNot(@Param("nacionalidad") String nacionalidad, @Param("id") Integer id);
}
