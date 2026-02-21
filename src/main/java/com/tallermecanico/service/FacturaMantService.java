package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateFacturaMantDto;
import com.tallermecanico.dto.request.UpdateFacturaMantDto;
import com.tallermecanico.dto.response.DeleteFacturaMantResponseDto;
import com.tallermecanico.entity.FacturaMant;
import com.tallermecanico.entity.Glosa;
import com.tallermecanico.entity.Proveedor;
import com.tallermecanico.entity.TallerExterno;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.FacturaMantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaMantService {

    private final FacturaMantRepository facturaMantRepository;
    private final ProveedorService proveedorService;
    private final GlosaService glosaService;
    private final TallerExternoService tallerExternoService;

    public FacturaMantService(FacturaMantRepository facturaMantRepository,
                              ProveedorService proveedorService,
                              GlosaService glosaService,
                              TallerExternoService tallerExternoService) {
        this.facturaMantRepository = facturaMantRepository;
        this.proveedorService = proveedorService;
        this.glosaService = glosaService;
        this.tallerExternoService = tallerExternoService;
    }

    @Transactional
    public FacturaMant create(CreateFacturaMantDto dto) {
        FacturaMant facturaMant = new FacturaMant();

        if (dto.getIdProveedor() != null) {
            Proveedor proveedor = proveedorService.findById(dto.getIdProveedor());
            facturaMant.setProveedor(proveedor);
        }

        facturaMant.setNumeroFactura(dto.getNumeroFactura());
        facturaMant.setFecha(dto.getFecha());
        facturaMant.setModelo(dto.getModelo());

        if (dto.getIdGlosa() != null) {
            Glosa glosa = glosaService.findById(dto.getIdGlosa());
            facturaMant.setGlosa(glosa);
        }

        if (dto.getIdTallerExterno() != null) {
            TallerExterno tallerExterno = tallerExternoService.findById(dto.getIdTallerExterno());
            facturaMant.setTallerExterno(tallerExterno);
        }

        return facturaMantRepository.save(facturaMant);
    }

    @Transactional(readOnly = true)
    public List<FacturaMant> findAll() {
        return facturaMantRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<FacturaMant> findByProveedor(Integer idProveedor) {
        return facturaMantRepository.findByProveedor_Id(idProveedor);
    }

    @Transactional(readOnly = true)
    public List<FacturaMant> findByTallerExterno(Integer idTallerExterno) {
        return facturaMantRepository.findByTallerExterno_Id(idTallerExterno);
    }

    @Transactional(readOnly = true)
    public FacturaMant findById(Integer id) {
        return facturaMantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaMant", "id", id));
    }

    @Transactional
    public FacturaMant update(Integer id, UpdateFacturaMantDto dto) {
        FacturaMant facturaMant = facturaMantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaMant", "id", id));

        if (dto.getIdProveedor() != null) {
            Proveedor proveedor = proveedorService.findById(dto.getIdProveedor());
            facturaMant.setProveedor(proveedor);
        }

        if (dto.getNumeroFactura() != null) {
            facturaMant.setNumeroFactura(dto.getNumeroFactura());
        }

        if (dto.getFecha() != null) {
            facturaMant.setFecha(dto.getFecha());
        }

        if (dto.getModelo() != null) {
            facturaMant.setModelo(dto.getModelo());
        }

        if (dto.getIdGlosa() != null) {
            Glosa glosa = glosaService.findById(dto.getIdGlosa());
            facturaMant.setGlosa(glosa);
        }

        if (dto.getIdTallerExterno() != null) {
            TallerExterno tallerExterno = tallerExternoService.findById(dto.getIdTallerExterno());
            facturaMant.setTallerExterno(tallerExterno);
        }

        return facturaMantRepository.save(facturaMant);
    }

    @Transactional
    public DeleteFacturaMantResponseDto delete(Integer id) {
        FacturaMant facturaMant = facturaMantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacturaMant", "id", id));

        facturaMantRepository.delete(facturaMant);
        return new DeleteFacturaMantResponseDto(
                facturaMant.getId(),
                "Factura de mantenimiento eliminada exitosamente"
        );
    }
}
