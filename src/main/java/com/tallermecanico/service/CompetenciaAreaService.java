package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateCompetenciaAreaDto;
import com.tallermecanico.dto.request.UpdateCompetenciaAreaDto;
import com.tallermecanico.dto.response.DeleteCompetenciaAreaResponseDto;
import com.tallermecanico.entity.CompetenciaArea;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.CompetenciaAreaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetenciaAreaService {

    private final CompetenciaAreaRepository competenciaAreaRepository;

    public CompetenciaAreaService(CompetenciaAreaRepository competenciaAreaRepository) {
        this.competenciaAreaRepository = competenciaAreaRepository;
    }

    @Transactional
    public CompetenciaArea create(CreateCompetenciaAreaDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getArea());

        if (competenciaAreaRepository.existsByAreaIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("CompetenciaArea", "area", dto.getArea());
        }

        CompetenciaArea competenciaArea = new CompetenciaArea();
        competenciaArea.setArea(nombreNormalizado);
        competenciaArea.setPonderacion(dto.getPonderacion());

        return competenciaAreaRepository.save(competenciaArea);
    }

    @Transactional(readOnly = true)
    public List<CompetenciaArea> findAll() {
        return competenciaAreaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CompetenciaArea findById(Integer id) {
        return competenciaAreaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompetenciaArea", "id", id));
    }

    @Transactional
    public CompetenciaArea update(Integer id, UpdateCompetenciaAreaDto dto) {
        CompetenciaArea competenciaArea = competenciaAreaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompetenciaArea", "id", id));

        if (dto.getArea() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getArea());

            if (competenciaAreaRepository.existsByAreaIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("CompetenciaArea", "area", dto.getArea());
            }

            competenciaArea.setArea(nombreNormalizado);
        }

        if (dto.getPonderacion() != null) {
            competenciaArea.setPonderacion(dto.getPonderacion());
        }

        return competenciaAreaRepository.save(competenciaArea);
    }

    @Transactional
    public DeleteCompetenciaAreaResponseDto delete(Integer id) {
        CompetenciaArea competenciaArea = competenciaAreaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompetenciaArea", "id", id));

        competenciaAreaRepository.delete(competenciaArea);
        return new DeleteCompetenciaAreaResponseDto(
                competenciaArea.getId(),
                competenciaArea.getArea(),
                "Área de competencia eliminada exitosamente"
        );
    }
}
