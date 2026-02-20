package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateLiquidoDto;
import com.tallermecanico.dto.request.UpdateLiquidoDto;
import com.tallermecanico.dto.response.DeleteLiquidoResponseDto;
import com.tallermecanico.entity.Liquido;
import com.tallermecanico.service.LiquidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/liquidos")
public class LiquidoController {

    private final LiquidoService liquidoService;

    public LiquidoController(LiquidoService liquidoService) {
        this.liquidoService = liquidoService;
    }

    @PostMapping
    public ResponseEntity<Liquido> create(@Valid @RequestBody CreateLiquidoDto dto) {
        Liquido liquido = liquidoService.create(dto);
        return new ResponseEntity<>(liquido, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Liquido>> findAll() {
        return ResponseEntity.ok(liquidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Liquido> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(liquidoService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Liquido> update(@PathVariable Integer id,
                                           @Valid @RequestBody UpdateLiquidoDto dto) {
        return ResponseEntity.ok(liquidoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteLiquidoResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(liquidoService.delete(id));
    }
}
