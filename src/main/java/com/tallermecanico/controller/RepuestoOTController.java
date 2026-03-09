package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateRepuestoOTDto;
import com.tallermecanico.dto.request.UpdateRepuestoOTDto;
import com.tallermecanico.dto.response.DeleteRepuestoOTResponseDto;
import com.tallermecanico.entity.RepuestoOT;
import com.tallermecanico.service.RepuestoOTService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repuestos-ot")
public class RepuestoOTController {

    private final RepuestoOTService repuestoOTService;

    public RepuestoOTController(RepuestoOTService repuestoOTService) {
        this.repuestoOTService = repuestoOTService;
    }

    @PostMapping
    public ResponseEntity<RepuestoOT> create(@Valid @RequestBody CreateRepuestoOTDto dto) {
        RepuestoOT repuestoOT = repuestoOTService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(repuestoOT);
    }

    @GetMapping
    public ResponseEntity<List<RepuestoOT>> findAll() {
        List<RepuestoOT> repuestos = repuestoOTService.findAll();
        return ResponseEntity.ok(repuestos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepuestoOT> findById(@PathVariable Integer id) {
        RepuestoOT repuestoOT = repuestoOTService.findById(id);
        return ResponseEntity.ok(repuestoOT);
    }

    @GetMapping("/orden-trabajo/{idOrdenTrabajo}")
    public ResponseEntity<List<RepuestoOT>> findByOrdenTrabajo(@PathVariable Integer idOrdenTrabajo) {
        List<RepuestoOT> repuestos = repuestoOTService.findByOrdenTrabajo(idOrdenTrabajo);
        return ResponseEntity.ok(repuestos);
    }

    @GetMapping("/orden-trabajo-prog/{idOrdenTrabajoProg}")
    public ResponseEntity<List<RepuestoOT>> findByOrdenTrabajoProg(@PathVariable Integer idOrdenTrabajoProg) {
        List<RepuestoOT> repuestos = repuestoOTService.findByOrdenTrabajoProg(idOrdenTrabajoProg);
        return ResponseEntity.ok(repuestos);
    }

    @GetMapping("/orden-trabajo-movil/{idOrdenTrabajoMovil}")
    public ResponseEntity<List<RepuestoOT>> findByOrdenTrabajoMovil(@PathVariable Integer idOrdenTrabajoMovil) {
        List<RepuestoOT> repuestos = repuestoOTService.findByOrdenTrabajoMovil(idOrdenTrabajoMovil);
        return ResponseEntity.ok(repuestos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RepuestoOT> update(@PathVariable Integer id,
                                              @Valid @RequestBody UpdateRepuestoOTDto dto) {
        RepuestoOT repuestoOT = repuestoOTService.update(id, dto);
        return ResponseEntity.ok(repuestoOT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRepuestoOTResponseDto> delete(@PathVariable Integer id) {
        DeleteRepuestoOTResponseDto response = repuestoOTService.delete(id);
        return ResponseEntity.ok(response);
    }
}
