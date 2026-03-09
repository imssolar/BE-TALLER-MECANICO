package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateEvaluacionEmpleadoDto;
import com.tallermecanico.dto.request.UpdateEvaluacionEmpleadoDto;
import com.tallermecanico.dto.response.DeleteEvaluacionEmpleadoResponseDto;
import com.tallermecanico.entity.EvaluacionEmpleado;
import com.tallermecanico.service.EvaluacionEmpleadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluaciones-empleados")
public class EvaluacionEmpleadoController {

    private final EvaluacionEmpleadoService evaluacionEmpleadoService;

    public EvaluacionEmpleadoController(EvaluacionEmpleadoService evaluacionEmpleadoService) {
        this.evaluacionEmpleadoService = evaluacionEmpleadoService;
    }

    @PostMapping
    public ResponseEntity<EvaluacionEmpleado> create(@Valid @RequestBody CreateEvaluacionEmpleadoDto dto) {
        EvaluacionEmpleado evaluacion = evaluacionEmpleadoService.create(dto);
        return new ResponseEntity<>(evaluacion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EvaluacionEmpleado>> findAll() {
        return ResponseEntity.ok(evaluacionEmpleadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionEmpleado> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(evaluacionEmpleadoService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EvaluacionEmpleado> update(@PathVariable Integer id,
                                                      @Valid @RequestBody UpdateEvaluacionEmpleadoDto dto) {
        return ResponseEntity.ok(evaluacionEmpleadoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteEvaluacionEmpleadoResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(evaluacionEmpleadoService.delete(id));
    }
}
