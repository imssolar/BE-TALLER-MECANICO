package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateObservacionHojaVidaDto;
import com.tallermecanico.dto.request.UpdateObservacionHojaVidaDto;
import com.tallermecanico.dto.response.DeleteObservacionHojaVidaResponseDto;
import com.tallermecanico.entity.ObservacionHojaVida;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ObservacionHojaVidaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ObservacionHojaVidaService {

    private final ObservacionHojaVidaRepository observacionHojaVidaRepository;

    public ObservacionHojaVidaService(ObservacionHojaVidaRepository observacionHojaVidaRepository) {
        this.observacionHojaVidaRepository = observacionHojaVidaRepository;
    }

    @Transactional
    public ObservacionHojaVida create(CreateObservacionHojaVidaDto dto) {
        if (observacionHojaVidaRepository.existsById(dto.getIdObs())) {
            throw new DuplicateResourceException("ObservacionHojaVida", "idObs", dto.getIdObs());
        }

        ObservacionHojaVida observacionHojaVida = new ObservacionHojaVida();
        observacionHojaVida.setIdObs(dto.getIdObs());
        observacionHojaVida.setObservacion(dto.getObservacion());

        return observacionHojaVidaRepository.save(observacionHojaVida);
    }

    @Transactional(readOnly = true)
    public List<ObservacionHojaVida> findAll() {
        return observacionHojaVidaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ObservacionHojaVida findById(String id) {
        return observacionHojaVidaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ObservacionHojaVida", "idObs", id));
    }

    @Transactional
    public ObservacionHojaVida update(String id, UpdateObservacionHojaVidaDto dto) {
        ObservacionHojaVida observacionHojaVida = observacionHojaVidaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ObservacionHojaVida", "idObs", id));

        if (dto.getObservacion() != null) {
            observacionHojaVida.setObservacion(dto.getObservacion());
        }

        return observacionHojaVidaRepository.save(observacionHojaVida);
    }

    @Transactional
    public DeleteObservacionHojaVidaResponseDto delete(String id) {
        ObservacionHojaVida observacionHojaVida = observacionHojaVidaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ObservacionHojaVida", "idObs", id));

        observacionHojaVidaRepository.delete(observacionHojaVida);
        return new DeleteObservacionHojaVidaResponseDto(
                observacionHojaVida.getIdObs(),
                observacionHojaVida.getObservacion(),
                "Observación de hoja de vida eliminada exitosamente"
        );
    }
}
