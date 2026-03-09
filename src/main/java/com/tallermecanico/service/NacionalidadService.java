package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateNacionalidadDto;
import com.tallermecanico.dto.request.UpdateNacionalidadDto;
import com.tallermecanico.dto.response.DeleteNacionalidadResponseDto;
import com.tallermecanico.entity.Nacionalidad;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.NacionalidadRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NacionalidadService {

    private final NacionalidadRepository nacionalidadRepository;

    public NacionalidadService(NacionalidadRepository nacionalidadRepository) {
        this.nacionalidadRepository = nacionalidadRepository;
    }

    @Transactional
    public Nacionalidad create(CreateNacionalidadDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getNacionalidad());

        if (nacionalidadRepository.existsByNacionalidadIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Nacionalidad", "nacionalidad", dto.getNacionalidad());
        }

        Nacionalidad nacionalidad = new Nacionalidad();
        nacionalidad.setNacionalidad(nombreNormalizado);

        return nacionalidadRepository.save(nacionalidad);
    }

    @Transactional(readOnly = true)
    public List<Nacionalidad> findAll() {
        return nacionalidadRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Nacionalidad findById(Integer id) {
        return nacionalidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nacionalidad", "id", id));
    }

    @Transactional
    public Nacionalidad update(Integer id, UpdateNacionalidadDto dto) {
        Nacionalidad nacionalidad = nacionalidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nacionalidad", "id", id));

        if (dto.getNacionalidad() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getNacionalidad());

            if (nacionalidadRepository.existsByNacionalidadIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Nacionalidad", "nacionalidad", dto.getNacionalidad());
            }

            nacionalidad.setNacionalidad(nombreNormalizado);
        }

        return nacionalidadRepository.save(nacionalidad);
    }

    @Transactional
    public DeleteNacionalidadResponseDto delete(Integer id) {
        Nacionalidad nacionalidad = nacionalidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nacionalidad", "id", id));

        nacionalidadRepository.delete(nacionalidad);
        return new DeleteNacionalidadResponseDto(
                nacionalidad.getId(),
                nacionalidad.getNacionalidad(),
                "Nacionalidad eliminada exitosamente"
        );
    }
}
