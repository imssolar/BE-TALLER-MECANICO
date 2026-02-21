package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateRepuestosManagerDto;
import com.tallermecanico.dto.request.UpdateRepuestosManagerDto;
import com.tallermecanico.dto.response.DeleteRepuestosManagerResponseDto;
import com.tallermecanico.entity.RepuestosManager;
import com.tallermecanico.service.RepuestosManagerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repuestos-manager")
public class RepuestosManagerController {

    private final RepuestosManagerService repuestosManagerService;

    public RepuestosManagerController(RepuestosManagerService repuestosManagerService) {
        this.repuestosManagerService = repuestosManagerService;
    }

    @PostMapping
    public ResponseEntity<RepuestosManager> create(@Valid @RequestBody CreateRepuestosManagerDto dto) {
        RepuestosManager repuestosManager = repuestosManagerService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(repuestosManager);
    }

    @GetMapping
    public ResponseEntity<List<RepuestosManager>> findAll() {
        List<RepuestosManager> repuestosManagers = repuestosManagerService.findAll();
        return ResponseEntity.ok(repuestosManagers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepuestosManager> findById(@PathVariable Integer id) {
        RepuestosManager repuestosManager = repuestosManagerService.findById(id);
        return ResponseEntity.ok(repuestosManager);
    }

    @GetMapping("/glosa/{idGlosa}")
    public ResponseEntity<List<RepuestosManager>> findByGlosa(@PathVariable Integer idGlosa) {
        List<RepuestosManager> repuestosManagers = repuestosManagerService.findByGlosa(idGlosa);
        return ResponseEntity.ok(repuestosManagers);
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<RepuestosManager>> findByTerminal(@PathVariable Integer idTerminal) {
        List<RepuestosManager> repuestosManagers = repuestosManagerService.findByTerminal(idTerminal);
        return ResponseEntity.ok(repuestosManagers);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RepuestosManager> update(@PathVariable Integer id,
                                                    @Valid @RequestBody UpdateRepuestosManagerDto dto) {
        RepuestosManager repuestosManager = repuestosManagerService.update(id, dto);
        return ResponseEntity.ok(repuestosManager);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRepuestosManagerResponseDto> delete(@PathVariable Integer id) {
        DeleteRepuestosManagerResponseDto response = repuestosManagerService.delete(id);
        return ResponseEntity.ok(response);
    }
}
