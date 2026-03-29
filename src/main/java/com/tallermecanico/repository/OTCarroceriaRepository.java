package com.tallermecanico.repository;

import com.tallermecanico.entity.OTCarroceria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OTCarroceriaRepository extends JpaRepository<OTCarroceria, Integer> {

    @Query("SELECT o FROM OTCarroceria o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.gravedadCarroceria LEFT JOIN FETCH o.gravedadPintura LEFT JOIN FETCH o.gravedadFibra")
    List<OTCarroceria> findAllWithRelations();

    @Query("SELECT o FROM OTCarroceria o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.gravedadCarroceria LEFT JOIN FETCH o.gravedadPintura LEFT JOIN FETCH o.gravedadFibra WHERE o.id = :id")
    Optional<OTCarroceria> findByIdWithRelations(@Param("id") Integer id);

    @Query("SELECT o FROM OTCarroceria o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.gravedadCarroceria LEFT JOIN FETCH o.gravedadPintura LEFT JOIN FETCH o.gravedadFibra WHERE o.bus.idBus = :idBus")
    List<OTCarroceria> findByBusWithRelations(@Param("idBus") Integer idBus);

    @Query("SELECT o FROM OTCarroceria o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.terminal LEFT JOIN FETCH o.gravedadCarroceria LEFT JOIN FETCH o.gravedadPintura LEFT JOIN FETCH o.gravedadFibra WHERE o.terminal.idTerminal = :idTerminal")
    List<OTCarroceria> findByTerminalWithRelations(@Param("idTerminal") Integer idTerminal);
}
