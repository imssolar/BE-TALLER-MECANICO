package com.tallermecanico.repository;

import com.tallermecanico.entity.BateriaModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BateriaModeloRepository extends JpaRepository<BateriaModelo, Integer> {

    @Query("SELECT b FROM BateriaModelo b WHERE LOWER(b.modelo) = LOWER(:modelo)")
    Optional<BateriaModelo> findByModeloIgnoreCase(@Param("modelo") String modelo);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM BateriaModelo b WHERE LOWER(b.modelo) = LOWER(:modelo)")
    boolean existsByModeloIgnoreCase(@Param("modelo") String modelo);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM BateriaModelo b WHERE LOWER(b.modelo) = LOWER(:modelo) AND b.id <> :id")
    boolean existsByModeloIgnoreCaseAndIdNot(@Param("modelo") String modelo, @Param("id") Integer id);
}
