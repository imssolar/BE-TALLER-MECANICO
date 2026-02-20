package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMarcaPastillaDto;
import com.tallermecanico.dto.request.UpdateMarcaPastillaDto;
import com.tallermecanico.dto.response.DeleteMarcaPastillaResponseDto;
import com.tallermecanico.entity.MarcaPastilla;
import com.tallermecanico.service.MarcaPastillaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas-pastillas")
public class MarcaPastillaController {

    private final MarcaPastillaService marcaPastillaService;

    public MarcaPastillaController(MarcaPastillaService marcaPastillaService) {
        this.marcaPastillaService = marcaPastillaService;
    }

    @PostMapping
    public ResponseEntity<MarcaPastilla> create(@Valid @RequestBody CreateMarcaPastillaDto dto) {
        MarcaPastilla marcaPastilla = marcaPastillaService.create(dto);
        return new ResponseEntity<>(marcaPastilla, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MarcaPastilla>> findAll() {
        return ResponseEntity.ok(marcaPastillaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaPastilla> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(marcaPastillaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MarcaPastilla> update(@PathVariable Integer id,
                                                 @Valid @RequestBody UpdateMarcaPastillaDto dto) {
        return ResponseEntity.ok(marcaPastillaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMarcaPastillaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(marcaPastillaService.delete(id));
    }
}
