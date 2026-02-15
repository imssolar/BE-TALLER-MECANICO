package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateBusDto;
import com.tallermecanico.dto.request.RegistrarEmergenciaDto;
import com.tallermecanico.dto.request.UpdateBusDto;
import com.tallermecanico.dto.request.UpdateEstadoDto;
import com.tallermecanico.dto.request.UpdateKilometrajeDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.service.BusService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping
    public ResponseEntity<Bus> create(@Valid @RequestBody CreateBusDto dto) {
        Bus bus = busService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bus);
    }

    @GetMapping
    public ResponseEntity<List<Bus>> findAll() {
        List<Bus> buses = busService.findAll();
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/estadisticas")
    public ResponseEntity<Map<String, Object>> getEstadisticas() {
        Map<String, Object> estadisticas = busService.getEstadisticas();
        return ResponseEntity.ok(estadisticas);
    }

    @GetMapping("/operativos")
    public ResponseEntity<List<Bus>> findOperativos() {
        List<Bus> buses = busService.findOperativos();
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/inactivos")
    public ResponseEntity<List<Bus>> findInactivos() {
        List<Bus> buses = busService.findInactivos();
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/en-mantencion")
    public ResponseEntity<List<Bus>> findEnMantencion() {
        List<Bus> buses = busService.findEnMantencion();
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/terminal/{id}")
    public ResponseEntity<List<Bus>> findByTerminal(@PathVariable Integer id) {
        List<Bus> buses = busService.findByTerminal(id);
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/modelo/{id}")
    public ResponseEntity<List<Bus>> findByModelo(@PathVariable Integer id) {
        List<Bus> buses = busService.findByModelo(id);
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/patente/{patente}")
    public ResponseEntity<Bus> findByPatente(@PathVariable String patente) {
        Bus bus = busService.findByPatente(patente);
        return ResponseEntity.ok(bus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> findById(@PathVariable Integer id) {
        Bus bus = busService.findById(id);
        return ResponseEntity.ok(bus);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Bus> update(@PathVariable Integer id,
                                     @Valid @RequestBody UpdateBusDto dto) {
        Bus bus = busService.update(id, dto);
        return ResponseEntity.ok(bus);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Bus> updateEstado(@PathVariable Integer id,
                                           @Valid @RequestBody UpdateEstadoDto dto) {
        Bus bus = busService.updateEstado(id, dto);
        return ResponseEntity.ok(bus);
    }

    @PatchMapping("/{id}/kilometraje")
    public ResponseEntity<Bus> updateKilometraje(@PathVariable Integer id,
                                                 @Valid @RequestBody UpdateKilometrajeDto dto) {
        Bus bus = busService.updateKilometraje(id, dto);
        return ResponseEntity.ok(bus);
    }

    @PatchMapping("/{id}/emergencia")
    public ResponseEntity<Bus> registrarEmergencia(@PathVariable Integer id,
                                                   @Valid @RequestBody RegistrarEmergenciaDto dto) {
        Bus bus = busService.registrarEmergencia(id, dto);
        return ResponseEntity.ok(bus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        busService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
