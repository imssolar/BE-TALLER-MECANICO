package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateCofpatioDto;
import com.tallermecanico.dto.request.UpdateCofpatioDto;
import com.tallermecanico.dto.response.CofpatioResponseDto;
import com.tallermecanico.dto.response.DeleteCofpatioResponseDto;
import com.tallermecanico.service.CofpatioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cofpatio")
public class CofpatioController {

    private final CofpatioService cofpatioService;

    public CofpatioController(CofpatioService cofpatioService) {
        this.cofpatioService = cofpatioService;
    }

    @PostMapping
    public ResponseEntity<CofpatioResponseDto> create(@Valid @RequestBody CreateCofpatioDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cofpatioService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<CofpatioResponseDto>> findAll() {
        return ResponseEntity.ok(cofpatioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CofpatioResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(cofpatioService.findById(id));
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<CofpatioResponseDto>> findByBus(@PathVariable Integer idBus) {
        return ResponseEntity.ok(cofpatioService.findByBus(idBus));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CofpatioResponseDto> update(@PathVariable Integer id,
                                                      @Valid @RequestBody UpdateCofpatioDto dto) {
        return ResponseEntity.ok(cofpatioService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCofpatioResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(cofpatioService.delete(id));
    }
}
