package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOTCarroceriaDto;
import com.tallermecanico.dto.request.UpdateOTCarroceriaDto;
import com.tallermecanico.dto.response.DeleteOTCarroceriaResponseDto;
import com.tallermecanico.entity.OTCarroceria;
import com.tallermecanico.service.OTCarroceriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ot-carroceria")
public class OTCarroceriaController {

    private final OTCarroceriaService otCarroceriaService;

    public OTCarroceriaController(OTCarroceriaService otCarroceriaService) {
        this.otCarroceriaService = otCarroceriaService;
    }

    @PostMapping
    public ResponseEntity<OTCarroceria> create(@Valid @RequestBody CreateOTCarroceriaDto dto) {
        OTCarroceria otCarroceria = otCarroceriaService.create(dto);
        return new ResponseEntity<>(otCarroceria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OTCarroceria>> findAll() {
        return ResponseEntity.ok(otCarroceriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OTCarroceria> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(otCarroceriaService.findById(id));
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<OTCarroceria>> findByBus(@PathVariable Integer idBus) {
        return ResponseEntity.ok(otCarroceriaService.findByBus(idBus));
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<OTCarroceria>> findByTerminal(@PathVariable Integer idTerminal) {
        return ResponseEntity.ok(otCarroceriaService.findByTerminal(idTerminal));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OTCarroceria> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdateOTCarroceriaDto dto) {
        return ResponseEntity.ok(otCarroceriaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOTCarroceriaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(otCarroceriaService.delete(id));
    }
}
