package com.tallermecanico.dto.request;

import com.tallermecanico.enums.CargoEmpleado;
import java.time.LocalDate;

public class CreateEvaluacionEmpleadoDto {

    private LocalDate fecha;

    private Integer anio;

    private Integer idEmpleado;

    private CargoEmpleado cargo;

    // Constructors
    public CreateEvaluacionEmpleadoDto() {
    }

    // Getters and Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public CargoEmpleado getCargo() {
        return cargo;
    }

    public void setCargo(CargoEmpleado cargo) {
        this.cargo = cargo;
    }
}
