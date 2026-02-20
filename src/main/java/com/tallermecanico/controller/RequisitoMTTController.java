package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateRequisitoMTTDto;
import com.tallermecanico.dto.request.UpdateRequisitoMTTDto;
import com.tallermecanico.dto.response.DeleteRequisitoMTTResponseDto;
import com.tallermecanico.entity.RequisitoMTT;
import com.tallermecanico.service.RequisitoMTTService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requisitos-mtt")
public class RequisitoMTTController {

    private final RequisitoMTTService requisitoMTTService;

    public RequisitoMTTController(RequisitoMTTService requisitoMTTService) {
        this.requisitoMTTService = requisitoMTTService;
    }

    @PostMapping
    public ResponseEntity<RequisitoMTT> create(@Valid @RequestBody CreateRequisitoMTTDto dto) {
        RequisitoMTT requisitoMTT = requisitoMTTService.create(dto);
        return new ResponseEntity<>(requisitoMTT, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RequisitoMTT>> findAll() {
        return ResponseEntity.ok(requisitoMTTService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequisitoMTT> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(requisitoMTTService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RequisitoMTT> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdateRequisitoMTTDto dto) {
        return ResponseEntity.ok(requisitoMTTService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRequisitoMTTResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(requisitoMTTService.delete(id));
    }
}
