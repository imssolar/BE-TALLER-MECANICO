package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOTTallerExtDto;
import com.tallermecanico.dto.request.UpdateOTTallerExtDto;
import com.tallermecanico.dto.response.DeleteOTTallerExtResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.OTTallerExt;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.OTTallerExtRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OTTallerExtService {

    private final OTTallerExtRepository otTallerExtRepository;
    private final BusService busService;

    public OTTallerExtService(OTTallerExtRepository otTallerExtRepository,
                              BusService busService) {
        this.otTallerExtRepository = otTallerExtRepository;
        this.busService = busService;
    }

    @Transactional
    public OTTallerExt create(CreateOTTallerExtDto dto) {
        if (otTallerExtRepository.existsById(dto.getId())) {
            throw new DuplicateResourceException("OTTallerExt", "id", dto.getId());
        }

        OTTallerExt otTallerExt = new OTTallerExt();
        otTallerExt.setId(dto.getId());

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            otTallerExt.setBus(bus);
        }

        otTallerExt.setKm(dto.getKm());
        otTallerExt.setPpu(dto.getPpu());
        otTallerExt.setProveedor(dto.getProveedor());
        otTallerExt.setConductor(dto.getConductor());
        otTallerExt.setRecorrido(dto.getRecorrido());
        otTallerExt.setFecha(dto.getFecha());
        otTallerExt.setRecibeTaller(dto.getRecibeTaller());
        otTallerExt.setHoraLlegada(dto.getHoraLlegada());
        otTallerExt.setHoraSalida(dto.getHoraSalida());
        otTallerExt.setDiagnostico(dto.getDiagnostico());
        otTallerExt.setNombrePreparador(dto.getNombrePreparador());
        otTallerExt.setHoraPreparador(dto.getHoraPreparador());
        otTallerExt.setNombreRevisor(dto.getNombreRevisor());
        otTallerExt.setHoraRevisor(dto.getHoraRevisor());
        otTallerExt.setNombreEjecutor(dto.getNombreEjecutor());
        otTallerExt.setHoraEjecutor(dto.getHoraEjecutor());
        otTallerExt.setTotal(dto.getTotal());
        otTallerExt.setIncidencias(dto.getIncidencias());
        otTallerExt.setSistema(dto.getSistema());
        otTallerExt.setFechaSalida(dto.getFechaSalida());

        return otTallerExtRepository.save(otTallerExt);
    }

    @Transactional(readOnly = true)
    public List<OTTallerExt> findAll() {
        return otTallerExtRepository.findAll();
    }

    @Transactional(readOnly = true)
    public OTTallerExt findById(Integer id) {
        return otTallerExtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTallerExt", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OTTallerExt> findByBus(Integer idBus) {
        return otTallerExtRepository.findByBus_IdBus(idBus);
    }

    @Transactional
    public OTTallerExt update(Integer id, UpdateOTTallerExtDto dto) {
        OTTallerExt otTallerExt = otTallerExtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTallerExt", "id", id));

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            otTallerExt.setBus(bus);
        }
        if (dto.getKm() != null) {
            otTallerExt.setKm(dto.getKm());
        }
        if (dto.getPpu() != null) {
            otTallerExt.setPpu(dto.getPpu());
        }
        if (dto.getProveedor() != null) {
            otTallerExt.setProveedor(dto.getProveedor());
        }
        if (dto.getConductor() != null) {
            otTallerExt.setConductor(dto.getConductor());
        }
        if (dto.getRecorrido() != null) {
            otTallerExt.setRecorrido(dto.getRecorrido());
        }
        if (dto.getFecha() != null) {
            otTallerExt.setFecha(dto.getFecha());
        }
        if (dto.getRecibeTaller() != null) {
            otTallerExt.setRecibeTaller(dto.getRecibeTaller());
        }
        if (dto.getHoraLlegada() != null) {
            otTallerExt.setHoraLlegada(dto.getHoraLlegada());
        }
        if (dto.getHoraSalida() != null) {
            otTallerExt.setHoraSalida(dto.getHoraSalida());
        }
        if (dto.getDiagnostico() != null) {
            otTallerExt.setDiagnostico(dto.getDiagnostico());
        }
        if (dto.getNombrePreparador() != null) {
            otTallerExt.setNombrePreparador(dto.getNombrePreparador());
        }
        if (dto.getHoraPreparador() != null) {
            otTallerExt.setHoraPreparador(dto.getHoraPreparador());
        }
        if (dto.getNombreRevisor() != null) {
            otTallerExt.setNombreRevisor(dto.getNombreRevisor());
        }
        if (dto.getHoraRevisor() != null) {
            otTallerExt.setHoraRevisor(dto.getHoraRevisor());
        }
        if (dto.getNombreEjecutor() != null) {
            otTallerExt.setNombreEjecutor(dto.getNombreEjecutor());
        }
        if (dto.getHoraEjecutor() != null) {
            otTallerExt.setHoraEjecutor(dto.getHoraEjecutor());
        }
        if (dto.getTotal() != null) {
            otTallerExt.setTotal(dto.getTotal());
        }
        if (dto.getIncidencias() != null) {
            otTallerExt.setIncidencias(dto.getIncidencias());
        }
        if (dto.getSistema() != null) {
            otTallerExt.setSistema(dto.getSistema());
        }
        if (dto.getFechaSalida() != null) {
            otTallerExt.setFechaSalida(dto.getFechaSalida());
        }

        return otTallerExtRepository.save(otTallerExt);
    }

    @Transactional
    public DeleteOTTallerExtResponseDto delete(Integer id) {
        OTTallerExt otTallerExt = otTallerExtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTallerExt", "id", id));

        otTallerExtRepository.delete(otTallerExt);
        return new DeleteOTTallerExtResponseDto(
                otTallerExt.getId(),
                "OT de taller externo eliminada exitosamente"
        );
    }
}
