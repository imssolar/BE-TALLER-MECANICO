package com.tallermecanico.dto.response;

import com.tallermecanico.enums.CargoEmpleado;
import com.tallermecanico.enums.Escolaridad;
import com.tallermecanico.enums.EstadoCivil;
import com.tallermecanico.enums.Parentesco;
import com.tallermecanico.enums.Talla;
import java.math.BigDecimal;
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

    // --- Nuevos campos ---
    private Talla talla;
    private Short calzado;
    private LocalDate fechaNacimiento;
    private EstadoCivil estadoCivil;
    private Short hijos;
    private String direccion;
    private String comuna;
    private String ciudad;
    private String telefono2;
    private Escolaridad escolaridad;
    private String nacionalidad;
    private String tipoVisa;
    private String contactoEmergencia;
    private String fonoContactoEmergencia;
    private Parentesco parentesco;
    private Boolean exTrabajador;
    private String observaciones;
    private BigDecimal costo;
    private String taller;

    // Constructors
    public EmpleadoResponseDto() {
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

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTipoVisa() {
        return tipoVisa;
    }

    public void setTipoVisa(String tipoVisa) {
        this.tipoVisa = tipoVisa;
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

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    private void updateNombreCompleto() {
        if (nombres != null && apellidoPaterno != null && apellidoMaterno != null) {
            this.nombreCompleto = nombres + " " + apellidoPaterno + " " + apellidoMaterno;
        }
    }
}
