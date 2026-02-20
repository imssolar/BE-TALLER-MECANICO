package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateLiquidoDto;
import com.tallermecanico.dto.request.UpdateLiquidoDto;
import com.tallermecanico.dto.response.DeleteLiquidoResponseDto;
import com.tallermecanico.entity.Liquido;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.LiquidoRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LiquidoService {

    private final LiquidoRepository liquidoRepository;

    public LiquidoService(LiquidoRepository liquidoRepository) {
        this.liquidoRepository = liquidoRepository;
    }

    @Transactional
    public Liquido create(CreateLiquidoDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getLiquido());

        if (liquidoRepository.existsByLiquidoIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Liquido", "liquido", dto.getLiquido());
        }

        Liquido liquido = new Liquido();
        liquido.setLiquido(nombreNormalizado);

        return liquidoRepository.save(liquido);
    }

    @Transactional(readOnly = true)
    public List<Liquido> findAll() {
        return liquidoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Liquido findById(Integer id) {
        return liquidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Liquido", "id", id));
    }

    @Transactional
    public Liquido update(Integer id, UpdateLiquidoDto dto) {
        Liquido liquido = liquidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Liquido", "id", id));

        if (dto.getLiquido() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getLiquido());

            if (liquidoRepository.existsByLiquidoIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Liquido", "liquido", dto.getLiquido());
            }

            liquido.setLiquido(nombreNormalizado);
        }

        return liquidoRepository.save(liquido);
    }

    @Transactional
    public DeleteLiquidoResponseDto delete(Integer id) {
        Liquido liquido = liquidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Liquido", "id", id));

        liquidoRepository.delete(liquido);
        return new DeleteLiquidoResponseDto(
                liquido.getId(),
                liquido.getLiquido(),
                "Liquido eliminado exitosamente"
        );
    }
}
