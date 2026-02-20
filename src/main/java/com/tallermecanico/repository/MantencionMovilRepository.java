package com.tallermecanico.repository;

import com.tallermecanico.entity.MantencionMovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MantencionMovilRepository extends JpaRepository<MantencionMovil, Integer> {

    @Query("SELECT m FROM MantencionMovil m WHERE LOWER(m.item) = LOWER(:item)")
    Optional<MantencionMovil> findByItemIgnoreCase(@Param("item") String item);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MantencionMovil m WHERE LOWER(m.item) = LOWER(:item)")
    boolean existsByItemIgnoreCase(@Param("item") String item);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MantencionMovil m WHERE LOWER(m.item) = LOWER(:item) AND m.id <> :id")
    boolean existsByItemIgnoreCaseAndIdNot(@Param("item") String item, @Param("id") Integer id);
}
