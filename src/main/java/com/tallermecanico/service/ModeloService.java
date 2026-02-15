package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateModeloDto;
import com.tallermecanico.dto.request.UpdateModeloDto;
import com.tallermecanico.entity.Modelo;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ModeloRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;

    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    @Transactional
    public Modelo create(CreateModeloDto dto) {
        // Validar modelo único
        if (dto.getModelo() != null && modeloRepository.existsByModelo(dto.getModelo())) {
            throw new DuplicateResourceException("Modelo", "modelo", dto.getModelo());
        }

        Modelo modelo = new Modelo();
        modelo.setIdModelo(dto.getIdModelo());
        modelo.setModelo(dto.getModelo());
        modelo.setKmDiario(dto.getKmDiario());
        modelo.setObs(dto.getObs());

        return modeloRepository.save(modelo);
    }

    @Transactional(readOnly = true)
    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Modelo findById(Integer id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Modelo", "id", id));
    }

    @Transactional
    public Modelo update(Integer id, UpdateModeloDto dto) {
        Modelo modelo = findById(id);

        // Validar modelo único (excluyendo el actual)
        if (dto.getModelo() != null &&
            modeloRepository.existsByModeloAndIdModeloNot(dto.getModelo(), id)) {
            throw new DuplicateResourceException("Modelo", "modelo", dto.getModelo());
        }

        if (dto.getModelo() != null) {
            modelo.setModelo(dto.getModelo());
        }
        if (dto.getKmDiario() != null) {
            modelo.setKmDiario(dto.getKmDiario());
        }
        if (dto.getObs() != null) {
            modelo.setObs(dto.getObs());
        }

        return modeloRepository.save(modelo);
    }

    @Transactional
    public void delete(Integer id) {
        Modelo modelo = findById(id);
        modeloRepository.delete(modelo);
    }
}
