package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "detalle_eh")
public class DetalleEH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rut", length = 13)
    private String rut;

    @Column(name = "tipo_entrega", length = 20)
    private String tipoEntrega;

    @Column(name = "equip_herram", length = 50)
    private String equipHerram;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "entregado_por", length = 30)
    private String entregadoPor;

    @Column(name = "cantidad")
    private Short cantidad;

    @Column(name = "costo")
    private Integer costo;

    @Column(name = "devuelto")
    private Boolean devuelto;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @Column(name = "cant_devuelta")
    private Integer cantDevuelta;

    @Column(name = "pendiente")
    private Integer pendiente;

    @Column(name = "prox_cambio", length = 10)
    private String proxCambio;

    @Column(name = "tipo_dev", length = 20)
    private String tipoDev;

    // Constructors
    public DetalleEH() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public String getEquipHerram() {
        return equipHerram;
    }

    public void setEquipHerram(String equipHerram) {
        this.equipHerram = equipHerram;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEntregadoPor() {
        return entregadoPor;
    }

    public void setEntregadoPor(String entregadoPor) {
        this.entregadoPor = entregadoPor;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getCantDevuelta() {
        return cantDevuelta;
    }

    public void setCantDevuelta(Integer cantDevuelta) {
        this.cantDevuelta = cantDevuelta;
    }

    public Integer getPendiente() {
        return pendiente;
    }

    public void setPendiente(Integer pendiente) {
        this.pendiente = pendiente;
    }

    public String getProxCambio() {
        return proxCambio;
    }

    public void setProxCambio(String proxCambio) {
        this.proxCambio = proxCambio;
    }

    public String getTipoDev() {
        return tipoDev;
    }

    public void setTipoDev(String tipoDev) {
        this.tipoDev = tipoDev;
    }
}
