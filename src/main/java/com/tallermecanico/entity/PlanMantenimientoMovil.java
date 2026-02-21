package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plan_mantenimiento_movil")
public class PlanMantenimientoMovil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_mantencion")
    private Integer idMantencion;

    @Column(name = "nro_movil")
    private Long nroMovil;

    @Column(name = "periodo")
    private Long periodo;

    @Column(name = "km_mantencion")
    private Long kmMantencion;

    @Column(name = "fecha_mantencion")
    private LocalDate fechaMantencion;

    @Column(name = "km_realizada")
    private Long kmRealizada;

    @Column(name = "realizada")
    private Boolean realizada;

    @Column(name = "nro_otp")
    private Long nroOtp;

    // Constructors
    public PlanMantenimientoMovil() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
