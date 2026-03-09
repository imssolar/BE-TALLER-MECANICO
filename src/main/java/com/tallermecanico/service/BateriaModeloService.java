package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateBateriaModeloDto;
import com.tallermecanico.dto.request.UpdateBateriaModeloDto;
import com.tallermecanico.dto.response.DeleteBateriaModeloResponseDto;
import com.tallermecanico.entity.BateriaModelo;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.BateriaModeloRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BateriaModeloService {

    private final BateriaModeloRepository bateriaModeloRepository;

    public BateriaModeloService(BateriaModeloRepository bateriaModeloRepository) {
        this.bateriaModeloRepository = bateriaModeloRepository;
    }

    @Transactional
    public BateriaModelo create(CreateBateriaModeloDto dto) {
        String modeloNormalizado = TextUtils.normalizeText(dto.getModelo());

        if (bateriaModeloRepository.existsByModeloIgnoreCase(modeloNormalizado)) {
            throw new DuplicateResourceException("BateriaModelo", "modelo", dto.getModelo());
        }

        BateriaModelo bateriaModelo = new BateriaModelo();
        bateriaModelo.setModelo(modeloNormalizado);
        bateriaModelo.setRendimiento(dto.getRendimiento());

        return bateriaModeloRepository.save(bateriaModelo);
    }

    @Transactional(readOnly = true)
    public List<BateriaModelo> findAll() {
        return bateriaModeloRepository.findAll();
    }

    @Transactional(readOnly = true)
    public BateriaModelo findById(Integer id) {
        return bateriaModeloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriaModelo", "id", id));
    }

    @Transactional
    public BateriaModelo update(Integer id, UpdateBateriaModeloDto dto) {
        BateriaModelo bateriaModelo = bateriaModeloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriaModelo", "id", id));

        if (dto.getModelo() != null) {
            String modeloNormalizado = TextUtils.normalizeText(dto.getModelo());

            if (bateriaModeloRepository.existsByModeloIgnoreCaseAndIdNot(modeloNormalizado, id)) {
                throw new DuplicateResourceException("BateriaModelo", "modelo", dto.getModelo());
            }

            bateriaModelo.setModelo(modeloNormalizado);
        }

        if (dto.getRendimiento() != null) {
            bateriaModelo.setRendimiento(dto.getRendimiento());
        }

        return bateriaModeloRepository.save(bateriaModelo);
    }

    @Transactional
    public DeleteBateriaModeloResponseDto delete(Integer id) {
        BateriaModelo bateriaModelo = bateriaModeloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriaModelo", "id", id));

        bateriaModeloRepository.delete(bateriaModelo);
        return new DeleteBateriaModeloResponseDto(
                bateriaModelo.getId(),
                bateriaModelo.getModelo(),
                "Modelo de batería eliminado exitosamente"
        );
    }
}
