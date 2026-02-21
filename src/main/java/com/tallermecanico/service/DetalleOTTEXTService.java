package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateDetalleOTTEXTDto;
import com.tallermecanico.dto.request.UpdateDetalleOTTEXTDto;
import com.tallermecanico.dto.response.DeleteDetalleOTTEXTResponseDto;
import com.tallermecanico.entity.DetalleOTTEXT;
import com.tallermecanico.entity.OTTallerExt;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.DetalleOTTEXTRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleOTTEXTService {

    private final DetalleOTTEXTRepository detalleOTTEXTRepository;
    private final OTTallerExtService otTallerExtService;

    public DetalleOTTEXTService(DetalleOTTEXTRepository detalleOTTEXTRepository,
                                OTTallerExtService otTallerExtService) {
        this.detalleOTTEXTRepository = detalleOTTEXTRepository;
        this.otTallerExtService = otTallerExtService;
    }

    @Transactional
    public DetalleOTTEXT create(CreateDetalleOTTEXTDto dto) {
        DetalleOTTEXT detalle = new DetalleOTTEXT();

        if (dto.getIdOtTallerExt() != null) {
            OTTallerExt otTallerExt = otTallerExtService.findById(dto.getIdOtTallerExt());
            detalle.setOtTallerExt(otTallerExt);
        }

        detalle.setCantidad(dto.getCantidad());
        detalle.setDescripcion(dto.getDescripcion());
        detalle.setPrecio(dto.getPrecio());
        detalle.setTipo(dto.getTipo());

        return detalleOTTEXTRepository.save(detalle);
    }

    @Transactional(readOnly = true)
    public List<DetalleOTTEXT> findAll() {
        return detalleOTTEXTRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DetalleOTTEXT findById(Integer id) {
        return detalleOTTEXTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleOTTEXT", "id", id));
    }

    @Transactional(readOnly = true)
    public List<DetalleOTTEXT> findByOtTallerExt(Integer idOtTallerExt) {
        return detalleOTTEXTRepository.findByOtTallerExt_Id(idOtTallerExt);
    }

    @Transactional
    public DetalleOTTEXT update(Integer id, UpdateDetalleOTTEXTDto dto) {
        DetalleOTTEXT detalle = detalleOTTEXTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleOTTEXT", "id", id));

        if (dto.getIdOtTallerExt() != null) {
            OTTallerExt otTallerExt = otTallerExtService.findById(dto.getIdOtTallerExt());
            detalle.setOtTallerExt(otTallerExt);
        }
        if (dto.getCantidad() != null) {
            detalle.setCantidad(dto.getCantidad());
        }
        if (dto.getDescripcion() != null) {
            detalle.setDescripcion(dto.getDescripcion());
        }
        if (dto.getPrecio() != null) {
            detalle.setPrecio(dto.getPrecio());
        }
        if (dto.getTipo() != null) {
            detalle.setTipo(dto.getTipo());
        }

        return detalleOTTEXTRepository.save(detalle);
    }

    @Transactional
    public DeleteDetalleOTTEXTResponseDto delete(Integer id) {
        DetalleOTTEXT detalle = detalleOTTEXTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleOTTEXT", "id", id));

        detalleOTTEXTRepository.delete(detalle);
        return new DeleteDetalleOTTEXTResponseDto(
                detalle.getId(),
                "Detalle de OT taller externo eliminado exitosamente"
        );
    }
}
