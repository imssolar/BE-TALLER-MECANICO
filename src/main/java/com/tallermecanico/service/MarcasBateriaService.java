package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMarcasBateriaDto;
import com.tallermecanico.entity.MarcasBateria;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MarcasBateriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarcasBateriaService {

    private final MarcasBateriaRepository marcasBateriaRepository;

    public MarcasBateriaService(MarcasBateriaRepository marcasBateriaRepository) {
        this.marcasBateriaRepository = marcasBateriaRepository;
    }

    @Transactional
    public MarcasBateria create(CreateMarcasBateriaDto dto) {
        // Validar marca única
        if (marcasBateriaRepository.existsByMarca(dto.getMarca())) {
            throw new DuplicateResourceException("MarcasBateria", "marca", dto.getMarca());
        }

        MarcasBateria marca = new MarcasBateria();
        marca.setMarca(dto.getMarca());

        return marcasBateriaRepository.save(marca);
    }

    @Transactional(readOnly = true)
    public List<MarcasBateria> findAll() {
        return marcasBateriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MarcasBateria findById(Integer id) {
        return marcasBateriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MarcasBateria", "id", id));
    }

    @Transactional
    public MarcasBateria update(Integer id, CreateMarcasBateriaDto dto) {
        MarcasBateria marca = findById(id);

        if (dto.getMarca() != null) {
            // Validar marca única (excluyendo la actual)
            if (marcasBateriaRepository.existsByMarcaAndIdNot(dto.getMarca(), id)) {
                throw new DuplicateResourceException("MarcasBateria", "marca", dto.getMarca());
            }
            marca.setMarca(dto.getMarca());
        }

        return marcasBateriaRepository.save(marca);
    }

    @Transactional
    public void delete(Integer id) {
        MarcasBateria marca = findById(id);
        marcasBateriaRepository.delete(marca);
    }
}
