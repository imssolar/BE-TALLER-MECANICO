package com.tallermecanico.entity;

import com.tallermecanico.enums.TipoEntrega;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "detalle_entregas")
public class DetalleEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_entrega", length = 20)
    private TipoEntrega tipoEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipamiento")
    private Equipamiento equipamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_herramienta")
    private Herramienta herramienta;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entregado_por")
    private Empleado entregadoPor;

    @Column(name = "cantidad")
    private Short cantidad;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(name = "devuelto")
    private Boolean devuelto;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @Column(name = "cantidad_devuelta")
    private Integer cantidadDevuelta;

    @Column(name = "pendiente")
    private Integer pendiente;

    @Column(name = "proximo_cambio", length = 10)
    private String proximoCambio;

    @Column(name = "tipo_devolucion", length = 20)
    private String tipoDevolucion;

    // Constructors
    public DetalleEntrega() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Equipamiento getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(Equipamiento equipamiento) {
        this.equipamiento = equipamiento;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Empleado getEntregadoPor() {
        return entregadoPor;
    }

    public void setEntregadoPor(Empleado entregadoPor) {
        this.entregadoPor = entregadoPor;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
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

    public Integer getCantidadDevuelta() {
        return cantidadDevuelta;
    }

    public void setCantidadDevuelta(Integer cantidadDevuelta) {
        this.cantidadDevuelta = cantidadDevuelta;
    }

    public Integer getPendiente() {
        return pendiente;
    }

    public void setPendiente(Integer pendiente) {
        this.pendiente = pendiente;
    }

    public String getProximoCambio() {
        return proximoCambio;
    }

    public void setProximoCambio(String proximoCambio) {
        this.proximoCambio = proximoCambio;
    }

    public String getTipoDevolucion() {
        return tipoDevolucion;
    }

    public void setTipoDevolucion(String tipoDevolucion) {
        this.tipoDevolucion = tipoDevolucion;
    }
}
