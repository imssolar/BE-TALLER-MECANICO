package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateHerramientasPlanDto;
import com.tallermecanico.dto.request.UpdateHerramientasPlanDto;
import com.tallermecanico.dto.response.DeleteHerramientasPlanResponseDto;
import com.tallermecanico.entity.HerramientasPlan;
import com.tallermecanico.entity.InfraHerraPatron;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.HerramientasPlanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HerramientasPlanService {

    private final HerramientasPlanRepository herramientasPlanRepository;
    private final InfraHerraPatronService infraHerraPatronService;

    public HerramientasPlanService(HerramientasPlanRepository herramientasPlanRepository,
                                   InfraHerraPatronService infraHerraPatronService) {
        this.herramientasPlanRepository = herramientasPlanRepository;
        this.infraHerraPatronService = infraHerraPatronService;
    }

    @Transactional
    public HerramientasPlan create(CreateHerramientasPlanDto dto) {
        HerramientasPlan herramientasPlan = new HerramientasPlan();

        if (dto.getIdHerramienta() != null) {
            InfraHerraPatron infraHerraPatron = infraHerraPatronService.findById(dto.getIdHerramienta());
            herramientasPlan.setInfraHerraPatron(infraHerraPatron);
        }

        herramientasPlan.setPatron(dto.getPatron());
        herramientasPlan.setFechaRevision(dto.getFechaRevision());
        herramientasPlan.setEstadoMantencion(dto.getEstadoMantencion());
        herramientasPlan.setPatron1(dto.getPatron1());
        herramientasPlan.setHerramienta1(dto.getHerramienta1());
        herramientasPlan.setPatron2(dto.getPatron2());
        herramientasPlan.setHerramienta2(dto.getHerramienta2());
        herramientasPlan.setPatron3(dto.getPatron3());
        herramientasPlan.setHerramienta3(dto.getHerramienta3());
        herramientasPlan.setObservaciones(dto.getObservaciones());
        herramientasPlan.setTecResponsable(dto.getTecResponsable());
        herramientasPlan.setEstadoHerramienta(dto.getEstadoHerramienta());

        return herramientasPlanRepository.save(herramientasPlan);
    }

    @Transactional(readOnly = true)
    public List<HerramientasPlan> findAll() {
        return herramientasPlanRepository.findAll();
    }

    @Transactional(readOnly = true)
    public HerramientasPlan findById(Integer id) {
        return herramientasPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HerramientasPlan", "id", id));
    }

    @Transactional(readOnly = true)
    public List<HerramientasPlan> findByInfraHerraPatron(String idInfra) {
        return herramientasPlanRepository.findByInfraHerraPatron_IdInfra(idInfra);
    }

    @Transactional
    public HerramientasPlan update(Integer id, UpdateHerramientasPlanDto dto) {
        HerramientasPlan herramientasPlan = herramientasPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HerramientasPlan", "id", id));

        if (dto.getIdHerramienta() != null) {
            InfraHerraPatron infraHerraPatron = infraHerraPatronService.findById(dto.getIdHerramienta());
            herramientasPlan.setInfraHerraPatron(infraHerraPatron);
        }
        if (dto.getPatron() != null) {
            herramientasPlan.setPatron(dto.getPatron());
        }
        if (dto.getFechaRevision() != null) {
            herramientasPlan.setFechaRevision(dto.getFechaRevision());
        }
        if (dto.getEstadoMantencion() != null) {
            herramientasPlan.setEstadoMantencion(dto.getEstadoMantencion());
        }
        if (dto.getPatron1() != null) {
            herramientasPlan.setPatron1(dto.getPatron1());
        }
        if (dto.getHerramienta1() != null) {
            herramientasPlan.setHerramienta1(dto.getHerramienta1());
        }
        if (dto.getPatron2() != null) {
            herramientasPlan.setPatron2(dto.getPatron2());
        }
        if (dto.getHerramienta2() != null) {
            herramientasPlan.setHerramienta2(dto.getHerramienta2());
        }
        if (dto.getPatron3() != null) {
            herramientasPlan.setPatron3(dto.getPatron3());
        }
        if (dto.getHerramienta3() != null) {
            herramientasPlan.setHerramienta3(dto.getHerramienta3());
        }
        if (dto.getObservaciones() != null) {
            herramientasPlan.setObservaciones(dto.getObservaciones());
        }
        if (dto.getTecResponsable() != null) {
            herramientasPlan.setTecResponsable(dto.getTecResponsable());
        }
        if (dto.getEstadoHerramienta() != null) {
            herramientasPlan.setEstadoHerramienta(dto.getEstadoHerramienta());
        }

        return herramientasPlanRepository.save(herramientasPlan);
    }

    @Transactional
    public DeleteHerramientasPlanResponseDto delete(Integer id) {
        HerramientasPlan herramientasPlan = herramientasPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HerramientasPlan", "id", id));

        herramientasPlanRepository.delete(herramientasPlan);
        return new DeleteHerramientasPlanResponseDto(
                herramientasPlan.getId(),
                "Plan de herramientas eliminado exitosamente"
        );
    }
}
