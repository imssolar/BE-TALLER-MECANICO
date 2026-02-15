package com.tallermecanico.repository;

import com.tallermecanico.entity.Empleado;
import com.tallermecanico.enums.CargoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    Optional<Empleado> findByRut(String rut);

    List<Empleado> findByActivo(Boolean activo);

    List<Empleado> findByCargoAndActivo(CargoEmpleado cargo, Boolean activo);

    boolean existsByRut(String rut);

    boolean existsByRutAndIdNot(String rut, Integer id);
}
