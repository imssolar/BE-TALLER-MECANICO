package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMarcasNeumaticoDto;
import com.tallermecanico.dto.request.UpdateMarcasNeumaticoDto;
import com.tallermecanico.dto.response.DeleteMarcasNeumaticoResponseDto;
import com.tallermecanico.entity.MarcasNeumatico;
import com.tallermecanico.service.MarcasNeumaticoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas-neumaticos")
public class MarcasNeumaticoController {

    private final MarcasNeumaticoService marcasNeumaticoService;

    public MarcasNeumaticoController(MarcasNeumaticoService marcasNeumaticoService) {
        this.marcasNeumaticoService = marcasNeumaticoService;
    }

    @PostMapping
    public ResponseEntity<MarcasNeumatico> create(@Valid @RequestBody CreateMarcasNeumaticoDto dto) {
        MarcasNeumatico marca = marcasNeumaticoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(marca);
    }

    @GetMapping
    public ResponseEntity<List<MarcasNeumatico>> findAll() {
        List<MarcasNeumatico> marcas = marcasNeumaticoService.findAll();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcasNeumatico> findById(@PathVariable Integer id) {
        MarcasNeumatico marca = marcasNeumaticoService.findById(id);
        return ResponseEntity.ok(marca);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MarcasNeumatico> update(@PathVariable Integer id,
                                                  @Valid @RequestBody UpdateMarcasNeumaticoDto dto) {
        MarcasNeumatico marca = marcasNeumaticoService.update(id, dto);
        return ResponseEntity.ok(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMarcasNeumaticoResponseDto> delete(@PathVariable Integer id) {
        DeleteMarcasNeumaticoResponseDto response = marcasNeumaticoService.delete(id);
        return ResponseEntity.ok(response);
    }
}
