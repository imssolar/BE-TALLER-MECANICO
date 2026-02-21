package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateAuditoriaMenuDto;
import com.tallermecanico.dto.request.UpdateAuditoriaMenuDto;
import com.tallermecanico.dto.response.DeleteAuditoriaMenuResponseDto;
import com.tallermecanico.entity.AuditoriaMenu;
import com.tallermecanico.service.AuditoriaMenuService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/auditoria-menus")
public class AuditoriaMenuController {

    private final AuditoriaMenuService auditoriaMenuService;

    public AuditoriaMenuController(AuditoriaMenuService auditoriaMenuService) {
        this.auditoriaMenuService = auditoriaMenuService;
    }

    @PostMapping
    public ResponseEntity<AuditoriaMenu> create(@Valid @RequestBody CreateAuditoriaMenuDto dto) {
        AuditoriaMenu auditoria = auditoriaMenuService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(auditoria);
    }

    @GetMapping
    public ResponseEntity<List<AuditoriaMenu>> findAll() {
        List<AuditoriaMenu> auditorias = auditoriaMenuService.findAll();
        return ResponseEntity.ok(auditorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditoriaMenu> findById(@PathVariable Long id) {
        AuditoriaMenu auditoria = auditoriaMenuService.findById(id);
        return ResponseEntity.ok(auditoria);
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List<AuditoriaMenu>> findByUsuario(@PathVariable String usuario) {
        List<AuditoriaMenu> auditorias = auditoriaMenuService.findByUsuario(usuario);
        return ResponseEntity.ok(auditorias);
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<AuditoriaMenu>> findByFechaBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
        List<AuditoriaMenu> auditorias = auditoriaMenuService.findByFechaBetween(desde, hasta);
        return ResponseEntity.ok(auditorias);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuditoriaMenu> update(@PathVariable Long id,
                                                 @Valid @RequestBody UpdateAuditoriaMenuDto dto) {
        AuditoriaMenu auditoria = auditoriaMenuService.update(id, dto);
        return ResponseEntity.ok(auditoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteAuditoriaMenuResponseDto> delete(@PathVariable Long id) {
        DeleteAuditoriaMenuResponseDto response = auditoriaMenuService.delete(id);
        return ResponseEntity.ok(response);
    }
}
