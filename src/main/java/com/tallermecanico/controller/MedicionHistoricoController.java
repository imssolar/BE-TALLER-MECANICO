package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMedicionHistoricoDto;
import com.tallermecanico.dto.request.UpdateMedicionHistoricoDto;
import com.tallermecanico.dto.response.DeleteMedicionHistoricoResponseDto;
import com.tallermecanico.entity.MedicionHistorico;
import com.tallermecanico.service.MedicionHistoricoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicion-historico")
public class MedicionHistoricoController {

    private final MedicionHistoricoService medicionHistoricoService;

    public MedicionHistoricoController(MedicionHistoricoService medicionHistoricoService) {
        this.medicionHistoricoService = medicionHistoricoService;
    }

    @PostMapping
    public ResponseEntity<MedicionHistorico> create(@Valid @RequestBody CreateMedicionHistoricoDto dto) {
        MedicionHistorico medicionHistorico = medicionHistoricoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicionHistorico);
    }

    @GetMapping
    public ResponseEntity<List<MedicionHistorico>> findAll() {
        return ResponseEntity.ok(medicionHistoricoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicionHistorico> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(medicionHistoricoService.findById(id));
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<MedicionHistorico>> findByBus(@PathVariable Integer idBus) {
        return ResponseEntity.ok(medicionHistoricoService.findByBus(idBus));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MedicionHistorico> update(@PathVariable Integer id,
                                                    @Valid @RequestBody UpdateMedicionHistoricoDto dto) {
        return ResponseEntity.ok(medicionHistoricoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMedicionHistoricoResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(medicionHistoricoService.delete(id));
    }
}
