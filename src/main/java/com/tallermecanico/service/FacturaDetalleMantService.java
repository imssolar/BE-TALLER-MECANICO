package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateFacturaDetalleMantDto;
import com.tallermecanico.dto.request.UpdateFacturaDetalleMantDto;
import com.tallermecanico.dto.response.DeleteFacturaDetalleMantResponseDto;
import com.tallermecanico.entity.FacturaDetalleMant;
import com.tallermecanico.entity.FacturaMant;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.FacturaDetalleMantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaDetalleMantService {

    private final FacturaDetalleMantRepository facturaDetalleMantRepository;
    private final FacturaMantService facturaMantService;

    public FacturaDetalleMantService(FacturaDetalleMantRepository facturaDetalleMantRepository,
                                     FacturaMantService facturaMantService) {
        this.facturaDetalleMantRepository = facturaDetalleMantRepository;
        this.facturaMantService = facturaMantService;
    }

    @Transactional
    public FacturaDetalleMant create(CreateFacturaDetalleMantDto dto) {
        FacturaDetalleMant detalle = new FacturaDetalleMant();

        FacturaMant factura = facturaMantService.findById(dto.getIdFactura());
        detalle.setFactura(factura);

        detalle.setIdRepuesto(dto.getIdRepuesto());
        detalle.setRepuesto(dto.getRepuesto());
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecio(dto.getPrecio());

        return facturaDetalleMantRepository.save(detalle);
    }

    @Transactional(readOnly = true)
    public List<FacturaDetalleMant> findAll() {
        return facturaDetalleMantRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<FacturaDetalleMant> findByFactura(Integer idFactura) {
        return facturaDetalleMantRepository.findByFactura_Id(idFactura);
    }

    @Transactional(readOnly = true)
    public FacturaDetalleMant findById(Integer id) {
        return facturaDetalleMantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaDetalleMant", "id", id));
    }

    @Transactional
    public FacturaDetalleMant update(Integer id, UpdateFacturaDetalleMantDto dto) {
        FacturaDetalleMant detalle = facturaDetalleMantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaDetalleMant", "id", id));

        if (dto.getIdFactura() != null) {
            FacturaMant factura = facturaMantService.findById(dto.getIdFactura());
            detalle.setFactura(factura);
        }
        if (dto.getIdRepuesto() != null) {
            detalle.setIdRepuesto(dto.getIdRepuesto());
        }
        if (dto.getRepuesto() != null) {
            detalle.setRepuesto(dto.getRepuesto());
        }
        if (dto.getCantidad() != null) {
            detalle.setCantidad(dto.getCantidad());
        }
        if (dto.getPrecio() != null) {
            detalle.setPrecio(dto.getPrecio());
        }

        return facturaDetalleMantRepository.save(detalle);
    }

    @Transactional
    public DeleteFacturaDetalleMantResponseDto delete(Integer id) {
        FacturaDetalleMant detalle = facturaDetalleMantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaDetalleMant", "id", id));

        facturaDetalleMantRepository.delete(detalle);
        return new DeleteFacturaDetalleMantResponseDto(
                detalle.getId(),
                "Detalle de factura de mantenimiento eliminado exitosamente"
        );
    }
}
