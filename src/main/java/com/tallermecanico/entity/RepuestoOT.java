package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "repuestos_ot")
public class RepuestoOT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_trabajo")
    private OrdenTrabajo ordenTrabajo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_trabajo_prog")
    private OrdenTrabajoProg ordenTrabajoProg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_trabajo_movil")
    private OrdenTrabajoMovil ordenTrabajoMovil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_glosa")
    private Glosa glosa;

    @Column(name = "id_repuesto", length = 15)
    private String idRepuesto;

    @Column(name = "repuesto", length = 50)
    private String repuesto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "costo")
    private Integer costo;

    // Constructors
    public RepuestoOT() {
    }

    public RepuestoOT(Integer id, OrdenTrabajo ordenTrabajo, OrdenTrabajoProg ordenTrabajoProg,
                      OrdenTrabajoMovil ordenTrabajoMovil, Glosa glosa, String idRepuesto,
                      String repuesto, Integer cantidad, Integer costo) {
        this.id = id;
        this.ordenTrabajo = ordenTrabajo;
        this.ordenTrabajoProg = ordenTrabajoProg;
        this.ordenTrabajoMovil = ordenTrabajoMovil;
        this.glosa = glosa;
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

    public OrdenTrabajoProg getOrdenTrabajoProg() {
        return ordenTrabajoProg;
    }

    public void setOrdenTrabajoProg(OrdenTrabajoProg ordenTrabajoProg) {
        this.ordenTrabajoProg = ordenTrabajoProg;
    }

    public OrdenTrabajoMovil getOrdenTrabajoMovil() {
        return ordenTrabajoMovil;
    }

    public void setOrdenTrabajoMovil(OrdenTrabajoMovil ordenTrabajoMovil) {
        this.ordenTrabajoMovil = ordenTrabajoMovil;
    }

    public Glosa getGlosa() {
        return glosa;
    }

    public void setGlosa(Glosa glosa) {
        this.glosa = glosa;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
}
