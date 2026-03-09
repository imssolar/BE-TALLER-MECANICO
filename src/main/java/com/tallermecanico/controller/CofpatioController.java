package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateCofpatioDto;
import com.tallermecanico.dto.request.UpdateCofpatioDto;
import com.tallermecanico.dto.response.DeleteCofpatioResponseDto;
import com.tallermecanico.entity.Cofpatio;
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
    public ResponseEntity<Cofpatio> create(@Valid @RequestBody CreateCofpatioDto dto) {
        Cofpatio cofpatio = cofpatioService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cofpatio);
    }

    @GetMapping
    public ResponseEntity<List<Cofpatio>> findAll() {
        List<Cofpatio> cofpatios = cofpatioService.findAll();
        return ResponseEntity.ok(cofpatios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cofpatio> findById(@PathVariable Integer id) {
        Cofpatio cofpatio = cofpatioService.findById(id);
        return ResponseEntity.ok(cofpatio);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<Cofpatio>> findByBus(@PathVariable Integer idBus) {
        List<Cofpatio> cofpatios = cofpatioService.findByBus(idBus);
        return ResponseEntity.ok(cofpatios);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cofpatio> update(@PathVariable Integer id,
                                           @Valid @RequestBody UpdateCofpatioDto dto) {
        Cofpatio cofpatio = cofpatioService.update(id, dto);
        return ResponseEntity.ok(cofpatio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCofpatioResponseDto> delete(@PathVariable Integer id) {
        DeleteCofpatioResponseDto response = cofpatioService.delete(id);
        return ResponseEntity.ok(response);
    }
}
