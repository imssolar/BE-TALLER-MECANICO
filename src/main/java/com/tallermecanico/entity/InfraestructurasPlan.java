package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "infraestructuras_plan")
public class InfraestructurasPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_infra")
    private InfraHerraPatron infraHerraPatron;

    @Column(name = "tipo", length = 15)
    private String tipo;

    @Column(name = "fecha_revision")
    private LocalDate fechaRevision;

    @Column(name = "estado", length = 15)
    private String estado;

    @Column(name = "observaciones", length = 250)
    private String observaciones;

    @Column(name = "tec_responsable", length = 50)
    private String tecResponsable;

    // Constructors
    public InfraestructurasPlan() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
}
