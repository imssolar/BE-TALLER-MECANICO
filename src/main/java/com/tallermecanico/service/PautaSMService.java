package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreatePautaSMDto;
import com.tallermecanico.dto.request.UpdatePautaSMDto;
import com.tallermecanico.dto.response.DeletePautaSMResponseDto;
import com.tallermecanico.entity.PautaSM;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.PautaSMRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PautaSMService {

    private final PautaSMRepository pautaSMRepository;

    public PautaSMService(PautaSMRepository pautaSMRepository) {
        this.pautaSMRepository = pautaSMRepository;
    }

    @Transactional
    public PautaSM create(CreatePautaSMDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getPauta());

        if (pautaSMRepository.existsByPautaIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("PautaSM", "pauta", dto.getPauta());
        }

        PautaSM pautaSM = new PautaSM();
        pautaSM.setPauta(nombreNormalizado);

        return pautaSMRepository.save(pautaSM);
    }

    @Transactional(readOnly = true)
    public List<PautaSM> findAll() {
        return pautaSMRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PautaSM findById(Integer id) {
        return pautaSMRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PautaSM", "id", id));
    }

    @Transactional
    public PautaSM update(Integer id, UpdatePautaSMDto dto) {
        PautaSM pautaSM = pautaSMRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PautaSM", "id", id));

        if (dto.getPauta() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getPauta());

            if (pautaSMRepository.existsByPautaIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("PautaSM", "pauta", dto.getPauta());
            }

            pautaSM.setPauta(nombreNormalizado);
        }

        return pautaSMRepository.save(pautaSM);
    }

    @Transactional
    public DeletePautaSMResponseDto delete(Integer id) {
        PautaSM pautaSM = pautaSMRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PautaSM", "id", id));

        pautaSMRepository.delete(pautaSM);
        return new DeletePautaSMResponseDto(
                pautaSM.getId(),
                pautaSM.getPauta(),
                "Pauta SM eliminada exitosamente"
        );
    }
}
