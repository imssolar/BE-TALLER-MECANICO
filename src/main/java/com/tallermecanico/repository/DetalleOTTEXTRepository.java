package com.tallermecanico.repository;

import com.tallermecanico.entity.DetalleOTTEXT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleOTTEXTRepository extends JpaRepository<DetalleOTTEXT, Integer> {
    List<DetalleOTTEXT> findByOtTallerExt_Id(Integer idOtTallerExt);
}
