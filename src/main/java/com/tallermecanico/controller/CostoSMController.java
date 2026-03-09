package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateCostoSMDto;
import com.tallermecanico.dto.request.UpdateCostoSMDto;
import com.tallermecanico.dto.response.DeleteCostoSMResponseDto;
import com.tallermecanico.entity.CostoSM;
import com.tallermecanico.service.CostoSMService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costos-sm")
public class CostoSMController {

    private final CostoSMService costoSMService;

    public CostoSMController(CostoSMService costoSMService) {
        this.costoSMService = costoSMService;
    }

    @PostMapping
    public ResponseEntity<CostoSM> create(@Valid @RequestBody CreateCostoSMDto dto) {
        CostoSM costoSM = costoSMService.create(dto);
        return new ResponseEntity<>(costoSM, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CostoSM>> findAll() {
        return ResponseEntity.ok(costoSMService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostoSM> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(costoSMService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CostoSM> update(@PathVariable Integer id,
                                           @Valid @RequestBody UpdateCostoSMDto dto) {
        return ResponseEntity.ok(costoSMService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCostoSMResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(costoSMService.delete(id));
    }
}
