package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreatePlanRendimientoDto;
import com.tallermecanico.dto.request.UpdatePlanRendimientoDto;
import com.tallermecanico.dto.response.DeletePlanRendimientoResponseDto;
import com.tallermecanico.entity.EstadosNeumatico;
import com.tallermecanico.entity.MarcasNeumatico;
import com.tallermecanico.entity.ModelosNeumatico;
import com.tallermecanico.entity.PlanRendimiento;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.PlanRendimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanRendimientoService {

    private final PlanRendimientoRepository planRendimientoRepository;
    private final MarcasNeumaticoService marcasNeumaticoService;
    private final ModelosNeumaticoService modelosNeumaticoService;
    private final EstadosNeumaticoService estadosNeumaticoService;

    public PlanRendimientoService(PlanRendimientoRepository planRendimientoRepository,
                                  MarcasNeumaticoService marcasNeumaticoService,
                                  ModelosNeumaticoService modelosNeumaticoService,
                                  EstadosNeumaticoService estadosNeumaticoService) {
        this.planRendimientoRepository = planRendimientoRepository;
        this.marcasNeumaticoService = marcasNeumaticoService;
        this.modelosNeumaticoService = modelosNeumaticoService;
        this.estadosNeumaticoService = estadosNeumaticoService;
    }

    @Transactional
    public PlanRendimiento create(CreatePlanRendimientoDto dto) {
        MarcasNeumatico marca = marcasNeumaticoService.findById(dto.getIdMarca());
        ModelosNeumatico modelo = modelosNeumaticoService.findById(dto.getIdModelo());
        EstadosNeumatico estado = estadosNeumaticoService.findById(dto.getIdEstado());

        // Validar combinación única
        if (planRendimientoRepository.existsByMarcaAndModeloAndEstado(marca, modelo, estado)) {
            throw new DuplicateResourceException("Ya existe un plan de rendimiento para la combinación de marca, modelo y estado proporcionada");
        }

        PlanRendimiento planRendimiento = new PlanRendimiento();
        planRendimiento.setMarca(marca);
        planRendimiento.setModelo(modelo);
        planRendimiento.setEstado(estado);
        planRendimiento.setRendimiento(dto.getRendimiento());

        return planRendimientoRepository.save(planRendimiento);
    }

    @Transactional(readOnly = true)
    public List<PlanRendimiento> findAll() {
        return planRendimientoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PlanRendimiento findById(Integer id) {
        return planRendimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanRendimiento", "id", id));
    }

    @Transactional
    public PlanRendimiento update(Integer id, UpdatePlanRendimientoDto dto) {
        PlanRendimiento planRendimiento = planRendimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanRendimiento", "id", id));

        if (dto.getIdMarca() != null) {
            MarcasNeumatico marca = marcasNeumaticoService.findById(dto.getIdMarca());
            planRendimiento.setMarca(marca);
        }
        if (dto.getIdModelo() != null) {
            ModelosNeumatico modelo = modelosNeumaticoService.findById(dto.getIdModelo());
            planRendimiento.setModelo(modelo);
        }
        if (dto.getIdEstado() != null) {
            EstadosNeumatico estado = estadosNeumaticoService.findById(dto.getIdEstado());
            planRendimiento.setEstado(estado);
        }
        if (dto.getRendimiento() != null) {
            planRendimiento.setRendimiento(dto.getRendimiento());
        }

        // Validar combinación única (excluyendo el registro actual)
        if (dto.getIdMarca() != null || dto.getIdModelo() != null || dto.getIdEstado() != null) {
            if (planRendimientoRepository.existsByMarcaAndModeloAndEstadoAndIdNot(
                    planRendimiento.getMarca(), planRendimiento.getModelo(), planRendimiento.getEstado(), id)) {
                throw new DuplicateResourceException("Ya existe un plan de rendimiento para la combinación de marca, modelo y estado proporcionada");
            }
        }

        return planRendimientoRepository.save(planRendimiento);
    }

    @Transactional
    public DeletePlanRendimientoResponseDto delete(Integer id) {
        PlanRendimiento planRendimiento = planRendimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanRendimiento", "id", id));

        planRendimientoRepository.delete(planRendimiento);
        return new DeletePlanRendimientoResponseDto(
                planRendimiento.getId(),
                "Plan de rendimiento eliminado exitosamente"
        );
    }
}
