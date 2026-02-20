package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateRepuestoDto;
import com.tallermecanico.dto.request.UpdateRepuestoDto;
import com.tallermecanico.dto.response.DeleteRepuestoResponseDto;
import com.tallermecanico.entity.Repuesto;
import com.tallermecanico.service.RepuestoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repuestos")
public class RepuestoController {

    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {
        this.repuestoService = repuestoService;
    }

    @PostMapping
    public ResponseEntity<Repuesto> create(@Valid @RequestBody CreateRepuestoDto dto) {
        Repuesto repuesto = repuestoService.create(dto);
        return new ResponseEntity<>(repuesto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Repuesto>> findAll() {
        return ResponseEntity.ok(repuestoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repuesto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(repuestoService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Repuesto> update(@PathVariable Integer id,
                                            @Valid @RequestBody UpdateRepuestoDto dto) {
        return ResponseEntity.ok(repuestoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRepuestoResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(repuestoService.delete(id));
    }
}
