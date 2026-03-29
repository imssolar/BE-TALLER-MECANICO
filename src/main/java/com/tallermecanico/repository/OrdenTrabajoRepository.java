package com.tallermecanico.repository;

import com.tallermecanico.entity.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Integer> {

    @Query("SELECT o FROM OrdenTrabajo o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.jefeTurnoPatio LEFT JOIN FETCH o.jefeTurnoMant LEFT JOIN FETCH o.supervCalidad")
    List<OrdenTrabajo> findAllWithRelations();

    @Query("SELECT o FROM OrdenTrabajo o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.jefeTurnoPatio LEFT JOIN FETCH o.jefeTurnoMant LEFT JOIN FETCH o.supervCalidad WHERE o.id = :id")
    Optional<OrdenTrabajo> findByIdWithRelations(Integer id);

    @Query("SELECT o FROM OrdenTrabajo o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.jefeTurnoPatio LEFT JOIN FETCH o.jefeTurnoMant LEFT JOIN FETCH o.supervCalidad WHERE o.bus.idBus = :idBus")
    List<OrdenTrabajo> findByBusWithRelations(Integer idBus);

    @Query("SELECT o FROM OrdenTrabajo o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.conductor LEFT JOIN FETCH o.jefeTurnoPatio LEFT JOIN FETCH o.jefeTurnoMant LEFT JOIN FETCH o.supervCalidad WHERE o.terminal.idTerminal = :idTerminal")
    List<OrdenTrabajo> findByTerminalWithRelations(Integer idTerminal);
}
