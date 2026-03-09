package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateGlosaDto;
import com.tallermecanico.dto.request.UpdateGlosaDto;
import com.tallermecanico.dto.response.DeleteGlosaResponseDto;
import com.tallermecanico.entity.Glosa;
import com.tallermecanico.service.GlosaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/glosas")
public class GlosaController {

    private final GlosaService glosaService;

    public GlosaController(GlosaService glosaService) {
        this.glosaService = glosaService;
    }

    @PostMapping
    public ResponseEntity<Glosa> create(@Valid @RequestBody CreateGlosaDto dto) {
        Glosa glosa = glosaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(glosa);
    }

    @GetMapping
    public ResponseEntity<List<Glosa>> findAll() {
        List<Glosa> glosas = glosaService.findAll();
        return ResponseEntity.ok(glosas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Glosa> findById(@PathVariable Integer id) {
        Glosa glosa = glosaService.findById(id);
        return ResponseEntity.ok(glosa);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Glosa> update(@PathVariable Integer id,
                                        @Valid @RequestBody UpdateGlosaDto dto) {
        Glosa glosa = glosaService.update(id, dto);
        return ResponseEntity.ok(glosa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteGlosaResponseDto> delete(@PathVariable Integer id) {
        DeleteGlosaResponseDto response = glosaService.delete(id);
        return ResponseEntity.ok(response);
    }
}
