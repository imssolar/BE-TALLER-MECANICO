package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateItemMantencionNDto;
import com.tallermecanico.dto.request.UpdateItemMantencionNDto;
import com.tallermecanico.dto.response.DeleteItemMantencionNResponseDto;
import com.tallermecanico.entity.ItemMantencionN;
import com.tallermecanico.service.ItemMantencionNService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items-mantencion-n")
public class ItemMantencionNController {

    private final ItemMantencionNService itemMantencionNService;

    public ItemMantencionNController(ItemMantencionNService itemMantencionNService) {
        this.itemMantencionNService = itemMantencionNService;
    }

    @PostMapping
    public ResponseEntity<ItemMantencionN> create(@Valid @RequestBody CreateItemMantencionNDto dto) {
        ItemMantencionN item = itemMantencionNService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping
    public ResponseEntity<List<ItemMantencionN>> findAll() {
        List<ItemMantencionN> items = itemMantencionNService.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemMantencionN> findById(@PathVariable Integer id) {
        ItemMantencionN item = itemMantencionNService.findById(id);
        return ResponseEntity.ok(item);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemMantencionN> update(@PathVariable Integer id,
                                                   @Valid @RequestBody UpdateItemMantencionNDto dto) {
        ItemMantencionN item = itemMantencionNService.update(id, dto);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteItemMantencionNResponseDto> delete(@PathVariable Integer id) {
        DeleteItemMantencionNResponseDto response = itemMantencionNService.delete(id);
        return ResponseEntity.ok(response);
    }
}
