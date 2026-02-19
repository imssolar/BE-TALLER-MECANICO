package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMotivoCambioDto;
import com.tallermecanico.dto.request.UpdateMotivoCambioDto;
import com.tallermecanico.dto.response.DeleteMotivoCambioResponseDto;
import com.tallermecanico.entity.MotivoCambio;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MotivoCambioRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MotivoCambioService {

    private final MotivoCambioRepository motivoCambioRepository;

    public MotivoCambioService(MotivoCambioRepository motivoCambioRepository) {
        this.motivoCambioRepository = motivoCambioRepository;
    }

    @Transactional
    public MotivoCambio create(CreateMotivoCambioDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getMotivo());

        if (motivoCambioRepository.existsByMotivoIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("MotivoCambio", "motivo", dto.getMotivo());
        }

        MotivoCambio motivoCambio = new MotivoCambio();
        motivoCambio.setMotivo(nombreNormalizado);

        return motivoCambioRepository.save(motivoCambio);
    }

    @Transactional(readOnly = true)
    public List<MotivoCambio> findAll() {
        return motivoCambioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MotivoCambio findById(Integer id) {
        return motivoCambioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MotivoCambio", "id", id));
    }

    @Transactional
    public MotivoCambio update(Integer id, UpdateMotivoCambioDto dto) {
        MotivoCambio motivoCambio = motivoCambioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MotivoCambio", "id", id));

        if (dto.getMotivo() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getMotivo());

            if (motivoCambioRepository.existsByMotivoIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("MotivoCambio", "motivo", dto.getMotivo());
            }

            motivoCambio.setMotivo(nombreNormalizado);
        }

        return motivoCambioRepository.save(motivoCambio);
    }

    @Transactional
    public DeleteMotivoCambioResponseDto delete(Integer id) {
        MotivoCambio motivoCambio = motivoCambioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MotivoCambio", "id", id));

        motivoCambioRepository.delete(motivoCambio);
        return new DeleteMotivoCambioResponseDto(
                motivoCambio.getId(),
                motivoCambio.getMotivo(),
                "Motivo de cambio eliminado exitosamente"
        );
    }
}
