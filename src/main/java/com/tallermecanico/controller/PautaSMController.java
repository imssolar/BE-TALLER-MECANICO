package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreatePautaSMDto;
import com.tallermecanico.dto.request.UpdatePautaSMDto;
import com.tallermecanico.dto.response.DeletePautaSMResponseDto;
import com.tallermecanico.entity.PautaSM;
import com.tallermecanico.service.PautaSMService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pautas-sm")
public class PautaSMController {

    private final PautaSMService pautaSMService;

    public PautaSMController(PautaSMService pautaSMService) {
        this.pautaSMService = pautaSMService;
    }

    @PostMapping
    public ResponseEntity<PautaSM> create(@Valid @RequestBody CreatePautaSMDto dto) {
        PautaSM pautaSM = pautaSMService.create(dto);
        return new ResponseEntity<>(pautaSM, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PautaSM>> findAll() {
        return ResponseEntity.ok(pautaSMService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaSM> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(pautaSMService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PautaSM> update(@PathVariable Integer id,
                                           @Valid @RequestBody UpdatePautaSMDto dto) {
        return ResponseEntity.ok(pautaSMService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePautaSMResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(pautaSMService.delete(id));
    }
}
