package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateGravedadPinturaDto;
import com.tallermecanico.dto.request.UpdateGravedadPinturaDto;
import com.tallermecanico.dto.response.DeleteGravedadPinturaResponseDto;
import com.tallermecanico.entity.GravedadPintura;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.GravedadPinturaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GravedadPinturaService {

    private final GravedadPinturaRepository gravedadPinturaRepository;

    public GravedadPinturaService(GravedadPinturaRepository gravedadPinturaRepository) {
        this.gravedadPinturaRepository = gravedadPinturaRepository;
    }

    @Transactional
    public GravedadPintura create(CreateGravedadPinturaDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getGravedad());

        if (gravedadPinturaRepository.existsByGravedadIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("GravedadPintura", "gravedad", dto.getGravedad());
        }

        GravedadPintura gravedadPintura = new GravedadPintura();
        gravedadPintura.setGravedad(nombreNormalizado);

        return gravedadPinturaRepository.save(gravedadPintura);
    }

    @Transactional(readOnly = true)
    public List<GravedadPintura> findAll() {
        return gravedadPinturaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public GravedadPintura findById(Integer id) {
        return gravedadPinturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GravedadPintura", "id", id));
    }

    @Transactional
    public GravedadPintura update(Integer id, UpdateGravedadPinturaDto dto) {
        GravedadPintura gravedadPintura = gravedadPinturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GravedadPintura", "id", id));

        if (dto.getGravedad() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getGravedad());

            if (gravedadPinturaRepository.existsByGravedadIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("GravedadPintura", "gravedad", dto.getGravedad());
            }

            gravedadPintura.setGravedad(nombreNormalizado);
        }

        return gravedadPinturaRepository.save(gravedadPintura);
    }

    @Transactional
    public DeleteGravedadPinturaResponseDto delete(Integer id) {
        GravedadPintura gravedadPintura = gravedadPinturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GravedadPintura", "id", id));

        gravedadPinturaRepository.delete(gravedadPintura);
        return new DeleteGravedadPinturaResponseDto(
                gravedadPintura.getId(),
                gravedadPintura.getGravedad(),
                "Gravedad de pintura eliminada exitosamente"
        );
    }
}
