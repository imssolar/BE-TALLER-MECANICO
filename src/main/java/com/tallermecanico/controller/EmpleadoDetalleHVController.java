package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateEmpleadoDetalleHVDto;
import com.tallermecanico.dto.request.UpdateEmpleadoDetalleHVDto;
import com.tallermecanico.dto.response.DeleteEmpleadoDetalleHVResponseDto;
import com.tallermecanico.entity.EmpleadoDetalleHV;
import com.tallermecanico.service.EmpleadoDetalleHVService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado-detalle-hv")
public class EmpleadoDetalleHVController {

    private final EmpleadoDetalleHVService empleadoDetalleHVService;

    public EmpleadoDetalleHVController(EmpleadoDetalleHVService empleadoDetalleHVService) {
        this.empleadoDetalleHVService = empleadoDetalleHVService;
    }

    @PostMapping
    public ResponseEntity<EmpleadoDetalleHV> create(@Valid @RequestBody CreateEmpleadoDetalleHVDto dto) {
        EmpleadoDetalleHV detalleHV = empleadoDetalleHVService.create(dto);
        return new ResponseEntity<>(detalleHV, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDetalleHV>> findAll() {
        return ResponseEntity.ok(empleadoDetalleHVService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDetalleHV> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(empleadoDetalleHVService.findById(id));
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<EmpleadoDetalleHV>> findByRut(@PathVariable String rut) {
        return ResponseEntity.ok(empleadoDetalleHVService.findByRut(rut));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmpleadoDetalleHV> update(@PathVariable Integer id,
                                                     @Valid @RequestBody UpdateEmpleadoDetalleHVDto dto) {
        return ResponseEntity.ok(empleadoDetalleHVService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteEmpleadoDetalleHVResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(empleadoDetalleHVService.delete(id));
    }
}
