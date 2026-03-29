package com.tallermecanico.repository;

import com.tallermecanico.entity.OTTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OTTecnicoRepository extends JpaRepository<OTTecnico, Integer> {

    @Query("SELECT t FROM OTTecnico t LEFT JOIN FETCH t.ordenTrabajo LEFT JOIN FETCH t.ordenTrabajoProg LEFT JOIN FETCH t.empleado")
    List<OTTecnico> findAllWithRelations();

    @Query("SELECT t FROM OTTecnico t LEFT JOIN FETCH t.ordenTrabajo LEFT JOIN FETCH t.ordenTrabajoProg LEFT JOIN FETCH t.empleado WHERE t.id = :id")
    Optional<OTTecnico> findByIdWithRelations(@Param("id") Integer id);

    @Query("SELECT t FROM OTTecnico t LEFT JOIN FETCH t.ordenTrabajo LEFT JOIN FETCH t.ordenTrabajoProg LEFT JOIN FETCH t.empleado WHERE t.ordenTrabajo.id = :idOrdenTrabajo")
    List<OTTecnico> findByOrdenTrabajoWithRelations(@Param("idOrdenTrabajo") Integer idOrdenTrabajo);

    @Query("SELECT t FROM OTTecnico t LEFT JOIN FETCH t.ordenTrabajo LEFT JOIN FETCH t.ordenTrabajoProg LEFT JOIN FETCH t.empleado WHERE t.ordenTrabajoProg.id = :idOrdenTrabajoProg")
    List<OTTecnico> findByOrdenTrabajoProgWithRelations(@Param("idOrdenTrabajoProg") Integer idOrdenTrabajoProg);
}
