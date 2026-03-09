package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "repuestos_proyectados")
public class RepuestosProyectados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "id_repuesto", length = 15)
    private String idRepuesto;

    @Column(name = "repuesto", length = 50)
    private String repuesto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "unitario")
    private Integer unitario;

    @Column(name = "total")
    private Integer total;

    // Constructors
    public RepuestosProyectados() {
    }

    public RepuestosProyectados(Integer id, LocalDate fecha, String idRepuesto, String repuesto,
                                Integer cantidad, Integer unitario, Integer total) {
        this.id = id;
        this.fecha = fecha;
        this.idRepuesto = idRepuesto;
        this.repuesto = repuesto;
        this.cantidad = cantidad;
        this.unitario = unitario;
        this.total = total;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getUnitario() {
        return unitario;
    }

    public void setUnitario(Integer unitario) {
        this.unitario = unitario;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
