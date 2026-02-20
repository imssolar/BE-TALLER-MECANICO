package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateBusKMMensualDto;
import com.tallermecanico.dto.request.UpdateBusKMMensualDto;
import com.tallermecanico.dto.response.DeleteBusKMMensualResponseDto;
import com.tallermecanico.entity.BusKMMensual;
import com.tallermecanico.service.BusKMMensualService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buses-km-mensual")
public class BusKMMensualController {

    private final BusKMMensualService busKMMensualService;

    public BusKMMensualController(BusKMMensualService busKMMensualService) {
        this.busKMMensualService = busKMMensualService;
    }

    @PostMapping
    public ResponseEntity<BusKMMensual> create(@Valid @RequestBody CreateBusKMMensualDto dto) {
        BusKMMensual busKMMensual = busKMMensualService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(busKMMensual);
    }

    @GetMapping
    public ResponseEntity<List<BusKMMensual>> findAll() {
        List<BusKMMensual> registros = busKMMensualService.findAll();
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusKMMensual> findById(@PathVariable Integer id) {
        BusKMMensual busKMMensual = busKMMensualService.findById(id);
        return ResponseEntity.ok(busKMMensual);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BusKMMensual> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdateBusKMMensualDto dto) {
        BusKMMensual busKMMensual = busKMMensualService.update(id, dto);
        return ResponseEntity.ok(busKMMensual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteBusKMMensualResponseDto> delete(@PathVariable Integer id) {
        DeleteBusKMMensualResponseDto response = busKMMensualService.delete(id);
        return ResponseEntity.ok(response);
    }
}
