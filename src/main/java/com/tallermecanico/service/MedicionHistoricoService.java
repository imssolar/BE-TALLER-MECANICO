package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateMedicionHistoricoDto;
import com.tallermecanico.dto.request.UpdateMedicionHistoricoDto;
import com.tallermecanico.dto.response.DeleteMedicionHistoricoResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.MedicionHistorico;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.MedicionHistoricoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicionHistoricoService {

    private final MedicionHistoricoRepository medicionHistoricoRepository;
    private final BusService busService;

    public MedicionHistoricoService(MedicionHistoricoRepository medicionHistoricoRepository,
                                    BusService busService) {
        this.medicionHistoricoRepository = medicionHistoricoRepository;
        this.busService = busService;
    }

    @Transactional
    public MedicionHistorico create(CreateMedicionHistoricoDto dto) {
        MedicionHistorico medicionHistorico = new MedicionHistorico();

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            medicionHistorico.setBus(bus);
        }

        medicionHistorico.setKm(dto.getKm());
        medicionHistorico.setNroBoucher(dto.getNroBoucher());
        medicionHistorico.setFechaHoraInicio(dto.getFechaHoraInicio());
        medicionHistorico.setFechaHoraFin(dto.getFechaHoraFin());
        medicionHistorico.setTipo(dto.getTipo());
        medicionHistorico.setMarca(dto.getMarca());
        medicionHistorico.setProveedor(dto.getProveedor());
        medicionHistorico.setDescripcion(dto.getDescripcion());
        medicionHistorico.setMedicion(dto.getMedicion());
        medicionHistorico.setObservaciones(dto.getObservaciones());
        medicionHistorico.setResultado(dto.getResultado());

        return medicionHistoricoRepository.save(medicionHistorico);
    }

    @Transactional(readOnly = true)
    public List<MedicionHistorico> findAll() {
        return medicionHistoricoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MedicionHistorico findById(Integer id) {
        return medicionHistoricoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicionHistorico", "id", id));
    }

    @Transactional(readOnly = true)
    public List<MedicionHistorico> findByBus(Integer idBus) {
        return medicionHistoricoRepository.findByBus_IdBus(idBus);
    }

    @Transactional
    public MedicionHistorico update(Integer id, UpdateMedicionHistoricoDto dto) {
        MedicionHistorico medicionHistorico = medicionHistoricoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicionHistorico", "id", id));

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            medicionHistorico.setBus(bus);
        }
        if (dto.getKm() != null) {
            medicionHistorico.setKm(dto.getKm());
        }
        if (dto.getNroBoucher() != null) {
            medicionHistorico.setNroBoucher(dto.getNroBoucher());
        }
        if (dto.getFechaHoraInicio() != null) {
            medicionHistorico.setFechaHoraInicio(dto.getFechaHoraInicio());
        }
        if (dto.getFechaHoraFin() != null) {
            medicionHistorico.setFechaHoraFin(dto.getFechaHoraFin());
        }
        if (dto.getTipo() != null) {
            medicionHistorico.setTipo(dto.getTipo());
        }
        if (dto.getMarca() != null) {
            medicionHistorico.setMarca(dto.getMarca());
        }
        if (dto.getProveedor() != null) {
            medicionHistorico.setProveedor(dto.getProveedor());
        }
        if (dto.getDescripcion() != null) {
            medicionHistorico.setDescripcion(dto.getDescripcion());
        }
        if (dto.getMedicion() != null) {
            medicionHistorico.setMedicion(dto.getMedicion());
        }
        if (dto.getObservaciones() != null) {
            medicionHistorico.setObservaciones(dto.getObservaciones());
        }
        if (dto.getResultado() != null) {
            medicionHistorico.setResultado(dto.getResultado());
        }

        return medicionHistoricoRepository.save(medicionHistorico);
    }

    @Transactional
    public DeleteMedicionHistoricoResponseDto delete(Integer id) {
        MedicionHistorico medicionHistorico = medicionHistoricoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicionHistorico", "id", id));

        medicionHistoricoRepository.delete(medicionHistorico);
        return new DeleteMedicionHistoricoResponseDto(
                medicionHistorico.getId(),
                "Medición histórica eliminada exitosamente"
        );
    }
}
