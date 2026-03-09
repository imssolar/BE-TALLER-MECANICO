package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateDetalleTrabOTDto;
import com.tallermecanico.dto.request.UpdateDetalleTrabOTDto;
import com.tallermecanico.dto.response.DeleteDetalleTrabOTResponseDto;
import com.tallermecanico.entity.DetalleTrabOT;
import com.tallermecanico.service.DetalleTrabOTService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-trab-ot")
public class DetalleTrabOTController {

    private final DetalleTrabOTService detalleTrabOTService;

    public DetalleTrabOTController(DetalleTrabOTService detalleTrabOTService) {
        this.detalleTrabOTService = detalleTrabOTService;
    }

    @PostMapping
    public ResponseEntity<DetalleTrabOT> create(@Valid @RequestBody CreateDetalleTrabOTDto dto) {
        DetalleTrabOT detalle = detalleTrabOTService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalle);
    }

    @GetMapping
    public ResponseEntity<List<DetalleTrabOT>> findAll() {
        List<DetalleTrabOT> detalles = detalleTrabOTService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleTrabOT> findById(@PathVariable Integer id) {
        DetalleTrabOT detalle = detalleTrabOTService.findById(id);
        return ResponseEntity.ok(detalle);
    }

    @GetMapping("/orden-trabajo/{idOrdenTrabajo}")
    public ResponseEntity<List<DetalleTrabOT>> findByOrdenTrabajo(@PathVariable Integer idOrdenTrabajo) {
        List<DetalleTrabOT> detalles = detalleTrabOTService.findByOrdenTrabajo(idOrdenTrabajo);
        return ResponseEntity.ok(detalles);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DetalleTrabOT> update(@PathVariable Integer id,
                                                 @Valid @RequestBody UpdateDetalleTrabOTDto dto) {
        DetalleTrabOT detalle = detalleTrabOTService.update(id, dto);
        return ResponseEntity.ok(detalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteDetalleTrabOTResponseDto> delete(@PathVariable Integer id) {
        DeleteDetalleTrabOTResponseDto response = detalleTrabOTService.delete(id);
        return ResponseEntity.ok(response);
    }
}
