package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "plan_mantenimiento_bus")
public class PlanMantenimientoBus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus")
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mantencion")
    private Mantencion mantencion;

    @Column(name = "id_item", length = 15)
    private String idItem;

    @Column(name = "periodo")
    private Long periodo;

    @Column(name = "km_mantencion")
    private Long kmMantencion;

    @Column(name = "fecha_hora_mantencion")
    private LocalDateTime fechaHoraMantencion;

    @Column(name = "km_realizada")
    private Long kmRealizada;

    @Column(name = "realizada")
    private Boolean realizada;

    @Column(name = "id_otp")
    private Long idOtp;

    @Column(name = "litros", precision = 18, scale = 2)
    private BigDecimal litros;

    @Column(name = "accion_ok")
    private Boolean accionOk;

    @Column(name = "rrhh")
    private Long rrhh;

    @Column(name = "dias_faltantes")
    private Long diasFaltantes;

    @Column(name = "dias_extras")
    private Long diasExtras;

    @Column(name = "fecha_prox_mtto")
    private LocalDate fechaProxMtto;

    @Column(name = "nueva_fecha_mtto")
    private LocalDate nuevaFechaMtto;

    @Column(name = "fecha_fin_mtto")
    private LocalDate fechaFinMtto;

    // Constructors
    public PlanMantenimientoBus() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Mantencion getMantencion() {
        return mantencion;
    }

    public void setMantencion(Mantencion mantencion) {
        this.mantencion = mantencion;
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
