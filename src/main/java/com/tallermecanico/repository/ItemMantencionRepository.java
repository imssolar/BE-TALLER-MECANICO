package com.tallermecanico.repository;

import com.tallermecanico.entity.ItemMantencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemMantencionRepository extends JpaRepository<ItemMantencion, Integer> {

    @Query("SELECT i FROM ItemMantencion i WHERE LOWER(i.descripcion) = LOWER(:descripcion)")
    Optional<ItemMantencion> findByDescripcionIgnoreCase(@Param("descripcion") String descripcion);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM ItemMantencion i WHERE LOWER(i.descripcion) = LOWER(:descripcion)")
    boolean existsByDescripcionIgnoreCase(@Param("descripcion") String descripcion);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM ItemMantencion i WHERE LOWER(i.descripcion) = LOWER(:descripcion) AND i.id <> :id")
    boolean existsByDescripcionIgnoreCaseAndIdNot(@Param("descripcion") String descripcion, @Param("id") Integer id);
}
