package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateTallerExternoDto;
import com.tallermecanico.dto.request.UpdateTallerExternoDto;
import com.tallermecanico.dto.response.DeleteTallerExternoResponseDto;
import com.tallermecanico.entity.TallerExterno;
import com.tallermecanico.service.TallerExternoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taller-externo")
public class TallerExternoController {

    private final TallerExternoService tallerExternoService;

    public TallerExternoController(TallerExternoService tallerExternoService) {
        this.tallerExternoService = tallerExternoService;
    }

    @PostMapping
    public ResponseEntity<TallerExterno> create(@Valid @RequestBody CreateTallerExternoDto dto) {
        TallerExterno tallerExterno = tallerExternoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tallerExterno);
    }

    @GetMapping
    public ResponseEntity<List<TallerExterno>> findAll() {
        List<TallerExterno> talleresExternos = tallerExternoService.findAll();
        return ResponseEntity.ok(talleresExternos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TallerExterno> findById(@PathVariable Integer id) {
        TallerExterno tallerExterno = tallerExternoService.findById(id);
        return ResponseEntity.ok(tallerExterno);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TallerExterno> update(@PathVariable Integer id,
                                                 @Valid @RequestBody UpdateTallerExternoDto dto) {
        TallerExterno tallerExterno = tallerExternoService.update(id, dto);
        return ResponseEntity.ok(tallerExterno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTallerExternoResponseDto> delete(@PathVariable Integer id) {
        DeleteTallerExternoResponseDto response = tallerExternoService.delete(id);
        return ResponseEntity.ok(response);
    }
}
