package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item_mantencion")
public class ItemMantencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion", length = 65, nullable = false, unique = true)
    private String descripcion;

    @Column(name = "orden_gantt")
    private Integer ordenGantt;

    // Constructors
    public ItemMantencion() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrdenGantt() {
        return ordenGantt;
    }

    public void setOrdenGantt(Integer ordenGantt) {
        this.ordenGantt = ordenGantt;
    }
}
