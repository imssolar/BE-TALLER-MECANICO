package com.tallermecanico.dto.request;

import com.tallermecanico.enums.CargoEmpleado;
import com.tallermecanico.enums.Escolaridad;
import com.tallermecanico.enums.EstadoCivil;
import com.tallermecanico.enums.Parentesco;
import com.tallermecanico.enums.LicenciaConducir;
import com.tallermecanico.enums.Talla;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdateEmpleadoDto {

    @Size(max = 12, message = "El RUT no puede exceder 12 caracteres")
    @Pattern(regexp = "^[0-9]+-[0-9kK]$", message = "Formato de RUT inválido (ejemplo: 12345678-9)")
    private String rut;

    @Size(max = 30, message = "Los nombres no pueden exceder 30 caracteres")
    private String nombres;

    @Size(max = 20, message = "El apellido paterno no puede exceder 20 caracteres")
    private String apellidoPaterno;

    @Size(max = 20, message = "El apellido materno no puede exceder 20 caracteres")
    private String apellidoMaterno;

    private CargoEmpleado cargo;

    @Size(max = 15, message = "El teléfono no puede exceder 15 caracteres")
    @Pattern(regexp = "^(\\+?56)?[2-9]\\d{8}$",
             message = "Formato de teléfono inválido (ejemplo: +56912345678 o 912345678)")
    private String telefono;

    private LocalDate fechaIngreso;

    private Boolean activo;

    private LicenciaConducir licenciaConducir;

    private LocalDate fechaVencimientoLicencia;

    // --- Nuevos campos ---

    private Talla talla;

    @Min(value = 0, message = "El calzado debe ser mayor o igual a 0")
    private Short calzado;

    private LocalDate fechaNacimiento;

    private EstadoCivil estadoCivil;

    @Min(value = 0, message = "El número de hijos debe ser mayor o igual a 0")
    private Short hijos;

    @Size(max = 50, message = "La dirección no puede exceder 50 caracteres")
    private String direccion;

    private Integer idComuna;

    private Integer idCiudad;

    @Size(max = 15, message = "El teléfono 2 no puede exceder 15 caracteres")
    private String telefono2;

    private Escolaridad escolaridad;

    private Integer idNacionalidad;

    private Integer idTipoVisa;

    @Size(max = 30, message = "El contacto de emergencia no puede exceder 30 caracteres")
    private String contactoEmergencia;

    @Size(max = 15, message = "El teléfono de contacto de emergencia no puede exceder 15 caracteres")
    private String fonoContactoEmergencia;

    private Parentesco parentesco;

    private Boolean exTrabajador;

    @Size(max = 500, message = "Las observaciones no pueden exceder 500 caracteres")
    private String observaciones;

    @DecimalMin(value = "0", message = "El costo debe ser mayor o igual a 0")
    private BigDecimal costo;

    private Integer idTaller;

    // Constructors
    public UpdateEmpleadoDto() {
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

    public LicenciaConducir getLicenciaConducir() {
        return licenciaConducir;
    }

    public void setLicenciaConducir(LicenciaConducir licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public LocalDate getFechaVencimientoLicencia() {
        return fechaVencimientoLicencia;
    }

    public void setFechaVencimientoLicencia(LocalDate fechaVencimientoLicencia) {
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Short getCalzado() {
        return calzado;
    }

    public void setCalzado(Short calzado) {
        this.calzado = calzado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Short getHijos() {
        return hijos;
    }

    public void setHijos(Short hijos) {
        this.hijos = hijos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Escolaridad getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(Escolaridad escolaridad) {
        this.escolaridad = escolaridad;
    }

    public Integer getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(Integer idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public Integer getIdTipoVisa() {
        return idTipoVisa;
    }

    public void setIdTipoVisa(Integer idTipoVisa) {
        this.idTipoVisa = idTipoVisa;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getFonoContactoEmergencia() {
        return fonoContactoEmergencia;
    }

    public void setFonoContactoEmergencia(String fonoContactoEmergencia) {
        this.fonoContactoEmergencia = fonoContactoEmergencia;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public Boolean getExTrabajador() {
        return exTrabajador;
    }

    public void setExTrabajador(Boolean exTrabajador) {
        this.exTrabajador = exTrabajador;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Integer getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(Integer idTaller) {
        this.idTaller = idTaller;
    }
}
