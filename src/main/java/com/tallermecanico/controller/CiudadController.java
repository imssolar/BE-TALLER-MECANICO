package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateCiudadDto;
import com.tallermecanico.dto.request.UpdateCiudadDto;
import com.tallermecanico.dto.response.DeleteCiudadResponseDto;
import com.tallermecanico.entity.Ciudad;
import com.tallermecanico.service.CiudadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @PostMapping
    public ResponseEntity<Ciudad> create(@Valid @RequestBody CreateCiudadDto dto) {
        Ciudad ciudad = ciudadService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ciudad);
    }

    @GetMapping
    public ResponseEntity<List<Ciudad>> findAll() {
        List<Ciudad> ciudades = ciudadService.findAll();
        return ResponseEntity.ok(ciudades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> findById(@PathVariable Integer id) {
        Ciudad ciudad = ciudadService.findById(id);
        return ResponseEntity.ok(ciudad);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ciudad> update(@PathVariable Integer id,
                                          @Valid @RequestBody UpdateCiudadDto dto) {
        Ciudad ciudad = ciudadService.update(id, dto);
        return ResponseEntity.ok(ciudad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCiudadResponseDto> delete(@PathVariable Integer id) {
        DeleteCiudadResponseDto response = ciudadService.delete(id);
        return ResponseEntity.ok(response);
    }
}
