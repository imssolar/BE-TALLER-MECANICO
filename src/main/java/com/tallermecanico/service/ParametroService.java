package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateParametroDto;
import com.tallermecanico.dto.request.UpdateParametroDto;
import com.tallermecanico.dto.response.DeleteParametroResponseDto;
import com.tallermecanico.entity.Parametro;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ParametroRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParametroService {

    private final ParametroRepository parametroRepository;

    public ParametroService(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }

    @Transactional
    public Parametro create(CreateParametroDto dto) {
        String descripcionNormalizada = TextUtils.normalizeText(dto.getDescripcion());

        if (parametroRepository.existsByDescripcionIgnoreCase(descripcionNormalizada)) {
            throw new DuplicateResourceException("Parametro", "descripcion", dto.getDescripcion());
        }

        Parametro parametro = new Parametro();
        parametro.setDescripcion(descripcionNormalizada);
        parametro.setValor(dto.getValor());

        return parametroRepository.save(parametro);
    }

    @Transactional(readOnly = true)
    public List<Parametro> findAll() {
        return parametroRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Parametro findById(Integer id) {
        return parametroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parametro", "id", id));
    }

    @Transactional
    public Parametro update(Integer id, UpdateParametroDto dto) {
        Parametro parametro = parametroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parametro", "id", id));

        if (dto.getDescripcion() != null) {
            String descripcionNormalizada = TextUtils.normalizeText(dto.getDescripcion());

            if (parametroRepository.existsByDescripcionIgnoreCaseAndIdNot(descripcionNormalizada, id)) {
                throw new DuplicateResourceException("Parametro", "descripcion", dto.getDescripcion());
            }

            parametro.setDescripcion(descripcionNormalizada);
        }

        if (dto.getValor() != null) {
            parametro.setValor(dto.getValor());
        }

        return parametroRepository.save(parametro);
    }

    @Transactional
    public DeleteParametroResponseDto delete(Integer id) {
        Parametro parametro = parametroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parametro", "id", id));

        parametroRepository.delete(parametro);
        return new DeleteParametroResponseDto(
                parametro.getId(),
                parametro.getDescripcion(),
                "Parámetro eliminado exitosamente"
        );
    }
}
