package com.tallermecanico.repository;

import com.tallermecanico.entity.PautaSM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PautaSMRepository extends JpaRepository<PautaSM, Integer> {

    @Query("SELECT p FROM PautaSM p WHERE LOWER(p.pauta) = LOWER(:pauta)")
    Optional<PautaSM> findByPautaIgnoreCase(@Param("pauta") String pauta);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PautaSM p WHERE LOWER(p.pauta) = LOWER(:pauta)")
    boolean existsByPautaIgnoreCase(@Param("pauta") String pauta);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PautaSM p WHERE LOWER(p.pauta) = LOWER(:pauta) AND p.id <> :id")
    boolean existsByPautaIgnoreCaseAndIdNot(@Param("pauta") String pauta, @Param("id") Integer id);
}
