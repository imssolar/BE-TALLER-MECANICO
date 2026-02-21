package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOTCarroceriaDto;
import com.tallermecanico.dto.request.UpdateOTCarroceriaDto;
import com.tallermecanico.dto.response.DeleteOTCarroceriaResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.GravedadCarroceria;
import com.tallermecanico.entity.GravedadFibra;
import com.tallermecanico.entity.GravedadPintura;
import com.tallermecanico.entity.OTCarroceria;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.OTCarroceriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OTCarroceriaService {

    private final OTCarroceriaRepository otCarroceriaRepository;
    private final BusService busService;
    private final TerminalService terminalService;
    private final GravedadCarroceriaService gravedadCarroceriaService;
    private final GravedadPinturaService gravedadPinturaService;
    private final GravedadFibraService gravedadFibraService;

    public OTCarroceriaService(OTCarroceriaRepository otCarroceriaRepository,
                               BusService busService,
                               TerminalService terminalService,
                               GravedadCarroceriaService gravedadCarroceriaService,
                               GravedadPinturaService gravedadPinturaService,
                               GravedadFibraService gravedadFibraService) {
        this.otCarroceriaRepository = otCarroceriaRepository;
        this.busService = busService;
        this.terminalService = terminalService;
        this.gravedadCarroceriaService = gravedadCarroceriaService;
        this.gravedadPinturaService = gravedadPinturaService;
        this.gravedadFibraService = gravedadFibraService;
    }

    @Transactional
    public OTCarroceria create(CreateOTCarroceriaDto dto) {
        if (otCarroceriaRepository.existsById(dto.getId())) {
            throw new DuplicateResourceException("OTCarroceria", "id", dto.getId());
        }

        OTCarroceria otCarroceria = new OTCarroceria();
        otCarroceria.setId(dto.getId());
        otCarroceria.setTipoOttc(dto.getTipoOttc());
        otCarroceria.setKm(dto.getKm());
        otCarroceria.setPpu(dto.getPpu());
        otCarroceria.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        otCarroceria.setFechaHoraSalida(dto.getFechaHoraSalida());
        otCarroceria.setDetalleCarroceria(dto.getDetalleCarroceria());
        otCarroceria.setDetallePintura(dto.getDetallePintura());
        otCarroceria.setDetalleFibra(dto.getDetalleFibra());

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            otCarroceria.setTerminal(terminal);
        }

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            otCarroceria.setBus(bus);
        }

        if (dto.getIdGravedadCarroceria() != null) {
            GravedadCarroceria gravedadCarroceria = gravedadCarroceriaService.findById(dto.getIdGravedadCarroceria());
            otCarroceria.setGravedadCarroceria(gravedadCarroceria);
        }

        if (dto.getIdGravedadPintura() != null) {
            GravedadPintura gravedadPintura = gravedadPinturaService.findById(dto.getIdGravedadPintura());
            otCarroceria.setGravedadPintura(gravedadPintura);
        }

        if (dto.getIdGravedadFibra() != null) {
            GravedadFibra gravedadFibra = gravedadFibraService.findById(dto.getIdGravedadFibra());
            otCarroceria.setGravedadFibra(gravedadFibra);
        }

        return otCarroceriaRepository.save(otCarroceria);
    }

    @Transactional(readOnly = true)
    public List<OTCarroceria> findAll() {
        return otCarroceriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public OTCarroceria findById(Integer id) {
        return otCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTCarroceria", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OTCarroceria> findByBus(Integer idBus) {
        return otCarroceriaRepository.findByBus_IdBus(idBus);
    }

    @Transactional(readOnly = true)
    public List<OTCarroceria> findByTerminal(Integer idTerminal) {
        return otCarroceriaRepository.findByTerminal_IdTerminal(idTerminal);
    }

    @Transactional
    public OTCarroceria update(Integer id, UpdateOTCarroceriaDto dto) {
        OTCarroceria otCarroceria = otCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTCarroceria", "id", id));

        if (dto.getTipoOttc() != null) {
            otCarroceria.setTipoOttc(dto.getTipoOttc());
        }
        if (dto.getKm() != null) {
            otCarroceria.setKm(dto.getKm());
        }
        if (dto.getPpu() != null) {
            otCarroceria.setPpu(dto.getPpu());
        }
        if (dto.getFechaHoraIngreso() != null) {
            otCarroceria.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        }
        if (dto.getFechaHoraSalida() != null) {
            otCarroceria.setFechaHoraSalida(dto.getFechaHoraSalida());
        }
        if (dto.getDetalleCarroceria() != null) {
            otCarroceria.setDetalleCarroceria(dto.getDetalleCarroceria());
        }
        if (dto.getDetallePintura() != null) {
            otCarroceria.setDetallePintura(dto.getDetallePintura());
        }
        if (dto.getDetalleFibra() != null) {
            otCarroceria.setDetalleFibra(dto.getDetalleFibra());
        }

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            otCarroceria.setTerminal(terminal);
        }
        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            otCarroceria.setBus(bus);
        }
        if (dto.getIdGravedadCarroceria() != null) {
            GravedadCarroceria gravedadCarroceria = gravedadCarroceriaService.findById(dto.getIdGravedadCarroceria());
            otCarroceria.setGravedadCarroceria(gravedadCarroceria);
        }
        if (dto.getIdGravedadPintura() != null) {
            GravedadPintura gravedadPintura = gravedadPinturaService.findById(dto.getIdGravedadPintura());
            otCarroceria.setGravedadPintura(gravedadPintura);
        }
        if (dto.getIdGravedadFibra() != null) {
            GravedadFibra gravedadFibra = gravedadFibraService.findById(dto.getIdGravedadFibra());
            otCarroceria.setGravedadFibra(gravedadFibra);
        }

        return otCarroceriaRepository.save(otCarroceria);
    }

    @Transactional
    public DeleteOTCarroceriaResponseDto delete(Integer id) {
        OTCarroceria otCarroceria = otCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTCarroceria", "id", id));

        otCarroceriaRepository.delete(otCarroceria);
        return new DeleteOTCarroceriaResponseDto(
                otCarroceria.getId(),
                "OT de carroceria eliminada exitosamente"
        );
    }
}
