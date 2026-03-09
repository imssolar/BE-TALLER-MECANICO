package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateProveedorDto;
import com.tallermecanico.dto.request.UpdateProveedorDto;
import com.tallermecanico.dto.response.DeleteProveedorResponseDto;
import com.tallermecanico.entity.Proveedor;
import com.tallermecanico.service.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping
    public ResponseEntity<Proveedor> create(@Valid @RequestBody CreateProveedorDto dto) {
        Proveedor proveedor = proveedorService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedor);
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> findAll() {
        List<Proveedor> proveedores = proveedorService.findAll();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> findById(@PathVariable Integer id) {
        Proveedor proveedor = proveedorService.findById(id);
        return ResponseEntity.ok(proveedor);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Proveedor> update(@PathVariable Integer id,
                                             @Valid @RequestBody UpdateProveedorDto dto) {
        Proveedor proveedor = proveedorService.update(id, dto);
        return ResponseEntity.ok(proveedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteProveedorResponseDto> delete(@PathVariable Integer id) {
        DeleteProveedorResponseDto response = proveedorService.delete(id);
        return ResponseEntity.ok(response);
    }
}
