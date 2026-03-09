package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateDetalleEHDto;
import com.tallermecanico.dto.request.UpdateDetalleEHDto;
import com.tallermecanico.dto.response.DeleteDetalleEHResponseDto;
import com.tallermecanico.entity.DetalleEH;
import com.tallermecanico.service.DetalleEHService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-eh")
public class DetalleEHController {

    private final DetalleEHService detalleEHService;

    public DetalleEHController(DetalleEHService detalleEHService) {
        this.detalleEHService = detalleEHService;
    }

    @PostMapping
    public ResponseEntity<DetalleEH> create(@Valid @RequestBody CreateDetalleEHDto dto) {
        DetalleEH detalleEH = detalleEHService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleEH);
    }

    @GetMapping
    public ResponseEntity<List<DetalleEH>> findAll() {
        List<DetalleEH> detalles = detalleEHService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleEH> findById(@PathVariable Integer id) {
        DetalleEH detalleEH = detalleEHService.findById(id);
        return ResponseEntity.ok(detalleEH);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<DetalleEH>> findByRut(@PathVariable String rut) {
        List<DetalleEH> detalles = detalleEHService.findByRut(rut);
        return ResponseEntity.ok(detalles);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DetalleEH> update(@PathVariable Integer id,
                                            @Valid @RequestBody UpdateDetalleEHDto dto) {
        DetalleEH detalleEH = detalleEHService.update(id, dto);
        return ResponseEntity.ok(detalleEH);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteDetalleEHResponseDto> delete(@PathVariable Integer id) {
        DeleteDetalleEHResponseDto response = detalleEHService.delete(id);
        return ResponseEntity.ok(response);
    }
}
