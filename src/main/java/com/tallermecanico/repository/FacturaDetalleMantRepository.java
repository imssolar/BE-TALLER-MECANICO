package com.tallermecanico.repository;

import com.tallermecanico.entity.FacturaDetalleMant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaDetalleMantRepository extends JpaRepository<FacturaDetalleMant, Integer> {
    List<FacturaDetalleMant> findByFactura_Id(Integer idFactura);
}
