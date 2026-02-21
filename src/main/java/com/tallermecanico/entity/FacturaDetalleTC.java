package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "factura_detalle_tc")
public class FacturaDetalleTC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura", nullable = false)
    private FacturaTC factura;

    @Column(name = "id_repuesto", length = 10)
    private String idRepuesto;

    @Column(length = 80)
    private String repuesto;

    @Column(precision = 18, scale = 2)
    private BigDecimal cantidad;

    @Column(precision = 18, scale = 0)
    private BigDecimal precio;

    // Constructors
    public FacturaDetalleTC() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FacturaTC getFactura() {
        return factura;
    }

    public void setFactura(FacturaTC factura) {
        this.factura = factura;
    }

    public String getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(String idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
