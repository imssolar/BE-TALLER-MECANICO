package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateRepuestoCarroceriaDto;
import com.tallermecanico.dto.request.UpdateRepuestoCarroceriaDto;
import com.tallermecanico.dto.response.DeleteRepuestoCarroceriaResponseDto;
import com.tallermecanico.entity.RepuestoCarroceria;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.RepuestoCarroceriaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepuestoCarroceriaService {

    private final RepuestoCarroceriaRepository repuestoCarroceriaRepository;

    public RepuestoCarroceriaService(RepuestoCarroceriaRepository repuestoCarroceriaRepository) {
        this.repuestoCarroceriaRepository = repuestoCarroceriaRepository;
    }

    @Transactional
    public RepuestoCarroceria create(CreateRepuestoCarroceriaDto dto) {
        String repuestoNormalizado = TextUtils.normalizeText(dto.getRepuesto());

        if (repuestoCarroceriaRepository.existsByRepuestoIgnoreCase(repuestoNormalizado)) {
            throw new DuplicateResourceException("RepuestoCarroceria", "repuesto", dto.getRepuesto());
        }

        RepuestoCarroceria repuestoCarroceria = new RepuestoCarroceria();
        repuestoCarroceria.setRepuesto(repuestoNormalizado);
        repuestoCarroceria.setStock(dto.getStock());
        repuestoCarroceria.setUnidad(dto.getUnidad());
        repuestoCarroceria.setValor(dto.getValor());
        repuestoCarroceria.setGrupo(dto.getGrupo());

        return repuestoCarroceriaRepository.save(repuestoCarroceria);
    }

    @Transactional(readOnly = true)
    public List<RepuestoCarroceria> findAll() {
        return repuestoCarroceriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RepuestoCarroceria findById(Integer id) {
        return repuestoCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RepuestoCarroceria", "id", id));
    }

    @Transactional
    public RepuestoCarroceria update(Integer id, UpdateRepuestoCarroceriaDto dto) {
        RepuestoCarroceria repuestoCarroceria = repuestoCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RepuestoCarroceria", "id", id));

        if (dto.getRepuesto() != null) {
            String repuestoNormalizado = TextUtils.normalizeText(dto.getRepuesto());

            if (repuestoCarroceriaRepository.existsByRepuestoIgnoreCaseAndIdNot(repuestoNormalizado, id)) {
                throw new DuplicateResourceException("RepuestoCarroceria", "repuesto", dto.getRepuesto());
            }

            repuestoCarroceria.setRepuesto(repuestoNormalizado);
        }

        if (dto.getStock() != null) {
            repuestoCarroceria.setStock(dto.getStock());
        }

        if (dto.getUnidad() != null) {
            repuestoCarroceria.setUnidad(dto.getUnidad());
        }

        if (dto.getValor() != null) {
            repuestoCarroceria.setValor(dto.getValor());
        }

        if (dto.getGrupo() != null) {
            repuestoCarroceria.setGrupo(dto.getGrupo());
        }

        return repuestoCarroceriaRepository.save(repuestoCarroceria);
    }

    @Transactional
    public DeleteRepuestoCarroceriaResponseDto delete(Integer id) {
        RepuestoCarroceria repuestoCarroceria = repuestoCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RepuestoCarroceria", "id", id));

        repuestoCarroceriaRepository.delete(repuestoCarroceria);
        return new DeleteRepuestoCarroceriaResponseDto(
                repuestoCarroceria.getId(),
                repuestoCarroceria.getRepuesto(),
                "Repuesto de carrocería eliminado exitosamente"
        );
    }
}
