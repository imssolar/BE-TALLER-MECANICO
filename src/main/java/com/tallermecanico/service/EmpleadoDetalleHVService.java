package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateEmpleadoDetalleHVDto;
import com.tallermecanico.dto.request.UpdateEmpleadoDetalleHVDto;
import com.tallermecanico.dto.response.DeleteEmpleadoDetalleHVResponseDto;
import com.tallermecanico.entity.EmpleadoDetalleHV;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.EmpleadoDetalleHVRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoDetalleHVService {

    private final EmpleadoDetalleHVRepository empleadoDetalleHVRepository;

    public EmpleadoDetalleHVService(EmpleadoDetalleHVRepository empleadoDetalleHVRepository) {
        this.empleadoDetalleHVRepository = empleadoDetalleHVRepository;
    }

    @Transactional
    public EmpleadoDetalleHV create(CreateEmpleadoDetalleHVDto dto) {
        EmpleadoDetalleHV detalleHV = new EmpleadoDetalleHV();
        detalleHV.setRut(dto.getRut());
        detalleHV.setObservacion(dto.getObservacion());
        detalleHV.setFechaHora(dto.getFechaHora());
        detalleHV.setComentario(dto.getComentario());

        return empleadoDetalleHVRepository.save(detalleHV);
    }

    @Transactional(readOnly = true)
    public List<EmpleadoDetalleHV> findAll() {
        return empleadoDetalleHVRepository.findAll();
    }

    @Transactional(readOnly = true)
    public EmpleadoDetalleHV findById(Integer id) {
        return empleadoDetalleHVRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EmpleadoDetalleHV", "id", id));
    }

    @Transactional(readOnly = true)
    public List<EmpleadoDetalleHV> findByRut(String rut) {
        return empleadoDetalleHVRepository.findByRut(rut);
    }

    @Transactional
    public EmpleadoDetalleHV update(Integer id, UpdateEmpleadoDetalleHVDto dto) {
        EmpleadoDetalleHV detalleHV = empleadoDetalleHVRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EmpleadoDetalleHV", "id", id));

        if (dto.getRut() != null) {
            detalleHV.setRut(dto.getRut());
        }
        if (dto.getObservacion() != null) {
            detalleHV.setObservacion(dto.getObservacion());
        }
        if (dto.getFechaHora() != null) {
            detalleHV.setFechaHora(dto.getFechaHora());
        }
        if (dto.getComentario() != null) {
            detalleHV.setComentario(dto.getComentario());
        }

        return empleadoDetalleHVRepository.save(detalleHV);
    }

    @Transactional
    public DeleteEmpleadoDetalleHVResponseDto delete(Integer id) {
        EmpleadoDetalleHV detalleHV = empleadoDetalleHVRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EmpleadoDetalleHV", "id", id));

        empleadoDetalleHVRepository.delete(detalleHV);
        return new DeleteEmpleadoDetalleHVResponseDto(
                detalleHV.getId(),
                "Detalle de hoja de vida eliminado exitosamente"
        );
    }
}
