package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateItemRRHHDto;
import com.tallermecanico.dto.request.UpdateItemRRHHDto;
import com.tallermecanico.dto.response.DeleteItemRRHHResponseDto;
import com.tallermecanico.entity.ItemRRHH;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ItemRRHHRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemRRHHService {

    private final ItemRRHHRepository itemRRHHRepository;

    public ItemRRHHService(ItemRRHHRepository itemRRHHRepository) {
        this.itemRRHHRepository = itemRRHHRepository;
    }

    @Transactional
    public ItemRRHH create(CreateItemRRHHDto dto) {
        String nombreNormalizado = TextUtils.normalizeText(dto.getItem());

        if (itemRRHHRepository.existsByItemIgnoreCase(nombreNormalizado)) {
            throw new DuplicateResourceException("ItemRRHH", "item", dto.getItem());
        }

        ItemRRHH itemRRHH = new ItemRRHH();
        itemRRHH.setItem(nombreNormalizado);

        return itemRRHHRepository.save(itemRRHH);
    }

    @Transactional(readOnly = true)
    public List<ItemRRHH> findAll() {
        return itemRRHHRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ItemRRHH findById(Integer id) {
        return itemRRHHRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemRRHH", "id", id));
    }

    @Transactional
    public ItemRRHH update(Integer id, UpdateItemRRHHDto dto) {
        ItemRRHH itemRRHH = itemRRHHRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemRRHH", "id", id));

        if (dto.getItem() != null) {
            String nombreNormalizado = TextUtils.normalizeText(dto.getItem());

            if (itemRRHHRepository.existsByItemIgnoreCaseAndIdNot(nombreNormalizado, id)) {
                throw new DuplicateResourceException("ItemRRHH", "item", dto.getItem());
            }

            itemRRHH.setItem(nombreNormalizado);
        }

        return itemRRHHRepository.save(itemRRHH);
    }

    @Transactional
    public DeleteItemRRHHResponseDto delete(Integer id) {
        ItemRRHH itemRRHH = itemRRHHRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemRRHH", "id", id));

        itemRRHHRepository.delete(itemRRHH);
        return new DeleteItemRRHHResponseDto(
                itemRRHH.getId(),
                itemRRHH.getItem(),
                "Ítem RRHH eliminado exitosamente"
        );
    }
}
