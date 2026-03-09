package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "otros_repuestos")
public class OtrosRepuestos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_trabajo")
    private OrdenTrabajo ordenTrabajo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_glosa")
    private Glosa glosa;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "id_repuesto", length = 15)
    private String idRepuesto;

    @Column(name = "repuesto", length = 50)
    private String repuesto;

    @Column(name = "cantidad", precision = 18, scale = 2)
    private BigDecimal cantidad;

    @Column(name = "costo", precision = 18, scale = 2)
    private BigDecimal costo;

    // Constructors
    public OtrosRepuestos() {
    }

    public OtrosRepuestos(Integer id, OrdenTrabajo ordenTrabajo, Glosa glosa, LocalDate fecha,
                          String idRepuesto, String repuesto, BigDecimal cantidad, BigDecimal costo) {
        this.id = id;
        this.ordenTrabajo = ordenTrabajo;
        this.glosa = glosa;
        this.fecha = fecha;
        this.idRepuesto = idRepuesto;
        this.repuesto = repuesto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public Glosa getGlosa() {
        return glosa;
    }

    public void setGlosa(Glosa glosa) {
        this.glosa = glosa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
}
