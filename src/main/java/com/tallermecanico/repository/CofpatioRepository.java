package com.tallermecanico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tallermecanico.entity.Cofpatio;

@Repository
public interface CofpatioRepository extends JpaRepository<Cofpatio, Integer> {

    @Query("SELECT c FROM Cofpatio c LEFT JOIN FETCH c.bus LEFT JOIN FETCH c.mecanico LEFT JOIN FETCH c.conductor LEFT JOIN FETCH c.responsable LEFT JOIN FETCH c.responsableCierre")
    List<Cofpatio> findAllWithRelations();

    @Query("SELECT c FROM Cofpatio c LEFT JOIN FETCH c.bus LEFT JOIN FETCH c.mecanico LEFT JOIN FETCH c.conductor LEFT JOIN FETCH c.responsable LEFT JOIN FETCH c.responsableCierre WHERE c.id= :id")
    Optional<Cofpatio> findByIdWithRelations(Integer id);

    @Query("SELECT c FROM Cofpatio c LEFT JOIN FETCH c.bus LEFT JOIN FETCH c.mecanico LEFT JOIN FETCH c.conductor LEFT JOIN FETCH c.responsable LEFT JOIN FETCH c.responsableCierre WHERE c.bus.idBus= :idBus")
    List<Cofpatio> findByBusWithRelations(Integer idBus);
}
