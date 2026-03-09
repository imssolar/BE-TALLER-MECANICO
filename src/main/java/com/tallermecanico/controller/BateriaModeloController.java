package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateBateriaModeloDto;
import com.tallermecanico.dto.request.UpdateBateriaModeloDto;
import com.tallermecanico.dto.response.DeleteBateriaModeloResponseDto;
import com.tallermecanico.entity.BateriaModelo;
import com.tallermecanico.service.BateriaModeloService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bateria-modelos")
public class BateriaModeloController {

    private final BateriaModeloService bateriaModeloService;

    public BateriaModeloController(BateriaModeloService bateriaModeloService) {
        this.bateriaModeloService = bateriaModeloService;
    }

    @PostMapping
    public ResponseEntity<BateriaModelo> create(@Valid @RequestBody CreateBateriaModeloDto dto) {
        BateriaModelo bateriaModelo = bateriaModeloService.create(dto);
        return new ResponseEntity<>(bateriaModelo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BateriaModelo>> findAll() {
        return ResponseEntity.ok(bateriaModeloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BateriaModelo> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(bateriaModeloService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BateriaModelo> update(@PathVariable Integer id,
                                                 @Valid @RequestBody UpdateBateriaModeloDto dto) {
        return ResponseEntity.ok(bateriaModeloService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteBateriaModeloResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(bateriaModeloService.delete(id));
    }
}
