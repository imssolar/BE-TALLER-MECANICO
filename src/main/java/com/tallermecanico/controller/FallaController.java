package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateFallaDto;
import com.tallermecanico.dto.request.UpdateFallaDto;
import com.tallermecanico.entity.Falla;
import com.tallermecanico.service.FallaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fallas")
public class FallaController {
    private final FallaService fallaService;

    public FallaController(FallaService fallaService){
        this.fallaService = fallaService;
    }

    @PostMapping
    public ResponseEntity<Falla> create(@Valid @RequestBody CreateFallaDto dto){
        Falla falla =  fallaService.createFalla(dto);
        return ResponseEntity.status(201).body(falla);
    }

    @GetMapping
    public List<Falla> getAll(){
        return fallaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Falla> getFallaByID(@PathVariable String id){
        Falla falla = fallaService.findById(id);
        return ResponseEntity.ok(falla);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Falla> update(@PathVariable String id, @Valid @RequestBody UpdateFallaDto dto){
        Falla falla = fallaService.update(id,dto);
        return ResponseEntity.ok(falla);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        fallaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
