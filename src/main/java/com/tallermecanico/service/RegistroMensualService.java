package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateRegistroMensualDto;
import com.tallermecanico.dto.request.UpdateRegistroMensualDto;
import com.tallermecanico.dto.response.DeleteRegistroMensualResponseDto;
import com.tallermecanico.entity.RegistroMensual;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.RegistroMensualRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistroMensualService {

    private final RegistroMensualRepository registroMensualRepository;

    public RegistroMensualService(RegistroMensualRepository registroMensualRepository) {
        this.registroMensualRepository = registroMensualRepository;
    }

    @Transactional
    public RegistroMensual create(CreateRegistroMensualDto dto) {
        RegistroMensual registroMensual = new RegistroMensual();
        registroMensual.setAnio(dto.getAnio());
        registroMensual.setItem(dto.getItem());
        registroMensual.setEnero(dto.getEnero());
        registroMensual.setFebrero(dto.getFebrero());
        registroMensual.setMarzo(dto.getMarzo());
        registroMensual.setAbril(dto.getAbril());
        registroMensual.setMayo(dto.getMayo());
        registroMensual.setJunio(dto.getJunio());
        registroMensual.setJulio(dto.getJulio());
        registroMensual.setAgosto(dto.getAgosto());
        registroMensual.setSeptiembre(dto.getSeptiembre());
        registroMensual.setOctubre(dto.getOctubre());
        registroMensual.setNoviembre(dto.getNoviembre());
        registroMensual.setDiciembre(dto.getDiciembre());
        registroMensual.setTipo(dto.getTipo());

        return registroMensualRepository.save(registroMensual);
    }

    @Transactional(readOnly = true)
    public List<RegistroMensual> findAll() {
        return registroMensualRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RegistroMensual findById(Integer id) {
        return registroMensualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegistroMensual", "id", id));
    }

    @Transactional(readOnly = true)
    public List<RegistroMensual> findByTipo(String tipo) {
        return registroMensualRepository.findByTipo(tipo);
    }

    @Transactional(readOnly = true)
    public List<RegistroMensual> findByAnio(Integer anio) {
        return registroMensualRepository.findByAnio(anio);
    }

    @Transactional
    public RegistroMensual update(Integer id, UpdateRegistroMensualDto dto) {
        RegistroMensual registroMensual = registroMensualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegistroMensual", "id", id));

        if (dto.getAnio() != null) {
            registroMensual.setAnio(dto.getAnio());
        }
        if (dto.getItem() != null) {
            registroMensual.setItem(dto.getItem());
        }
        if (dto.getEnero() != null) {
            registroMensual.setEnero(dto.getEnero());
        }
        if (dto.getFebrero() != null) {
            registroMensual.setFebrero(dto.getFebrero());
        }
        if (dto.getMarzo() != null) {
            registroMensual.setMarzo(dto.getMarzo());
        }
        if (dto.getAbril() != null) {
            registroMensual.setAbril(dto.getAbril());
        }
        if (dto.getMayo() != null) {
            registroMensual.setMayo(dto.getMayo());
        }
        if (dto.getJunio() != null) {
            registroMensual.setJunio(dto.getJunio());
        }
        if (dto.getJulio() != null) {
            registroMensual.setJulio(dto.getJulio());
        }
        if (dto.getAgosto() != null) {
            registroMensual.setAgosto(dto.getAgosto());
        }
        if (dto.getSeptiembre() != null) {
            registroMensual.setSeptiembre(dto.getSeptiembre());
        }
        if (dto.getOctubre() != null) {
            registroMensual.setOctubre(dto.getOctubre());
        }
        if (dto.getNoviembre() != null) {
            registroMensual.setNoviembre(dto.getNoviembre());
        }
        if (dto.getDiciembre() != null) {
            registroMensual.setDiciembre(dto.getDiciembre());
        }
        if (dto.getTipo() != null) {
            registroMensual.setTipo(dto.getTipo());
        }

        return registroMensualRepository.save(registroMensual);
    }

    @Transactional
    public DeleteRegistroMensualResponseDto delete(Integer id) {
        RegistroMensual registroMensual = registroMensualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegistroMensual", "id", id));

        registroMensualRepository.delete(registroMensual);
        return new DeleteRegistroMensualResponseDto(
                registroMensual.getId(),
                "Registro mensual eliminado exitosamente"
        );
    }
}
