package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreatePagoBonosDetalleDto;
import com.tallermecanico.dto.request.UpdatePagoBonosDetalleDto;
import com.tallermecanico.dto.response.DeletePagoBonosDetalleResponseDto;
import com.tallermecanico.entity.PagoBonosDetalle;
import com.tallermecanico.service.PagoBonosDetalleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago-bonos-detalle")
public class PagoBonosDetalleController {

    private final PagoBonosDetalleService pagoBonosDetalleService;

    public PagoBonosDetalleController(PagoBonosDetalleService pagoBonosDetalleService) {
        this.pagoBonosDetalleService = pagoBonosDetalleService;
    }

    @PostMapping
    public ResponseEntity<PagoBonosDetalle> create(@Valid @RequestBody CreatePagoBonosDetalleDto dto) {
        PagoBonosDetalle detalle = pagoBonosDetalleService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalle);
    }

    @GetMapping
    public ResponseEntity<List<PagoBonosDetalle>> findAll() {
        List<PagoBonosDetalle> detalles = pagoBonosDetalleService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoBonosDetalle> findById(@PathVariable Integer id) {
        PagoBonosDetalle detalle = pagoBonosDetalleService.findById(id);
        return ResponseEntity.ok(detalle);
    }

    @GetMapping("/pago-bonos/{idPagoBonos}")
    public ResponseEntity<List<PagoBonosDetalle>> findByPagoBonos(@PathVariable Integer idPagoBonos) {
        List<PagoBonosDetalle> detalles = pagoBonosDetalleService.findByPagoBonos(idPagoBonos);
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<PagoBonosDetalle>> findByBus(@PathVariable Integer idBus) {
        List<PagoBonosDetalle> detalles = pagoBonosDetalleService.findByBus(idBus);
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<PagoBonosDetalle>> findByRut(@PathVariable String rut) {
        List<PagoBonosDetalle> detalles = pagoBonosDetalleService.findByRut(rut);
        return ResponseEntity.ok(detalles);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PagoBonosDetalle> update(@PathVariable Integer id,
                                                    @Valid @RequestBody UpdatePagoBonosDetalleDto dto) {
        PagoBonosDetalle detalle = pagoBonosDetalleService.update(id, dto);
        return ResponseEntity.ok(detalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePagoBonosDetalleResponseDto> delete(@PathVariable Integer id) {
        DeletePagoBonosDetalleResponseDto response = pagoBonosDetalleService.delete(id);
        return ResponseEntity.ok(response);
    }
}
