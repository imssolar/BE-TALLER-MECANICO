package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOTTecnicoDto;
import com.tallermecanico.dto.request.UpdateOTTecnicoDto;
import com.tallermecanico.dto.response.DeleteOTTecnicoResponseDto;
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

    public OTTecnicoService(OTTecnicoRepository otTecnicoRepository,
                            OrdenTrabajoService ordenTrabajoService,
                            OrdenTrabajoProgService ordenTrabajoProgService) {
        this.otTecnicoRepository = otTecnicoRepository;
        this.ordenTrabajoService = ordenTrabajoService;
        this.ordenTrabajoProgService = ordenTrabajoProgService;
    }

    @Transactional
    public OTTecnico create(CreateOTTecnicoDto dto) {
        OTTecnico tecnico = new OTTecnico();

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findById(dto.getIdOrdenTrabajo());
            tecnico.setOrdenTrabajo(ordenTrabajo);
        }

        if (dto.getIdOrdenTrabajoProg() != null) {
            OrdenTrabajoProg ordenTrabajoProg = ordenTrabajoProgService.findById(dto.getIdOrdenTrabajoProg());
            tecnico.setOrdenTrabajoProg(ordenTrabajoProg);
        }

        tecnico.setNombre(dto.getNombre());
        tecnico.setTipo(dto.getTipo());
        tecnico.setCargo(dto.getCargo());
        tecnico.setHoraInicio(dto.getHoraInicio());
        tecnico.setHoraTermino(dto.getHoraTermino());

        return otTecnicoRepository.save(tecnico);
    }

    @Transactional(readOnly = true)
    public List<OTTecnico> findAll() {
        return otTecnicoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public OTTecnico findById(Integer id) {
        return otTecnicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTecnico", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OTTecnico> findByOrdenTrabajo(Integer idOrdenTrabajo) {
        return otTecnicoRepository.findByOrdenTrabajo_Id(idOrdenTrabajo);
    }

    @Transactional(readOnly = true)
    public List<OTTecnico> findByOrdenTrabajoProg(Integer idOrdenTrabajoProg) {
        return otTecnicoRepository.findByOrdenTrabajoProg_Id(idOrdenTrabajoProg);
    }

    @Transactional
    public OTTecnico update(Integer id, UpdateOTTecnicoDto dto) {
        OTTecnico tecnico = otTecnicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTecnico", "id", id));

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findById(dto.getIdOrdenTrabajo());
            tecnico.setOrdenTrabajo(ordenTrabajo);
        }
        if (dto.getIdOrdenTrabajoProg() != null) {
            OrdenTrabajoProg ordenTrabajoProg = ordenTrabajoProgService.findById(dto.getIdOrdenTrabajoProg());
            tecnico.setOrdenTrabajoProg(ordenTrabajoProg);
        }
        if (dto.getNombre() != null) {
            tecnico.setNombre(dto.getNombre());
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

        return otTecnicoRepository.save(tecnico);
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
}
