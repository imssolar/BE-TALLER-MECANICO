package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateRepuestoCarroceriaDto;
import com.tallermecanico.dto.request.UpdateRepuestoCarroceriaDto;
import com.tallermecanico.dto.response.DeleteRepuestoCarroceriaResponseDto;
import com.tallermecanico.entity.RepuestoCarroceria;
import com.tallermecanico.service.RepuestoCarroceriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repuestos-carroceria")
public class RepuestoCarroceriaController {

    private final RepuestoCarroceriaService repuestoCarroceriaService;

    public RepuestoCarroceriaController(RepuestoCarroceriaService repuestoCarroceriaService) {
        this.repuestoCarroceriaService = repuestoCarroceriaService;
    }

    @PostMapping
    public ResponseEntity<RepuestoCarroceria> create(@Valid @RequestBody CreateRepuestoCarroceriaDto dto) {
        RepuestoCarroceria repuestoCarroceria = repuestoCarroceriaService.create(dto);
        return new ResponseEntity<>(repuestoCarroceria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RepuestoCarroceria>> findAll() {
        return ResponseEntity.ok(repuestoCarroceriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepuestoCarroceria> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(repuestoCarroceriaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RepuestoCarroceria> update(@PathVariable Integer id,
                                                      @Valid @RequestBody UpdateRepuestoCarroceriaDto dto) {
        return ResponseEntity.ok(repuestoCarroceriaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRepuestoCarroceriaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(repuestoCarroceriaService.delete(id));
    }
}
