package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateFallasTiposDto;
import com.tallermecanico.dto.request.UpdateFallasTiposDto;
import com.tallermecanico.entity.Falla;
import com.tallermecanico.entity.FallasTipos;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.FallasTiposRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FallasTiposService {

    private final FallasTiposRepository fallasTiposRepository;
    private final FallaService fallaService;

    public FallasTiposService(FallasTiposRepository fallasTiposRepository, FallaService fallaService) {
        this.fallasTiposRepository = fallasTiposRepository;
        this.fallaService = fallaService;
    }

    @Transactional
    public FallasTipos create(CreateFallasTiposDto dto) {
        Falla falla = fallaService.findById(dto.getIdFalla());

        if (fallasTiposRepository.existsByTipoFallaAndFalla_IdFalla(dto.getTipoFalla(), dto.getIdFalla())) {
            throw new DuplicateResourceException("FallasTipos", "tipoFalla", dto.getTipoFalla());
        }

        FallasTipos fallasTipos = new FallasTipos();
        fallasTipos.setFalla(falla);
        fallasTipos.setTipoFalla(dto.getTipoFalla());

        return fallasTiposRepository.save(fallasTipos);
    }

    @Transactional(readOnly = true)
    public List<FallasTipos> findAll() {
        return fallasTiposRepository.findAll();
    }

    @Transactional(readOnly = true)
    public FallasTipos findById(Integer id) {
        return fallasTiposRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FallasTipos", "id", id));
    }

    @Transactional(readOnly = true)
    public List<FallasTipos> findByFalla(String idFalla) {
        fallaService.findById(idFalla);
        return fallasTiposRepository.findByFalla_IdFalla(idFalla);
    }

    @Transactional
    public FallasTipos update(Integer id, UpdateFallasTiposDto dto) {
        FallasTipos fallasTipos = findById(id);

        if (dto.getIdFalla() != null) {
            Falla falla = fallaService.findById(dto.getIdFalla());
            fallasTipos.setFalla(falla);
        }

        if (dto.getTipoFalla() != null) {
            String idFalla = dto.getIdFalla() != null ? dto.getIdFalla() : fallasTipos.getFalla().getIdFalla();
            if (fallasTiposRepository.existsByTipoFallaAndFalla_IdFallaAndIdNot(dto.getTipoFalla(), idFalla, id)) {
                throw new DuplicateResourceException("FallasTipos", "tipoFalla", dto.getTipoFalla());
            }
            fallasTipos.setTipoFalla(dto.getTipoFalla());
        }

        return fallasTiposRepository.save(fallasTipos);
    }

    @Transactional
    public void delete(Integer id) {
        FallasTipos fallasTipos = findById(id);
        fallasTiposRepository.delete(fallasTipos);
    }
}
