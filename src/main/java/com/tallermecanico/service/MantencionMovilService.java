package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMantencionMovilDto;
import com.tallermecanico.dto.request.UpdateMantencionMovilDto;
import com.tallermecanico.dto.response.DeleteMantencionMovilResponseDto;
import com.tallermecanico.entity.MantencionMovil;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MantencionMovilRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MantencionMovilService {

    private final MantencionMovilRepository mantencionMovilRepository;

    public MantencionMovilService(MantencionMovilRepository mantencionMovilRepository) {
        this.mantencionMovilRepository = mantencionMovilRepository;
    }

    @Transactional
    public MantencionMovil create(CreateMantencionMovilDto dto) {
        String itemNormalizado = TextUtils.normalizeText(dto.getItem());

        if (mantencionMovilRepository.existsByItemIgnoreCase(itemNormalizado)) {
            throw new DuplicateResourceException("MantencionMovil", "item", dto.getItem());
        }

        MantencionMovil mantencionMovil = new MantencionMovil();
        mantencionMovil.setItem(itemNormalizado);
        mantencionMovil.setKm(dto.getKm());

        return mantencionMovilRepository.save(mantencionMovil);
    }

    @Transactional(readOnly = true)
    public List<MantencionMovil> findAll() {
        return mantencionMovilRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MantencionMovil findById(Integer id) {
        return mantencionMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MantencionMovil", "id", id));
    }

    @Transactional
    public MantencionMovil update(Integer id, UpdateMantencionMovilDto dto) {
        MantencionMovil mantencionMovil = mantencionMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MantencionMovil", "id", id));

        if (dto.getItem() != null) {
            String itemNormalizado = TextUtils.normalizeText(dto.getItem());

            if (mantencionMovilRepository.existsByItemIgnoreCaseAndIdNot(itemNormalizado, id)) {
                throw new DuplicateResourceException("MantencionMovil", "item", dto.getItem());
            }

            mantencionMovil.setItem(itemNormalizado);
        }

        if (dto.getKm() != null) {
            mantencionMovil.setKm(dto.getKm());
        }

        return mantencionMovilRepository.save(mantencionMovil);
    }

    @Transactional
    public DeleteMantencionMovilResponseDto delete(Integer id) {
        MantencionMovil mantencionMovil = mantencionMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MantencionMovil", "id", id));

        mantencionMovilRepository.delete(mantencionMovil);
        return new DeleteMantencionMovilResponseDto(
                mantencionMovil.getId(),
                mantencionMovil.getItem(),
                "Mantención de móvil eliminada exitosamente"
        );
    }
}
