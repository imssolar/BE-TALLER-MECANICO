package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateCiudadDto;
import com.tallermecanico.dto.request.UpdateCiudadDto;
import com.tallermecanico.dto.response.DeleteCiudadResponseDto;
import com.tallermecanico.entity.Ciudad;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.CiudadRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Transactional
    public Ciudad create(CreateCiudadDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getCiudad());

        if (ciudadRepository.existsByCiudadIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Ciudad", "ciudad", dto.getCiudad());
        }

        Ciudad ciudad = new Ciudad();
        ciudad.setCiudad(nombreNormalizado);

        return ciudadRepository.save(ciudad);
    }

    @Transactional(readOnly = true)
    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Ciudad findById(Integer id) {
        return ciudadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ciudad", "id", id));
    }

    @Transactional
    public Ciudad update(Integer id, UpdateCiudadDto dto) {
        Ciudad ciudad = ciudadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ciudad", "id", id));

        if (dto.getCiudad() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getCiudad());

            if (ciudadRepository.existsByCiudadIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Ciudad", "ciudad", dto.getCiudad());
            }

            ciudad.setCiudad(nombreNormalizado);
        }

        return ciudadRepository.save(ciudad);
    }

    @Transactional
    public DeleteCiudadResponseDto delete(Integer id) {
        Ciudad ciudad = ciudadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ciudad", "id", id));

        ciudadRepository.delete(ciudad);
        return new DeleteCiudadResponseDto(
                ciudad.getId(),
                ciudad.getCiudad(),
                "Ciudad eliminada exitosamente"
        );
    }
}
