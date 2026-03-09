package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreatePlanMantenimientoBusDto;
import com.tallermecanico.dto.request.UpdatePlanMantenimientoBusDto;
import com.tallermecanico.dto.response.DeletePlanMantenimientoBusResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.Mantencion;
import com.tallermecanico.entity.PlanMantenimientoBus;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.PlanMantenimientoBusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanMantenimientoBusService {

    private final PlanMantenimientoBusRepository planMantenimientoBusRepository;
    private final BusService busService;
    private final MantencionService mantencionService;

    public PlanMantenimientoBusService(PlanMantenimientoBusRepository planMantenimientoBusRepository,
                                       BusService busService,
                                       MantencionService mantencionService) {
        this.planMantenimientoBusRepository = planMantenimientoBusRepository;
        this.busService = busService;
        this.mantencionService = mantencionService;
    }

    @Transactional
    public PlanMantenimientoBus create(CreatePlanMantenimientoBusDto dto) {
        PlanMantenimientoBus plan = new PlanMantenimientoBus();

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            plan.setBus(bus);
        }

        if (dto.getIdMantencion() != null) {
            Mantencion mantencion = mantencionService.findById(dto.getIdMantencion());
            plan.setMantencion(mantencion);
        }

        plan.setIdItem(dto.getIdItem());
        plan.setPeriodo(dto.getPeriodo());
        plan.setKmMantencion(dto.getKmMantencion());
        plan.setFechaHoraMantencion(dto.getFechaHoraMantencion());
        plan.setKmRealizada(dto.getKmRealizada());
        plan.setRealizada(dto.getRealizada());
        plan.setIdOtp(dto.getIdOtp());
        plan.setLitros(dto.getLitros());
        plan.setAccionOk(dto.getAccionOk());
        plan.setRrhh(dto.getRrhh());
        plan.setDiasFaltantes(dto.getDiasFaltantes());
        plan.setDiasExtras(dto.getDiasExtras());
        plan.setFechaProxMtto(dto.getFechaProxMtto());
        plan.setNuevaFechaMtto(dto.getNuevaFechaMtto());
        plan.setFechaFinMtto(dto.getFechaFinMtto());

        return planMantenimientoBusRepository.save(plan);
    }

    @Transactional(readOnly = true)
    public List<PlanMantenimientoBus> findAll() {
        return planMantenimientoBusRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PlanMantenimientoBus findById(Integer id) {
        return planMantenimientoBusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanMantenimientoBus", "id", id));
    }

    @Transactional(readOnly = true)
    public List<PlanMantenimientoBus> findByBus(Integer idBus) {
        return planMantenimientoBusRepository.findByBus_IdBus(idBus);
    }

    @Transactional
    public PlanMantenimientoBus update(Integer id, UpdatePlanMantenimientoBusDto dto) {
        PlanMantenimientoBus plan = planMantenimientoBusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanMantenimientoBus", "id", id));

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            plan.setBus(bus);
        }

        if (dto.getIdMantencion() != null) {
            Mantencion mantencion = mantencionService.findById(dto.getIdMantencion());
            plan.setMantencion(mantencion);
        }

        if (dto.getIdItem() != null) {
            plan.setIdItem(dto.getIdItem());
        }

        if (dto.getPeriodo() != null) {
            plan.setPeriodo(dto.getPeriodo());
        }

        if (dto.getKmMantencion() != null) {
            plan.setKmMantencion(dto.getKmMantencion());
        }

        if (dto.getFechaHoraMantencion() != null) {
            plan.setFechaHoraMantencion(dto.getFechaHoraMantencion());
        }

        if (dto.getKmRealizada() != null) {
            plan.setKmRealizada(dto.getKmRealizada());
        }

        if (dto.getRealizada() != null) {
            plan.setRealizada(dto.getRealizada());
        }

        if (dto.getIdOtp() != null) {
            plan.setIdOtp(dto.getIdOtp());
        }

        if (dto.getLitros() != null) {
            plan.setLitros(dto.getLitros());
        }

        if (dto.getAccionOk() != null) {
            plan.setAccionOk(dto.getAccionOk());
        }

        if (dto.getRrhh() != null) {
            plan.setRrhh(dto.getRrhh());
        }

        if (dto.getDiasFaltantes() != null) {
            plan.setDiasFaltantes(dto.getDiasFaltantes());
        }

        if (dto.getDiasExtras() != null) {
            plan.setDiasExtras(dto.getDiasExtras());
        }

        if (dto.getFechaProxMtto() != null) {
            plan.setFechaProxMtto(dto.getFechaProxMtto());
        }

        if (dto.getNuevaFechaMtto() != null) {
            plan.setNuevaFechaMtto(dto.getNuevaFechaMtto());
        }

        if (dto.getFechaFinMtto() != null) {
            plan.setFechaFinMtto(dto.getFechaFinMtto());
        }

        return planMantenimientoBusRepository.save(plan);
    }

    @Transactional
    public DeletePlanMantenimientoBusResponseDto delete(Integer id) {
        PlanMantenimientoBus plan = planMantenimientoBusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanMantenimientoBus", "id", id));

        planMantenimientoBusRepository.delete(plan);
        return new DeletePlanMantenimientoBusResponseDto(
                plan.getId(),
                "Plan de mantenimiento de bus eliminado exitosamente"
        );
    }
}
