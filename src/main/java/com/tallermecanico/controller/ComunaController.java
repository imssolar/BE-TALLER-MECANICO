package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateComunaDto;
import com.tallermecanico.dto.request.UpdateComunaDto;
import com.tallermecanico.dto.response.DeleteComunaResponseDto;
import com.tallermecanico.entity.Comuna;
import com.tallermecanico.service.ComunaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comunas")
public class ComunaController {

    private final ComunaService comunaService;

    public ComunaController(ComunaService comunaService) {
        this.comunaService = comunaService;
    }

    @PostMapping
    public ResponseEntity<Comuna> create(@Valid @RequestBody CreateComunaDto dto) {
        Comuna comuna = comunaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(comuna);
    }

    @GetMapping
    public ResponseEntity<List<Comuna>> findAll() {
        List<Comuna> comunas = comunaService.findAll();
        return ResponseEntity.ok(comunas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> findById(@PathVariable Integer id) {
        Comuna comuna = comunaService.findById(id);
        return ResponseEntity.ok(comuna);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Comuna> update(@PathVariable Integer id,
                                          @Valid @RequestBody UpdateComunaDto dto) {
        Comuna comuna = comunaService.update(id, dto);
        return ResponseEntity.ok(comuna);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteComunaResponseDto> delete(@PathVariable Integer id) {
        DeleteComunaResponseDto response = comunaService.delete(id);
        return ResponseEntity.ok(response);
    }
}
