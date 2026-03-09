package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateItemOTPDto;
import com.tallermecanico.dto.request.UpdateItemOTPDto;
import com.tallermecanico.dto.response.DeleteItemOTPResponseDto;
import com.tallermecanico.entity.ItemOTP;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.ItemOTPRepository;
import com.tallermecanico.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemOTPService {

    private final ItemOTPRepository itemOTPRepository;

    public ItemOTPService(ItemOTPRepository itemOTPRepository) {
        this.itemOTPRepository = itemOTPRepository;
    }

    @Transactional
    public ItemOTP create(CreateItemOTPDto dto) {
        String itemNormalizado = TextUtils.normalizeText(dto.getItem());

        if (itemOTPRepository.existsByItemIgnoreCase(itemNormalizado)) {
            throw new DuplicateResourceException("ItemOTP", "item", dto.getItem());
        }

        ItemOTP itemOTP = new ItemOTP();
        itemOTP.setItem(itemNormalizado);
        itemOTP.setPauta(dto.getPauta());
        itemOTP.setTipo(dto.getTipo());
        itemOTP.setControl(dto.getControl());
        itemOTP.setFormato(dto.getFormato());

        return itemOTPRepository.save(itemOTP);
    }

    @Transactional(readOnly = true)
    public List<ItemOTP> findAll() {
        return itemOTPRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ItemOTP findById(Integer id) {
        return itemOTPRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemOTP", "id", id));
    }

    @Transactional
    public ItemOTP update(Integer id, UpdateItemOTPDto dto) {
        ItemOTP itemOTP = itemOTPRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemOTP", "id", id));

        if (dto.getItem() != null) {
            String itemNormalizado = TextUtils.normalizeText(dto.getItem());

            if (itemOTPRepository.existsByItemIgnoreCaseAndIdNot(itemNormalizado, id)) {
                throw new DuplicateResourceException("ItemOTP", "item", dto.getItem());
            }

            itemOTP.setItem(itemNormalizado);
        }

        if (dto.getPauta() != null) {
            itemOTP.setPauta(dto.getPauta());
        }

        if (dto.getTipo() != null) {
            itemOTP.setTipo(dto.getTipo());
        }

        if (dto.getControl() != null) {
            itemOTP.setControl(dto.getControl());
        }

        if (dto.getFormato() != null) {
            itemOTP.setFormato(dto.getFormato());
        }

        return itemOTPRepository.save(itemOTP);
    }

    @Transactional
    public DeleteItemOTPResponseDto delete(Integer id) {
        ItemOTP itemOTP = itemOTPRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemOTP", "id", id));

        itemOTPRepository.delete(itemOTP);
        return new DeleteItemOTPResponseDto(
                itemOTP.getId(),
                itemOTP.getItem(),
                "Ítem OTP eliminado exitosamente"
        );
    }
}
