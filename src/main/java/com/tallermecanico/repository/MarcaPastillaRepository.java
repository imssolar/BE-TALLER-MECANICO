package com.tallermecanico.repository;

import com.tallermecanico.entity.MarcaPastilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarcaPastillaRepository extends JpaRepository<MarcaPastilla, Integer> {

    @Query("SELECT m FROM MarcaPastilla m WHERE LOWER(m.marcaPastilla) = LOWER(:marcaPastilla)")
    Optional<MarcaPastilla> findByMarcaPastillaIgnoreCase(@Param("marcaPastilla") String marcaPastilla);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MarcaPastilla m WHERE LOWER(m.marcaPastilla) = LOWER(:marcaPastilla)")
    boolean existsByMarcaPastillaIgnoreCase(@Param("marcaPastilla") String marcaPastilla);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MarcaPastilla m WHERE LOWER(m.marcaPastilla) = LOWER(:marcaPastilla) AND m.id <> :id")
    boolean existsByMarcaPastillaIgnoreCaseAndIdNot(@Param("marcaPastilla") String marcaPastilla, @Param("id") Integer id);
}
