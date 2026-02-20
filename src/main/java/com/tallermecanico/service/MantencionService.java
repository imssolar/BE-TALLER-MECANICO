package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMantencionDto;
import com.tallermecanico.dto.request.UpdateMantencionDto;
import com.tallermecanico.dto.response.DeleteMantencionResponseDto;
import com.tallermecanico.entity.ItemMantencion;
import com.tallermecanico.entity.Mantencion;
import com.tallermecanico.entity.Modelo;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MantencionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MantencionService {

    private final MantencionRepository mantencionRepository;
    private final ItemMantencionService itemMantencionService;
    private final ModeloService modeloService;

    public MantencionService(MantencionRepository mantencionRepository,
                             ItemMantencionService itemMantencionService,
                             ModeloService modeloService) {
        this.mantencionRepository = mantencionRepository;
        this.itemMantencionService = itemMantencionService;
        this.modeloService = modeloService;
    }

    @Transactional
    public Mantencion create(CreateMantencionDto dto) {
        ItemMantencion itemMantencion = itemMantencionService.findById(dto.getIdItem());
        Modelo modelo = modeloService.findById(dto.getIdModelo());

        if (mantencionRepository.existsByItemMantencionAndModelo(itemMantencion, modelo)) {
            throw new DuplicateResourceException("Mantención ya existe para este ítem y modelo");
        }

        Mantencion mantencion = new Mantencion();
        mantencion.setItemMantencion(itemMantencion);
        mantencion.setModelo(modelo);
        mantencion.setKm(dto.getKm());

        return mantencionRepository.save(mantencion);
    }

    @Transactional(readOnly = true)
    public List<Mantencion> findAll() {
        return mantencionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Mantencion findById(Integer id) {
        return mantencionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mantención", "id", id));
    }

    @Transactional
    public Mantencion update(Integer id, UpdateMantencionDto dto) {
        Mantencion mantencion = mantencionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mantención", "id", id));

        ItemMantencion itemMantencion = mantencion.getItemMantencion();
        Modelo modelo = mantencion.getModelo();

        if (dto.getIdItem() != null) {
            itemMantencion = itemMantencionService.findById(dto.getIdItem());
            mantencion.setItemMantencion(itemMantencion);
        }

        if (dto.getIdModelo() != null) {
            modelo = modeloService.findById(dto.getIdModelo());
            mantencion.setModelo(modelo);
        }

        if (dto.getIdItem() != null || dto.getIdModelo() != null) {
            if (mantencionRepository.existsByItemMantencionAndModeloAndIdNot(itemMantencion, modelo, id)) {
                throw new DuplicateResourceException("Mantención ya existe para este ítem y modelo");
            }
        }

        if (dto.getKm() != null) {
            mantencion.setKm(dto.getKm());
        }

        return mantencionRepository.save(mantencion);
    }

    @Transactional
    public DeleteMantencionResponseDto delete(Integer id) {
        Mantencion mantencion = mantencionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mantención", "id", id));

        mantencionRepository.delete(mantencion);
        return new DeleteMantencionResponseDto(
                mantencion.getId(),
                "Mantención eliminada exitosamente"
        );
    }
}
