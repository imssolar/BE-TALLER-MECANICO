package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateEquipamientoDto;
import com.tallermecanico.dto.request.UpdateEquipamientoDto;
import com.tallermecanico.dto.response.DeleteEquipamientoResponseDto;
import com.tallermecanico.entity.Equipamiento;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.EquipamientoRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipamientoService {

    private final EquipamientoRepository equipamientoRepository;

    public EquipamientoService(EquipamientoRepository equipamientoRepository) {
        this.equipamientoRepository = equipamientoRepository;
    }

    @Transactional
    public Equipamiento create(CreateEquipamientoDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getEquipamiento());

        if (equipamientoRepository.existsByEquipamientoIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Equipamiento", "equipamiento", dto.getEquipamiento());
        }

        Equipamiento equipamiento = new Equipamiento();
        equipamiento.setEquipamiento(nombreNormalizado);
        equipamiento.setCosto(dto.getCosto());
        equipamiento.setCambio(dto.getCambio());

        return equipamientoRepository.save(equipamiento);
    }

    @Transactional(readOnly = true)
    public List<Equipamiento> findAll() {
        return equipamientoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Equipamiento findById(Integer id) {
        return equipamientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipamiento", "id", id));
    }

    @Transactional
    public Equipamiento update(Integer id, UpdateEquipamientoDto dto) {
        Equipamiento equipamiento = equipamientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipamiento", "id", id));

        if (dto.getEquipamiento() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getEquipamiento());

            if (equipamientoRepository.existsByEquipamientoIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Equipamiento", "equipamiento", dto.getEquipamiento());
            }

            equipamiento.setEquipamiento(nombreNormalizado);
        }

        if (dto.getCosto() != null) {
            equipamiento.setCosto(dto.getCosto());
        }

        if (dto.getCambio() != null) {
            equipamiento.setCambio(dto.getCambio());
        }

        return equipamientoRepository.save(equipamiento);
    }

    @Transactional
    public DeleteEquipamientoResponseDto delete(Integer id) {
        Equipamiento equipamiento = equipamientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipamiento", "id", id));

        equipamientoRepository.delete(equipamiento);
        return new DeleteEquipamientoResponseDto(
                equipamiento.getId(),
                equipamiento.getEquipamiento(),
                "Equipamiento eliminado exitosamente"
        );
    }
}
