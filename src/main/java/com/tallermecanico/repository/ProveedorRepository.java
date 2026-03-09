package com.tallermecanico.repository;

import com.tallermecanico.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    boolean existsByRut(String rut);

    boolean existsByRutAndIdNot(String rut, Integer id);
}
