package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMarcasNeumaticoDto;
import com.tallermecanico.dto.request.UpdateMarcasNeumaticoDto;
import com.tallermecanico.dto.response.DeleteMarcasNeumaticoResponseDto;
import com.tallermecanico.entity.MarcasNeumatico;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MarcasNeumaticoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarcasNeumaticoService {

    private final MarcasNeumaticoRepository marcasNeumaticoRepository;

    public MarcasNeumaticoService(MarcasNeumaticoRepository marcasNeumaticoRepository) {
        this.marcasNeumaticoRepository = marcasNeumaticoRepository;
    }

    @Transactional
    public MarcasNeumatico create(CreateMarcasNeumaticoDto dto) {
        // Validar marca única
        if (marcasNeumaticoRepository.existsByMarca(dto.getMarca())) {
            throw new DuplicateResourceException("MarcasNeumatico", "marca", dto.getMarca());
        }

        MarcasNeumatico marca = new MarcasNeumatico();
        marca.setMarca(dto.getMarca());

        return marcasNeumaticoRepository.save(marca);
    }

    @Transactional(readOnly = true)
    public List<MarcasNeumatico> findAll() {
        return marcasNeumaticoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MarcasNeumatico findById(Integer id) {
        return marcasNeumaticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MarcasNeumatico", "id", id));
    }

    @Transactional
    public MarcasNeumatico update(Integer id, UpdateMarcasNeumaticoDto dto) {
        MarcasNeumatico marca = findById(id);

        if (dto.getMarca() != null) {
            // Validar marca única (excluyendo la actual)
            if (marcasNeumaticoRepository.existsByMarcaAndIdNot(dto.getMarca(), id)) {
                throw new DuplicateResourceException("MarcasNeumatico", "marca", dto.getMarca());
            }
            marca.setMarca(dto.getMarca());
        }

        return marcasNeumaticoRepository.save(marca);
    }

    @Transactional
    public DeleteMarcasNeumaticoResponseDto delete(Integer id) {
        MarcasNeumatico marca = findById(id);
        marcasNeumaticoRepository.delete(marca);
        return new DeleteMarcasNeumaticoResponseDto(marca.getId(), marca.getMarca());
    }
}
