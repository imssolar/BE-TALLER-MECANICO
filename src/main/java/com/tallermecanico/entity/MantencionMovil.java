package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mantenciones_movil")
public class MantencionMovil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item", length = 30, nullable = false, unique = true)
    private String item;

    @Column(name = "km")
    private Integer km;

    // Constructors
    public MantencionMovil() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }
}
