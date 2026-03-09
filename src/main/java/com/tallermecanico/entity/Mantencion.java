package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mantenciones", uniqueConstraints = @UniqueConstraint(columnNames = {"id_item", "id_modelo"}))
public class Mantencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item", nullable = false)
    private ItemMantencion itemMantencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo", nullable = false)
    private Modelo modelo;

    @Column(name = "km", nullable = false)
    private Integer km;

    // Constructors
    public Mantencion() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemMantencion getItemMantencion() {
        return itemMantencion;
    }

    public void setItemMantencion(ItemMantencion itemMantencion) {
        this.itemMantencion = itemMantencion;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }
}
