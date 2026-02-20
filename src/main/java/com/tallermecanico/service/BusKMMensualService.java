package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateBusKMMensualDto;
import com.tallermecanico.dto.request.UpdateBusKMMensualDto;
import com.tallermecanico.dto.response.DeleteBusKMMensualResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.BusKMMensual;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.BusKMMensualRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusKMMensualService {

    private final BusKMMensualRepository busKMMensualRepository;
    private final BusService busService;

    public BusKMMensualService(BusKMMensualRepository busKMMensualRepository,
                               BusService busService) {
        this.busKMMensualRepository = busKMMensualRepository;
        this.busService = busService;
    }

    @Transactional
    public BusKMMensual create(CreateBusKMMensualDto dto) {
        Bus bus = busService.findById(dto.getIdBus());

        if (busKMMensualRepository.existsByBusAndMesAndAno(bus, dto.getMes(), dto.getAno())) {
            throw new DuplicateResourceException("Ya existe un registro de KM mensual para este bus en el mes y año indicados");
        }

        BusKMMensual busKMMensual = new BusKMMensual();
        busKMMensual.setBus(bus);
        busKMMensual.setPatente(dto.getPatente());
        busKMMensual.setKm(dto.getKm());
        busKMMensual.setLitros(dto.getLitros());
        busKMMensual.setMes(dto.getMes());
        busKMMensual.setAno(dto.getAno());

        return busKMMensualRepository.save(busKMMensual);
    }

    @Transactional(readOnly = true)
    public List<BusKMMensual> findAll() {
        return busKMMensualRepository.findAll();
    }

    @Transactional(readOnly = true)
    public BusKMMensual findById(Integer id) {
        return busKMMensualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BusKMMensual", "id", id));
    }

    @Transactional
    public BusKMMensual update(Integer id, UpdateBusKMMensualDto dto) {
        BusKMMensual busKMMensual = busKMMensualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BusKMMensual", "id", id));

        Bus bus = busKMMensual.getBus();
        Integer mes = busKMMensual.getMes();
        Integer ano = busKMMensual.getAno();

        if (dto.getIdBus() != null) {
            bus = busService.findById(dto.getIdBus());
        }
        if (dto.getMes() != null) {
            mes = dto.getMes();
        }
        if (dto.getAno() != null) {
            ano = dto.getAno();
        }

        if (busKMMensualRepository.existsByBusAndMesAndAnoAndIdNot(bus, mes, ano, id)) {
            throw new DuplicateResourceException("Ya existe un registro de KM mensual para este bus en el mes y año indicados");
        }

        if (dto.getIdBus() != null) {
            busKMMensual.setBus(bus);
        }
        if (dto.getPatente() != null) {
            busKMMensual.setPatente(dto.getPatente());
        }
        if (dto.getKm() != null) {
            busKMMensual.setKm(dto.getKm());
        }
        if (dto.getLitros() != null) {
            busKMMensual.setLitros(dto.getLitros());
        }
        if (dto.getMes() != null) {
            busKMMensual.setMes(dto.getMes());
        }
        if (dto.getAno() != null) {
            busKMMensual.setAno(dto.getAno());
        }

        return busKMMensualRepository.save(busKMMensual);
    }

    @Transactional
    public DeleteBusKMMensualResponseDto delete(Integer id) {
        BusKMMensual busKMMensual = busKMMensualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BusKMMensual", "id", id));

        busKMMensualRepository.delete(busKMMensual);
        return new DeleteBusKMMensualResponseDto(
                busKMMensual.getId(),
                "Registro de KM mensual eliminado exitosamente"
        );
    }
}
