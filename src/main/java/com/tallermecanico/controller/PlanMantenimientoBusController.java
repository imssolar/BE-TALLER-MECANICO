package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreatePlanMantenimientoBusDto;
import com.tallermecanico.dto.request.UpdatePlanMantenimientoBusDto;
import com.tallermecanico.dto.response.DeletePlanMantenimientoBusResponseDto;
import com.tallermecanico.entity.PlanMantenimientoBus;
import com.tallermecanico.service.PlanMantenimientoBusService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan-mantenimiento-bus")
public class PlanMantenimientoBusController {

    private final PlanMantenimientoBusService planMantenimientoBusService;

    public PlanMantenimientoBusController(PlanMantenimientoBusService planMantenimientoBusService) {
        this.planMantenimientoBusService = planMantenimientoBusService;
    }

    @PostMapping
    public ResponseEntity<PlanMantenimientoBus> create(@Valid @RequestBody CreatePlanMantenimientoBusDto dto) {
        PlanMantenimientoBus plan = planMantenimientoBusService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(plan);
    }

    @GetMapping
    public ResponseEntity<List<PlanMantenimientoBus>> findAll() {
        List<PlanMantenimientoBus> planes = planMantenimientoBusService.findAll();
        return ResponseEntity.ok(planes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanMantenimientoBus> findById(@PathVariable Integer id) {
        PlanMantenimientoBus plan = planMantenimientoBusService.findById(id);
        return ResponseEntity.ok(plan);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<PlanMantenimientoBus>> findByBus(@PathVariable Integer idBus) {
        List<PlanMantenimientoBus> planes = planMantenimientoBusService.findByBus(idBus);
        return ResponseEntity.ok(planes);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlanMantenimientoBus> update(@PathVariable Integer id,
                                                        @Valid @RequestBody UpdatePlanMantenimientoBusDto dto) {
        PlanMantenimientoBus plan = planMantenimientoBusService.update(id, dto);
        return ResponseEntity.ok(plan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePlanMantenimientoBusResponseDto> delete(@PathVariable Integer id) {
        DeletePlanMantenimientoBusResponseDto response = planMantenimientoBusService.delete(id);
        return ResponseEntity.ok(response);
    }
}
