package com.tallermecanico.repository;

import com.tallermecanico.entity.EstadosNeumatico;
import com.tallermecanico.entity.MarcasNeumatico;
import com.tallermecanico.entity.ModelosNeumatico;
import com.tallermecanico.entity.PlanRendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRendimientoRepository extends JpaRepository<PlanRendimiento, Integer> {

    boolean existsByMarcaAndModeloAndEstado(MarcasNeumatico marca, ModelosNeumatico modelo, EstadosNeumatico estado);

    boolean existsByMarcaAndModeloAndEstadoAndIdNot(MarcasNeumatico marca, ModelosNeumatico modelo, EstadosNeumatico estado, Integer id);
}
