package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateTipoVisaDto;
import com.tallermecanico.dto.request.UpdateTipoVisaDto;
import com.tallermecanico.dto.response.DeleteTipoVisaResponseDto;
import com.tallermecanico.entity.TipoVisa;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.TipoVisaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoVisaService {

    private final TipoVisaRepository tipoVisaRepository;

    public TipoVisaService(TipoVisaRepository tipoVisaRepository) {
        this.tipoVisaRepository = tipoVisaRepository;
    }

    @Transactional
    public TipoVisa create(CreateTipoVisaDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getTipoVisa());

        if (tipoVisaRepository.existsByTipoVisaIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("TipoVisa", "tipoVisa", dto.getTipoVisa());
        }

        TipoVisa tipoVisa = new TipoVisa();
        tipoVisa.setTipoVisa(nombreNormalizado);

        return tipoVisaRepository.save(tipoVisa);
    }

    @Transactional(readOnly = true)
    public List<TipoVisa> findAll() {
        return tipoVisaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TipoVisa findById(Integer id) {
        return tipoVisaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoVisa", "id", id));
    }

    @Transactional
    public TipoVisa update(Integer id, UpdateTipoVisaDto dto) {
        TipoVisa tipoVisa = tipoVisaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoVisa", "id", id));

        if (dto.getTipoVisa() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getTipoVisa());

            if (tipoVisaRepository.existsByTipoVisaIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("TipoVisa", "tipoVisa", dto.getTipoVisa());
            }

            tipoVisa.setTipoVisa(nombreNormalizado);
        }

        return tipoVisaRepository.save(tipoVisa);
    }

    @Transactional
    public DeleteTipoVisaResponseDto delete(Integer id) {
        TipoVisa tipoVisa = tipoVisaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoVisa", "id", id));

        tipoVisaRepository.delete(tipoVisa);
        return new DeleteTipoVisaResponseDto(
                tipoVisa.getId(),
                tipoVisa.getTipoVisa(),
                "Tipo de visa eliminado exitosamente"
        );
    }
}
