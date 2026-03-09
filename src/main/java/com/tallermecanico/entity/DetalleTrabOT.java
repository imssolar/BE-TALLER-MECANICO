package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_trab_ot")
public class DetalleTrabOT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_trabajo")
    private OrdenTrabajo ordenTrabajo;

    @Column(name = "trabajo", length = 60)
    private String trabajo;

    @Column(name = "tipo")
    private Short tipo;

    // Constructors
    public DetalleTrabOT() {
    }

    public DetalleTrabOT(Integer id, OrdenTrabajo ordenTrabajo, String trabajo, Short tipo) {
        this.id = id;
        this.ordenTrabajo = ordenTrabajo;
        this.trabajo = trabajo;
        this.tipo = tipo;
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

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }
}
