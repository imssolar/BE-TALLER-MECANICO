package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateSistemaDto;
import com.tallermecanico.dto.request.UpdateSistemaDto;
import com.tallermecanico.dto.response.DeleteSistemaResponseDto;
import com.tallermecanico.entity.Sistema;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.SistemaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SistemaService {

    private final SistemaRepository sistemaRepository;

    public SistemaService(SistemaRepository sistemaRepository) {
        this.sistemaRepository = sistemaRepository;
    }

    @Transactional
    public Sistema create(CreateSistemaDto dto) {
        // Validar nombre único
        if (sistemaRepository.existsByNombre(dto.getNombre())) {
            throw new DuplicateResourceException("Sistema", "nombre", dto.getNombre());
        }

        Sistema sistema = new Sistema();
        sistema.setNombre(dto.getNombre());

        return sistemaRepository.save(sistema);
    }

    @Transactional(readOnly = true)
    public List<Sistema> findAll() {
        return sistemaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Sistema findById(Integer id) {
        return sistemaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sistema", "id", id));
    }

    @Transactional
    public Sistema update(Integer id, UpdateSistemaDto dto) {
        Sistema sistema = findById(id);

        if (dto.getNombre() != null) {
            // Validar nombre único (excluyendo el actual)
            if (sistemaRepository.existsByNombreAndIdNot(dto.getNombre(), id)) {
                throw new DuplicateResourceException("Sistema", "nombre", dto.getNombre());
            }
            sistema.setNombre(dto.getNombre());
        }

        return sistemaRepository.save(sistema);
    }

    @Transactional
    public DeleteSistemaResponseDto delete(Integer id) {
        Sistema sistema = findById(id);
        sistemaRepository.delete(sistema);
        return new DeleteSistemaResponseDto(sistema.getId(), sistema.getNombre());
    }
}
