package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateBateriasEstadoDto;
import com.tallermecanico.dto.request.UpdateBateriasEstadoDto;
import com.tallermecanico.dto.response.DeleteBateriasEstadoResponseDto;
import com.tallermecanico.entity.BateriasEstado;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.BateriasEstadoRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BateriasEstadoService {

    private final BateriasEstadoRepository bateriasEstadoRepository;

    public BateriasEstadoService(BateriasEstadoRepository bateriasEstadoRepository) {
        this.bateriasEstadoRepository = bateriasEstadoRepository;
    }

    @Transactional
    public BateriasEstado create(CreateBateriasEstadoDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getEstado());

        if (bateriasEstadoRepository.existsByEstadoIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("BateriasEstado", "estado", dto.getEstado());
        }

        BateriasEstado bateriasEstado = new BateriasEstado();
        bateriasEstado.setEstado(nombreNormalizado);

        return bateriasEstadoRepository.save(bateriasEstado);
    }

    @Transactional(readOnly = true)
    public List<BateriasEstado> findAll() {
        return bateriasEstadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public BateriasEstado findById(Integer id) {
        return bateriasEstadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriasEstado", "id", id));
    }

    @Transactional
    public BateriasEstado update(Integer id, UpdateBateriasEstadoDto dto) {
        BateriasEstado bateriasEstado = bateriasEstadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriasEstado", "id", id));

        if (dto.getEstado() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getEstado());

            if (bateriasEstadoRepository.existsByEstadoIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("BateriasEstado", "estado", dto.getEstado());
            }

            bateriasEstado.setEstado(nombreNormalizado);
        }

        return bateriasEstadoRepository.save(bateriasEstado);
    }

    @Transactional
    public DeleteBateriasEstadoResponseDto delete(Integer id) {
        BateriasEstado bateriasEstado = bateriasEstadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriasEstado", "id", id));

        bateriasEstadoRepository.delete(bateriasEstado);
        return new DeleteBateriasEstadoResponseDto(
                bateriasEstado.getId(),
                bateriasEstado.getEstado(),
                "Estado de batería eliminado exitosamente"
        );
    }
}
