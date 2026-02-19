package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "glosas")
public class Glosa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(length = 100, unique = true, nullable = false)
    private String glosa;

    public Glosa(Integer id, String glosa){
        this.id = id;
        this.glosa = glosa;
    }

    public Glosa(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }
}
