package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateDetalleMTTOTDto;
import com.tallermecanico.dto.request.UpdateDetalleMTTOTDto;
import com.tallermecanico.dto.response.DeleteDetalleMTTOTResponseDto;
import com.tallermecanico.entity.DetalleMTTOT;
import com.tallermecanico.entity.OrdenTrabajo;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.DetalleMTTOTRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleMTTOTService {

    private final DetalleMTTOTRepository detalleMTTOTRepository;
    private final OrdenTrabajoService ordenTrabajoService;

    public DetalleMTTOTService(DetalleMTTOTRepository detalleMTTOTRepository,
                               OrdenTrabajoService ordenTrabajoService) {
        this.detalleMTTOTRepository = detalleMTTOTRepository;
        this.ordenTrabajoService = ordenTrabajoService;
    }

    @Transactional
    public DetalleMTTOT create(CreateDetalleMTTOTDto dto) {
        DetalleMTTOT detalle = new DetalleMTTOT();
        detalle.setIdMtt(dto.getIdMtt());
        detalle.setLitrosMtt(dto.getLitrosMtt());

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findById(dto.getIdOrdenTrabajo());
            detalle.setOrdenTrabajo(ordenTrabajo);
        }

        return detalleMTTOTRepository.save(detalle);
    }

    @Transactional(readOnly = true)
    public List<DetalleMTTOT> findAll() {
        return detalleMTTOTRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DetalleMTTOT findById(Integer id) {
        return detalleMTTOTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleMTTOT", "id", id));
    }

    @Transactional(readOnly = true)
    public List<DetalleMTTOT> findByOrdenTrabajo(Integer idOrdenTrabajo) {
        return detalleMTTOTRepository.findByOrdenTrabajo_Id(idOrdenTrabajo);
    }

    @Transactional
    public DetalleMTTOT update(Integer id, UpdateDetalleMTTOTDto dto) {
        DetalleMTTOT detalle = detalleMTTOTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleMTTOT", "id", id));

        if (dto.getIdOrdenTrabajo() != null) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.findById(dto.getIdOrdenTrabajo());
            detalle.setOrdenTrabajo(ordenTrabajo);
        }
        if (dto.getIdMtt() != null) {
            detalle.setIdMtt(dto.getIdMtt());
        }
        if (dto.getLitrosMtt() != null) {
            detalle.setLitrosMtt(dto.getLitrosMtt());
        }

        return detalleMTTOTRepository.save(detalle);
    }

    @Transactional
    public DeleteDetalleMTTOTResponseDto delete(Integer id) {
        DetalleMTTOT detalle = detalleMTTOTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleMTTOT", "id", id));

        detalleMTTOTRepository.delete(detalle);
        return new DeleteDetalleMTTOTResponseDto(
                detalle.getId(),
                "Detalle MTT OT eliminado exitosamente"
        );
    }
}
