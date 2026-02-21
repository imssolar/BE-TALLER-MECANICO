package com.tallermecanico.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "facturas_mant")
public class FacturaMant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @Column(name = "numero_factura")
    private Long numeroFactura;

    private LocalDate fecha;

    @Column(length = 15)
    private String modelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_glosa")
    private Glosa glosa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taller_externo")
    private TallerExterno tallerExterno;

    // Constructors
    public FacturaMant() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Glosa getGlosa() {
        return glosa;
    }

    public void setGlosa(Glosa glosa) {
        this.glosa = glosa;
    }

    public TallerExterno getTallerExterno() {
        return tallerExterno;
    }

    public void setTallerExterno(TallerExterno tallerExterno) {
        this.tallerExterno = tallerExterno;
    }
}
