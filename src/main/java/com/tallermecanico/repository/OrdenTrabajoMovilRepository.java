package com.tallermecanico.repository;

import com.tallermecanico.entity.OrdenTrabajoMovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdenTrabajoMovilRepository extends JpaRepository<OrdenTrabajoMovil, Integer> {

    @Query("SELECT o FROM OrdenTrabajoMovil o LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.responsable LEFT JOIN FETCH o.respTecnico LEFT JOIN FETCH o.respRecepciona")
    List<OrdenTrabajoMovil> findAllWithRelations();

    @Query("SELECT o FROM OrdenTrabajoMovil o LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.responsable LEFT JOIN FETCH o.respTecnico LEFT JOIN FETCH o.respRecepciona WHERE o.id = :id")
    Optional<OrdenTrabajoMovil> findByIdWithRelations(Integer id);

    @Query("SELECT o FROM OrdenTrabajoMovil o LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.responsable LEFT JOIN FETCH o.respTecnico LEFT JOIN FETCH o.respRecepciona WHERE o.terminal.idTerminal = :idTerminal")
    List<OrdenTrabajoMovil> findByTerminalWithRelations(Integer idTerminal);
}
