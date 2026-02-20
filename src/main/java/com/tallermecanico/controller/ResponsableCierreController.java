package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateResponsableCierreDto;
import com.tallermecanico.dto.request.UpdateResponsableCierreDto;
import com.tallermecanico.dto.response.DeleteResponsableCierreResponseDto;
import com.tallermecanico.entity.ResponsableCierre;
import com.tallermecanico.service.ResponsableCierreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsable-cierre")
public class ResponsableCierreController {

    private final ResponsableCierreService responsableCierreService;

    public ResponsableCierreController(ResponsableCierreService responsableCierreService) {
        this.responsableCierreService = responsableCierreService;
    }

    @PostMapping
    public ResponseEntity<ResponsableCierre> create(@Valid @RequestBody CreateResponsableCierreDto dto) {
        ResponsableCierre responsableCierre = responsableCierreService.create(dto);
        return new ResponseEntity<>(responsableCierre, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponsableCierre>> findAll() {
        return ResponseEntity.ok(responsableCierreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsableCierre> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(responsableCierreService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponsableCierre> update(@PathVariable Integer id,
                                                     @Valid @RequestBody UpdateResponsableCierreDto dto) {
        return ResponseEntity.ok(responsableCierreService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponsableCierreResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(responsableCierreService.delete(id));
    }
}
