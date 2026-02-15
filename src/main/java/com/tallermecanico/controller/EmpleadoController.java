package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateEmpleadoDto;
import com.tallermecanico.dto.request.UpdateEmpleadoDto;
import com.tallermecanico.dto.response.DeleteEmpleadoResponseDto;
import com.tallermecanico.dto.response.EmpleadoResponseDto;
import com.tallermecanico.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponseDto> create(@Valid @RequestBody CreateEmpleadoDto dto) {
        EmpleadoResponseDto empleado = empleadoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDto>> findAll() {
        List<EmpleadoResponseDto> empleados = empleadoService.findAll();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<EmpleadoResponseDto>> findActivos() {
        List<EmpleadoResponseDto> empleados = empleadoService.findByActivo(true);
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/inactivos")
    public ResponseEntity<List<EmpleadoResponseDto>> findInactivos() {
        List<EmpleadoResponseDto> empleados = empleadoService.findByActivo(false);
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/conductores")
    public ResponseEntity<List<EmpleadoResponseDto>> findConductores() {
        List<EmpleadoResponseDto> empleados = empleadoService.findConductores();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/mecanicos")
    public ResponseEntity<List<EmpleadoResponseDto>> findMecanicos() {
        List<EmpleadoResponseDto> empleados = empleadoService.findMecanicos();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<EmpleadoResponseDto> findByRut(@PathVariable String rut) {
        EmpleadoResponseDto empleado = empleadoService.findByRut(rut);
        return ResponseEntity.ok(empleado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDto> findById(@PathVariable Integer id) {
        EmpleadoResponseDto empleado = empleadoService.findById(id);
        return ResponseEntity.ok(empleado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDto> update(@PathVariable Integer id,
                                                      @Valid @RequestBody UpdateEmpleadoDto dto) {
        EmpleadoResponseDto empleado = empleadoService.update(id, dto);
        return ResponseEntity.ok(empleado);
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<EmpleadoResponseDto> desactivar(@PathVariable Integer id) {
        EmpleadoResponseDto empleado = empleadoService.desactivar(id);
        return ResponseEntity.ok(empleado);
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<EmpleadoResponseDto> activar(@PathVariable Integer id) {
        EmpleadoResponseDto empleado = empleadoService.activar(id);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteEmpleadoResponseDto> delete(@PathVariable Integer id) {
        DeleteEmpleadoResponseDto response = empleadoService.delete(id);
        return ResponseEntity.ok(response);
    }
}
