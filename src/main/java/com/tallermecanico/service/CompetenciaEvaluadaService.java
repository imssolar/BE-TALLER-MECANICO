package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateCompetenciaEvaluadaDto;
import com.tallermecanico.dto.request.UpdateCompetenciaEvaluadaDto;
import com.tallermecanico.dto.response.DeleteCompetenciaEvaluadaResponseDto;
import com.tallermecanico.entity.Competencia;
import com.tallermecanico.entity.CompetenciaEvaluada;
import com.tallermecanico.entity.EvaluacionEmpleado;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.CompetenciaEvaluadaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetenciaEvaluadaService {

    private final CompetenciaEvaluadaRepository competenciaEvaluadaRepository;
    private final EvaluacionEmpleadoService evaluacionEmpleadoService;
    private final CompetenciaService competenciaService;

    public CompetenciaEvaluadaService(CompetenciaEvaluadaRepository competenciaEvaluadaRepository,
                                      EvaluacionEmpleadoService evaluacionEmpleadoService,
                                      CompetenciaService competenciaService) {
        this.competenciaEvaluadaRepository = competenciaEvaluadaRepository;
        this.evaluacionEmpleadoService = evaluacionEmpleadoService;
        this.competenciaService = competenciaService;
    }

    @Transactional
    public CompetenciaEvaluada create(CreateCompetenciaEvaluadaDto dto) {
        CompetenciaEvaluada competenciaEvaluada = new CompetenciaEvaluada();
        competenciaEvaluada.setEvaluacionNota(dto.getEvaluacionNota());
        competenciaEvaluada.setReal(dto.getReal());

        if (dto.getIdEvaluacionEmpleado() != null) {
            EvaluacionEmpleado evaluacion = evaluacionEmpleadoService.findById(dto.getIdEvaluacionEmpleado());
            competenciaEvaluada.setEvaluacionEmpleado(evaluacion);
        }

        if (dto.getIdCompetencia() != null) {
            Competencia competencia = competenciaService.findById(dto.getIdCompetencia());
            competenciaEvaluada.setCompetencia(competencia);
        }

        return competenciaEvaluadaRepository.save(competenciaEvaluada);
    }

    @Transactional(readOnly = true)
    public List<CompetenciaEvaluada> findAll() {
        return competenciaEvaluadaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CompetenciaEvaluada findById(Integer id) {
        return competenciaEvaluadaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompetenciaEvaluada", "id", id));
    }

    @Transactional
    public CompetenciaEvaluada update(Integer id, UpdateCompetenciaEvaluadaDto dto) {
        CompetenciaEvaluada competenciaEvaluada = competenciaEvaluadaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompetenciaEvaluada", "id", id));

        if (dto.getEvaluacionNota() != null) {
            competenciaEvaluada.setEvaluacionNota(dto.getEvaluacionNota());
        }
        if (dto.getReal() != null) {
            competenciaEvaluada.setReal(dto.getReal());
        }
        if (dto.getIdEvaluacionEmpleado() != null) {
            EvaluacionEmpleado evaluacion = evaluacionEmpleadoService.findById(dto.getIdEvaluacionEmpleado());
            competenciaEvaluada.setEvaluacionEmpleado(evaluacion);
        }
        if (dto.getIdCompetencia() != null) {
            Competencia competencia = competenciaService.findById(dto.getIdCompetencia());
            competenciaEvaluada.setCompetencia(competencia);
        }

        return competenciaEvaluadaRepository.save(competenciaEvaluada);
    }

    @Transactional
    public DeleteCompetenciaEvaluadaResponseDto delete(Integer id) {
        CompetenciaEvaluada competenciaEvaluada = competenciaEvaluadaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompetenciaEvaluada", "id", id));

        competenciaEvaluadaRepository.delete(competenciaEvaluada);
        return new DeleteCompetenciaEvaluadaResponseDto(
                competenciaEvaluada.getId(),
                "Competencia evaluada eliminada exitosamente"
        );
    }
}
