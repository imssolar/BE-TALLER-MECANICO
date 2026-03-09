package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateBusTallerCarDto;
import com.tallermecanico.dto.request.UpdateBusTallerCarDto;
import com.tallermecanico.dto.response.DeleteBusTallerCarResponseDto;
import com.tallermecanico.entity.BusTallerCar;
import com.tallermecanico.service.BusTallerCarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buses-taller-car")
public class BusTallerCarController {

    private final BusTallerCarService busTallerCarService;

    public BusTallerCarController(BusTallerCarService busTallerCarService) {
        this.busTallerCarService = busTallerCarService;
    }

    @PostMapping
    public ResponseEntity<BusTallerCar> create(@Valid @RequestBody CreateBusTallerCarDto dto) {
        BusTallerCar bus = busTallerCarService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bus);
    }

    @GetMapping
    public ResponseEntity<List<BusTallerCar>> findAll() {
        List<BusTallerCar> buses = busTallerCarService.findAll();
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/{idBus}")
    public ResponseEntity<BusTallerCar> findById(@PathVariable Integer idBus) {
        BusTallerCar bus = busTallerCarService.findById(idBus);
        return ResponseEntity.ok(bus);
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<BusTallerCar>> findByTerminal(@PathVariable Integer idTerminal) {
        List<BusTallerCar> buses = busTallerCarService.findByTerminal(idTerminal);
        return ResponseEntity.ok(buses);
    }

    @PatchMapping("/{idBus}")
    public ResponseEntity<BusTallerCar> update(@PathVariable Integer idBus,
                                               @Valid @RequestBody UpdateBusTallerCarDto dto) {
        BusTallerCar bus = busTallerCarService.update(idBus, dto);
        return ResponseEntity.ok(bus);
    }

    @DeleteMapping("/{idBus}")
    public ResponseEntity<DeleteBusTallerCarResponseDto> delete(@PathVariable Integer idBus) {
        DeleteBusTallerCarResponseDto response = busTallerCarService.delete(idBus);
        return ResponseEntity.ok(response);
    }
}
