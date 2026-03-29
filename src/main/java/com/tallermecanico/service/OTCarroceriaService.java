package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOTCarroceriaDto;
import com.tallermecanico.dto.request.UpdateOTCarroceriaDto;
import com.tallermecanico.dto.response.DeleteOTCarroceriaResponseDto;
import com.tallermecanico.dto.response.OTCarroceriaResponseDto;
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
    public OTCarroceriaResponseDto create(CreateOTCarroceriaDto dto) {
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

        return toDto(otCarroceriaRepository.save(otCarroceria));
    }

    @Transactional(readOnly = true)
    public List<OTCarroceriaResponseDto> findAll() {
        return otCarroceriaRepository.findAllWithRelations().stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public OTCarroceriaResponseDto findById(Integer id) {
        return toDto(otCarroceriaRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTCarroceria", "id", id)));
    }

    @Transactional(readOnly = true)
    public OTCarroceria findEntityById(Integer id) {
        return otCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OTCarroceria", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OTCarroceriaResponseDto> findByBus(Integer idBus) {
        return otCarroceriaRepository.findByBusWithRelations(idBus).stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<OTCarroceriaResponseDto> findByTerminal(Integer idTerminal) {
        return otCarroceriaRepository.findByTerminalWithRelations(idTerminal).stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional
    public OTCarroceriaResponseDto update(Integer id, UpdateOTCarroceriaDto dto) {
        OTCarroceria otCarroceria = otCarroceriaRepository.findByIdWithRelations(id)
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

        return toDto(otCarroceriaRepository.save(otCarroceria));
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

    private OTCarroceriaResponseDto toDto(OTCarroceria o) {
        OTCarroceriaResponseDto dto = new OTCarroceriaResponseDto();
        dto.setId(o.getId());
        dto.setTipoOttc(o.getTipoOttc());
        dto.setKm(o.getKm());
        dto.setPpu(o.getPpu());
        dto.setFechaHoraIngreso(o.getFechaHoraIngreso());
        dto.setFechaHoraSalida(o.getFechaHoraSalida());
        dto.setDetalleCarroceria(o.getDetalleCarroceria());
        dto.setDetallePintura(o.getDetallePintura());
        dto.setDetalleFibra(o.getDetalleFibra());

        if (o.getTerminal() != null) {
            dto.setIdTerminal(o.getTerminal().getIdTerminal());
            dto.setTerminal(o.getTerminal().getTerminal());
        }
        if (o.getBus() != null) {
            dto.setIdBus(o.getBus().getIdBus());
            dto.setPatenteB(o.getBus().getPatenteB());
        }
        if (o.getGravedadCarroceria() != null) {
            dto.setIdGravedadCarroceria(o.getGravedadCarroceria().getId());
            dto.setGravedadCarroceria(o.getGravedadCarroceria().getGravedad());
        }
        if (o.getGravedadPintura() != null) {
            dto.setIdGravedadPintura(o.getGravedadPintura().getId());
            dto.setGravedadPintura(o.getGravedadPintura().getGravedad());
        }
        if (o.getGravedadFibra() != null) {
            dto.setIdGravedadFibra(o.getGravedadFibra().getId());
            dto.setGravedadFibra(o.getGravedadFibra().getGravedad());
        }

        return dto;
    }
}
