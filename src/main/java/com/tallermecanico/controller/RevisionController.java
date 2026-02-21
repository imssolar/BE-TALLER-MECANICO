package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateRevisionDto;
import com.tallermecanico.dto.request.UpdateRevisionDto;
import com.tallermecanico.dto.response.DeleteRevisionResponseDto;
import com.tallermecanico.entity.Revision;
import com.tallermecanico.service.RevisionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revisiones")
public class RevisionController {

    private final RevisionService revisionService;

    public RevisionController(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    @PostMapping
    public ResponseEntity<Revision> create(@Valid @RequestBody CreateRevisionDto dto) {
        Revision revision = revisionService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(revision);
    }

    @GetMapping
    public ResponseEntity<List<Revision>> findAll() {
        List<Revision> revisiones = revisionService.findAll();
        return ResponseEntity.ok(revisiones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revision> findById(@PathVariable Integer id) {
        Revision revision = revisionService.findById(id);
        return ResponseEntity.ok(revision);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<Revision>> findByBus(@PathVariable Integer idBus) {
        List<Revision> revisiones = revisionService.findByBus(idBus);
        return ResponseEntity.ok(revisiones);
    }

    @GetMapping("/plan-revisiones/{idPlanRevisiones}")
    public ResponseEntity<List<Revision>> findByPlanRevisiones(@PathVariable Integer idPlanRevisiones) {
        List<Revision> revisiones = revisionService.findByPlanRevisiones(idPlanRevisiones);
        return ResponseEntity.ok(revisiones);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Revision> update(@PathVariable Integer id,
                                           @Valid @RequestBody UpdateRevisionDto dto) {
        Revision revision = revisionService.update(id, dto);
        return ResponseEntity.ok(revision);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRevisionResponseDto> delete(@PathVariable Integer id) {
        DeleteRevisionResponseDto response = revisionService.delete(id);
        return ResponseEntity.ok(response);
    }
}
