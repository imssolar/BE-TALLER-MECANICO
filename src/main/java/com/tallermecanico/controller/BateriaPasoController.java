package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateBateriaPasoDto;
import com.tallermecanico.dto.request.UpdateBateriaPasoDto;
import com.tallermecanico.dto.response.DeleteBateriaPasoResponseDto;
import com.tallermecanico.entity.BateriaPaso;
import com.tallermecanico.service.BateriaPasoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baterias-paso")
public class BateriaPasoController {

    private final BateriaPasoService bateriaPasoService;

    public BateriaPasoController(BateriaPasoService bateriaPasoService) {
        this.bateriaPasoService = bateriaPasoService;
    }

    @PostMapping
    public ResponseEntity<BateriaPaso> create(@Valid @RequestBody CreateBateriaPasoDto dto) {
        BateriaPaso bateriaPaso = bateriaPasoService.create(dto);
        return new ResponseEntity<>(bateriaPaso, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BateriaPaso>> findAll() {
        return ResponseEntity.ok(bateriaPasoService.findAll());
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<BateriaPaso>> findByBus(@PathVariable Integer idBus) {
        return ResponseEntity.ok(bateriaPasoService.findByBus(idBus));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BateriaPaso> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(bateriaPasoService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BateriaPaso> update(@PathVariable Integer id,
                                               @Valid @RequestBody UpdateBateriaPasoDto dto) {
        return ResponseEntity.ok(bateriaPasoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteBateriaPasoResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(bateriaPasoService.delete(id));
    }
}
