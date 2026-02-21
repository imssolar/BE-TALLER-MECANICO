package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOTTallerExtDto;
import com.tallermecanico.dto.request.UpdateOTTallerExtDto;
import com.tallermecanico.dto.response.DeleteOTTallerExtResponseDto;
import com.tallermecanico.entity.OTTallerExt;
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
    public ResponseEntity<OTTallerExt> create(@Valid @RequestBody CreateOTTallerExtDto dto) {
        OTTallerExt otTallerExt = otTallerExtService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(otTallerExt);
    }

    @GetMapping
    public ResponseEntity<List<OTTallerExt>> findAll() {
        List<OTTallerExt> otTallerExts = otTallerExtService.findAll();
        return ResponseEntity.ok(otTallerExts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OTTallerExt> findById(@PathVariable Integer id) {
        OTTallerExt otTallerExt = otTallerExtService.findById(id);
        return ResponseEntity.ok(otTallerExt);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<OTTallerExt>> findByBus(@PathVariable Integer idBus) {
        List<OTTallerExt> otTallerExts = otTallerExtService.findByBus(idBus);
        return ResponseEntity.ok(otTallerExts);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OTTallerExt> update(@PathVariable Integer id,
                                               @Valid @RequestBody UpdateOTTallerExtDto dto) {
        OTTallerExt otTallerExt = otTallerExtService.update(id, dto);
        return ResponseEntity.ok(otTallerExt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOTTallerExtResponseDto> delete(@PathVariable Integer id) {
        DeleteOTTallerExtResponseDto response = otTallerExtService.delete(id);
        return ResponseEntity.ok(response);
    }
}
