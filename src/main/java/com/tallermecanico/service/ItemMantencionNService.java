package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateItemMantencionNDto;
import com.tallermecanico.dto.request.UpdateItemMantencionNDto;
import com.tallermecanico.dto.response.DeleteItemMantencionNResponseDto;
import com.tallermecanico.entity.ItemMantencionN;
import com.tallermecanico.entity.Modelo;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ItemMantencionNRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemMantencionNService {

    private final ItemMantencionNRepository itemMantencionNRepository;
    private final ModeloService modeloService;

    public ItemMantencionNService(ItemMantencionNRepository itemMantencionNRepository,
                                  ModeloService modeloService) {
        this.itemMantencionNRepository = itemMantencionNRepository;
        this.modeloService = modeloService;
    }

    @Transactional
    public ItemMantencionN create(CreateItemMantencionNDto dto) {
        String descripcionNormalizada = TextUtils.normalizeText(dto.getDescripcion());

        Modelo modelo = null;
        if (dto.getIdModelo() != null) {
            modelo = modeloService.findById(dto.getIdModelo());
        }

        // Check duplicate (descripcion + modelo combo)
        if (modelo != null) {
            if (itemMantencionNRepository.existsByDescripcionIgnoreCaseAndModelo(descripcionNormalizada, modelo)) {
                throw new DuplicateResourceException("ItemMantencionN", "descripcion", descripcionNormalizada);
            }
        } else {
            if (itemMantencionNRepository.existsByDescripcionIgnoreCaseAndModeloIsNull(descripcionNormalizada)) {
                throw new DuplicateResourceException("ItemMantencionN", "descripcion", descripcionNormalizada);
            }
        }

        ItemMantencionN item = new ItemMantencionN();
        item.setDescripcion(descripcionNormalizada);
        item.setModelo(modelo);
        item.setPeriodo(dto.getPeriodo());

        return itemMantencionNRepository.save(item);
    }

    @Transactional(readOnly = true)
    public List<ItemMantencionN> findAll() {
        return itemMantencionNRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ItemMantencionN findById(Integer id) {
        return itemMantencionNRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemMantencionN", "id", id));
    }

    @Transactional
    public ItemMantencionN update(Integer id, UpdateItemMantencionNDto dto) {
        ItemMantencionN item = itemMantencionNRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemMantencionN", "id", id));

        if (dto.getIdModelo() != null) {
            Modelo modelo = modeloService.findById(dto.getIdModelo());
            item.setModelo(modelo);
        }

        if (dto.getDescripcion() != null) {
            String descripcionNormalizada = TextUtils.normalizeText(dto.getDescripcion());

            // Check duplicate with current modelo (could have been updated above)
            Modelo modeloActual = item.getModelo();
            if (modeloActual != null) {
                if (itemMantencionNRepository.existsByDescripcionIgnoreCaseAndModeloAndIdNot(
                        descripcionNormalizada, modeloActual, id)) {
                    throw new DuplicateResourceException("ItemMantencionN", "descripcion", descripcionNormalizada);
                }
            } else {
                if (itemMantencionNRepository.existsByDescripcionIgnoreCaseAndModeloIsNullAndIdNot(
                        descripcionNormalizada, id)) {
                    throw new DuplicateResourceException("ItemMantencionN", "descripcion", descripcionNormalizada);
                }
            }

            item.setDescripcion(descripcionNormalizada);
        }

        if (dto.getPeriodo() != null) {
            item.setPeriodo(dto.getPeriodo());
        }

        return itemMantencionNRepository.save(item);
    }

    @Transactional
    public DeleteItemMantencionNResponseDto delete(Integer id) {
        ItemMantencionN item = itemMantencionNRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemMantencionN", "id", id));

        itemMantencionNRepository.delete(item);
        return new DeleteItemMantencionNResponseDto(
                item.getId(),
                item.getDescripcion(),
                "Ítem de mantención eliminado exitosamente"
        );
    }
}
