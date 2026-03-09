package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateRelatorDto;
import com.tallermecanico.dto.request.UpdateRelatorDto;
import com.tallermecanico.dto.response.DeleteRelatorResponseDto;
import com.tallermecanico.entity.Relator;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.RelatorRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RelatorService {

    private final RelatorRepository relatorRepository;

    public RelatorService(RelatorRepository relatorRepository) {
        this.relatorRepository = relatorRepository;
    }

    @Transactional
    public Relator create(CreateRelatorDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getRelator());

        if (relatorRepository.existsByRelatorIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Relator", "relator", dto.getRelator());
        }

        Relator relator = new Relator();
        relator.setRelator(nombreNormalizado);

        return relatorRepository.save(relator);
    }

    @Transactional(readOnly = true)
    public List<Relator> findAll() {
        return relatorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Relator findById(Integer id) {
        return relatorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relator", "id", id));
    }

    @Transactional
    public Relator update(Integer id, UpdateRelatorDto dto) {
        Relator relator = relatorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relator", "id", id));

        if (dto.getRelator() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getRelator());

            if (relatorRepository.existsByRelatorIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Relator", "relator", dto.getRelator());
            }

            relator.setRelator(nombreNormalizado);
        }

        return relatorRepository.save(relator);
    }

    @Transactional
    public DeleteRelatorResponseDto delete(Integer id) {
        Relator relator = relatorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relator", "id", id));

        relatorRepository.delete(relator);
        return new DeleteRelatorResponseDto(
                relator.getId(),
                relator.getRelator(),
                "Relator eliminado exitosamente"
        );
    }
}
