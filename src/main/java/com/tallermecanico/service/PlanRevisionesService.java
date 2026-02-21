package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreatePlanRevisionesDto;
import com.tallermecanico.dto.request.UpdatePlanRevisionesDto;
import com.tallermecanico.dto.response.DeletePlanRevisionesResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.PlanRevisiones;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.PlanRevisionesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanRevisionesService {

    private final PlanRevisionesRepository planRevisionesRepository;
    private final BusService busService;

    public PlanRevisionesService(PlanRevisionesRepository planRevisionesRepository,
                                 BusService busService) {
        this.planRevisionesRepository = planRevisionesRepository;
        this.busService = busService;
    }

    @Transactional
    public PlanRevisiones create(CreatePlanRevisionesDto dto) {
        PlanRevisiones planRevisiones = new PlanRevisiones();

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            planRevisiones.setBus(bus);
        }

        planRevisiones.setTipo(dto.getTipo());
        planRevisiones.setFechaRevision(dto.getFechaRevision());
        planRevisiones.setEstado(dto.getEstado());

        return planRevisionesRepository.save(planRevisiones);
    }

    @Transactional(readOnly = true)
    public List<PlanRevisiones> findAll() {
        return planRevisionesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PlanRevisiones findById(Integer id) {
        return planRevisionesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanRevisiones", "id", id));
    }

    @Transactional(readOnly = true)
    public List<PlanRevisiones> findByBus(Integer idBus) {
        return planRevisionesRepository.findByBus_IdBus(idBus);
    }

    @Transactional
    public PlanRevisiones update(Integer id, UpdatePlanRevisionesDto dto) {
        PlanRevisiones planRevisiones = findById(id);

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            planRevisiones.setBus(bus);
        }
        if (dto.getTipo() != null) {
            planRevisiones.setTipo(dto.getTipo());
        }
        if (dto.getFechaRevision() != null) {
            planRevisiones.setFechaRevision(dto.getFechaRevision());
        }
        if (dto.getEstado() != null) {
            planRevisiones.setEstado(dto.getEstado());
        }

        return planRevisionesRepository.save(planRevisiones);
    }

    @Transactional
    public DeletePlanRevisionesResponseDto delete(Integer id) {
        PlanRevisiones planRevisiones = findById(id);
        planRevisionesRepository.delete(planRevisiones);
        return new DeletePlanRevisionesResponseDto(planRevisiones.getId(), "Plan de revisiones eliminado exitosamente");
    }
}
