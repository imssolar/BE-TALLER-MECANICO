package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateDetalleIPSDto;
import com.tallermecanico.dto.request.UpdateDetalleIPSDto;
import com.tallermecanico.dto.response.DeleteDetalleIPSResponseDto;
import com.tallermecanico.entity.DetalleIPS;
import com.tallermecanico.entity.OrdenTrabajoMovil;
import com.tallermecanico.entity.OrdenTrabajoProg;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.DetalleIPSRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleIPSService {

    private final DetalleIPSRepository detalleIPSRepository;
    private final OrdenTrabajoProgService ordenTrabajoProgService;
    private final OrdenTrabajoMovilService ordenTrabajoMovilService;

    public DetalleIPSService(DetalleIPSRepository detalleIPSRepository,
                             OrdenTrabajoProgService ordenTrabajoProgService,
                             OrdenTrabajoMovilService ordenTrabajoMovilService) {
        this.detalleIPSRepository = detalleIPSRepository;
        this.ordenTrabajoProgService = ordenTrabajoProgService;
        this.ordenTrabajoMovilService = ordenTrabajoMovilService;
    }

    @Transactional
    public DetalleIPS create(CreateDetalleIPSDto dto) {
        DetalleIPS detalleIPS = new DetalleIPS();

        if (dto.getIdOrdenTrabajoProg() != null) {
            OrdenTrabajoProg ordenTrabajoProg = ordenTrabajoProgService.findEntityById(dto.getIdOrdenTrabajoProg());
            detalleIPS.setOrdenTrabajoProg(ordenTrabajoProg);
        }

        if (dto.getIdOrdenTrabajoMovil() != null) {
            OrdenTrabajoMovil ordenTrabajoMovil = ordenTrabajoMovilService.findEntityById(dto.getIdOrdenTrabajoMovil());
            detalleIPS.setOrdenTrabajoMovil(ordenTrabajoMovil);
        }

        detalleIPS.setIdIps(dto.getIdIps());
        detalleIPS.setLitros(dto.getLitros());

        return detalleIPSRepository.save(detalleIPS);
    }

    @Transactional(readOnly = true)
    public List<DetalleIPS> findAll() {
        return detalleIPSRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DetalleIPS findById(Integer id) {
        return detalleIPSRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleIPS", "id", id));
    }

    @Transactional(readOnly = true)
    public List<DetalleIPS> findByOrdenTrabajoProg(Integer idOrdenTrabajoProg) {
        return detalleIPSRepository.findByOrdenTrabajoProg_Id(idOrdenTrabajoProg);
    }

    @Transactional(readOnly = true)
    public List<DetalleIPS> findByOrdenTrabajoMovil(Integer idOrdenTrabajoMovil) {
        return detalleIPSRepository.findByOrdenTrabajoMovil_Id(idOrdenTrabajoMovil);
    }

    @Transactional
    public DetalleIPS update(Integer id, UpdateDetalleIPSDto dto) {
        DetalleIPS detalleIPS = detalleIPSRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleIPS", "id", id));

        if (dto.getIdOrdenTrabajoProg() != null) {
            OrdenTrabajoProg ordenTrabajoProg = ordenTrabajoProgService.findEntityById(dto.getIdOrdenTrabajoProg());
            detalleIPS.setOrdenTrabajoProg(ordenTrabajoProg);
        }
        if (dto.getIdOrdenTrabajoMovil() != null) {
            OrdenTrabajoMovil ordenTrabajoMovil = ordenTrabajoMovilService.findEntityById(dto.getIdOrdenTrabajoMovil());
            detalleIPS.setOrdenTrabajoMovil(ordenTrabajoMovil);
        }
        if (dto.getIdIps() != null) {
            detalleIPS.setIdIps(dto.getIdIps());
        }
        if (dto.getLitros() != null) {
            detalleIPS.setLitros(dto.getLitros());
        }

        return detalleIPSRepository.save(detalleIPS);
    }

    @Transactional
    public DeleteDetalleIPSResponseDto delete(Integer id) {
        DetalleIPS detalleIPS = detalleIPSRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleIPS", "id", id));

        detalleIPSRepository.delete(detalleIPS);
        return new DeleteDetalleIPSResponseDto(
                detalleIPS.getId(),
                "Detalle IPS eliminado exitosamente"
        );
    }
}
