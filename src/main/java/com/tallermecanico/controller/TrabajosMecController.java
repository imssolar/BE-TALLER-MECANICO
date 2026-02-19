package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateTrabajosMecDto;
import com.tallermecanico.dto.request.UpdateTrabajosMecDto;
import com.tallermecanico.dto.response.DeleteTrabajosMecResponseDto;
import com.tallermecanico.entity.TrabajosMec;
import com.tallermecanico.service.TrabajoMecService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajos-mec")
public class TrabajosMecController {

    private final TrabajoMecService trabajoMecService;

    public TrabajosMecController(TrabajoMecService trabajoMecService) {
        this.trabajoMecService = trabajoMecService;
    }

    @PostMapping
    public ResponseEntity<TrabajosMec> create(@Valid @RequestBody CreateTrabajosMecDto dto) {
        TrabajosMec trabajosMec = trabajoMecService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(trabajosMec);
    }

    @GetMapping
    public ResponseEntity<List<TrabajosMec>> findAll() {
        List<TrabajosMec> trabajosMec = trabajoMecService.findAll();
        return ResponseEntity.ok(trabajosMec);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabajosMec> findById(@PathVariable Integer id) {
        TrabajosMec trabajosMec = trabajoMecService.findById(id);
        return ResponseEntity.ok(trabajosMec);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TrabajosMec> update(@PathVariable Integer id,
                                              @Valid @RequestBody UpdateTrabajosMecDto dto) {
        TrabajosMec trabajosMec = trabajoMecService.update(id, dto);
        return ResponseEntity.ok(trabajosMec);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTrabajosMecResponseDto> delete(@PathVariable Integer id) {
        DeleteTrabajosMecResponseDto response = trabajoMecService.delete(id);
        return ResponseEntity.ok(response);
    }
}
