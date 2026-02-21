package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "costos_sm")
public class CostoSM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pauta_sm", length = 15)
    private String pautaSm;

    @Column(name = "modelo", length = 50)
    private String modelo;

    @Column(name = "nro_ot_manager", length = 50)
    private String nroOtManager;

    @Column(name = "producto", length = 150)
    private String producto;

    @Column(name = "cantidad")
    private Long cantidad;

    @Column(name = "valor_promedio")
    private Long valorPromedio;

    @Column(name = "horas_hombre")
    private Long horasHombre;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    // Constructors
    public CostoSM() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPautaSm() {
        return pautaSm;
    }

    public void setPautaSm(String pautaSm) {
        this.pautaSm = pautaSm;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNroOtManager() {
        return nroOtManager;
    }

    public void setNroOtManager(String nroOtManager) {
        this.nroOtManager = nroOtManager;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getValorPromedio() {
        return valorPromedio;
    }

    public void setValorPromedio(Long valorPromedio) {
        this.valorPromedio = valorPromedio;
    }

    public Long getHorasHombre() {
        return horasHombre;
    }

    public void setHorasHombre(Long horasHombre) {
        this.horasHombre = horasHombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
