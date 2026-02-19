package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trabajos_mecanico")
public class TrabajosMec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false, unique = true)
    private String trabajoMec;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_glosa", nullable = false)
    private Glosa glosa;

    public TrabajosMec(Integer id, String trabajoMec, Glosa glosa){
        this.id = id;
        this.glosa = glosa;
        this.trabajoMec = trabajoMec;
    }

    public TrabajosMec(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrabajoMec() {
        return trabajoMec;
    }

    public void setTrabajoMec(String trabajoMec) {
        this.trabajoMec = trabajoMec;
    }

    public Glosa getGlosa() {
        return glosa;
    }

    public void setGlosa(Glosa glosa) {
        this.glosa = glosa;
    }
}
