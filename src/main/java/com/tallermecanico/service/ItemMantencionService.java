package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateItemMantencionDto;
import com.tallermecanico.dto.request.UpdateItemMantencionDto;
import com.tallermecanico.dto.response.DeleteItemMantencionResponseDto;
import com.tallermecanico.entity.ItemMantencion;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ItemMantencionRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemMantencionService {

    private final ItemMantencionRepository itemMantencionRepository;

    public ItemMantencionService(ItemMantencionRepository itemMantencionRepository) {
        this.itemMantencionRepository = itemMantencionRepository;
    }

    @Transactional
    public ItemMantencion create(CreateItemMantencionDto dto) {
        String descripcionNormalizada = TextUtils.normalizeText(dto.getDescripcion());

        if (itemMantencionRepository.existsByDescripcionIgnoreCase(descripcionNormalizada)) {
            throw new DuplicateResourceException("ItemMantencion", "descripcion", dto.getDescripcion());
        }

        ItemMantencion itemMantencion = new ItemMantencion();
        itemMantencion.setDescripcion(descripcionNormalizada);
        itemMantencion.setOrdenGantt(dto.getOrdenGantt());

        return itemMantencionRepository.save(itemMantencion);
    }

    @Transactional(readOnly = true)
    public List<ItemMantencion> findAll() {
        return itemMantencionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ItemMantencion findById(Integer id) {
        return itemMantencionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemMantencion", "id", id));
    }

    @Transactional
    public ItemMantencion update(Integer id, UpdateItemMantencionDto dto) {
        ItemMantencion itemMantencion = itemMantencionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemMantencion", "id", id));

        if (dto.getDescripcion() != null) {
            String descripcionNormalizada = TextUtils.normalizeText(dto.getDescripcion());

            if (itemMantencionRepository.existsByDescripcionIgnoreCaseAndIdNot(descripcionNormalizada, id)) {
                throw new DuplicateResourceException("ItemMantencion", "descripcion", dto.getDescripcion());
            }

            itemMantencion.setDescripcion(descripcionNormalizada);
        }

        if (dto.getOrdenGantt() != null) {
            itemMantencion.setOrdenGantt(dto.getOrdenGantt());
        }

        return itemMantencionRepository.save(itemMantencion);
    }

    @Transactional
    public DeleteItemMantencionResponseDto delete(Integer id) {
        ItemMantencion itemMantencion = itemMantencionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemMantencion", "id", id));

        itemMantencionRepository.delete(itemMantencion);
        return new DeleteItemMantencionResponseDto(
                itemMantencion.getId(),
                itemMantencion.getDescripcion(),
                "Ítem de mantención eliminado exitosamente"
        );
    }
}
