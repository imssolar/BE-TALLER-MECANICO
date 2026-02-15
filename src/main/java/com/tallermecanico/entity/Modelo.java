package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "modelos")
public class Modelo {

    @Id
    @Column(name = "id_modelo")
    private Integer idModelo;

    @Column(length = 15)
    private String modelo;

    @Column(name = "km_diario", precision = 18, scale = 0)
    private BigDecimal kmDiario;

    @Column(length = 35)
    private String obs;

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bus> buses;

    // Constructors
    public Modelo() {
    }

    public Modelo(Integer idModelo, String modelo, BigDecimal kmDiario, String obs) {
        this.idModelo = idModelo;
        this.modelo = modelo;
        this.kmDiario = kmDiario;
        this.obs = obs;
    }

    // Getters and Setters
    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}
