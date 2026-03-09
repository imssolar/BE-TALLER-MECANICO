package com.tallermecanico.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_ott_carroceria")
public class DetalleOTTCarroceria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ot_carroceria")
    private OTCarroceria otCarroceria;

    @Column(name = "codigo", length = 8)
    private String codigo;

    @Column(name = "insumo_repuesto", length = 80)
    private String insumoRepuesto;

    @Column(name = "unidad", length = 15)
    private String unidad;

    @Column(name = "cantidad", precision = 18, scale = 2)
    private BigDecimal cantidad;

    @Column(name = "valor", precision = 18, scale = 0)
    private BigDecimal valor;

    @Column(name = "area", length = 15)
    private String area;

    // Constructors
    public DetalleOTTCarroceria() {
    }

    public DetalleOTTCarroceria(Integer id, OTCarroceria otCarroceria, String codigo, String insumoRepuesto,
                                 String unidad, BigDecimal cantidad, BigDecimal valor, String area) {
        this.id = id;
        this.otCarroceria = otCarroceria;
        this.codigo = codigo;
        this.insumoRepuesto = insumoRepuesto;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.valor = valor;
        this.area = area;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OTCarroceria getOtCarroceria() {
        return otCarroceria;
    }

    public void setOtCarroceria(OTCarroceria otCarroceria) {
        this.otCarroceria = otCarroceria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getInsumoRepuesto() {
        return insumoRepuesto;
    }

    public void setInsumoRepuesto(String insumoRepuesto) {
        this.insumoRepuesto = insumoRepuesto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
