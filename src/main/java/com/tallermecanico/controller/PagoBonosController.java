package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreatePagoBonosDto;
import com.tallermecanico.dto.request.UpdatePagoBonosDto;
import com.tallermecanico.dto.response.DeletePagoBonosResponseDto;
import com.tallermecanico.entity.PagoBonos;
import com.tallermecanico.service.PagoBonosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago-bonos")
public class PagoBonosController {

    private final PagoBonosService pagoBonosService;

    public PagoBonosController(PagoBonosService pagoBonosService) {
        this.pagoBonosService = pagoBonosService;
    }

    @PostMapping
    public ResponseEntity<PagoBonos> create(@Valid @RequestBody CreatePagoBonosDto dto) {
        PagoBonos pagoBonos = pagoBonosService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoBonos);
    }

    @GetMapping
    public ResponseEntity<List<PagoBonos>> findAll() {
        List<PagoBonos> pagoBonosList = pagoBonosService.findAll();
        return ResponseEntity.ok(pagoBonosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoBonos> findById(@PathVariable Integer id) {
        PagoBonos pagoBonos = pagoBonosService.findById(id);
        return ResponseEntity.ok(pagoBonos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PagoBonos> update(@PathVariable Integer id,
                                            @Valid @RequestBody UpdatePagoBonosDto dto) {
        PagoBonos pagoBonos = pagoBonosService.update(id, dto);
        return ResponseEntity.ok(pagoBonos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePagoBonosResponseDto> delete(@PathVariable Integer id) {
        DeletePagoBonosResponseDto response = pagoBonosService.delete(id);
        return ResponseEntity.ok(response);
    }
}
