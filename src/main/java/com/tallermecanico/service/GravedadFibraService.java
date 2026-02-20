package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateGravedadFibraDto;
import com.tallermecanico.dto.request.UpdateGravedadFibraDto;
import com.tallermecanico.dto.response.DeleteGravedadFibraResponseDto;
import com.tallermecanico.entity.GravedadFibra;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.GravedadFibraRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GravedadFibraService {

    private final GravedadFibraRepository gravedadFibraRepository;

    public GravedadFibraService(GravedadFibraRepository gravedadFibraRepository) {
        this.gravedadFibraRepository = gravedadFibraRepository;
    }

    @Transactional
    public GravedadFibra create(CreateGravedadFibraDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getGravedad());

        if (gravedadFibraRepository.existsByGravedadIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("GravedadFibra", "gravedad", dto.getGravedad());
        }

        GravedadFibra gravedadFibra = new GravedadFibra();
        gravedadFibra.setGravedad(nombreNormalizado);

        return gravedadFibraRepository.save(gravedadFibra);
    }

    @Transactional(readOnly = true)
    public List<GravedadFibra> findAll() {
        return gravedadFibraRepository.findAll();
    }

    @Transactional(readOnly = true)
    public GravedadFibra findById(Integer id) {
        return gravedadFibraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GravedadFibra", "id", id));
    }

    @Transactional
    public GravedadFibra update(Integer id, UpdateGravedadFibraDto dto) {
        GravedadFibra gravedadFibra = gravedadFibraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GravedadFibra", "id", id));

        if (dto.getGravedad() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getGravedad());

            if (gravedadFibraRepository.existsByGravedadIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("GravedadFibra", "gravedad", dto.getGravedad());
            }

            gravedadFibra.setGravedad(nombreNormalizado);
        }

        return gravedadFibraRepository.save(gravedadFibra);
    }

    @Transactional
    public DeleteGravedadFibraResponseDto delete(Integer id) {
        GravedadFibra gravedadFibra = gravedadFibraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GravedadFibra", "id", id));

        gravedadFibraRepository.delete(gravedadFibra);
        return new DeleteGravedadFibraResponseDto(
                gravedadFibra.getId(),
                gravedadFibra.getGravedad(),
                "Gravedad de fibra eliminada exitosamente"
        );
    }
}
