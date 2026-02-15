package com.tallermecanico.repository;

import com.tallermecanico.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

    Optional<Bus> findByPatenteB(String patenteB);

    List<Bus> findByOperativaBAndActivoB(Boolean operativaB, Boolean activoB);

    List<Bus> findByActivoB(Boolean activoB);

    List<Bus> findByMantencionB(Boolean mantencionB);

    List<Bus> findByTerminal_IdTerminal(Integer idTerminal);

    List<Bus> findByModelo_IdModelo(Integer idModelo);

    boolean existsByPatenteB(String patenteB);

    boolean existsByPatenteBAndIdBusNot(String patenteB, Integer idBus);

    @Query("SELECT COUNT(b) FROM Bus b WHERE b.operativaB = true AND b.activoB = true")
    long countOperativos();

    @Query("SELECT COUNT(b) FROM Bus b WHERE b.activoB = false")
    long countInactivos();

    @Query("SELECT COUNT(b) FROM Bus b WHERE b.mantencionB = true")
    long countEnMantencion();
}
