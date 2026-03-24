package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOrdenTrabajoProgDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoProgDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoProgResponseDto;
import com.tallermecanico.dto.response.OrdenTrabajoProgResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.Empleado;
import com.tallermecanico.entity.OrdenTrabajoProg;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.OrdenTrabajoProgRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdenTrabajoProgService {

    private final OrdenTrabajoProgRepository ordenTrabajoProgRepository;
    private final BusService busService;
    private final TerminalService terminalService;
    private final EmpleadoService empleadoService;

    public OrdenTrabajoProgService(OrdenTrabajoProgRepository ordenTrabajoProgRepository,
                                   BusService busService,
                                   TerminalService terminalService,
                                   EmpleadoService empleadoService) {
        this.ordenTrabajoProgRepository = ordenTrabajoProgRepository;
        this.busService = busService;
        this.terminalService = terminalService;
        this.empleadoService = empleadoService;
    }

    @Transactional
    public OrdenTrabajoProgResponseDto create(CreateOrdenTrabajoProgDto dto) {
        if (ordenTrabajoProgRepository.existsById(dto.getId())) {
            throw new DuplicateResourceException("OrdenTrabajoProg", "id", dto.getId());
        }

        OrdenTrabajoProg otp = new OrdenTrabajoProg();
        otp.setId(dto.getId());
        otp.setNroOtManager(dto.getNroOtManager());
        otp.setKm(dto.getKm());
        otp.setPpu(dto.getPpu());
        otp.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        otp.setFechaHoraSalida(dto.getFechaHoraSalida());
        otp.setTrabajoARealizar(dto.getTrabajoARealizar());
        otp.setHoraJefeTurnoPatio(dto.getHoraJefeTurnoPatio());
        otp.setHoraJefeTurnoMant(dto.getHoraJefeTurnoMant());
        otp.setHoraSupervCalidad(dto.getHoraSupervCalidad());
        otp.setObsControlCalidad(dto.getObsControlCalidad());
        otp.setRepAutoriza(dto.getRepAutoriza());
        otp.setRepRetira(dto.getRepRetira());
        otp.setRepBodega(dto.getRepBodega());
        otp.setItem(dto.getItem());
        otp.setFormato(dto.getFormato());

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            otp.setTerminal(terminal);
        }
        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            otp.setBus(bus);
        }
        if (dto.getIdConductor() != null) {
            Empleado conductor = empleadoService.findEntityById(dto.getIdConductor());
            otp.setConductor(conductor);
        }
        if (dto.getIdJefeTurnoPatio() != null) {
            Empleado jefeTurnoPatio = empleadoService.findEntityById(dto.getIdJefeTurnoPatio());
            otp.setJefeTurnoPatio(jefeTurnoPatio);
        }
        if (dto.getIdJefeTurnoMant() != null) {
            Empleado jefeTurnoMant = empleadoService.findEntityById(dto.getIdJefeTurnoMant());
            otp.setJefeTurnoMant(jefeTurnoMant);
        }
        if (dto.getIdSupervCalidad() != null) {
            Empleado supervCalidad = empleadoService.findEntityById(dto.getIdSupervCalidad());
            otp.setSupervCalidad(supervCalidad);
        }

        return toDto(ordenTrabajoProgRepository.save(otp));
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoProgResponseDto> findAll() {
        return ordenTrabajoProgRepository.findAllWithRelations()
                .stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public OrdenTrabajoProgResponseDto findById(Integer id) {
        return toDto(ordenTrabajoProgRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoProg", "id", id)));
    }

    @Transactional(readOnly = true)
    public OrdenTrabajoProg findEntityById(Integer id) {
        return ordenTrabajoProgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoProg", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoProgResponseDto> findByBus(Integer idBus) {
        return ordenTrabajoProgRepository.findByBusWithRelations(idBus)
                .stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoProgResponseDto> findByTerminal(Integer idTerminal) {
        return ordenTrabajoProgRepository.findByTerminalWithRelations(idTerminal)
                .stream().map(this::toDto).toList();
    }

    @Transactional
    public OrdenTrabajoProgResponseDto update(Integer id, UpdateOrdenTrabajoProgDto dto) {
        OrdenTrabajoProg otp = ordenTrabajoProgRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoProg", "id", id));

        if (dto.getIdTerminal() != null) {
            otp.setTerminal(terminalService.findById(dto.getIdTerminal()));
        }
        if (dto.getNroOtManager() != null) {
            otp.setNroOtManager(dto.getNroOtManager());
        }
        if (dto.getIdBus() != null) {
            otp.setBus(busService.findById(dto.getIdBus()));
        }
        if (dto.getKm() != null) {
            otp.setKm(dto.getKm());
        }
        if (dto.getPpu() != null) {
            otp.setPpu(dto.getPpu());
        }
        if (dto.getIdConductor() != null) {
            otp.setConductor(empleadoService.findEntityById(dto.getIdConductor()));
        }
        if (dto.getFechaHoraIngreso() != null) {
            otp.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        }
        if (dto.getFechaHoraSalida() != null) {
            otp.setFechaHoraSalida(dto.getFechaHoraSalida());
        }
        if (dto.getTrabajoARealizar() != null) {
            otp.setTrabajoARealizar(dto.getTrabajoARealizar());
        }
        if (dto.getIdJefeTurnoPatio() != null) {
            otp.setJefeTurnoPatio(empleadoService.findEntityById(dto.getIdJefeTurnoPatio()));
        }
        if (dto.getHoraJefeTurnoPatio() != null) {
            otp.setHoraJefeTurnoPatio(dto.getHoraJefeTurnoPatio());
        }
        if (dto.getIdJefeTurnoMant() != null) {
            otp.setJefeTurnoMant(empleadoService.findEntityById(dto.getIdJefeTurnoMant()));
        }
        if (dto.getHoraJefeTurnoMant() != null) {
            otp.setHoraJefeTurnoMant(dto.getHoraJefeTurnoMant());
        }
        if (dto.getIdSupervCalidad() != null) {
            otp.setSupervCalidad(empleadoService.findEntityById(dto.getIdSupervCalidad()));
        }
        if (dto.getHoraSupervCalidad() != null) {
            otp.setHoraSupervCalidad(dto.getHoraSupervCalidad());
        }
        if (dto.getObsControlCalidad() != null) {
            otp.setObsControlCalidad(dto.getObsControlCalidad());
        }
        if (dto.getRepAutoriza() != null) {
            otp.setRepAutoriza(dto.getRepAutoriza());
        }
        if (dto.getRepRetira() != null) {
            otp.setRepRetira(dto.getRepRetira());
        }
        if (dto.getRepBodega() != null) {
            otp.setRepBodega(dto.getRepBodega());
        }
        if (dto.getItem() != null) {
            otp.setItem(dto.getItem());
        }
        if (dto.getFormato() != null) {
            otp.setFormato(dto.getFormato());
        }

        return toDto(ordenTrabajoProgRepository.save(otp));
    }

    @Transactional
    public DeleteOrdenTrabajoProgResponseDto delete(Integer id) {
        OrdenTrabajoProg otp = ordenTrabajoProgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoProg", "id", id));
        ordenTrabajoProgRepository.delete(otp);
        return new DeleteOrdenTrabajoProgResponseDto(otp.getId(), "Orden de trabajo programada eliminada exitosamente");
    }

    private OrdenTrabajoProgResponseDto toDto(OrdenTrabajoProg o) {
        OrdenTrabajoProgResponseDto dto = new OrdenTrabajoProgResponseDto();
        dto.setId(o.getId());
        if (o.getTerminal() != null) {
            dto.setIdTerminal(o.getTerminal().getIdTerminal());
        }
        if (o.getBus() != null) {
            dto.setIdBus(o.getBus().getIdBus());
            dto.setPatenteB(o.getBus().getPatenteB());
        }
        if (o.getConductor() != null) {
            dto.setIdConductor(o.getConductor().getId());
            dto.setNombreCompletoConductor(o.getConductor().getNombres() + " " + o.getConductor().getApellidoPaterno() + " " + o.getConductor().getApellidoMaterno());
        }
        if (o.getJefeTurnoPatio() != null) {
            dto.setIdJefeTurnoPatio(o.getJefeTurnoPatio().getId());
            dto.setNombreCompletoJefeTurnoPatio(o.getJefeTurnoPatio().getNombres() + " " + o.getJefeTurnoPatio().getApellidoPaterno() + " " + o.getJefeTurnoPatio().getApellidoMaterno());
        }
        if (o.getJefeTurnoMant() != null) {
            dto.setIdJefeTurnoMant(o.getJefeTurnoMant().getId());
            dto.setNombreCompletoJefeTurnoMant(o.getJefeTurnoMant().getNombres() + " " + o.getJefeTurnoMant().getApellidoPaterno() + " " + o.getJefeTurnoMant().getApellidoMaterno());
        }
        if (o.getSupervCalidad() != null) {
            dto.setIdSupervCalidad(o.getSupervCalidad().getId());
            dto.setNombreCompletoSupervCalidad(o.getSupervCalidad().getNombres() + " " + o.getSupervCalidad().getApellidoPaterno() + " " + o.getSupervCalidad().getApellidoMaterno());
        }
        dto.setNroOtManager(o.getNroOtManager());
        dto.setKm(o.getKm());
        dto.setPpu(o.getPpu());
        dto.setFechaHoraIngreso(o.getFechaHoraIngreso());
        dto.setFechaHoraSalida(o.getFechaHoraSalida());
        dto.setTrabajoARealizar(o.getTrabajoARealizar());
        dto.setHoraJefeTurnoPatio(o.getHoraJefeTurnoPatio());
        dto.setHoraJefeTurnoMant(o.getHoraJefeTurnoMant());
        dto.setHoraSupervCalidad(o.getHoraSupervCalidad());
        dto.setObsControlCalidad(o.getObsControlCalidad());
        dto.setRepAutoriza(o.getRepAutoriza());
        dto.setRepRetira(o.getRepRetira());
        dto.setRepBodega(o.getRepBodega());
        dto.setItem(o.getItem());
        dto.setFormato(o.getFormato());
        return dto;
    }
}
