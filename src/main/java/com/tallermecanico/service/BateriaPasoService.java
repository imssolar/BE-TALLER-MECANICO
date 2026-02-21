package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateBateriaPasoDto;
import com.tallermecanico.dto.request.UpdateBateriaPasoDto;
import com.tallermecanico.dto.response.DeleteBateriaPasoResponseDto;
import com.tallermecanico.entity.BateriaPaso;
import com.tallermecanico.entity.BateriaModelo;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.MarcasBateria;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.BateriaPasoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BateriaPasoService {

    private final BateriaPasoRepository bateriaPasoRepository;
    private final BusService busService;
    private final BateriaModeloService bateriaModeloService;
    private final MarcasBateriaService marcasBateriaService;
    private final TerminalService terminalService;

    public BateriaPasoService(BateriaPasoRepository bateriaPasoRepository,
                              BusService busService,
                              BateriaModeloService bateriaModeloService,
                              MarcasBateriaService marcasBateriaService,
                              TerminalService terminalService) {
        this.bateriaPasoRepository = bateriaPasoRepository;
        this.busService = busService;
        this.bateriaModeloService = bateriaModeloService;
        this.marcasBateriaService = marcasBateriaService;
        this.terminalService = terminalService;
    }

    @Transactional
    public BateriaPaso create(CreateBateriaPasoDto dto) {
        BateriaPaso bateriaPaso = new BateriaPaso();

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            bateriaPaso.setBus(bus);
        }

        if (dto.getIdModelo() != null) {
            BateriaModelo modelo = bateriaModeloService.findById(dto.getIdModelo());
            bateriaPaso.setModelo(modelo);
        }

        if (dto.getIdMarca() != null) {
            MarcasBateria marca = marcasBateriaService.findById(dto.getIdMarca());
            bateriaPaso.setMarca(marca);
        }

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            bateriaPaso.setTerminal(terminal);
        }

        bateriaPaso.setFechaCambio(dto.getFechaCambio());
        bateriaPaso.setMarcaFuego(dto.getMarcaFuego());

        return bateriaPasoRepository.save(bateriaPaso);
    }

    @Transactional(readOnly = true)
    public List<BateriaPaso> findAll() {
        return bateriaPasoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<BateriaPaso> findByBus(Integer idBus) {
        return bateriaPasoRepository.findByBus_IdBus(idBus);
    }

    @Transactional(readOnly = true)
    public BateriaPaso findById(Integer id) {
        return bateriaPasoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriaPaso", "id", id));
    }

    @Transactional
    public BateriaPaso update(Integer id, UpdateBateriaPasoDto dto) {
        BateriaPaso bateriaPaso = bateriaPasoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriaPaso", "id", id));

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            bateriaPaso.setBus(bus);
        }

        if (dto.getIdModelo() != null) {
            BateriaModelo modelo = bateriaModeloService.findById(dto.getIdModelo());
            bateriaPaso.setModelo(modelo);
        }

        if (dto.getIdMarca() != null) {
            MarcasBateria marca = marcasBateriaService.findById(dto.getIdMarca());
            bateriaPaso.setMarca(marca);
        }

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            bateriaPaso.setTerminal(terminal);
        }

        if (dto.getFechaCambio() != null) {
            bateriaPaso.setFechaCambio(dto.getFechaCambio());
        }

        if (dto.getMarcaFuego() != null) {
            bateriaPaso.setMarcaFuego(dto.getMarcaFuego());
        }

        return bateriaPasoRepository.save(bateriaPaso);
    }

    @Transactional
    public DeleteBateriaPasoResponseDto delete(Integer id) {
        BateriaPaso bateriaPaso = bateriaPasoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BateriaPaso", "id", id));

        bateriaPasoRepository.delete(bateriaPaso);
        return new DeleteBateriaPasoResponseDto(id, "BateriaPaso eliminado exitosamente");
    }
}
