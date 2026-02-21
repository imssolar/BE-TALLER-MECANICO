package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateSMProyeccionDto;
import com.tallermecanico.dto.request.UpdateSMProyeccionDto;
import com.tallermecanico.dto.response.DeleteSMProyeccionResponseDto;
import com.tallermecanico.entity.SMProyeccion;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.SMProyeccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SMProyeccionService {

    private final SMProyeccionRepository smProyeccionRepository;

    public SMProyeccionService(SMProyeccionRepository smProyeccionRepository) {
        this.smProyeccionRepository = smProyeccionRepository;
    }

    @Transactional
    public SMProyeccion create(CreateSMProyeccionDto dto) {
        SMProyeccion smProyeccion = new SMProyeccion();
        smProyeccion.setFechaActual(dto.getFechaActual());
        smProyeccion.setTerminal(dto.getTerminal());
        smProyeccion.setModelo(dto.getModelo());
        smProyeccion.setKmRecorrido(dto.getKmRecorrido());
        smProyeccion.setSm(dto.getSm());
        smProyeccion.setMinutos(dto.getMinutos());
        smProyeccion.setHoras(dto.getHoras());
        smProyeccion.setFechaInicio(dto.getFechaInicio());
        smProyeccion.setFechaTermino(dto.getFechaTermino());
        smProyeccion.setDias(dto.getDias());
        smProyeccion.setRecursos(dto.getRecursos());

        return smProyeccionRepository.save(smProyeccion);
    }

    @Transactional(readOnly = true)
    public List<SMProyeccion> findAll() {
        return smProyeccionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public SMProyeccion findById(Integer id) {
        return smProyeccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SMProyeccion", "id", id));
    }

    @Transactional
    public SMProyeccion update(Integer id, UpdateSMProyeccionDto dto) {
        SMProyeccion smProyeccion = smProyeccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SMProyeccion", "id", id));

        if (dto.getFechaActual() != null) {
            smProyeccion.setFechaActual(dto.getFechaActual());
        }
        if (dto.getTerminal() != null) {
            smProyeccion.setTerminal(dto.getTerminal());
        }
        if (dto.getModelo() != null) {
            smProyeccion.setModelo(dto.getModelo());
        }
        if (dto.getKmRecorrido() != null) {
            smProyeccion.setKmRecorrido(dto.getKmRecorrido());
        }
        if (dto.getSm() != null) {
            smProyeccion.setSm(dto.getSm());
        }
        if (dto.getMinutos() != null) {
            smProyeccion.setMinutos(dto.getMinutos());
        }
        if (dto.getHoras() != null) {
            smProyeccion.setHoras(dto.getHoras());
        }
        if (dto.getFechaInicio() != null) {
            smProyeccion.setFechaInicio(dto.getFechaInicio());
        }
        if (dto.getFechaTermino() != null) {
            smProyeccion.setFechaTermino(dto.getFechaTermino());
        }
        if (dto.getDias() != null) {
            smProyeccion.setDias(dto.getDias());
        }
        if (dto.getRecursos() != null) {
            smProyeccion.setRecursos(dto.getRecursos());
        }

        return smProyeccionRepository.save(smProyeccion);
    }

    @Transactional
    public DeleteSMProyeccionResponseDto delete(Integer id) {
        SMProyeccion smProyeccion = smProyeccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SMProyeccion", "id", id));

        smProyeccionRepository.delete(smProyeccion);
        return new DeleteSMProyeccionResponseDto(
                smProyeccion.getId(),
                "Proyección SM eliminada exitosamente"
        );
    }
}
