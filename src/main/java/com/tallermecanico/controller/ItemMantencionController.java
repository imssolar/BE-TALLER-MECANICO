package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateItemMantencionDto;
import com.tallermecanico.dto.request.UpdateItemMantencionDto;
import com.tallermecanico.dto.response.DeleteItemMantencionResponseDto;
import com.tallermecanico.entity.ItemMantencion;
import com.tallermecanico.service.ItemMantencionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items-mantencion")
public class ItemMantencionController {

    private final ItemMantencionService itemMantencionService;

    public ItemMantencionController(ItemMantencionService itemMantencionService) {
        this.itemMantencionService = itemMantencionService;
    }

    @PostMapping
    public ResponseEntity<ItemMantencion> create(@Valid @RequestBody CreateItemMantencionDto dto) {
        ItemMantencion itemMantencion = itemMantencionService.create(dto);
        return new ResponseEntity<>(itemMantencion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemMantencion>> findAll() {
        return ResponseEntity.ok(itemMantencionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemMantencion> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(itemMantencionService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemMantencion> update(@PathVariable Integer id,
                                                  @Valid @RequestBody UpdateItemMantencionDto dto) {
        return ResponseEntity.ok(itemMantencionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteItemMantencionResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(itemMantencionService.delete(id));
    }
}
