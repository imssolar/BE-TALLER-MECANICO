package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreatePautaOTMovilDto;
import com.tallermecanico.dto.request.UpdatePautaOTMovilDto;
import com.tallermecanico.dto.response.DeletePautaOTMovilResponseDto;
import com.tallermecanico.entity.PautaOTMovil;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.PautaOTMovilRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PautaOTMovilService {

    private final PautaOTMovilRepository pautaOTMovilRepository;

    public PautaOTMovilService(PautaOTMovilRepository pautaOTMovilRepository) {
        this.pautaOTMovilRepository = pautaOTMovilRepository;
    }

    @Transactional
    public PautaOTMovil create(CreatePautaOTMovilDto dto) {
        String pautaNormalizada = TextUtils.normalizeText(dto.getPauta());

        if (pautaOTMovilRepository.existsByPautaIgnoreCase(pautaNormalizada)) {
            throw new DuplicateResourceException("PautaOTMovil", "pauta", dto.getPauta());
        }

        PautaOTMovil pautaOTMovil = new PautaOTMovil();
        pautaOTMovil.setPauta(pautaNormalizada);
        pautaOTMovil.setCodigoPauta(dto.getCodigoPauta());
        pautaOTMovil.setControl(dto.getControl());
        pautaOTMovil.setFormato(dto.getFormato());

        return pautaOTMovilRepository.save(pautaOTMovil);
    }

    @Transactional(readOnly = true)
    public List<PautaOTMovil> findAll() {
        return pautaOTMovilRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PautaOTMovil findById(Integer id) {
        return pautaOTMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PautaOTMovil", "id", id));
    }

    @Transactional
    public PautaOTMovil update(Integer id, UpdatePautaOTMovilDto dto) {
        PautaOTMovil pautaOTMovil = pautaOTMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PautaOTMovil", "id", id));

        if (dto.getPauta() != null) {
            String pautaNormalizada = TextUtils.normalizeText(dto.getPauta());

            if (pautaOTMovilRepository.existsByPautaIgnoreCaseAndIdNot(pautaNormalizada, id)) {
                throw new DuplicateResourceException("PautaOTMovil", "pauta", dto.getPauta());
            }

            pautaOTMovil.setPauta(pautaNormalizada);
        }

        if (dto.getCodigoPauta() != null) {
            pautaOTMovil.setCodigoPauta(dto.getCodigoPauta());
        }

        if (dto.getControl() != null) {
            pautaOTMovil.setControl(dto.getControl());
        }

        if (dto.getFormato() != null) {
            pautaOTMovil.setFormato(dto.getFormato());
        }

        return pautaOTMovilRepository.save(pautaOTMovil);
    }

    @Transactional
    public DeletePautaOTMovilResponseDto delete(Integer id) {
        PautaOTMovil pautaOTMovil = pautaOTMovilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PautaOTMovil", "id", id));

        pautaOTMovilRepository.delete(pautaOTMovil);
        return new DeletePautaOTMovilResponseDto(
                pautaOTMovil.getId(),
                pautaOTMovil.getPauta(),
                "Pauta OT de móvil eliminada exitosamente"
        );
    }
}
