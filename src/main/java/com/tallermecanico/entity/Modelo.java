package com.tallermecanico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "modelos")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private Integer id;

    @Column(length = 100, nullable = false, unique = true)
    private String modelo;

    @Column(name = "km_diario", precision = 10, scale = 2)
    private BigDecimal kmDiario;

    @Column(name = "obs", length = 255)
    private String observaciones;

    @JsonIgnore
    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bus> buses;

    // Constructors
    public Modelo() {
    }

    public Modelo(String modelo, BigDecimal kmDiario, String observaciones) {
        this.modelo = modelo;
        this.kmDiario = kmDiario;
        this.observaciones = observaciones;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getKmDiario() {
        return kmDiario;
    }

    public void setKmDiario(BigDecimal kmDiario) {
        this.kmDiario = kmDiario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}
