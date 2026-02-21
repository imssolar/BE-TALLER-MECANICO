package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOTTecnicoDto;
import com.tallermecanico.dto.request.UpdateOTTecnicoDto;
import com.tallermecanico.dto.response.DeleteOTTecnicoResponseDto;
import com.tallermecanico.entity.OTTecnico;
import com.tallermecanico.service.OTTecnicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ot-tecnicos")
public class OTTecnicoController {

    private final OTTecnicoService otTecnicoService;

    public OTTecnicoController(OTTecnicoService otTecnicoService) {
        this.otTecnicoService = otTecnicoService;
    }

    @PostMapping
    public ResponseEntity<OTTecnico> create(@Valid @RequestBody CreateOTTecnicoDto dto) {
        OTTecnico tecnico = otTecnicoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnico);
    }

    @GetMapping
    public ResponseEntity<List<OTTecnico>> findAll() {
        List<OTTecnico> tecnicos = otTecnicoService.findAll();
        return ResponseEntity.ok(tecnicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OTTecnico> findById(@PathVariable Integer id) {
        OTTecnico tecnico = otTecnicoService.findById(id);
        return ResponseEntity.ok(tecnico);
    }

    @GetMapping("/orden-trabajo/{idOrdenTrabajo}")
    public ResponseEntity<List<OTTecnico>> findByOrdenTrabajo(@PathVariable Integer idOrdenTrabajo) {
        List<OTTecnico> tecnicos = otTecnicoService.findByOrdenTrabajo(idOrdenTrabajo);
        return ResponseEntity.ok(tecnicos);
    }

    @GetMapping("/orden-trabajo-prog/{idOrdenTrabajoProg}")
    public ResponseEntity<List<OTTecnico>> findByOrdenTrabajoProg(@PathVariable Integer idOrdenTrabajoProg) {
        List<OTTecnico> tecnicos = otTecnicoService.findByOrdenTrabajoProg(idOrdenTrabajoProg);
        return ResponseEntity.ok(tecnicos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OTTecnico> update(@PathVariable Integer id,
                                             @Valid @RequestBody UpdateOTTecnicoDto dto) {
        OTTecnico tecnico = otTecnicoService.update(id, dto);
        return ResponseEntity.ok(tecnico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOTTecnicoResponseDto> delete(@PathVariable Integer id) {
        DeleteOTTecnicoResponseDto response = otTecnicoService.delete(id);
        return ResponseEntity.ok(response);
    }
}
