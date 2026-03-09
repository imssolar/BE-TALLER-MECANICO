package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateEmpleadoDto;
import com.tallermecanico.dto.request.UpdateEmpleadoDto;
import com.tallermecanico.dto.response.DeleteEmpleadoResponseDto;
import com.tallermecanico.dto.response.EmpleadoResponseDto;
import com.tallermecanico.entity.*;
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
    private final ComunaService comunaService;
    private final CiudadService ciudadService;
    private final NacionalidadService nacionalidadService;
    private final TipoVisaService tipoVisaService;
    private final TallerService tallerService;

    public EmpleadoService(EmpleadoRepository empleadoRepository,
                           ComunaService comunaService,
                           CiudadService ciudadService,
                           NacionalidadService nacionalidadService,
                           TipoVisaService tipoVisaService,
                           TallerService tallerService) {
        this.empleadoRepository = empleadoRepository;
        this.comunaService = comunaService;
        this.ciudadService = ciudadService;
        this.nacionalidadService = nacionalidadService;
        this.tipoVisaService = tipoVisaService;
        this.tallerService = tallerService;
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

        // Nuevos campos directos
        empleado.setTalla(dto.getTalla());
        empleado.setCalzado(dto.getCalzado());
        empleado.setFechaNacimiento(dto.getFechaNacimiento());
        empleado.setEstadoCivil(dto.getEstadoCivil());
        empleado.setHijos(dto.getHijos());
        empleado.setDireccion(dto.getDireccion());
        empleado.setTelefono2(dto.getTelefono2());
        empleado.setEscolaridad(dto.getEscolaridad());
        empleado.setContactoEmergencia(dto.getContactoEmergencia());
        empleado.setFonoContactoEmergencia(dto.getFonoContactoEmergencia());
        empleado.setParentesco(dto.getParentesco());
        empleado.setExTrabajador(dto.getExTrabajador() != null ? dto.getExTrabajador() : false);
        empleado.setObservaciones(dto.getObservaciones());
        empleado.setCosto(dto.getCosto());

        // Relaciones ManyToOne
        if (dto.getIdComuna() != null) {
            Comuna comuna = comunaService.findById(dto.getIdComuna());
            empleado.setComuna(comuna);
        }
        if (dto.getIdCiudad() != null) {
            Ciudad ciudad = ciudadService.findById(dto.getIdCiudad());
            empleado.setCiudad(ciudad);
        }
        if (dto.getIdNacionalidad() != null) {
            Nacionalidad nacionalidad = nacionalidadService.findById(dto.getIdNacionalidad());
            empleado.setNacionalidad(nacionalidad);
        }
        if (dto.getIdTipoVisa() != null) {
            TipoVisa tipoVisa = tipoVisaService.findById(dto.getIdTipoVisa());
            empleado.setTipoVisa(tipoVisa);
        }
        if (dto.getIdTaller() != null) {
            Taller taller = tallerService.findById(dto.getIdTaller());
            empleado.setTaller(taller);
        }

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

        // Nuevos campos directos
        if (dto.getTalla() != null) {
            empleado.setTalla(dto.getTalla());
        }
        if (dto.getCalzado() != null) {
            empleado.setCalzado(dto.getCalzado());
        }
        if (dto.getFechaNacimiento() != null) {
            empleado.setFechaNacimiento(dto.getFechaNacimiento());
        }
        if (dto.getEstadoCivil() != null) {
            empleado.setEstadoCivil(dto.getEstadoCivil());
        }
        if (dto.getHijos() != null) {
            empleado.setHijos(dto.getHijos());
        }
        if (dto.getDireccion() != null) {
            empleado.setDireccion(dto.getDireccion());
        }
        if (dto.getTelefono2() != null) {
            empleado.setTelefono2(dto.getTelefono2());
        }
        if (dto.getEscolaridad() != null) {
            empleado.setEscolaridad(dto.getEscolaridad());
        }
        if (dto.getContactoEmergencia() != null) {
            empleado.setContactoEmergencia(dto.getContactoEmergencia());
        }
        if (dto.getFonoContactoEmergencia() != null) {
            empleado.setFonoContactoEmergencia(dto.getFonoContactoEmergencia());
        }
        if (dto.getParentesco() != null) {
            empleado.setParentesco(dto.getParentesco());
        }
        if (dto.getExTrabajador() != null) {
            empleado.setExTrabajador(dto.getExTrabajador());
        }
        if (dto.getObservaciones() != null) {
            empleado.setObservaciones(dto.getObservaciones());
        }
        if (dto.getCosto() != null) {
            empleado.setCosto(dto.getCosto());
        }

        // Relaciones ManyToOne
        if (dto.getIdComuna() != null) {
            Comuna comuna = comunaService.findById(dto.getIdComuna());
            empleado.setComuna(comuna);
        }
        if (dto.getIdCiudad() != null) {
            Ciudad ciudad = ciudadService.findById(dto.getIdCiudad());
            empleado.setCiudad(ciudad);
        }
        if (dto.getIdNacionalidad() != null) {
            Nacionalidad nacionalidad = nacionalidadService.findById(dto.getIdNacionalidad());
            empleado.setNacionalidad(nacionalidad);
        }
        if (dto.getIdTipoVisa() != null) {
            TipoVisa tipoVisa = tipoVisaService.findById(dto.getIdTipoVisa());
            empleado.setTipoVisa(tipoVisa);
        }
        if (dto.getIdTaller() != null) {
            Taller taller = tallerService.findById(dto.getIdTaller());
            empleado.setTaller(taller);
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
        EmpleadoResponseDto dto = new EmpleadoResponseDto();
        dto.setId(empleado.getId());
        dto.setRut(empleado.getRut());
        dto.setNombres(empleado.getNombres());
        dto.setApellidoPaterno(empleado.getApellidoPaterno());
        dto.setApellidoMaterno(empleado.getApellidoMaterno());
        dto.setCargo(empleado.getCargo());
        dto.setTelefono(empleado.getTelefono());
        dto.setActivo(empleado.getActivo());
        dto.setFechaIngreso(empleado.getFechaIngreso());
        dto.setLicenciaConducir(empleado.getLicenciaConducir());
        dto.setFechaVencimientoLicencia(empleado.getFechaVencimientoLicencia());

        // Nuevos campos
        dto.setTalla(empleado.getTalla());
        dto.setCalzado(empleado.getCalzado());
        dto.setFechaNacimiento(empleado.getFechaNacimiento());
        dto.setEstadoCivil(empleado.getEstadoCivil());
        dto.setHijos(empleado.getHijos());
        dto.setDireccion(empleado.getDireccion());
        dto.setTelefono2(empleado.getTelefono2());
        dto.setEscolaridad(empleado.getEscolaridad());
        dto.setContactoEmergencia(empleado.getContactoEmergencia());
        dto.setFonoContactoEmergencia(empleado.getFonoContactoEmergencia());
        dto.setParentesco(empleado.getParentesco());
        dto.setExTrabajador(empleado.getExTrabajador());
        dto.setObservaciones(empleado.getObservaciones());
        dto.setCosto(empleado.getCosto());

        // Relaciones - devolver nombre legible
        if (empleado.getComuna() != null) {
            dto.setComuna(empleado.getComuna().getComuna());
        }
        if (empleado.getCiudad() != null) {
            dto.setCiudad(empleado.getCiudad().getCiudad());
        }
        if (empleado.getNacionalidad() != null) {
            dto.setNacionalidad(empleado.getNacionalidad().getNacionalidad());
        }
        if (empleado.getTipoVisa() != null) {
            dto.setTipoVisa(empleado.getTipoVisa().getTipoVisa());
        }
        if (empleado.getTaller() != null) {
            dto.setTaller(empleado.getTaller().getTaller());
        }

        return dto;
    }
}
