package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateItemRRHHDto;
import com.tallermecanico.dto.request.UpdateItemRRHHDto;
import com.tallermecanico.dto.response.DeleteItemRRHHResponseDto;
import com.tallermecanico.entity.ItemRRHH;
import com.tallermecanico.service.ItemRRHHService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items-rrhh")
public class ItemRRHHController {

    private final ItemRRHHService itemRRHHService;

    public ItemRRHHController(ItemRRHHService itemRRHHService) {
        this.itemRRHHService = itemRRHHService;
    }

    @PostMapping
    public ResponseEntity<ItemRRHH> create(@Valid @RequestBody CreateItemRRHHDto dto) {
        ItemRRHH itemRRHH = itemRRHHService.create(dto);
        return new ResponseEntity<>(itemRRHH, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemRRHH>> findAll() {
        return ResponseEntity.ok(itemRRHHService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemRRHH> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(itemRRHHService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemRRHH> update(@PathVariable Integer id,
                                            @Valid @RequestBody UpdateItemRRHHDto dto) {
        return ResponseEntity.ok(itemRRHHService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteItemRRHHResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(itemRRHHService.delete(id));
    }
}
