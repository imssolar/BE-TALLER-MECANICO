package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateModelosNeumaticoDto;
import com.tallermecanico.dto.request.UpdateModelosNeumaticoDto;
import com.tallermecanico.dto.response.DeleteModelosNeumaticoResponseDto;
import com.tallermecanico.entity.ModelosNeumatico;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ModelosNeumaticoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModelosNeumaticoService {

    private final ModelosNeumaticoRepository modelosNeumaticoRepository;

    public ModelosNeumaticoService(ModelosNeumaticoRepository modelosNeumaticoRepository) {
        this.modelosNeumaticoRepository = modelosNeumaticoRepository;
    }

    @Transactional
    public ModelosNeumatico create(CreateModelosNeumaticoDto dto) {
        // Validar modelo único
        if (modelosNeumaticoRepository.existsByModelo(dto.getModelo())) {
            throw new DuplicateResourceException("ModelosNeumatico", "modelo", dto.getModelo());
        }

        ModelosNeumatico modelo = new ModelosNeumatico();
        modelo.setModelo(dto.getModelo());

        return modelosNeumaticoRepository.save(modelo);
    }

    @Transactional(readOnly = true)
    public List<ModelosNeumatico> findAll() {
        return modelosNeumaticoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ModelosNeumatico findById(Integer id) {
        return modelosNeumaticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ModelosNeumatico", "id", id));
    }

    @Transactional
    public ModelosNeumatico update(Integer id, UpdateModelosNeumaticoDto dto) {
        ModelosNeumatico modelo = findById(id);

        if (dto.getModelo() != null) {
            // Validar modelo único (excluyendo el actual)
            if (modelosNeumaticoRepository.existsByModeloAndIdNot(dto.getModelo(), id)) {
                throw new DuplicateResourceException("ModelosNeumatico", "modelo", dto.getModelo());
            }
            modelo.setModelo(dto.getModelo());
        }

        return modelosNeumaticoRepository.save(modelo);
    }

    @Transactional
    public DeleteModelosNeumaticoResponseDto delete(Integer id) {
        ModelosNeumatico modelo = findById(id);
        modelosNeumaticoRepository.delete(modelo);
        return new DeleteModelosNeumaticoResponseDto(modelo.getId(), modelo.getModelo());
    }
}
