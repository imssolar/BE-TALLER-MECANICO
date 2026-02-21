package com.tallermecanico.repository;

import com.tallermecanico.entity.OTTallerExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OTTallerExtRepository extends JpaRepository<OTTallerExt, Integer> {

    List<OTTallerExt> findByBus_IdBus(Integer idBus);
}
