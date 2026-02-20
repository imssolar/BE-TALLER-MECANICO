package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateBateriaMotivoCambioDto;
import com.tallermecanico.dto.request.UpdateBateriaMotivoCambioDto;
import com.tallermecanico.dto.response.DeleteBateriaMotivoCambioResponseDto;
import com.tallermecanico.entity.BateriaMotivoCambio;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.BateriaMotivoCambioRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BateriaMotivoCambioService {

    private final BateriaMotivoCambioRepository bateriaMotivoCambioRepository;

    public BateriaMotivoCambioService(BateriaMotivoCambioRepository bateriaMotivoCambioRepository) {
        this.bateriaMotivoCambioRepository = bateriaMotivoCambioRepository;
    }

    @Transactional
    public BateriaMotivoCambio create(CreateBateriaMotivoCambioDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getMotivoCambio());

        if (bateriaMotivoCambioRepository.existsByMotivoCambioIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("BateriaMotivoCambio", "motivoCambio", dto.getMotivoCambio());
        }

        BateriaMotivoCambio bateriaMotivoCambio = new BateriaMotivoCambio();
        bateriaMotivoCambio.setMotivoCambio(nombreNormalizado);

        return bateriaMotivoCambioRepository.save(bateriaMotivoCambio);
    }

    @Transactional(readOnly = true)
    public List<BateriaMotivoCambio> findAll() {
        return bateriaMotivoCambioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public BateriaMotivoCambio findById(Integer id) {
        return bateriaMotivoCambioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriaMotivoCambio", "id", id));
    }

    @Transactional
    public BateriaMotivoCambio update(Integer id, UpdateBateriaMotivoCambioDto dto) {
        BateriaMotivoCambio bateriaMotivoCambio = bateriaMotivoCambioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriaMotivoCambio", "id", id));

        if (dto.getMotivoCambio() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getMotivoCambio());

            if (bateriaMotivoCambioRepository.existsByMotivoCambioIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("BateriaMotivoCambio", "motivoCambio", dto.getMotivoCambio());
            }

            bateriaMotivoCambio.setMotivoCambio(nombreNormalizado);
        }

        return bateriaMotivoCambioRepository.save(bateriaMotivoCambio);
    }

    @Transactional
    public DeleteBateriaMotivoCambioResponseDto delete(Integer id) {
        BateriaMotivoCambio bateriaMotivoCambio = bateriaMotivoCambioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriaMotivoCambio", "id", id));

        bateriaMotivoCambioRepository.delete(bateriaMotivoCambio);
        return new DeleteBateriaMotivoCambioResponseDto(
                bateriaMotivoCambio.getId(),
                bateriaMotivoCambio.getMotivoCambio(),
                "Motivo de cambio de batería eliminado exitosamente"
        );
    }
}
