package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateRelatorDto;
import com.tallermecanico.dto.request.UpdateRelatorDto;
import com.tallermecanico.dto.response.DeleteRelatorResponseDto;
import com.tallermecanico.entity.Relator;
import com.tallermecanico.service.RelatorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatores")
public class RelatorController {

    private final RelatorService relatorService;

    public RelatorController(RelatorService relatorService) {
        this.relatorService = relatorService;
    }

    @PostMapping
    public ResponseEntity<Relator> create(@Valid @RequestBody CreateRelatorDto dto) {
        Relator relator = relatorService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(relator);
    }

    @GetMapping
    public ResponseEntity<List<Relator>> findAll() {
        List<Relator> relatores = relatorService.findAll();
        return ResponseEntity.ok(relatores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relator> findById(@PathVariable Integer id) {
        Relator relator = relatorService.findById(id);
        return ResponseEntity.ok(relator);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Relator> update(@PathVariable Integer id,
                                           @Valid @RequestBody UpdateRelatorDto dto) {
        Relator relator = relatorService.update(id, dto);
        return ResponseEntity.ok(relator);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRelatorResponseDto> delete(@PathVariable Integer id) {
        DeleteRelatorResponseDto response = relatorService.delete(id);
        return ResponseEntity.ok(response);
    }
}
