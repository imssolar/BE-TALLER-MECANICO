package com.tallermecanico.repository;

import com.tallermecanico.entity.MedicionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicionProductoRepository extends JpaRepository<MedicionProducto, Integer> {

    @Query("SELECT m FROM MedicionProducto m WHERE LOWER(m.producto) = LOWER(:producto)")
    Optional<MedicionProducto> findByProductoIgnoreCase(@Param("producto") String producto);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MedicionProducto m WHERE LOWER(m.producto) = LOWER(:producto)")
    boolean existsByProductoIgnoreCase(@Param("producto") String producto);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MedicionProducto m WHERE LOWER(m.producto) = LOWER(:producto) AND m.id <> :id")
    boolean existsByProductoIgnoreCaseAndIdNot(@Param("producto") String producto, @Param("id") Integer id);
}
