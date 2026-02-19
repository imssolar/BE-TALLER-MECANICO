package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateHerramientaDto;
import com.tallermecanico.dto.request.UpdateHerramientaDto;
import com.tallermecanico.dto.response.DeleteHerramientaResponseDto;
import com.tallermecanico.entity.Herramienta;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.HerramientaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HerramientaService {

    private final HerramientaRepository herramientaRepository;

    public HerramientaService(HerramientaRepository herramientaRepository) {
        this.herramientaRepository = herramientaRepository;
    }

    @Transactional
    public Herramienta create(CreateHerramientaDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getHerramienta());

        if (herramientaRepository.existsByHerramientaIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Herramienta", "herramienta", dto.getHerramienta());
        }

        Herramienta herramienta = new Herramienta();
        herramienta.setHerramienta(nombreNormalizado);
        herramienta.setCosto(dto.getCosto());

        return herramientaRepository.save(herramienta);
    }

    @Transactional(readOnly = true)
    public List<Herramienta> findAll() {
        return herramientaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Herramienta findById(Integer id) {
        return herramientaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Herramienta", "id", id));
    }

    @Transactional
    public Herramienta update(Integer id, UpdateHerramientaDto dto) {
        Herramienta herramienta = herramientaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Herramienta", "id", id));

        if (dto.getHerramienta() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getHerramienta());

            if (herramientaRepository.existsByHerramientaIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Herramienta", "herramienta", dto.getHerramienta());
            }

            herramienta.setHerramienta(nombreNormalizado);
        }

        if (dto.getCosto() != null) {
            herramienta.setCosto(dto.getCosto());
        }

        return herramientaRepository.save(herramienta);
    }

    @Transactional
    public DeleteHerramientaResponseDto delete(Integer id) {
        Herramienta herramienta = herramientaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Herramienta", "id", id));

        herramientaRepository.delete(herramienta);
        return new DeleteHerramientaResponseDto(
                herramienta.getId(),
                herramienta.getHerramienta(),
                "Herramienta eliminada exitosamente"
        );
    }
}
