package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreatePagoBonosDto;
import com.tallermecanico.dto.request.UpdatePagoBonosDto;
import com.tallermecanico.dto.response.DeletePagoBonosResponseDto;
import com.tallermecanico.entity.PagoBonos;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.PagoBonosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagoBonosService {

    private final PagoBonosRepository pagoBonosRepository;

    public PagoBonosService(PagoBonosRepository pagoBonosRepository) {
        this.pagoBonosRepository = pagoBonosRepository;
    }

    @Transactional
    public PagoBonos create(CreatePagoBonosDto dto) {
        if (pagoBonosRepository.existsByFecha(dto.getFecha())) {
            throw new DuplicateResourceException("PagoBonos", "fecha", dto.getFecha());
        }

        PagoBonos pagoBonos = new PagoBonos();
        pagoBonos.setFecha(dto.getFecha());

        return pagoBonosRepository.save(pagoBonos);
    }

    @Transactional(readOnly = true)
    public List<PagoBonos> findAll() {
        return pagoBonosRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PagoBonos findById(Integer id) {
        return pagoBonosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PagoBonos", "id", id));
    }

    @Transactional
    public PagoBonos update(Integer id, UpdatePagoBonosDto dto) {
        PagoBonos pagoBonos = pagoBonosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PagoBonos", "id", id));

        if (dto.getFecha() != null) {
            if (pagoBonosRepository.existsByFechaAndIdNot(dto.getFecha(), id)) {
                throw new DuplicateResourceException("PagoBonos", "fecha", dto.getFecha());
            }
            pagoBonos.setFecha(dto.getFecha());
        }

        return pagoBonosRepository.save(pagoBonos);
    }

    @Transactional
    public DeletePagoBonosResponseDto delete(Integer id) {
        PagoBonos pagoBonos = pagoBonosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PagoBonos", "id", id));

        pagoBonosRepository.delete(pagoBonos);
        return new DeletePagoBonosResponseDto(
                pagoBonos.getId(),
                pagoBonos.getFecha(),
                "Pago de bonos eliminado exitosamente"
        );
    }
}
