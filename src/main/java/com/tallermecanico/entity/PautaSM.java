package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pautas_sm")
public class PautaSM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pauta", length = 10, nullable = false, unique = true)
    private String pauta;

    // Constructors
    public PautaSM() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }
}
