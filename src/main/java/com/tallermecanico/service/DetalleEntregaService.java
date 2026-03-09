package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateDetalleEntregaDto;
import com.tallermecanico.dto.request.UpdateDetalleEntregaDto;
import com.tallermecanico.dto.response.DeleteDetalleEntregaResponseDto;
import com.tallermecanico.entity.DetalleEntrega;
import com.tallermecanico.entity.Empleado;
import com.tallermecanico.entity.Equipamiento;
import com.tallermecanico.entity.Herramienta;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.DetalleEntregaRepository;
import com.tallermecanico.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleEntregaService {

    private final DetalleEntregaRepository detalleEntregaRepository;
    private final EmpleadoRepository empleadoRepository;
    private final EquipamientoService equipamientoService;
    private final HerramientaService herramientaService;

    public DetalleEntregaService(DetalleEntregaRepository detalleEntregaRepository,
                                 EmpleadoRepository empleadoRepository,
                                 EquipamientoService equipamientoService,
                                 HerramientaService herramientaService) {
        this.detalleEntregaRepository = detalleEntregaRepository;
        this.empleadoRepository = empleadoRepository;
        this.equipamientoService = equipamientoService;
        this.herramientaService = herramientaService;
    }

    @Transactional
    public DetalleEntrega create(CreateDetalleEntregaDto dto) {
        DetalleEntrega detalle = new DetalleEntrega();
        detalle.setTipoEntrega(dto.getTipoEntrega());
        detalle.setFechaEntrega(dto.getFechaEntrega());
        detalle.setCantidad(dto.getCantidad());
        detalle.setCosto(dto.getCosto());
        detalle.setDevuelto(dto.getDevuelto());
        detalle.setFechaDevolucion(dto.getFechaDevolucion());
        detalle.setCantidadDevuelta(dto.getCantidadDevuelta());
        detalle.setPendiente(dto.getPendiente());
        detalle.setProximoCambio(dto.getProximoCambio());
        detalle.setTipoDevolucion(dto.getTipoDevolucion());

        if (dto.getIdEmpleado() != null) {
            Empleado empleado = empleadoRepository.findById(dto.getIdEmpleado())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleado()));
            detalle.setEmpleado(empleado);
        }
        if (dto.getIdEntregadoPor() != null) {
            Empleado entregadoPor = empleadoRepository.findById(dto.getIdEntregadoPor())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEntregadoPor()));
            detalle.setEntregadoPor(entregadoPor);
        }
        if (dto.getIdEquipamiento() != null) {
            Equipamiento equipamiento = equipamientoService.findById(dto.getIdEquipamiento());
            detalle.setEquipamiento(equipamiento);
        }
        if (dto.getIdHerramienta() != null) {
            Herramienta herramienta = herramientaService.findById(dto.getIdHerramienta());
            detalle.setHerramienta(herramienta);
        }

        return detalleEntregaRepository.save(detalle);
    }

    @Transactional(readOnly = true)
    public List<DetalleEntrega> findAll() {
        return detalleEntregaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DetalleEntrega findById(Integer id) {
        return detalleEntregaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleEntrega", "id", id));
    }

    @Transactional
    public DetalleEntrega update(Integer id, UpdateDetalleEntregaDto dto) {
        DetalleEntrega detalle = detalleEntregaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleEntrega", "id", id));

        if (dto.getTipoEntrega() != null) {
            detalle.setTipoEntrega(dto.getTipoEntrega());
        }
        if (dto.getFechaEntrega() != null) {
            detalle.setFechaEntrega(dto.getFechaEntrega());
        }
        if (dto.getCantidad() != null) {
            detalle.setCantidad(dto.getCantidad());
        }
        if (dto.getCosto() != null) {
            detalle.setCosto(dto.getCosto());
        }
        if (dto.getDevuelto() != null) {
            detalle.setDevuelto(dto.getDevuelto());
        }
        if (dto.getFechaDevolucion() != null) {
            detalle.setFechaDevolucion(dto.getFechaDevolucion());
        }
        if (dto.getCantidadDevuelta() != null) {
            detalle.setCantidadDevuelta(dto.getCantidadDevuelta());
        }
        if (dto.getPendiente() != null) {
            detalle.setPendiente(dto.getPendiente());
        }
        if (dto.getProximoCambio() != null) {
            detalle.setProximoCambio(dto.getProximoCambio());
        }
        if (dto.getTipoDevolucion() != null) {
            detalle.setTipoDevolucion(dto.getTipoDevolucion());
        }
        if (dto.getIdEmpleado() != null) {
            Empleado empleado = empleadoRepository.findById(dto.getIdEmpleado())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleado()));
            detalle.setEmpleado(empleado);
        }
        if (dto.getIdEntregadoPor() != null) {
            Empleado entregadoPor = empleadoRepository.findById(dto.getIdEntregadoPor())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEntregadoPor()));
            detalle.setEntregadoPor(entregadoPor);
        }
        if (dto.getIdEquipamiento() != null) {
            Equipamiento equipamiento = equipamientoService.findById(dto.getIdEquipamiento());
            detalle.setEquipamiento(equipamiento);
        }
        if (dto.getIdHerramienta() != null) {
            Herramienta herramienta = herramientaService.findById(dto.getIdHerramienta());
            detalle.setHerramienta(herramienta);
        }

        return detalleEntregaRepository.save(detalle);
    }

    @Transactional
    public DeleteDetalleEntregaResponseDto delete(Integer id) {
        DetalleEntrega detalle = detalleEntregaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleEntrega", "id", id));

        detalleEntregaRepository.delete(detalle);
        return new DeleteDetalleEntregaResponseDto(
                detalle.getId(),
                "Detalle de entrega eliminado exitosamente"
        );
    }
}
