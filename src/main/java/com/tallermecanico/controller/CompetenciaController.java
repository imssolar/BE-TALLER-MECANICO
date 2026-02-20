package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateCompetenciaDto;
import com.tallermecanico.dto.request.UpdateCompetenciaDto;
import com.tallermecanico.dto.response.DeleteCompetenciaResponseDto;
import com.tallermecanico.entity.Competencia;
import com.tallermecanico.service.CompetenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencias")
public class CompetenciaController {

    private final CompetenciaService competenciaService;

    public CompetenciaController(CompetenciaService competenciaService) {
        this.competenciaService = competenciaService;
    }

    @PostMapping
    public ResponseEntity<Competencia> create(@Valid @RequestBody CreateCompetenciaDto dto) {
        Competencia competencia = competenciaService.create(dto);
        return new ResponseEntity<>(competencia, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Competencia>> findAll() {
        return ResponseEntity.ok(competenciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(competenciaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Competencia> update(@PathVariable Integer id,
                                               @Valid @RequestBody UpdateCompetenciaDto dto) {
        return ResponseEntity.ok(competenciaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCompetenciaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(competenciaService.delete(id));
    }
}
