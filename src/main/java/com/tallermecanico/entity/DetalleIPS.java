package com.tallermecanico.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_ips")
public class DetalleIPS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_trabajo_prog")
    private OrdenTrabajoProg ordenTrabajoProg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_trabajo_movil")
    private OrdenTrabajoMovil ordenTrabajoMovil;

    @Column(name = "id_ips", length = 5)
    private String idIps;

    @Column(name = "litros", precision = 8, scale = 2)
    private BigDecimal litros;

    // Constructors
    public DetalleIPS() {
    }

    public DetalleIPS(Integer id, OrdenTrabajoProg ordenTrabajoProg, OrdenTrabajoMovil ordenTrabajoMovil,
                      String idIps, BigDecimal litros) {
        this.id = id;
        this.ordenTrabajoProg = ordenTrabajoProg;
        this.ordenTrabajoMovil = ordenTrabajoMovil;
        this.idIps = idIps;
        this.litros = litros;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIdIps() {
        return idIps;
    }

    public void setIdIps(String idIps) {
        this.idIps = idIps;
    }

    public BigDecimal getLitros() {
        return litros;
    }

    public void setLitros(BigDecimal litros) {
        this.litros = litros;
    }
}
