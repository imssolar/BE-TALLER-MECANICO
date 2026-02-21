package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateInfraHerraPatronDto;
import com.tallermecanico.dto.request.UpdateInfraHerraPatronDto;
import com.tallermecanico.dto.response.DeleteInfraHerraPatronResponseDto;
import com.tallermecanico.entity.InfraHerraPatron;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.InfraHerraPatronRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InfraHerraPatronService {

    private final InfraHerraPatronRepository infraHerraPatronRepository;
    private final TerminalService terminalService;

    public InfraHerraPatronService(InfraHerraPatronRepository infraHerraPatronRepository,
                                   TerminalService terminalService) {
        this.infraHerraPatronRepository = infraHerraPatronRepository;
        this.terminalService = terminalService;
    }

    @Transactional
    public InfraHerraPatron create(CreateInfraHerraPatronDto dto) {
        if (infraHerraPatronRepository.existsById(dto.getIdInfra())) {
            throw new DuplicateResourceException("InfraHerraPatron", "idInfra", dto.getIdInfra());
        }

        InfraHerraPatron infraHerraPatron = new InfraHerraPatron();
        infraHerraPatron.setIdInfra(dto.getIdInfra());
        infraHerraPatron.setModelo(dto.getModelo());
        infraHerraPatron.setSerie(dto.getSerie());
        infraHerraPatron.setMarca(dto.getMarca());
        infraHerraPatron.setDescripcion(dto.getDescripcion());
        infraHerraPatron.setAnio(dto.getAnio());
        infraHerraPatron.setResponsable(dto.getResponsable());
        infraHerraPatron.setTipo(dto.getTipo());
        infraHerraPatron.setFechaCalibracion(dto.getFechaCalibracion());
        infraHerraPatron.setFechaVigencia(dto.getFechaVigencia());
        infraHerraPatron.setPeriodo(dto.getPeriodo());

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            infraHerraPatron.setTerminal(terminal);
        }

        return infraHerraPatronRepository.save(infraHerraPatron);
    }

    @Transactional(readOnly = true)
    public List<InfraHerraPatron> findAll() {
        return infraHerraPatronRepository.findAll();
    }

    @Transactional(readOnly = true)
    public InfraHerraPatron findById(String id) {
        return infraHerraPatronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InfraHerraPatron", "idInfra", id));
    }

    @Transactional(readOnly = true)
    public List<InfraHerraPatron> findByTerminal(Integer idTerminal) {
        return infraHerraPatronRepository.findByTerminal_IdTerminal(idTerminal);
    }

    @Transactional
    public InfraHerraPatron update(String id, UpdateInfraHerraPatronDto dto) {
        InfraHerraPatron infraHerraPatron = infraHerraPatronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InfraHerraPatron", "idInfra", id));

        if (dto.getModelo() != null) {
            infraHerraPatron.setModelo(dto.getModelo());
        }
        if (dto.getSerie() != null) {
            infraHerraPatron.setSerie(dto.getSerie());
        }
        if (dto.getMarca() != null) {
            infraHerraPatron.setMarca(dto.getMarca());
        }
        if (dto.getDescripcion() != null) {
            infraHerraPatron.setDescripcion(dto.getDescripcion());
        }
        if (dto.getAnio() != null) {
            infraHerraPatron.setAnio(dto.getAnio());
        }
        if (dto.getResponsable() != null) {
            infraHerraPatron.setResponsable(dto.getResponsable());
        }
        if (dto.getTipo() != null) {
            infraHerraPatron.setTipo(dto.getTipo());
        }
        if (dto.getFechaCalibracion() != null) {
            infraHerraPatron.setFechaCalibracion(dto.getFechaCalibracion());
        }
        if (dto.getFechaVigencia() != null) {
            infraHerraPatron.setFechaVigencia(dto.getFechaVigencia());
        }
        if (dto.getPeriodo() != null) {
            infraHerraPatron.setPeriodo(dto.getPeriodo());
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            infraHerraPatron.setTerminal(terminal);
        }

        return infraHerraPatronRepository.save(infraHerraPatron);
    }

    @Transactional
    public DeleteInfraHerraPatronResponseDto delete(String id) {
        InfraHerraPatron infraHerraPatron = infraHerraPatronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InfraHerraPatron", "idInfra", id));

        infraHerraPatronRepository.delete(infraHerraPatron);
        return new DeleteInfraHerraPatronResponseDto(
                infraHerraPatron.getIdInfra(),
                infraHerraPatron.getDescripcion(),
                "Infraestructura/herramienta patrón eliminada exitosamente"
        );
    }
}
