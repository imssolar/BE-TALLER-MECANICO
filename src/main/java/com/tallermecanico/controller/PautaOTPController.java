package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreatePautaOTPDto;
import com.tallermecanico.dto.request.UpdatePautaOTPDto;
import com.tallermecanico.dto.response.DeletePautaOTPResponseDto;
import com.tallermecanico.entity.PautaOTP;
import com.tallermecanico.service.PautaOTPService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pautas-otp")
public class PautaOTPController {

    private final PautaOTPService pautaOTPService;

    public PautaOTPController(PautaOTPService pautaOTPService) {
        this.pautaOTPService = pautaOTPService;
    }

    @PostMapping
    public ResponseEntity<PautaOTP> create(@Valid @RequestBody CreatePautaOTPDto dto) {
        PautaOTP pautaOTP = pautaOTPService.create(dto);
        return new ResponseEntity<>(pautaOTP, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PautaOTP>> findAll() {
        return ResponseEntity.ok(pautaOTPService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaOTP> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(pautaOTPService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PautaOTP> update(@PathVariable Integer id,
                                            @Valid @RequestBody UpdatePautaOTPDto dto) {
        return ResponseEntity.ok(pautaOTPService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePautaOTPResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(pautaOTPService.delete(id));
    }
}
