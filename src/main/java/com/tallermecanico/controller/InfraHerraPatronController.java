package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateInfraHerraPatronDto;
import com.tallermecanico.dto.request.UpdateInfraHerraPatronDto;
import com.tallermecanico.dto.response.DeleteInfraHerraPatronResponseDto;
import com.tallermecanico.entity.InfraHerraPatron;
import com.tallermecanico.service.InfraHerraPatronService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infra-herra-patron")
public class InfraHerraPatronController {

    private final InfraHerraPatronService infraHerraPatronService;

    public InfraHerraPatronController(InfraHerraPatronService infraHerraPatronService) {
        this.infraHerraPatronService = infraHerraPatronService;
    }

    @PostMapping
    public ResponseEntity<InfraHerraPatron> create(@Valid @RequestBody CreateInfraHerraPatronDto dto) {
        InfraHerraPatron infraHerraPatron = infraHerraPatronService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(infraHerraPatron);
    }

    @GetMapping
    public ResponseEntity<List<InfraHerraPatron>> findAll() {
        List<InfraHerraPatron> infraHerraPatrones = infraHerraPatronService.findAll();
        return ResponseEntity.ok(infraHerraPatrones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfraHerraPatron> findById(@PathVariable String id) {
        InfraHerraPatron infraHerraPatron = infraHerraPatronService.findById(id);
        return ResponseEntity.ok(infraHerraPatron);
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<InfraHerraPatron>> findByTerminal(@PathVariable Integer idTerminal) {
        List<InfraHerraPatron> infraHerraPatrones = infraHerraPatronService.findByTerminal(idTerminal);
        return ResponseEntity.ok(infraHerraPatrones);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<InfraHerraPatron> update(@PathVariable String id,
                                                   @Valid @RequestBody UpdateInfraHerraPatronDto dto) {
        InfraHerraPatron infraHerraPatron = infraHerraPatronService.update(id, dto);
        return ResponseEntity.ok(infraHerraPatron);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteInfraHerraPatronResponseDto> delete(@PathVariable String id) {
        DeleteInfraHerraPatronResponseDto response = infraHerraPatronService.delete(id);
        return ResponseEntity.ok(response);
    }
}
