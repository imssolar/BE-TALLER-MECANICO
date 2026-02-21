package com.tallermecanico.dto.request;

import java.time.LocalDate;

public class UpdatePlanMantenimientoMovilDto {

    private Integer idMantencion;

    private Long nroMovil;

    private Long periodo;

    private Long kmMantencion;

    private LocalDate fechaMantencion;

    private Long kmRealizada;

    private Boolean realizada;

    private Long nroOtp;

    // Constructors
    public UpdatePlanMantenimientoMovilDto() {
    }

    // Getters and Setters
    public Integer getIdMantencion() {
        return idMantencion;
    }

    public void setIdMantencion(Integer idMantencion) {
        this.idMantencion = idMantencion;
    }

    public Long getNroMovil() {
        return nroMovil;
    }

    public void setNroMovil(Long nroMovil) {
        this.nroMovil = nroMovil;
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

    public LocalDate getFechaMantencion() {
        return fechaMantencion;
    }

    public void setFechaMantencion(LocalDate fechaMantencion) {
        this.fechaMantencion = fechaMantencion;
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

    public Long getNroOtp() {
        return nroOtp;
    }

    public void setNroOtp(Long nroOtp) {
        this.nroOtp = nroOtp;
    }
}
