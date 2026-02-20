package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateResponsableDto;
import com.tallermecanico.dto.request.UpdateResponsableDto;
import com.tallermecanico.dto.response.DeleteResponsableResponseDto;
import com.tallermecanico.entity.Responsable;
import com.tallermecanico.service.ResponsableService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsables")
public class ResponsableController {

    private final ResponsableService responsableService;

    public ResponsableController(ResponsableService responsableService) {
        this.responsableService = responsableService;
    }

    @PostMapping
    public ResponseEntity<Responsable> create(@Valid @RequestBody CreateResponsableDto dto) {
        Responsable responsable = responsableService.create(dto);
        return new ResponseEntity<>(responsable, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Responsable>> findAll() {
        return ResponseEntity.ok(responsableService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsable> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(responsableService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Responsable> update(@PathVariable Integer id,
                                               @Valid @RequestBody UpdateResponsableDto dto) {
        return ResponseEntity.ok(responsableService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponsableResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(responsableService.delete(id));
    }
}
