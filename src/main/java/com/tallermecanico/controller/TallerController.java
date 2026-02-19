package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateTallerDto;
import com.tallermecanico.dto.request.UpdateTallerDto;
import com.tallermecanico.dto.response.DeleteTallerResponseDto;
import com.tallermecanico.entity.Taller;
import com.tallermecanico.service.TallerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talleres")
public class TallerController {

    private final TallerService tallerService;

    public TallerController(TallerService tallerService) {
        this.tallerService = tallerService;
    }

    @PostMapping
    public ResponseEntity<Taller> create(@Valid @RequestBody CreateTallerDto dto) {
        Taller taller = tallerService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(taller);
    }

    @GetMapping
    public ResponseEntity<List<Taller>> findAll() {
        List<Taller> talleres = tallerService.findAll();
        return ResponseEntity.ok(talleres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taller> findById(@PathVariable Integer id) {
        Taller taller = tallerService.findById(id);
        return ResponseEntity.ok(taller);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Taller> update(@PathVariable Integer id,
                                          @Valid @RequestBody UpdateTallerDto dto) {
        Taller taller = tallerService.update(id, dto);
        return ResponseEntity.ok(taller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTallerResponseDto> delete(@PathVariable Integer id) {
        DeleteTallerResponseDto response = tallerService.delete(id);
        return ResponseEntity.ok(response);
    }
}
