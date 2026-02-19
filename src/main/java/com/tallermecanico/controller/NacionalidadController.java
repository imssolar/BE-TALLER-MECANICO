package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateNacionalidadDto;
import com.tallermecanico.dto.request.UpdateNacionalidadDto;
import com.tallermecanico.dto.response.DeleteNacionalidadResponseDto;
import com.tallermecanico.entity.Nacionalidad;
import com.tallermecanico.service.NacionalidadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nacionalidades")
public class NacionalidadController {

    private final NacionalidadService nacionalidadService;

    public NacionalidadController(NacionalidadService nacionalidadService) {
        this.nacionalidadService = nacionalidadService;
    }

    @PostMapping
    public ResponseEntity<Nacionalidad> create(@Valid @RequestBody CreateNacionalidadDto dto) {
        Nacionalidad nacionalidad = nacionalidadService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nacionalidad);
    }

    @GetMapping
    public ResponseEntity<List<Nacionalidad>> findAll() {
        List<Nacionalidad> nacionalidades = nacionalidadService.findAll();
        return ResponseEntity.ok(nacionalidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nacionalidad> findById(@PathVariable Integer id) {
        Nacionalidad nacionalidad = nacionalidadService.findById(id);
        return ResponseEntity.ok(nacionalidad);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Nacionalidad> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdateNacionalidadDto dto) {
        Nacionalidad nacionalidad = nacionalidadService.update(id, dto);
        return ResponseEntity.ok(nacionalidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteNacionalidadResponseDto> delete(@PathVariable Integer id) {
        DeleteNacionalidadResponseDto response = nacionalidadService.delete(id);
        return ResponseEntity.ok(response);
    }
}
