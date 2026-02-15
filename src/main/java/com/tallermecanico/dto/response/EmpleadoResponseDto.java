package com.tallermecanico.dto.response;

import com.tallermecanico.enums.CargoEmpleado;
import java.time.LocalDate;

public class EmpleadoResponseDto {

    private Integer id;
    private String rut;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombreCompleto;
    private CargoEmpleado cargo;
    private String telefono;
    private Boolean activo;
    private LocalDate fechaIngreso;
    private String licenciaConducir;
    private LocalDate fechaVencimientoLicencia;

    // Constructors
    public EmpleadoResponseDto() {
    }

    public EmpleadoResponseDto(Integer id, String rut, String nombres, String apellidoPaterno,
                              String apellidoMaterno, CargoEmpleado cargo, String telefono,
                              Boolean activo, LocalDate fechaIngreso, String licenciaConducir,
                              LocalDate fechaVencimientoLicencia) {
        this.id = id;
        this.rut = rut;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombreCompleto = nombres + " " + apellidoPaterno + " " + apellidoMaterno;
        this.cargo = cargo;
        this.telefono = telefono;
        this.activo = activo;
        this.fechaIngreso = fechaIngreso;
        this.licenciaConducir = licenciaConducir;
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
        updateNombreCompleto();
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
        updateNombreCompleto();
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
        updateNombreCompleto();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public CargoEmpleado getCargo() {
        return cargo;
    }

    public void setCargo(CargoEmpleado cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getLicenciaConducir() {
        return licenciaConducir;
    }

    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public LocalDate getFechaVencimientoLicencia() {
        return fechaVencimientoLicencia;
    }

    public void setFechaVencimientoLicencia(LocalDate fechaVencimientoLicencia) {
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }

    private void updateNombreCompleto() {
        if (nombres != null && apellidoPaterno != null && apellidoMaterno != null) {
            this.nombreCompleto = nombres + " " + apellidoPaterno + " " + apellidoMaterno;
        }
    }
}
