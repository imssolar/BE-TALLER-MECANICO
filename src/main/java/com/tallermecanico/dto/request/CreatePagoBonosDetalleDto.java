package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class CreatePagoBonosDetalleDto {

    private Integer idPagoBonos;

    @Size(max = 12, message = "El rut no debe exceder los 12 caracteres")
    private String rut;

    @Size(max = 50, message = "El nombre no debe exceder los 50 caracteres")
    private String nombre;

    @Size(max = 50, message = "El cargo no debe exceder los 50 caracteres")
    private String cargo;

    @Size(max = 50, message = "El terminal no debe exceder los 50 caracteres")
    private String terminalNombre;

    private LocalDate fecha;

    @Size(max = 10, message = "La hora de inicio no debe exceder los 10 caracteres")
    private String horaInicio;

    @Size(max = 10, message = "La hora de fin no debe exceder los 10 caracteres")
    private String horaFin;

    private Integer monto;

    @Size(max = 50, message = "El servicio no debe exceder los 50 caracteres")
    private String servicio;

    @Size(max = 50, message = "El autoriza no debe exceder los 50 caracteres")
    private String autoriza;

    @Size(max = 50, message = "El area no debe exceder los 50 caracteres")
    private String area;

    private Integer idBus;

    // Constructors
    public CreatePagoBonosDetalleDto() {
    }

    // Getters and Setters
    public Integer getIdPagoBonos() {
        return idPagoBonos;
    }

    public void setIdPagoBonos(Integer idPagoBonos) {
        this.idPagoBonos = idPagoBonos;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTerminalNombre() {
        return terminalNombre;
    }

    public void setTerminalNombre(String terminalNombre) {
        this.terminalNombre = terminalNombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }
}
