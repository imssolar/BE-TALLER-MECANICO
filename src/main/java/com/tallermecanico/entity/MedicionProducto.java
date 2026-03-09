package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicion_productos")
public class MedicionProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "producto", length = 50, nullable = false, unique = true)
    private String producto;

    // Constructors
    public MedicionProducto() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
