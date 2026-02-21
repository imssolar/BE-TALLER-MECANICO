package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreatePlanMantenimientoMovilDto;
import com.tallermecanico.dto.request.UpdatePlanMantenimientoMovilDto;
import com.tallermecanico.dto.response.DeletePlanMantenimientoMovilResponseDto;
import com.tallermecanico.entity.PlanMantenimientoMovil;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.PlanMantenimientoMovilRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanMantenimientoMovilService {

    private final PlanMantenimientoMovilRepository planMantenimientoMovilRepository;

    public PlanMantenimientoMovilService(PlanMantenimientoMovilRepository planMantenimientoMovilRepository) {
        this.planMantenimientoMovilRepository = planMantenimientoMovilRepository;
    }

    @Transactional
    public PlanMantenimientoMovil create(CreatePlanMantenimientoMovilDto dto) {
        PlanMantenimientoMovil plan = new PlanMantenimientoMovil();
        plan.setIdMantencion(dto.getIdMantencion());
        plan.setNroMovil(dto.getNroMovil());
        plan.setPeriodo(dto.getPeriodo());
        plan.setKmMantencion(dto.getKmMantencion());
        plan.setFechaMantencion(dto.getFechaMantencion());
        plan.setKmRealizada(dto.getKmRealizada());
        plan.setRealizada(dto.getRealizada());
        plan.setNroOtp(dto.getNroOtp());

        return planMantenimientoMovilRepository.save(plan);
    }

    @Transactional(readOnly = true)
    public List<PlanMantenimientoMovil> findAll() {
        return planMantenimientoMovilRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PlanMantenimientoMovil findById(Integer id) {
        return planMantenimientoMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanMantenimientoMovil", "id", id));
    }

    @Transactional
    public PlanMantenimientoMovil update(Integer id, UpdatePlanMantenimientoMovilDto dto) {
        PlanMantenimientoMovil plan = planMantenimientoMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanMantenimientoMovil", "id", id));

        if (dto.getIdMantencion() != null) {
            plan.setIdMantencion(dto.getIdMantencion());
        }
        if (dto.getNroMovil() != null) {
            plan.setNroMovil(dto.getNroMovil());
        }
        if (dto.getPeriodo() != null) {
            plan.setPeriodo(dto.getPeriodo());
        }
        if (dto.getKmMantencion() != null) {
            plan.setKmMantencion(dto.getKmMantencion());
        }
        if (dto.getFechaMantencion() != null) {
            plan.setFechaMantencion(dto.getFechaMantencion());
        }
        if (dto.getKmRealizada() != null) {
            plan.setKmRealizada(dto.getKmRealizada());
        }
        if (dto.getRealizada() != null) {
            plan.setRealizada(dto.getRealizada());
        }
        if (dto.getNroOtp() != null) {
            plan.setNroOtp(dto.getNroOtp());
        }

        return planMantenimientoMovilRepository.save(plan);
    }

    @Transactional
    public DeletePlanMantenimientoMovilResponseDto delete(Integer id) {
        PlanMantenimientoMovil plan = planMantenimientoMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanMantenimientoMovil", "id", id));

        planMantenimientoMovilRepository.delete(plan);
        return new DeletePlanMantenimientoMovilResponseDto(
                plan.getId(),
                "Plan de mantenimiento móvil eliminado exitosamente"
        );
    }
}
