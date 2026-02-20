package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateProveedorDto;
import com.tallermecanico.dto.request.UpdateProveedorDto;
import com.tallermecanico.dto.response.DeleteProveedorResponseDto;
import com.tallermecanico.entity.Ciudad;
import com.tallermecanico.entity.Comuna;
import com.tallermecanico.entity.Proveedor;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;
    private final ComunaService comunaService;
    private final CiudadService ciudadService;

    public ProveedorService(ProveedorRepository proveedorRepository,
                            ComunaService comunaService,
                            CiudadService ciudadService) {
        this.proveedorRepository = proveedorRepository;
        this.comunaService = comunaService;
        this.ciudadService = ciudadService;
    }

    @Transactional
    public Proveedor create(CreateProveedorDto dto) {
        if (proveedorRepository.existsByRut(dto.getRut())) {
            throw new DuplicateResourceException("Proveedor", "rut", dto.getRut());
        }

        Proveedor proveedor = new Proveedor();
        proveedor.setRut(dto.getRut());
        proveedor.setRazonSocial(dto.getRazonSocial());
        proveedor.setDireccion(dto.getDireccion());
        proveedor.setFono1(dto.getFono1());
        proveedor.setFono2(dto.getFono2());
        proveedor.setEmail(dto.getEmail());
        proveedor.setContacto(dto.getContacto());
        proveedor.setFonoContacto(dto.getFonoContacto());
        proveedor.setArea(dto.getArea());

        if (dto.getIdComuna() != null) {
            Comuna comuna = comunaService.findById(dto.getIdComuna());
            proveedor.setComuna(comuna);
        }
        if (dto.getIdCiudad() != null) {
            Ciudad ciudad = ciudadService.findById(dto.getIdCiudad());
            proveedor.setCiudad(ciudad);
        }

        return proveedorRepository.save(proveedor);
    }

    @Transactional(readOnly = true)
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Proveedor findById(Integer id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", id));
    }

    @Transactional
    public Proveedor update(Integer id, UpdateProveedorDto dto) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", id));

        if (dto.getRut() != null && proveedorRepository.existsByRutAndIdNot(dto.getRut(), id)) {
            throw new DuplicateResourceException("Proveedor", "rut", dto.getRut());
        }

        if (dto.getRut() != null) {
            proveedor.setRut(dto.getRut());
        }
        if (dto.getRazonSocial() != null) {
            proveedor.setRazonSocial(dto.getRazonSocial());
        }
        if (dto.getDireccion() != null) {
            proveedor.setDireccion(dto.getDireccion());
        }
        if (dto.getFono1() != null) {
            proveedor.setFono1(dto.getFono1());
        }
        if (dto.getFono2() != null) {
            proveedor.setFono2(dto.getFono2());
        }
        if (dto.getEmail() != null) {
            proveedor.setEmail(dto.getEmail());
        }
        if (dto.getContacto() != null) {
            proveedor.setContacto(dto.getContacto());
        }
        if (dto.getFonoContacto() != null) {
            proveedor.setFonoContacto(dto.getFonoContacto());
        }
        if (dto.getArea() != null) {
            proveedor.setArea(dto.getArea());
        }

        if (dto.getIdComuna() != null) {
            Comuna comuna = comunaService.findById(dto.getIdComuna());
            proveedor.setComuna(comuna);
        }
        if (dto.getIdCiudad() != null) {
            Ciudad ciudad = ciudadService.findById(dto.getIdCiudad());
            proveedor.setCiudad(ciudad);
        }

        return proveedorRepository.save(proveedor);
    }

    @Transactional
    public DeleteProveedorResponseDto delete(Integer id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", id));

        proveedorRepository.delete(proveedor);
        return new DeleteProveedorResponseDto(
                proveedor.getId(),
                proveedor.getRazonSocial(),
                "Proveedor eliminado exitosamente"
        );
    }
}
