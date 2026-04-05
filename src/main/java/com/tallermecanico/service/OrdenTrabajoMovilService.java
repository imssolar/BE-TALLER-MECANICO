package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOrdenTrabajoMovilDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoMovilDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoMovilResponseDto;
import com.tallermecanico.dto.response.OrdenTrabajoMovilResponseDto;
import com.tallermecanico.entity.Empleado;
import com.tallermecanico.entity.Movil;
import com.tallermecanico.entity.OrdenTrabajoMovil;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.OrdenTrabajoMovilRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdenTrabajoMovilService {

    private final OrdenTrabajoMovilRepository ordenTrabajoMovilRepository;
    private final TerminalService terminalService;
    private final MovilService movilService;
    private final EmpleadoService empleadoService;

    public OrdenTrabajoMovilService(OrdenTrabajoMovilRepository ordenTrabajoMovilRepository,
                                    TerminalService terminalService,
                                    MovilService movilService,
                                    EmpleadoService empleadoService) {
        this.ordenTrabajoMovilRepository = ordenTrabajoMovilRepository;
        this.terminalService = terminalService;
        this.movilService = movilService;
        this.empleadoService = empleadoService;
    }

    @Transactional
    public OrdenTrabajoMovilResponseDto create(CreateOrdenTrabajoMovilDto dto) {
        if (ordenTrabajoMovilRepository.existsById(dto.getId())) {
            throw new DuplicateResourceException("OrdenTrabajoMovil", "id", dto.getId());
        }

        OrdenTrabajoMovil otm = new OrdenTrabajoMovil();
        otm.setId(dto.getId());
        otm.setTipoOtm(dto.getTipoOtm());
        otm.setNroOtManager(dto.getNroOtManager());
        otm.setKm(dto.getKm());
        otm.setPpu(dto.getPpu());
        otm.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        otm.setFechaHoraSalida(dto.getFechaHoraSalida());
        otm.setTrabajoARealizar(dto.getTrabajoARealizar());
        otm.setObsRecepcion(dto.getObsRecepcion());
        otm.setHoraResponsable(dto.getHoraResponsable());
        otm.setHoraTecnico(dto.getHoraTecnico());
        otm.setHoraRecepcion(dto.getHoraRecepcion());
        otm.setObsTecnicas(dto.getObsTecnicas());
        otm.setAutoriza(dto.getAutoriza());
        otm.setRetira(dto.getRetira());
        otm.setBodega(dto.getBodega());
        otm.setFormato(dto.getFormato());

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            otm.setTerminal(terminal);
        }
        if (dto.getIdMovil() != null) {
            Movil movil = movilService.findById(dto.getIdMovil());
            otm.setMovil(movil);
        }
        if (dto.getIdConductor() != null) {
            Empleado conductor = empleadoService.findEntityById(dto.getIdConductor());
            otm.setConductor(conductor);
        }
        if (dto.getIdResponsable() != null) {
            Empleado responsable = empleadoService.findEntityById(dto.getIdResponsable());
            otm.setResponsable(responsable);
        }
        if (dto.getIdRespTecnico() != null) {
            Empleado respTecnico = empleadoService.findEntityById(dto.getIdRespTecnico());
            otm.setRespTecnico(respTecnico);
        }
        if (dto.getIdRespRecepciona() != null) {
            Empleado respRecepciona = empleadoService.findEntityById(dto.getIdRespRecepciona());
            otm.setRespRecepciona(respRecepciona);
        }

        return toDto(ordenTrabajoMovilRepository.save(otm));
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoMovilResponseDto> findAll() {
        return ordenTrabajoMovilRepository.findAllWithRelations()
                .stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public OrdenTrabajoMovilResponseDto findById(Integer id) {
        return toDto(ordenTrabajoMovilRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoMovil", "id", id)));
    }

    @Transactional(readOnly = true)
    public OrdenTrabajoMovil findEntityById(Integer id) {
        return ordenTrabajoMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoMovil", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoMovilResponseDto> findByTerminal(Integer idTerminal) {
        return ordenTrabajoMovilRepository.findByTerminalWithRelations(idTerminal)
                .stream().map(this::toDto).toList();
    }

    @Transactional
    public OrdenTrabajoMovilResponseDto update(Integer id, UpdateOrdenTrabajoMovilDto dto) {
        OrdenTrabajoMovil otm = ordenTrabajoMovilRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoMovil", "id", id));

        if (dto.getTipoOtm() != null) {
            otm.setTipoOtm(dto.getTipoOtm());
        }
        if (dto.getIdTerminal() != null) {
            otm.setTerminal(terminalService.findById(dto.getIdTerminal()));
        }
        if (dto.getNroOtManager() != null) {
            otm.setNroOtManager(dto.getNroOtManager());
        }
        if (dto.getIdMovil() != null) {
            otm.setMovil(movilService.findById(dto.getIdMovil()));
        }
        if (dto.getKm() != null) {
            otm.setKm(dto.getKm());
        }
        if (dto.getPpu() != null) {
            otm.setPpu(dto.getPpu());
        }
        if (dto.getIdConductor() != null) {
            otm.setConductor(empleadoService.findEntityById(dto.getIdConductor()));
        }
        if (dto.getFechaHoraIngreso() != null) {
            otm.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        }
        if (dto.getFechaHoraSalida() != null) {
            otm.setFechaHoraSalida(dto.getFechaHoraSalida());
        }
        if (dto.getTrabajoARealizar() != null) {
            otm.setTrabajoARealizar(dto.getTrabajoARealizar());
        }
        if (dto.getObsRecepcion() != null) {
            otm.setObsRecepcion(dto.getObsRecepcion());
        }
        if (dto.getIdResponsable() != null) {
            otm.setResponsable(empleadoService.findEntityById(dto.getIdResponsable()));
        }
        if (dto.getHoraResponsable() != null) {
            otm.setHoraResponsable(dto.getHoraResponsable());
        }
        if (dto.getIdRespTecnico() != null) {
            otm.setRespTecnico(empleadoService.findEntityById(dto.getIdRespTecnico()));
        }
        if (dto.getHoraTecnico() != null) {
            otm.setHoraTecnico(dto.getHoraTecnico());
        }
        if (dto.getIdRespRecepciona() != null) {
            otm.setRespRecepciona(empleadoService.findEntityById(dto.getIdRespRecepciona()));
        }
        if (dto.getHoraRecepcion() != null) {
            otm.setHoraRecepcion(dto.getHoraRecepcion());
        }
        if (dto.getObsTecnicas() != null) {
            otm.setObsTecnicas(dto.getObsTecnicas());
        }
        if (dto.getAutoriza() != null) {
            otm.setAutoriza(dto.getAutoriza());
        }
        if (dto.getRetira() != null) {
            otm.setRetira(dto.getRetira());
        }
        if (dto.getBodega() != null) {
            otm.setBodega(dto.getBodega());
        }
        if (dto.getFormato() != null) {
            otm.setFormato(dto.getFormato());
        }

        return toDto(ordenTrabajoMovilRepository.save(otm));
    }

    @Transactional
    public DeleteOrdenTrabajoMovilResponseDto delete(Integer id) {
        OrdenTrabajoMovil otm = ordenTrabajoMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoMovil", "id", id));
        ordenTrabajoMovilRepository.delete(otm);
        return new DeleteOrdenTrabajoMovilResponseDto(otm.getId(), "Orden de trabajo móvil eliminada exitosamente");
    }

    private OrdenTrabajoMovilResponseDto toDto(OrdenTrabajoMovil o) {
        OrdenTrabajoMovilResponseDto dto = new OrdenTrabajoMovilResponseDto();
        dto.setId(o.getId());
        dto.setTipoOtm(o.getTipoOtm());
        dto.setNroOtManager(o.getNroOtManager());
        dto.setKm(o.getKm());
        dto.setPpu(o.getPpu());
        if (o.getTerminal() != null) {
            dto.setIdTerminal(o.getTerminal().getIdTerminal());
        }
        if (o.getMovil() != null) {
            dto.setIdMovil(o.getMovil().getId());
            dto.setPatenteMovil(o.getMovil().getPatente());
        }
        if (o.getConductor() != null) {
            dto.setIdConductor(o.getConductor().getId());
            dto.setNombreCompletoConductor(o.getConductor().getNombres() + " " + o.getConductor().getApellidoPaterno() + " " + o.getConductor().getApellidoMaterno());
        }
        if (o.getResponsable() != null) {
            dto.setIdResponsable(o.getResponsable().getId());
            dto.setNombreCompletoResponsable(o.getResponsable().getNombres() + " " + o.getResponsable().getApellidoPaterno() + " " + o.getResponsable().getApellidoMaterno());
        }
        if (o.getRespTecnico() != null) {
            dto.setIdRespTecnico(o.getRespTecnico().getId());
            dto.setNombreCompletoRespTecnico(o.getRespTecnico().getNombres() + " " + o.getRespTecnico().getApellidoPaterno() + " " + o.getRespTecnico().getApellidoMaterno());
        }
        if (o.getRespRecepciona() != null) {
            dto.setIdRespRecepciona(o.getRespRecepciona().getId());
            dto.setNombreCompletoRespRecepciona(o.getRespRecepciona().getNombres() + " " + o.getRespRecepciona().getApellidoPaterno() + " " + o.getRespRecepciona().getApellidoMaterno());
        }
        dto.setFechaHoraIngreso(o.getFechaHoraIngreso());
        dto.setFechaHoraSalida(o.getFechaHoraSalida());
        dto.setTrabajoARealizar(o.getTrabajoARealizar());
        dto.setObsRecepcion(o.getObsRecepcion());
        dto.setHoraResponsable(o.getHoraResponsable());
        dto.setHoraTecnico(o.getHoraTecnico());
        dto.setHoraRecepcion(o.getHoraRecepcion());
        dto.setObsTecnicas(o.getObsTecnicas());
        dto.setAutoriza(o.getAutoriza());
        dto.setRetira(o.getRetira());
        dto.setBodega(o.getBodega());
        dto.setFormato(o.getFormato());
        return dto;
    }
}
