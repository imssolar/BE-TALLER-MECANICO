package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOTCarroceriaDto;
import com.tallermecanico.dto.request.UpdateOTCarroceriaDto;
import com.tallermecanico.dto.response.DeleteOTCarroceriaResponseDto;
import com.tallermecanico.dto.response.OTCarroceriaResponseDto;
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
    public ResponseEntity<OTCarroceriaResponseDto> create(@Valid @RequestBody CreateOTCarroceriaDto dto) {
        return new ResponseEntity<>(otCarroceriaService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OTCarroceriaResponseDto>> findAll() {
        return ResponseEntity.ok(otCarroceriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OTCarroceriaResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(otCarroceriaService.findById(id));
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<OTCarroceriaResponseDto>> findByBus(@PathVariable Integer idBus) {
        return ResponseEntity.ok(otCarroceriaService.findByBus(idBus));
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<OTCarroceriaResponseDto>> findByTerminal(@PathVariable Integer idTerminal) {
        return ResponseEntity.ok(otCarroceriaService.findByTerminal(idTerminal));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OTCarroceriaResponseDto> update(@PathVariable Integer id,
                                                          @Valid @RequestBody UpdateOTCarroceriaDto dto) {
        return ResponseEntity.ok(otCarroceriaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOTCarroceriaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(otCarroceriaService.delete(id));
    }
}
