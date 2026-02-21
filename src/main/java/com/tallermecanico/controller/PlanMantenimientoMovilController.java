package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreatePlanMantenimientoMovilDto;
import com.tallermecanico.dto.request.UpdatePlanMantenimientoMovilDto;
import com.tallermecanico.dto.response.DeletePlanMantenimientoMovilResponseDto;
import com.tallermecanico.entity.PlanMantenimientoMovil;
import com.tallermecanico.service.PlanMantenimientoMovilService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan-mantenimiento-movil")
public class PlanMantenimientoMovilController {

    private final PlanMantenimientoMovilService planMantenimientoMovilService;

    public PlanMantenimientoMovilController(PlanMantenimientoMovilService planMantenimientoMovilService) {
        this.planMantenimientoMovilService = planMantenimientoMovilService;
    }

    @PostMapping
    public ResponseEntity<PlanMantenimientoMovil> create(@Valid @RequestBody CreatePlanMantenimientoMovilDto dto) {
        PlanMantenimientoMovil plan = planMantenimientoMovilService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(plan);
    }

    @GetMapping
    public ResponseEntity<List<PlanMantenimientoMovil>> findAll() {
        List<PlanMantenimientoMovil> planes = planMantenimientoMovilService.findAll();
        return ResponseEntity.ok(planes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanMantenimientoMovil> findById(@PathVariable Integer id) {
        PlanMantenimientoMovil plan = planMantenimientoMovilService.findById(id);
        return ResponseEntity.ok(plan);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlanMantenimientoMovil> update(@PathVariable Integer id,
                                                          @Valid @RequestBody UpdatePlanMantenimientoMovilDto dto) {
        PlanMantenimientoMovil plan = planMantenimientoMovilService.update(id, dto);
        return ResponseEntity.ok(plan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePlanMantenimientoMovilResponseDto> delete(@PathVariable Integer id) {
        DeletePlanMantenimientoMovilResponseDto response = planMantenimientoMovilService.delete(id);
        return ResponseEntity.ok(response);
    }
}
