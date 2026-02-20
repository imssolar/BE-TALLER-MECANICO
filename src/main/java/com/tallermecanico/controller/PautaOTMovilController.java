package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreatePautaOTMovilDto;
import com.tallermecanico.dto.request.UpdatePautaOTMovilDto;
import com.tallermecanico.dto.response.DeletePautaOTMovilResponseDto;
import com.tallermecanico.entity.PautaOTMovil;
import com.tallermecanico.service.PautaOTMovilService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pautas-ot-moviles")
public class PautaOTMovilController {

    private final PautaOTMovilService pautaOTMovilService;

    public PautaOTMovilController(PautaOTMovilService pautaOTMovilService) {
        this.pautaOTMovilService = pautaOTMovilService;
    }

    @PostMapping
    public ResponseEntity<PautaOTMovil> create(@Valid @RequestBody CreatePautaOTMovilDto dto) {
        PautaOTMovil pautaOTMovil = pautaOTMovilService.create(dto);
        return new ResponseEntity<>(pautaOTMovil, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PautaOTMovil>> findAll() {
        return ResponseEntity.ok(pautaOTMovilService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaOTMovil> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(pautaOTMovilService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PautaOTMovil> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdatePautaOTMovilDto dto) {
        return ResponseEntity.ok(pautaOTMovilService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePautaOTMovilResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(pautaOTMovilService.delete(id));
    }
}
