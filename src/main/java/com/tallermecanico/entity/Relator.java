package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "relatores")
public class Relator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private String relator;

    // Constructors
    public Relator() {
    }

    public Relator(String relator) {
        this.relator = relator;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelator() {
        return relator;
    }

    public void setRelator(String relator) {
        this.relator = relator;
    }
}
