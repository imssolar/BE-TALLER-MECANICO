package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateGlosaDto;
import com.tallermecanico.dto.request.UpdateGlosaDto;
import com.tallermecanico.dto.response.DeleteGlosaResponseDto;
import com.tallermecanico.entity.Glosa;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.GlosaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GlosaService {

    private final GlosaRepository glosaRepository;

    public GlosaService(GlosaRepository glosaRepository) {
        this.glosaRepository = glosaRepository;
    }

    @Transactional
    public Glosa create(CreateGlosaDto dto) {
        // Validar glosa única
        if (glosaRepository.existsByGlosa(dto.getGlosa())) {
            throw new DuplicateResourceException("Glosa", "glosa", dto.getGlosa());
        }

        Glosa glosa = new Glosa();
        glosa.setGlosa(dto.getGlosa());

        return glosaRepository.save(glosa);
    }

    @Transactional(readOnly = true)
    public List<Glosa> findAll() {
        return glosaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Glosa findById(Integer id) {
        return glosaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Glosa", "id", id));
    }

    @Transactional
    public Glosa update(Integer id, UpdateGlosaDto dto) {
        Glosa glosa = findById(id);

        if (dto.getGlosa() != null) {
            // Validar glosa única (excluyendo la actual)
            if (glosaRepository.existsByGlosaAndIdNot(dto.getGlosa(), id)) {
                throw new DuplicateResourceException("Glosa", "glosa", dto.getGlosa());
            }
            glosa.setGlosa(dto.getGlosa());
        }

        return glosaRepository.save(glosa);
    }

    @Transactional
    public DeleteGlosaResponseDto delete(Integer id) {
        Glosa glosa = findById(id);
        glosaRepository.delete(glosa);
        return new DeleteGlosaResponseDto(glosa.getId(), glosa.getGlosa());
    }
}
