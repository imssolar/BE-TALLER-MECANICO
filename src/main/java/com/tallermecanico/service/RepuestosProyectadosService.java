package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateRepuestosProyectadosDto;
import com.tallermecanico.dto.request.UpdateRepuestosProyectadosDto;
import com.tallermecanico.dto.response.DeleteRepuestosProyectadosResponseDto;
import com.tallermecanico.entity.RepuestosProyectados;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.RepuestosProyectadosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepuestosProyectadosService {

    private final RepuestosProyectadosRepository repuestosProyectadosRepository;

    public RepuestosProyectadosService(RepuestosProyectadosRepository repuestosProyectadosRepository) {
        this.repuestosProyectadosRepository = repuestosProyectadosRepository;
    }

    @Transactional
    public RepuestosProyectados create(CreateRepuestosProyectadosDto dto) {
        RepuestosProyectados repuestosProyectados = new RepuestosProyectados();
        repuestosProyectados.setFecha(dto.getFecha());
        repuestosProyectados.setIdRepuesto(dto.getIdRepuesto());
        repuestosProyectados.setRepuesto(dto.getRepuesto());
        repuestosProyectados.setCantidad(dto.getCantidad());
        repuestosProyectados.setUnitario(dto.getUnitario());
        repuestosProyectados.setTotal(dto.getTotal());

        return repuestosProyectadosRepository.save(repuestosProyectados);
    }

    @Transactional(readOnly = true)
    public List<RepuestosProyectados> findAll() {
        return repuestosProyectadosRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RepuestosProyectados findById(Integer id) {
        return repuestosProyectadosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RepuestosProyectados", "id", id));
    }

    @Transactional
    public RepuestosProyectados update(Integer id, UpdateRepuestosProyectadosDto dto) {
        RepuestosProyectados repuestosProyectados = findById(id);

        if (dto.getFecha() != null) {
            repuestosProyectados.setFecha(dto.getFecha());
        }
        if (dto.getIdRepuesto() != null) {
            repuestosProyectados.setIdRepuesto(dto.getIdRepuesto());
        }
        if (dto.getRepuesto() != null) {
            repuestosProyectados.setRepuesto(dto.getRepuesto());
        }
        if (dto.getCantidad() != null) {
            repuestosProyectados.setCantidad(dto.getCantidad());
        }
        if (dto.getUnitario() != null) {
            repuestosProyectados.setUnitario(dto.getUnitario());
        }
        if (dto.getTotal() != null) {
            repuestosProyectados.setTotal(dto.getTotal());
        }

        return repuestosProyectadosRepository.save(repuestosProyectados);
    }

    @Transactional
    public DeleteRepuestosProyectadosResponseDto delete(Integer id) {
        RepuestosProyectados repuestosProyectados = findById(id);
        repuestosProyectadosRepository.delete(repuestosProyectados);
        return new DeleteRepuestosProyectadosResponseDto(repuestosProyectados.getId());
    }
}
