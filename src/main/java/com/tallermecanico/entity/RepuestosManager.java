package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "repuestos_manager")
public class RepuestosManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "id_repuesto", length = 15)
    private String idRepuesto;

    @Column(name = "repuesto", length = 50)
    private String repuesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_glosa")
    private Glosa glosa;

    @Column(name = "cantidad", precision = 18, scale = 2)
    private BigDecimal cantidad;

    @Column(name = "costo", precision = 18, scale = 2)
    private BigDecimal costo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terminal")
    private Terminal terminal;

    // Constructors
    public RepuestosManager() {
    }

    public RepuestosManager(Integer id, LocalDate fecha, String idRepuesto, String repuesto,
                            Glosa glosa, BigDecimal cantidad, BigDecimal costo, Terminal terminal) {
        this.id = id;
        this.fecha = fecha;
        this.idRepuesto = idRepuesto;
        this.repuesto = repuesto;
        this.glosa = glosa;
        this.cantidad = cantidad;
        this.costo = costo;
        this.terminal = terminal;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Glosa getGlosa() {
        return glosa;
    }

    public void setGlosa(Glosa glosa) {
        this.glosa = glosa;
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

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}
