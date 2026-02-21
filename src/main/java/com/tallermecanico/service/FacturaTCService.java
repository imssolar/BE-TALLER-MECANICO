package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateFacturaTCDto;
import com.tallermecanico.dto.request.UpdateFacturaTCDto;
import com.tallermecanico.dto.response.DeleteFacturaTCResponseDto;
import com.tallermecanico.entity.FacturaTC;
import com.tallermecanico.entity.Proveedor;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.FacturaTCRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaTCService {

    private final FacturaTCRepository facturaTCRepository;
    private final ProveedorService proveedorService;
    private final TerminalService terminalService;

    public FacturaTCService(FacturaTCRepository facturaTCRepository,
                            ProveedorService proveedorService,
                            TerminalService terminalService) {
        this.facturaTCRepository = facturaTCRepository;
        this.proveedorService = proveedorService;
        this.terminalService = terminalService;
    }

    @Transactional
    public FacturaTC create(CreateFacturaTCDto dto) {
        FacturaTC facturaTC = new FacturaTC();
        facturaTC.setNumeroFactura(dto.getNumeroFactura());
        facturaTC.setFecha(dto.getFecha());

        if (dto.getIdProveedor() != null) {
            Proveedor proveedor = proveedorService.findById(dto.getIdProveedor());
            facturaTC.setProveedor(proveedor);
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            facturaTC.setTerminal(terminal);
        }

        return facturaTCRepository.save(facturaTC);
    }

    @Transactional(readOnly = true)
    public List<FacturaTC> findAll() {
        return facturaTCRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<FacturaTC> findByProveedor(Integer idProveedor) {
        return facturaTCRepository.findByProveedor_Id(idProveedor);
    }

    @Transactional(readOnly = true)
    public List<FacturaTC> findByTerminal(Integer idTerminal) {
        return facturaTCRepository.findByTerminal_IdTerminal(idTerminal);
    }

    @Transactional(readOnly = true)
    public FacturaTC findById(Integer id) {
        return facturaTCRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaTC", "id", id));
    }

    @Transactional
    public FacturaTC update(Integer id, UpdateFacturaTCDto dto) {
        FacturaTC facturaTC = facturaTCRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaTC", "id", id));

        if (dto.getNumeroFactura() != null) {
            facturaTC.setNumeroFactura(dto.getNumeroFactura());
        }
        if (dto.getFecha() != null) {
            facturaTC.setFecha(dto.getFecha());
        }
        if (dto.getIdProveedor() != null) {
            Proveedor proveedor = proveedorService.findById(dto.getIdProveedor());
            facturaTC.setProveedor(proveedor);
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            facturaTC.setTerminal(terminal);
        }

        return facturaTCRepository.save(facturaTC);
    }

    @Transactional
    public DeleteFacturaTCResponseDto delete(Integer id) {
        FacturaTC facturaTC = facturaTCRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaTC", "id", id));

        facturaTCRepository.delete(facturaTC);
        return new DeleteFacturaTCResponseDto(
                facturaTC.getId(),
                "Factura de taller de carrocería eliminada exitosamente"
        );
    }
}
