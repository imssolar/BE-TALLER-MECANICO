package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOTTallerExtDto;
import com.tallermecanico.dto.request.UpdateOTTallerExtDto;
import com.tallermecanico.dto.response.DeleteOTTallerExtResponseDto;
import com.tallermecanico.dto.response.OTTallerExtResponseDto;
import com.tallermecanico.service.OTTallerExtService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ot-taller-ext")
public class OTTallerExtController {

    private final OTTallerExtService otTallerExtService;

    public OTTallerExtController(OTTallerExtService otTallerExtService) {
        this.otTallerExtService = otTallerExtService;
    }

    @PostMapping
    public ResponseEntity<OTTallerExtResponseDto> create(@Valid @RequestBody CreateOTTallerExtDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(otTallerExtService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<OTTallerExtResponseDto>> findAll() {
        return ResponseEntity.ok(otTallerExtService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OTTallerExtResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(otTallerExtService.findById(id));
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<OTTallerExtResponseDto>> findByBus(@PathVariable Integer idBus) {
        return ResponseEntity.ok(otTallerExtService.findByBus(idBus));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OTTallerExtResponseDto> update(@PathVariable Integer id,
                                                         @Valid @RequestBody UpdateOTTallerExtDto dto) {
        return ResponseEntity.ok(otTallerExtService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOTTallerExtResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(otTallerExtService.delete(id));
    }
}
