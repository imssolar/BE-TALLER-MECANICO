package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateModelosNeumaticoDto;
import com.tallermecanico.dto.request.UpdateModelosNeumaticoDto;
import com.tallermecanico.dto.response.DeleteModelosNeumaticoResponseDto;
import com.tallermecanico.entity.ModelosNeumatico;
import com.tallermecanico.service.ModelosNeumaticoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos-neumatico")
public class ModelosNeumaticoController {

    private final ModelosNeumaticoService modelosNeumaticoService;

    public ModelosNeumaticoController(ModelosNeumaticoService modelosNeumaticoService) {
        this.modelosNeumaticoService = modelosNeumaticoService;
    }

    @PostMapping
    public ResponseEntity<ModelosNeumatico> create(@Valid @RequestBody CreateModelosNeumaticoDto dto) {
        ModelosNeumatico modelo = modelosNeumaticoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelo);
    }

    @GetMapping
    public ResponseEntity<List<ModelosNeumatico>> findAll() {
        List<ModelosNeumatico> modelos = modelosNeumaticoService.findAll();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelosNeumatico> findById(@PathVariable Integer id) {
        ModelosNeumatico modelo = modelosNeumaticoService.findById(id);
        return ResponseEntity.ok(modelo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ModelosNeumatico> update(@PathVariable Integer id,
                                                   @Valid @RequestBody UpdateModelosNeumaticoDto dto) {
        ModelosNeumatico modelo = modelosNeumaticoService.update(id, dto);
        return ResponseEntity.ok(modelo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteModelosNeumaticoResponseDto> delete(@PathVariable Integer id) {
        DeleteModelosNeumaticoResponseDto response = modelosNeumaticoService.delete(id);
        return ResponseEntity.ok(response);
    }
}
