package com.tallermecanico.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "moviles")
public class Movil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "patente", length = 7, unique = true, nullable = false)
    private String patente;

    @Column(name = "marca", length = 50)
    private String marca;

    @Column(name = "modelo", length = 50)
    private String modelo;

    @Column(name = "responsable", length = 50)
    private String responsable;

    @Column(name = "ano_fabricacion")
    private Integer anoFabricacion;

    @Column(name = "operativa")
    private Boolean operativa = true;

    @Column(name = "km")
    private Integer km;

    @Column(name = "fecha_revision_tecnica")
    private LocalDate fechaRevisionTecnica;

    @Column(name = "fecha_revision_gases")
    private LocalDate fechaRevisionGases;

    // Constructors
    public Movil() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Integer getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(Integer anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public Boolean getOperativa() {
        return operativa;
    }

    public void setOperativa(Boolean operativa) {
        this.operativa = operativa;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public LocalDate getFechaRevisionTecnica() {
        return fechaRevisionTecnica;
    }

    public void setFechaRevisionTecnica(LocalDate fechaRevisionTecnica) {
        this.fechaRevisionTecnica = fechaRevisionTecnica;
    }

    public LocalDate getFechaRevisionGases() {
        return fechaRevisionGases;
    }

    public void setFechaRevisionGases(LocalDate fechaRevisionGases) {
        this.fechaRevisionGases = fechaRevisionGases;
    }
}
