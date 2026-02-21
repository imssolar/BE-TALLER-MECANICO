package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateDetalleCapDto;
import com.tallermecanico.dto.request.UpdateDetalleCapDto;
import com.tallermecanico.dto.response.DeleteDetalleCapResponseDto;
import com.tallermecanico.entity.Capacitacion;
import com.tallermecanico.entity.DetalleCap;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.DetalleCapRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleCapService {

    private final DetalleCapRepository detalleCapRepository;
    private final CapacitacionService capacitacionService;

    public DetalleCapService(DetalleCapRepository detalleCapRepository,
                             CapacitacionService capacitacionService) {
        this.detalleCapRepository = detalleCapRepository;
        this.capacitacionService = capacitacionService;
    }

    @Transactional
    public DetalleCap create(CreateDetalleCapDto dto) {
        DetalleCap detalle = new DetalleCap();
        detalle.setNombre(dto.getNombre());
        detalle.setRun(dto.getRun());
        detalle.setNota(dto.getNota());
        detalle.setPorcentajeObtenido(dto.getPorcentajeObtenido());
        detalle.setPorcentajeAsistencia(dto.getPorcentajeAsistencia());

        if (dto.getIdCapacitacion() != null) {
            Capacitacion capacitacion = capacitacionService.findById(dto.getIdCapacitacion());
            detalle.setCapacitacion(capacitacion);
        }

        return detalleCapRepository.save(detalle);
    }

    @Transactional(readOnly = true)
    public List<DetalleCap> findAll() {
        return detalleCapRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DetalleCap findById(Integer id) {
        return detalleCapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleCap", "id", id));
    }

    @Transactional(readOnly = true)
    public List<DetalleCap> findByCapacitacion(Integer idCapacitacion) {
        return detalleCapRepository.findByCapacitacion_Id(idCapacitacion);
    }

    @Transactional(readOnly = true)
    public List<DetalleCap> findByRun(String run) {
        return detalleCapRepository.findByRun(run);
    }

    @Transactional
    public DetalleCap update(Integer id, UpdateDetalleCapDto dto) {
        DetalleCap detalle = detalleCapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleCap", "id", id));

        if (dto.getNombre() != null) {
            detalle.setNombre(dto.getNombre());
        }
        if (dto.getRun() != null) {
            detalle.setRun(dto.getRun());
        }
        if (dto.getNota() != null) {
            detalle.setNota(dto.getNota());
        }
        if (dto.getPorcentajeObtenido() != null) {
            detalle.setPorcentajeObtenido(dto.getPorcentajeObtenido());
        }
        if (dto.getPorcentajeAsistencia() != null) {
            detalle.setPorcentajeAsistencia(dto.getPorcentajeAsistencia());
        }

        if (dto.getIdCapacitacion() != null) {
            Capacitacion capacitacion = capacitacionService.findById(dto.getIdCapacitacion());
            detalle.setCapacitacion(capacitacion);
        }

        return detalleCapRepository.save(detalle);
    }

    @Transactional
    public DeleteDetalleCapResponseDto delete(Integer id) {
        DetalleCap detalle = detalleCapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleCap", "id", id));

        detalleCapRepository.delete(detalle);
        return new DeleteDetalleCapResponseDto(
                detalle.getId(),
                "Detalle de capacitación eliminado exitosamente"
        );
    }
}
