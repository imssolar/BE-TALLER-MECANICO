package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_mtt_ot")
public class DetalleMTTOT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_trabajo")
    private OrdenTrabajo ordenTrabajo;

    @Column(name = "id_mtt", length = 4)
    private String idMtt;

    @Column(name = "litros_mtt", precision = 8, scale = 2)
    private BigDecimal litrosMtt;

    // Constructors
    public DetalleMTTOT() {
    }

    public DetalleMTTOT(Integer id, OrdenTrabajo ordenTrabajo, String idMtt, BigDecimal litrosMtt) {
        this.id = id;
        this.ordenTrabajo = ordenTrabajo;
        this.idMtt = idMtt;
        this.litrosMtt = litrosMtt;
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

    public String getIdMtt() {
        return idMtt;
    }

    public void setIdMtt(String idMtt) {
        this.idMtt = idMtt;
    }

    public BigDecimal getLitrosMtt() {
        return litrosMtt;
    }

    public void setLitrosMtt(BigDecimal litrosMtt) {
        this.litrosMtt = litrosMtt;
    }
}
