package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateEmpleadoDto;
import com.tallermecanico.dto.request.UpdateEmpleadoDto;
import com.tallermecanico.dto.response.DeleteEmpleadoResponseDto;
import com.tallermecanico.dto.response.EmpleadoResponseDto;
import com.tallermecanico.entity.Empleado;
import com.tallermecanico.enums.CargoEmpleado;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public EmpleadoResponseDto create(CreateEmpleadoDto dto) {
        // Validar RUT único
        if (empleadoRepository.existsByRut(dto.getRut())) {
            throw new DuplicateResourceException("Empleado", "rut", dto.getRut());
        }

        Empleado empleado = new Empleado();
        empleado.setRut(dto.getRut());
        empleado.setNombres(dto.getNombres());
        empleado.setApellidoPaterno(dto.getApellidoPaterno());
        empleado.setApellidoMaterno(dto.getApellidoMaterno());
        empleado.setCargo(dto.getCargo());
        empleado.setTelefono(dto.getTelefono());
        empleado.setFechaIngreso(dto.getFechaIngreso());
        empleado.setActivo(dto.getActivo() != null ? dto.getActivo() : true);
        empleado.setLicenciaConducir(dto.getLicenciaConducir());
        empleado.setFechaVencimientoLicencia(dto.getFechaVencimientoLicencia());

        Empleado savedEmpleado = empleadoRepository.save(empleado);
        return toResponseDto(savedEmpleado);
    }

    @Transactional(readOnly = true)
    public List<EmpleadoResponseDto> findAll() {
        return empleadoRepository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EmpleadoResponseDto> findByActivo(Boolean activo) {
        return empleadoRepository.findByActivo(activo).stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EmpleadoResponseDto> findConductores() {
        return empleadoRepository.findByCargoAndActivo(CargoEmpleado.CONDUCTOR, true).stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EmpleadoResponseDto> findMecanicos() {
        return empleadoRepository.findByCargoAndActivo(CargoEmpleado.MECANICO, true).stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmpleadoResponseDto findById(Integer id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));
        return toResponseDto(empleado);
    }

    @Transactional(readOnly = true)
    public EmpleadoResponseDto findByRut(String rut) {
        Empleado empleado = empleadoRepository.findByRut(rut)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "rut", rut));
        return toResponseDto(empleado);
    }

    @Transactional
    public EmpleadoResponseDto update(Integer id, UpdateEmpleadoDto dto) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));

        // Validar RUT único (excluyendo el actual)
        if (dto.getRut() != null && empleadoRepository.existsByRutAndIdNot(dto.getRut(), id)) {
            throw new DuplicateResourceException("Empleado", "rut", dto.getRut());
        }

        if (dto.getRut() != null) {
            empleado.setRut(dto.getRut());
        }
        if (dto.getNombres() != null) {
            empleado.setNombres(dto.getNombres());
        }
        if (dto.getApellidoPaterno() != null) {
            empleado.setApellidoPaterno(dto.getApellidoPaterno());
        }
        if (dto.getApellidoMaterno() != null) {
            empleado.setApellidoMaterno(dto.getApellidoMaterno());
        }
        if (dto.getCargo() != null) {
            empleado.setCargo(dto.getCargo());
        }
        if (dto.getTelefono() != null) {
            empleado.setTelefono(dto.getTelefono());
        }
        if (dto.getFechaIngreso() != null) {
            empleado.setFechaIngreso(dto.getFechaIngreso());
        }
        if (dto.getActivo() != null) {
            empleado.setActivo(dto.getActivo());
        }
        if (dto.getLicenciaConducir() != null) {
            empleado.setLicenciaConducir(dto.getLicenciaConducir());
        }
        if (dto.getFechaVencimientoLicencia() != null) {
            empleado.setFechaVencimientoLicencia(dto.getFechaVencimientoLicencia());
        }

        Empleado updatedEmpleado = empleadoRepository.save(empleado);
        return toResponseDto(updatedEmpleado);
    }

    @Transactional
    public EmpleadoResponseDto desactivar(Integer id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));

        empleado.setActivo(false);
        Empleado updatedEmpleado = empleadoRepository.save(empleado);
        return toResponseDto(updatedEmpleado);
    }

    @Transactional
    public EmpleadoResponseDto activar(Integer id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));

        empleado.setActivo(true);
        Empleado updatedEmpleado = empleadoRepository.save(empleado);
        return toResponseDto(updatedEmpleado);
    }

    @Transactional
    public DeleteEmpleadoResponseDto delete(Integer id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));

        empleadoRepository.delete(empleado);
        return new DeleteEmpleadoResponseDto(
            empleado.getId(),
            empleado.getNombreCompleto(),
            empleado.getRut()
        );
    }

    private EmpleadoResponseDto toResponseDto(Empleado empleado) {
        return new EmpleadoResponseDto(
            empleado.getId(),
            empleado.getRut(),
            empleado.getNombres(),
            empleado.getApellidoPaterno(),
            empleado.getApellidoMaterno(),
            empleado.getCargo(),
            empleado.getTelefono(),
            empleado.getActivo(),
            empleado.getFechaIngreso(),
            empleado.getLicenciaConducir(),
            empleado.getFechaVencimientoLicencia()
        );
    }
}
