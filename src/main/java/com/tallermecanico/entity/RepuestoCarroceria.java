package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "repuestos_carroceria")
public class RepuestoCarroceria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "repuesto", length = 80, nullable = false, unique = true)
    private String repuesto;

    @Column(name = "stock", precision = 18, scale = 2)
    private BigDecimal stock;

    @Column(name = "unidad", length = 15)
    private String unidad;

    @Column(name = "valor", precision = 18, scale = 0)
    private BigDecimal valor;

    @Column(name = "grupo", length = 15)
    private String grupo;

    // Constructors
    public RepuestoCarroceria() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
