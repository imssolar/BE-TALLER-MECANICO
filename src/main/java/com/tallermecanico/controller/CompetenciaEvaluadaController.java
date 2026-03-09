package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateCompetenciaEvaluadaDto;
import com.tallermecanico.dto.request.UpdateCompetenciaEvaluadaDto;
import com.tallermecanico.dto.response.DeleteCompetenciaEvaluadaResponseDto;
import com.tallermecanico.entity.CompetenciaEvaluada;
import com.tallermecanico.service.CompetenciaEvaluadaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencias-evaluadas")
public class CompetenciaEvaluadaController {

    private final CompetenciaEvaluadaService competenciaEvaluadaService;

    public CompetenciaEvaluadaController(CompetenciaEvaluadaService competenciaEvaluadaService) {
        this.competenciaEvaluadaService = competenciaEvaluadaService;
    }

    @PostMapping
    public ResponseEntity<CompetenciaEvaluada> create(@Valid @RequestBody CreateCompetenciaEvaluadaDto dto) {
        CompetenciaEvaluada competenciaEvaluada = competenciaEvaluadaService.create(dto);
        return new ResponseEntity<>(competenciaEvaluada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CompetenciaEvaluada>> findAll() {
        return ResponseEntity.ok(competenciaEvaluadaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaEvaluada> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(competenciaEvaluadaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CompetenciaEvaluada> update(@PathVariable Integer id,
                                                       @Valid @RequestBody UpdateCompetenciaEvaluadaDto dto) {
        return ResponseEntity.ok(competenciaEvaluadaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCompetenciaEvaluadaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(competenciaEvaluadaService.delete(id));
    }
}
