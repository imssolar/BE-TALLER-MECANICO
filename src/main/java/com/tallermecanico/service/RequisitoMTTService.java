package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateRequisitoMTTDto;
import com.tallermecanico.dto.request.UpdateRequisitoMTTDto;
import com.tallermecanico.dto.response.DeleteRequisitoMTTResponseDto;
import com.tallermecanico.entity.RequisitoMTT;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.RequisitoMTTRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RequisitoMTTService {

    private final RequisitoMTTRepository requisitoMTTRepository;

    public RequisitoMTTService(RequisitoMTTRepository requisitoMTTRepository) {
        this.requisitoMTTRepository = requisitoMTTRepository;
    }

    @Transactional
    public RequisitoMTT create(CreateRequisitoMTTDto dto) {
        String requisitoNormalizado = TextUtils.normalizeText(dto.getRequisito());

        if (requisitoMTTRepository.existsByRequisitoIgnoreCase(requisitoNormalizado)) {
            throw new DuplicateResourceException("RequisitoMTT", "requisito", dto.getRequisito());
        }

        RequisitoMTT requisitoMTT = new RequisitoMTT();
        requisitoMTT.setRequisito(requisitoNormalizado);
        requisitoMTT.setTipo(dto.getTipo());
        requisitoMTT.setTipoFiltro(dto.getTipoFiltro());

        return requisitoMTTRepository.save(requisitoMTT);
    }

    @Transactional(readOnly = true)
    public List<RequisitoMTT> findAll() {
        return requisitoMTTRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RequisitoMTT findById(Integer id) {
        return requisitoMTTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RequisitoMTT", "id", id));
    }

    @Transactional
    public RequisitoMTT update(Integer id, UpdateRequisitoMTTDto dto) {
        RequisitoMTT requisitoMTT = requisitoMTTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RequisitoMTT", "id", id));

        if (dto.getRequisito() != null) {
            String requisitoNormalizado = TextUtils.normalizeText(dto.getRequisito());

            if (requisitoMTTRepository.existsByRequisitoIgnoreCaseAndIdNot(requisitoNormalizado, id)) {
                throw new DuplicateResourceException("RequisitoMTT", "requisito", dto.getRequisito());
            }

            requisitoMTT.setRequisito(requisitoNormalizado);
        }

        if (dto.getTipo() != null) {
            requisitoMTT.setTipo(dto.getTipo());
        }

        if (dto.getTipoFiltro() != null) {
            requisitoMTT.setTipoFiltro(dto.getTipoFiltro());
        }

        return requisitoMTTRepository.save(requisitoMTT);
    }

    @Transactional
    public DeleteRequisitoMTTResponseDto delete(Integer id) {
        RequisitoMTT requisitoMTT = requisitoMTTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RequisitoMTT", "id", id));

        requisitoMTTRepository.delete(requisitoMTT);
        return new DeleteRequisitoMTTResponseDto(
                requisitoMTT.getId(),
                requisitoMTT.getRequisito(),
                "Requisito MTT eliminado exitosamente"
        );
    }
}
