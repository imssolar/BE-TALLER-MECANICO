package com.tallermecanico.repository;

import com.tallermecanico.entity.OrdenTrabajoProg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdenTrabajoProgRepository extends JpaRepository<OrdenTrabajoProg, Integer> {

    @Query("SELECT o FROM OrdenTrabajoProg o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.jefeTurnoPatio LEFT JOIN FETCH o.jefeTurnoMant LEFT JOIN FETCH o.supervCalidad")
    List<OrdenTrabajoProg> findAllWithRelations();

    @Query("SELECT o FROM OrdenTrabajoProg o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.jefeTurnoPatio LEFT JOIN FETCH o.jefeTurnoMant LEFT JOIN FETCH o.supervCalidad WHERE o.id = :id")
    Optional<OrdenTrabajoProg> findByIdWithRelations(Integer id);

    @Query("SELECT o FROM OrdenTrabajoProg o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.jefeTurnoPatio LEFT JOIN FETCH o.jefeTurnoMant LEFT JOIN FETCH o.supervCalidad WHERE o.bus.idBus = :idBus")
    List<OrdenTrabajoProg> findByBusWithRelations(Integer idBus);

    @Query("SELECT o FROM OrdenTrabajoProg o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.jefeTurnoPatio LEFT JOIN FETCH o.jefeTurnoMant LEFT JOIN FETCH o.supervCalidad WHERE o.terminal.idTerminal = :idTerminal")
    List<OrdenTrabajoProg> findByTerminalWithRelations(Integer idTerminal);
}
