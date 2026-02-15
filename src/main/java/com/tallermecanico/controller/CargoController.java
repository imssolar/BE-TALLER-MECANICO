package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateCargoDto;
import com.tallermecanico.entity.Cargo;
import com.tallermecanico.service.CargoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {
    private final CargoService cargoService;

    public CargoController(CargoService cargoService){
        this.cargoService = cargoService;
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> findAll(){
        List<Cargo> cargos = cargoService.findAll();
        return ResponseEntity.ok(cargos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> findById(@PathVariable Integer id){
        Cargo cargo = cargoService.findByID(id);
        return ResponseEntity.ok(cargo);
    }

    @PostMapping
    public ResponseEntity<Cargo> create(@Valid @RequestBody CreateCargoDto createCargoDto){
        Cargo cargo = cargoService.create(createCargoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cargo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cargo> update(@PathVariable  Integer id,@Valid @RequestBody CreateCargoDto createCargoDto){
        Cargo cargo = cargoService.update(id, createCargoDto);
        return ResponseEntity.ok(cargo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable  Integer id){
        cargoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

