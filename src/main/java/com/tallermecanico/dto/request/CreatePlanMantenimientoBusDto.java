package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreatePlanMantenimientoBusDto {

    private Integer idBus;

    private Integer idMantencion;

    @Size(max = 15, message = "El id de item no debe exceder los 15 caracteres")
    private String idItem;

    private Long periodo;

    private Long kmMantencion;

    private LocalDateTime fechaHoraMantencion;

    private Long kmRealizada;

    private Boolean realizada;

    private Long idOtp;

    @DecimalMin(value = "0.0", message = "Los litros no pueden ser negativos")
    private BigDecimal litros;

    private Boolean accionOk;

    private Long rrhh;

    private Long diasFaltantes;

    private Long diasExtras;

    private LocalDate fechaProxMtto;

    private LocalDate nuevaFechaMtto;

    private LocalDate fechaFinMtto;

    // Constructors
    public CreatePlanMantenimientoBusDto() {
    }

    // Getters and Setters
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public Integer getIdMantencion() {
        return idMantencion;
    }

    public void setIdMantencion(Integer idMantencion) {
        this.idMantencion = idMantencion;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public Long getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Long periodo) {
        this.periodo = periodo;
    }

    public Long getKmMantencion() {
        return kmMantencion;
    }

    public void setKmMantencion(Long kmMantencion) {
        this.kmMantencion = kmMantencion;
    }

    public LocalDateTime getFechaHoraMantencion() {
        return fechaHoraMantencion;
    }

    public void setFechaHoraMantencion(LocalDateTime fechaHoraMantencion) {
        this.fechaHoraMantencion = fechaHoraMantencion;
    }

    public Long getKmRealizada() {
        return kmRealizada;
    }

    public void setKmRealizada(Long kmRealizada) {
        this.kmRealizada = kmRealizada;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    public Long getIdOtp() {
        return idOtp;
    }

    public void setIdOtp(Long idOtp) {
        this.idOtp = idOtp;
    }

    public BigDecimal getLitros() {
        return litros;
    }

    public void setLitros(BigDecimal litros) {
        this.litros = litros;
    }

    public Boolean getAccionOk() {
        return accionOk;
    }

    public void setAccionOk(Boolean accionOk) {
        this.accionOk = accionOk;
    }

    public Long getRrhh() {
        return rrhh;
    }

    public void setRrhh(Long rrhh) {
        this.rrhh = rrhh;
    }

    public Long getDiasFaltantes() {
        return diasFaltantes;
    }

    public void setDiasFaltantes(Long diasFaltantes) {
        this.diasFaltantes = diasFaltantes;
    }

    public Long getDiasExtras() {
        return diasExtras;
    }

    public void setDiasExtras(Long diasExtras) {
        this.diasExtras = diasExtras;
    }

    public LocalDate getFechaProxMtto() {
        return fechaProxMtto;
    }

    public void setFechaProxMtto(LocalDate fechaProxMtto) {
        this.fechaProxMtto = fechaProxMtto;
    }

    public LocalDate getNuevaFechaMtto() {
        return nuevaFechaMtto;
    }

    public void setNuevaFechaMtto(LocalDate nuevaFechaMtto) {
        this.nuevaFechaMtto = nuevaFechaMtto;
    }

    public LocalDate getFechaFinMtto() {
        return fechaFinMtto;
    }

    public void setFechaFinMtto(LocalDate fechaFinMtto) {
        this.fechaFinMtto = fechaFinMtto;
    }
}
