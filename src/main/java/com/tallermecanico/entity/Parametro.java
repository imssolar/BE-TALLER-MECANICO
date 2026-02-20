package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "parametros")
public class Parametro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion", length = 50, nullable = false, unique = true)
    private String descripcion;

    @Column(name = "valor", precision = 18, scale = 0)
    private BigDecimal valor;

    // Constructors
    public Parametro() {
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
