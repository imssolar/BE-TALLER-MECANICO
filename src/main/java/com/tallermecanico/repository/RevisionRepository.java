package com.tallermecanico.repository;

import com.tallermecanico.entity.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevisionRepository extends JpaRepository<Revision, Integer> {

    List<Revision> findByBus_IdBus(Integer idBus);

    List<Revision> findByPlanRevisiones_Id(Integer idPlanRevisiones);
}
