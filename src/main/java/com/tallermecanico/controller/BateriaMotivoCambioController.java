package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateBateriaMotivoCambioDto;
import com.tallermecanico.dto.request.UpdateBateriaMotivoCambioDto;
import com.tallermecanico.dto.response.DeleteBateriaMotivoCambioResponseDto;
import com.tallermecanico.entity.BateriaMotivoCambio;
import com.tallermecanico.service.BateriaMotivoCambioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bateria-motivo-cambio")
public class BateriaMotivoCambioController {

    private final BateriaMotivoCambioService bateriaMotivoCambioService;

    public BateriaMotivoCambioController(BateriaMotivoCambioService bateriaMotivoCambioService) {
        this.bateriaMotivoCambioService = bateriaMotivoCambioService;
    }

    @PostMapping
    public ResponseEntity<BateriaMotivoCambio> create(@Valid @RequestBody CreateBateriaMotivoCambioDto dto) {
        BateriaMotivoCambio bateriaMotivoCambio = bateriaMotivoCambioService.create(dto);
        return new ResponseEntity<>(bateriaMotivoCambio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BateriaMotivoCambio>> findAll() {
        return ResponseEntity.ok(bateriaMotivoCambioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BateriaMotivoCambio> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(bateriaMotivoCambioService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BateriaMotivoCambio> update(@PathVariable Integer id,
                                                       @Valid @RequestBody UpdateBateriaMotivoCambioDto dto) {
        return ResponseEntity.ok(bateriaMotivoCambioService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteBateriaMotivoCambioResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(bateriaMotivoCambioService.delete(id));
    }
}
