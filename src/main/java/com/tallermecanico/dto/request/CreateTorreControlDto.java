package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class CreateTorreControlDto {

    private Integer idBus;

    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer km;

    private LocalDateTime fechaHoraIngreso;

    @Size(max = 50, message = "La falla no debe exceder los 50 caracteres")
    private String falla;

    @Size(max = 50, message = "El tipo de falla no debe exceder los 50 caracteres")
    private String tipoFalla;

    private Long nroOtManager;

    @Size(max = 50, message = "El electrico no debe exceder los 50 caracteres")
    private String electrico;

    private LocalDateTime fechaHoraInicioElectrico;

    private LocalDateTime fechaHoraFinElectrico;

    @Size(max = 50, message = "El mecanico no debe exceder los 50 caracteres")
    private String mecanico;

    private LocalDateTime fechaHoraInicioMecanico;

    private LocalDateTime fechaHoraFinMecanico;

    @Size(max = 20, message = "El status no debe exceder los 20 caracteres")
    private String status;

    @Min(value = 0, message = "El tiempo proyectado no puede ser negativo")
    private Integer tiempoProyectado;

    @Min(value = 0, message = "El tiempo transcurrido no puede ser negativo")
    private Integer tiempoTranscurrido;

    @Size(max = 10, message = "El PNC no debe exceder los 10 caracteres")
    private String pnc;

    @Min(value = 0, message = "El numero de ingresos no puede ser negativo")
    private Integer nroIngresos;

    @Size(max = 50, message = "Las observaciones no deben exceder los 50 caracteres")
    private String observaciones;

    private Boolean cerrado;

    @Size(max = 20, message = "El tipo de emergencia no debe exceder los 20 caracteres")
    private String tipoEmergencia;

    // Constructors
    public CreateTorreControlDto() {
    }

    // Getters and Setters
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }

    public String getTipoFalla() {
        return tipoFalla;
    }

    public void setTipoFalla(String tipoFalla) {
        this.tipoFalla = tipoFalla;
    }

    public Long getNroOtManager() {
        return nroOtManager;
    }

    public void setNroOtManager(Long nroOtManager) {
        this.nroOtManager = nroOtManager;
    }

    public String getElectrico() {
        return electrico;
    }

    public void setElectrico(String electrico) {
        this.electrico = electrico;
    }

    public LocalDateTime getFechaHoraInicioElectrico() {
        return fechaHoraInicioElectrico;
    }

    public void setFechaHoraInicioElectrico(LocalDateTime fechaHoraInicioElectrico) {
        this.fechaHoraInicioElectrico = fechaHoraInicioElectrico;
    }

    public LocalDateTime getFechaHoraFinElectrico() {
        return fechaHoraFinElectrico;
    }

    public void setFechaHoraFinElectrico(LocalDateTime fechaHoraFinElectrico) {
        this.fechaHoraFinElectrico = fechaHoraFinElectrico;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public LocalDateTime getFechaHoraInicioMecanico() {
        return fechaHoraInicioMecanico;
    }

    public void setFechaHoraInicioMecanico(LocalDateTime fechaHoraInicioMecanico) {
        this.fechaHoraInicioMecanico = fechaHoraInicioMecanico;
    }

    public LocalDateTime getFechaHoraFinMecanico() {
        return fechaHoraFinMecanico;
    }

    public void setFechaHoraFinMecanico(LocalDateTime fechaHoraFinMecanico) {
        this.fechaHoraFinMecanico = fechaHoraFinMecanico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTiempoProyectado() {
        return tiempoProyectado;
    }

    public void setTiempoProyectado(Integer tiempoProyectado) {
        this.tiempoProyectado = tiempoProyectado;
    }

    public Integer getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public void setTiempoTranscurrido(Integer tiempoTranscurrido) {
        this.tiempoTranscurrido = tiempoTranscurrido;
    }

    public String getPnc() {
        return pnc;
    }

    public void setPnc(String pnc) {
        this.pnc = pnc;
    }

    public Integer getNroIngresos() {
        return nroIngresos;
    }

    public void setNroIngresos(Integer nroIngresos) {
        this.nroIngresos = nroIngresos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(String tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }
}
