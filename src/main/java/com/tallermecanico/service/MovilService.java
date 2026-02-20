package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMovilDto;
import com.tallermecanico.dto.request.UpdateMovilDto;
import com.tallermecanico.dto.response.DeleteMovilResponseDto;
import com.tallermecanico.entity.Movil;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MovilRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovilService {

    private final MovilRepository movilRepository;

    public MovilService(MovilRepository movilRepository) {
        this.movilRepository = movilRepository;
    }

    @Transactional
    public Movil create(CreateMovilDto dto) {
        String patenteUpper = dto.getPatente().toUpperCase();

        if (movilRepository.existsByPatente(patenteUpper)) {
            throw new DuplicateResourceException("Movil", "patente", patenteUpper);
        }

        Movil movil = new Movil();
        movil.setPatente(patenteUpper);
        movil.setMarca(dto.getMarca());
        movil.setModelo(dto.getModelo());
        movil.setResponsable(dto.getResponsable());
        movil.setAnoFabricacion(dto.getAnoFabricacion());
        movil.setOperativa(dto.getOperativa() != null ? dto.getOperativa() : true);
        movil.setKm(dto.getKm());
        movil.setFechaRevisionTecnica(dto.getFechaRevisionTecnica());
        movil.setFechaRevisionGases(dto.getFechaRevisionGases());

        return movilRepository.save(movil);
    }

    @Transactional(readOnly = true)
    public List<Movil> findAll() {
        return movilRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Movil findById(Integer id) {
        return movilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movil", "id", id));
    }

    @Transactional
    public Movil update(Integer id, UpdateMovilDto dto) {
        Movil movil = movilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movil", "id", id));

        if (dto.getPatente() != null) {
            String patenteUpper = dto.getPatente().toUpperCase();
            if (movilRepository.existsByPatenteAndIdNot(patenteUpper, id)) {
                throw new DuplicateResourceException("Movil", "patente", patenteUpper);
            }
            movil.setPatente(patenteUpper);
        }
        if (dto.getMarca() != null) {
            movil.setMarca(dto.getMarca());
        }
        if (dto.getModelo() != null) {
            movil.setModelo(dto.getModelo());
        }
        if (dto.getResponsable() != null) {
            movil.setResponsable(dto.getResponsable());
        }
        if (dto.getAnoFabricacion() != null) {
            movil.setAnoFabricacion(dto.getAnoFabricacion());
        }
        if (dto.getOperativa() != null) {
            movil.setOperativa(dto.getOperativa());
        }
        if (dto.getKm() != null) {
            movil.setKm(dto.getKm());
        }
        if (dto.getFechaRevisionTecnica() != null) {
            movil.setFechaRevisionTecnica(dto.getFechaRevisionTecnica());
        }
        if (dto.getFechaRevisionGases() != null) {
            movil.setFechaRevisionGases(dto.getFechaRevisionGases());
        }

        return movilRepository.save(movil);
    }

    @Transactional
    public DeleteMovilResponseDto delete(Integer id) {
        Movil movil = movilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movil", "id", id));

        movilRepository.delete(movil);
        return new DeleteMovilResponseDto(
                movil.getId(),
                movil.getPatente(),
                "Móvil eliminado exitosamente"
        );
    }
}
