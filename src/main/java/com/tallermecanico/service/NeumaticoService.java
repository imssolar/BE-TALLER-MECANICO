package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateNeumaticoDto;
import com.tallermecanico.dto.request.UpdateNeumaticoDto;
import com.tallermecanico.dto.response.DeleteNeumaticoResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.EstadosNeumatico;
import com.tallermecanico.entity.MarcasNeumatico;
import com.tallermecanico.entity.ModelosNeumatico;
import com.tallermecanico.entity.Neumatico;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.NeumaticoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NeumaticoService {

    private final NeumaticoRepository neumaticoRepository;
    private final BusService busService;
    private final EstadosNeumaticoService estadosNeumaticoService;
    private final MarcasNeumaticoService marcasNeumaticoService;
    private final ModelosNeumaticoService modelosNeumaticoService;

    public NeumaticoService(NeumaticoRepository neumaticoRepository,
                           BusService busService,
                           EstadosNeumaticoService estadosNeumaticoService,
                           MarcasNeumaticoService marcasNeumaticoService,
                           ModelosNeumaticoService modelosNeumaticoService) {
        this.neumaticoRepository = neumaticoRepository;
        this.busService = busService;
        this.estadosNeumaticoService = estadosNeumaticoService;
        this.marcasNeumaticoService = marcasNeumaticoService;
        this.modelosNeumaticoService = modelosNeumaticoService;
    }

    @Transactional
    public Neumatico create(CreateNeumaticoDto dto) {
        // Validar que existan bus, estado, marca y modelo
        Bus bus = busService.findById(dto.getIdBus());
        EstadosNeumatico estado = estadosNeumaticoService.findById(dto.getIdEstado());
        MarcasNeumatico marca = marcasNeumaticoService.findById(dto.getIdMarca());
        ModelosNeumatico modelo = modelosNeumaticoService.findById(dto.getIdModelo());

        Neumatico neumatico = new Neumatico();
        neumatico.setBus(bus);
        neumatico.setEstado(estado);
        neumatico.setMarca(marca);
        neumatico.setModeloNeumatico(modelo);
        neumatico.setFechaInstalacion(dto.getFechaInstalacion());
        neumatico.setKilometraje(dto.getKilometraje());
        neumatico.setPosicion(dto.getPosicion());
        neumatico.setProfundidad(dto.getProfundidad());
        neumatico.setPresion(dto.getPresion());
        neumatico.setMarcaFuego(dto.getMarcaFuego());
        neumatico.setObservaciones(dto.getObservaciones());
        neumatico.setActivo(true);

        return neumaticoRepository.save(neumatico);
    }

    @Transactional(readOnly = true)
    public List<Neumatico> findAll() {
        return neumaticoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Neumatico> findActivos() {
        return neumaticoRepository.findByActivo(true);
    }

    @Transactional(readOnly = true)
    public List<Neumatico> findInactivos() {
        return neumaticoRepository.findByActivo(false);
    }

    @Transactional(readOnly = true)
    public List<Neumatico> findByBus(Integer idBus) {
        return neumaticoRepository.findByBus_IdBusOrderByPosicionAsc(idBus);
    }

    @Transactional(readOnly = true)
    public List<Neumatico> findByEstado(Integer idEstado) {
        return neumaticoRepository.findByEstado_Id(idEstado);
    }

    @Transactional(readOnly = true)
    public List<Neumatico> findByMarca(Integer idMarca) {
        return neumaticoRepository.findByMarca_Id(idMarca);
    }

    @Transactional(readOnly = true)
    public Neumatico findById(Integer id) {
        return neumaticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Neumatico", "id", id));
    }

    @Transactional
    public Neumatico update(Integer id, UpdateNeumaticoDto dto) {
        Neumatico neumatico = findById(id);

        // Validar y actualizar relaciones si se proporcionan
        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            neumatico.setBus(bus);
        }
        if (dto.getIdEstado() != null) {
            EstadosNeumatico estado = estadosNeumaticoService.findById(dto.getIdEstado());
            neumatico.setEstado(estado);
        }
        if (dto.getIdMarca() != null) {
            MarcasNeumatico marca = marcasNeumaticoService.findById(dto.getIdMarca());
            neumatico.setMarca(marca);
        }
        if (dto.getIdModelo() != null) {
            ModelosNeumatico modelo = modelosNeumaticoService.findById(dto.getIdModelo());
            neumatico.setModeloNeumatico(modelo);
        }

        if (dto.getFechaInstalacion() != null) {
            neumatico.setFechaInstalacion(dto.getFechaInstalacion());
        }
        if (dto.getKilometraje() != null) {
            neumatico.setKilometraje(dto.getKilometraje());
        }
        if (dto.getPosicion() != null) {
            neumatico.setPosicion(dto.getPosicion());
        }
        if (dto.getProfundidad() != null) {
            neumatico.setProfundidad(dto.getProfundidad());
        }
        if (dto.getPresion() != null) {
            neumatico.setPresion(dto.getPresion());
        }
        if (dto.getMarcaFuego() != null) {
            neumatico.setMarcaFuego(dto.getMarcaFuego());
        }
        if (dto.getObservaciones() != null) {
            neumatico.setObservaciones(dto.getObservaciones());
        }

        return neumaticoRepository.save(neumatico);
    }

    @Transactional
    public Neumatico desactivar(Integer id) {
        Neumatico neumatico = findById(id);
        neumatico.setActivo(false);
        return neumaticoRepository.save(neumatico);
    }

    @Transactional
    public Neumatico activar(Integer id) {
        Neumatico neumatico = findById(id);
        neumatico.setActivo(true);
        return neumaticoRepository.save(neumatico);
    }

    @Transactional
    public DeleteNeumaticoResponseDto delete(Integer id) {
        Neumatico neumatico = findById(id);
        neumaticoRepository.delete(neumatico);
        return new DeleteNeumaticoResponseDto(neumatico.getId());
    }
}
