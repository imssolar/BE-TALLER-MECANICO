package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMarcaPastillaDto;
import com.tallermecanico.dto.request.UpdateMarcaPastillaDto;
import com.tallermecanico.dto.response.DeleteMarcaPastillaResponseDto;
import com.tallermecanico.entity.MarcaPastilla;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MarcaPastillaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarcaPastillaService {

    private final MarcaPastillaRepository marcaPastillaRepository;

    public MarcaPastillaService(MarcaPastillaRepository marcaPastillaRepository) {
        this.marcaPastillaRepository = marcaPastillaRepository;
    }

    @Transactional
    public MarcaPastilla create(CreateMarcaPastillaDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getMarcaPastilla());

        if (marcaPastillaRepository.existsByMarcaPastillaIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("MarcaPastilla", "marcaPastilla", dto.getMarcaPastilla());
        }

        MarcaPastilla marcaPastilla = new MarcaPastilla();
        marcaPastilla.setMarcaPastilla(nombreNormalizado);

        return marcaPastillaRepository.save(marcaPastilla);
    }

    @Transactional(readOnly = true)
    public List<MarcaPastilla> findAll() {
        return marcaPastillaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MarcaPastilla findById(Integer id) {
        return marcaPastillaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MarcaPastilla", "id", id));
    }

    @Transactional
    public MarcaPastilla update(Integer id, UpdateMarcaPastillaDto dto) {
        MarcaPastilla marcaPastilla = marcaPastillaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MarcaPastilla", "id", id));

        if (dto.getMarcaPastilla() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getMarcaPastilla());

            if (marcaPastillaRepository.existsByMarcaPastillaIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("MarcaPastilla", "marcaPastilla", dto.getMarcaPastilla());
            }

            marcaPastilla.setMarcaPastilla(nombreNormalizado);
        }

        return marcaPastillaRepository.save(marcaPastilla);
    }

    @Transactional
    public DeleteMarcaPastillaResponseDto delete(Integer id) {
        MarcaPastilla marcaPastilla = marcaPastillaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MarcaPastilla", "id", id));

        marcaPastillaRepository.delete(marcaPastilla);
        return new DeleteMarcaPastillaResponseDto(
                marcaPastilla.getId(),
                marcaPastilla.getMarcaPastilla(),
                "Marca de pastilla eliminada exitosamente"
        );
    }
}
