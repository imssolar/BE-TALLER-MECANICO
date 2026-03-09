package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateBateriaDto;
import com.tallermecanico.dto.request.UpdateBateriaDto;
import com.tallermecanico.dto.response.DeleteBateriaResponseDto;
import com.tallermecanico.entity.*;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.BateriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BateriaService {

    private final BateriaRepository bateriaRepository;
    private final BusService busService;
    private final BateriasEstadoService bateriasEstadoService;
    private final MarcasBateriaService marcasBateriaService;
    private final BateriaModeloService bateriaModeloService;
    private final TerminalService terminalService;
    private final BateriaMotivoCambioService bateriaMotivoCambioService;

    public BateriaService(BateriaRepository bateriaRepository,
                          BusService busService,
                          BateriasEstadoService bateriasEstadoService,
                          MarcasBateriaService marcasBateriaService,
                          BateriaModeloService bateriaModeloService,
                          TerminalService terminalService,
                          BateriaMotivoCambioService bateriaMotivoCambioService) {
        this.bateriaRepository = bateriaRepository;
        this.busService = busService;
        this.bateriasEstadoService = bateriasEstadoService;
        this.marcasBateriaService = marcasBateriaService;
        this.bateriaModeloService = bateriaModeloService;
        this.terminalService = terminalService;
        this.bateriaMotivoCambioService = bateriaMotivoCambioService;
    }

    @Transactional
    public Bateria create(CreateBateriaDto dto) {
        Bus bus = busService.findById(dto.getIdBus());
        BateriasEstado estado = bateriasEstadoService.findById(dto.getIdEstado());
        MarcasBateria marca = marcasBateriaService.findById(dto.getIdMarca());
        BateriaModelo modelo = bateriaModeloService.findById(dto.getIdModelo());

        Bateria bateria = new Bateria();
        bateria.setBus(bus);
        bateria.setEstado(estado);
        bateria.setMarca(marca);
        bateria.setModelo(modelo);
        bateria.setFechaInstalacion(dto.getFechaInstalacion());
        bateria.setKilometraje(dto.getKilometraje());
        bateria.setPosicion(dto.getPosicion());
        bateria.setCracnKing(dto.getCracnKing());
        bateria.setIdPlanRend(dto.getIdPlanRend());
        bateria.setMarcaFuego(dto.getMarcaFuego());
        bateria.setFechaCambio(dto.getFechaCambio());
        bateria.setKmCambio(dto.getKmCambio());
        bateria.setProyeccion(dto.getProyeccion());
        bateria.setVisor(dto.getVisor());
        bateria.setOhms(dto.getOhms());
        bateria.setCcaSalida(dto.getCcaSalida());
        bateria.setObservacionesBaja(dto.getObservacionesBaja());
        bateria.setActivo(true);

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            bateria.setTerminal(terminal);
        }

        if (dto.getIdMotivoCambio() != null) {
            BateriaMotivoCambio motivoCambio = bateriaMotivoCambioService.findById(dto.getIdMotivoCambio());
            bateria.setMotivoCambio(motivoCambio);
        }

        return bateriaRepository.save(bateria);
    }

    @Transactional(readOnly = true)
    public List<Bateria> findAll() {
        return bateriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Bateria> findActivos() {
        return bateriaRepository.findByActivo(true);
    }

    @Transactional(readOnly = true)
    public List<Bateria> findInactivos() {
        return bateriaRepository.findByActivo(false);
    }

    @Transactional(readOnly = true)
    public List<Bateria> findByBus(Integer idBus) {
        return bateriaRepository.findByBus_IdBusOrderByPosicionAsc(idBus);
    }

    @Transactional(readOnly = true)
    public List<Bateria> findByEstado(Integer idEstado) {
        return bateriaRepository.findByEstado_Id(idEstado);
    }

    @Transactional(readOnly = true)
    public List<Bateria> findByMarca(Integer idMarca) {
        return bateriaRepository.findByMarca_Id(idMarca);
    }

    @Transactional(readOnly = true)
    public Bateria findById(Integer id) {
        return bateriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bateria", "id", id));
    }

    @Transactional
    public Bateria update(Integer id, UpdateBateriaDto dto) {
        Bateria bateria = findById(id);

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            bateria.setBus(bus);
        }
        if (dto.getIdEstado() != null) {
            BateriasEstado estado = bateriasEstadoService.findById(dto.getIdEstado());
            bateria.setEstado(estado);
        }
        if (dto.getIdMarca() != null) {
            MarcasBateria marca = marcasBateriaService.findById(dto.getIdMarca());
            bateria.setMarca(marca);
        }
        if (dto.getIdModelo() != null) {
            BateriaModelo modelo = bateriaModeloService.findById(dto.getIdModelo());
            bateria.setModelo(modelo);
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            bateria.setTerminal(terminal);
        }
        if (dto.getIdMotivoCambio() != null) {
            BateriaMotivoCambio motivoCambio = bateriaMotivoCambioService.findById(dto.getIdMotivoCambio());
            bateria.setMotivoCambio(motivoCambio);
        }
        if (dto.getFechaInstalacion() != null) {
            bateria.setFechaInstalacion(dto.getFechaInstalacion());
        }
        if (dto.getKilometraje() != null) {
            bateria.setKilometraje(dto.getKilometraje());
        }
        if (dto.getPosicion() != null) {
            bateria.setPosicion(dto.getPosicion());
        }
        if (dto.getCracnKing() != null) {
            bateria.setCracnKing(dto.getCracnKing());
        }
        if (dto.getIdPlanRend() != null) {
            bateria.setIdPlanRend(dto.getIdPlanRend());
        }
        if (dto.getMarcaFuego() != null) {
            bateria.setMarcaFuego(dto.getMarcaFuego());
        }
        if (dto.getFechaCambio() != null) {
            bateria.setFechaCambio(dto.getFechaCambio());
        }
        if (dto.getKmCambio() != null) {
            bateria.setKmCambio(dto.getKmCambio());
        }
        if (dto.getProyeccion() != null) {
            bateria.setProyeccion(dto.getProyeccion());
        }
        if (dto.getVisor() != null) {
            bateria.setVisor(dto.getVisor());
        }
        if (dto.getOhms() != null) {
            bateria.setOhms(dto.getOhms());
        }
        if (dto.getCcaSalida() != null) {
            bateria.setCcaSalida(dto.getCcaSalida());
        }
        if (dto.getObservacionesBaja() != null) {
            bateria.setObservacionesBaja(dto.getObservacionesBaja());
        }

        return bateriaRepository.save(bateria);
    }

    @Transactional
    public Bateria desactivar(Integer id) {
        Bateria bateria = findById(id);
        bateria.setActivo(false);
        return bateriaRepository.save(bateria);
    }

    @Transactional
    public Bateria activar(Integer id) {
        Bateria bateria = findById(id);
        bateria.setActivo(true);
        return bateriaRepository.save(bateria);
    }

    @Transactional
    public DeleteBateriaResponseDto delete(Integer id) {
        Bateria bateria = findById(id);
        bateriaRepository.delete(bateria);
        return new DeleteBateriaResponseDto(bateria.getId(),
                String.format("Bateria con ID %d eliminada correctamente", id));
    }
}
