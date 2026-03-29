package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOTTallerExtDto;
import com.tallermecanico.dto.request.UpdateOTTallerExtDto;
import com.tallermecanico.dto.response.DeleteOTTallerExtResponseDto;
import com.tallermecanico.dto.response.OTTallerExtResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.Empleado;
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
    private final EmpleadoService empleadoService;

    public OTTallerExtService(OTTallerExtRepository otTallerExtRepository,
                              BusService busService,
                              EmpleadoService empleadoService) {
        this.otTallerExtRepository = otTallerExtRepository;
        this.busService = busService;
        this.empleadoService = empleadoService;
    }

    @Transactional
    public OTTallerExtResponseDto create(CreateOTTallerExtDto dto) {
        if (otTallerExtRepository.existsById(dto.getId())) {
            throw new DuplicateResourceException("OTTallerExt", "id", dto.getId());
        }

        OTTallerExt otTallerExt = new OTTallerExt();
        otTallerExt.setId(dto.getId());

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            otTallerExt.setBus(bus);
        }
        if (dto.getIdConductor() != null) {
            Empleado conductor = empleadoService.findEntityById(dto.getIdConductor());
            otTallerExt.setConductor(conductor);
        }

        otTallerExt.setKm(dto.getKm());
        otTallerExt.setPpu(dto.getPpu());
        otTallerExt.setProveedor(dto.getProveedor());
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

        return toDto(otTallerExtRepository.save(otTallerExt));
    }

    @Transactional(readOnly = true)
    public List<OTTallerExtResponseDto> findAll() {
        return otTallerExtRepository.findAllWithRelations().stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public OTTallerExtResponseDto findById(Integer id) {
        return toDto(otTallerExtRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTallerExt", "id", id)));
    }

    @Transactional(readOnly = true)
    public OTTallerExt findEntityById(Integer id) {
        return otTallerExtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTallerExt", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OTTallerExtResponseDto> findByBus(Integer idBus) {
        return otTallerExtRepository.findByBusWithRelations(idBus).stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional
    public OTTallerExtResponseDto update(Integer id, UpdateOTTallerExtDto dto) {
        OTTallerExt otTallerExt = otTallerExtRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTTallerExt", "id", id));

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            otTallerExt.setBus(bus);
        }
        if (dto.getIdConductor() != null) {
            Empleado conductor = empleadoService.findEntityById(dto.getIdConductor());
            otTallerExt.setConductor(conductor);
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

        return toDto(otTallerExtRepository.save(otTallerExt));
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

    private OTTallerExtResponseDto toDto(OTTallerExt o) {
        OTTallerExtResponseDto dto = new OTTallerExtResponseDto();
        dto.setId(o.getId());
        dto.setKm(o.getKm());
        dto.setPpu(o.getPpu());
        dto.setProveedor(o.getProveedor());
        dto.setRecorrido(o.getRecorrido());
        dto.setFecha(o.getFecha());
        dto.setRecibeTaller(o.getRecibeTaller());
        dto.setHoraLlegada(o.getHoraLlegada());
        dto.setHoraSalida(o.getHoraSalida());
        dto.setDiagnostico(o.getDiagnostico());
        dto.setNombrePreparador(o.getNombrePreparador());
        dto.setHoraPreparador(o.getHoraPreparador());
        dto.setNombreRevisor(o.getNombreRevisor());
        dto.setHoraRevisor(o.getHoraRevisor());
        dto.setNombreEjecutor(o.getNombreEjecutor());
        dto.setHoraEjecutor(o.getHoraEjecutor());
        dto.setTotal(o.getTotal());
        dto.setIncidencias(o.getIncidencias());
        dto.setSistema(o.getSistema());
        dto.setFechaSalida(o.getFechaSalida());

        if (o.getBus() != null) {
            dto.setIdBus(o.getBus().getIdBus());
            dto.setPatenteB(o.getBus().getPatenteB());
        }
        if (o.getConductor() != null) {
            dto.setIdConductor(o.getConductor().getId());
            dto.setNombreConductor(o.getConductor().getNombreCompleto());
        }

        return dto;
    }
}
