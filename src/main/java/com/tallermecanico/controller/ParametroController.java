package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateParametroDto;
import com.tallermecanico.dto.request.UpdateParametroDto;
import com.tallermecanico.dto.response.DeleteParametroResponseDto;
import com.tallermecanico.entity.Parametro;
import com.tallermecanico.service.ParametroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parametros")
public class ParametroController {

    private final ParametroService parametroService;

    public ParametroController(ParametroService parametroService) {
        this.parametroService = parametroService;
    }

    @PostMapping
    public ResponseEntity<Parametro> create(@Valid @RequestBody CreateParametroDto dto) {
        Parametro parametro = parametroService.create(dto);
        return new ResponseEntity<>(parametro, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Parametro>> findAll() {
        return ResponseEntity.ok(parametroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parametro> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(parametroService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Parametro> update(@PathVariable Integer id,
                                             @Valid @RequestBody UpdateParametroDto dto) {
        return ResponseEntity.ok(parametroService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteParametroResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(parametroService.delete(id));
    }
}
