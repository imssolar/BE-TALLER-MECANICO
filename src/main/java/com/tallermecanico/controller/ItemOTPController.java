package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateItemOTPDto;
import com.tallermecanico.dto.request.UpdateItemOTPDto;
import com.tallermecanico.dto.response.DeleteItemOTPResponseDto;
import com.tallermecanico.entity.ItemOTP;
import com.tallermecanico.service.ItemOTPService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items-otp")
public class ItemOTPController {

    private final ItemOTPService itemOTPService;

    public ItemOTPController(ItemOTPService itemOTPService) {
        this.itemOTPService = itemOTPService;
    }

    @PostMapping
    public ResponseEntity<ItemOTP> create(@Valid @RequestBody CreateItemOTPDto dto) {
        ItemOTP itemOTP = itemOTPService.create(dto);
        return new ResponseEntity<>(itemOTP, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemOTP>> findAll() {
        return ResponseEntity.ok(itemOTPService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemOTP> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(itemOTPService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemOTP> update(@PathVariable Integer id,
                                           @Valid @RequestBody UpdateItemOTPDto dto) {
        return ResponseEntity.ok(itemOTPService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteItemOTPResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(itemOTPService.delete(id));
    }
}
