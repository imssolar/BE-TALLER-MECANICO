package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateAreaDto;
import com.tallermecanico.dto.request.UpdateAreaDto;
import com.tallermecanico.dto.response.DeleteAreaResponseDto;
import com.tallermecanico.entity.Area;
import com.tallermecanico.service.AreaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping
    public ResponseEntity<Area> create(@Valid @RequestBody CreateAreaDto dto) {
        Area area = areaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(area);
    }

    @GetMapping
    public ResponseEntity<List<Area>> findAll() {
        List<Area> areas = areaService.findAll();
        return ResponseEntity.ok(areas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> findById(@PathVariable Integer id) {
        Area area = areaService.findById(id);
        return ResponseEntity.ok(area);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Area> update(@PathVariable Integer id,
                                        @Valid @RequestBody UpdateAreaDto dto) {
        Area area = areaService.update(id, dto);
        return ResponseEntity.ok(area);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteAreaResponseDto> delete(@PathVariable Integer id) {
        DeleteAreaResponseDto response = areaService.delete(id);
        return ResponseEntity.ok(response);
    }
}
