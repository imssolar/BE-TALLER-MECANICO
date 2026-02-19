package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateModeloDto;
import com.tallermecanico.dto.request.UpdateModeloDto;
import com.tallermecanico.dto.response.DeleteModeloResponseDto;
import com.tallermecanico.entity.Modelo;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ModeloRepository;
import com.tallermecanico.util.TextUtils;
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
        String nombreNormalizado = TextUtils.normalizeText(dto.getModelo());

        if (modeloRepository.existsByModeloIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Modelo", "modelo", dto.getModelo());
        }

        Modelo modelo = new Modelo();
        modelo.setModelo(nombreNormalizado);
        modelo.setKmDiario(dto.getKmDiario());
        modelo.setObservaciones(dto.getObservaciones());

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
        Modelo modelo = modeloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Modelo", "id", id));

        if (dto.getModelo() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getModelo());

            if (modeloRepository.existsByModeloIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Modelo", "modelo", dto.getModelo());
            }

            modelo.setModelo(nombreNormalizado);
        }

        if (dto.getKmDiario() != null) {
            modelo.setKmDiario(dto.getKmDiario());
        }

        if (dto.getObservaciones() != null) {
            modelo.setObservaciones(dto.getObservaciones());
        }

        return modeloRepository.save(modelo);
    }

    @Transactional
    public DeleteModeloResponseDto delete(Integer id) {
        Modelo modelo = modeloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Modelo", "id", id));

        modeloRepository.delete(modelo);
        return new DeleteModeloResponseDto(
                modelo.getId(),
                modelo.getModelo(),
                "Modelo eliminado exitosamente"
        );
    }
}
