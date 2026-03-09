package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item_mantencion_n", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_modelo", "descripcion"})
})
public class ItemMantencionN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    @Column(name = "descripcion", length = 65, nullable = false)
    private String descripcion;

    @Column(name = "periodo")
    private Integer periodo;

    // Constructors
    public ItemMantencionN() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
