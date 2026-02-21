package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateDetalleTrabOTDto;
import com.tallermecanico.dto.request.UpdateDetalleTrabOTDto;
import com.tallermecanico.dto.response.DeleteDetalleTrabOTResponseDto;
import com.tallermecanico.entity.DetalleTrabOT;
import com.tallermecanico.entity.OrdenTrabajo;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.DetalleTrabOTRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleTrabOTService {

    private final DetalleTrabOTRepository detalleTrabOTRepository;
    private final OrdenTrabajoService ordenTrabajoService;

    public DetalleTrabOTService(DetalleTrabOTRepository detalleTrabOTRepository,
                                OrdenTrabajoService ordenTrabajoService) {
        this.detalleTrabOTRepository = detalleTrabOTRepository;
        this.ordenTrabajoService = ordenTrabajoService;
    }

    @Transactional
    public DetalleTrabOT create(CreateDetalleTrabOTDto dto) {
        DetalleTrabOT detalle = new DetalleTrabOT();

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findById(dto.getIdOrdenTrabajo());
            detalle.setOrdenTrabajo(ordenTrabajo);
        }

        detalle.setTrabajo(dto.getTrabajo());
        detalle.setTipo(dto.getTipo());

        return detalleTrabOTRepository.save(detalle);
    }

    @Transactional(readOnly = true)
    public List<DetalleTrabOT> findAll() {
        return detalleTrabOTRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DetalleTrabOT findById(Integer id) {
        return detalleTrabOTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleTrabOT", "id", id));
    }

    @Transactional(readOnly = true)
    public List<DetalleTrabOT> findByOrdenTrabajo(Integer idOrdenTrabajo) {
        return detalleTrabOTRepository.findByOrdenTrabajo_Id(idOrdenTrabajo);
    }

    @Transactional
    public DetalleTrabOT update(Integer id, UpdateDetalleTrabOTDto dto) {
        DetalleTrabOT detalle = detalleTrabOTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleTrabOT", "id", id));

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findById(dto.getIdOrdenTrabajo());
            detalle.setOrdenTrabajo(ordenTrabajo);
        }
        if (dto.getTrabajo() != null) {
            detalle.setTrabajo(dto.getTrabajo());
        }
        if (dto.getTipo() != null) {
            detalle.setTipo(dto.getTipo());
        }

        return detalleTrabOTRepository.save(detalle);
    }

    @Transactional
    public DeleteDetalleTrabOTResponseDto delete(Integer id) {
        DetalleTrabOT detalle = detalleTrabOTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleTrabOT", "id", id));

        detalleTrabOTRepository.delete(detalle);
        return new DeleteDetalleTrabOTResponseDto(
                detalle.getId(),
                "Detalle de trabajo OT eliminado exitosamente"
        );
    }
}
