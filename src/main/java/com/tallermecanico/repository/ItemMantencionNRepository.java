package com.tallermecanico.repository;

import com.tallermecanico.entity.ItemMantencionN;
import com.tallermecanico.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMantencionNRepository extends JpaRepository<ItemMantencionN, Integer> {

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM ItemMantencionN i " +
            "WHERE LOWER(i.descripcion) = LOWER(:descripcion) AND i.modelo = :modelo")
    boolean existsByDescripcionIgnoreCaseAndModelo(@Param("descripcion") String descripcion,
                                                   @Param("modelo") Modelo modelo);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM ItemMantencionN i " +
            "WHERE LOWER(i.descripcion) = LOWER(:descripcion) AND i.modelo = :modelo AND i.id <> :id")
    boolean existsByDescripcionIgnoreCaseAndModeloAndIdNot(@Param("descripcion") String descripcion,
                                                           @Param("modelo") Modelo modelo,
                                                           @Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM ItemMantencionN i " +
            "WHERE LOWER(i.descripcion) = LOWER(:descripcion) AND i.modelo IS NULL")
    boolean existsByDescripcionIgnoreCaseAndModeloIsNull(@Param("descripcion") String descripcion);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM ItemMantencionN i " +
            "WHERE LOWER(i.descripcion) = LOWER(:descripcion) AND i.modelo IS NULL AND i.id <> :id")
    boolean existsByDescripcionIgnoreCaseAndModeloIsNullAndIdNot(@Param("descripcion") String descripcion,
                                                                 @Param("id") Integer id);
}
