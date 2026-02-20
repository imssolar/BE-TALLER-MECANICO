package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateAreaDto;
import com.tallermecanico.dto.request.UpdateAreaDto;
import com.tallermecanico.dto.response.DeleteAreaResponseDto;
import com.tallermecanico.entity.Area;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.AreaRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AreaService {

    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Transactional
    public Area create(CreateAreaDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getArea());

        if (areaRepository.existsByAreaIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("Area", "area", dto.getArea());
        }

        Area area = new Area();
        area.setArea(nombreNormalizado);
        area.setPonderacion(dto.getPonderacion());

        return areaRepository.save(area);
    }

    @Transactional(readOnly = true)
    public List<Area> findAll() {
        return areaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Area findById(Integer id) {
        return areaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Area", "id", id));
    }

    @Transactional
    public Area update(Integer id, UpdateAreaDto dto) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Area", "id", id));

        if (dto.getArea() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getArea());

            if (areaRepository.existsByAreaIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("Area", "area", dto.getArea());
            }

            area.setArea(nombreNormalizado);
        }

        if (dto.getPonderacion() != null) {
            area.setPonderacion(dto.getPonderacion());
        }

        return areaRepository.save(area);
    }

    @Transactional
    public DeleteAreaResponseDto delete(Integer id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Area", "id", id));

        areaRepository.delete(area);
        return new DeleteAreaResponseDto(
                area.getId(),
                area.getArea(),
                "Área eliminada exitosamente"
        );
    }
}
