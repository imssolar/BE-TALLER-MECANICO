package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ot_carroceria")
public class OTCarroceria {

    @Id
    @Column(name = "id_ottc")
    private Integer id;

    @Column(name = "tipo_ottc", length = 15)
    private String tipoOttc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terminal")
    private Terminal terminal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus")
    private Bus bus;

    @Column
    private Integer km;

    @Column(length = 7)
    private String ppu;

    @Column(name = "fecha_hora_ingreso")
    private LocalDateTime fechaHoraIngreso;

    @Column(name = "fecha_hora_salida")
    private LocalDateTime fechaHoraSalida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gravedad_carroceria")
    private GravedadCarroceria gravedadCarroceria;

    @Column(name = "detalle_carroceria", length = 200)
    private String detalleCarroceria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gravedad_pintura")
    private GravedadPintura gravedadPintura;

    @Column(name = "detalle_pintura", length = 200)
    private String detallePintura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gravedad_fibra")
    private GravedadFibra gravedadFibra;

    @Column(name = "detalle_fibra", length = 200)
    private String detalleFibra;

    // Constructors
    public OTCarroceria() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoOttc() {
        return tipoOttc;
    }

    public void setTipoOttc(String tipoOttc) {
        this.tipoOttc = tipoOttc;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
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

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public GravedadCarroceria getGravedadCarroceria() {
        return gravedadCarroceria;
    }

    public void setGravedadCarroceria(GravedadCarroceria gravedadCarroceria) {
        this.gravedadCarroceria = gravedadCarroceria;
    }

    public String getDetalleCarroceria() {
        return detalleCarroceria;
    }

    public void setDetalleCarroceria(String detalleCarroceria) {
        this.detalleCarroceria = detalleCarroceria;
    }

    public GravedadPintura getGravedadPintura() {
        return gravedadPintura;
    }

    public void setGravedadPintura(GravedadPintura gravedadPintura) {
        this.gravedadPintura = gravedadPintura;
    }

    public String getDetallePintura() {
        return detallePintura;
    }

    public void setDetallePintura(String detallePintura) {
        this.detallePintura = detallePintura;
    }

    public GravedadFibra getGravedadFibra() {
        return gravedadFibra;
    }

    public void setGravedadFibra(GravedadFibra gravedadFibra) {
        this.gravedadFibra = gravedadFibra;
    }

    public String getDetalleFibra() {
        return detalleFibra;
    }

    public void setDetalleFibra(String detalleFibra) {
        this.detalleFibra = detalleFibra;
    }
}
