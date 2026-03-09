package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateTallerExternoDto;
import com.tallermecanico.dto.request.UpdateTallerExternoDto;
import com.tallermecanico.dto.response.DeleteTallerExternoResponseDto;
import com.tallermecanico.entity.Comuna;
import com.tallermecanico.entity.TallerExterno;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.TallerExternoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TallerExternoService {

    private final TallerExternoRepository tallerExternoRepository;
    private final ComunaService comunaService;

    public TallerExternoService(TallerExternoRepository tallerExternoRepository,
                                ComunaService comunaService) {
        this.tallerExternoRepository = tallerExternoRepository;
        this.comunaService = comunaService;
    }

    @Transactional
    public TallerExterno create(CreateTallerExternoDto dto) {
        TallerExterno tallerExterno = new TallerExterno();
        tallerExterno.setRazonSocial(dto.getRazonSocial());
        tallerExterno.setRut(dto.getRut());
        tallerExterno.setDireccion(dto.getDireccion());
        tallerExterno.setFono(dto.getFono());

        if (dto.getIdComuna() != null) {
            Comuna comuna = comunaService.findById(dto.getIdComuna());
            tallerExterno.setComuna(comuna);
        }

        return tallerExternoRepository.save(tallerExterno);
    }

    @Transactional(readOnly = true)
    public List<TallerExterno> findAll() {
        return tallerExternoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TallerExterno findById(Integer id) {
        return tallerExternoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TallerExterno", "id", id));
    }

    @Transactional
    public TallerExterno update(Integer id, UpdateTallerExternoDto dto) {
        TallerExterno tallerExterno = tallerExternoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TallerExterno", "id", id));

        if (dto.getRazonSocial() != null) {
            tallerExterno.setRazonSocial(dto.getRazonSocial());
        }
        if (dto.getRut() != null) {
            tallerExterno.setRut(dto.getRut());
        }
        if (dto.getDireccion() != null) {
            tallerExterno.setDireccion(dto.getDireccion());
        }
        if (dto.getFono() != null) {
            tallerExterno.setFono(dto.getFono());
        }
        if (dto.getIdComuna() != null) {
            Comuna comuna = comunaService.findById(dto.getIdComuna());
            tallerExterno.setComuna(comuna);
        }

        return tallerExternoRepository.save(tallerExterno);
    }

    @Transactional
    public DeleteTallerExternoResponseDto delete(Integer id) {
        TallerExterno tallerExterno = tallerExternoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TallerExterno", "id", id));

        tallerExternoRepository.delete(tallerExterno);
        return new DeleteTallerExternoResponseDto(
                tallerExterno.getId(),
                tallerExterno.getRazonSocial(),
                "Taller externo eliminado exitosamente"
        );
    }
}
