package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateInfraestructurasPlanDto;
import com.tallermecanico.dto.request.UpdateInfraestructurasPlanDto;
import com.tallermecanico.dto.response.DeleteInfraestructurasPlanResponseDto;
import com.tallermecanico.entity.InfraHerraPatron;
import com.tallermecanico.entity.InfraestructurasPlan;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.InfraestructurasPlanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InfraestructurasPlanService {

    private final InfraestructurasPlanRepository infraestructurasPlanRepository;
    private final InfraHerraPatronService infraHerraPatronService;

    public InfraestructurasPlanService(InfraestructurasPlanRepository infraestructurasPlanRepository,
                                       InfraHerraPatronService infraHerraPatronService) {
        this.infraestructurasPlanRepository = infraestructurasPlanRepository;
        this.infraHerraPatronService = infraHerraPatronService;
    }

    @Transactional
    public InfraestructurasPlan create(CreateInfraestructurasPlanDto dto) {
        InfraestructurasPlan infraestructurasPlan = new InfraestructurasPlan();

        if (dto.getIdInfra() != null) {
            InfraHerraPatron infraHerraPatron = infraHerraPatronService.findById(dto.getIdInfra());
            infraestructurasPlan.setInfraHerraPatron(infraHerraPatron);
        }

        infraestructurasPlan.setTipo(dto.getTipo());
        infraestructurasPlan.setFechaRevision(dto.getFechaRevision());
        infraestructurasPlan.setEstado(dto.getEstado());
        infraestructurasPlan.setObservaciones(dto.getObservaciones());
        infraestructurasPlan.setTecResponsable(dto.getTecResponsable());

        return infraestructurasPlanRepository.save(infraestructurasPlan);
    }

    @Transactional(readOnly = true)
    public List<InfraestructurasPlan> findAll() {
        return infraestructurasPlanRepository.findAll();
    }

    @Transactional(readOnly = true)
    public InfraestructurasPlan findById(Integer id) {
        return infraestructurasPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InfraestructurasPlan", "id", id));
    }

    @Transactional(readOnly = true)
    public List<InfraestructurasPlan> findByInfraHerraPatron(String idInfra) {
        return infraestructurasPlanRepository.findByInfraHerraPatron_IdInfra(idInfra);
    }

    @Transactional
    public InfraestructurasPlan update(Integer id, UpdateInfraestructurasPlanDto dto) {
        InfraestructurasPlan infraestructurasPlan = infraestructurasPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InfraestructurasPlan", "id", id));

        if (dto.getIdInfra() != null) {
            InfraHerraPatron infraHerraPatron = infraHerraPatronService.findById(dto.getIdInfra());
            infraestructurasPlan.setInfraHerraPatron(infraHerraPatron);
        }
        if (dto.getTipo() != null) {
            infraestructurasPlan.setTipo(dto.getTipo());
        }
        if (dto.getFechaRevision() != null) {
            infraestructurasPlan.setFechaRevision(dto.getFechaRevision());
        }
        if (dto.getEstado() != null) {
            infraestructurasPlan.setEstado(dto.getEstado());
        }
        if (dto.getObservaciones() != null) {
            infraestructurasPlan.setObservaciones(dto.getObservaciones());
        }
        if (dto.getTecResponsable() != null) {
            infraestructurasPlan.setTecResponsable(dto.getTecResponsable());
        }

        return infraestructurasPlanRepository.save(infraestructurasPlan);
    }

    @Transactional
    public DeleteInfraestructurasPlanResponseDto delete(Integer id) {
        InfraestructurasPlan infraestructurasPlan = infraestructurasPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InfraestructurasPlan", "id", id));

        infraestructurasPlanRepository.delete(infraestructurasPlan);
        return new DeleteInfraestructurasPlanResponseDto(
                infraestructurasPlan.getId(),
                "Plan de infraestructuras eliminado exitosamente"
        );
    }
}
