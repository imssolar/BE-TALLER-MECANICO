package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateTerminalDto;
import com.tallermecanico.dto.request.UpdateTerminalDto;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.service.TerminalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terminal")
public class TerminalController {

    private final TerminalService terminalService;

    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @PostMapping
    public ResponseEntity<Terminal> create(@Valid @RequestBody CreateTerminalDto dto) {
        Terminal terminal = terminalService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(terminal);
    }

    @GetMapping
    public ResponseEntity<List<Terminal>> findAll() {
        List<Terminal> terminales = terminalService.findAll();
        return ResponseEntity.ok(terminales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Terminal> findById(@PathVariable Integer id) {
        Terminal terminal = terminalService.findById(id);
        return ResponseEntity.ok(terminal);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Terminal> update(@PathVariable Integer id,
                                          @Valid @RequestBody UpdateTerminalDto dto) {
        Terminal terminal = terminalService.update(id, dto);
        return ResponseEntity.ok(terminal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        terminalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
