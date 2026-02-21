package com.tallermecanico.repository;

import com.tallermecanico.entity.DetalleMTTOT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleMTTOTRepository extends JpaRepository<DetalleMTTOT, Integer> {

    List<DetalleMTTOT> findByOrdenTrabajo_Id(Integer idOrdenTrabajo);
}
