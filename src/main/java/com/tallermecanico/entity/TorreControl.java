package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "torre_control")
public class TorreControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus")
    private Bus bus;

    @Column
    private Integer km;

    @Column(name = "fecha_hora_ingreso")
    private LocalDateTime fechaHoraIngreso;

    @Column(length = 50)
    private String falla;

    @Column(name = "tipo_falla", length = 50)
    private String tipoFalla;

    @Column(name = "nro_ot_manager")
    private Long nroOtManager;

    @Column(length = 50)
    private String electrico;

    @Column(name = "fecha_hora_inicio_electrico")
    private LocalDateTime fechaHoraInicioElectrico;

    @Column(name = "fecha_hora_fin_electrico")
    private LocalDateTime fechaHoraFinElectrico;

    @Column(length = 50)
    private String mecanico;

    @Column(name = "fecha_hora_inicio_mecanico")
    private LocalDateTime fechaHoraInicioMecanico;

    @Column(name = "fecha_hora_fin_mecanico")
    private LocalDateTime fechaHoraFinMecanico;

    @Column(length = 20)
    private String status;

    @Column(name = "tiempo_proyectado")
    private Integer tiempoProyectado;

    @Column(name = "tiempo_transcurrido")
    private Integer tiempoTranscurrido;

    @Column(length = 10)
    private String pnc;

    @Column(name = "nro_ingresos")
    private Integer nroIngresos;

    @Column(length = 50)
    private String observaciones;

    @Column
    private Boolean cerrado;

    @Column(name = "tipo_emergencia", length = 20)
    private String tipoEmergencia;

    // Constructors
    public TorreControl() {
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

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }

    public String getTipoFalla() {
        return tipoFalla;
    }

    public void setTipoFalla(String tipoFalla) {
        this.tipoFalla = tipoFalla;
    }

    public Long getNroOtManager() {
        return nroOtManager;
    }

    public void setNroOtManager(Long nroOtManager) {
        this.nroOtManager = nroOtManager;
    }

    public String getElectrico() {
        return electrico;
    }

    public void setElectrico(String electrico) {
        this.electrico = electrico;
    }

    public LocalDateTime getFechaHoraInicioElectrico() {
        return fechaHoraInicioElectrico;
    }

    public void setFechaHoraInicioElectrico(LocalDateTime fechaHoraInicioElectrico) {
        this.fechaHoraInicioElectrico = fechaHoraInicioElectrico;
    }

    public LocalDateTime getFechaHoraFinElectrico() {
        return fechaHoraFinElectrico;
    }

    public void setFechaHoraFinElectrico(LocalDateTime fechaHoraFinElectrico) {
        this.fechaHoraFinElectrico = fechaHoraFinElectrico;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public LocalDateTime getFechaHoraInicioMecanico() {
        return fechaHoraInicioMecanico;
    }

    public void setFechaHoraInicioMecanico(LocalDateTime fechaHoraInicioMecanico) {
        this.fechaHoraInicioMecanico = fechaHoraInicioMecanico;
    }

    public LocalDateTime getFechaHoraFinMecanico() {
        return fechaHoraFinMecanico;
    }

    public void setFechaHoraFinMecanico(LocalDateTime fechaHoraFinMecanico) {
        this.fechaHoraFinMecanico = fechaHoraFinMecanico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTiempoProyectado() {
        return tiempoProyectado;
    }

    public void setTiempoProyectado(Integer tiempoProyectado) {
        this.tiempoProyectado = tiempoProyectado;
    }

    public Integer getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public void setTiempoTranscurrido(Integer tiempoTranscurrido) {
        this.tiempoTranscurrido = tiempoTranscurrido;
    }

    public String getPnc() {
        return pnc;
    }

    public void setPnc(String pnc) {
        this.pnc = pnc;
    }

    public Integer getNroIngresos() {
        return nroIngresos;
    }

    public void setNroIngresos(Integer nroIngresos) {
        this.nroIngresos = nroIngresos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(String tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }
}
