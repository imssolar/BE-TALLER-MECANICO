package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateRutaDto;
import com.tallermecanico.dto.request.UpdateRutaDto;
import com.tallermecanico.dto.response.DeleteResponseDto;
import com.tallermecanico.dto.response.RutaResponseDto;
import com.tallermecanico.entity.Ruta;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.RutaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RutaService {

    private final RutaRepository rutaRepository;

    public RutaService(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    @Transactional
    public RutaResponseDto create(CreateRutaDto dto) {
        String rutaNormalizada = TextUtils.normalizeText(dto.getRuta());

        // Validar ruta única (con normalización)
        if (rutaRepository.existsByRutaIgnoreCase(rutaNormalizada)) {
            throw new DuplicateResourceException("Ruta", "ruta", dto.getRuta());
        }

        Ruta ruta = new Ruta();
        ruta.setRuta(rutaNormalizada);

        Ruta savedRuta = rutaRepository.save(ruta);
        return toResponseDto(savedRuta);
    }

    @Transactional(readOnly = true)
    public List<RutaResponseDto> findAll() {
        return rutaRepository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RutaResponseDto findById(Integer id) {
        Ruta ruta = rutaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ruta", "id", id));
        return toResponseDto(ruta);
    }

    @Transactional
    public RutaResponseDto update(Integer id, UpdateRutaDto dto) {
        Ruta ruta = rutaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ruta", "id", id));

        if (dto.getRuta() != null) {
            String rutaNormalizada = TextUtils.normalizeText(dto.getRuta());

            // Validar ruta única (excluyendo la actual)
            if (rutaRepository.existsByRutaIgnoreCaseAndIdRutaNot(rutaNormalizada, id)) {
                throw new DuplicateResourceException("Ruta", "ruta", dto.getRuta());
            }

            ruta.setRuta(rutaNormalizada);
        }

        Ruta updatedRuta = rutaRepository.save(ruta);
        return toResponseDto(updatedRuta);
    }

    @Transactional
    public DeleteResponseDto delete(Integer id) {
        Ruta ruta = rutaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ruta", "id", id));

        rutaRepository.delete(ruta);
        return new DeleteResponseDto(ruta.getIdRuta(), ruta.getRuta());
    }

    private RutaResponseDto toResponseDto(Ruta ruta) {
        return new RutaResponseDto(ruta.getIdRuta(), ruta.getRuta());
    }
}
