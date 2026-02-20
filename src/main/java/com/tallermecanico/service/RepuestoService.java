package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateRepuestoDto;
import com.tallermecanico.dto.request.UpdateRepuestoDto;
import com.tallermecanico.dto.response.DeleteRepuestoResponseDto;
import com.tallermecanico.entity.Repuesto;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.RepuestoRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepuestoService {

    private final RepuestoRepository repuestoRepository;

    public RepuestoService(RepuestoRepository repuestoRepository) {
        this.repuestoRepository = repuestoRepository;
    }

    @Transactional
    public Repuesto create(CreateRepuestoDto dto) {
        String repuestoNormalizado = TextUtils.normalizeText(dto.getRepuesto());

        if (repuestoRepository.existsByRepuestoIgnoreCase(repuestoNormalizado)) {
            throw new DuplicateResourceException("Repuesto", "repuesto", dto.getRepuesto());
        }

        Repuesto repuesto = new Repuesto();
        repuesto.setRepuesto(repuestoNormalizado);
        repuesto.setCosto(dto.getCosto());
        repuesto.setStock(dto.getStock());

        return repuestoRepository.save(repuesto);
    }

    @Transactional(readOnly = true)
    public List<Repuesto> findAll() {
        return repuestoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Repuesto findById(Integer id) {
        return repuestoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Repuesto", "id", id));
    }

    @Transactional
    public Repuesto update(Integer id, UpdateRepuestoDto dto) {
        Repuesto repuesto = repuestoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Repuesto", "id", id));

        if (dto.getRepuesto() != null) {
            String repuestoNormalizado = TextUtils.normalizeText(dto.getRepuesto());

            if (repuestoRepository.existsByRepuestoIgnoreCaseAndIdNot(repuestoNormalizado, id)) {
                throw new DuplicateResourceException("Repuesto", "repuesto", dto.getRepuesto());
            }

            repuesto.setRepuesto(repuestoNormalizado);
        }

        if (dto.getCosto() != null) {
            repuesto.setCosto(dto.getCosto());
        }

        if (dto.getStock() != null) {
            repuesto.setStock(dto.getStock());
        }

        return repuestoRepository.save(repuesto);
    }

    @Transactional
    public DeleteRepuestoResponseDto delete(Integer id) {
        Repuesto repuesto = repuestoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Repuesto", "id", id));

        repuestoRepository.delete(repuesto);
        return new DeleteRepuestoResponseDto(
                repuesto.getId(),
                repuesto.getRepuesto(),
                "Repuesto eliminado exitosamente"
        );
    }
}
