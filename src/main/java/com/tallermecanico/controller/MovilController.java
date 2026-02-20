package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMovilDto;
import com.tallermecanico.dto.request.UpdateMovilDto;
import com.tallermecanico.dto.response.DeleteMovilResponseDto;
import com.tallermecanico.entity.Movil;
import com.tallermecanico.service.MovilService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moviles")
public class MovilController {

    private final MovilService movilService;

    public MovilController(MovilService movilService) {
        this.movilService = movilService;
    }

    @PostMapping
    public ResponseEntity<Movil> create(@Valid @RequestBody CreateMovilDto dto) {
        Movil movil = movilService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movil);
    }

    @GetMapping
    public ResponseEntity<List<Movil>> findAll() {
        List<Movil> moviles = movilService.findAll();
        return ResponseEntity.ok(moviles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movil> findById(@PathVariable Integer id) {
        Movil movil = movilService.findById(id);
        return ResponseEntity.ok(movil);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Movil> update(@PathVariable Integer id,
                                         @Valid @RequestBody UpdateMovilDto dto) {
        Movil movil = movilService.update(id, dto);
        return ResponseEntity.ok(movil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMovilResponseDto> delete(@PathVariable Integer id) {
        DeleteMovilResponseDto response = movilService.delete(id);
        return ResponseEntity.ok(response);
    }
}
