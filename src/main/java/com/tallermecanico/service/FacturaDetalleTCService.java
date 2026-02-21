package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateFacturaDetalleTCDto;
import com.tallermecanico.dto.request.UpdateFacturaDetalleTCDto;
import com.tallermecanico.dto.response.DeleteFacturaDetalleTCResponseDto;
import com.tallermecanico.entity.FacturaDetalleTC;
import com.tallermecanico.entity.FacturaTC;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.FacturaDetalleTCRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaDetalleTCService {

    private final FacturaDetalleTCRepository facturaDetalleTCRepository;
    private final FacturaTCService facturaTCService;

    public FacturaDetalleTCService(FacturaDetalleTCRepository facturaDetalleTCRepository,
                                   FacturaTCService facturaTCService) {
        this.facturaDetalleTCRepository = facturaDetalleTCRepository;
        this.facturaTCService = facturaTCService;
    }

    @Transactional
    public FacturaDetalleTC create(CreateFacturaDetalleTCDto dto) {
        FacturaDetalleTC facturaDetalleTC = new FacturaDetalleTC();

        FacturaTC factura = facturaTCService.findById(dto.getIdFactura());
        facturaDetalleTC.setFactura(factura);

        facturaDetalleTC.setIdRepuesto(dto.getIdRepuesto());
        facturaDetalleTC.setRepuesto(dto.getRepuesto());
        facturaDetalleTC.setCantidad(dto.getCantidad());
        facturaDetalleTC.setPrecio(dto.getPrecio());

        return facturaDetalleTCRepository.save(facturaDetalleTC);
    }

    @Transactional(readOnly = true)
    public List<FacturaDetalleTC> findAll() {
        return facturaDetalleTCRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<FacturaDetalleTC> findByFactura(Integer idFactura) {
        return facturaDetalleTCRepository.findByFactura_Id(idFactura);
    }

    @Transactional(readOnly = true)
    public FacturaDetalleTC findById(Integer id) {
        return facturaDetalleTCRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaDetalleTC", "id", id));
    }

    @Transactional
    public FacturaDetalleTC update(Integer id, UpdateFacturaDetalleTCDto dto) {
        FacturaDetalleTC facturaDetalleTC = facturaDetalleTCRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaDetalleTC", "id", id));

        if (dto.getIdFactura() != null) {
            FacturaTC factura = facturaTCService.findById(dto.getIdFactura());
            facturaDetalleTC.setFactura(factura);
        }
        if (dto.getIdRepuesto() != null) {
            facturaDetalleTC.setIdRepuesto(dto.getIdRepuesto());
        }
        if (dto.getRepuesto() != null) {
            facturaDetalleTC.setRepuesto(dto.getRepuesto());
        }
        if (dto.getCantidad() != null) {
            facturaDetalleTC.setCantidad(dto.getCantidad());
        }
        if (dto.getPrecio() != null) {
            facturaDetalleTC.setPrecio(dto.getPrecio());
        }

        return facturaDetalleTCRepository.save(facturaDetalleTC);
    }

    @Transactional
    public DeleteFacturaDetalleTCResponseDto delete(Integer id) {
        FacturaDetalleTC facturaDetalleTC = facturaDetalleTCRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaDetalleTC", "id", id));

        facturaDetalleTCRepository.delete(facturaDetalleTC);
        return new DeleteFacturaDetalleTCResponseDto(
                facturaDetalleTC.getId(),
                "Detalle de factura de taller de carrocería eliminado exitosamente"
        );
    }
}
