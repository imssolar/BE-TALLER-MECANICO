package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOrdenTrabajoDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoResponseDto;
import com.tallermecanico.dto.response.OrdenTrabajoResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.Empleado;
import com.tallermecanico.entity.OrdenTrabajo;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.OrdenTrabajoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdenTrabajoService {

    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final BusService busService;
    private final TerminalService terminalService;
    private final EmpleadoService empleadoService;

    public OrdenTrabajoService(OrdenTrabajoRepository ordenTrabajoRepository,
                               BusService busService,
                               TerminalService terminalService,
                               EmpleadoService empleadoService) {
        this.ordenTrabajoRepository = ordenTrabajoRepository;
        this.busService = busService;
        this.terminalService = terminalService;
        this.empleadoService = empleadoService;
    }

    @Transactional
    public OrdenTrabajoResponseDto create(CreateOrdenTrabajoDto dto) {
        if (ordenTrabajoRepository.existsById(dto.getId())) {
            throw new DuplicateResourceException("OrdenTrabajo", "id", dto.getId());
        }

        OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
        ordenTrabajo.setId(dto.getId());
        ordenTrabajo.setTipoOt(dto.getTipoOt());
        ordenTrabajo.setNroOtManager(dto.getNroOtManager());
        ordenTrabajo.setKm(dto.getKm());
        ordenTrabajo.setPpu(dto.getPpu());
        ordenTrabajo.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        ordenTrabajo.setFechaHoraSalida(dto.getFechaHoraSalida());
        ordenTrabajo.setTrabajoARealizar(dto.getTrabajoARealizar());
        ordenTrabajo.setObsTrabMecanico(dto.getObsTrabMecanico());
        ordenTrabajo.setObsTrabElectrico(dto.getObsTrabElectrico());
        ordenTrabajo.setHoraJefeTurnoPatio(dto.getHoraJefeTurnoPatio());
        ordenTrabajo.setHoraJefeTurnoMant(dto.getHoraJefeTurnoMant());
        ordenTrabajo.setHoraSupervCalidad(dto.getHoraSupervCalidad());
        ordenTrabajo.setObsControlCalidad(dto.getObsControlCalidad());
        ordenTrabajo.setRepAutoriza(dto.getRepAutoriza());
        ordenTrabajo.setRepRetira(dto.getRepRetira());
        ordenTrabajo.setRepBodega(dto.getRepBodega());
        ordenTrabajo.setItemFalla(dto.getItemFalla());

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            ordenTrabajo.setBus(bus);
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            ordenTrabajo.setTerminal(terminal);
        }
        if (dto.getIdConductor() != null) {
            Empleado conductor = empleadoService.findEntityById(dto.getIdConductor());
            ordenTrabajo.setConductor(conductor);
        }
        if (dto.getIdJefeTurnoPatio() != null) {
            Empleado jefeTurnoPatio = empleadoService.findEntityById(dto.getIdJefeTurnoPatio());
            ordenTrabajo.setJefeTurnoPatio(jefeTurnoPatio);
        }
        if (dto.getIdJefeTurnoMant() != null) {
            Empleado jefeTurnoMant = empleadoService.findEntityById(dto.getIdJefeTurnoMant());
            ordenTrabajo.setJefeTurnoMant(jefeTurnoMant);
        }
        if (dto.getIdSupervCalidad() != null) {
            Empleado supervCalidad = empleadoService.findEntityById(dto.getIdSupervCalidad());
            ordenTrabajo.setSupervCalidad(supervCalidad);
        }

        return toDto(ordenTrabajoRepository.save(ordenTrabajo));
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoResponseDto> findAll() {
        return ordenTrabajoRepository.findAllWithRelations()
                .stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public OrdenTrabajoResponseDto findById(Integer id) {
        return toDto(ordenTrabajoRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo", "id", id)));
    }

    @Transactional(readOnly = true)
    public OrdenTrabajo findEntityById(Integer id) {
        return ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoResponseDto> findByBus(Integer idBus) {
        return ordenTrabajoRepository.findByBusWithRelations(idBus)
                .stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoResponseDto> findByTerminal(Integer idTerminal) {
        return ordenTrabajoRepository.findByTerminalWithRelations(idTerminal)
                .stream().map(this::toDto).toList();
    }

    @Transactional
    public OrdenTrabajoResponseDto update(Integer id, UpdateOrdenTrabajoDto dto) {
        OrdenTrabajo ordenTrabajo = ordenTrabajoRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo", "id", id));

        if (dto.getIdBus() != null) {
            ordenTrabajo.setBus(busService.findById(dto.getIdBus()));
        }
        if (dto.getIdTerminal() != null) {
            ordenTrabajo.setTerminal(terminalService.findById(dto.getIdTerminal()));
        }
        if (dto.getTipoOt() != null) {
            ordenTrabajo.setTipoOt(dto.getTipoOt());
        }
        if (dto.getNroOtManager() != null) {
            ordenTrabajo.setNroOtManager(dto.getNroOtManager());
        }
        if (dto.getKm() != null) {
            ordenTrabajo.setKm(dto.getKm());
        }
        if (dto.getPpu() != null) {
            ordenTrabajo.setPpu(dto.getPpu());
        }
        if (dto.getIdConductor() != null) {
            ordenTrabajo.setConductor(empleadoService.findEntityById(dto.getIdConductor()));
        }
        if (dto.getFechaHoraIngreso() != null) {
            ordenTrabajo.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        }
        if (dto.getFechaHoraSalida() != null) {
            ordenTrabajo.setFechaHoraSalida(dto.getFechaHoraSalida());
        }
        if (dto.getTrabajoARealizar() != null) {
            ordenTrabajo.setTrabajoARealizar(dto.getTrabajoARealizar());
        }
        if (dto.getObsTrabMecanico() != null) {
            ordenTrabajo.setObsTrabMecanico(dto.getObsTrabMecanico());
        }
        if (dto.getObsTrabElectrico() != null) {
            ordenTrabajo.setObsTrabElectrico(dto.getObsTrabElectrico());
        }
        if (dto.getIdJefeTurnoPatio() != null) {
            ordenTrabajo.setJefeTurnoPatio(empleadoService.findEntityById(dto.getIdJefeTurnoPatio()));
        }
        if (dto.getHoraJefeTurnoPatio() != null) {
            ordenTrabajo.setHoraJefeTurnoPatio(dto.getHoraJefeTurnoPatio());
        }
        if (dto.getIdJefeTurnoMant() != null) {
            ordenTrabajo.setJefeTurnoMant(empleadoService.findEntityById(dto.getIdJefeTurnoMant()));
        }
        if (dto.getHoraJefeTurnoMant() != null) {
            ordenTrabajo.setHoraJefeTurnoMant(dto.getHoraJefeTurnoMant());
        }
        if (dto.getIdSupervCalidad() != null) {
            ordenTrabajo.setSupervCalidad(empleadoService.findEntityById(dto.getIdSupervCalidad()));
        }
        if (dto.getHoraSupervCalidad() != null) {
            ordenTrabajo.setHoraSupervCalidad(dto.getHoraSupervCalidad());
        }
        if (dto.getObsControlCalidad() != null) {
            ordenTrabajo.setObsControlCalidad(dto.getObsControlCalidad());
        }
        if (dto.getRepAutoriza() != null) {
            ordenTrabajo.setRepAutoriza(dto.getRepAutoriza());
        }
        if (dto.getRepRetira() != null) {
            ordenTrabajo.setRepRetira(dto.getRepRetira());
        }
        if (dto.getRepBodega() != null) {
            ordenTrabajo.setRepBodega(dto.getRepBodega());
        }
        if (dto.getItemFalla() != null) {
            ordenTrabajo.setItemFalla(dto.getItemFalla());
        }

        return toDto(ordenTrabajoRepository.save(ordenTrabajo));
    }

    @Transactional
    public DeleteOrdenTrabajoResponseDto delete(Integer id) {
        OrdenTrabajo ordenTrabajo = ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo", "id", id));
        ordenTrabajoRepository.delete(ordenTrabajo);
        return new DeleteOrdenTrabajoResponseDto(id, "Orden de trabajo eliminada exitosamente");
    }

    private OrdenTrabajoResponseDto toDto(OrdenTrabajo o) {
        OrdenTrabajoResponseDto dto = new OrdenTrabajoResponseDto();
        dto.setId(o.getId());
        if (o.getBus() != null) {
            dto.setIdBus(o.getBus().getIdBus());
            dto.setPatenteB(o.getBus().getPatenteB());
        }
        dto.setIdTerminal(o.getTerminal().getIdTerminal());
        dto.setNombreTerminal(o.getTerminal().getTerminal());
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
        dto.setTipoOt(o.getTipoOt());
        dto.setNroOtManager(o.getNroOtManager());
        dto.setKm(o.getKm());
        dto.setPpu(o.getPpu());
        dto.setFechaHoraIngreso(o.getFechaHoraIngreso());
        dto.setFechaHoraSalida(o.getFechaHoraSalida());
        dto.setTrabajoARealizar(o.getTrabajoARealizar());
        dto.setObsTrabMecanico(o.getObsTrabMecanico());
        dto.setObsTrabElectrico(o.getObsTrabElectrico());
        dto.setHoraJefeTurnoPatio(o.getHoraJefeTurnoPatio());
        dto.setHoraJefeTurnoMant(o.getHoraJefeTurnoMant());
        dto.setHoraSupervCalidad(o.getHoraSupervCalidad());
        dto.setObsControlCalidad(o.getObsControlCalidad());
        dto.setRepAutoriza(o.getRepAutoriza());
        dto.setRepRetira(o.getRepRetira());
        dto.setRepBodega(o.getRepBodega());
        dto.setItemFalla(o.getItemFalla());
        return dto;
    }
}
