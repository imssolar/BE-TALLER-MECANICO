package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateTorreControlDto;
import com.tallermecanico.dto.request.UpdateTorreControlDto;
import com.tallermecanico.dto.response.DeleteTorreControlResponseDto;
import com.tallermecanico.entity.TorreControl;
import com.tallermecanico.service.TorreControlService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torre-control")
public class TorreControlController {

    private final TorreControlService torreControlService;

    public TorreControlController(TorreControlService torreControlService) {
        this.torreControlService = torreControlService;
    }

    @PostMapping
    public ResponseEntity<TorreControl> create(@Valid @RequestBody CreateTorreControlDto dto) {
        TorreControl torreControl = torreControlService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(torreControl);
    }

    @GetMapping
    public ResponseEntity<List<TorreControl>> findAll() {
        List<TorreControl> registros = torreControlService.findAll();
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TorreControl> findById(@PathVariable Integer id) {
        TorreControl torreControl = torreControlService.findById(id);
        return ResponseEntity.ok(torreControl);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<TorreControl>> findByBus(@PathVariable Integer idBus) {
        List<TorreControl> registros = torreControlService.findByBus(idBus);
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/abiertos")
    public ResponseEntity<List<TorreControl>> findAbiertos() {
        List<TorreControl> registros = torreControlService.findAbiertos();
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/cerrados")
    public ResponseEntity<List<TorreControl>> findCerrados() {
        List<TorreControl> registros = torreControlService.findCerrados();
        return ResponseEntity.ok(registros);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TorreControl> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdateTorreControlDto dto) {
        TorreControl torreControl = torreControlService.update(id, dto);
        return ResponseEntity.ok(torreControl);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTorreControlResponseDto> delete(@PathVariable Integer id) {
        DeleteTorreControlResponseDto response = torreControlService.delete(id);
        return ResponseEntity.ok(response);
    }
}
