package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateInfraestructurasPlanDto;
import com.tallermecanico.dto.request.UpdateInfraestructurasPlanDto;
import com.tallermecanico.dto.response.DeleteInfraestructurasPlanResponseDto;
import com.tallermecanico.entity.InfraestructurasPlan;
import com.tallermecanico.service.InfraestructurasPlanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infraestructuras-plan")
public class InfraestructurasPlanController {

    private final InfraestructurasPlanService infraestructurasPlanService;

    public InfraestructurasPlanController(InfraestructurasPlanService infraestructurasPlanService) {
        this.infraestructurasPlanService = infraestructurasPlanService;
    }

    @PostMapping
    public ResponseEntity<InfraestructurasPlan> create(@Valid @RequestBody CreateInfraestructurasPlanDto dto) {
        InfraestructurasPlan infraestructurasPlan = infraestructurasPlanService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(infraestructurasPlan);
    }

    @GetMapping
    public ResponseEntity<List<InfraestructurasPlan>> findAll() {
        List<InfraestructurasPlan> planes = infraestructurasPlanService.findAll();
        return ResponseEntity.ok(planes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfraestructurasPlan> findById(@PathVariable Integer id) {
        InfraestructurasPlan infraestructurasPlan = infraestructurasPlanService.findById(id);
        return ResponseEntity.ok(infraestructurasPlan);
    }

    @GetMapping("/infra-herra-patron/{idInfra}")
    public ResponseEntity<List<InfraestructurasPlan>> findByInfraHerraPatron(@PathVariable String idInfra) {
        List<InfraestructurasPlan> planes = infraestructurasPlanService.findByInfraHerraPatron(idInfra);
        return ResponseEntity.ok(planes);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<InfraestructurasPlan> update(@PathVariable Integer id,
                                                        @Valid @RequestBody UpdateInfraestructurasPlanDto dto) {
        InfraestructurasPlan infraestructurasPlan = infraestructurasPlanService.update(id, dto);
        return ResponseEntity.ok(infraestructurasPlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteInfraestructurasPlanResponseDto> delete(@PathVariable Integer id) {
        DeleteInfraestructurasPlanResponseDto response = infraestructurasPlanService.delete(id);
        return ResponseEntity.ok(response);
    }
}
