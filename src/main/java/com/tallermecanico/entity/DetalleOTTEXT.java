package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_ott_ext")
public class DetalleOTTEXT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ot_taller_ext")
    private OTTallerExt otTallerExt;

    @Column(name = "cantidad")
    private Short cantidad;

    @Column(name = "descripcion", length = 80)
    private String descripcion;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "tipo")
    private Short tipo;

    // Constructors
    public DetalleOTTEXT() {
    }

    public DetalleOTTEXT(Integer id, OTTallerExt otTallerExt, Short cantidad, String descripcion, Integer precio, Short tipo) {
        this.id = id;
        this.otTallerExt = otTallerExt;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OTTallerExt getOtTallerExt() {
        return otTallerExt;
    }

    public void setOtTallerExt(OTTallerExt otTallerExt) {
        this.otTallerExt = otTallerExt;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }
}
