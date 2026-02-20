package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMedicionDto;
import com.tallermecanico.dto.request.UpdateMedicionDto;
import com.tallermecanico.dto.response.DeleteMedicionResponseDto;
import com.tallermecanico.entity.Medicion;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MedicionRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicionService {

    private final MedicionRepository medicionRepository;

    public MedicionService(MedicionRepository medicionRepository) {
        this.medicionRepository = medicionRepository;
    }

    @Transactional
    public Medicion create(CreateMedicionDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getMedicion());

        if (medicionRepository.existsByMedicionIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Medicion", "medicion", dto.getMedicion());
        }

        Medicion medicion = new Medicion();
        medicion.setMedicion(nombreNormalizado);

        return medicionRepository.save(medicion);
    }

    @Transactional(readOnly = true)
    public List<Medicion> findAll() {
        return medicionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Medicion findById(Integer id) {
        return medicionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicion", "id", id));
    }

    @Transactional
    public Medicion update(Integer id, UpdateMedicionDto dto) {
        Medicion medicion = medicionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicion", "id", id));

        if (dto.getMedicion() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getMedicion());

            if (medicionRepository.existsByMedicionIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Medicion", "medicion", dto.getMedicion());
            }

            medicion.setMedicion(nombreNormalizado);
        }

        return medicionRepository.save(medicion);
    }

    @Transactional
    public DeleteMedicionResponseDto delete(Integer id) {
        Medicion medicion = medicionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicion", "id", id));

        medicionRepository.delete(medicion);
        return new DeleteMedicionResponseDto(
                medicion.getId(),
                medicion.getMedicion(),
                "Medición eliminada exitosamente"
        );
    }
}
