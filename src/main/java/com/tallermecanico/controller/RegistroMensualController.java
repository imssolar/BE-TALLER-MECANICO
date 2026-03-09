package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateRegistroMensualDto;
import com.tallermecanico.dto.request.UpdateRegistroMensualDto;
import com.tallermecanico.dto.response.DeleteRegistroMensualResponseDto;
import com.tallermecanico.entity.RegistroMensual;
import com.tallermecanico.service.RegistroMensualService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro-mensual")
public class RegistroMensualController {

    private final RegistroMensualService registroMensualService;

    public RegistroMensualController(RegistroMensualService registroMensualService) {
        this.registroMensualService = registroMensualService;
    }

    @PostMapping
    public ResponseEntity<RegistroMensual> create(@Valid @RequestBody CreateRegistroMensualDto dto) {
        RegistroMensual registroMensual = registroMensualService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroMensual);
    }

    @GetMapping
    public ResponseEntity<List<RegistroMensual>> findAll() {
        List<RegistroMensual> registros = registroMensualService.findAll();
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroMensual> findById(@PathVariable Integer id) {
        RegistroMensual registroMensual = registroMensualService.findById(id);
        return ResponseEntity.ok(registroMensual);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<RegistroMensual>> findByTipo(@PathVariable String tipo) {
        List<RegistroMensual> registros = registroMensualService.findByTipo(tipo);
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/anio/{anio}")
    public ResponseEntity<List<RegistroMensual>> findByAnio(@PathVariable Integer anio) {
        List<RegistroMensual> registros = registroMensualService.findByAnio(anio);
        return ResponseEntity.ok(registros);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RegistroMensual> update(@PathVariable Integer id,
                                                   @Valid @RequestBody UpdateRegistroMensualDto dto) {
        RegistroMensual registroMensual = registroMensualService.update(id, dto);
        return ResponseEntity.ok(registroMensual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRegistroMensualResponseDto> delete(@PathVariable Integer id) {
        DeleteRegistroMensualResponseDto response = registroMensualService.delete(id);
        return ResponseEntity.ok(response);
    }
}
