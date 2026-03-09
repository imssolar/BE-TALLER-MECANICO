package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateTrabajosElectDto;
import com.tallermecanico.dto.request.UpdateTrabajosElectDto;
import com.tallermecanico.dto.response.DeleteTrabajosElectResponseDto;
import com.tallermecanico.entity.TrabajosElect;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.TrabajosElectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrabajosElectService {

    private final TrabajosElectRepository trabajosElectRepository;

    public TrabajosElectService(TrabajosElectRepository trabajosElectRepository) {
        this.trabajosElectRepository = trabajosElectRepository;
    }

    @Transactional
    public TrabajosElect create(CreateTrabajosElectDto dto) {
        if (trabajosElectRepository.existsByTipoTE(dto.getTipoTE())) {
            throw new DuplicateResourceException("TrabajosElect", "tipoTE", dto.getTipoTE());
        }

        TrabajosElect trabajosElect = new TrabajosElect();
        trabajosElect.setTipoTE(dto.getTipoTE());

        return trabajosElectRepository.save(trabajosElect);
    }

    @Transactional(readOnly = true)
    public List<TrabajosElect> findAll() {
        return trabajosElectRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TrabajosElect findById(Integer id) {
        return trabajosElectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TrabajosElect", "id", id));
    }

    @Transactional
    public TrabajosElect update(Integer id, UpdateTrabajosElectDto dto) {
        TrabajosElect trabajosElect = findById(id);

        if (dto.getTipoTE() != null) {
            if (trabajosElectRepository.existsByTipoTEAndIdNot(dto.getTipoTE(), id)) {
                throw new DuplicateResourceException("TrabajosElect", "tipoTE", dto.getTipoTE());
            }
            trabajosElect.setTipoTE(dto.getTipoTE());
        }

        return trabajosElectRepository.save(trabajosElect);
    }

    @Transactional
    public DeleteTrabajosElectResponseDto delete(Integer id) {
        TrabajosElect trabajosElect = findById(id);
        trabajosElectRepository.delete(trabajosElect);
        return new DeleteTrabajosElectResponseDto(trabajosElect.getId(), trabajosElect.getTipoTE());
    }
}
