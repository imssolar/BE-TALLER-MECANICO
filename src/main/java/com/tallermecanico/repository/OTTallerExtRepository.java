package com.tallermecanico.repository;

import com.tallermecanico.entity.OTTallerExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OTTallerExtRepository extends JpaRepository<OTTallerExt, Integer> {

    @Query("SELECT o FROM OTTallerExt o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.conductor")
    List<OTTallerExt> findAllWithRelations();

    @Query("SELECT o FROM OTTallerExt o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.conductor WHERE o.id = :id")
    Optional<OTTallerExt> findByIdWithRelations(@Param("id") Integer id);

    @Query("SELECT o FROM OTTallerExt o LEFT JOIN FETCH o.bus LEFT JOIN FETCH o.conductor WHERE o.bus.idBus = :idBus")
    List<OTTallerExt> findByBusWithRelations(@Param("idBus") Integer idBus);
}
