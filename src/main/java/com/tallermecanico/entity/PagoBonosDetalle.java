package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pago_bonos_detalle")
public class PagoBonosDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago_bonos")
    private PagoBonos pagoBonos;

    @Column(name = "rut", length = 12)
    private String rut;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "cargo", length = 50)
    private String cargo;

    @Column(name = "terminal", length = 50)
    private String terminalNombre;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora_inicio", length = 10)
    private String horaInicio;

    @Column(name = "hora_fin", length = 10)
    private String horaFin;

    @Column(name = "monto")
    private Integer monto;

    @Column(name = "servicio", length = 50)
    private String servicio;

    @Column(name = "autoriza", length = 50)
    private String autoriza;

    @Column(name = "area", length = 50)
    private String area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus")
    private Bus bus;

    // Constructors
    public PagoBonosDetalle() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PagoBonos getPagoBonos() {
        return pagoBonos;
    }

    public void setPagoBonos(PagoBonos pagoBonos) {
        this.pagoBonos = pagoBonos;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTerminalNombre() {
        return terminalNombre;
    }

    public void setTerminalNombre(String terminalNombre) {
        this.terminalNombre = terminalNombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
