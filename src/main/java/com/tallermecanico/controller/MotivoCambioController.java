package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMotivoCambioDto;
import com.tallermecanico.dto.request.UpdateMotivoCambioDto;
import com.tallermecanico.dto.response.DeleteMotivoCambioResponseDto;
import com.tallermecanico.entity.MotivoCambio;
import com.tallermecanico.service.MotivoCambioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motivo-cambio")
public class MotivoCambioController {

    private final MotivoCambioService motivoCambioService;

    public MotivoCambioController(MotivoCambioService motivoCambioService) {
        this.motivoCambioService = motivoCambioService;
    }

    @PostMapping
    public ResponseEntity<MotivoCambio> create(@Valid @RequestBody CreateMotivoCambioDto dto) {
        MotivoCambio motivoCambio = motivoCambioService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(motivoCambio);
    }

    @GetMapping
    public ResponseEntity<List<MotivoCambio>> findAll() {
        List<MotivoCambio> motivosCambio = motivoCambioService.findAll();
        return ResponseEntity.ok(motivosCambio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotivoCambio> findById(@PathVariable Integer id) {
        MotivoCambio motivoCambio = motivoCambioService.findById(id);
        return ResponseEntity.ok(motivoCambio);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MotivoCambio> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdateMotivoCambioDto dto) {
        MotivoCambio motivoCambio = motivoCambioService.update(id, dto);
        return ResponseEntity.ok(motivoCambio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMotivoCambioResponseDto> delete(@PathVariable Integer id) {
        DeleteMotivoCambioResponseDto response = motivoCambioService.delete(id);
        return ResponseEntity.ok(response);
    }
}
