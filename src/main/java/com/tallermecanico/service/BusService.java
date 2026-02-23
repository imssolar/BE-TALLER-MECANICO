package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateBusDto;
import com.tallermecanico.dto.request.RegistrarEmergenciaDto;
import com.tallermecanico.dto.request.UpdateBusDto;
import com.tallermecanico.dto.request.UpdateEstadoDto;
import com.tallermecanico.dto.request.UpdateKilometrajeDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.Modelo;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.BusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusService {

    private final BusRepository busRepository;
    private final TerminalService terminalService;
    private final ModeloService modeloService;

    public BusService(BusRepository busRepository,
                     TerminalService terminalService,
                     ModeloService modeloService) {
        this.busRepository = busRepository;
        this.terminalService = terminalService;
        this.modeloService = modeloService;
    }

    @Transactional
    public Bus create(CreateBusDto dto) {
        // Validar patente única
        if (dto.getPatenteB() != null && busRepository.existsByPatenteB(dto.getPatenteB())) {
            throw new DuplicateResourceException("Bus", "patente", dto.getPatenteB());
        }

        // Validar que existan terminal y modelo
        Terminal terminal = terminalService.findById(dto.getIdTerminal());
        Modelo modelo = modeloService.findById(dto.getIdModelo());

        Bus bus = new Bus();
        bus.setIdBus(dto.getIdBus());
        bus.setPatenteB(dto.getPatenteB());
        bus.setMarcaB(dto.getMarcaB());
        bus.setMotorB(dto.getMotorB());
        bus.setAnioFabB(dto.getAnioFabB());
        bus.setTransmisionB(dto.getTransmisionB());
        bus.setOperativaB(dto.getOperativaB() != null ? dto.getOperativaB() : false);
        bus.setKmB(dto.getKmB());
        bus.setZonaB(dto.getZonaB());
        bus.setNroNeumaticosB(dto.getNroNeumaticosB());
        bus.setActivoB(dto.getActivoB() != null ? dto.getActivoB() : true);
        bus.setNroBaterias(dto.getNroBaterias());
        bus.setFechaEmergencia(dto.getFechaEmergencia());
        bus.setObsEmergenciaB(dto.getObsEmergenciaB());
        bus.setAbastecimientoB(dto.getAbastecimientoB() != null ? dto.getAbastecimientoB() : false);
        bus.setMantencionB(dto.getMantencionB() != null ? dto.getMantencionB() : false);
        bus.setOperacionB(dto.getOperacionB() != null ? dto.getOperacionB() : false);
        bus.setNoControladaB(dto.getNoControladaB() != null ? dto.getNoControladaB() : false);
        bus.setOperativaPatio(dto.getOperativaPatio() != null ? dto.getOperativaPatio() : false);
        bus.setProyRep(dto.getProyRep());
        bus.setFechaRevisionTecnica(dto.getFechaRevisionTecnica());
        bus.setFechaRevisionGases(dto.getFechaRevisionGases());
        bus.setTerminal(terminal);
        bus.setModelo(modelo);

        return busRepository.save(bus);
    }

    @Transactional(readOnly = true)
    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Bus findById(Integer id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus", "id", id));
    }

    @Transactional(readOnly = true)
    public Bus findByPatente(String patente) {
        return busRepository.findByPatenteB(patente)
                .orElseThrow(() -> new ResourceNotFoundException("Bus", "patente", patente));
    }

    @Transactional(readOnly = true)
    public List<Bus> findOperativos() {
        return busRepository.findByOperativaBAndActivoB(true, true);
    }

    @Transactional(readOnly = true)
    public List<Bus> findInactivos() {
        return busRepository.findByActivoB(false);
    }

    @Transactional(readOnly = true)
    public List<Bus> findEnMantencion() {
        return busRepository.findByMantencionB(true);
    }

    @Transactional(readOnly = true)
    public List<Bus> findByTerminal(Integer idTerminal) {
        return busRepository.findByTerminal_IdTerminal(idTerminal);
    }

    @Transactional(readOnly = true)
    public List<Bus> findByModelo(Integer idModelo) {
        return busRepository.findByModelo_Id(idModelo);
    }

    @Transactional(readOnly = true)
    public Map<String, Object> getEstadisticas() {
        long total = busRepository.count();
        long operativos = busRepository.countOperativos();
        long inactivos = busRepository.countInactivos();
        long enMantencion = busRepository.countEnMantencion();

        // Agrupar por terminal
        List<Bus> buses = busRepository.findAll();
        Map<String, Long> porTerminal = new HashMap<>();
        for (Bus bus : buses) {
            if (bus.getTerminal() != null) {
                String terminalNombre = bus.getTerminal().getTerminal();
                porTerminal.put(terminalNombre, porTerminal.getOrDefault(terminalNombre, 0L) + 1);
            }
        }

        Map<String, Object> estadisticas = new HashMap<>();
        estadisticas.put("total", total);
        estadisticas.put("operativos", operativos);
        estadisticas.put("inactivos", inactivos);
        estadisticas.put("enMantencion", enMantencion);
        estadisticas.put("porTerminal", porTerminal);

        return estadisticas;
    }

    @Transactional
    public Bus update(Integer id, UpdateBusDto dto) {
        Bus bus = findById(id);

        // Validar patente única (excluyendo el actual)
        if (dto.getPatenteB() != null &&
            busRepository.existsByPatenteBAndIdBusNot(dto.getPatenteB(), id)) {
            throw new DuplicateResourceException("Bus", "patente", dto.getPatenteB());
        }

        // Validar terminal y modelo si se proporcionan
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            bus.setTerminal(terminal);
        }
        if (dto.getIdModelo() != null) {
            Modelo modelo = modeloService.findById(dto.getIdModelo());
            bus.setModelo(modelo);
        }

        if (dto.getPatenteB() != null) {
            bus.setPatenteB(dto.getPatenteB());
        }
        if (dto.getMarcaB() != null) {
            bus.setMarcaB(dto.getMarcaB());
        }
        if (dto.getMotorB() != null) {
            bus.setMotorB(dto.getMotorB());
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
        if (dto.getNroNeumaticosB() != null) {
            bus.setNroNeumaticosB(dto.getNroNeumaticosB());
        }
        if (dto.getActivoB() != null) {
            bus.setActivoB(dto.getActivoB());
        }
        if (dto.getNroBaterias() != null) {
            bus.setNroBaterias(dto.getNroBaterias());
        }
        if (dto.getFechaEmergencia() != null) {
            bus.setFechaEmergencia(dto.getFechaEmergencia());
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
        if (dto.getFechaRevisionTecnica() != null) {
            bus.setFechaRevisionTecnica(dto.getFechaRevisionTecnica());
        }
        if (dto.getFechaRevisionGases() != null) {
            bus.setFechaRevisionGases(dto.getFechaRevisionGases());
        }

        return busRepository.save(bus);
    }

    @Transactional
    public Bus updateEstado(Integer id, UpdateEstadoDto dto) {
        Bus bus = findById(id);
        bus.setOperativaB(dto.getOperativaB());
        return busRepository.save(bus);
    }

    @Transactional
    public Bus updateKilometraje(Integer id, UpdateKilometrajeDto dto) {
        Bus bus = findById(id);
        bus.setKmB(dto.getKmB());
        return busRepository.save(bus);
    }

    @Transactional
    public Bus registrarEmergencia(Integer id, RegistrarEmergenciaDto dto) {
        Bus bus = findById(id);
        bus.setFechaEmergencia(dto.getFechaEmergencia());
        bus.setObsEmergenciaB(dto.getObsEmergenciaB());
        return busRepository.save(bus);
    }

    @Transactional
    public void delete(Integer id) {
        Bus bus = findById(id);
        busRepository.delete(bus);
    }
}
