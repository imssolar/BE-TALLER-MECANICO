package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateObservacionHojaVidaDto;
import com.tallermecanico.dto.request.UpdateObservacionHojaVidaDto;
import com.tallermecanico.dto.response.DeleteObservacionHojaVidaResponseDto;
import com.tallermecanico.entity.ObservacionHojaVida;
import com.tallermecanico.service.ObservacionHojaVidaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observacion-hoja-vida")
public class ObservacionHojaVidaController {

    private final ObservacionHojaVidaService observacionHojaVidaService;

    public ObservacionHojaVidaController(ObservacionHojaVidaService observacionHojaVidaService) {
        this.observacionHojaVidaService = observacionHojaVidaService;
    }

    @PostMapping
    public ResponseEntity<ObservacionHojaVida> create(@Valid @RequestBody CreateObservacionHojaVidaDto dto) {
        ObservacionHojaVida observacionHojaVida = observacionHojaVidaService.create(dto);
        return new ResponseEntity<>(observacionHojaVida, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ObservacionHojaVida>> findAll() {
        return ResponseEntity.ok(observacionHojaVidaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObservacionHojaVida> findById(@PathVariable String id) {
        return ResponseEntity.ok(observacionHojaVidaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ObservacionHojaVida> update(@PathVariable String id,
                                                       @Valid @RequestBody UpdateObservacionHojaVidaDto dto) {
        return ResponseEntity.ok(observacionHojaVidaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteObservacionHojaVidaResponseDto> delete(@PathVariable String id) {
        return ResponseEntity.ok(observacionHojaVidaService.delete(id));
    }
}
