package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateResponsableDto;
import com.tallermecanico.dto.request.UpdateResponsableDto;
import com.tallermecanico.dto.response.DeleteResponsableResponseDto;
import com.tallermecanico.entity.Responsable;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ResponsableRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResponsableService {

    private final ResponsableRepository responsableRepository;

    public ResponsableService(ResponsableRepository responsableRepository) {
        this.responsableRepository = responsableRepository;
    }

    @Transactional
    public Responsable create(CreateResponsableDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getResponsable());

        if (responsableRepository.existsByResponsableIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Responsable", "responsable", dto.getResponsable());
        }

        Responsable responsable = new Responsable();
        responsable.setResponsable(nombreNormalizado);

        return responsableRepository.save(responsable);
    }

    @Transactional(readOnly = true)
    public List<Responsable> findAll() {
        return responsableRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Responsable findById(Integer id) {
        return responsableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Responsable", "id", id));
    }

    @Transactional
    public Responsable update(Integer id, UpdateResponsableDto dto) {
        Responsable responsable = responsableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Responsable", "id", id));

        if (dto.getResponsable() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getResponsable());

            if (responsableRepository.existsByResponsableIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Responsable", "responsable", dto.getResponsable());
            }

            responsable.setResponsable(nombreNormalizado);
        }

        return responsableRepository.save(responsable);
    }

    @Transactional
    public DeleteResponsableResponseDto delete(Integer id) {
        Responsable responsable = responsableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Responsable", "id", id));

        responsableRepository.delete(responsable);
        return new DeleteResponsableResponseDto(
                responsable.getId(),
                responsable.getResponsable(),
                "Responsable eliminado exitosamente"
        );
    }
}
