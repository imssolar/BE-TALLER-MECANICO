package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOTTecnicoDto;
import com.tallermecanico.dto.request.UpdateOTTecnicoDto;
import com.tallermecanico.dto.response.DeleteOTTecnicoResponseDto;
import com.tallermecanico.dto.response.OTTecnicoResponseDto;
import com.tallermecanico.entity.Empleado;
import com.tallermecanico.entity.OTTecnico;
import com.tallermecanico.entity.OrdenTrabajo;
import com.tallermecanico.entity.OrdenTrabajoProg;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.OTTecnicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OTTecnicoService {

    private final OTTecnicoRepository otTecnicoRepository;
    private final OrdenTrabajoService ordenTrabajoService;
    private final OrdenTrabajoProgService ordenTrabajoProgService;
    private final EmpleadoService empleadoService;

    public OTTecnicoService(OTTecnicoRepository otTecnicoRepository,
                            OrdenTrabajoService ordenTrabajoService,
                            OrdenTrabajoProgService ordenTrabajoProgService,
                            EmpleadoService empleadoService) {
        this.otTecnicoRepository = otTecnicoRepository;
        this.ordenTrabajoService = ordenTrabajoService;
        this.ordenTrabajoProgService = ordenTrabajoProgService;
        this.empleadoService = empleadoService;
    }

    @Transactional
    public OTTecnicoResponseDto create(CreateOTTecnicoDto dto) {
        OTTecnico tecnico = new OTTecnico();

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findEntityById(dto.getIdOrdenTrabajo());
            tecnico.setOrdenTrabajo(ordenTrabajo);
        }
        if (dto.getIdOrdenTrabajoProg() != null) {
            OrdenTrabajoProg ordenTrabajoProg = ordenTrabajoProgService.findEntityById(dto.getIdOrdenTrabajoProg());
            tecnico.setOrdenTrabajoProg(ordenTrabajoProg);
        }
        if (dto.getIdEmpleado() != null) {
            Empleado empleado = empleadoService.findEntityById(dto.getIdEmpleado());
            tecnico.setEmpleado(empleado);
        }

        tecnico.setTipo(dto.getTipo());
        tecnico.setCargo(dto.getCargo());
        tecnico.setHoraInicio(dto.getHoraInicio());
        tecnico.setHoraTermino(dto.getHoraTermino());

        return toDto(otTecnicoRepository.save(tecnico));
    }

    @Transactional(readOnly = true)
    public List<OTTecnicoResponseDto> findAll() {
        return otTecnicoRepository.findAllWithRelations().stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public OTTecnicoResponseDto findById(Integer id) {
        return toDto(otTecnicoRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTecnico", "id", id)));
    }

    @Transactional(readOnly = true)
    public List<OTTecnicoResponseDto> findByOrdenTrabajo(Integer idOrdenTrabajo) {
        return otTecnicoRepository.findByOrdenTrabajoWithRelations(idOrdenTrabajo).stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<OTTecnicoResponseDto> findByOrdenTrabajoProg(Integer idOrdenTrabajoProg) {
        return otTecnicoRepository.findByOrdenTrabajoProgWithRelations(idOrdenTrabajoProg).stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional
    public OTTecnicoResponseDto update(Integer id, UpdateOTTecnicoDto dto) {
        OTTecnico tecnico = otTecnicoRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTecnico", "id", id));

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findEntityById(dto.getIdOrdenTrabajo());
            tecnico.setOrdenTrabajo(ordenTrabajo);
        }
        if (dto.getIdOrdenTrabajoProg() != null) {
            OrdenTrabajoProg ordenTrabajoProg = ordenTrabajoProgService.findEntityById(dto.getIdOrdenTrabajoProg());
            tecnico.setOrdenTrabajoProg(ordenTrabajoProg);
        }
        if (dto.getIdEmpleado() != null) {
            Empleado empleado = empleadoService.findEntityById(dto.getIdEmpleado());
            tecnico.setEmpleado(empleado);
        }
        if (dto.getTipo() != null) {
            tecnico.setTipo(dto.getTipo());
        }
        if (dto.getCargo() != null) {
            tecnico.setCargo(dto.getCargo());
        }
        if (dto.getHoraInicio() != null) {
            tecnico.setHoraInicio(dto.getHoraInicio());
        }
        if (dto.getHoraTermino() != null) {
            tecnico.setHoraTermino(dto.getHoraTermino());
        }

        return toDto(otTecnicoRepository.save(tecnico));
    }

    @Transactional
    public DeleteOTTecnicoResponseDto delete(Integer id) {
        OTTecnico tecnico = otTecnicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTecnico", "id", id));

        otTecnicoRepository.delete(tecnico);
        return new DeleteOTTecnicoResponseDto(
                tecnico.getId(),
                "Técnico de OT eliminado exitosamente"
        );
    }

    private OTTecnicoResponseDto toDto(OTTecnico t) {
        OTTecnicoResponseDto dto = new OTTecnicoResponseDto();
        dto.setId(t.getId());
        dto.setTipo(t.getTipo());
        dto.setCargo(t.getCargo());
        dto.setHoraInicio(t.getHoraInicio());
        dto.setHoraTermino(t.getHoraTermino());

        if (t.getOrdenTrabajo() != null) {
            dto.setIdOrdenTrabajo(t.getOrdenTrabajo().getId());
        }
        if (t.getOrdenTrabajoProg() != null) {
            dto.setIdOrdenTrabajoProg(t.getOrdenTrabajoProg().getId());
        }
        if (t.getEmpleado() != null) {
            dto.setIdEmpleado(t.getEmpleado().getId());
            dto.setNombreEmpleado(t.getEmpleado().getNombreCompleto());
        }

        return dto;
    }
}
