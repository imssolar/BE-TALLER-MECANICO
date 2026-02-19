package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateTipoVisaDto;
import com.tallermecanico.dto.request.UpdateTipoVisaDto;
import com.tallermecanico.dto.response.DeleteTipoVisaResponseDto;
import com.tallermecanico.entity.TipoVisa;
import com.tallermecanico.service.TipoVisaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-visa")
public class TipoVisaController {

    private final TipoVisaService tipoVisaService;

    public TipoVisaController(TipoVisaService tipoVisaService) {
        this.tipoVisaService = tipoVisaService;
    }

    @PostMapping
    public ResponseEntity<TipoVisa> create(@Valid @RequestBody CreateTipoVisaDto dto) {
        TipoVisa tipoVisa = tipoVisaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoVisa);
    }

    @GetMapping
    public ResponseEntity<List<TipoVisa>> findAll() {
        List<TipoVisa> tiposVisa = tipoVisaService.findAll();
        return ResponseEntity.ok(tiposVisa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoVisa> findById(@PathVariable Integer id) {
        TipoVisa tipoVisa = tipoVisaService.findById(id);
        return ResponseEntity.ok(tipoVisa);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoVisa> update(@PathVariable Integer id,
                                            @Valid @RequestBody UpdateTipoVisaDto dto) {
        TipoVisa tipoVisa = tipoVisaService.update(id, dto);
        return ResponseEntity.ok(tipoVisa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTipoVisaResponseDto> delete(@PathVariable Integer id) {
        DeleteTipoVisaResponseDto response = tipoVisaService.delete(id);
        return ResponseEntity.ok(response);
    }
}
