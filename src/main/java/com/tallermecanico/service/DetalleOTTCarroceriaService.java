package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateDetalleOTTCarroceriaDto;
import com.tallermecanico.dto.request.UpdateDetalleOTTCarroceriaDto;
import com.tallermecanico.dto.response.DeleteDetalleOTTCarroceriaResponseDto;
import com.tallermecanico.entity.DetalleOTTCarroceria;
import com.tallermecanico.entity.OTCarroceria;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.DetalleOTTCarroceriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleOTTCarroceriaService {

    private final DetalleOTTCarroceriaRepository detalleOTTCarroceriaRepository;
    private final OTCarroceriaService otCarroceriaService;

    public DetalleOTTCarroceriaService(DetalleOTTCarroceriaRepository detalleOTTCarroceriaRepository,
                                        OTCarroceriaService otCarroceriaService) {
        this.detalleOTTCarroceriaRepository = detalleOTTCarroceriaRepository;
        this.otCarroceriaService = otCarroceriaService;
    }

    @Transactional
    public DetalleOTTCarroceria create(CreateDetalleOTTCarroceriaDto dto) {
        DetalleOTTCarroceria detalle = new DetalleOTTCarroceria();

        if (dto.getIdOtCarroceria() != null) {
            OTCarroceria otCarroceria = otCarroceriaService.findById(dto.getIdOtCarroceria());
            detalle.setOtCarroceria(otCarroceria);
        }

        detalle.setCodigo(dto.getCodigo());
        detalle.setInsumoRepuesto(dto.getInsumoRepuesto());
        detalle.setUnidad(dto.getUnidad());
        detalle.setCantidad(dto.getCantidad());
        detalle.setValor(dto.getValor());
        detalle.setArea(dto.getArea());

        return detalleOTTCarroceriaRepository.save(detalle);
    }

    @Transactional(readOnly = true)
    public List<DetalleOTTCarroceria> findAll() {
        return detalleOTTCarroceriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DetalleOTTCarroceria findById(Integer id) {
        return detalleOTTCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleOTTCarroceria", "id", id));
    }

    @Transactional(readOnly = true)
    public List<DetalleOTTCarroceria> findByOtCarroceria(Integer idOtCarroceria) {
        return detalleOTTCarroceriaRepository.findByOtCarroceria_Id(idOtCarroceria);
    }

    @Transactional
    public DetalleOTTCarroceria update(Integer id, UpdateDetalleOTTCarroceriaDto dto) {
        DetalleOTTCarroceria detalle = detalleOTTCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleOTTCarroceria", "id", id));

        if (dto.getIdOtCarroceria() != null) {
            OTCarroceria otCarroceria = otCarroceriaService.findById(dto.getIdOtCarroceria());
            detalle.setOtCarroceria(otCarroceria);
        }
        if (dto.getCodigo() != null) {
            detalle.setCodigo(dto.getCodigo());
        }
        if (dto.getInsumoRepuesto() != null) {
            detalle.setInsumoRepuesto(dto.getInsumoRepuesto());
        }
        if (dto.getUnidad() != null) {
            detalle.setUnidad(dto.getUnidad());
        }
        if (dto.getCantidad() != null) {
            detalle.setCantidad(dto.getCantidad());
        }
        if (dto.getValor() != null) {
            detalle.setValor(dto.getValor());
        }
        if (dto.getArea() != null) {
            detalle.setArea(dto.getArea());
        }

        return detalleOTTCarroceriaRepository.save(detalle);
    }

    @Transactional
    public DeleteDetalleOTTCarroceriaResponseDto delete(Integer id) {
        DetalleOTTCarroceria detalle = detalleOTTCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleOTTCarroceria", "id", id));

        detalleOTTCarroceriaRepository.delete(detalle);
        return new DeleteDetalleOTTCarroceriaResponseDto(
                detalle.getId(),
                "Detalle de OT carrocería eliminado exitosamente"
        );
    }
}
