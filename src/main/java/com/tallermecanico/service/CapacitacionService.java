package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateCapacitacionDto;
import com.tallermecanico.dto.request.UpdateCapacitacionDto;
import com.tallermecanico.dto.response.DeleteCapacitacionResponseDto;
import com.tallermecanico.entity.*;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.CapacitacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CapacitacionService {

    private final CapacitacionRepository capacitacionRepository;
    private final RelatorService relatorService;
    private final AreaService areaService;
    private final TerminalService terminalService;

    public CapacitacionService(CapacitacionRepository capacitacionRepository,
                               RelatorService relatorService,
                               AreaService areaService,
                               TerminalService terminalService) {
        this.capacitacionRepository = capacitacionRepository;
        this.relatorService = relatorService;
        this.areaService = areaService;
        this.terminalService = terminalService;
    }

    @Transactional
    public Capacitacion create(CreateCapacitacionDto dto) {
        Capacitacion capacitacion = new Capacitacion();
        capacitacion.setFecha(dto.getFecha());
        capacitacion.setActividad(dto.getActividad());
        capacitacion.setTema(dto.getTema());
        capacitacion.setObjetivo(dto.getObjetivo());
        capacitacion.setDuracion(dto.getDuracion());
        capacitacion.setLugar(dto.getLugar());
        capacitacion.setComentario(dto.getComentario());
        capacitacion.setMejora(dto.getMejora());
        capacitacion.setFechaTermino(dto.getFechaTermino());

        // Relaciones ManyToOne
        if (dto.getIdRelator() != null) {
            Relator relator = relatorService.findById(dto.getIdRelator());
            capacitacion.setRelator(relator);
        }
        if (dto.getIdArea() != null) {
            Area area = areaService.findById(dto.getIdArea());
            capacitacion.setArea(area);
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            capacitacion.setTerminal(terminal);
        }

        return capacitacionRepository.save(capacitacion);
    }

    @Transactional(readOnly = true)
    public List<Capacitacion> findAll() {
        return capacitacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Capacitacion findById(Integer id) {
        return capacitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Capacitacion", "id", id));
    }

    @Transactional
    public Capacitacion update(Integer id, UpdateCapacitacionDto dto) {
        Capacitacion capacitacion = capacitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Capacitacion", "id", id));

        if (dto.getFecha() != null) {
            capacitacion.setFecha(dto.getFecha());
        }
        if (dto.getActividad() != null) {
            capacitacion.setActividad(dto.getActividad());
        }
        if (dto.getTema() != null) {
            capacitacion.setTema(dto.getTema());
        }
        if (dto.getObjetivo() != null) {
            capacitacion.setObjetivo(dto.getObjetivo());
        }
        if (dto.getDuracion() != null) {
            capacitacion.setDuracion(dto.getDuracion());
        }
        if (dto.getLugar() != null) {
            capacitacion.setLugar(dto.getLugar());
        }
        if (dto.getComentario() != null) {
            capacitacion.setComentario(dto.getComentario());
        }
        if (dto.getMejora() != null) {
            capacitacion.setMejora(dto.getMejora());
        }
        if (dto.getFechaTermino() != null) {
            capacitacion.setFechaTermino(dto.getFechaTermino());
        }

        // Relaciones ManyToOne
        if (dto.getIdRelator() != null) {
            Relator relator = relatorService.findById(dto.getIdRelator());
            capacitacion.setRelator(relator);
        }
        if (dto.getIdArea() != null) {
            Area area = areaService.findById(dto.getIdArea());
            capacitacion.setArea(area);
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            capacitacion.setTerminal(terminal);
        }

        return capacitacionRepository.save(capacitacion);
    }

    @Transactional
    public DeleteCapacitacionResponseDto delete(Integer id) {
        Capacitacion capacitacion = capacitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Capacitacion", "id", id));

        capacitacionRepository.delete(capacitacion);
        return new DeleteCapacitacionResponseDto(
                capacitacion.getId(),
                capacitacion.getTema(),
                "Capacitación eliminada exitosamente"
        );
    }
}
