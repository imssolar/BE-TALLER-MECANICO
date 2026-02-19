package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateTallerDto;
import com.tallermecanico.dto.request.UpdateTallerDto;
import com.tallermecanico.dto.response.DeleteTallerResponseDto;
import com.tallermecanico.entity.Taller;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.TallerRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TallerService {

    private final TallerRepository tallerRepository;

    public TallerService(TallerRepository tallerRepository) {
        this.tallerRepository = tallerRepository;
    }

    @Transactional
    public Taller create(CreateTallerDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getTaller());

        if (tallerRepository.existsByTallerIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Taller", "taller", dto.getTaller());
        }

        Taller taller = new Taller();
        taller.setTaller(nombreNormalizado);

        return tallerRepository.save(taller);
    }

    @Transactional(readOnly = true)
    public List<Taller> findAll() {
        return tallerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Taller findById(Integer id) {
        return tallerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Taller", "id", id));
    }

    @Transactional
    public Taller update(Integer id, UpdateTallerDto dto) {
        Taller taller = tallerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Taller", "id", id));

        if (dto.getTaller() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getTaller());

            if (tallerRepository.existsByTallerIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Taller", "taller", dto.getTaller());
            }

            taller.setTaller(nombreNormalizado);
        }

        return tallerRepository.save(taller);
    }

    @Transactional
    public DeleteTallerResponseDto delete(Integer id) {
        Taller taller = tallerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Taller", "id", id));

        tallerRepository.delete(taller);
        return new DeleteTallerResponseDto(
                taller.getId(),
                taller.getTaller(),
                "Taller eliminado exitosamente"
        );
    }
}
