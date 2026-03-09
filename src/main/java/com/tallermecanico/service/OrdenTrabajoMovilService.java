package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOrdenTrabajoMovilDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoMovilDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoMovilResponseDto;
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

    public OrdenTrabajoMovilService(OrdenTrabajoMovilRepository ordenTrabajoMovilRepository,
                                    TerminalService terminalService) {
        this.ordenTrabajoMovilRepository = ordenTrabajoMovilRepository;
        this.terminalService = terminalService;
    }

    @Transactional
    public OrdenTrabajoMovil create(CreateOrdenTrabajoMovilDto dto) {
        if (ordenTrabajoMovilRepository.existsById(dto.getId())) {
            throw new DuplicateResourceException("OrdenTrabajoMovil", "id", dto.getId());
        }

        OrdenTrabajoMovil otm = new OrdenTrabajoMovil();
        otm.setId(dto.getId());
        otm.setTipoOtm(dto.getTipoOtm());
        otm.setNroOtManager(dto.getNroOtManager());
        otm.setNroMovil(dto.getNroMovil());
        otm.setKm(dto.getKm());
        otm.setPpu(dto.getPpu());
        otm.setConductor(dto.getConductor());
        otm.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        otm.setFechaHoraSalida(dto.getFechaHoraSalida());
        otm.setTrabajoARealizar(dto.getTrabajoARealizar());
        otm.setObsRecepcion(dto.getObsRecepcion());
        otm.setResponsable(dto.getResponsable());
        otm.setHoraResponsable(dto.getHoraResponsable());
        otm.setRespTecnico(dto.getRespTecnico());
        otm.setHoraTecnico(dto.getHoraTecnico());
        otm.setRespRecepciona(dto.getRespRecepciona());
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

        return ordenTrabajoMovilRepository.save(otm);
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoMovil> findAll() {
        return ordenTrabajoMovilRepository.findAll();
    }

    @Transactional(readOnly = true)
    public OrdenTrabajoMovil findById(Integer id) {
        return ordenTrabajoMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoMovil", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoMovil> findByTerminal(Integer idTerminal) {
        return ordenTrabajoMovilRepository.findByTerminal_IdTerminal(idTerminal);
    }

    @Transactional
    public OrdenTrabajoMovil update(Integer id, UpdateOrdenTrabajoMovilDto dto) {
        OrdenTrabajoMovil otm = ordenTrabajoMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoMovil", "id", id));

        if (dto.getTipoOtm() != null) {
            otm.setTipoOtm(dto.getTipoOtm());
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            otm.setTerminal(terminal);
        }
        if (dto.getNroOtManager() != null) {
            otm.setNroOtManager(dto.getNroOtManager());
        }
        if (dto.getNroMovil() != null) {
            otm.setNroMovil(dto.getNroMovil());
        }
        if (dto.getKm() != null) {
            otm.setKm(dto.getKm());
        }
        if (dto.getPpu() != null) {
            otm.setPpu(dto.getPpu());
        }
        if (dto.getConductor() != null) {
            otm.setConductor(dto.getConductor());
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
        if (dto.getResponsable() != null) {
            otm.setResponsable(dto.getResponsable());
        }
        if (dto.getHoraResponsable() != null) {
            otm.setHoraResponsable(dto.getHoraResponsable());
        }
        if (dto.getRespTecnico() != null) {
            otm.setRespTecnico(dto.getRespTecnico());
        }
        if (dto.getHoraTecnico() != null) {
            otm.setHoraTecnico(dto.getHoraTecnico());
        }
        if (dto.getRespRecepciona() != null) {
            otm.setRespRecepciona(dto.getRespRecepciona());
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

        return ordenTrabajoMovilRepository.save(otm);
    }

    @Transactional
    public DeleteOrdenTrabajoMovilResponseDto delete(Integer id) {
        OrdenTrabajoMovil otm = ordenTrabajoMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoMovil", "id", id));

        ordenTrabajoMovilRepository.delete(otm);
        return new DeleteOrdenTrabajoMovilResponseDto(
                otm.getId(),
                "Orden de trabajo móvil eliminada exitosamente"
        );
    }
}
