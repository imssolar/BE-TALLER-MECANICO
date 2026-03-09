package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateHojaVidaEmpleadoDto;
import com.tallermecanico.dto.request.UpdateHojaVidaEmpleadoDto;
import com.tallermecanico.dto.response.DeleteHojaVidaEmpleadoResponseDto;
import com.tallermecanico.entity.HojaVidaEmpleado;
import com.tallermecanico.service.HojaVidaEmpleadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoja-vida-empleados")
public class HojaVidaEmpleadoController {

    private final HojaVidaEmpleadoService hojaVidaEmpleadoService;

    public HojaVidaEmpleadoController(HojaVidaEmpleadoService hojaVidaEmpleadoService) {
        this.hojaVidaEmpleadoService = hojaVidaEmpleadoService;
    }

    @PostMapping
    public ResponseEntity<HojaVidaEmpleado> create(@Valid @RequestBody CreateHojaVidaEmpleadoDto dto) {
        HojaVidaEmpleado hojaVida = hojaVidaEmpleadoService.create(dto);
        return new ResponseEntity<>(hojaVida, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HojaVidaEmpleado>> findAll() {
        return ResponseEntity.ok(hojaVidaEmpleadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HojaVidaEmpleado> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(hojaVidaEmpleadoService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HojaVidaEmpleado> update(@PathVariable Integer id,
                                                     @Valid @RequestBody UpdateHojaVidaEmpleadoDto dto) {
        return ResponseEntity.ok(hojaVidaEmpleadoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteHojaVidaEmpleadoResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(hojaVidaEmpleadoService.delete(id));
    }
}
