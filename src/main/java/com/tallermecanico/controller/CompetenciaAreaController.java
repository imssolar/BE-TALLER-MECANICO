package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateCompetenciaAreaDto;
import com.tallermecanico.dto.request.UpdateCompetenciaAreaDto;
import com.tallermecanico.dto.response.DeleteCompetenciaAreaResponseDto;
import com.tallermecanico.entity.CompetenciaArea;
import com.tallermecanico.service.CompetenciaAreaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencia-areas")
public class CompetenciaAreaController {

    private final CompetenciaAreaService competenciaAreaService;

    public CompetenciaAreaController(CompetenciaAreaService competenciaAreaService) {
        this.competenciaAreaService = competenciaAreaService;
    }

    @PostMapping
    public ResponseEntity<CompetenciaArea> create(@Valid @RequestBody CreateCompetenciaAreaDto dto) {
        CompetenciaArea competenciaArea = competenciaAreaService.create(dto);
        return new ResponseEntity<>(competenciaArea, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CompetenciaArea>> findAll() {
        return ResponseEntity.ok(competenciaAreaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaArea> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(competenciaAreaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CompetenciaArea> update(@PathVariable Integer id,
                                                   @Valid @RequestBody UpdateCompetenciaAreaDto dto) {
        return ResponseEntity.ok(competenciaAreaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCompetenciaAreaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(competenciaAreaService.delete(id));
    }
}
