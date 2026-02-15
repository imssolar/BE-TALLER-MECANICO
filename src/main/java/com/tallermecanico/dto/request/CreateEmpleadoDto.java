package com.tallermecanico.dto.request;

import com.tallermecanico.enums.CargoEmpleado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class CreateEmpleadoDto {

    @NotBlank(message = "El RUT es requerido")
    @Size(max = 12, message = "El RUT no puede exceder 12 caracteres")
    @Pattern(regexp = "^[0-9]+-[0-9kK]$", message = "Formato de RUT inválido (ejemplo: 12345678-9)")
    private String rut;

    @NotBlank(message = "Los nombres son requeridos")
    @Size(max = 30, message = "Los nombres no pueden exceder 30 caracteres")
    private String nombres;

    @NotBlank(message = "El apellido paterno es requerido")
    @Size(max = 20, message = "El apellido paterno no puede exceder 20 caracteres")
    private String apellidoPaterno;

    @NotBlank(message = "El apellido materno es requerido")
    @Size(max = 20, message = "El apellido materno no puede exceder 20 caracteres")
    private String apellidoMaterno;

    @NotNull(message = "El cargo es requerido")
    private CargoEmpleado cargo;

    @Size(max = 15, message = "El teléfono no puede exceder 15 caracteres")
    @Pattern(regexp = "^(\\+?56)?[2-9]\\d{8}$",
             message = "Formato de teléfono inválido (ejemplo: +56912345678 o 912345678)")
    private String telefono;

    @NotNull(message = "La fecha de ingreso es requerida")
    private LocalDate fechaIngreso;

    private Boolean activo = true;

    @Size(max = 10, message = "La licencia de conducir no puede exceder 10 caracteres")
    private String licenciaConducir;

    private LocalDate fechaVencimientoLicencia;

    // Constructors
    public CreateEmpleadoDto() {
    }

    // Getters and Setters
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
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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
}
