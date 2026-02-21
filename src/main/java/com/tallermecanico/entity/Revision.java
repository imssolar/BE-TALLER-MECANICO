package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "revisiones")
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_revisiones")
    private PlanRevisiones planRevisiones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus")
    private Bus bus;

    @Column(name = "fecha_revision")
    private LocalDate fechaRevision;

    @Column(name = "km")
    private Long km;

    @Column(name = "tipo", length = 10)
    private String tipo;

    @Column(name = "fecha_control")
    private LocalDate fechaControl;

    @Column(name = "estado", length = 10)
    private String estado;

    @Column(name = "instancia", length = 10)
    private String instancia;

    @Column(name = "observaciones", length = 50)
    private String observaciones;

    // Constructors
    public Revision() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlanRevisiones getPlanRevisiones() {
        return planRevisiones;
    }

    public void setPlanRevisiones(PlanRevisiones planRevisiones) {
        this.planRevisiones = planRevisiones;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public Long getKm() {
        return km;
    }

    public void setKm(Long km) {
        this.km = km;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaControl() {
        return fechaControl;
    }

    public void setFechaControl(LocalDate fechaControl) {
        this.fechaControl = fechaControl;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
