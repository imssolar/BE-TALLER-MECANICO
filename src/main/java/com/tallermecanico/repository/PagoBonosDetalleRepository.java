package com.tallermecanico.repository;

import com.tallermecanico.entity.PagoBonosDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoBonosDetalleRepository extends JpaRepository<PagoBonosDetalle, Integer> {

    List<PagoBonosDetalle> findByPagoBonos_Id(Integer idPagoBonos);

    List<PagoBonosDetalle> findByBus_IdBus(Integer idBus);

    List<PagoBonosDetalle> findByRut(String rut);
}
