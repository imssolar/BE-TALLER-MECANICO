package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateCompetenciaDto;
import com.tallermecanico.dto.request.UpdateCompetenciaDto;
import com.tallermecanico.dto.response.DeleteCompetenciaResponseDto;
import com.tallermecanico.entity.Competencia;
import com.tallermecanico.entity.CompetenciaArea;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.CompetenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaAreaService competenciaAreaService;

    public CompetenciaService(CompetenciaRepository competenciaRepository,
                              CompetenciaAreaService competenciaAreaService) {
        this.competenciaRepository = competenciaRepository;
        this.competenciaAreaService = competenciaAreaService;
    }

    @Transactional
    public Competencia create(CreateCompetenciaDto dto) {
        Competencia competencia = new Competencia();
        competencia.setCargo(dto.getCargo());
        competencia.setCompetencia(dto.getCompetencia());
        competencia.setOrden(dto.getOrden());
        competencia.setTeorico(dto.getTeorico());

        if (dto.getIdCompetenciaArea() != null) {
            CompetenciaArea competenciaArea = competenciaAreaService.findById(dto.getIdCompetenciaArea());
            competencia.setCompetenciaArea(competenciaArea);
        }

        return competenciaRepository.save(competencia);
    }

    @Transactional(readOnly = true)
    public List<Competencia> findAll() {
        return competenciaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Competencia findById(Integer id) {
        return competenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Competencia", "id", id));
    }

    @Transactional
    public Competencia update(Integer id, UpdateCompetenciaDto dto) {
        Competencia competencia = competenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Competencia", "id", id));

        if (dto.getCargo() != null) {
            competencia.setCargo(dto.getCargo());
        }
        if (dto.getCompetencia() != null) {
            competencia.setCompetencia(dto.getCompetencia());
        }
        if (dto.getOrden() != null) {
            competencia.setOrden(dto.getOrden());
        }
        if (dto.getTeorico() != null) {
            competencia.setTeorico(dto.getTeorico());
        }
        if (dto.getIdCompetenciaArea() != null) {
            CompetenciaArea competenciaArea = competenciaAreaService.findById(dto.getIdCompetenciaArea());
            competencia.setCompetenciaArea(competenciaArea);
        }

        return competenciaRepository.save(competencia);
    }

    @Transactional
    public DeleteCompetenciaResponseDto delete(Integer id) {
        Competencia competencia = competenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Competencia", "id", id));

        competenciaRepository.delete(competencia);
        return new DeleteCompetenciaResponseDto(
                competencia.getId(),
                competencia.getCompetencia(),
                "Competencia eliminada exitosamente"
        );
    }
}
