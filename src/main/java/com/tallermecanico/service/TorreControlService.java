package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateTorreControlDto;
import com.tallermecanico.dto.request.UpdateTorreControlDto;
import com.tallermecanico.dto.response.DeleteTorreControlResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.TorreControl;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.TorreControlRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TorreControlService {

    private final TorreControlRepository torreControlRepository;
    private final BusService busService;

    public TorreControlService(TorreControlRepository torreControlRepository,
                               BusService busService) {
        this.torreControlRepository = torreControlRepository;
        this.busService = busService;
    }

    @Transactional
    public TorreControl create(CreateTorreControlDto dto) {
        TorreControl torreControl = new TorreControl();

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            torreControl.setBus(bus);
        }

        torreControl.setKm(dto.getKm());
        torreControl.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        torreControl.setFalla(dto.getFalla());
        torreControl.setTipoFalla(dto.getTipoFalla());
        torreControl.setNroOtManager(dto.getNroOtManager());
        torreControl.setElectrico(dto.getElectrico());
        torreControl.setFechaHoraInicioElectrico(dto.getFechaHoraInicioElectrico());
        torreControl.setFechaHoraFinElectrico(dto.getFechaHoraFinElectrico());
        torreControl.setMecanico(dto.getMecanico());
        torreControl.setFechaHoraInicioMecanico(dto.getFechaHoraInicioMecanico());
        torreControl.setFechaHoraFinMecanico(dto.getFechaHoraFinMecanico());
        torreControl.setStatus(dto.getStatus());
        torreControl.setTiempoProyectado(dto.getTiempoProyectado());
        torreControl.setTiempoTranscurrido(dto.getTiempoTranscurrido());
        torreControl.setPnc(dto.getPnc());
        torreControl.setNroIngresos(dto.getNroIngresos());
        torreControl.setObservaciones(dto.getObservaciones());
        torreControl.setCerrado(dto.getCerrado());
        torreControl.setTipoEmergencia(dto.getTipoEmergencia());

        return torreControlRepository.save(torreControl);
    }

    @Transactional(readOnly = true)
    public List<TorreControl> findAll() {
        return torreControlRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TorreControl findById(Integer id) {
        return torreControlRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TorreControl", "id", id));
    }

    @Transactional(readOnly = true)
    public List<TorreControl> findByBus(Integer idBus) {
        return torreControlRepository.findByBus_IdBus(idBus);
    }

    @Transactional(readOnly = true)
    public List<TorreControl> findAbiertos() {
        return torreControlRepository.findByCerrado(false);
    }

    @Transactional(readOnly = true)
    public List<TorreControl> findCerrados() {
        return torreControlRepository.findByCerrado(true);
    }

    @Transactional
    public TorreControl update(Integer id, UpdateTorreControlDto dto) {
        TorreControl torreControl = torreControlRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TorreControl", "id", id));

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            torreControl.setBus(bus);
        }
        if (dto.getKm() != null) {
            torreControl.setKm(dto.getKm());
        }
        if (dto.getFechaHoraIngreso() != null) {
            torreControl.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        }
        if (dto.getFalla() != null) {
            torreControl.setFalla(dto.getFalla());
        }
        if (dto.getTipoFalla() != null) {
            torreControl.setTipoFalla(dto.getTipoFalla());
        }
        if (dto.getNroOtManager() != null) {
            torreControl.setNroOtManager(dto.getNroOtManager());
        }
        if (dto.getElectrico() != null) {
            torreControl.setElectrico(dto.getElectrico());
        }
        if (dto.getFechaHoraInicioElectrico() != null) {
            torreControl.setFechaHoraInicioElectrico(dto.getFechaHoraInicioElectrico());
        }
        if (dto.getFechaHoraFinElectrico() != null) {
            torreControl.setFechaHoraFinElectrico(dto.getFechaHoraFinElectrico());
        }
        if (dto.getMecanico() != null) {
            torreControl.setMecanico(dto.getMecanico());
        }
        if (dto.getFechaHoraInicioMecanico() != null) {
            torreControl.setFechaHoraInicioMecanico(dto.getFechaHoraInicioMecanico());
        }
        if (dto.getFechaHoraFinMecanico() != null) {
            torreControl.setFechaHoraFinMecanico(dto.getFechaHoraFinMecanico());
        }
        if (dto.getStatus() != null) {
            torreControl.setStatus(dto.getStatus());
        }
        if (dto.getTiempoProyectado() != null) {
            torreControl.setTiempoProyectado(dto.getTiempoProyectado());
        }
        if (dto.getTiempoTranscurrido() != null) {
            torreControl.setTiempoTranscurrido(dto.getTiempoTranscurrido());
        }
        if (dto.getPnc() != null) {
            torreControl.setPnc(dto.getPnc());
        }
        if (dto.getNroIngresos() != null) {
            torreControl.setNroIngresos(dto.getNroIngresos());
        }
        if (dto.getObservaciones() != null) {
            torreControl.setObservaciones(dto.getObservaciones());
        }
        if (dto.getCerrado() != null) {
            torreControl.setCerrado(dto.getCerrado());
        }
        if (dto.getTipoEmergencia() != null) {
            torreControl.setTipoEmergencia(dto.getTipoEmergencia());
        }

        return torreControlRepository.save(torreControl);
    }

    @Transactional
    public DeleteTorreControlResponseDto delete(Integer id) {
        TorreControl torreControl = torreControlRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TorreControl", "id", id));

        torreControlRepository.delete(torreControl);
        return new DeleteTorreControlResponseDto(
                torreControl.getId(),
                "Torre de control eliminada exitosamente"
        );
    }
}
