package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateComunaDto;
import com.tallermecanico.dto.request.UpdateComunaDto;
import com.tallermecanico.dto.response.DeleteComunaResponseDto;
import com.tallermecanico.entity.Comuna;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ComunaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComunaService {

    private final ComunaRepository comunaRepository;

    public ComunaService(ComunaRepository comunaRepository) {
        this.comunaRepository = comunaRepository;
    }

    @Transactional
    public Comuna create(CreateComunaDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getComuna());

        if (comunaRepository.existsByComunaIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Comuna", "comuna", dto.getComuna());
        }

        Comuna comuna = new Comuna();
        comuna.setComuna(nombreNormalizado);

        return comunaRepository.save(comuna);
    }

    @Transactional(readOnly = true)
    public List<Comuna> findAll() {
        return comunaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Comuna findById(Integer id) {
        return comunaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comuna", "id", id));
    }

    @Transactional
    public Comuna update(Integer id, UpdateComunaDto dto) {
        Comuna comuna = comunaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comuna", "id", id));

        if (dto.getComuna() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getComuna());

            if (comunaRepository.existsByComunaIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Comuna", "comuna", dto.getComuna());
            }

            comuna.setComuna(nombreNormalizado);
        }

        return comunaRepository.save(comuna);
    }

    @Transactional
    public DeleteComunaResponseDto delete(Integer id) {
        Comuna comuna = comunaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comuna", "id", id));

        comunaRepository.delete(comuna);
        return new DeleteComunaResponseDto(
                comuna.getId(),
                comuna.getComuna(),
                "Comuna eliminada exitosamente"
        );
    }
}
