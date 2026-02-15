package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateEstadosNeumaticoDto;
import com.tallermecanico.dto.request.UpdateEstadosNeumaticoDto;
import com.tallermecanico.dto.response.DeleteEstadosNeumaticoResponseDto;
import com.tallermecanico.entity.EstadosNeumatico;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.EstadosNeumaticoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadosNeumaticoService {

    private final EstadosNeumaticoRepository estadosNeumaticoRepository;

    public EstadosNeumaticoService(EstadosNeumaticoRepository estadosNeumaticoRepository) {
        this.estadosNeumaticoRepository = estadosNeumaticoRepository;
    }

    @Transactional
    public EstadosNeumatico create(CreateEstadosNeumaticoDto dto) {
        // Validar estado único
        if (estadosNeumaticoRepository.existsByEstado(dto.getEstado())) {
            throw new DuplicateResourceException("EstadosNeumatico", "estado", dto.getEstado());
        }

        EstadosNeumatico estado = new EstadosNeumatico();
        estado.setEstado(dto.getEstado());

        return estadosNeumaticoRepository.save(estado);
    }

    @Transactional(readOnly = true)
    public List<EstadosNeumatico> findAll() {
        return estadosNeumaticoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public EstadosNeumatico findById(Integer id) {
        return estadosNeumaticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadosNeumatico", "id", id));
    }

    @Transactional
    public EstadosNeumatico update(Integer id, UpdateEstadosNeumaticoDto dto) {
        EstadosNeumatico estado = findById(id);

        if (dto.getEstado() != null) {
            // Validar estado único (excluyendo el actual)
            if (estadosNeumaticoRepository.existsByEstadoAndIdNot(dto.getEstado(), id)) {
                throw new DuplicateResourceException("EstadosNeumatico", "estado", dto.getEstado());
            }
            estado.setEstado(dto.getEstado());
        }

        return estadosNeumaticoRepository.save(estado);
    }

    @Transactional
    public DeleteEstadosNeumaticoResponseDto delete(Integer id) {
        EstadosNeumatico estado = findById(id);
        estadosNeumaticoRepository.delete(estado);
        return new DeleteEstadosNeumaticoResponseDto(estado.getId(), estado.getEstado());
    }
}
