package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateCostoSMDto;
import com.tallermecanico.dto.request.UpdateCostoSMDto;
import com.tallermecanico.dto.response.DeleteCostoSMResponseDto;
import com.tallermecanico.entity.CostoSM;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.CostoSMRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CostoSMService {

    private final CostoSMRepository costoSMRepository;

    public CostoSMService(CostoSMRepository costoSMRepository) {
        this.costoSMRepository = costoSMRepository;
    }

    @Transactional
    public CostoSM create(CreateCostoSMDto dto) {
        CostoSM costoSM = new CostoSM();
        costoSM.setPautaSm(dto.getPautaSm());
        costoSM.setModelo(dto.getModelo());
        costoSM.setNroOtManager(dto.getNroOtManager());
        costoSM.setProducto(dto.getProducto());
        costoSM.setCantidad(dto.getCantidad());
        costoSM.setValorPromedio(dto.getValorPromedio());
        costoSM.setHorasHombre(dto.getHorasHombre());
        costoSM.setFechaIngreso(dto.getFechaIngreso());

        return costoSMRepository.save(costoSM);
    }

    @Transactional(readOnly = true)
    public List<CostoSM> findAll() {
        return costoSMRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CostoSM findById(Integer id) {
        return costoSMRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CostoSM", "id", id));
    }

    @Transactional
    public CostoSM update(Integer id, UpdateCostoSMDto dto) {
        CostoSM costoSM = costoSMRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CostoSM", "id", id));

        if (dto.getPautaSm() != null) {
            costoSM.setPautaSm(dto.getPautaSm());
        }

        if (dto.getModelo() != null) {
            costoSM.setModelo(dto.getModelo());
        }

        if (dto.getNroOtManager() != null) {
            costoSM.setNroOtManager(dto.getNroOtManager());
        }

        if (dto.getProducto() != null) {
            costoSM.setProducto(dto.getProducto());
        }

        if (dto.getCantidad() != null) {
            costoSM.setCantidad(dto.getCantidad());
        }

        if (dto.getValorPromedio() != null) {
            costoSM.setValorPromedio(dto.getValorPromedio());
        }

        if (dto.getHorasHombre() != null) {
            costoSM.setHorasHombre(dto.getHorasHombre());
        }

        if (dto.getFechaIngreso() != null) {
            costoSM.setFechaIngreso(dto.getFechaIngreso());
        }

        return costoSMRepository.save(costoSM);
    }

    @Transactional
    public DeleteCostoSMResponseDto delete(Integer id) {
        CostoSM costoSM = costoSMRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CostoSM", "id", id));

        costoSMRepository.delete(costoSM);
        return new DeleteCostoSMResponseDto(
                costoSM.getId(),
                costoSM.getPautaSm(),
                "Costo SM eliminado exitosamente"
        );
    }
}
