package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateHerramientasPlanDto;
import com.tallermecanico.dto.request.UpdateHerramientasPlanDto;
import com.tallermecanico.dto.response.DeleteHerramientasPlanResponseDto;
import com.tallermecanico.entity.HerramientasPlan;
import com.tallermecanico.service.HerramientasPlanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herramientas-plan")
public class HerramientasPlanController {

    private final HerramientasPlanService herramientasPlanService;

    public HerramientasPlanController(HerramientasPlanService herramientasPlanService) {
        this.herramientasPlanService = herramientasPlanService;
    }

    @PostMapping
    public ResponseEntity<HerramientasPlan> create(@Valid @RequestBody CreateHerramientasPlanDto dto) {
        HerramientasPlan herramientasPlan = herramientasPlanService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(herramientasPlan);
    }

    @GetMapping
    public ResponseEntity<List<HerramientasPlan>> findAll() {
        List<HerramientasPlan> planes = herramientasPlanService.findAll();
        return ResponseEntity.ok(planes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HerramientasPlan> findById(@PathVariable Integer id) {
        HerramientasPlan herramientasPlan = herramientasPlanService.findById(id);
        return ResponseEntity.ok(herramientasPlan);
    }

    @GetMapping("/infra-herra-patron/{idInfra}")
    public ResponseEntity<List<HerramientasPlan>> findByInfraHerraPatron(@PathVariable String idInfra) {
        List<HerramientasPlan> planes = herramientasPlanService.findByInfraHerraPatron(idInfra);
        return ResponseEntity.ok(planes);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HerramientasPlan> update(@PathVariable Integer id,
                                                    @Valid @RequestBody UpdateHerramientasPlanDto dto) {
        HerramientasPlan herramientasPlan = herramientasPlanService.update(id, dto);
        return ResponseEntity.ok(herramientasPlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteHerramientasPlanResponseDto> delete(@PathVariable Integer id) {
        DeleteHerramientasPlanResponseDto response = herramientasPlanService.delete(id);
        return ResponseEntity.ok(response);
    }
}
