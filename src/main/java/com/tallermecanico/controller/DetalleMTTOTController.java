package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateDetalleMTTOTDto;
import com.tallermecanico.dto.request.UpdateDetalleMTTOTDto;
import com.tallermecanico.dto.response.DeleteDetalleMTTOTResponseDto;
import com.tallermecanico.entity.DetalleMTTOT;
import com.tallermecanico.service.DetalleMTTOTService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-mtt-ot")
public class DetalleMTTOTController {

    private final DetalleMTTOTService detalleMTTOTService;

    public DetalleMTTOTController(DetalleMTTOTService detalleMTTOTService) {
        this.detalleMTTOTService = detalleMTTOTService;
    }

    @PostMapping
    public ResponseEntity<DetalleMTTOT> create(@Valid @RequestBody CreateDetalleMTTOTDto dto) {
        DetalleMTTOT detalle = detalleMTTOTService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalle);
    }

    @GetMapping
    public ResponseEntity<List<DetalleMTTOT>> findAll() {
        List<DetalleMTTOT> detalles = detalleMTTOTService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleMTTOT> findById(@PathVariable Integer id) {
        DetalleMTTOT detalle = detalleMTTOTService.findById(id);
        return ResponseEntity.ok(detalle);
    }

    @GetMapping("/orden-trabajo/{idOrdenTrabajo}")
    public ResponseEntity<List<DetalleMTTOT>> findByOrdenTrabajo(@PathVariable Integer idOrdenTrabajo) {
        List<DetalleMTTOT> detalles = detalleMTTOTService.findByOrdenTrabajo(idOrdenTrabajo);
        return ResponseEntity.ok(detalles);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DetalleMTTOT> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdateDetalleMTTOTDto dto) {
        DetalleMTTOT detalle = detalleMTTOTService.update(id, dto);
        return ResponseEntity.ok(detalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteDetalleMTTOTResponseDto> delete(@PathVariable Integer id) {
        DeleteDetalleMTTOTResponseDto response = detalleMTTOTService.delete(id);
        return ResponseEntity.ok(response);
    }
}
