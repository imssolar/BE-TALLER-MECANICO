package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMantencionMovilDto;
import com.tallermecanico.dto.request.UpdateMantencionMovilDto;
import com.tallermecanico.dto.response.DeleteMantencionMovilResponseDto;
import com.tallermecanico.entity.MantencionMovil;
import com.tallermecanico.service.MantencionMovilService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mantenciones-movil")
public class MantencionMovilController {

    private final MantencionMovilService mantencionMovilService;

    public MantencionMovilController(MantencionMovilService mantencionMovilService) {
        this.mantencionMovilService = mantencionMovilService;
    }

    @PostMapping
    public ResponseEntity<MantencionMovil> create(@Valid @RequestBody CreateMantencionMovilDto dto) {
        MantencionMovil mantencionMovil = mantencionMovilService.create(dto);
        return new ResponseEntity<>(mantencionMovil, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MantencionMovil>> findAll() {
        return ResponseEntity.ok(mantencionMovilService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MantencionMovil> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(mantencionMovilService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MantencionMovil> update(@PathVariable Integer id,
                                                   @Valid @RequestBody UpdateMantencionMovilDto dto) {
        return ResponseEntity.ok(mantencionMovilService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMantencionMovilResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(mantencionMovilService.delete(id));
    }
}
