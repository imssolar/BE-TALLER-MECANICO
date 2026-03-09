package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateBusTallerCarDto;
import com.tallermecanico.dto.request.UpdateBusTallerCarDto;
import com.tallermecanico.dto.response.DeleteBusTallerCarResponseDto;
import com.tallermecanico.entity.BusTallerCar;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.BusTallerCarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusTallerCarService {

    private final BusTallerCarRepository busTallerCarRepository;
    private final TerminalService terminalService;

    public BusTallerCarService(BusTallerCarRepository busTallerCarRepository,
                               TerminalService terminalService) {
        this.busTallerCarRepository = busTallerCarRepository;
        this.terminalService = terminalService;
    }

    @Transactional
    public BusTallerCar create(CreateBusTallerCarDto dto) {
        // Validar que no exista un bus con el mismo ID
        if (busTallerCarRepository.existsById(dto.getIdBus())) {
            throw new DuplicateResourceException("BusTallerCar", "idBus", dto.getIdBus());
        }

        BusTallerCar bus = new BusTallerCar();
        bus.setIdBus(dto.getIdBus());
        bus.setPatenteB(dto.getPatenteB());
        bus.setMarcaB(dto.getMarcaB());
        bus.setMotorB(dto.getMotorB());
        bus.setModeloB(dto.getModeloB());
        bus.setAnioFabB(dto.getAnioFabB());
        bus.setTransmisionB(dto.getTransmisionB());
        bus.setOperativaB(dto.getOperativaB());
        bus.setKmB(dto.getKmB());
        bus.setZonaB(dto.getZonaB());
        bus.setNroNeumaticosB(dto.getNroNeumaticosB());
        bus.setActivoB(dto.getActivoB());
        bus.setFEmergenciaB(dto.getFEmergenciaB());
        bus.setHEmergenciaB(dto.getHEmergenciaB());
        bus.setObsEmergenciaB(dto.getObsEmergenciaB());
        bus.setAbastecimientoB(dto.getAbastecimientoB());
        bus.setMantencionB(dto.getMantencionB());
        bus.setOperacionB(dto.getOperacionB());
        bus.setNoControladaB(dto.getNoControladaB());
        bus.setOperativaPatio(dto.getOperativaPatio());
        bus.setProyRep(dto.getProyRep());
        bus.setNroBaterias(dto.getNroBaterias());

        // Validar y asignar terminal si se proporciona
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            bus.setTerminal(terminal);
        }

        return busTallerCarRepository.save(bus);
    }

    @Transactional(readOnly = true)
    public List<BusTallerCar> findAll() {
        return busTallerCarRepository.findAll();
    }

    @Transactional(readOnly = true)
    public BusTallerCar findById(Integer idBus) {
        return busTallerCarRepository.findById(idBus)
                .orElseThrow(() -> new ResourceNotFoundException("BusTallerCar", "idBus", idBus));
    }

    @Transactional(readOnly = true)
    public List<BusTallerCar> findByTerminal(Integer idTerminal) {
        return busTallerCarRepository.findByTerminal_IdTerminal(idTerminal);
    }

    @Transactional
    public BusTallerCar update(Integer idBus, UpdateBusTallerCarDto dto) {
        BusTallerCar bus = findById(idBus);

        if (dto.getPatenteB() != null) {
            bus.setPatenteB(dto.getPatenteB());
        }
        if (dto.getMarcaB() != null) {
            bus.setMarcaB(dto.getMarcaB());
        }
        if (dto.getMotorB() != null) {
            bus.setMotorB(dto.getMotorB());
        }
        if (dto.getModeloB() != null) {
            bus.setModeloB(dto.getModeloB());
        }
        if (dto.getAnioFabB() != null) {
            bus.setAnioFabB(dto.getAnioFabB());
        }
        if (dto.getTransmisionB() != null) {
            bus.setTransmisionB(dto.getTransmisionB());
        }
        if (dto.getOperativaB() != null) {
            bus.setOperativaB(dto.getOperativaB());
        }
        if (dto.getKmB() != null) {
            bus.setKmB(dto.getKmB());
        }
        if (dto.getZonaB() != null) {
            bus.setZonaB(dto.getZonaB());
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            bus.setTerminal(terminal);
        }
        if (dto.getNroNeumaticosB() != null) {
            bus.setNroNeumaticosB(dto.getNroNeumaticosB());
        }
        if (dto.getActivoB() != null) {
            bus.setActivoB(dto.getActivoB());
        }
        if (dto.getFEmergenciaB() != null) {
            bus.setFEmergenciaB(dto.getFEmergenciaB());
        }
        if (dto.getHEmergenciaB() != null) {
            bus.setHEmergenciaB(dto.getHEmergenciaB());
        }
        if (dto.getObsEmergenciaB() != null) {
            bus.setObsEmergenciaB(dto.getObsEmergenciaB());
        }
        if (dto.getAbastecimientoB() != null) {
            bus.setAbastecimientoB(dto.getAbastecimientoB());
        }
        if (dto.getMantencionB() != null) {
            bus.setMantencionB(dto.getMantencionB());
        }
        if (dto.getOperacionB() != null) {
            bus.setOperacionB(dto.getOperacionB());
        }
        if (dto.getNoControladaB() != null) {
            bus.setNoControladaB(dto.getNoControladaB());
        }
        if (dto.getOperativaPatio() != null) {
            bus.setOperativaPatio(dto.getOperativaPatio());
        }
        if (dto.getProyRep() != null) {
            bus.setProyRep(dto.getProyRep());
        }
        if (dto.getNroBaterias() != null) {
            bus.setNroBaterias(dto.getNroBaterias());
        }

        return busTallerCarRepository.save(bus);
    }

    @Transactional
    public DeleteBusTallerCarResponseDto delete(Integer idBus) {
        BusTallerCar bus = findById(idBus);
        busTallerCarRepository.delete(bus);
        return new DeleteBusTallerCarResponseDto(idBus);
    }
}
