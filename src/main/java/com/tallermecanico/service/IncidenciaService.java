package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateIncidenciaDto;
import com.tallermecanico.dto.request.UpdateIncidenciaDto;
import com.tallermecanico.dto.response.DeleteIncidenciaResponseDto;
import com.tallermecanico.entity.Incidencia;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.IncidenciaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IncidenciaService {

    private final IncidenciaRepository incidenciaRepository;

    public IncidenciaService(IncidenciaRepository incidenciaRepository) {
        this.incidenciaRepository = incidenciaRepository;
    }

    @Transactional
    public Incidencia create(CreateIncidenciaDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getIncidencia());

        if (incidenciaRepository.existsByIncidenciaIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Incidencia", "incidencia", dto.getIncidencia());
        }

        Incidencia incidencia = new Incidencia();
        incidencia.setIncidencia(nombreNormalizado);

        return incidenciaRepository.save(incidencia);
    }

    @Transactional(readOnly = true)
    public List<Incidencia> findAll() {
        return incidenciaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Incidencia findById(Integer id) {
        return incidenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incidencia", "id", id));
    }

    @Transactional
    public Incidencia update(Integer id, UpdateIncidenciaDto dto) {
        Incidencia incidencia = incidenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incidencia", "id", id));

        if (dto.getIncidencia() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getIncidencia());

            if (incidenciaRepository.existsByIncidenciaIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Incidencia", "incidencia", dto.getIncidencia());
            }

            incidencia.setIncidencia(nombreNormalizado);
        }

        return incidenciaRepository.save(incidencia);
    }

    @Transactional
    public DeleteIncidenciaResponseDto delete(Integer id) {
        Incidencia incidencia = incidenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incidencia", "id", id));

        incidenciaRepository.delete(incidencia);
        return new DeleteIncidenciaResponseDto(
                incidencia.getId(),
                incidencia.getIncidencia(),
                "Incidencia eliminada exitosamente"
        );
    }
}
