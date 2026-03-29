package com.tallermecanico.entity;

import com.tallermecanico.entity.Empleado;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ot_taller_ext")
public class OTTallerExt {

    @Id
    @Column(name = "id_otte")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus")
    private Bus bus;

    @Column
    private Integer km;

    @Column(length = 8)
    private String ppu;

    @Column(length = 50)
    private String proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conductor")
    private Empleado conductor;

    @Column(length = 50)
    private String recorrido;

    @Column
    private LocalDate fecha;

    @Column(name = "recibe_taller", length = 30)
    private String recibeTaller;

    @Column(name = "hora_llegada")
    private LocalDateTime horaLlegada;

    @Column(name = "hora_salida")
    private LocalDateTime horaSalida;

    @Column(length = 150)
    private String diagnostico;

    @Column(name = "nombre_preparador", length = 50)
    private String nombrePreparador;

    @Column(name = "hora_preparador")
    private LocalDateTime horaPreparador;

    @Column(name = "nombre_revisor", length = 50)
    private String nombreRevisor;

    @Column(name = "hora_revisor")
    private LocalDateTime horaRevisor;

    @Column(name = "nombre_ejecutor", length = 50)
    private String nombreEjecutor;

    @Column(name = "hora_ejecutor")
    private LocalDateTime horaEjecutor;

    @Column
    private Integer total;

    @Column(length = 30)
    private String incidencias;

    @Column(length = 50)
    private String sistema;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    // Constructors
    public OTTallerExt() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public String getPpu() {
        return ppu;
    }

    public void setPpu(String ppu) {
        this.ppu = ppu;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Empleado getConductor() {
        return conductor;
    }

    public void setConductor(Empleado conductor) {
        this.conductor = conductor;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getRecibeTaller() {
        return recibeTaller;
    }

    public void setRecibeTaller(String recibeTaller) {
        this.recibeTaller = recibeTaller;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getNombrePreparador() {
        return nombrePreparador;
    }

    public void setNombrePreparador(String nombrePreparador) {
        this.nombrePreparador = nombrePreparador;
    }

    public LocalDateTime getHoraPreparador() {
        return horaPreparador;
    }

    public void setHoraPreparador(LocalDateTime horaPreparador) {
        this.horaPreparador = horaPreparador;
    }

    public String getNombreRevisor() {
        return nombreRevisor;
    }

    public void setNombreRevisor(String nombreRevisor) {
        this.nombreRevisor = nombreRevisor;
    }

    public LocalDateTime getHoraRevisor() {
        return horaRevisor;
    }

    public void setHoraRevisor(LocalDateTime horaRevisor) {
        this.horaRevisor = horaRevisor;
    }

    public String getNombreEjecutor() {
        return nombreEjecutor;
    }

    public void setNombreEjecutor(String nombreEjecutor) {
        this.nombreEjecutor = nombreEjecutor;
    }

    public LocalDateTime getHoraEjecutor() {
        return horaEjecutor;
    }

    public void setHoraEjecutor(LocalDateTime horaEjecutor) {
        this.horaEjecutor = horaEjecutor;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
