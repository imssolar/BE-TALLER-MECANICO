package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateGravedadCarroceriaDto;
import com.tallermecanico.dto.request.UpdateGravedadCarroceriaDto;
import com.tallermecanico.dto.response.DeleteGravedadCarroceriaResponseDto;
import com.tallermecanico.entity.GravedadCarroceria;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.GravedadCarroceriaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GravedadCarroceriaService {

    private final GravedadCarroceriaRepository gravedadCarroceriaRepository;

    public GravedadCarroceriaService(GravedadCarroceriaRepository gravedadCarroceriaRepository) {
        this.gravedadCarroceriaRepository = gravedadCarroceriaRepository;
    }

    @Transactional
    public GravedadCarroceria create(CreateGravedadCarroceriaDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getGravedad());

        if (gravedadCarroceriaRepository.existsByGravedadIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("GravedadCarroceria", "gravedad", dto.getGravedad());
        }

        GravedadCarroceria gravedadCarroceria = new GravedadCarroceria();
        gravedadCarroceria.setGravedad(nombreNormalizado);

        return gravedadCarroceriaRepository.save(gravedadCarroceria);
    }

    @Transactional(readOnly = true)
    public List<GravedadCarroceria> findAll() {
        return gravedadCarroceriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public GravedadCarroceria findById(Integer id) {
        return gravedadCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GravedadCarroceria", "id", id));
    }

    @Transactional
    public GravedadCarroceria update(Integer id, UpdateGravedadCarroceriaDto dto) {
        GravedadCarroceria gravedadCarroceria = gravedadCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GravedadCarroceria", "id", id));

        if (dto.getGravedad() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getGravedad());

            if (gravedadCarroceriaRepository.existsByGravedadIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("GravedadCarroceria", "gravedad", dto.getGravedad());
            }

            gravedadCarroceria.setGravedad(nombreNormalizado);
        }

        return gravedadCarroceriaRepository.save(gravedadCarroceria);
    }

    @Transactional
    public DeleteGravedadCarroceriaResponseDto delete(Integer id) {
        GravedadCarroceria gravedadCarroceria = gravedadCarroceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GravedadCarroceria", "id", id));

        gravedadCarroceriaRepository.delete(gravedadCarroceria);
        return new DeleteGravedadCarroceriaResponseDto(
                gravedadCarroceria.getId(),
                gravedadCarroceria.getGravedad(),
                "Gravedad de carrocería eliminada exitosamente"
        );
    }
}
