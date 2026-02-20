package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateEvaluacionEmpleadoDto;
import com.tallermecanico.dto.request.UpdateEvaluacionEmpleadoDto;
import com.tallermecanico.dto.response.DeleteEvaluacionEmpleadoResponseDto;
import com.tallermecanico.entity.Empleado;
import com.tallermecanico.entity.EvaluacionEmpleado;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.EmpleadoRepository;
import com.tallermecanico.repository.EvaluacionEmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EvaluacionEmpleadoService {

    private final EvaluacionEmpleadoRepository evaluacionEmpleadoRepository;
    private final EmpleadoRepository empleadoRepository;

    public EvaluacionEmpleadoService(EvaluacionEmpleadoRepository evaluacionEmpleadoRepository,
                                     EmpleadoRepository empleadoRepository) {
        this.evaluacionEmpleadoRepository = evaluacionEmpleadoRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public EvaluacionEmpleado create(CreateEvaluacionEmpleadoDto dto) {
        EvaluacionEmpleado evaluacion = new EvaluacionEmpleado();
        evaluacion.setFecha(dto.getFecha());
        evaluacion.setAnio(dto.getAnio());
        evaluacion.setCargo(dto.getCargo());

        if (dto.getIdEmpleado() != null) {
            Empleado empleado = empleadoRepository.findById(dto.getIdEmpleado())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleado()));
            evaluacion.setEmpleado(empleado);
        }

        return evaluacionEmpleadoRepository.save(evaluacion);
    }

    @Transactional(readOnly = true)
    public List<EvaluacionEmpleado> findAll() {
        return evaluacionEmpleadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public EvaluacionEmpleado findById(Integer id) {
        return evaluacionEmpleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EvaluacionEmpleado", "id", id));
    }

    @Transactional
    public EvaluacionEmpleado update(Integer id, UpdateEvaluacionEmpleadoDto dto) {
        EvaluacionEmpleado evaluacion = evaluacionEmpleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EvaluacionEmpleado", "id", id));

        if (dto.getFecha() != null) {
            evaluacion.setFecha(dto.getFecha());
        }
        if (dto.getAnio() != null) {
            evaluacion.setAnio(dto.getAnio());
        }
        if (dto.getCargo() != null) {
            evaluacion.setCargo(dto.getCargo());
        }
        if (dto.getIdEmpleado() != null) {
            Empleado empleado = empleadoRepository.findById(dto.getIdEmpleado())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleado()));
            evaluacion.setEmpleado(empleado);
        }

        return evaluacionEmpleadoRepository.save(evaluacion);
    }

    @Transactional
    public DeleteEvaluacionEmpleadoResponseDto delete(Integer id) {
        EvaluacionEmpleado evaluacion = evaluacionEmpleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EvaluacionEmpleado", "id", id));

        evaluacionEmpleadoRepository.delete(evaluacion);
        return new DeleteEvaluacionEmpleadoResponseDto(
                evaluacion.getId(),
                evaluacion.getAnio(),
                "Evaluación de empleado eliminada exitosamente"
        );
    }
}
