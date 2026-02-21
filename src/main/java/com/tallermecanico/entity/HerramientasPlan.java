package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "herramientas_plan")
public class HerramientasPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_herramienta")
    private InfraHerraPatron infraHerraPatron;

    @Column(name = "patron", length = 25)
    private String patron;

    @Column(name = "fecha_revision")
    private LocalDate fechaRevision;

    @Column(name = "estado_mantencion", length = 15)
    private String estadoMantencion;

    @Column(name = "patron1", length = 25)
    private String patron1;

    @Column(name = "herramienta1", length = 25)
    private String herramienta1;

    @Column(name = "patron2", length = 25)
    private String patron2;

    @Column(name = "herramienta2", length = 25)
    private String herramienta2;

    @Column(name = "patron3", length = 25)
    private String patron3;

    @Column(name = "herramienta3", length = 25)
    private String herramienta3;

    @Column(name = "observaciones", length = 250)
    private String observaciones;

    @Column(name = "tec_responsable", length = 50)
    private String tecResponsable;

    @Column(name = "estado_herramienta")
    private Boolean estadoHerramienta;

    // Constructors
    public HerramientasPlan() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InfraHerraPatron getInfraHerraPatron() {
        return infraHerraPatron;
    }

    public void setInfraHerraPatron(InfraHerraPatron infraHerraPatron) {
        this.infraHerraPatron = infraHerraPatron;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getEstadoMantencion() {
        return estadoMantencion;
    }

    public void setEstadoMantencion(String estadoMantencion) {
        this.estadoMantencion = estadoMantencion;
    }

    public String getPatron1() {
        return patron1;
    }

    public void setPatron1(String patron1) {
        this.patron1 = patron1;
    }

    public String getHerramienta1() {
        return herramienta1;
    }

    public void setHerramienta1(String herramienta1) {
        this.herramienta1 = herramienta1;
    }

    public String getPatron2() {
        return patron2;
    }

    public void setPatron2(String patron2) {
        this.patron2 = patron2;
    }

    public String getHerramienta2() {
        return herramienta2;
    }

    public void setHerramienta2(String herramienta2) {
        this.herramienta2 = herramienta2;
    }

    public String getPatron3() {
        return patron3;
    }

    public void setPatron3(String patron3) {
        this.patron3 = patron3;
    }

    public String getHerramienta3() {
        return herramienta3;
    }

    public void setHerramienta3(String herramienta3) {
        this.herramienta3 = herramienta3;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTecResponsable() {
        return tecResponsable;
    }

    public void setTecResponsable(String tecResponsable) {
        this.tecResponsable = tecResponsable;
    }

    public Boolean getEstadoHerramienta() {
        return estadoHerramienta;
    }

    public void setEstadoHerramienta(Boolean estadoHerramienta) {
        this.estadoHerramienta = estadoHerramienta;
    }
}
