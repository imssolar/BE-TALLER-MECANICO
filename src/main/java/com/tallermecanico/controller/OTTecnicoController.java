package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOTTecnicoDto;
import com.tallermecanico.dto.request.UpdateOTTecnicoDto;
import com.tallermecanico.dto.response.DeleteOTTecnicoResponseDto;
import com.tallermecanico.dto.response.OTTecnicoResponseDto;
import com.tallermecanico.service.OTTecnicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ot-tecnicos")
public class OTTecnicoController {

    private final OTTecnicoService otTecnicoService;

    public OTTecnicoController(OTTecnicoService otTecnicoService) {
        this.otTecnicoService = otTecnicoService;
    }

    @PostMapping
    public ResponseEntity<OTTecnicoResponseDto> create(@Valid @RequestBody CreateOTTecnicoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(otTecnicoService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<OTTecnicoResponseDto>> findAll() {
        return ResponseEntity.ok(otTecnicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OTTecnicoResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(otTecnicoService.findById(id));
    }

    @GetMapping("/orden-trabajo/{idOrdenTrabajo}")
    public ResponseEntity<List<OTTecnicoResponseDto>> findByOrdenTrabajo(@PathVariable Integer idOrdenTrabajo) {
        return ResponseEntity.ok(otTecnicoService.findByOrdenTrabajo(idOrdenTrabajo));
    }

    @GetMapping("/orden-trabajo-prog/{idOrdenTrabajoProg}")
    public ResponseEntity<List<OTTecnicoResponseDto>> findByOrdenTrabajoProg(@PathVariable Integer idOrdenTrabajoProg) {
        return ResponseEntity.ok(otTecnicoService.findByOrdenTrabajoProg(idOrdenTrabajoProg));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OTTecnicoResponseDto> update(@PathVariable Integer id,
                                                       @Valid @RequestBody UpdateOTTecnicoDto dto) {
        return ResponseEntity.ok(otTecnicoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOTTecnicoResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(otTecnicoService.delete(id));
    }
}
