package com.tallermecanico.repository;

import com.tallermecanico.entity.PautaOTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PautaOTPRepository extends JpaRepository<PautaOTP, Integer> {

    @Query("SELECT p FROM PautaOTP p WHERE LOWER(p.pauta) = LOWER(:pauta)")
    Optional<PautaOTP> findByPautaIgnoreCase(@Param("pauta") String pauta);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PautaOTP p WHERE LOWER(p.pauta) = LOWER(:pauta)")
    boolean existsByPautaIgnoreCase(@Param("pauta") String pauta);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PautaOTP p WHERE LOWER(p.pauta) = LOWER(:pauta) AND p.id <> :id")
    boolean existsByPautaIgnoreCaseAndIdNot(@Param("pauta") String pauta, @Param("id") Integer id);
}
