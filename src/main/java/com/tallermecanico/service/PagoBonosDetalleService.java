package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreatePagoBonosDetalleDto;
import com.tallermecanico.dto.request.UpdatePagoBonosDetalleDto;
import com.tallermecanico.dto.response.DeletePagoBonosDetalleResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.PagoBonos;
import com.tallermecanico.entity.PagoBonosDetalle;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.PagoBonosDetalleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagoBonosDetalleService {

    private final PagoBonosDetalleRepository pagoBonosDetalleRepository;
    private final PagoBonosService pagoBonosService;
    private final BusService busService;

    public PagoBonosDetalleService(PagoBonosDetalleRepository pagoBonosDetalleRepository,
                                   PagoBonosService pagoBonosService,
                                   BusService busService) {
        this.pagoBonosDetalleRepository = pagoBonosDetalleRepository;
        this.pagoBonosService = pagoBonosService;
        this.busService = busService;
    }

    @Transactional
    public PagoBonosDetalle create(CreatePagoBonosDetalleDto dto) {
        PagoBonosDetalle detalle = new PagoBonosDetalle();

        if (dto.getIdPagoBonos() != null) {
            PagoBonos pagoBonos = pagoBonosService.findById(dto.getIdPagoBonos());
            detalle.setPagoBonos(pagoBonos);
        }
        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            detalle.setBus(bus);
        }

        detalle.setRut(dto.getRut());
        detalle.setNombre(dto.getNombre());
        detalle.setCargo(dto.getCargo());
        detalle.setTerminalNombre(dto.getTerminalNombre());
        detalle.setFecha(dto.getFecha());
        detalle.setHoraInicio(dto.getHoraInicio());
        detalle.setHoraFin(dto.getHoraFin());
        detalle.setMonto(dto.getMonto());
        detalle.setServicio(dto.getServicio());
        detalle.setAutoriza(dto.getAutoriza());
        detalle.setArea(dto.getArea());

        return pagoBonosDetalleRepository.save(detalle);
    }

    @Transactional(readOnly = true)
    public List<PagoBonosDetalle> findAll() {
        return pagoBonosDetalleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PagoBonosDetalle findById(Integer id) {
        return pagoBonosDetalleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PagoBonosDetalle", "id", id));
    }

    @Transactional(readOnly = true)
    public List<PagoBonosDetalle> findByPagoBonos(Integer idPagoBonos) {
        return pagoBonosDetalleRepository.findByPagoBonos_Id(idPagoBonos);
    }

    @Transactional(readOnly = true)
    public List<PagoBonosDetalle> findByBus(Integer idBus) {
        return pagoBonosDetalleRepository.findByBus_IdBus(idBus);
    }

    @Transactional(readOnly = true)
    public List<PagoBonosDetalle> findByRut(String rut) {
        return pagoBonosDetalleRepository.findByRut(rut);
    }

    @Transactional
    public PagoBonosDetalle update(Integer id, UpdatePagoBonosDetalleDto dto) {
        PagoBonosDetalle detalle = findById(id);

        if (dto.getIdPagoBonos() != null) {
            PagoBonos pagoBonos = pagoBonosService.findById(dto.getIdPagoBonos());
            detalle.setPagoBonos(pagoBonos);
        }
        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            detalle.setBus(bus);
        }
        if (dto.getRut() != null) {
            detalle.setRut(dto.getRut());
        }
        if (dto.getNombre() != null) {
            detalle.setNombre(dto.getNombre());
        }
        if (dto.getCargo() != null) {
            detalle.setCargo(dto.getCargo());
        }
        if (dto.getTerminalNombre() != null) {
            detalle.setTerminalNombre(dto.getTerminalNombre());
        }
        if (dto.getFecha() != null) {
            detalle.setFecha(dto.getFecha());
        }
        if (dto.getHoraInicio() != null) {
            detalle.setHoraInicio(dto.getHoraInicio());
        }
        if (dto.getHoraFin() != null) {
            detalle.setHoraFin(dto.getHoraFin());
        }
        if (dto.getMonto() != null) {
            detalle.setMonto(dto.getMonto());
        }
        if (dto.getServicio() != null) {
            detalle.setServicio(dto.getServicio());
        }
        if (dto.getAutoriza() != null) {
            detalle.setAutoriza(dto.getAutoriza());
        }
        if (dto.getArea() != null) {
            detalle.setArea(dto.getArea());
        }

        return pagoBonosDetalleRepository.save(detalle);
    }

    @Transactional
    public DeletePagoBonosDetalleResponseDto delete(Integer id) {
        PagoBonosDetalle detalle = findById(id);
        pagoBonosDetalleRepository.delete(detalle);
        return new DeletePagoBonosDetalleResponseDto(detalle.getId(), "Detalle de pago de bonos eliminado exitosamente");
    }
}
