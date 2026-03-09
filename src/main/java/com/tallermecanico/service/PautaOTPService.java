package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreatePautaOTPDto;
import com.tallermecanico.dto.request.UpdatePautaOTPDto;
import com.tallermecanico.dto.response.DeletePautaOTPResponseDto;
import com.tallermecanico.entity.PautaOTP;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.PautaOTPRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PautaOTPService {

    private final PautaOTPRepository pautaOTPRepository;

    public PautaOTPService(PautaOTPRepository pautaOTPRepository) {
        this.pautaOTPRepository = pautaOTPRepository;
    }

    @Transactional
    public PautaOTP create(CreatePautaOTPDto dto) {
        String pautaNormalizada = TextUtils.normalizeText(dto.getPauta());

        if (pautaOTPRepository.existsByPautaIgnoreCase(pautaNormalizada)) {
            throw new DuplicateResourceException("PautaOTP", "pauta", dto.getPauta());
        }

        PautaOTP pautaOTP = new PautaOTP();
        pautaOTP.setPauta(pautaNormalizada);
        pautaOTP.setCodigoPauta(dto.getCodigoPauta());
        pautaOTP.setControl(dto.getControl());
        pautaOTP.setFormato(dto.getFormato());

        return pautaOTPRepository.save(pautaOTP);
    }

    @Transactional(readOnly = true)
    public List<PautaOTP> findAll() {
        return pautaOTPRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PautaOTP findById(Integer id) {
        return pautaOTPRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PautaOTP", "id", id));
    }

    @Transactional
    public PautaOTP update(Integer id, UpdatePautaOTPDto dto) {
        PautaOTP pautaOTP = pautaOTPRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PautaOTP", "id", id));

        if (dto.getPauta() != null) {
            String pautaNormalizada = TextUtils.normalizeText(dto.getPauta());

            if (pautaOTPRepository.existsByPautaIgnoreCaseAndIdNot(pautaNormalizada, id)) {
                throw new DuplicateResourceException("PautaOTP", "pauta", dto.getPauta());
            }

            pautaOTP.setPauta(pautaNormalizada);
        }

        if (dto.getCodigoPauta() != null) {
            pautaOTP.setCodigoPauta(dto.getCodigoPauta());
        }

        if (dto.getControl() != null) {
            pautaOTP.setControl(dto.getControl());
        }

        if (dto.getFormato() != null) {
            pautaOTP.setFormato(dto.getFormato());
        }

        return pautaOTPRepository.save(pautaOTP);
    }

    @Transactional
    public DeletePautaOTPResponseDto delete(Integer id) {
        PautaOTP pautaOTP = pautaOTPRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PautaOTP", "id", id));

        pautaOTPRepository.delete(pautaOTP);
        return new DeletePautaOTPResponseDto(
                pautaOTP.getId(),
                pautaOTP.getPauta(),
                "Pauta OTP eliminada exitosamente"
        );
    }
}
