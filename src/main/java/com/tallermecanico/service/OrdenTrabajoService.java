package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOrdenTrabajoDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoResponseDto;
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
    public OrdenTrabajo create(CreateOrdenTrabajoDto dto) {
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

        return ordenTrabajoRepository.save(ordenTrabajo);
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajo> findAll() {
        return ordenTrabajoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public OrdenTrabajo findById(Integer id) {
        return ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajo> findByBus(Integer idBus) {
        return ordenTrabajoRepository.findByBus_IdBus(idBus);
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajo> findByTerminal(Integer idTerminal) {
        return ordenTrabajoRepository.findByTerminal_IdTerminal(idTerminal);
    }

    @Transactional
    public OrdenTrabajo update(Integer id, UpdateOrdenTrabajoDto dto) {
        OrdenTrabajo ordenTrabajo = findById(id);

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            ordenTrabajo.setBus(bus);
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            ordenTrabajo.setTerminal(terminal);
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
            Empleado conductor = empleadoService.findEntityById(dto.getIdConductor());
            ordenTrabajo.setConductor(conductor);
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
            Empleado jefeTurnoPatio = empleadoService.findEntityById(dto.getIdJefeTurnoPatio());
            ordenTrabajo.setJefeTurnoPatio(jefeTurnoPatio);
        }
        if (dto.getHoraJefeTurnoPatio() != null) {
            ordenTrabajo.setHoraJefeTurnoPatio(dto.getHoraJefeTurnoPatio());
        }
        if (dto.getIdJefeTurnoMant() != null) {
            Empleado jefeTurnoMant = empleadoService.findEntityById(dto.getIdJefeTurnoMant());
            ordenTrabajo.setJefeTurnoMant(jefeTurnoMant);
        }
        if (dto.getHoraJefeTurnoMant() != null) {
            ordenTrabajo.setHoraJefeTurnoMant(dto.getHoraJefeTurnoMant());
        }
        if (dto.getIdSupervCalidad() != null) {
            Empleado supervCalidad = empleadoService.findEntityById(dto.getIdSupervCalidad());
            ordenTrabajo.setSupervCalidad(supervCalidad);
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

        return ordenTrabajoRepository.save(ordenTrabajo);
    }

    @Transactional
    public DeleteOrdenTrabajoResponseDto delete(Integer id) {
        OrdenTrabajo ordenTrabajo = findById(id);
        ordenTrabajoRepository.delete(ordenTrabajo);
        return new DeleteOrdenTrabajoResponseDto(id, "Orden de trabajo eliminada exitosamente");
    }
}
