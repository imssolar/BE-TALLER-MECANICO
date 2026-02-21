package com.tallermecanico.repository;

import com.tallermecanico.entity.FacturaDetalleTC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaDetalleTCRepository extends JpaRepository<FacturaDetalleTC, Integer> {
    List<FacturaDetalleTC> findByFactura_Id(Integer idFactura);
}
