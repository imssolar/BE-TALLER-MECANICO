package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateDetalleEHDto;
import com.tallermecanico.dto.request.UpdateDetalleEHDto;
import com.tallermecanico.dto.response.DeleteDetalleEHResponseDto;
import com.tallermecanico.entity.DetalleEH;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.DetalleEHRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleEHService {

    private final DetalleEHRepository detalleEHRepository;

    public DetalleEHService(DetalleEHRepository detalleEHRepository) {
        this.detalleEHRepository = detalleEHRepository;
    }

    @Transactional
    public DetalleEH create(CreateDetalleEHDto dto) {
        DetalleEH detalleEH = new DetalleEH();
        detalleEH.setRut(dto.getRut());
        detalleEH.setTipoEntrega(dto.getTipoEntrega());
        detalleEH.setEquipHerram(dto.getEquipHerram());
        detalleEH.setFechaEntrega(dto.getFechaEntrega());
        detalleEH.setEntregadoPor(dto.getEntregadoPor());
        detalleEH.setCantidad(dto.getCantidad());
        detalleEH.setCosto(dto.getCosto());
        detalleEH.setDevuelto(dto.getDevuelto());
        detalleEH.setFechaDevolucion(dto.getFechaDevolucion());
        detalleEH.setCantDevuelta(dto.getCantDevuelta());
        detalleEH.setPendiente(dto.getPendiente());
        detalleEH.setProxCambio(dto.getProxCambio());
        detalleEH.setTipoDev(dto.getTipoDev());

        return detalleEHRepository.save(detalleEH);
    }

    @Transactional(readOnly = true)
    public List<DetalleEH> findAll() {
        return detalleEHRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DetalleEH findById(Integer id) {
        return detalleEHRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleEH", "id", id));
    }

    @Transactional(readOnly = true)
    public List<DetalleEH> findByRut(String rut) {
        return detalleEHRepository.findByRut(rut);
    }

    @Transactional
    public DetalleEH update(Integer id, UpdateDetalleEHDto dto) {
        DetalleEH detalleEH = findById(id);

        if (dto.getRut() != null) {
            detalleEH.setRut(dto.getRut());
        }
        if (dto.getTipoEntrega() != null) {
            detalleEH.setTipoEntrega(dto.getTipoEntrega());
        }
        if (dto.getEquipHerram() != null) {
            detalleEH.setEquipHerram(dto.getEquipHerram());
        }
        if (dto.getFechaEntrega() != null) {
            detalleEH.setFechaEntrega(dto.getFechaEntrega());
        }
        if (dto.getEntregadoPor() != null) {
            detalleEH.setEntregadoPor(dto.getEntregadoPor());
        }
        if (dto.getCantidad() != null) {
            detalleEH.setCantidad(dto.getCantidad());
        }
        if (dto.getCosto() != null) {
            detalleEH.setCosto(dto.getCosto());
        }
        if (dto.getDevuelto() != null) {
            detalleEH.setDevuelto(dto.getDevuelto());
        }
        if (dto.getFechaDevolucion() != null) {
            detalleEH.setFechaDevolucion(dto.getFechaDevolucion());
        }
        if (dto.getCantDevuelta() != null) {
            detalleEH.setCantDevuelta(dto.getCantDevuelta());
        }
        if (dto.getPendiente() != null) {
            detalleEH.setPendiente(dto.getPendiente());
        }
        if (dto.getProxCambio() != null) {
            detalleEH.setProxCambio(dto.getProxCambio());
        }
        if (dto.getTipoDev() != null) {
            detalleEH.setTipoDev(dto.getTipoDev());
        }

        return detalleEHRepository.save(detalleEH);
    }

    @Transactional
    public DeleteDetalleEHResponseDto delete(Integer id) {
        DetalleEH detalleEH = findById(id);
        detalleEHRepository.delete(detalleEH);
        return new DeleteDetalleEHResponseDto(detalleEH.getId());
    }
}
