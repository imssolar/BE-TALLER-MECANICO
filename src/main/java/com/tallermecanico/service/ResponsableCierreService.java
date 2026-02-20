package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateResponsableCierreDto;
import com.tallermecanico.dto.request.UpdateResponsableCierreDto;
import com.tallermecanico.dto.response.DeleteResponsableCierreResponseDto;
import com.tallermecanico.entity.ResponsableCierre;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ResponsableCierreRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResponsableCierreService {

    private final ResponsableCierreRepository responsableCierreRepository;

    public ResponsableCierreService(ResponsableCierreRepository responsableCierreRepository) {
        this.responsableCierreRepository = responsableCierreRepository;
    }

    @Transactional
    public ResponsableCierre create(CreateResponsableCierreDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getNombre());

        if (responsableCierreRepository.existsByNombreIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("ResponsableCierre", "nombre", dto.getNombre());
        }

        ResponsableCierre responsableCierre = new ResponsableCierre();
        responsableCierre.setNombre(nombreNormalizado);

        return responsableCierreRepository.save(responsableCierre);
    }

    @Transactional(readOnly = true)
    public List<ResponsableCierre> findAll() {
        return responsableCierreRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ResponsableCierre findById(Integer id) {
        return responsableCierreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResponsableCierre", "id", id));
    }

    @Transactional
    public ResponsableCierre update(Integer id, UpdateResponsableCierreDto dto) {
        ResponsableCierre responsableCierre = responsableCierreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResponsableCierre", "id", id));

        if (dto.getNombre() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getNombre());

            if (responsableCierreRepository.existsByNombreIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("ResponsableCierre", "nombre", dto.getNombre());
            }

            responsableCierre.setNombre(nombreNormalizado);
        }

        return responsableCierreRepository.save(responsableCierre);
    }

    @Transactional
    public DeleteResponsableCierreResponseDto delete(Integer id) {
        ResponsableCierre responsableCierre = responsableCierreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResponsableCierre", "id", id));

        responsableCierreRepository.delete(responsableCierre);
        return new DeleteResponsableCierreResponseDto(
                responsableCierre.getId(),
                responsableCierre.getNombre(),
                "Responsable de cierre eliminado exitosamente"
        );
    }
}
