package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateBateriasEstadoDto;
import com.tallermecanico.dto.request.UpdateBateriasEstadoDto;
import com.tallermecanico.dto.response.DeleteBateriasEstadoResponseDto;
import com.tallermecanico.entity.BateriasEstado;
import com.tallermecanico.service.BateriasEstadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baterias-estado")
public class BateriasEstadoController {

    private final BateriasEstadoService bateriasEstadoService;

    public BateriasEstadoController(BateriasEstadoService bateriasEstadoService) {
        this.bateriasEstadoService = bateriasEstadoService;
    }

    @PostMapping
    public ResponseEntity<BateriasEstado> create(@Valid @RequestBody CreateBateriasEstadoDto dto) {
        BateriasEstado bateriasEstado = bateriasEstadoService.create(dto);
        return new ResponseEntity<>(bateriasEstado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BateriasEstado>> findAll() {
        return ResponseEntity.ok(bateriasEstadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BateriasEstado> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(bateriasEstadoService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BateriasEstado> update(@PathVariable Integer id,
                                                  @Valid @RequestBody UpdateBateriasEstadoDto dto) {
        return ResponseEntity.ok(bateriasEstadoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteBateriasEstadoResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(bateriasEstadoService.delete(id));
    }
}
