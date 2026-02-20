package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateHojaVidaEmpleadoDto;
import com.tallermecanico.dto.request.UpdateHojaVidaEmpleadoDto;
import com.tallermecanico.dto.response.DeleteHojaVidaEmpleadoResponseDto;
import com.tallermecanico.entity.Empleado;
import com.tallermecanico.entity.HojaVidaEmpleado;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.EmpleadoRepository;
import com.tallermecanico.repository.HojaVidaEmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HojaVidaEmpleadoService {

    private final HojaVidaEmpleadoRepository hojaVidaEmpleadoRepository;
    private final EmpleadoRepository empleadoRepository;

    public HojaVidaEmpleadoService(HojaVidaEmpleadoRepository hojaVidaEmpleadoRepository,
                                    EmpleadoRepository empleadoRepository) {
        this.hojaVidaEmpleadoRepository = hojaVidaEmpleadoRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public HojaVidaEmpleado create(CreateHojaVidaEmpleadoDto dto) {
        HojaVidaEmpleado hojaVida = new HojaVidaEmpleado();
        hojaVida.setObservacion(dto.getObservacion());
        hojaVida.setFecha(dto.getFecha());
        hojaVida.setHora(dto.getHora());
        hojaVida.setComentario(dto.getComentario());

        if (dto.getIdEmpleado() != null) {
            Empleado empleado = empleadoRepository.findById(dto.getIdEmpleado())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleado()));
            hojaVida.setEmpleado(empleado);
        }

        return hojaVidaEmpleadoRepository.save(hojaVida);
    }

    @Transactional(readOnly = true)
    public List<HojaVidaEmpleado> findAll() {
        return hojaVidaEmpleadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public HojaVidaEmpleado findById(Integer id) {
        return hojaVidaEmpleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HojaVidaEmpleado", "id", id));
    }

    @Transactional
    public HojaVidaEmpleado update(Integer id, UpdateHojaVidaEmpleadoDto dto) {
        HojaVidaEmpleado hojaVida = hojaVidaEmpleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HojaVidaEmpleado", "id", id));

        if (dto.getObservacion() != null) {
            hojaVida.setObservacion(dto.getObservacion());
        }
        if (dto.getFecha() != null) {
            hojaVida.setFecha(dto.getFecha());
        }
        if (dto.getHora() != null) {
            hojaVida.setHora(dto.getHora());
        }
        if (dto.getComentario() != null) {
            hojaVida.setComentario(dto.getComentario());
        }
        if (dto.getIdEmpleado() != null) {
            Empleado empleado = empleadoRepository.findById(dto.getIdEmpleado())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleado()));
            hojaVida.setEmpleado(empleado);
        }

        return hojaVidaEmpleadoRepository.save(hojaVida);
    }

    @Transactional
    public DeleteHojaVidaEmpleadoResponseDto delete(Integer id) {
        HojaVidaEmpleado hojaVida = hojaVidaEmpleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HojaVidaEmpleado", "id", id));

        hojaVidaEmpleadoRepository.delete(hojaVida);
        return new DeleteHojaVidaEmpleadoResponseDto(
                hojaVida.getId(),
                "Registro de hoja de vida eliminado exitosamente"
        );
    }
}
