package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreatePlanRevisionesDto;
import com.tallermecanico.dto.request.UpdatePlanRevisionesDto;
import com.tallermecanico.dto.response.DeletePlanRevisionesResponseDto;
import com.tallermecanico.entity.PlanRevisiones;
import com.tallermecanico.service.PlanRevisionesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan-revisiones")
public class PlanRevisionesController {

    private final PlanRevisionesService planRevisionesService;

    public PlanRevisionesController(PlanRevisionesService planRevisionesService) {
        this.planRevisionesService = planRevisionesService;
    }

    @PostMapping
    public ResponseEntity<PlanRevisiones> create(@Valid @RequestBody CreatePlanRevisionesDto dto) {
        PlanRevisiones planRevisiones = planRevisionesService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(planRevisiones);
    }

    @GetMapping
    public ResponseEntity<List<PlanRevisiones>> findAll() {
        List<PlanRevisiones> planRevisiones = planRevisionesService.findAll();
        return ResponseEntity.ok(planRevisiones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanRevisiones> findById(@PathVariable Integer id) {
        PlanRevisiones planRevisiones = planRevisionesService.findById(id);
        return ResponseEntity.ok(planRevisiones);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<PlanRevisiones>> findByBus(@PathVariable Integer idBus) {
        List<PlanRevisiones> planRevisiones = planRevisionesService.findByBus(idBus);
        return ResponseEntity.ok(planRevisiones);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlanRevisiones> update(@PathVariable Integer id,
                                                 @Valid @RequestBody UpdatePlanRevisionesDto dto) {
        PlanRevisiones planRevisiones = planRevisionesService.update(id, dto);
        return ResponseEntity.ok(planRevisiones);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePlanRevisionesResponseDto> delete(@PathVariable Integer id) {
        DeletePlanRevisionesResponseDto response = planRevisionesService.delete(id);
        return ResponseEntity.ok(response);
    }
}
