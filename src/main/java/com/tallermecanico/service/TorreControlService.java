package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateTorreControlDto;
import com.tallermecanico.dto.request.UpdateTorreControlDto;
import com.tallermecanico.dto.response.DeleteTorreControlResponseDto;
import com.tallermecanico.dto.response.TorreControlResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.Empleado;
import com.tallermecanico.entity.TorreControl;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.EmpleadoRepository;
import com.tallermecanico.repository.TorreControlRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TorreControlService {

    private final TorreControlRepository torreControlRepository;
    private final BusService busService;
    private final EmpleadoRepository empleadoRepository;

    public TorreControlService(TorreControlRepository torreControlRepository,
                               BusService busService,
                               EmpleadoRepository empleadoRepository) {
        this.torreControlRepository = torreControlRepository;
        this.busService = busService;
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public TorreControlResponseDto create(CreateTorreControlDto dto) {
        TorreControl torreControl = new TorreControl();

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            torreControl.setBus(bus);
        }
        if (dto.getIdEmpleadoMecanico() != null) {
            Empleado mecanico = empleadoRepository.findById(dto.getIdEmpleadoMecanico())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoMecanico()));
            torreControl.setMecanico(mecanico);
        }
        if (dto.getIdEmpleadoElectrico() != null) {
            Empleado electrico = empleadoRepository.findById(dto.getIdEmpleadoElectrico())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoElectrico()));
            torreControl.setElectrico(electrico);
        }

        torreControl.setKm(dto.getKm());
        torreControl.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        torreControl.setFalla(dto.getFalla());
        torreControl.setTipoFalla(dto.getTipoFalla());
        torreControl.setNroOtManager(dto.getNroOtManager());
        torreControl.setFechaHoraInicioElectrico(dto.getFechaHoraInicioElectrico());
        torreControl.setFechaHoraFinElectrico(dto.getFechaHoraFinElectrico());
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

        TorreControl saved = torreControlRepository.save(torreControl);
        return toDto(saved);
    }

    @Transactional(readOnly = true)
    public List<TorreControlResponseDto> findAll() {
        return torreControlRepository.findAllWithRelations()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public TorreControlResponseDto findById(Integer id) {
        TorreControl torreControl = torreControlRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("TorreControl", "id", id));
        return toDto(torreControl);
    }

    @Transactional(readOnly = true)
    public List<TorreControlResponseDto> findByBus(Integer idBus) {
        return torreControlRepository.findByBusWithRelations(idBus)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TorreControlResponseDto> findAbiertos() {
        return torreControlRepository.findByCerradoWithRelations(false)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TorreControlResponseDto> findCerrados() {
        return torreControlRepository.findByCerradoWithRelations(true)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional
    public TorreControlResponseDto update(Integer id, UpdateTorreControlDto dto) {
        TorreControl torreControl = torreControlRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("TorreControl", "id", id));

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            torreControl.setBus(bus);
        }
        if (dto.getIdEmpleadoMecanico() != null) {
            Empleado mecanico = empleadoRepository.findById(dto.getIdEmpleadoMecanico())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoMecanico()));
            torreControl.setMecanico(mecanico);
        }
        if (dto.getIdEmpleadoElectrico() != null) {
            Empleado electrico = empleadoRepository.findById(dto.getIdEmpleadoElectrico())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoElectrico()));
            torreControl.setElectrico(electrico);
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
        if (dto.getFechaHoraInicioElectrico() != null) {
            torreControl.setFechaHoraInicioElectrico(dto.getFechaHoraInicioElectrico());
        }
        if (dto.getFechaHoraFinElectrico() != null) {
            torreControl.setFechaHoraFinElectrico(dto.getFechaHoraFinElectrico());
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

        return toDto(torreControlRepository.save(torreControl));
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

    private TorreControlResponseDto toDto(TorreControl t) {
        TorreControlResponseDto dto = new TorreControlResponseDto();
        dto.setId(t.getId());
        if (t.getBus() != null) {
            dto.setIdBus(t.getBus().getIdBus());
            dto.setPatenteB(t.getBus().getPatenteB());
        }
        if (t.getMecanico() != null) {
            dto.setIdEmpleadoMecanico(t.getMecanico().getId());
            dto.setNombreCompletoMecanico(
                t.getMecanico().getNombres() + " " +
                t.getMecanico().getApellidoPaterno() + " " +
                t.getMecanico().getApellidoMaterno()
            );
        }
        if (t.getElectrico() != null) {
            dto.setIdEmpleadoElectrico(t.getElectrico().getId());
            dto.setNombreCompletoElectrico(
                t.getElectrico().getNombres() + " " +
                t.getElectrico().getApellidoPaterno() + " " +
                t.getElectrico().getApellidoMaterno()
            );
        }
        dto.setFalla(t.getFalla());
        dto.setTipoFalla(t.getTipoFalla());
        dto.setStatus(t.getStatus());
        dto.setCerrado(t.getCerrado());
        return dto;
    }
}
