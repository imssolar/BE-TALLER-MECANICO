package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMovimientoBodegaDto;
import com.tallermecanico.dto.request.UpdateMovimientoBodegaDto;
import com.tallermecanico.dto.response.DeleteMovimientoBodegaResponseDto;
import com.tallermecanico.entity.MovimientoBodega;
import com.tallermecanico.entity.Repuesto;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MovimientoBodegaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovimientoBodegaService {

    private final MovimientoBodegaRepository movimientoBodegaRepository;
    private final RepuestoService repuestoService;

    public MovimientoBodegaService(MovimientoBodegaRepository movimientoBodegaRepository,
                                   RepuestoService repuestoService) {
        this.movimientoBodegaRepository = movimientoBodegaRepository;
        this.repuestoService = repuestoService;
    }

    @Transactional
    public MovimientoBodega create(CreateMovimientoBodegaDto dto) {
        MovimientoBodega movimientoBodega = new MovimientoBodega();
        movimientoBodega.setMovimiento(dto.getMovimiento());
        movimientoBodega.setFecha(dto.getFecha());
        movimientoBodega.setCantidad(dto.getCantidad());
        movimientoBodega.setStockActual(dto.getStockActual());
        movimientoBodega.setNuevoStock(dto.getNuevoStock());

        Repuesto repuesto = repuestoService.findById(dto.getIdRepuesto());
        movimientoBodega.setRepuesto(repuesto);

        return movimientoBodegaRepository.save(movimientoBodega);
    }

    @Transactional(readOnly = true)
    public List<MovimientoBodega> findAll() {
        return movimientoBodegaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MovimientoBodega findById(Integer id) {
        return movimientoBodegaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MovimientoBodega", "id", id));
    }

    @Transactional
    public MovimientoBodega update(Integer id, UpdateMovimientoBodegaDto dto) {
        MovimientoBodega movimientoBodega = movimientoBodegaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MovimientoBodega", "id", id));

        if (dto.getMovimiento() != null) {
            movimientoBodega.setMovimiento(dto.getMovimiento());
        }
        if (dto.getFecha() != null) {
            movimientoBodega.setFecha(dto.getFecha());
        }
        if (dto.getCantidad() != null) {
            movimientoBodega.setCantidad(dto.getCantidad());
        }
        if (dto.getStockActual() != null) {
            movimientoBodega.setStockActual(dto.getStockActual());
        }
        if (dto.getNuevoStock() != null) {
            movimientoBodega.setNuevoStock(dto.getNuevoStock());
        }
        if (dto.getIdRepuesto() != null) {
            Repuesto repuesto = repuestoService.findById(dto.getIdRepuesto());
            movimientoBodega.setRepuesto(repuesto);
        }

        return movimientoBodegaRepository.save(movimientoBodega);
    }

    @Transactional
    public DeleteMovimientoBodegaResponseDto delete(Integer id) {
        MovimientoBodega movimientoBodega = movimientoBodegaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MovimientoBodega", "id", id));

        movimientoBodegaRepository.delete(movimientoBodega);
        return new DeleteMovimientoBodegaResponseDto(
                movimientoBodega.getId(),
                "Movimiento de bodega eliminado exitosamente"
        );
    }
}
