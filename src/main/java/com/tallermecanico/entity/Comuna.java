package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comunas")
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private String comuna;

    // Constructors
    public Comuna() {
    }

    public Comuna(String comuna) {
        this.comuna = comuna;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
}
