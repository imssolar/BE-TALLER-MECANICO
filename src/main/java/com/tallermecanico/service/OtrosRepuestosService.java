package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOtrosRepuestosDto;
import com.tallermecanico.dto.request.UpdateOtrosRepuestosDto;
import com.tallermecanico.dto.response.DeleteOtrosRepuestosResponseDto;
import com.tallermecanico.entity.Glosa;
import com.tallermecanico.entity.OrdenTrabajo;
import com.tallermecanico.entity.OtrosRepuestos;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.OtrosRepuestosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OtrosRepuestosService {

    private final OtrosRepuestosRepository otrosRepuestosRepository;
    private final OrdenTrabajoService ordenTrabajoService;
    private final GlosaService glosaService;

    public OtrosRepuestosService(OtrosRepuestosRepository otrosRepuestosRepository,
                                 OrdenTrabajoService ordenTrabajoService,
                                 GlosaService glosaService) {
        this.otrosRepuestosRepository = otrosRepuestosRepository;
        this.ordenTrabajoService = ordenTrabajoService;
        this.glosaService = glosaService;
    }

    @Transactional
    public OtrosRepuestos create(CreateOtrosRepuestosDto dto) {
        OtrosRepuestos otrosRepuestos = new OtrosRepuestos();

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findById(dto.getIdOrdenTrabajo());
            otrosRepuestos.setOrdenTrabajo(ordenTrabajo);
        }

        if (dto.getIdGlosa() != null) {
            Glosa glosa = glosaService.findById(dto.getIdGlosa());
            otrosRepuestos.setGlosa(glosa);
        }

        otrosRepuestos.setFecha(dto.getFecha());
        otrosRepuestos.setIdRepuesto(dto.getIdRepuesto());
        otrosRepuestos.setRepuesto(dto.getRepuesto());
        otrosRepuestos.setCantidad(dto.getCantidad());
        otrosRepuestos.setCosto(dto.getCosto());

        return otrosRepuestosRepository.save(otrosRepuestos);
    }

    @Transactional(readOnly = true)
    public List<OtrosRepuestos> findAll() {
        return otrosRepuestosRepository.findAll();
    }

    @Transactional(readOnly = true)
    public OtrosRepuestos findById(Integer id) {
        return otrosRepuestosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OtrosRepuestos", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OtrosRepuestos> findByOrdenTrabajo(Integer idOrdenTrabajo) {
        return otrosRepuestosRepository.findByOrdenTrabajo_Id(idOrdenTrabajo);
    }

    @Transactional
    public OtrosRepuestos update(Integer id, UpdateOtrosRepuestosDto dto) {
        OtrosRepuestos otrosRepuestos = otrosRepuestosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OtrosRepuestos", "id", id));

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findById(dto.getIdOrdenTrabajo());
            otrosRepuestos.setOrdenTrabajo(ordenTrabajo);
        }
        if (dto.getIdGlosa() != null) {
            Glosa glosa = glosaService.findById(dto.getIdGlosa());
            otrosRepuestos.setGlosa(glosa);
        }
        if (dto.getFecha() != null) {
            otrosRepuestos.setFecha(dto.getFecha());
        }
        if (dto.getIdRepuesto() != null) {
            otrosRepuestos.setIdRepuesto(dto.getIdRepuesto());
        }
        if (dto.getRepuesto() != null) {
            otrosRepuestos.setRepuesto(dto.getRepuesto());
        }
        if (dto.getCantidad() != null) {
            otrosRepuestos.setCantidad(dto.getCantidad());
        }
        if (dto.getCosto() != null) {
            otrosRepuestos.setCosto(dto.getCosto());
        }

        return otrosRepuestosRepository.save(otrosRepuestos);
    }

    @Transactional
    public DeleteOtrosRepuestosResponseDto delete(Integer id) {
        OtrosRepuestos otrosRepuestos = otrosRepuestosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OtrosRepuestos", "id", id));

        otrosRepuestosRepository.delete(otrosRepuestos);
        return new DeleteOtrosRepuestosResponseDto(
                otrosRepuestos.getId(),
                "Otros repuestos eliminado exitosamente"
        );
    }
}
