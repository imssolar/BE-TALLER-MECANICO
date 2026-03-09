package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movimiento_bodega")
public class MovimientoBodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "movimiento", length = 15, nullable = false)
    private String movimiento;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_repuesto", nullable = false)
    private Repuesto repuesto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "stock_actual")
    private Integer stockActual;

    @Column(name = "nuevo_stock")
    private Integer nuevoStock;

    // Constructors
    public MovimientoBodega() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getNuevoStock() {
        return nuevoStock;
    }

    public void setNuevoStock(Integer nuevoStock) {
        this.nuevoStock = nuevoStock;
    }
}
