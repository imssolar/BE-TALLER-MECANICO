package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateRepuestoOTDto;
import com.tallermecanico.dto.request.UpdateRepuestoOTDto;
import com.tallermecanico.dto.response.DeleteRepuestoOTResponseDto;
import com.tallermecanico.entity.Glosa;
import com.tallermecanico.entity.OrdenTrabajo;
import com.tallermecanico.entity.OrdenTrabajoProg;
import com.tallermecanico.entity.OrdenTrabajoMovil;
import com.tallermecanico.entity.RepuestoOT;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.RepuestoOTRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepuestoOTService {

    private final RepuestoOTRepository repuestoOTRepository;
    private final OrdenTrabajoService ordenTrabajoService;
    private final OrdenTrabajoProgService ordenTrabajoProgService;
    private final OrdenTrabajoMovilService ordenTrabajoMovilService;
    private final GlosaService glosaService;

    public RepuestoOTService(RepuestoOTRepository repuestoOTRepository,
                             OrdenTrabajoService ordenTrabajoService,
                             OrdenTrabajoProgService ordenTrabajoProgService,
                             OrdenTrabajoMovilService ordenTrabajoMovilService,
                             GlosaService glosaService) {
        this.repuestoOTRepository = repuestoOTRepository;
        this.ordenTrabajoService = ordenTrabajoService;
        this.ordenTrabajoProgService = ordenTrabajoProgService;
        this.ordenTrabajoMovilService = ordenTrabajoMovilService;
        this.glosaService = glosaService;
    }

    @Transactional
    public RepuestoOT create(CreateRepuestoOTDto dto) {
        RepuestoOT repuestoOT = new RepuestoOT();

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findEntityById(dto.getIdOrdenTrabajo());
            repuestoOT.setOrdenTrabajo(ordenTrabajo);
        }

        if (dto.getIdOrdenTrabajoProg() != null) {
            OrdenTrabajoProg ordenTrabajoProg = ordenTrabajoProgService.findEntityById(dto.getIdOrdenTrabajoProg());
            repuestoOT.setOrdenTrabajoProg(ordenTrabajoProg);
        }

        if (dto.getIdOrdenTrabajoMovil() != null) {
            OrdenTrabajoMovil ordenTrabajoMovil = ordenTrabajoMovilService.findEntityById(dto.getIdOrdenTrabajoMovil());
            repuestoOT.setOrdenTrabajoMovil(ordenTrabajoMovil);
        }

        if (dto.getIdGlosa() != null) {
            Glosa glosa = glosaService.findById(dto.getIdGlosa());
            repuestoOT.setGlosa(glosa);
        }

        repuestoOT.setIdRepuesto(dto.getIdRepuesto());
        repuestoOT.setRepuesto(dto.getRepuesto());
        repuestoOT.setCantidad(dto.getCantidad());
        repuestoOT.setCosto(dto.getCosto());

        return repuestoOTRepository.save(repuestoOT);
    }

    @Transactional(readOnly = true)
    public List<RepuestoOT> findAll() {
        return repuestoOTRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RepuestoOT findById(Integer id) {
        return repuestoOTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RepuestoOT", "id", id));
    }

    @Transactional(readOnly = true)
    public List<RepuestoOT> findByOrdenTrabajo(Integer idOrdenTrabajo) {
        return repuestoOTRepository.findByOrdenTrabajo_Id(idOrdenTrabajo);
    }

    @Transactional(readOnly = true)
    public List<RepuestoOT> findByOrdenTrabajoProg(Integer idOrdenTrabajoProg) {
        return repuestoOTRepository.findByOrdenTrabajoProg_Id(idOrdenTrabajoProg);
    }

    @Transactional(readOnly = true)
    public List<RepuestoOT> findByOrdenTrabajoMovil(Integer idOrdenTrabajoMovil) {
        return repuestoOTRepository.findByOrdenTrabajoMovil_Id(idOrdenTrabajoMovil);
    }

    @Transactional
    public RepuestoOT update(Integer id, UpdateRepuestoOTDto dto) {
        RepuestoOT repuestoOT = repuestoOTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RepuestoOT", "id", id));

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findEntityById(dto.getIdOrdenTrabajo());
            repuestoOT.setOrdenTrabajo(ordenTrabajo);
        }
        if (dto.getIdOrdenTrabajoProg() != null) {
            OrdenTrabajoProg ordenTrabajoProg = ordenTrabajoProgService.findEntityById(dto.getIdOrdenTrabajoProg());
            repuestoOT.setOrdenTrabajoProg(ordenTrabajoProg);
        }
        if (dto.getIdOrdenTrabajoMovil() != null) {
            OrdenTrabajoMovil ordenTrabajoMovil = ordenTrabajoMovilService.findEntityById(dto.getIdOrdenTrabajoMovil());
            repuestoOT.setOrdenTrabajoMovil(ordenTrabajoMovil);
        }
        if (dto.getIdGlosa() != null) {
            Glosa glosa = glosaService.findById(dto.getIdGlosa());
            repuestoOT.setGlosa(glosa);
        }
        if (dto.getIdRepuesto() != null) {
            repuestoOT.setIdRepuesto(dto.getIdRepuesto());
        }
        if (dto.getRepuesto() != null) {
            repuestoOT.setRepuesto(dto.getRepuesto());
        }
        if (dto.getCantidad() != null) {
            repuestoOT.setCantidad(dto.getCantidad());
        }
        if (dto.getCosto() != null) {
            repuestoOT.setCosto(dto.getCosto());
        }

        return repuestoOTRepository.save(repuestoOT);
    }

    @Transactional
    public DeleteRepuestoOTResponseDto delete(Integer id) {
        RepuestoOT repuestoOT = repuestoOTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RepuestoOT", "id", id));

        repuestoOTRepository.delete(repuestoOT);
        return new DeleteRepuestoOTResponseDto(
                repuestoOT.getId(),
                "Repuesto OT eliminado exitosamente"
        );
    }
}
