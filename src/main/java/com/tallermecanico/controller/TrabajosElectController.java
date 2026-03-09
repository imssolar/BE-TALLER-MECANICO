package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateTrabajosElectDto;
import com.tallermecanico.dto.request.UpdateTrabajosElectDto;
import com.tallermecanico.dto.response.DeleteTrabajosElectResponseDto;
import com.tallermecanico.entity.TrabajosElect;
import com.tallermecanico.service.TrabajosElectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajos-elect")
public class TrabajosElectController {

    private final TrabajosElectService trabajosElectService;

    public TrabajosElectController(TrabajosElectService trabajosElectService) {
        this.trabajosElectService = trabajosElectService;
    }

    @PostMapping
    public ResponseEntity<TrabajosElect> create(@Valid @RequestBody CreateTrabajosElectDto dto) {
        TrabajosElect trabajosElect = trabajosElectService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(trabajosElect);
    }

    @GetMapping
    public ResponseEntity<List<TrabajosElect>> findAll() {
        List<TrabajosElect> trabajosElect = trabajosElectService.findAll();
        return ResponseEntity.ok(trabajosElect);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabajosElect> findById(@PathVariable Integer id) {
        TrabajosElect trabajosElect = trabajosElectService.findById(id);
        return ResponseEntity.ok(trabajosElect);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TrabajosElect> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdateTrabajosElectDto dto) {
        TrabajosElect trabajosElect = trabajosElectService.update(id, dto);
        return ResponseEntity.ok(trabajosElect);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTrabajosElectResponseDto> delete(@PathVariable Integer id) {
        DeleteTrabajosElectResponseDto response = trabajosElectService.delete(id);
        return ResponseEntity.ok(response);
    }
}
