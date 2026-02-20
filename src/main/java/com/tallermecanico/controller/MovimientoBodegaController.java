package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMovimientoBodegaDto;
import com.tallermecanico.dto.request.UpdateMovimientoBodegaDto;
import com.tallermecanico.dto.response.DeleteMovimientoBodegaResponseDto;
import com.tallermecanico.entity.MovimientoBodega;
import com.tallermecanico.service.MovimientoBodegaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimiento-bodega")
public class MovimientoBodegaController {

    private final MovimientoBodegaService movimientoBodegaService;

    public MovimientoBodegaController(MovimientoBodegaService movimientoBodegaService) {
        this.movimientoBodegaService = movimientoBodegaService;
    }

    @PostMapping
    public ResponseEntity<MovimientoBodega> create(@Valid @RequestBody CreateMovimientoBodegaDto dto) {
        MovimientoBodega movimientoBodega = movimientoBodegaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimientoBodega);
    }

    @GetMapping
    public ResponseEntity<List<MovimientoBodega>> findAll() {
        List<MovimientoBodega> movimientos = movimientoBodegaService.findAll();
        return ResponseEntity.ok(movimientos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoBodega> findById(@PathVariable Integer id) {
        MovimientoBodega movimientoBodega = movimientoBodegaService.findById(id);
        return ResponseEntity.ok(movimientoBodega);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovimientoBodega> update(@PathVariable Integer id,
                                                    @Valid @RequestBody UpdateMovimientoBodegaDto dto) {
        MovimientoBodega movimientoBodega = movimientoBodegaService.update(id, dto);
        return ResponseEntity.ok(movimientoBodega);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMovimientoBodegaResponseDto> delete(@PathVariable Integer id) {
        DeleteMovimientoBodegaResponseDto response = movimientoBodegaService.delete(id);
        return ResponseEntity.ok(response);
    }
}
