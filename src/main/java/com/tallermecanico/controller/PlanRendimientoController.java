package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreatePlanRendimientoDto;
import com.tallermecanico.dto.request.UpdatePlanRendimientoDto;
import com.tallermecanico.dto.response.DeletePlanRendimientoResponseDto;
import com.tallermecanico.entity.PlanRendimiento;
import com.tallermecanico.service.PlanRendimientoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan-rendimiento")
public class PlanRendimientoController {

    private final PlanRendimientoService planRendimientoService;

    public PlanRendimientoController(PlanRendimientoService planRendimientoService) {
        this.planRendimientoService = planRendimientoService;
    }

    @PostMapping
    public ResponseEntity<PlanRendimiento> create(@Valid @RequestBody CreatePlanRendimientoDto dto) {
        PlanRendimiento planRendimiento = planRendimientoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(planRendimiento);
    }

    @GetMapping
    public ResponseEntity<List<PlanRendimiento>> findAll() {
        List<PlanRendimiento> planes = planRendimientoService.findAll();
        return ResponseEntity.ok(planes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanRendimiento> findById(@PathVariable Integer id) {
        PlanRendimiento planRendimiento = planRendimientoService.findById(id);
        return ResponseEntity.ok(planRendimiento);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlanRendimiento> update(@PathVariable Integer id,
                                                   @Valid @RequestBody UpdatePlanRendimientoDto dto) {
        PlanRendimiento planRendimiento = planRendimientoService.update(id, dto);
        return ResponseEntity.ok(planRendimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePlanRendimientoResponseDto> delete(@PathVariable Integer id) {
        DeletePlanRendimientoResponseDto response = planRendimientoService.delete(id);
        return ResponseEntity.ok(response);
    }
}
