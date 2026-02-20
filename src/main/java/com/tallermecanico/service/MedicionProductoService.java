package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMedicionProductoDto;
import com.tallermecanico.dto.request.UpdateMedicionProductoDto;
import com.tallermecanico.dto.response.DeleteMedicionProductoResponseDto;
import com.tallermecanico.entity.MedicionProducto;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MedicionProductoRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicionProductoService {

    private final MedicionProductoRepository medicionProductoRepository;

    public MedicionProductoService(MedicionProductoRepository medicionProductoRepository) {
        this.medicionProductoRepository = medicionProductoRepository;
    }

    @Transactional
    public MedicionProducto create(CreateMedicionProductoDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getProducto());

        if (medicionProductoRepository.existsByProductoIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("MedicionProducto", "producto", dto.getProducto());
        }

        MedicionProducto medicionProducto = new MedicionProducto();
        medicionProducto.setProducto(nombreNormalizado);

        return medicionProductoRepository.save(medicionProducto);
    }

    @Transactional(readOnly = true)
    public List<MedicionProducto> findAll() {
        return medicionProductoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MedicionProducto findById(Integer id) {
        return medicionProductoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicionProducto", "id", id));
    }

    @Transactional
    public MedicionProducto update(Integer id, UpdateMedicionProductoDto dto) {
        MedicionProducto medicionProducto = medicionProductoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicionProducto", "id", id));

        if (dto.getProducto() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getProducto());

            if (medicionProductoRepository.existsByProductoIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("MedicionProducto", "producto", dto.getProducto());
            }

            medicionProducto.setProducto(nombreNormalizado);
        }

        return medicionProductoRepository.save(medicionProducto);
    }

    @Transactional
    public DeleteMedicionProductoResponseDto delete(Integer id) {
        MedicionProducto medicionProducto = medicionProductoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicionProducto", "id", id));

        medicionProductoRepository.delete(medicionProducto);
        return new DeleteMedicionProductoResponseDto(
                medicionProducto.getId(),
                medicionProducto.getProducto(),
                "Producto de medición eliminado exitosamente"
        );
    }
}
