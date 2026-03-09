package com.tallermecanico.repository;

import com.tallermecanico.entity.TipoVisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoVisaRepository extends JpaRepository<TipoVisa, Integer> {

    @Query("SELECT t FROM TipoVisa t WHERE LOWER(t.tipoVisa) = LOWER(:tipoVisa)")
    Optional<TipoVisa> findByTipoVisaIgnoreCase(@Param("tipoVisa") String tipoVisa);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM TipoVisa t WHERE LOWER(t.tipoVisa) = LOWER(:tipoVisa)")
    boolean existsByTipoVisaIgnoreCase(@Param("tipoVisa") String tipoVisa);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM TipoVisa t WHERE LOWER(t.tipoVisa) = LOWER(:tipoVisa) AND t.id <> :id")
    boolean existsByTipoVisaIgnoreCaseAndIdNot(@Param("tipoVisa") String tipoVisa, @Param("id") Integer id);
}
