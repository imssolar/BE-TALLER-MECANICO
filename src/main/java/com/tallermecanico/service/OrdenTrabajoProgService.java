package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateOrdenTrabajoProgDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoProgDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoProgResponseDto;
import com.tallermecanico.entity.Bus;
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

    public OrdenTrabajoProgService(OrdenTrabajoProgRepository ordenTrabajoProgRepository,
                                   BusService busService,
                                   TerminalService terminalService) {
        this.ordenTrabajoProgRepository = ordenTrabajoProgRepository;
        this.busService = busService;
        this.terminalService = terminalService;
    }

    @Transactional
    public OrdenTrabajoProg create(CreateOrdenTrabajoProgDto dto) {
        if (ordenTrabajoProgRepository.existsById(dto.getId())) {
            throw new DuplicateResourceException("OrdenTrabajoProg", "id", dto.getId());
        }

        OrdenTrabajoProg otp = new OrdenTrabajoProg();
        otp.setId(dto.getId());

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            otp.setTerminal(terminal);
        }

        otp.setNroOtManager(dto.getNroOtManager());

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            otp.setBus(bus);
        }

        otp.setKm(dto.getKm());
        otp.setPpu(dto.getPpu());
        otp.setConductor(dto.getConductor());
        otp.setFechaHoraIngreso(dto.getFechaHoraIngreso());
        otp.setFechaHoraSalida(dto.getFechaHoraSalida());
        otp.setTrabajoARealizar(dto.getTrabajoARealizar());
        otp.setJefeTurnoPatio(dto.getJefeTurnoPatio());
        otp.setHoraJefeTurnoPatio(dto.getHoraJefeTurnoPatio());
        otp.setJefeTurnoMant(dto.getJefeTurnoMant());
        otp.setHoraJefeTurnoMant(dto.getHoraJefeTurnoMant());
        otp.setSupervCalidad(dto.getSupervCalidad());
        otp.setHoraSupervCalidad(dto.getHoraSupervCalidad());
        otp.setObsControlCalidad(dto.getObsControlCalidad());
        otp.setRepAutoriza(dto.getRepAutoriza());
        otp.setRepRetira(dto.getRepRetira());
        otp.setRepBodega(dto.getRepBodega());
        otp.setItem(dto.getItem());
        otp.setFormato(dto.getFormato());

        return ordenTrabajoProgRepository.save(otp);
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoProg> findAll() {
        return ordenTrabajoProgRepository.findAll();
    }

    @Transactional(readOnly = true)
    public OrdenTrabajoProg findById(Integer id) {
        return ordenTrabajoProgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoProg", "id", id));
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoProg> findByBus(Integer idBus) {
        return ordenTrabajoProgRepository.findByBus_IdBus(idBus);
    }

    @Transactional(readOnly = true)
    public List<OrdenTrabajoProg> findByTerminal(Integer idTerminal) {
        return ordenTrabajoProgRepository.findByTerminal_IdTerminal(idTerminal);
    }

    @Transactional
    public OrdenTrabajoProg update(Integer id, UpdateOrdenTrabajoProgDto dto) {
        OrdenTrabajoProg otp = ordenTrabajoProgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoProg", "id", id));

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            otp.setTerminal(terminal);
        }

        if (dto.getNroOtManager() != null) {
            otp.setNroOtManager(dto.getNroOtManager());
        }

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            otp.setBus(bus);
        }

        if (dto.getKm() != null) {
            otp.setKm(dto.getKm());
        }

        if (dto.getPpu() != null) {
            otp.setPpu(dto.getPpu());
        }

        if (dto.getConductor() != null) {
            otp.setConductor(dto.getConductor());
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

        if (dto.getJefeTurnoPatio() != null) {
            otp.setJefeTurnoPatio(dto.getJefeTurnoPatio());
        }

        if (dto.getHoraJefeTurnoPatio() != null) {
            otp.setHoraJefeTurnoPatio(dto.getHoraJefeTurnoPatio());
        }

        if (dto.getJefeTurnoMant() != null) {
            otp.setJefeTurnoMant(dto.getJefeTurnoMant());
        }

        if (dto.getHoraJefeTurnoMant() != null) {
            otp.setHoraJefeTurnoMant(dto.getHoraJefeTurnoMant());
        }

        if (dto.getSupervCalidad() != null) {
            otp.setSupervCalidad(dto.getSupervCalidad());
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

        return ordenTrabajoProgRepository.save(otp);
    }

    @Transactional
    public DeleteOrdenTrabajoProgResponseDto delete(Integer id) {
        OrdenTrabajoProg otp = ordenTrabajoProgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajoProg", "id", id));

        ordenTrabajoProgRepository.delete(otp);
        return new DeleteOrdenTrabajoProgResponseDto(
                otp.getId(),
                "Orden de trabajo programada eliminada exitosamente"
        );
    }
}
