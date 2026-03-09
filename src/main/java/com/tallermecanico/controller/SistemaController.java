package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateSistemaDto;
import com.tallermecanico.dto.request.UpdateSistemaDto;
import com.tallermecanico.dto.response.DeleteSistemaResponseDto;
import com.tallermecanico.entity.Sistema;
import com.tallermecanico.service.SistemaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sistemas")
public class SistemaController {

    private final SistemaService sistemaService;

    public SistemaController(SistemaService sistemaService) {
        this.sistemaService = sistemaService;
    }

    @PostMapping
    public ResponseEntity<Sistema> create(@Valid @RequestBody CreateSistemaDto dto) {
        Sistema sistema = sistemaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(sistema);
    }

    @GetMapping
    public ResponseEntity<List<Sistema>> findAll() {
        List<Sistema> sistemas = sistemaService.findAll();
        return ResponseEntity.ok(sistemas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sistema> findById(@PathVariable Integer id) {
        Sistema sistema = sistemaService.findById(id);
        return ResponseEntity.ok(sistema);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Sistema> update(@PathVariable Integer id,
                                          @Valid @RequestBody UpdateSistemaDto dto) {
        Sistema sistema = sistemaService.update(id, dto);
        return ResponseEntity.ok(sistema);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteSistemaResponseDto> delete(@PathVariable Integer id) {
        DeleteSistemaResponseDto response = sistemaService.delete(id);
        return ResponseEntity.ok(response);
    }
}
