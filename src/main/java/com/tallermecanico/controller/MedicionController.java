package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMedicionDto;
import com.tallermecanico.dto.request.UpdateMedicionDto;
import com.tallermecanico.dto.response.DeleteMedicionResponseDto;
import com.tallermecanico.entity.Medicion;
import com.tallermecanico.service.MedicionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mediciones")
public class MedicionController {

    private final MedicionService medicionService;

    public MedicionController(MedicionService medicionService) {
        this.medicionService = medicionService;
    }

    @PostMapping
    public ResponseEntity<Medicion> create(@Valid @RequestBody CreateMedicionDto dto) {
        Medicion medicion = medicionService.create(dto);
        return new ResponseEntity<>(medicion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Medicion>> findAll() {
        return ResponseEntity.ok(medicionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicion> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(medicionService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Medicion> update(@PathVariable Integer id,
                                           @Valid @RequestBody UpdateMedicionDto dto) {
        return ResponseEntity.ok(medicionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMedicionResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(medicionService.delete(id));
    }
}
